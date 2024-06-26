package pomeriggio.sistemadiprenotazionehotel;

import java.time.LocalDate;

public class Prenotazione {
    private Cliente cliente;
    private Camera camera;
    private LocalDate dataArrivo;
    private LocalDate dataPartenza;

    public Prenotazione(Cliente cliente, Camera camera, LocalDate dataArrivo, LocalDate dataPartenza) {
        this.cliente = cliente;
        this.camera = camera;
        this.dataArrivo = dataArrivo;
        this.dataPartenza = dataPartenza;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Camera getCamera() {
        return camera;
    }

    public LocalDate getDataArrivo() {
        return dataArrivo;
    }

    public LocalDate getDataPartenza() {
        return dataPartenza;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void setDataArrivo(LocalDate dataArrivo) {
        this.dataArrivo = dataArrivo;
    }

    public void setDataPartenza(LocalDate dataPartenza) {
        this.dataPartenza = dataPartenza;
    }
}
