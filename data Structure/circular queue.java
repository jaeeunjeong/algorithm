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

    static class Queue {
        public static final int C = 26;
        public static int front, rear;
        public static char[] queue = new char[C];
        
        /*
        public Queue (){
            front = rear = 0;
            queue = new char[C]; 
        }*/

    }

    private static void sortedString(){
        for(int i = 0; i<Queue.C; i++){
            Queue.rear = (++Queue.rear)%Queue.C;
            Queue.queue[Queue.rear] = (char) (((int) 'A') + i);    
        }
    }
}
