//https://www.hackerrank.com/challenges/lisa-workbook/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the workbook function below.
    static int workbook(int n, int  k, int[] arr) {
        int result = 0;;
        int page = 1;
        
        for (int i = 0; i < arr.length; i++) {
            int problems = arr[i];//chapter 당 문제 수
            System.out.println(page);
            for (int problem = 1; problem <= problems; problem++) {
                if(page == problem) {
                    result++;
                }
                if(problem%k == 0 ||problems == problem) {
                    page++;
                }
            }
        }
        


        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
