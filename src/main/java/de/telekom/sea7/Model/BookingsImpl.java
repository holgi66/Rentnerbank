package de.telekom.sea7.Model;
import java.time.*;

import java.util.ArrayList;
import java.util.Iterator;


public class BookingsImpl implements Iterable {

		private ArrayList bookings;
		
		public BookingsImpl() {
			bookings = new ArrayList();
		}
		
		public void add(float betrag, String empfaenger, String iban, String bic, String verwendungszweck, LocalDateTime datum) {
			BookingImpl bookingimpl = new BookingImpl(betrag, empfaenger, iban, bic, verwendungszweck, datum);
			bookings.add(bookingimpl);
		}
		
		
		@Override
		public Iterator iterator() {
			// TODO Auto-generated method stub
			return bookings.iterator();
		}
		public int getIndex(BookingImpl horst) {
		return this.bookings.indexOf(horst);	
			
		}
		public BookingImpl getBooking (int index ) {
			return (BookingImpl) bookings.get(index);
		}
}

