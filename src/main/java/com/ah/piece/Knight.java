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
        return false;
    }
}
