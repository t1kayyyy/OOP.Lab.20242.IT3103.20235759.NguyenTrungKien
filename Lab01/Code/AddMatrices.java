import java.util.Scanner;
public class AddMatrices {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter size of matices m x n: ");
        System.out.print("m = ");
        int m = keyboard.nextInt();
        System.out.print("n = ");
        int n = keyboard.nextInt();

        int[][] Matx = new int[n][m];

        System.out.println("Enter first matrix: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                Matx[i][j] = keyboard.nextInt();
            };
        }

        System.out.println("Enter second matrix: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int tmp = keyboard.nextInt();
                Matx[i][j] += tmp;
            }
        }

        System.out.println("Sum of two matrices:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(Matx[i][j] + " ");
            }
            System.out.println();
        }

        keyboard.close();
    }
}