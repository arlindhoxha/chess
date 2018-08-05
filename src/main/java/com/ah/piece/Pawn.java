package com.ah.piece;

import com.ah.board.Coordinate;
import com.ah.board.Square;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class Pawn extends Piece {

    public Pawn(Color color) {
        this.setType(Type.PAWN);
        this.setColor(color);
    }

    public boolean validateMove(Square[][] board, Coordinate from, Coordinate to) {
        boolean valid = false;

        if (from.getRow() == to.getRow()) {
            return false;
        }

        if (from.getCol() - to.getCol() > 1 || to.getCol() - from.getCol() > 1) {
            return false;
        }

        if (getColor() == Color.WHITE) {
            valid = checkWhite(board, from, to);
        }

        if (getColor() == Color.BLACK) {
            valid = checkBlack(board, from, to);
        }

        return valid;
    }

    private boolean checkWhite(Square[][] board, Coordinate from, Coordinate to) {
        if (from.getRow() == 6 && from.getCol() == to.getCol() && (from.getRow() - to.getRow() == 2)) {
            int c = from.getCol();
            for (int r = from.getRow() - 1; r >= to.getRow(); r--) {
                if (board[r][c] != null) {
                    return false;
                }
            }
        } else if (from.getCol() == to.getCol()) {
            if (board[to.getRow()][to.getCol()] != null) {
                return false;
            }
        }

        if (from.getCol() != to.getCol()) {
            return checkDiagonal(board, from, to);
        }

        return true;
    }

    private boolean checkBlack(Square[][] board, Coordinate from, Coordinate to) {
        if (from.getRow() == 1 && from.getCol() == to.getCol() && (to.getRow() - from.getRow() == 2)) {
            int c = from.getCol();
            for (int r = to.getRow(); r > from.getRow(); r--) {
                if (board[r][c] != null) {
                    return false;
                }
            }
        } else if (from.getCol() == to.getCol()) {
            if (board[to.getRow()][to.getCol()] != null) {
                return false;
            }
        }

        if (from.getCol() != to.getCol()) {
            return checkDiagonal(board, from, to);
        }

        return true;
    }

    private boolean checkDiagonal(Square[][] board, Coordinate from, Coordinate to) {
        if (to.getRow() - from.getRow() > 1) {
            return false;
        }

        if (board[to.getRow()][to.getCol()] == null && board[from.getRow()][to.getCol()] == null) {
            return false;
        }

        return true;
    }
}
