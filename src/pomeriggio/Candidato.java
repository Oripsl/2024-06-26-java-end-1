package pomeriggio;

import java.util.HashMap;
import java.util.Map;

public class Candidato {
    private String name;
    private String surname;

    private Map<Elettore, Integer> votes;

    public Candidato(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.votes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void addVoto(Elettore elettore) {
        if (votes.containsKey(elettore)) {
            throw new IllegalArgumentException("Elettore ha gia votato questo candidato");
        }
        votes.put(elettore, 1);
    }

    public int getNumeroVoti() {
        return votes.size();
    }
}
