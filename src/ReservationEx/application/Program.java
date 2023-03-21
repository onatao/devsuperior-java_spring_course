package ReservationEx.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ReservationEx.model.entities.Reservation;
import ReservationEx.model.exception.DomainException;

public class Program {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room number: ");
			int number = scan.nextInt();
			System.out.println("Check-in date (DD/MM/YYYY)");
			Date checkIn = spdf.parse(scan.next());
			System.out.println("Check-out date (DD/MM/YYYY)");
			Date checkOut = spdf.parse(scan.next());
		
		
			Reservation res = new Reservation(number, checkIn, checkOut);
			System.out.println(res);
				
			System.out.println();
			System.out.println("Enter data update for reservation: ");
			System.out.println("Check-in date (DD/MM/YYYY)");
			checkIn = spdf.parse(scan.next());
			System.out.println("Check-out date (DD/MM/YYYY)");
			checkOut = spdf.parse(scan.next());
			
			res.updateDate(checkIn, checkOut);
			System.out.println(res);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation " + e.getMessage());
		}
	
		
		scan.close();
	}

}
