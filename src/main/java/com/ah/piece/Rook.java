package com.ah.piece;

import com.ah.board.Coordinate;
import com.ah.board.Square;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class Rook extends Piece {

    public Rook(Color color) {
        this.setType(Type.ROOK);
        this.setColor(color);
    }

    @Override
    public boolean validateMove(Square[][] board, Coordinate from, Coordinate to) {
        if (from.getRow() == to.getRow() && from.getCol() != to.getCol()) {
            return true;
        }

        if (from.getCol() == to.getCol() && from.getRow() != to.getRow()) {
            return true;
        }

        return false;
    }
}
