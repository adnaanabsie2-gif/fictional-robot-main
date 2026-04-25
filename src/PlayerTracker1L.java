import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Kernel implementation of PlayerTracker using HashMap.
 */
public class PlayerTracker1L extends PlayerTrackerSecondary {

    /**
     * Representationma ps player name -> (stat then value)
     */
    private Map<String, Map<String, Integer>> rep;

    /**
     * Creates a new empty PlayerTracker.
     */
    public PlayerTracker1L() {
        this.rep = new HashMap<>();
    }

    @Override
    public void addPlayer(String playerName) {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("points", 0);
        stats.put("rebounds", 0);
        stats.put("assists", 0);
        stats.put("steals", 0);
        stats.put("blocks", 0);

        this.rep.put(playerName, stats);
    }

    @Override
    public void updateStat(String playerName, String stat, int value) {
        this.rep.get(playerName).put(stat, value);
    }

    @Override
    public int getStat(String playerName, String stat) {
        return this.rep.get(playerName).get(stat);
    }

    @Override
    public Set<String> allPlayers() {
        return this.rep.keySet();
    }

    @Override
    public void clear() {
        this.rep.clear();
    }

    @Override
    public PlayerTracker newInstance() {
        return new PlayerTracker1L();
    }

    @Override
    public void transferFrom(PlayerTracker source) {
        PlayerTracker1L localSource = (PlayerTracker1L) source;
        this.rep = localSource.rep;
        localSource.rep = new HashMap<>();
    }
}