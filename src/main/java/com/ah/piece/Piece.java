package com.ah.piece;

import com.ah.board.Coordinate;
import com.ah.board.Square;

import java.util.Objects;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public abstract class Piece {
    private Type type;
    private Color color;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract boolean validateMove(Square[][] board, Coordinate from, Coordinate to);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return type == piece.type &&
                color == piece.color;
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, color);
    }
}
