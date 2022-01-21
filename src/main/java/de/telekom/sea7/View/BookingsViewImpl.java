package de.telekom.sea7.View;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import de.telekom.sea7.Model.BookingImpl;
import de.telekom.sea7.Model.BookingsImpl;

public class BookingsViewImpl {

	private BookingsImpl bookingsimpl;

	public BookingsViewImpl(BookingsImpl bookingsimpl) {
		this.bookingsimpl = bookingsimpl;
	}

	public void menu() {
		String input = "";
		Scanner scanner = new Scanner(System.in);
		while (!input.equals("exit")) {
			System.out
					.println("Enter something (e.g add - create new transaction, showAll - lists all transactions): ");
			input = scanner.next();

			switch (input) {
			case "add":
				add();
				break;
			case "showOne":
				showOne();
				break;
			case "showAll":
				showAll();
				break;
			case "exit":
				scanner.close();
				System.out.println();
				System.out.println("Programm will be closed...");
				System.out.println();
			default:
				System.out.println(
						"Command unknown. Please enter an existing command. With command 'help' you can list all existing commands.");
				System.out.println();
				break;

			}
		}
	}

	/*
	 * private void showOne() { Scanner scannerAdd = new Scanner(System.in);
	 * System.out.println("Wähle eine Transaktion aus: "); int position =
	 * scannerAdd.nextInt(); scannerAdd.nextLine(); ArrayList allTrans =
	 * bookingsimpl.get(); TransactionView transabookingsimplctionView = new
	 * TransactionView(this, (Transaction) allTrans.get(position));
	 * transactionView.menu(); }
	 */
		
	
	
	private void add() {
		LocalDateTime datum = LocalDateTime.now();
		Scanner scannerAdd = new Scanner(System.in);

		System.out.println("Wie viel soll überwiesen werden: ");
		float betrag = scannerAdd.nextFloat();
		scannerAdd.nextLine();
		System.out.println("Empfänger: ");
		String empfaenger = scannerAdd.nextLine();
		System.out.println("IBAN: ");
		String iban = scannerAdd.nextLine();
		System.out.println("BIC: ");
		String bic = scannerAdd.nextLine();
		System.out.println("Verwendungszweck: ");
		String verwendungszweck = scannerAdd.nextLine();

		bookingsimpl.add(betrag, empfaenger, iban, bic, verwendungszweck, datum);
		// scannerAdd.close();
	}

	private void showAll() {

		for (Object o : bookingsimpl) {
			BookingImpl tempTrans = (BookingImpl) o;
			System.out.println(bookingsimpl.getIndex(tempTrans) + "-" + tempTrans.getEmpfaenger() + " - "
					+ tempTrans.getVerwendungszweck() + " - " + String.format("%.2f", tempTrans.getBetrag()) + "€");
		}
	
	}
private void showOne() {
	 Scanner scannershowOne = new Scanner(System.in);
	 System.out.println("Wähle den gewünschten Datensatz aus: "); 
	 int index = scannershowOne.nextInt(); 
	 scannershowOne.nextLine();
	BookingImpl temp = bookingsimpl.getBooking(index);
	
	BookingViewImpl bookingviewimpl = new BookingViewImpl(temp);
	bookingviewimpl.show();
	
	
	
}
}

