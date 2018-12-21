package practicals.task5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void reverseSplit(long number) {
        int len = (int)(Math.log10(number)+1);
        long div = number/(long)Math.pow(10,len-1);
        System.out.print(div + " ");
        if (len>1) reverseSplit(number%(long)Math.pow(10,len-1));
    }

    private static void reverseSplitBackwards(long number) {
        int len = (int)(Math.log10(number)+1);
        long div = number%10;
        System.out.print(div + " ");
        if (len>1) reverseSplitBackwards(number/10);
    }


    private static void countSeqMax() {
        //Input sequence
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> seq = new ArrayList<>();
        int input = -1;

        System.out.println("Enter the sequence: ");
        while (input!=0) {
            input = sc.nextInt();
            if (input!=0) seq.add(input);
        }

        int seqMax = getMax(seq,0,0);
        System.out.println("Max Element: " + seqMax + " Occurs: " + countMax(seq,0,0,seqMax) + " time(s)");
    }

    private static int getMax(ArrayList<Integer> seq, int idx, int currentMax) {
        if (idx!=seq.size()) {
            if(seq.get(idx) > currentMax) {
                currentMax = seq.get(idx);
            }
            return getMax(seq,idx+1,currentMax);
        } else {
            return currentMax;
        }
    }
    private static int countMax(ArrayList<Integer> seq, int idx, int count, int max) {
        if (idx!=seq.size()) {
            if(seq.get(idx)==max) {
                count++;
            }
            return countMax(seq,idx+1,count,max);
        } else {
            return count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number whose digit order needs to be displayed one by one in both orders: ");
        long i = sc.nextLong();

        System.out.println("\n\nResult(Task14): ");
        reverseSplit(i);

        System.out.println("\n\nResult(Task15): ");
        reverseSplitBackwards(i);

        System.out.println("\n\nResult(Task16): ");
        countSeqMax();
    }

}
