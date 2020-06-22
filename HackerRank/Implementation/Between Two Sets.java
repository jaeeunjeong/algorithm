//https://www.hackerrank.com/challenges/between-two-sets
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

   /*
    * Complete the 'getTotalX' function below.
    *
    * The function is expected to return an INTEGER.
    * The function accepts following parameters:
    *  1. INTEGER_ARRAY a
    *  2. INTEGER_ARRAY b
    */

   public static int getTotalX(List<Integer> a, List<Integer> b) {
   // Write your code here
   //a에서 공배수 찾기
   int multiple = 1;
   
   //공약수 찾음
   int divisor  = 1;
   int nbrA =  b.get(0);
   //divisor = gcd( nbrA, a.get(1));
   for(int i = 1; i<b.size(); i++){
        int nbrB = b.get(i);
        //b에서 공약수 찾기
        divisor = gcd( nbrA, nbrB);
        nbrA = divisor;
   }
   nbrA =  a.get(0);
   for(int i = 1; i<a.size(); i++){
        int nbrB = a.get(i);
        //b에서 공약수 찾기
        multiple = lcd( nbrA, nbrB);
        nbrA = multiple;
   }

   int cnt = 0;
   //a의 최소공배수 <b의 최대공약수

   while(multiple <= divisor){
              System.out.println("A="+divisor+":"+ multiple+":"+nbrA);
       if(divisor%multiple == 0){
           ++cnt;
       }else{
           continue;
       }
       multiple = nbrA*(cnt+1);

       System.out.println(multiple);
   }

   return cnt;
   }
   //최대공약수
   public static int gcd(int a, int b) {
       while (b > 0) {
           int temp = b;
           b = a % b; // % is remainder
           a = temp;
       }
       return a;
   }
   //최소공배수
   public static int lcd(int a, int b) {
       return a * (b / gcd(a,b));
   }

}

public class Solution {
   public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

       int n = Integer.parseInt(firstMultipleInput[0]);

       int m = Integer.parseInt(firstMultipleInput[1]);

       List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
           .map(Integer::parseInt)
           .collect(toList());

       List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
           .map(Integer::parseInt)
           .collect(toList());

       int total = Result.getTotalX(arr, brr);

       bufferedWriter.write(String.valueOf(total));
       bufferedWriter.newLine();

       bufferedReader.close();
       bufferedWriter.close();
   }
}
