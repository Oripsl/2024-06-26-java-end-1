public class Contatto {
    private String nome;
    private String numeroDiTelefono;

    public Contatto(String nome, String numeroDiTelefono) {
        this.nome = nome;
        this.numeroDiTelefono = numeroDiTelefono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroDiTelefono() {
        return numeroDiTelefono;
    }

    public void setNumeroDiTelefono(String numeroDiTelefono) {
        this.numeroDiTelefono = numeroDiTelefono;
    }
}
