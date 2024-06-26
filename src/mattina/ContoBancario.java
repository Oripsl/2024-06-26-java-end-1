package mattina;

public class ContoBancario {
    private Double conto = 0d;

    public Double addMoney(double deposit) {
        if (deposit < 0) {
            throw new IllegalArgumentException("Il deposito non puo essere negativo");
        }
        return conto += deposit;
    }

    public Double retrieveMoney(double retrieval) {
        if (retrieval < 0 || retrieval > conto) {
            throw new IllegalArgumentException("Il deposito non puo essere negativo o maggiore del saldo disponibile");
        }
        return conto -= retrieval;
    }

    public Double getConto() {
        return conto;
    }
}
