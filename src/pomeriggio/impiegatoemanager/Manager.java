package pomeriggio.impiegatoemanager;

public class Manager extends Impiegato{
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }
    @Override
    public void aumentaSalario(int percentuale) {
        if (percentuale < 0) {
            throw new IllegalArgumentException("La percentuale di aumento non può essere negativa");
        }
        setSalary(getSalary() + bonus);
        super.aumentaSalario(percentuale);
    }
}
