import java.util.Arrays;
import java.util.Scanner;
public class NumericArray {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Size of Array Numbers: ");
        int n = keyboard.nextInt();
        int[] arr = new int[n];
        int sum = 0;

        System.out.print("Enter Array Numbers: ");
        for(int i = 0; i < n; i++){
           arr[i] = keyboard.nextInt();
           sum += arr[i]; 
        }

        double aver = (double)sum / n;

        Arrays.sort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.printf("Average value: %.2f", aver);

        keyboard.close();
    }
}