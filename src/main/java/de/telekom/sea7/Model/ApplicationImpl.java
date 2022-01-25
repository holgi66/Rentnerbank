package de.telekom.sea7.Model;

import de.telekom.sea7.*;
import de.telekom.sea7.Model.*;
import de.telekom.sea7.View.BookingsViewImpl;




public class ApplicationImpl implements Application {
	
	public ApplicationImpl () {};
	
	
	
	
	
	public void run(String[] args) {
		Bookings bookingsimpl = new BookingsImpl();
		BookingsView bookingsviewimpl = new BookingsViewImpl(bookingsimpl);
		
		
		bookingsviewimpl.menu();
				
	}

}
