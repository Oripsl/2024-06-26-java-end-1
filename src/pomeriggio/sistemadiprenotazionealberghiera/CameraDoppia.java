package pomeriggio.sistemadiprenotazionealberghiera;

public class CameraDoppia extends CameraAlbergo{
    public CameraDoppia(int numero) {
        super(numero);
    }

    @Override
    public double calcolaCosto() {
        return 70.0;
    }

    @Override
    public int numeroLetti() {
        return 2;
    }
}
