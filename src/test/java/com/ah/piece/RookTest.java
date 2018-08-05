package com.ah.piece;

import com.ah.board.Board;
import com.ah.board.Coordinate;
import com.ah.board.Square;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arlind Hoxha on 8/4/2018.
 */
public class RookTest {

    private Board board;
    private Rook bRook;
    private Rook wRook;

    @Before
    public void setup() {
        board = new Board();
        wRook = new Rook(Color.WHITE);
        bRook = new Rook(Color.BLACK);

        board.getBoard()[5][3] = new Square(new Rook(Color.WHITE));
        board.getBoard()[3][6] = new Square(new Rook(Color.WHITE));
    }

    @Test
    public void testHorizontalValidWhiteMove_ReturnsTrue() {
        Coordinate from = new Coordinate(5, 3);
        Coordinate to = new Coordinate(3, 3);

        assertTrue(wRook.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testVerticalValidWhiteMove_ReturnsTrue() {
        Coordinate from = new Coordinate(5, 3);
        Coordinate to = new Coordinate(5, 7);

        assertTrue(wRook.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testInvalidWhiteMove_ReturnsFalse() {
        Coordinate from = new Coordinate(5, 3);
        Coordinate to = new Coordinate(4, 7);

        assertFalse(wRook.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testHorizontalValidBlackMove_ReturnsTrue() {
        Coordinate from = new Coordinate(3, 6);
        Coordinate to = new Coordinate(5, 6);

        assertTrue(bRook.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testVerticalValidBlackMove_ReturnsTrue() {
        Coordinate from = new Coordinate(3, 6);
        Coordinate to = new Coordinate(3, 0);

        assertTrue(bRook.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testInvalidBlackMove_ReturnsFalse() {
        Coordinate from = new Coordinate(3, 6);
        Coordinate to = new Coordinate(4, 5);

        assertFalse(bRook.validateMove(board.getBoard(), from, to));
    }

}