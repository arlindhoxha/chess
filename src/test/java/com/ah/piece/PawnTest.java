package com.ah.piece;

import com.ah.board.Board;
import com.ah.board.Coordinate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class PawnTest {

    private Board board;

    private Pawn bPawn;
    private Pawn wPawn;

    @Before
    public void setup() {
        board = new Board();
        wPawn = new Pawn(Color.WHITE);
        bPawn = new Pawn(Color.BLACK);
    }

    @Test
    public void testFirstMoveWhite_ReturnsTrue() {
        Coordinate from = new Coordinate(6,1);
        Coordinate to = new Coordinate(4, 1);

        assertTrue(wPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testFirstMoveWhite_SameRow_ReturnsFalse() {
        Coordinate from = new Coordinate(6,1);
        Coordinate to = new Coordinate(6, 1);

        assertFalse(wPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testNonFirstMoveWhite_ReturnsTrue() {
        Coordinate from = new Coordinate(5, 2);
        Coordinate to = new Coordinate(4, 2);

        assertTrue(wPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testBadRowInputOnDiagonalWhite_ReturnsFalse() {
        Coordinate from = new Coordinate(5, 2);
        Coordinate to = new Coordinate(3, 3);

        assertFalse(wPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testLeftDiagonalWhite_ReturnsTrue() {
        Coordinate from = new Coordinate(6, 3);
        Coordinate to = new Coordinate(5, 2);

        assertTrue(wPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testRightDiagonalWhite_ReturnsTrue() {
        Coordinate from = new Coordinate(6, 3);
        Coordinate to = new Coordinate(5, 4);

        assertTrue(wPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testIllegalLeftFarDiagonalWhite_ReturnsFalse() {
        Coordinate from = new Coordinate(6, 3);
        Coordinate to = new Coordinate(5, 1);

        assertFalse(wPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testIllegalRightFarDiagonalWhite_ReturnsFalse() {
        Coordinate from = new Coordinate(6, 3);
        Coordinate to = new Coordinate(5, 5);

        assertFalse(wPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testFirstMoveBlack_ReturnsTrue() {
        Coordinate from = new Coordinate(1,1);
        Coordinate to = new Coordinate(3, 1);

        assertTrue(bPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testFirstMoveBlack_SameRow_ReturnsFalse() {
        Coordinate from = new Coordinate(6,1);
        Coordinate to = new Coordinate(6, 1);

        assertFalse(bPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testNonFirstMoveBlack_ReturnsTrue() {
        Coordinate from = new Coordinate(2, 2);
        Coordinate to = new Coordinate(3, 2);

        assertTrue(bPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testBadRowInputOnDiagonalBlack_ReturnsFalse() {
        Coordinate from = new Coordinate(2, 2);
        Coordinate to = new Coordinate(4, 3);

        assertFalse(bPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testLeftDiagonalBlack_ReturnsTrue() {
        Coordinate from = new Coordinate(1, 3);
        Coordinate to = new Coordinate(2, 2);

        assertTrue(bPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testRightDiagonalBlack_ReturnsTrue() {
        Coordinate from = new Coordinate(1, 3);
        Coordinate to = new Coordinate(2, 4);

        assertTrue(bPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testIllegalLeftFarDiagonalBlack_ReturnsFalse() {
        Coordinate from = new Coordinate(1, 3);
        Coordinate to = new Coordinate(2, 1);

        assertFalse(bPawn.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testIllegalRightFarDiagonalBlack_ReturnsFalse() {
        Coordinate from = new Coordinate(1, 3);
        Coordinate to = new Coordinate(2, 5);

        assertFalse(bPawn.validateMove(board.getBoard(), from, to));
    }


}