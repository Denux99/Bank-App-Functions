
import java.util.Scanner;
public class Account {
	
	//class variables 
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	
	//class constructors
	Account(String cname, String cid){
		customerName = cname;
		customerID = cid;
	}
	
	//function for deposit money
	void deposit(int amount) {
		if(amount !=0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	//function for withdrawing money
	void withdraw(int amount) {
		if(amount !=0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	//function showing the previous transaction
	void getpreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposit :" + previousTransaction);
				
		}else if(previousTransaction < 0) {
			System.out.println("Withdrawn :" + Math.abs(previousTransaction));	
		}else {
			System.out.println("No transaction occured");
		}
	}
	
	//function of calculation interest of current funds after a number of years
	void calculateInterest(int years) {
		double interestRate = 0.169;
		double newBalance = (balance + interestRate + years)+ balance;
		System.out.println("The current interest rate is " + (100 * interestRate));
		System.out.println("After " + "years, you balance will be; " + newBalance);
		
	}
	
	//function showing main menu
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("What would like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdraw");
		System.out.println("D. View previous transcation");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			// case 'A' is allows the user to check account balance
			case 'A':
			System.out.println("****************************************");
			System.out.println("Balance = Rs" + balance);
			System.out.println("****************************************");
			System.out.println();
			break;
			
			// case 'B' is allows the user to deposit money
			case 'B':
			System.out.println("Enter an amount to deposit: ");
			int amount =scanner.nextInt();
			deposit(amount);
			System.out.println();
			break;
			
			// case 'C' is allows the user can withdraw money
			case 'C':
			System.out.println("Enter an amount to withdraw: ");
			int amount2 = scanner.nextInt();
			withdraw(amount2);
			System.out.println();
			break;
			
			// case 'D' is allows the user can view recent transaction
			case 'D':
			System.out.println("****************************************");
			getpreviousTransaction();
			System.out.println("****************************************");
			System.out.println();
			break;
			
			// case 'E' is allows the calculate interest
			case 'E':
			System.out.println("How many years occured interest? ");
			int years = scanner.nextInt();
			calculateInterest(years);
			break;
			
			// case 'E' is allows the calculate interest
			case 'F':
				System.out.println("****************************************");
				break;
				
			
				default:
					System.out.println("Error: invalid option. Please enter A,B,C,D,E,F");
					break;
					
			}
				
		}while(option !='F');
		System.out.println("Thank you for banking with DBC!");
		
		
	}
}
