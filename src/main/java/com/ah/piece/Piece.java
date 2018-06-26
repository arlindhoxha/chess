package com.ah.piece;

import com.ah.board.Coordinate;
import com.ah.board.Square;
import com.ah.board.ValidateMoveResult;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public abstract class Piece {
    private Type type;
    private Color color;
    private boolean twoSquares;

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

    public boolean isTwoSquares() {
        return twoSquares;
    }

    public void setTwoSquares(boolean twoSquares) {
        this.twoSquares = twoSquares;
    }

    public abstract ValidateMoveResult validateMove(Square[][] board, Coordinate from, Coordinate to);
}
