import java.util.Scanner;

class Bank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name, accountNumber, accountType;
		int choice;
		double amount;

		System.out.println("Welcome to the Bank\n");

		System.out.print("Enter the name of the account holder: ");
		name = sc.nextLine();

		System.out.print("Enter the account number: ");
		accountNumber = sc.nextLine();

		System.out.println("Choose your account type:");
		System.out.println("1. Savings Account\t2. Current Account");
		System.out.print("Enter your choice: ");
		choice = sc.nextInt();

		System.out.println("Thank you for registering!");

		Account account;
		if (choice == 1) {
			account = new SavingsAccount();
			accountType = "Savings Account";
		} else {
			account = new CurrentAccount();
			accountType = "Current Account";
		}

		account.customerName = name;
		account.accountNumber = accountNumber;
		account.accountType = accountType;

		while (true) {
			System.out.println("\n1. Deposit\n2. Withdraw\n3. Get Balance\n4. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter the amount to deposit: ");
					amount = sc.nextDouble();
					account.deposit(amount);
					break;
				case 2:
					System.out.print("Enter the amount to withdraw: ");
					amount = sc.nextDouble();
					account.withdraw(amount);
					break;
				case 3:
					account.getBalance();
					break;
				case 4:
					System.out.println("Exiting...");
					sc.close();
					System.exit(0);
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}

abstract class Account {
	String customerName;
	String accountNumber;
	String accountType;
	Double balance = 0.0;

	abstract void deposit(double amount);

	abstract void withdraw(double amount);

	void getBalance() {
		System.out.println("Current Balance: " + balance);
	}
}

class CurrentAccount extends Account {
	double minBalance = 8500.0;
	double penalty = 2000.0;

	void deposit(double amount) {
		if (balance == 0) {
			if (amount < minBalance) {
				System.out.println("The minimum deposit is " + minBalance);
				System.out.println("Please deposit a higher amount");
				return;
			}
		}
		balance += amount;
		System.out.println("Deposited " + amount + " to " + customerName + ", Current Balance: " + balance);
	}

	void withdraw(double amount) {
		if (amount > minBalance) {
			balance -= penalty;
			System.out.println("You have been penalized for not maintaining the minimum balance");
		} else {
			balance -= amount;
			System.out.println("Withdrawn " + amount + " from " + customerName);
		}
	}
}

class SavingsAccount extends Account {
	final double CI = 0.05;

	void deposit(double amount) {
		balance += amount + (amount * CI);
		System.out.println("Deposited " + amount + " to " + customerName + ", Current Balance: " + balance);
		System.out.println("Compound Interest earned = " + (amount * CI));
	}

	void withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Insufficient balance");
		} else {
			balance -= amount;
			System.out.println("Withdrawn " + amount + " from " + customerName);
		}
	}
}
