package gl.vetb;

import java.time.LocalTime;

public class Horaire {
    private LocalTime heureDepart;
    private LocalTime heureArrivee;

    public Horaire(LocalTime heureDepart, LocalTime heureArrivee) {
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public LocalTime getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(LocalTime heureArrivee) {
        this.heureArrivee = heureArrivee;
    }
}