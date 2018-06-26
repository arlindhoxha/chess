package com.ah.piece;

import com.ah.board.Coordinate;
import com.ah.board.Square;
import com.ah.board.ValidateMoveResult;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class Pawn extends Piece {

    public Pawn(Color color) {
        this.setType(Type.PAWN);
        this.setColor(color);
        this.setTwoSquares(false);
    }

    public ValidateMoveResult validateMove(Square[][] board, Coordinate from, Coordinate to) {
        if (from.getRow() == to.getRow()) {
            return new ValidateMoveResult(false, false);
        }

        if (from.getCol() - to.getCol() > 1 || to.getCol() - from.getCol() > 1) {
            return new ValidateMoveResult(false, false);
        }

        if (getColor() == Color.WHITE) {
            if (from.getRow() == 6 && from.getCol() == to.getCol()) {
                if (from.getRow() - to.getRow() < 3) {
                    int c = from.getCol();
                    for (int r = from.getRow() - 1; r > to.getRow(); r--) {
                        if (board[r][c] != null) {
                            return new ValidateMoveResult(false, false);
                        }
                    }
                }
            } else if (from.getCol() != to.getCol()) {
                if (from.getRow() - to.getRow() > 1) {
                    return new ValidateMoveResult(false, false);
                }

                if (board[to.getRow()][to.getCol()] == null && (board[from.getRow()][to.getCol()].getPiece() != null && board[from.getRow()][to.getCol()].getPiece().isTwoSquares())) {
                    return new ValidateMoveResult(true, true);
                } else {
                    return new ValidateMoveResult(false, false);
                }
            }
        }

        if (getColor() == Color.BLACK) {
            if (from.getRow() == 1 && from.getCol() == to.getCol()) {
                if (to.getRow() - from.getRow() < 3) {
                    int c = from.getCol();
                    for (int r = to.getRow() + 1; r > from.getRow(); r--) {
                        if (board[r][c] != null) {
                            return new ValidateMoveResult(false, false);
                        }
                    }
                }
            } else if (from.getCol() != to.getCol()) {
                if (to.getRow() - from.getRow() > 1) {
                    return new ValidateMoveResult(false, false);
                }

                if (board[to.getRow()][to.getCol()] == null && (board[from.getRow()][to.getCol()].getPiece() != null && board[from.getRow()][to.getCol()].getPiece().isTwoSquares())) {
                    return new ValidateMoveResult(true, true);
                } else {
                    return new ValidateMoveResult(false, false);
                }
            }
        }

        return new ValidateMoveResult(true, false);
    }
}
