package pomeriggio.sistemadiprenotazionealberghiera;

public abstract class CameraAlbergo {
    private int numero;
    private boolean disponibile;

    private int numeroLetti;

    public CameraAlbergo(int numero, int numeroLetti) {
        this.numero = numero;
        this.numeroLetti = numeroLetti;
        this.disponibile = true;
    }

    public abstract double calcolaCosto();

    public  int getNumeroLetti() {
        return numeroLetti;
    }

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
