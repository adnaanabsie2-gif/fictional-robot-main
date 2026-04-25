import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTracker1LTest {

    @Test
    public void testAddPlayerAndGetStat() {
        PlayerTracker t = new PlayerTracker1L();

        t.addPlayer("LeBron James");

        assertEquals(0, t.getStat("LeBron James", "points"));
        assertEquals(0, t.getStat("LeBron James", "rebounds"));
    }

    @Test
    public void testUpdateStat() {
        PlayerTracker t = new PlayerTracker1L();

        t.addPlayer("Curry");
        t.updateStat("Curry", "points", 30);

        assertEquals(30, t.getStat("Curry", "points"));
    }

    @Test
    public void testAllPlayers() {
        PlayerTracker t = new PlayerTracker1L();

        t.addPlayer("A");
        t.addPlayer("B");

        assertEquals(2, t.allPlayers().size());
    }

    @Test
    public void testAvgStat() {
        PlayerTracker t = new PlayerTracker1L();

        t.addPlayer("A");
        t.addPlayer("B");

        t.updateStat("A", "points", 10);
        t.updateStat("B", "points", 20);

        assertEquals(15.0, t.avgStat("points"), 0.01);
    }
}