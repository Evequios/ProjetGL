package gl.vetb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class GrapheTests {

    @Test
    public void testGrapheStationsItinerairesNull(){
        assertThatThrownBy(() -> new Graphe(null, null)).isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    public void testGrapheStationsVide(){
        Station s1 = new Station("A", null, false, 0, 0, 0);
        Station s2 = new Station("B", null, false, 0, 0, 0);
        List<Station> stations = List.of();
        List<Itineraire> itineraires = List.of(new Itineraire(s1, s2, null, 10, null));
        var g = new Graphe(stations, itineraires).getStations();
        assertEquals(g,List.of());
    }

    @Test
    public void testGetRelations(){
        Station s1 = new Station("A", null, false, 0, 0, 0);
        Station s2 = new Station("B", null, false, 0, 0, 0);
        Station s3 = new Station("C", null, false, 0, 0, 0);
        List<Station> stations = List.of(s1, s2);
        List<Itineraire> itineraires = List.of(
            new Itineraire(s1, s2, null, 10, null), 
            new Itineraire(s1, s3, null, 20, null)
        );

        HashMap<Station, Integer> expecteds = new HashMap<>();
        expecteds.put(s2, 10);
        expecteds.put(s3, 20);
        var g = new Graphe(stations, itineraires).getRelations(s1);
        for(Map.Entry<Station, Integer> entry : g.entrySet()){
            assertEquals(expecteds.get(entry.getKey()), g.get(entry.getKey()));
        }
    }


}
