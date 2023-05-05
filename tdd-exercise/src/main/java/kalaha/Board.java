package kalaha;

import java.util.Arrays;

public class Board {
    private final PlayerSet[] playerSets;

    public Board() {
        this.playerSets = new PlayerSet[2];
        this.playerSets[0] = new PlayerSet();
        this.playerSets[1] = new PlayerSet();
    }

    public int getNumberOfPits() {
        return this.playerSets.length * this.playerSets[0].numberOfPits();
    }

    public int getMarbles(int pitId) {
        if (pitId <= 6 && pitId >= 1) {
            return this.playerSets[0].marbleCount(pitId - 1);
        }
        return this.playerSets[1].marbleCount(pitId - 6 - 1);
    }

    public int getBankCount(int bankId) {
        return this.playerSets[bankId - 1].bank;
    }

    public void depositMarble(int pitId) {
        if (pitId >= 1 && pitId <= 6) {
            this.playerSets[0].incrementMarble(pitId - 1);
            return;
        }
        this.playerSets[1].incrementMarble(pitId - 6 - 1);
    }

    public void depositInBank(int bankId) {
        this.playerSets[bankId - 1].bank++;
    }

    public int getNumberOfBanks() {
        return 2;
    }

    public PlayerSet getPlayerSet(int activePlayer) {
        return this.playerSets[activePlayer - 1];
    }

    public int nextPit(int activePit) {
        if (activePit == 12) {
            return 1;
        }
        return activePit + 1;
    }

    public void emptyPit(int pitId) {
        if (pitId <= 6 && pitId >= 1) {
            this.playerSets[0].setMarbleCountToZero(pitId - 1);
            return;
        }
        this.playerSets[1].setMarbleCountToZero(pitId - 6 - 1);
    }

    public boolean isActivePitBank(int activePit) {
        return activePit == 7 || activePit == 14;
    }

    public static final class PlayerSet {
        private final int[] pits;
        private int bank;

        private PlayerSet() {
            this.pits = new int[6];
            this.bank = 0;
            initialMarbleCountInPits();
        }

        private void initialMarbleCountInPits() {
            Arrays.fill(this.pits, 6);
        }

        private int numberOfPits() {
            return this.pits.length;
        }

        private void incrementMarble(int pitId) {
            this.pits[pitId]++;
        }

        public int marbleCount(int pitId) {
            return this.pits[pitId];
        }

        public void setMarbleCountToZero(int pitId) {
            this.pits[pitId] = 0;
        }
    }
}
