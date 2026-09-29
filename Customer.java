public class Customer {

    private String firstName;
    private String lastName;

    private Account[] accounts = new Account[5];
    private int numberOfAccounts = 0;

    // Konstruktor
    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
    }

    // Mengambil nama depan
    public String getFirstName() {
        return firstName;
    }

    // Mengambil nama belakang
    public String getLastName() {
        return lastName;
    }

    // Menambahkan Akun
    public void setAccount(Account acct) {
        if (numberOfAccounts < accounts.length) {
            accounts[numberOfAccounts] = acct;
            numberOfAccounts++;
        }
    }

    // Mengambil Akun berdasarkan index
    public Account getAccount(int accountIndex) {
        return accounts[accountIndex];
    }

    // Mengambil jumlah Akun
    public int getNumOfAccounts() {
        return numberOfAccounts;
    }
}