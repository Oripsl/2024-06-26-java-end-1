import mattina.*;
import pomeriggio.impiegatoemanager.Impiegato;
import pomeriggio.impiegatoemanager.Manager;
import pomeriggio.sistemadiprenotazionealberghiera.CameraAlbergo;
import pomeriggio.sistemadiprenotazionealberghiera.CameraDoppia;
import pomeriggio.sistemadiprenotazionealberghiera.CameraSingola;
import pomeriggio.sistemadiprenotazionealberghiera.Suite;
import pomeriggio.sistemadiprenotazionehotel.Camera;
import pomeriggio.sistemadiprenotazionehotel.Cliente;
import pomeriggio.sistemadiprenotazionehotel.ManagerPrenotazioni;
import pomeriggio.sistemadiprenotazionehotel.Prenotazione;
import pomeriggio.sistemadivotazione.Candidato;
import pomeriggio.sistemadivotazione.Elettore;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        checkPrenotazioni();
//        checkStudente();
//        checkConto();
//        checkElenco();
//        checkVotazione();
//        checkSistemaDiPrenotazioni();
//        checkSistemaAlbergo();
        checkImpiegatoManager();
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

    public static void checkSistemaDiPrenotazioni() {
        ManagerPrenotazioni manager = new ManagerPrenotazioni();
        Camera camera1 = new Camera(101, "Singola");
        Camera camera2 = new Camera(102, "Doppia");
        Cliente cliente1 = new Cliente("Mario Rossi", "mario.rossi@suacugina.com");
        Cliente cliente2 = new Cliente("Luca Bianchi", "luca.bianchi@suamamma.com");

        manager.addCamera(camera1);
        manager.addCamera(camera2);
        Prenotazione prenotazione1 = null;

        try {
            prenotazione1 = manager.createPrenotazione(cliente1, camera1, "01/07/2024", "10/07/2024");
            System.out.println("Prenotazione 1 creata con successo per " + prenotazione1.getCliente().getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Errore nella creazione della prenotazione: " + e.getMessage());
        }

        try {
            Prenotazione prenotazione2 = manager.createPrenotazione(cliente2, camera1, "05/07/2024", "15/07/2024");
            System.out.println("Prenotazione 2 creata con successo per " + prenotazione2.getCliente().getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Errore nella creazione della prenotazione: " + e.getMessage());
        }

        try {
            boolean cancellata = manager.cancelPrenotazione(cliente1, prenotazione1);
            if (cancellata) {
                System.out.println("Prenotazione 1 cancellata con successo");
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
            System.out.println("Errore nella cancellazione della prenotazione: " + e.getMessage());
        }

        try {
            boolean cancellata = manager.cancelPrenotazione(cliente2, prenotazione1);
            if (cancellata) {
                System.out.println("Prenotazione 2 cancellata con successo");
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
            System.out.println("Errore nella cancellazione della prenotazione: " + e.getMessage());
        }
    }

    public static void checkSistemaAlbergo() {
        List<CameraAlbergo> albergo = new ArrayList<>();

        albergo.add(new CameraSingola(101, 2));
        albergo.add(new CameraDoppia(102, 2));
        albergo.add(new Suite(103, 3));

        List<CameraAlbergo> camereDisponibili = albergo.stream().filter(CameraAlbergo::isDisponibile).toList();
        for (CameraAlbergo camera : camereDisponibili) {
            System.out.println("Camera numero: " + camera.getNumero() + ", Tipo: " + camera.getClass().getSimpleName() + ", Costo: " + camera.calcolaCosto() + " Euro, Letti: " + camera.getNumeroLetti());
        }

        if (!camereDisponibili.isEmpty()) {
            CameraAlbergo cameraDaPrenotare = camereDisponibili.getFirst();
            cameraDaPrenotare.prenota();
            System.out.println("Camera numero " + cameraDaPrenotare.getNumero() + " prenotata con successo.");
        }

        camereDisponibili = albergo.stream().filter(CameraAlbergo::isDisponibile).toList();
        for (CameraAlbergo camera : camereDisponibili) {
            System.out.println("Camera numero: " + camera.getNumero() + ", Tipo: " + camera.getClass().getSimpleName() + ", Costo: " + camera.calcolaCosto() + " Euro, Letti: " + camera.getNumeroLetti());
        }
    }

    public static void checkImpiegatoManager() {
        Impiegato imp1 = new Impiegato("Mario Rossi", 30000);
        System.out.println("Nome: " + imp1.getName() + ", Salario: " + imp1.getSalary());

        imp1.aumentaSalario(10);
        System.out.println("Nome: " + imp1.getName() + ", Salario dopo aumento: " + imp1.getSalary());

        Manager mgr1 = new Manager("Luigi Bianchi", 50000, 5000);
        System.out.println("Nome: " + mgr1.getName() + ", Salario: " + mgr1.getSalary() + ", Bonus: " + mgr1.getBonus());

        mgr1.aumentaSalario(10);
        System.out.println("Nome: " + mgr1.getName() + ", Salario dopo aumento: " + mgr1.getSalary());
    }
}





