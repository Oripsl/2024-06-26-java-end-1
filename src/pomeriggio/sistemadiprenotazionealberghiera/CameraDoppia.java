package pomeriggio.sistemadiprenotazionealberghiera;

public class CameraDoppia extends CameraAlbergo{
    public CameraDoppia(int numero, int numeroLetti) {
        super(numero, numeroLetti);
    }

    @Override
    public double calcolaCosto() {
        return 70.0 * getNumeroLetti();
    }

    @Override
    public int getNumeroLetti() {
        return getLetti();
    }
}
