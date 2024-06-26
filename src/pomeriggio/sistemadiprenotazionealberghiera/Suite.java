package pomeriggio.sistemadiprenotazionealberghiera;

public class Suite extends CameraAlbergo {
    public Suite(int numero) {
        super(numero);
    }

    @Override
    public double calcolaCosto() {
        return 110.0;
    }

    @Override
    public int numeroLetti() {
        return 4;
    }
}
