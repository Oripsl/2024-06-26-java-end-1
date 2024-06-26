import java.util.ArrayList;
import java.util.List;

public class ElencoTelefonico {
    List<Contatto> listaDiContatti = new ArrayList<>();

    public ElencoTelefonico() {
    }

    public boolean addContatto(Contatto contatto) {
        checkDetails(contatto);

        listaDiContatti.add(contatto);
        return true;
    }

    public boolean removeContatto(Contatto contatto) {
        checkDetails(contatto);
        return listaDiContatti.remove(contatto);
    }

    public Contatto searchContatto(String name) {
        for(Contatto contatto: listaDiContatti) {
            if(contatto.getNome().equals(name)) {
                return contatto;
            }
        }
        return null;
    }

    public Contatto searchContattoWithNumber(String phoneNumber) {
        for(Contatto contatto: listaDiContatti) {
            if(contatto.getNumeroDiTelefono().equals(phoneNumber)) {
                return contatto;
            }
        }
        return null;
    }

    private void checkDetails(Contatto contatto) {
        if (contatto.getNumeroDiTelefono() == null) {
            throw new IllegalArgumentException("Il numero non puo essere nullo");
        }
    }

    public List<Contatto> getListaDiContatti() {
        return listaDiContatti;
    }
}
