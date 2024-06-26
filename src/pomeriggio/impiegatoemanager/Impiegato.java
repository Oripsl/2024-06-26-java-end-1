package pomeriggio.impiegatoemanager;

public class Impiegato {
    private String name;
    private double salary;

    public Impiegato(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void aumentaSalario(int percentuale) {
        if (percentuale < 0) {
            throw new IllegalArgumentException("La percentuale di aumento non può essere negativa");
        }
        salary += salary * percentuale / 100.0;
    }
}
