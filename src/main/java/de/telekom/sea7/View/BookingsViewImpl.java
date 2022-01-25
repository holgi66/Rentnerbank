package de.telekom.sea7.View;

import java.time.LocalDateTime;
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import de.telekom.sea7.Booking;
import de.telekom.sea7.BookingView;
import de.telekom.sea7.Bookings;
import de.telekom.sea7.BookingsView;

public class BookingsViewImpl implements BookingsView {

	private Bookings bookingsimpl;

	public BookingsViewImpl(Bookings bookingsimpl) {
		this.bookingsimpl = bookingsimpl;
	}

	@Override
	public void menu() {
		String input = "";
		Scanner scanner = new Scanner(System.in);
		while (!input.equals("exit")) {
			System.out.println(
					"Enter something (e.g add - create new transaction,showAll - lists all transactions, showOne - List one transaction): ");
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

		while (!scannerAdd.hasNextFloat()) {
			System.out.println("Es wurde kein gültiger Betrag eingegeben. Bitte um neue Eingabe: ");
			scannerAdd.next();
		}
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
			Booking tempTrans = (Booking) o;
			System.out.println(bookingsimpl.getIndex(tempTrans) + "-" + tempTrans.getEmpfaenger() + " - "
					+ tempTrans.getVerwendungszweck() + " - " + String.format("%.2f", tempTrans.getBetrag()) + "€");
		}

	}

	private void showOne() {
		Scanner scannershowOne = new Scanner(System.in);
		System.out.println("Wähle den gewünschten Datensatz aus: ");
		int index = scannershowOne.nextInt();
		scannershowOne.nextLine();
		Booking temp = bookingsimpl.getBooking(index);

		BookingView bookingviewimpl = new BookingViewImpl(temp);
		bookingviewimpl.show();

	}
}
