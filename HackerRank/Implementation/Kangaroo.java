//https://www.hackerrank.com/challenges/kangaroo/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        //x1 ,x2는 시작 위치
        //v1,v2는 간격
        String result = "NO";
        int max = x1;
        int min = x2;
        int max_itv = v1;
        int min_itv = v2;
        if(x2 > x1){
            max = x2;
            min = x1;
            max_itv = v2;
            min_itv = v1;
        }
        while(max > min){
            max += max_itv;
            min += min_itv;
            if(min == max) {
                result = "YES";
                break;
            };
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
