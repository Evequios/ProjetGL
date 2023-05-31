package gl.vetb;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PlusCourtCheminTests {

    @Test
    public void testDepartNullArriveeNull(){
        Station s1 = new Station("A", null, false, 0, 0, 0);
        Station s2 = new Station("B", null, false, 0, 0, 0);
        List<Station> stations = List.of(s1, s2);
        List<Itineraire> itineraires = List.of(new Itineraire(s1, s2, null, 10));
        var g = new Graphe(stations, itineraires);
        
        assertThatThrownBy(() -> g.algoPlusCourtChemin(null, null)).isExactlyInstanceOf(NullPointerException.class);

    }

    @Test
    public void testDureeDepartEqualsArrivee(){
        Station s1 = new Station("A", null, false, 0, 0, 0);
        List<Station> stations = List.of(s1);
        List<Itineraire> itineraires = List.of(new Itineraire(s1, s1, null, 10));
        var g = new Graphe(stations, itineraires);

        var result = g.algoPlusCourtChemin(s1, s1);
        assertEquals(result.getDuree(), 0);
    }

}
