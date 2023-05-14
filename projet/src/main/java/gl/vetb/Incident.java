package gl.vetb;

import java.util.List;

public class Incident {
    private String type;
    private List<Station> stations;
    private List<Ligne> lignes;

    public Incident(String type, List<Station> stations, List<Ligne> lignes) {
        this.type = type;
        this.stations = stations;
        this.lignes = lignes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Ligne> getLignes() {
        return lignes;
    }

    public void setLignes(List<Ligne> lignes) {
        this.lignes = lignes;
    }
}