package pomeriggio.sistemadiprenotazionealberghiera;

public class CameraSingola extends CameraAlbergo {

    public CameraSingola(int numero, int numeroLetti) {
        super(numero, numeroLetti);
    }

    @Override
    public double calcolaCosto() {
        return 40.0 * getNumeroLetti();
    }

    @Override
    public int getNumeroLetti() {
        return getLetti();
    }
}
