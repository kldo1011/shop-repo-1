package shop.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import shop.artikelverwaltung.domain.Hersteller;
import shop.artikelverwaltung.domain.Lieferant;
import shop.artikelverwaltung.domain.Rad;
import shop.bestellverwaltung.domain.Bestellung;
import shop.kundenverwaltung.domain.Adresse;
import shop.kundenverwaltung.domain.Bankdaten;
import shop.kundenverwaltung.domain.Kunde;

public class Mock {
	private static final int MAX_ID = 99;
	private static final int MAX_BESTELLUNGEN = 4;

	public static Bestellung findeBestellungById(Long id) {
		if (id > MAX_ID) {
			return null;
		}
		
		final Kunde kunde = findKundeById(id + 1);
		final Date date = new Date();

		final Bestellung bestellung = new Bestellung();
		bestellung.setId(id);
		bestellung.setAusgeliefert(false);
		bestellung.setKunde(kunde);
		bestellung.setBestelldatum(date);

		return bestellung;
	}

	public static Bestellung createBestellung(Bestellung bestellung) {
		bestellung.setId((long) bestellung.getKunde().getNachname().length());
		bestellung.setAusgeliefert(false);
		bestellung.setKunde(bestellung.getKunde());
		bestellung.setBestelldatum(bestellung.getBestelldatum());
		
		System.out.println("Erstellte Bestellung: " + bestellung);
		return bestellung;
	}

	public static void updateBestellung(Bestellung bestellung) {
		System.out.println("Aktualisierte Bestellung: " + bestellung);
	}

	public static void deleteBestellung(Long id) {
		System.out.println("Bestellung mit ID=" + id + " geloescht");
	}

	public static Rad findRadById(Long id) {
		final int preis = 150;
		final int baujahr = 2012;
		final int zoll = 28;
		
		final Lieferant lieferant = new Lieferant();
		lieferant.setId(id + 1);
		lieferant.setName("Franz");

		final Hersteller hersteller = new Hersteller();
		hersteller.setId(id + 2);
		hersteller.setName("Velo GmbH");
		
		final Rad rad = new Rad();
		rad.setId(id);
		rad.setName("City-Bike");
		rad.setPreis(preis);
		rad.setBaujahr(baujahr);
		rad.setZoll(zoll);
		rad.setHersteller(null);
		rad.setLieferant(null);

		return rad;
	}

	public static Rad createRad(Rad rad) {
		final long id = 10;
		
		final Rad radx = new Rad();
		radx.setId(id);
		radx.setName(rad.getName());
		radx.setPreis(rad.getPreis());
		radx.setZoll(rad.getZoll());
		radx.setBaujahr(rad.getBaujahr());
		radx.setHersteller(rad.getHersteller());
		radx.setLieferant(rad.getLieferant());

		System.out.println("Erstelltes Rad: " + rad);
		return rad;
	}

	public static void updateRad(Rad rad) {
		System.out.println("Aktualisiertes Rad: " + rad);
	}

	public static void deleteRad(Long id) {
		System.out.println("Rad mit ID = " + id + "geloescht");
	}
								
	public static Kunde findKundeById(Long id) {
		if (id > MAX_ID) {
			return null;
		}
		final int kontonr = 83747446;
		final int blz = 325443567;
		
		final Kunde kunde = new Kunde(); 
		kunde.setId(id); 
		kunde.setVorname("Andreas"); 
		kunde.setNachname("Jankowoi"); 
		kunde.setEmail("jaan1011@hs-karlsruhe.de"); 
		final Date geburt = new Date(); 
		kunde.setGeburtstag(geburt); 
		kunde.setTelefon("00234234994");

		final Adresse adress = new Adresse(); 
		adress.setStrasse("Kaiserstrasse"); 
		adress.setHausnummer("12"); 
		adress.setStadt("Karlsruhe"); 
		adress.setPlz("76100"); 
		kunde.setAdresse(adress);

		final Bankdaten bank = new Bankdaten(); 
		bank.setBankname("Sparkasse Ettlingen"); 
		bank.setKontonummer(kontonr); 
		bank.setBlz(blz); 
		kunde.setBankdaten(bank);

		return kunde;
	}
	
