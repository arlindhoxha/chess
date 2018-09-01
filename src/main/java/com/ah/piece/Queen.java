package com.ah.piece;

import com.ah.board.Coordinate;
import com.ah.board.Square;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class Queen extends Piece {

    public Queen(Color color) {
        this.setType(Type.QUEEN);
        this.setColor(color);
    }

    @Override
    public boolean validateMove(Square[][] board, Coordinate from, Coordinate to) {
        //Queen can do pretty much any move she wants, as long as it's in a line

        if (from.getCol() == to.getCol()) {
            return true;
        }

        if (from.getRow() == to.getRow()) {
            return true;
        }

        int rowDiff = Math.abs(from.getRow()-to.getRow());
        int colDiff = Math.abs(from.getCol()-to.getCol());

        if (rowDiff - colDiff == 0) {
            return true;
        }

        return false;
    }
}
