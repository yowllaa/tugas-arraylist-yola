import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Membuat object Bank
        Bank bank = new Bank();

        bank.addCustomer("Andi", "Saputra");
        bank.addCustomer("Budi", "Santoso");
        bank.addCustomer("Citra", "Lestari");

        // Customer pertama
        Customer customer1 = bank.getCustomer(0);
        customer1.setAccount(new Account(1000000));
        customer1.setAccount(new Account(500000));

        // Customer kedua
        Customer customer2 = bank.getCustomer(1);
        customer2.setAccount(new Account(2000000));

        // Customer ketiga
        Customer customer3 = bank.getCustomer(2);
        customer3.setAccount(new Account(1500000));

        int pilihan;

        do {

            System.out.println("\n================================");
            System.out.println("          SISTEM BANK");
            System.out.println("================================");
            System.out.println("1. Lihat Daftar Customer");
            System.out.println("2. Tambah Customer");
            System.out.println("3. Lihat Account Customer");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Cek Saldo");
            System.out.println("0. Keluar");
            System.out.println("================================");
            System.out.print("Pilih menu : ");

            pilihan = input.nextInt();

            switch (pilihan) {

                case 1:

                    System.out.println("\n=== DAFTAR CUSTOMER ===");

                    for (int i = 0;
                         i < bank.getNumOfCustomers();
                         i++) {

                        Customer customer =
                                bank.getCustomer(i);

                        System.out.println(
                                (i + 1) + ". "
                                + customer.getFirstName()
                                + " "
                                + customer.getLastName()
                        );
                    }

                    break;


                case 2:

                    input.nextLine();

                    System.out.print("Nama depan   : ");
                    String firstName = input.nextLine();

                    System.out.print("Nama belakang: ");
                    String lastName = input.nextLine();

                    bank.addCustomer(firstName, lastName);

                    System.out.println(
                            "Customer berhasil ditambahkan."
                    );

                    break;

                case 3:

                    tampilkanCustomer(bank);

                    System.out.print(
                            "\nPilih nomor customer : "
                    );

                    int pilihCustomer = input.nextInt() - 1;

                    if (pilihCustomer >= 0 &&
                        pilihCustomer < bank.getNumOfCustomers()) {

                        Customer customer =
                                bank.getCustomer(pilihCustomer);

                        System.out.println(
                                "\nCustomer : "
                                + customer.getFirstName()
                                + " "
                                + customer.getLastName()
                        );

                        if (customer.getNumOfAccounts() == 0) {

                            System.out.println(
                                    "Customer belum memiliki account."
                            );

                            System.out.print(
                                    "Masukkan saldo awal account: Rp"
                            );

                            double saldoAwal =
                                    input.nextDouble();

                            customer.setAccount(
                                    new Account(saldoAwal)
                            );

                            System.out.println(
                                    "Account berhasil dibuat."
                            );

                        } else {

                            tampilkanAccount(customer);
                        }

                    } else {

                        System.out.println(
                                "Customer tidak ditemukan."
                        );
                    }

                    break;

                case 4:

                    Customer customerDeposit =
                            pilihCustomer(bank, input);

                    if (customerDeposit != null) {

                        Account accountDeposit =
                                pilihAccount(
                                        customerDeposit,
                                        input
                                );

                        if (accountDeposit != null) {

                            System.out.print(
                                    "Jumlah deposit : Rp"
                            );

                            double deposit =
                                    input.nextDouble();

                            boolean berhasil =
                                    accountDeposit.deposit(
                                            deposit
                                    );

                            if (berhasil) {

                                System.out.println(
                                        "Deposit berhasil."
                                );

                                System.out.println(
                                        "Saldo sekarang : Rp"
                                        + accountDeposit
                                                .getBalance()
                                );

                            } else {

                                System.out.println(
                                        "Deposit gagal."
                                );
                            }
                        }
                    }

                    break;

                case 5:

                    Customer customerWithdraw =
                            pilihCustomer(bank, input);

                    if (customerWithdraw != null) {

                        Account accountWithdraw =
                                pilihAccount(
                                        customerWithdraw,
                                        input
                                );

                        if (accountWithdraw != null) {

                            System.out.print(
                                    "Jumlah withdraw : Rp"
                            );

                            double withdraw =
                                    input.nextDouble();

                            boolean berhasil =
                                    accountWithdraw.withdraw(
                                            withdraw
                                    );

                            if (berhasil) {

                                System.out.println(
                                        "Withdraw berhasil."
                                );

                                System.out.println(
                                        "Saldo sekarang : Rp"
                                        + accountWithdraw
                                                .getBalance()
                                );

                            } else {

                                System.out.println(
                                        "Withdraw gagal."
                                );

                                System.out.println(
                                        "Saldo tidak mencukupi "
                                        + "atau jumlah tidak valid."
                                );
                            }
                        }
                    }

                    break;

                case 6:

                    Customer customerSaldo =
                            pilihCustomer(bank, input);

                    if (customerSaldo != null) {

                        Account accountSaldo =
                                pilihAccount(
                                        customerSaldo,
                                        input
                                );

                        if (accountSaldo != null) {

                            System.out.println(
                                    "Saldo account : Rp"
                                    + accountSaldo.getBalance()
                            );
                        }
                    }

                    break;

                case 0:

                    System.out.println(
                            "\nProgram selesai."
                    );

                    System.out.println(
                            "Terima kasih."
                    );

                    break;

                default:

                    System.out.println(
                            "Pilihan tidak tersedia."
                    );
            }

        } while (pilihan != 0);

        input.close();
    }

    public static void tampilkanCustomer(Bank bank) {

        System.out.println("\n=== DAFTAR CUSTOMER ===");

        for (int i = 0;
             i < bank.getNumOfCustomers();
             i++) {

            Customer customer =
                    bank.getCustomer(i);

            System.out.println(
                    (i + 1) + ". "
                    + customer.getFirstName()
                    + " "
                    + customer.getLastName()
            );
        }
    }

    public static void tampilkanAccount(
            Customer customer) {

        System.out.println("\n=== DAFTAR ACCOUNT ===");

        for (int i = 0;
             i < customer.getNumOfAccounts();
             i++) {

            Account account =
                    customer.getAccount(i);

            System.out.println(
                    (i + 1)
                    + ". Account "
                    + (i + 1)
                    + " | Saldo: Rp"
                    + account.getBalance()
            );
        }
    }

    public static Customer pilihCustomer(
            Bank bank,
            Scanner input) {

        tampilkanCustomer(bank);

        System.out.print(
                "\nPilih nomor customer : "
        );

        int index = input.nextInt() - 1;

        if (index >= 0 &&
            index < bank.getNumOfCustomers()) {

            Customer customer =
                    bank.getCustomer(index);

            System.out.println(
                    "Customer dipilih : "
                    + customer.getFirstName()
                    + " "
                    + customer.getLastName()
            );

            return customer;

        } else {

            System.out.println(
                    "Customer tidak ditemukan."
            );

            return null;
        }
    }

    public static Account pilihAccount(
            Customer customer,
            Scanner input) {

        if (customer.getNumOfAccounts() == 0) {

            System.out.println(
                    "Customer belum memiliki account."
            );

            return null;
        }

        tampilkanAccount(customer);

        System.out.print(
                "\nPilih nomor account : "
        );

        int index = input.nextInt() - 1;

        if (index >= 0 &&
            index < customer.getNumOfAccounts()) {

            return customer.getAccount(index);

        } else {

            System.out.println(
                    "Account tidak ditemukan."
            );

            return null;
        }
    }
}