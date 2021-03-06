package com.ah.board;

import com.ah.piece.*;
import com.ah.player.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class Board {
    private Square[][] board;
    private Map<Piece, Integer> whitePieces;
    private Map<Piece, Integer> blackPieces;

    public Board() {
        super();
        init();
    }

    public Square[][] getBoard() {
        return board;
    }

    public void setBoard(Square[][] board) {
        this.board = board;
    }

    public Map<Piece, Integer> getWhitePieces() {
        return whitePieces;
    }

    public void setWhitePieces(Map<Piece, Integer> whitePieces) {
        this.whitePieces = whitePieces;
    }

    public Map<Piece, Integer> getBlackPieces() {
        return blackPieces;
    }

    public void setBlackPieces(Map<Piece, Integer> blackPieces) {
        this.blackPieces = blackPieces;
    }

    public boolean move(Player wPlayer, Player bPlayer, Coordinate from, Coordinate to, String promotion, boolean isWhiteMove) {
        Square fromSquare = board[from.getRow()][from.getCol()];
        Square passantSquare = board[from.getRow()][to.getCol()];
        Square toSquare = board[to.getRow()][to.getCol()];

        if (fromSquare.getPiece().getColor() == Color.WHITE && !isWhiteMove) {
            return false;
        }

        if (fromSquare.getPiece().getColor() == Color.BLACK && isWhiteMove) {
            return false;
        }

        if (fromSquare == null) {
            return false;
        }

        boolean valid = fromSquare.getPiece().validateMove(board, from, to);
        if (valid) {
            Piece toPiece = null;
            Piece fromPiece = fromSquare.getPiece();

            if (passantSquare != null && toSquare == null) {
                Piece passantPiece = passantSquare.getPiece();

                if (passantPiece.getColor() == Color.WHITE && fromPiece.getColor() == Color.BLACK) {
                    board[from.getRow()][to.getCol()] = null;
                } else if (passantPiece.getColor() == Color.BLACK && fromPiece.getColor() == Color.WHITE) {
                    board[from.getRow()][to.getCol()] = null;
                }
            }

            if (fromPiece.getType() == Type.PAWN  && promotion != null) {
                //promotion
                if (fromPiece.getColor() == Color.WHITE && to.getRow() == 0) {
                    switch (promotion) {
                        case "q":
                            fromSquare.setPiece(new Queen(Color.WHITE));
                            break;
                        case "n":
                            fromSquare.setPiece(new Knight(Color.WHITE));
                            break;
                        case "r":
                            fromSquare.setPiece(new Rook(Color.WHITE));
                            break;
                        case "b":
                            fromSquare.setPiece(new Bishop(Color.WHITE));
                            break;
                        default:
                            return false;
                    }
                }

                if (fromPiece.getColor() == Color.BLACK && to.getRow() == 7) {
                    //promotion
                    switch (promotion) {
                        case "q":
                            fromSquare.setPiece(new Queen(Color.BLACK));
                            break;
                        case "n":
                            fromSquare.setPiece(new Knight(Color.BLACK));
                            break;
                        case "r":
                            fromSquare.setPiece(new Rook(Color.BLACK));
                            break;
                        case "b":
                            fromSquare.setPiece(new Bishop(Color.BLACK));
                            break;
                        default:
                            return false;
                    }
                }
            }

            if (toSquare != null) {
                toPiece = toSquare.getPiece();
            }

            if (toPiece != null) {
                if (toPiece.getColor() == fromPiece.getColor()) {
                    return false;
                }
            }

            board[to.getRow()][to.getCol()] = fromSquare;
            board[from.getRow()][from.getCol()] = null;
            return true;
        }

        return false;
    }

    public void printBoard() {
        System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH");
        for (int r = 0; r < board.length; r++) {
            System.out.print(board.length - r);
            for (int c = 0; c < board[0].length; c++) {
                String symbol = "#";
                Square square = board[r][c];

                if (square != null) {
                    Piece p = board[r][c].getPiece();
                    if (p.getColor() == Color.BLACK) {
                        switch (p.getType()) {
                            case ROOK:
                                symbol = "bR";
                                break;
                            case KNIGHT:
                                symbol = "bN";
                                break;
                            case BISHOP:
                                symbol = "bB";
                                break;
                            case KING:
                                symbol = "bK";
                                break;
                            case QUEEN:
                                symbol = "bQ";
                                break;
                            case PAWN:
                                symbol = "bP";
                                break;
                        }
                    } else {
                        switch (p.getType()) {
                            case ROOK:
                                symbol = "wR";
                                break;
                            case KNIGHT:
                                symbol = "wN";
                                break;
                            case BISHOP:
                                symbol = "wB";
                                break;
                            case KING:
                                symbol = "wK";
                                break;
                            case QUEEN:
                                symbol = "wQ";
                                break;
                            case PAWN:
                                symbol = "wP";
                                break;
                        }
                    }
                }
                System.out.print("\t" + symbol);
            }
            System.out.println();
        }
    }

    private void init() {
//        whitePieces = initPieces(whitePieces, Color.WHITE);
//        blackPieces = initPieces(blackPieces, Color.BLACK);
        board = new Square[8][8];

        setBlackPieces();
        setWhitePieces();
    }

    private Map<Piece, Integer> initPieces(Map<Piece, Integer> pieces, Color color) {
        pieces = new HashMap<Piece, Integer>();
        pieces.put(new King(color), 1);
        pieces.put(new Queen(color), 1);
        pieces.put(new Bishop(color), 2);
        pieces.put(new Knight(color), 2);
        pieces.put(new Rook(color), 2);
        pieces.put(new Pawn(color), 8);

        return pieces;
    }

    private void setBlackPieces() {
        Color color = Color.BLACK;
        board[0][0] = new Square(new Rook(color));
        board[0][1] = new Square(new Knight(color));
        board[0][2] = new Square(new Bishop(color));
        board[0][3] = new Square(new King(color));
        board[0][4] = new Square(new Queen(color));
        board[0][5] = new Square(new Bishop(color));
        board[0][6] = new Square(new Knight(color));
        board[0][7] = new Square(new Rook(color));

        for (int i = 0; i < board[0].length; i++) {
            board[1][i] = new Square(new Pawn(color));
        }
    }

    private void setWhitePieces() {
        Color color = Color.WHITE;
        board[7][0] = new Square(new Rook(color));
        board[7][1] = new Square(new Knight(color));
        board[7][2] = new Square(new Bishop(color));
        board[7][3] = new Square(new King(color));
        board[7][4] = new Square(new Queen(color));
        board[7][5] = new Square(new Bishop(color));
        board[7][6] = new Square(new Knight(color));
        board[7][7] = new Square(new Rook(color));

        for (int i = 0; i < board[0].length; i++) {
            board[6][i] = new Square(new Pawn(color));
        }
    }
}
