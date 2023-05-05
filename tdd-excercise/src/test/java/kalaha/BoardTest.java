package kalaha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        this.board = new Board();
    }

    @Test
    void boardShouldHave12Pits() {
        assertThat(board.getNumberOfPits()).isEqualTo(12);
    }

    @Test
    void boardShouldHave2Banks() {
        assertThat(board.getNumberOfBanks()).isEqualTo(2);
    }

    @Test
    void allPitsShouldHave6MarbleOnInitialization() {
        IntStream.rangeClosed(1, board.getNumberOfPits())
                .forEach(pitId -> assertThat(board.getMarbles(pitId)).isEqualTo(6));
    }

    @Test
    void bothBankShouldHaveZeroMarbleOnInitialization() {
        assertThat(board.getBankCount(1)).isZero();
        assertThat(board.getBankCount(2)).isZero();
    }

    @Test
    void addingMarbleToPitShouldIncreaseTheCount() {
        board.depositMarble(2);
        assertThat(board.getMarbles(2)).isEqualTo(7);

        board.depositMarble(12);
        assertThat(board.getMarbles(2)).isEqualTo(7);
    }

    @Test
    void addingMarbleToBankShouldIncreaseTheCount() {
        board.depositInBank(1);
        assertThat(board.getBankCount(1)).isEqualTo(1);

        board.depositInBank(2);
        assertThat(board.getBankCount(2)).isEqualTo(1);
    }

    @Test
    void nextPitShouldReturnThePitIdToItsRight() {
        assertThat(board.nextPit(1)).isEqualTo(2);
        assertThat(board.nextPit(12)).isEqualTo(1);
    }

    @Test
    void emptyPitShouldReturnZeroMarbles() {
        board.emptyPit(1);
        assertThat(board.getMarbles(1)).isZero();
    }

    @Test
    void testIsActiveBank() {
        assertThat(board.isActivePitBank(1)).isFalse();
        assertThat(board.isActivePitBank(7)).isTrue();
        assertThat(board.isActivePitBank(11)).isFalse();
        assertThat(board.isActivePitBank(14)).isTrue();
    }
}
