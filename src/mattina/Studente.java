package mattina;

import java.util.ArrayList;
import java.util.List;

public class Studente {
    private final String nome;
    private final Integer matricola;
    private final List<Integer> voti = new ArrayList<>();

    public Studente(String nome, Integer matricola) {
        this.nome = nome;
        this.matricola = matricola;
    }

    public boolean addVoto(int voto) {
        if (voto < 0 || voto > 10) {
            throw new IllegalArgumentException("Voto non puo essere negativo o maggiore di 10");
        }
        voti.add(voto);
        return true;
    }

    public double getAverageVoti() {
        if (voti.isEmpty()) {
            return 0;
        }

        int total = 0;
        for (Integer voto : voti) {
            total += voto;
        }
        double av = (double) total / voti.size();

        return Math.round(av * 10.0) / 10.0;
    }

    public void printDetails() {
        System.out.println("Nome: " + nome +
                "\nMatricola: " + matricola +
                "\nVoti: " + voti);
    }
}
