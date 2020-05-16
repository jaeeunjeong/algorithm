//https://www.hackerrank.com/challenges/strange-advertising/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int Cumulative = 0;
        int Shared  = 5;//초기 멤버.
        int liked = 0;
        
        for (int i = 0; i < n; i++) {
            Cumulative+=Shared/2;
            liked  = Shared/2;
            Shared = Shared/2*3;
        }
                
                
        return Cumulative;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
