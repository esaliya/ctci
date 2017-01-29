package ctci.v6.ch1;

import java.util.Random;

/**
 * Saliya Ekanayake on 1/28/17.
 */
public class Q6 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[][] image = new int[N][N];
        initializeImage(N, image);
        printImage(N, image);
        rotateInPlaceByNinety(N, image);
        System.out.println();
        printImage(N, image);
    }

    private static void rotateInPlaceByNinety(int n, int[][] image){
//        for (int i = 0; i <= ((n%2 == 0) ? n/2 : ((n/2)+1)); ++i){
        for (int i = 0; i < n/2; ++i){
            for (int j = i; j < n-1-i; ++j){
                int temp = image[j][n-1-i];
                image[j][n-1-i] = image[i][j];
                int temp2 = image[n-1-i][n-1-j];
                image[n-1-i][n-1-j] = temp;
                temp = image[n-1-j][n-1-(n-1-i)];
                image[n-1-j][n-1-(n-1-i)] = temp2;
                image[i][j] = temp;
            }
        }
    }

    private static void initializeImage(int n, int[][] image) {
        Random rand = new Random();
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j){
                image[i][j] = rand.nextInt(n);
            }
        }
    }

    private static void printImage(int n, int[][] image){
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j){
                System.out.print(image[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
