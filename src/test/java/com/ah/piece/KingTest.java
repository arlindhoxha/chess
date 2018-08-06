package com.ah.piece;

import com.ah.board.Board;
import com.ah.board.Coordinate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arlind Hoxha on 8/5/2018.
 */
public class KingTest {

    private Board board;
    private King wKing;
    private King bKing;

    @Before
    public void setup() {
        board = new Board();
        wKing = new King(Color.WHITE);
        bKing = new King(Color.BLACK);
    }

    @Test
    public void testWhiteForwardValidMove_ReturnsTrue() {
        Coordinate from = new Coordinate(7, 3);
        Coordinate to = new Coordinate(6, 3);

        assertTrue(wKing.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testWhiteBackwardValidMove_ReturnsTrue() {
        Coordinate from = new Coordinate(6, 3);
        Coordinate to = new Coordinate(7, 3);

        assertTrue(wKing.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testWhiteDiagonalValidMove_ReturnsTrue() {
        Coordinate from = new Coordinate(7, 3);
        Coordinate to = new Coordinate(6, 4);

        assertTrue(wKing.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testWhiteInvalidMove_ReturnsFalse() {
        Coordinate from = new Coordinate(7, 3);
        Coordinate to = new Coordinate(5, 3);

        assertFalse(wKing.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testBlackForwardValidMove_ReturnsTrue() {
        Coordinate from = new Coordinate(0, 3);
        Coordinate to = new Coordinate(1, 3);

        assertTrue(bKing.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testBlackBackwardValidMove_ReturnsTrue() {
        Coordinate from = new Coordinate(1, 3);
        Coordinate to = new Coordinate(0, 3);

        assertTrue(bKing.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testBlackDiagonalValidMove_ReturnsTrue() {
        Coordinate from = new Coordinate(0, 3);
        Coordinate to = new Coordinate(1, 4);

        assertTrue(bKing.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testBlackInvalidMove_ReturnsFalse() {
        Coordinate from = new Coordinate(0, 3);
        Coordinate to = new Coordinate(2, 3);

        assertFalse(bKing.validateMove(board.getBoard(), from, to));
    }
}