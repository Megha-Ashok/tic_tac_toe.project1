import java.util.Scanner;
import board.Board;
import game.Game;
import player.Player;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("First Project -> tic toc toe");
        Board b = new Board(4, '-');
        Player p1[] = new Player[2];
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the first player name and Symbol");
        String name1 = obj.nextLine();
        char symbol1 = obj.next().charAt(0);
        p1[0] = new Player();
        p1[0].setNameandSymbol(name1, symbol1);
        p1[0].getnameandsymbol();
        System.out.println("Enter the Second player name");
        String name2 = obj.next();
        System.out.println("Symbol is:");
        char symbol2 = obj.next().charAt(0);
        p1[1] = new Player();
        p1[1].setNameandSymbol(name2, symbol2);
        p1[1].getnameandsymbol();
        Game g = new Game(p1, b);
        g.play();

    }

}
