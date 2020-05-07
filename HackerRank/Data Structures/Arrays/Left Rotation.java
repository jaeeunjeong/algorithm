//https://www.hackerrank.com/challenges/array-left-rotation/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];
        int[] b = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        int arrN = 0;
        for (int i = d; i < n; i++) {
            int aItem = a[i];
            b[arrN++] = aItem;
            System.out.print(String.valueOf(aItem));
        }
        System.out.print(" ");
        for (int i = 0; d < n; i++) {
            int aItem = a[i];
            b[arrN++] = aItem;
            System.out.print(String.valueOf(aItem)+" ");
        }
        scanner.close();
    }
}
