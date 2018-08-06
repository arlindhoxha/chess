package com.ah.piece;

import com.ah.board.Board;
import com.ah.board.Coordinate;
import com.ah.board.Square;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arlind Hoxha on 8/5/2018.
 */
public class KnightTest {

    private Board board;
    private Knight wKnight;
    private Knight bKnight;

    @Before
    public void setup() {
        board = new Board();
        wKnight = new Knight(Color.WHITE);
        bKnight = new Knight(Color.BLACK);
    }

    @Test
    public void testValidWhiteMove_UpperLeftTop_ReturnTrue() {
        Coordinate from = new Coordinate(4, 2);
        Coordinate to = new Coordinate(2, 1);

        wKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidWhiteMove_UpperLeftBottom_ReturnsTrue() {
        Coordinate from = new Coordinate(4, 2);
        Coordinate to = new Coordinate(3, 0);

        wKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidWhiteMove_LowerLeftTop_ReturnTrue() {
        Coordinate from = new Coordinate(4, 2);
        Coordinate to = new Coordinate(5, 0);

        wKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidWhiteMove_LowerLeftBottom_ReturnsTrue() {
        Coordinate from = new Coordinate(4, 2);
        Coordinate to = new Coordinate(6, 1);

        wKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidWhiteMove_UpperRightTop_ReturnTrue() {
        Coordinate from = new Coordinate(4, 2);
        Coordinate to = new Coordinate(2, 3);

        wKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidWhiteMove_UpperRightBottom_ReturnsTrue() {
        Coordinate from = new Coordinate(4, 2);
        Coordinate to = new Coordinate(3, 4);

        wKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidWhiteMove_LowerRightTop_ReturnTrue() {
        Coordinate from = new Coordinate(4, 2);
        Coordinate to = new Coordinate(5, 4);

        wKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidWhiteMove_LowerRightBottom_ReturnsTrue() {
        Coordinate from = new Coordinate(4, 2);
        Coordinate to = new Coordinate(6, 3);

        wKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testInvalidWhiteMove_ReturnsFalse() {
        Coordinate from = new Coordinate(4, 2);
        Coordinate to = new Coordinate(5, 2);

        wKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidBlackMove_UpperLeftTop_ReturnTrue() {
        Coordinate from = new Coordinate(4, 5);
        Coordinate to = new Coordinate(2, 4);

        bKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidBlackMove_UpperLeftBottom_ReturnsTrue() {
        Coordinate from = new Coordinate(4, 5);
        Coordinate to = new Coordinate(3, 3);

        bKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidBlackMove_LowerLeftTop_ReturnTrue() {
        Coordinate from = new Coordinate(4, 5);
        Coordinate to = new Coordinate(5, 3);

        bKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidBlackMove_LowerLeftBottom_ReturnsTrue() {
        Coordinate from = new Coordinate(4, 5);
        Coordinate to = new Coordinate(6, 4);

        bKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidBlackMove_UpperRightTop_ReturnTrue() {
        Coordinate from = new Coordinate(4, 5);
        Coordinate to = new Coordinate(2, 6);

        bKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidBlackMove_UpperRightBottom_ReturnsTrue() {
        Coordinate from = new Coordinate(4, 5);
        Coordinate to = new Coordinate(3, 7);

        bKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidBlackMove_LowerRightTop_ReturnTrue() {
        Coordinate from = new Coordinate(4, 5);
        Coordinate to = new Coordinate(5, 7);

        bKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testValidBlackMove_LowerRightBottom_ReturnsTrue() {
        Coordinate from = new Coordinate(4, 5);
        Coordinate to = new Coordinate(6, 6);

        bKnight.validateMove(board.getBoard(), from, to);
    }

    @Test
    public void testInvalidBlackeMove_ReturnsFalse() {
        Coordinate from = new Coordinate(4, 5);
        Coordinate to = new Coordinate(5, 5);

        bKnight.validateMove(board.getBoard(), from, to);
    }
}