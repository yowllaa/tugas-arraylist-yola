public class Bank {

    private Customer[] customers;
    private int numberOfCustomers;

    // Konstruktor
    public Bank() {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    // Menambahkan customer baru
    public void addCustomer(String firstName, String lastName) {
        if (numberOfCustomers < customers.length) {
            customers[numberOfCustomers] =
                    new Customer(firstName, lastName);

            numberOfCustomers++;
        }
    }

    // Mengambil jumlah customer
    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    // Mengambil customer berdasarkan index
    public Customer getCustomer(int index) {
        return customers[index];
    }
}