//https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        //i : startDay j : endDay K: diovvvvv
        //정수 찾기.
        int result = 0;

        for (int l = i; l <= j ; l++) {
            int reverse = 0;//reverse....
            int n = l;
            int m = l;
            while(m>0) { //>1
                //1. 나머지 구하기  2.몫 구하기
                n = m%10;
                reverse = reverse*10 + n;
                m = m/10;                 
            }
           
            int r = Math.abs(l-reverse)%k;
            if(r == 0) {//r이 정수인지 확인.
                result++;
            }            
        }
        
        return result;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
