
public class Board{
    private String name;
    private char[][] navires;
    private boolean[][] frappes;
    private int length;
    private int width;

    public Board(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
        navires = new char[length][width];
        for (int i=0; i< length; i++)
            for (int j=0; j<width; j++)
                navires[i][j] = '.';

        frappes = new boolean[length][width];
        for (int i=0; i< length; i++)
            for (int j=0; j<width; j++)
                frappes[i][j] = false;
    }

    public Board(String name){
        this(name, 10, 10);
    }

    public void print(){
        char begin_letter='A';
        System.out.println("Navires : " );
        System.out.print("  ");
        for (int i=(int)begin_letter; i<(int)begin_letter+length; i++){
            System.out.print(" "+(char)i);
        }
        System.out.print("\n");
        for (int j = 1; j<=width; j++){
            System.out.print(j);
            System.out.print(" ");
            for (int i = 0; i < length; i++){
                System.out.print(". ");
            }
            System.out.print("\n");
        }
        System.out.println("Frappes : " );
        System.out.print("  ");
        for (int i=(int)begin_letter; i<(int)begin_letter+length; i++){
            System.out.print(" "+(char)i);
        }
        System.out.print("\n");
        for (int j = 1; j<=width; j++){
            System.out.print(j);
            System.out.print(" ");
            for (int i = 0; i < length; i++){
                if (frappes[i][j-1])
                    System.out.print("x ");
                else System.out.print(". ");
            }
            System.out.print("\n");
        }
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setMName(String name) {
        this.name = name;
    }

}
