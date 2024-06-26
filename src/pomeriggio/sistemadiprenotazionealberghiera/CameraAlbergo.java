package pomeriggio.sistemadiprenotazionealberghiera;

public abstract class CameraAlbergo {
    private int numero;
    private boolean disponibile;

    public CameraAlbergo(int numero) {
        this.numero = numero;
        this.disponibile = true;
    }

    public abstract double calcolaCosto();

    public abstract int numeroLetti();

    public int getNumero() {
        return numero;
    }

    public boolean isDisponibile() {
        return disponibile;
    }


    public void prenota() {
        disponibile = false;
    }

    public void annullaPrenotazione() {
        disponibile = true;
    }
}
