public abstract class PlayerTrackerSecondary implements PlayerTracker {

    @Override
    public double avgStat(String stat) {
        int total = 0;
        int count = 0;
        for (String player : this.allPlayers()) {
            total += this.getStat(player, stat);
            count++;
        }
        double result = 0.0;
        if (count > 0) {
            result = (double) total / count;
        }

        return result;
    }

    @Override
    public String highestPlayer(String stat) {
        String bestPlayer = "";
        int bestValue = -1;
        for (String player : this.allPlayers()) {
            int value = this.getStat(player, stat);
            if (value > bestValue) {
                bestValue = value;
                bestPlayer = player;
            }
        }
        return bestPlayer;
    }

    @Override
    public String toString() {
        String result = "";

        for (String player : this.allPlayers()) {
            result = result + player + ": " + "points="
                    + this.getStat(player, "points") + ", " + "rebounds="
                    + this.getStat(player, "rebounds") + ", " + "assists="
                    + this.getStat(player, "assists") + ", " + "steals="
                    + this.getStat(player, "steals") + ", " + "blocks="
                    + this.getStat(player, "blocks") + "\n";
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof PlayerTracker) {
            PlayerTracker other = (PlayerTracker) obj;
            result = this.allPlayers().size() == other.allPlayers().size();
            for (String player : this.allPlayers()) {
                if (!other.allPlayers().contains(player)
                        || this.getStat(player, "points") != other
                                .getStat(player, "points")
                        || this.getStat(player, "rebounds") != other
                                .getStat(player, "rebounds")
                        || this.getStat(player, "assists") != other
                                .getStat(player, "assists")
                        || this.getStat(player, "steals") != other
                                .getStat(player, "steals")
                        || this.getStat(player, "blocks") != other
                                .getStat(player, "blocks")) {
                    result = false;
                }
            }
        }

        return result;
    }
}
