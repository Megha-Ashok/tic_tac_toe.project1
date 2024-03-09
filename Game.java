package game;

import java.util.Scanner;

import board.Board;
import player.Player;

public class Game {
    Board board;
    Player players[];
    int turn;
    boolean gameover;
    int noOfMoves;
    String zero;
    String cross;
    Scanner obj = new Scanner(System.in);

    public Game(Player players[], Board board) {
        this.players = players;
        this.board = board;
        this.turn = 0;
        this.gameover = false;
        this.noOfMoves = 0;
        StringBuilder z = new StringBuilder();
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < board.size; i++) {
            z.append('0');
            x.append('x');
        }
        this.zero = z.toString();
        this.cross = x.toString();
    }

    public void printmatrix() {
        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j++) {
                System.out.print(board.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void play() {
        printmatrix();
        int sz = board.size;
        while (!gameover) {
            noOfMoves++;
            int idx = getIndex();
            int row = idx / sz;
            int col = idx % sz;
            board.matrix[row][col] = players[turn].getSymbol();
            if (noOfMoves >= sz * sz) {
                board.printmatrix();
                System.out.println("Game Draw");
                return;
            }
            if (noOfMoves >= 2 * sz - 1 && checkcombination() == true) {
                gameover = true;
                printmatrix();
                System.out.println("Winner is :" + players[turn].getName());
                return;
            }
            turn = (turn + 1) % 2;
            printmatrix();
        }
    }

    public int getIndex() {
        while (true) {
            System.out.println("player:" + players[turn].getName() + " give position");
            int pos = obj.nextInt() - 1;
            int sz = board.size;
            int row = pos / sz;
            int col = pos % sz;
            if (row < 0 || row >= sz || col < 0 || col >= sz) {
                System.out.println("invalid position");
                continue;
            }
            if (board.matrix[row][col] != '-') {
                System.out.println("position is already occupy");
                continue;
            }
            return pos;
        }
    }

    public boolean checkcombination() {
        int sz = board.size;
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                sb.append(board.matrix[i][j]);
            }
            String pattern = sb.toString();
            if (pattern.equals(zero) || pattern.equals(cross)) {
                return true;
            }
        }
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                sb.append(board.matrix[j][i]);
            }
            String pattern = sb.toString();
            if (pattern.equals(zero) || pattern.equals(cross)) {
                return true;
            }
        }
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < sz) {
            sb.append(board.matrix[i][j]);
            i++;
            j++;
        }
        String pattern = sb.toString();
        if (pattern.equals(zero) || pattern.equals(cross)) {
            return true;
        }
        i = 0;
        j = sz - 1;
        while (i < sz) {
            sb.append(board.matrix[i][j]);
            i++;
            j--;
        }
        pattern = sb.toString();
        if (pattern.equals(zero) || pattern.equals(cross)) {
            return true;
        }
        return false;
    }

}
