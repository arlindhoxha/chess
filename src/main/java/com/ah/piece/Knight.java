package com.ah.piece;

import com.ah.board.Coordinate;
import com.ah.board.Square;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class Knight extends Piece {

    public Knight(Color color) {
        this.setType(Type.KNIGHT);
        this.setColor(color);
    }

    @Override
    public boolean validateMove(Square[][] board, Coordinate from, Coordinate to) {
        if ((from.getRow() - to.getRow() == 1 || to.getRow() - from.getRow() == 1) &&
                (from.getCol() - to.getCol() == 2 || to.getCol() - from.getCol() == 2)) {
            return true;
        }

        if ((from.getRow() - to.getRow() == 2 || to.getRow() - from.getRow() == 2) &&
                (from.getCol() - to.getCol() == 1 || to.getCol() - from.getCol() == 1)) {
            return true;
        }

        return false;
    }
}