	public static Kunde findKundeByNachname(String nachname) {
		if (nachname == null) {
			return null;
		}
		final long id = 98;
		final int kontonr = 83747446;
		final int blz = 325443567;
		
		final Kunde kunde = new Kunde(); 
		kunde.setId(id); 
		kunde.setVorname("Andreas"); 
		kunde.setNachname(nachname); 
		kunde.setEmail("jaan1011@hs-karlsruhe.de"); 
		final Date geburt = new Date(); 
		kunde.setGeburtstag(geburt); 
		kunde.setTelefon("00234234994");

		final Adresse adress = new Adresse(); 
		adress.setStrasse("Kaiserstrasse"); 
		adress.setHausnummer("12"); 
		adress.setStadt("Karlsruhe"); 
		adress.setPlz("76100"); 
		kunde.setAdresse(adress);

		final Bankdaten bank = new Bankdaten(); 
		bank.setBankname("Sparkasse Ettlingen"); 
		bank.setKontonummer(kontonr); 
		bank.setBlz(blz); 
		kunde.setBankdaten(bank);

		return kunde;
	}
	
	public static List<Bestellung> findBestellungenByKunde(Kunde kunde) {
		// Beziehungsgeflecht zwischen Kunde und Bestellungen aufbauen
		final int anzahl = kunde.getId().intValue() % MAX_BESTELLUNGEN + 1;  // 1, 2, 3 oder 4 Bestellungen
		final List<Bestellung> bestellungen = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Bestellung bestellung = findeBestellungById(Long.valueOf(i));
			bestellung.setKunde(kunde);
			bestellungen.add(bestellung);			
		}
		
		return bestellungen;
	}
	
	public static Kunde findKundeByVornamen(String vorname) {
		if (vorname == null) {
			return null;
		}
		final long id = 98;
		final int kontonr = 83747446;
		final int blz = 325443567;
		
		final Kunde kunde = new Kunde(); 
		kunde.setId(id); 
		kunde.setVorname(vorname); 
		kunde.setNachname("Jankowoi"); 
		kunde.setEmail("jaan1011@hs-karlsruhe.de"); 
		final Date geburt = new Date(); 
		kunde.setGeburtstag(geburt); 
		kunde.setTelefon("00234234994");

		final Adresse adress = new Adresse(); 
		adress.setStrasse("Kaiserstrasse"); 
		adress.setHausnummer("12"); 
		adress.setStadt("Karlsruhe"); 
		adress.setPlz("76100"); 
		kunde.setAdresse(adress);

		final Bankdaten bank = new Bankdaten(); 
		bank.setBankname("Sparkasse Ettlingen"); 
		bank.setKontonummer(kontonr); 
		bank.setBlz(blz); 
		kunde.setBankdaten(bank);

		return kunde;
	}
	
	public static Kunde createKunde(Kunde kunde) {
		final Kunde kund = new Kunde();
		kund.setId(kunde.getId());
		kund.setVorname(kunde.getVorname());
		kund.setNachname(kunde.getNachname());
		kund.setEmail(kunde.getEmail());
		final Date geburt = new Date();
		kund.setGeburtstag(geburt);
		kund.setTelefon(kunde.getTelefon());

		final Adresse adress = new Adresse();
		adress.setStrasse(kunde.getAdresse().getStrasse());
		adress.setHausnummer(kunde.getAdresse().getHausnummer());
		adress.setStadt(kunde.getAdresse().getStadt());
		adress.setPlz(kunde.getAdresse().getPlz());
		kund.setAdresse(adress);

		final Bankdaten bank = new Bankdaten();
		bank.setBankname(kunde.getBankdaten().getBankname());
		bank.setKontonummer(kunde.getBankdaten().getKontonummer());
		bank.setBlz(kunde.getBankdaten().getBlz());
		kund.setBankdaten(bank);

		System.out.println("Erstellter Kunde: " + kund);
		return kund;
	}

	public static void updateKunde(Kunde kunde) {
		System.out.println("Aktualisierter Kunde: " + kunde);
	}
	
	public static void deleteKunde(Long id) {
		System.out.println("Kunde mit ID = " + id + "geloescht");
	}
}
