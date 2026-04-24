import components.standard.Standard;

/**
 * Enhanced interface for PlayerTracker.
 * Provides additional functionality for analyzing player statistics.
 */
public interface PlayerTracker extends PlayerTrackerKernel {

    /**
     * Computes the average value of a given stat across all players.
     *
     * @param stat the stat to average
     * @return the average value of the stat
     * @requires at least one player exists
     * @ensures returns average of the stat across all players
     */
    double avgStat(String stat);

    /**
     * Finds the player with the highest value for a given stat.
     *
     * @param stat the stat to check
     * @return the name of the player with the highest value
     * @requires at least one player exists
     * @ensures returns player with maximum stat value
     */
    String highestPlayer(String stat);
}