package pomeriggio.sistemadiprenotazionehotel;

public class Camera {
    private int numero;
    private String tipo;
    private boolean disponibile;

    public Camera(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponibile = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void prenota() {
        this.disponibile = false;
    }

    public void cancellaPrenotazione() {
        this.disponibile = true;
    }
}
