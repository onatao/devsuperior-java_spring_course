package AccountEx.application;

import java.util.Scanner;

import AccountEx.models.entities.Account;
import AccountEx.models.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data: ");
			System.out.println("Number: ");
			int number = sc.nextInt();
			System.out.println("Holder: ");
			String holder = sc.next();
			System.out.println("Balance: ");
			double balance = sc.nextDouble();
			System.out.println("Limit: ");
			double limit = sc.nextDouble();
			
			Account c1 = new Account(number, holder, balance, limit);
			
			System.out.println("Enter amount for witchdraw: ");
			c1.withdraw(sc.nextDouble());
			System.out.println("New balance: " + c1.getBalance());
			
		}
		catch (DomainException e) {
			System.out.println("Erro " + e.getMessage());
		}
		sc.close();
		
	}

}
