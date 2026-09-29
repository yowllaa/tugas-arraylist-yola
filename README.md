# Tugas PBO - Array dan ArrayList

Pada program ini dibuat simulasi bank sederhana yang terdiri dari beberapa class, yaitu `Account`, `Customer`, dan `Bank`. Program juga dilengkapi dengan class `Main` sebagai main program untuk mencoba object dan method yang sudah dibuat.

## Struktur Class

### 1. Account

Class `Account` digunakan untuk menyimpan data saldo dari sebuah rekening.

Beberapa method yang terdapat pada class ini:

- `getBalance()` untuk melihat saldo
- `deposit()` untuk menambahkan saldo
- `withdraw()` untuk melakukan penarikan saldo

Method `deposit()` dan `withdraw()` menggunakan nilai boolean untuk menentukan apakah transaksi berhasil atau tidak.

### 2. Customer

Class `Customer` digunakan untuk menyimpan data customer berupa nama depan dan nama belakang.

Setiap customer dapat mempunyai beberapa account yang disimpan menggunakan array:

```java
private Account[] accounts = new Account[5];
```

Jadi satu customer dapat memiliki maksimal 5 account.

Beberapa method yang digunakan:

- `getFirstName()`
- `getLastName()`
- `setAccount()`
- `getAccount()`
- `getNumOfAccounts()`

### 3. Bank

Class `Bank` digunakan untuk menyimpan kumpulan object `Customer`.

Customer disimpan dalam array:

```java
private Customer[] customers;
```

Pada constructor, kapasitas array dibuat sebanyak 10 customer.

```java
customers = new Customer[10];
```

Method yang digunakan pada class Bank:

- `addCustomer()` untuk menambahkan customer
- `getNumOfCustomers()` untuk melihat jumlah customer
- `getCustomer()` untuk mengambil customer berdasarkan index

## Hubungan Antar Class

Secara sederhana hubungan object pada program ini seperti berikut:

```text
Bank
 |
 +-- Customer[]
      |
      +-- Account[]
```

Artinya sebuah `Bank` dapat mempunyai beberapa `Customer`, kemudian setiap `Customer` dapat mempunyai beberapa `Account`.

## Main Program

Main program terdapat pada:

```text
Main.java
```

Pada bagian ini saya mencoba menggunakan object dan method yang sudah dibuat pada ketiga class sebelumnya.

Data awal yang digunakan terdiri dari beberapa customer dan account. Setelah itu program dapat digunakan melalui menu sederhana menggunakan `Scanner`.

Menu yang tersedia:

```text
================================
          SISTEM BANK
================================
1. Lihat Daftar Customer
2. Tambah Customer
3. Lihat Account Customer
4. Deposit
5. Withdraw
6. Cek Saldo
0. Keluar
================================
```

Dari menu tersebut user dapat memilih customer dan account, kemudian mencoba beberapa operasi seperti deposit, withdraw, dan melihat saldo.

## Contoh Pembuatan Object

Membuat object Bank:

```java
Bank bank = new Bank();
```

Menambahkan customer:

```java
bank.addCustomer("Andi", "Saputra");
```

Mengambil customer dari array:

```java
Customer customer = bank.getCustomer(0);
```

Membuat account dan memasukkannya ke customer:

```java
customer.setAccount(new Account(1000000));
```

Mengambil account:

```java
Account account = customer.getAccount(0);
```

Melakukan deposit:

```java
account.deposit(500000);
```

Melakukan withdraw:

```java
account.withdraw(200000);
```

## Struktur File

```text
.
├── Account.java
├── Customer.java
├── Bank.java
├── Main.java
└── README.md
```

## Menjalankan Program

Compile seluruh file Java:

```bash
javac Account.java Customer.java Bank.java Main.java
```

Kemudian jalankan:

```bash
java Main
```

## Kesimpulan

Dari tugas ini saya mencoba menerapkan penggunaan array yang berisi object pada Java. Array tidak hanya dapat digunakan untuk menyimpan tipe data biasa, tetapi juga dapat digunakan untuk menyimpan object dari suatu class.

Pada program ini penerapannya dapat dilihat pada `Customer[]` di dalam class `Bank` dan `Account[]` di dalam class `Customer`.

Selain itu, main program dikembangkan dengan menu sederhana supaya proses pemanggilan object dan method seperti `addCustomer()`, `deposit()`, `withdraw()`, `getAccount()`, dan `getCustomer()` dapat dicoba secara langsung.
