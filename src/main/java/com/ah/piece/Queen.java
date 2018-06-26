package com.ah.piece;

import com.ah.board.Board;
import com.ah.board.Coordinate;
import com.ah.board.Square;
import com.ah.board.ValidateMoveResult;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class Queen extends Piece {

    public Queen(Color color) {
        this.setType(Type.QUEEN);
        this.setColor(color);
    }

    @Override
    public ValidateMoveResult validateMove(Square[][] board, Coordinate from, Coordinate to) {
        return null;
    }
}