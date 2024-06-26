package pomeriggio;

public class Elettore {
    private String name;
    private String surname;
    private boolean hasVoted;

    public Elettore(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void vote(Candidato candidato) {
        if(candidato == null || candidato.getName() == null || candidato.getSurname() == null) {
            throw new IllegalArgumentException("Candidato non trovato");
        }
        if(hasVoted) {
            throw new IllegalArgumentException("Questo elettore ha gia votato");
        }
        candidato.addVoto(this);
        hasVoted = true;
    }
}
