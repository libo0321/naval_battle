
import java.util.ArrayList;
import java.util.List;


public class TestBoard{
    public static void main(String [] args) {
        Board board = new Board("Test",11,12);
        board.print();
        System.out.println(board.getLength());
        System.out.println(board.getWidth());
        System.out.println(board.getName());
    }
}