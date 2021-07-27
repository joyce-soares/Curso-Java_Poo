package aplicattion;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++){
                if(mat[i][j] == x){
                    System.out.printf("Position %d, %d:\n", i, j);
                    if(i > 0) {
                        System.out.printf("Left: %d\n", mat[i][j - 1]);
                    }
                    if(j < mat[i].length - 1) {
                        System.out.printf("Right: %d\n", mat[i][j + 1]);
                    }
                    if(i > 0) {
                        System.out.printf("Up: %d\n", mat[i - 1][j]);
                    }
                    if(i < mat.length) {
                        System.out.printf("Down: %d\n", mat[i + 1][j]);
                    }
                }
            }
        }



        sc.close();
    }
}
