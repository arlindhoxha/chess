package com.ah.board;

import com.ah.piece.Piece;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class Square {
    private Piece piece;

    public Square(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
