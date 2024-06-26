package pomeriggio.sistemadiprenotazionehotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerPrenotazioni {
    private List<Camera> camereList = new ArrayList<>();
    private Map<Prenotazione, Cliente> prenotazioniMap = new HashMap<>();

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void addCamera(Camera camera) {
        camereList.add(camera);
    }

    public void addAllCameras(List<Camera> cameras) {
        camereList.addAll(cameras);
    }

    public Prenotazione createPrenotazione(Cliente cliente, Camera camera, String dataArrivo, String dataPartenza) {
        if (cliente == null || camera == null || dataArrivo == null || dataPartenza == null) {
            throw new IllegalArgumentException("Non è stato possibile creare la prenotazione per via di dati mancanti");
        }
        if (!camera.isDisponibile()) {
            throw new IllegalArgumentException("La camera selezionata non è disponibile");
        }

        LocalDate dataArrivoDate;
        LocalDate dataPartenzaDate;

        try {
            dataArrivoDate = LocalDate.parse(dataArrivo, DATE_FORMATTER);
            dataPartenzaDate = LocalDate.parse(dataPartenza, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato data non valido. Usa il formato dd/MM/yyyy.");
        }

        Prenotazione prenotazione = new Prenotazione(cliente, camera, dataArrivoDate, dataPartenzaDate);
        camera.prenota();
        prenotazioniMap.put(prenotazione, cliente);
        return prenotazione;
    }

    public boolean cancelPrenotazione(Cliente cliente, Prenotazione prenotazione) throws IllegalAccessException {
        if (!prenotazioniMap.containsKey(prenotazione) || !prenotazioniMap.get(prenotazione).equals(cliente)) {
            throw new IllegalAccessException("La prenotazione elencata non appartiene al cliente o non esiste");
        }

        if (LocalDate.now().isAfter(prenotazione.getDataArrivo())) {
            throw new IllegalArgumentException("Non e' piu possibile annullare la prenotazione");
        }
        prenotazione.getCamera().cancellaPrenotazione();
        prenotazioniMap.remove(prenotazione);
        return true;
    }
}
