package labs.task1;

import java.lang.System;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1");

        int sum1 = 0, sum2 = 0, sum3 = 0, inputI = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        if(sc.hasNextInt()) {
            inputI =sc.nextInt();

            for (int i =1; i <= inputI;i++){
                System.out.print(i + ": ");
                sum1 += sc.nextInt();
            }
            int j = inputI;
            while (j!=0) {
                System.out.print(inputI-j+1 + ": ");
                sum2 += sc.nextInt();
                j--;
            }
            int k = inputI;
            do {
                System.out.print(inputI-k+1 + ": ");
                sum3 += sc.nextInt();
                k--;
            } while (k!= 0);
            System.out.println("The sum is:"
            + "\n(For Loop):" + sum1
            + "\n(While Loop):"+ sum2
            + "\n(Do While Loop):" + sum3);
        } else {
            System.out.println("You didn't enter a number :<(");
        }

        System.out.println("\nTask 2");
        for (String arg: args) {
            System.out.print(arg + " ");
        }

        System.out.println("\n\nTask 3");

        for (int i =1; i < 10;i++){
            System.out.printf("%.3f\n", (double)1/i);
        }

        System.out.println("\nTask 4");

        Random rnd = new Random();
        int length = 7; // dummy number
        int[] arr = new int[length];

        for (int i = 0; i <= length-1; i++) {
            arr[i] = rnd.nextInt(99) + 1;
            System.out.println(arr[i]);
        }
        Arrays.sort(arr);

        System.out.println("\nSorted:");
        for (int i = 0; i <= length-1; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("\nTask 5");

        int num = 10; // dummy number
        int result = 1;

        for (int i = num; i > 0; i--) {
            result *= i;
        }
        System.out.print("The result is: " + result);
    }
}