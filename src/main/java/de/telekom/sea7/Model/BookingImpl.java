package de.telekom.sea7.Model;

import java.time.LocalDateTime;

public class BookingImpl {
	
	private float betrag;
	private String empfaenger;
	private String iban;
	private String bic;
	private String verwendungszweck;
	private LocalDateTime datum;
	
	public BookingImpl( float betrag, String empfaenger, String iban, String bic, String verwendungszweck, LocalDateTime datum) {
		this.betrag = betrag;
		this.empfaenger = empfaenger;
		this.iban = iban;
		this.bic = bic;
		this.verwendungszweck = verwendungszweck;
		this.datum = datum;
	}

	public LocalDateTime getDatum() {
		return datum;
	}

	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	public float getBetrag() {
		return betrag;
	}

	public void setBetrag(float betrag) {
		this.betrag = betrag;
	}

	public String getEmpfaenger() {
		return empfaenger;
	}

	public void setEmpfaenger(String empfaenger) {
		this.empfaenger = empfaenger;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getVerwendungszweck() {
		return verwendungszweck;
	}

	public void setVerwendungszweck(String verwendungszweck) {
		this.verwendungszweck = verwendungszweck;
	}

}


