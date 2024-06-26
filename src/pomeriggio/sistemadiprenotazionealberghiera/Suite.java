package pomeriggio.sistemadiprenotazionealberghiera;

public class Suite extends CameraAlbergo {
    public Suite(int numero, int numeroLetti) {
        super(numero, numeroLetti);
    }

    @Override
    public double calcolaCosto() {
        return 110.0 * getNumeroLetti();
    }

    @Override
    public int getNumeroLetti() {
        return getLetti();
    }


}
