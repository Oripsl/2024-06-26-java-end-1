package mattina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prenotazioni {
    private final List<Boolean> seatsAvailable;
    public Prenotazioni(int numeroPosti) {
        seatsAvailable = new ArrayList<>(numeroPosti);

        for (int i = 0; i < numeroPosti; i++) {
            seatsAvailable.add(false);
        }
    }

    public boolean reserveSeat() {
        for (int i = 0; i < seatsAvailable.size(); i++) {
            if (!seatsAvailable.get(i)) {
                seatsAvailable.set(i, true);
                return true;
            }
        }
        return false;
    }

    public boolean reserveSeat(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= seatsAvailable.size() || seatsAvailable.get(seatNumber)) {
            return false;
        }

        seatsAvailable.set(seatNumber, true);
        return true;
    }

    public boolean removeReservation() {
        for (int i = 0; i < seatsAvailable.size(); i++) {
            if (seatsAvailable.get(i)) {
                seatsAvailable.set(i, false);
                return true;
            }
        }
        return false;
    }

    public boolean removeReservation(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= seatsAvailable.size() || !seatsAvailable.get(seatNumber)) {
            return false;
        }

        seatsAvailable.set(seatNumber, false);
        return true;
    }

    public Map<String, String> checkAvailableSeats() {
        Map<String, String> available = new HashMap<>();

        available.put("Posti totali disponibili ", " "+(int) seatsAvailable.stream().filter(seat -> !seat).count());

        for(int i = 0; i < seatsAvailable.size(); i++) {
            if(!seatsAvailable.get(i)) {
                available.put("Posto " + i + " ", " disponibile");
            }
        }

        return available;
    }
}
