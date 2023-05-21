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
        List<Itineraire> itineraires = List.of(new Itineraire(s1, s2, null, 10));
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
            new Itineraire(s1, s2, null, 10), 
            new Itineraire(s1, s3, null, 20)
        );

        HashMap<String, Integer> expecteds = new HashMap<>();
        expecteds.put("B", 10);
        expecteds.put("C", 20);
        var g = new Graphe(stations, itineraires).getRelations("A");
        for(Map.Entry<String, Integer> entry : g.entrySet()){
            assertEquals(expecteds.get(entry.getKey()), g.get(entry.getKey()));
        }
    }


}
