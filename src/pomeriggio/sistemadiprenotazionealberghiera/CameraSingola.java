package pomeriggio.sistemadiprenotazionealberghiera;

public class CameraSingola extends CameraAlbergo{
    public CameraSingola(int numero) {
        super(numero);
    }

    @Override
    public double calcolaCosto() {
        return 40.0;
    }

    @Override
    public int numeroLetti() {
        return 1;
    }
}
