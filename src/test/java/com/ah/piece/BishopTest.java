package com.ah.piece;

import com.ah.board.Board;
import com.ah.board.Coordinate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arlind Hoxha on 8/5/2018.
 */
public class BishopTest {

    private Board board;
    private Bishop wBishop;
    private Bishop bBishop;

    @Before
    public void setup() {
        board = new Board();
        wBishop = new Bishop(Color.WHITE);
        bBishop = new Bishop(Color.BLACK);

        board.getBoard()[6][3] = null;
        board.getBoard()[1][3] = null;
    }

    @Test
    public void testWhiteValidMove_ReturnsTrue() {
        Coordinate from = new Coordinate(7, 2);
        Coordinate to = new Coordinate(3, 6);

        assertTrue(wBishop.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testWhiteInvalidMove_ReturnsFalse() {
        Coordinate from = new Coordinate(7, 2);
        Coordinate to = new Coordinate(7, 6);

        assertFalse(wBishop.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testBlackValidMove_ReturnsTrue() {
        Coordinate from = new Coordinate(1, 2);
        Coordinate to = new Coordinate(5, 7);

        assertTrue(bBishop.validateMove(board.getBoard(), from, to));
    }

    @Test
    public void testBlackInvalidMove_ReturnsFalse() {
        Coordinate from = new Coordinate(1, 2);
        Coordinate to = new Coordinate(5, 2);

        assertFalse(bBishop.validateMove(board.getBoard(), from, to));
    }
}