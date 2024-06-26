import mattina.*;
import pomeriggio.sistemadivotazione.Candidato;
import pomeriggio.sistemadivotazione.Elettore;

public class Main {
    public static void main(String[] args) {
//        checkPrenotazioni();
//        checkStudente();
//        checkConto();
//        checkElenco();
//        checkVotazione();
    }

    public static void checkPrenotazioni() {
        Prenotazioni prenotazioni = new Prenotazioni(20);
        System.out.println(prenotazioni.reserveSeat());
        System.out.println(prenotazioni.reserveSeat());
        System.out.println(prenotazioni.reserveSeat());
        System.out.println(prenotazioni.reserveSeat(2));
        System.out.println(prenotazioni.removeReservation());
        System.out.println(prenotazioni.removeReservation(2));
        System.out.println(prenotazioni.removeReservation(14));
        System.out.println(prenotazioni.checkAvailableSeats());
    }

    public static void checkStudente() {
        Studente studente = new Studente("Mario Rossi", 12345);
        try {
            studente.addVoto(10);
            studente.addVoto(9);
            studente.addVoto(7);
            studente.printDetails();

            System.out.println("Media voti: " + studente.getAverageVoti());
        } catch (IllegalArgumentException e) {
            System.out.println("Impossibile aggiungere voto: " + e.getMessage());
        }
    }

    public static void checkConto() {
        ContoBancario conto = new ContoBancario();

        conto.addMoney(100.0);
        System.out.println("Saldo dopo il deposito: " + conto.getConto());

        try {
            conto.retrieveMoney(50.0);
            System.out.println("Saldo dopo il prelievo: " + conto.getConto());
        } catch (IllegalArgumentException e) {
            System.out.println("Impossibile prelevare denaro: " + e.getMessage());
        }

        try {
            conto.retrieveMoney(70.0);
            System.out.println("Saldo dopo il secondo prelievo: " + conto.getConto());
        } catch (IllegalArgumentException e) {
            System.out.println("Impossibile prelevare denaro: " + e.getMessage());
        }

        try {
            conto.addMoney(-20.0);
            System.out.println("Saldo dopo l'aggiunta di denaro negativo: " + conto.getConto());
        } catch (IllegalArgumentException e) {
            System.out.println("Impossibile aggiungere denaro negativo: " + e.getMessage());
        }
    }

    public static void checkElenco() {
        ElencoTelefonico elenco = new ElencoTelefonico();

        Contatto contatto1 = new Contatto("Mario Rossi", "1234567890");
        Contatto contatto2 = new Contatto("Luigi Verdi", "0987654321");

        elenco.addContatto(contatto1);
        elenco.addContatto(contatto2);

        Contatto risultatoRicercaNome = elenco.searchContatto("Mario Rossi");
        if (risultatoRicercaNome != null) {
            System.out.println("mattina.Contatto trovato per nome: " + risultatoRicercaNome.getNome() + ", Numero di telefono: " + risultatoRicercaNome.getNumeroDiTelefono());
        } else {
            System.out.println("mattina.Contatto non trovato per nome.");
        }

        Contatto risultatoRicercaNumero = elenco.searchContattoWithNumber("0987654321");
        if (risultatoRicercaNumero != null) {
            System.out.println("mattina.Contatto trovato per numero di telefono: " + risultatoRicercaNumero.getNome() + ", Numero di telefono: " + risultatoRicercaNumero.getNumeroDiTelefono());
        } else {
            System.out.println("mattina.Contatto non trovato per numero di telefono.");
        }

        elenco.removeContatto(contatto1);
        System.out.println("Elenco dopo la rimozione");
        for (Contatto contatto : elenco.getListaDiContatti()) {
            System.out.println(contatto.getNome() + ", " + contatto.getNumeroDiTelefono());
        }

        try {
            elenco.addContatto(new Contatto(null, null));
        } catch (IllegalArgumentException e) {
            System.out.println("Impossibile aggiungere conttatto: " + e.getMessage());
        }

        try {
            elenco.removeContatto(new Contatto(null, null));
        } catch (IllegalArgumentException e) {
            System.out.println("Impossibile rimuovere conttatto: " + e.getMessage());
        }
    }

    public static void checkVotazione() {
        Candidato candidato1 = new Candidato("Alice", "Pieraldi");
        Candidato candidato2 = new Candidato("Carlo", "Saccarosio");
        Candidato candidato3 = null;

        Elettore elettore1 = new Elettore("Piero", "Diamanti");
        Elettore elettore2 = new Elettore("Termosifone", "Caldo");
        Elettore elettore3 = new Elettore("Termosifone", "Caldo");

        try {
            elettore1.vote(candidato1);
            elettore3.vote(candidato1);
            elettore2.vote(candidato3);
            elettore2.vote(candidato2);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore durante la votazione: " + e.getMessage());
        }

        System.out.println("Risultati delle votazioni:");
        System.out.println(candidato1.getName() + ": " + candidato1.getNumeroVoti() + " voti");
        System.out.println(candidato2.getName() + ": " + candidato2.getNumeroVoti() + " voti");
    }
}


