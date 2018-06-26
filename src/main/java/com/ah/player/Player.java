package com.ah.player;

import com.ah.piece.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class Player {

    private Color color;
    private String name;
    private Map<Piece,Integer> pieces;

    public Player(Color color) {
        this.color = color;
        initPieces();
    }

    public Player(Color color, String name) {
        this.name = name;
        this.color = color;
        initPieces();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Piece, Integer> getPieces() {
        return pieces;
    }

    public void setPieces(Map<Piece, Integer> pieces) {
        this.pieces = pieces;
    }

    private void initPieces() {
        pieces = new HashMap<Piece, Integer>();
        pieces.put(new King(color), 1);
        pieces.put(new Queen(color), 1);
        pieces.put(new Bishop(color), 2);
        pieces.put(new Knight(color), 2);
        pieces.put(new Rook(color), 2);
        pieces.put(new Pawn(color), 8);
    }
}
