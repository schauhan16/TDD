package kalaha;

public class GamePlay {
    private int activePlayer;
    private final Board board;

    public GamePlay() {
        this.activePlayer = 1;
        this.board = new Board();
    }

    public int selectedPitCount() {
        return 0;
    }

    public void changeTurn() {
        this.activePlayer = this.activePlayer == 1 ? 2 : 1;
    }

    public int activePlayer() {
        return this.activePlayer;
    }

    public void playFromPit(int selectedPitId) {
        int marblesCountInSelectedPit = this.board.getMarbles(selectedPitId);
        this.board.emptyPit(selectedPitId);
        int activePit = this.board.nextPit(selectedPitId);
        while (marblesCountInSelectedPit > 0) {
            if (this.board.isActivePitBank(activePit)) {
                this.board.depositInBank(this.activePlayer);
            } else {
                this.board.depositMarble(activePit);
            }
            activePit = this.board.nextPit(activePit);
            marblesCountInSelectedPit--;
        }
    }

    public Board getPlayerBoard(int playerId) {
        return this.board;
    }
}
