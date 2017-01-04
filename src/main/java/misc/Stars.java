package misc;


public class Stars {
    public static void main(String[] args) {
        int x = 10;
        for (int i = 0; i < x; ++i){
            for (int j = i; j <= x+1; ++j){
                System.out.print("+ ");
            }
            System.out.println();
        }

    }
}
