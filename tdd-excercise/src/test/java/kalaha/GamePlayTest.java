package kalaha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GamePlayTest {

    private GamePlay gamePlay;

    @BeforeEach
    void setup() {
        this.gamePlay = new GamePlay();
    }

    @Test
    void gameShouldHaveTwoPlayerOneAsActiveOnStart() {
        assertThat(gamePlay.activePlayer()).isEqualTo(1);
    }

    @Test
    void changeTurnShouldGiveAnotherPlayer() {
        gamePlay.changeTurn();
        assertThat(gamePlay.activePlayer()).isEqualTo(2);
        assertThat(gamePlay.activePlayer()).isNotEqualTo(1);

        gamePlay.changeTurn();
        assertThat(gamePlay.activePlayer()).isEqualTo(1);
        assertThat(gamePlay.activePlayer()).isNotEqualTo(2);
    }

    @Test
    void pitShouldBeEmptyFromWhichTheSowStart() {
        assertThat(gamePlay.selectedPitCount()).isZero();
    }

    @Test
    void activePlayerShouldSowAllMarbleToTheRightPits() {
        gamePlay.playFromPit(1);
        assertThat(gamePlay.getPlayerBoard(1).getMarbles(1)).isZero();
        assertThat(gamePlay.getPlayerBoard(1).getMarbles(2)).isEqualTo(7);
        assertThat(gamePlay.getPlayerBoard(1).getMarbles(3)).isEqualTo(7);
        assertThat(gamePlay.getPlayerBoard(1).getMarbles(4)).isEqualTo(7);
        assertThat(gamePlay.getPlayerBoard(1).getMarbles(5)).isEqualTo(7);
        assertThat(gamePlay.getPlayerBoard(1).getMarbles(6)).isEqualTo(7);
        assertThat(gamePlay.getPlayerBoard(1).getBankCount(1)).isEqualTo(1);
    }

}
