//https://www.hackerrank.com/challenges/fair-rations/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the fairRations function below.
    static int fairRations(int[] B) {
        int result = 0;

        for (int i = 0; i < B.length-1; i++) {
            int nbr = B[i];
            if(nbr%2 ==1) {
                B[i]++;
                B[i+1]++;
                result = result+2;
            }
        }

        if(B[B.length-1]%2 ==1) {
            result = -1;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);
        if(result >-1){
        bufferedWriter.write(String.valueOf(result));
        }else{
            bufferedWriter.write("NO");
        }
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
