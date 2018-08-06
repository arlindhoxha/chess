package com.ah.piece;

import com.ah.board.Coordinate;
import com.ah.board.Square;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class King extends Piece {

    public King(Color color) {
        this.setType(Type.KING);
        this.setColor(color);
    }

    @Override
    public boolean validateMove(Square[][] board, Coordinate from, Coordinate to) {
        if ((from.getCol() - to.getCol() == 1 || to.getCol() - from.getCol() == 1) ||
                (from.getRow() - to.getRow() == 1 || to.getRow() - from.getRow() == 1)) {
            return true;
        }

        return false;
    }
}
