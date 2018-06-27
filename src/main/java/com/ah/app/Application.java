package com.ah.app;

import com.ah.board.Board;
import com.ah.board.Coordinate;
import com.ah.piece.Color;
import com.ah.player.Player;

import java.util.Scanner;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Player 1's name: ");
        String wName = sc.nextLine();
        System.out.println("Player 2's name: ");
        String bName = sc.nextLine();
        Player wPlayer = new Player(Color.WHITE, wName);
        Player bPlayer = new Player(Color.BLACK, bName);

        Board board = new Board();

        boolean whiteMove = true;
        boolean checkmate = false;
        while (!checkmate) {
            board.printBoard();
            if (whiteMove) {
                System.out.println(wPlayer.getName() + "'s TURN!");
                System.out.println("Move: \n");
                String move = sc.nextLine().toLowerCase();

                String[] tokens = move.split(" ");
                String from = tokens[0];
                String to = tokens[1];
                String promotion = null;
                if (tokens.length == 3) {
                    promotion = tokens[2];
                }

                int fromRow = board.getBoard().length - Character.getNumericValue(from.charAt(1));
                int fromCol = from.charAt(0) - 97;
                Coordinate fromCoord = new Coordinate(fromRow, fromCol);

                int toRow = board.getBoard().length - Character.getNumericValue(to.charAt(1));
                int toCol = to.charAt(0) - 97;
                Coordinate toCoord = new Coordinate(toRow, toCol);

                boolean validMove = board.move(wPlayer, bPlayer, fromCoord, toCoord, promotion, whiteMove);

                if (!validMove) {
                    System.out.println("Invalid move! Please make a valid move.");
                } else {
                    whiteMove = false;
                }
            } else {
                System.out.println(bPlayer.getName() + "'s TURN!");
                System.out.println("Move: \n");
                String move = sc.nextLine().toLowerCase();

                String[] tokens = move.split(" ");
                String from = tokens[0];
                String to = tokens[1];
                String promotion = null;
                if (tokens.length == 3) {
                    promotion = tokens[2];
                }

                int fromRow = board.getBoard().length - Character.getNumericValue(from.charAt(1));
                int fromCol = from.charAt(0) - 97;
                Coordinate fromCoord = new Coordinate(fromRow, fromCol);

                int toRow = board.getBoard().length - Character.getNumericValue(to.charAt(1));
                int toCol = to.charAt(0) - 97;
                Coordinate toCoord = new Coordinate(toRow, toCol);

                boolean validMove = board.move(wPlayer, bPlayer, fromCoord, toCoord, promotion, whiteMove);

                if (!validMove) {
                    System.out.println("Invalid move! Please make a valid move.");
                } else {
                    whiteMove = true;
                }
            }
        }
    }
}
