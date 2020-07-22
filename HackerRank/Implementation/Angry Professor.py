#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the angryProfessor function below.
def angryProfessor(k, a):
    result = "NO"
    cnt = 0

    for i in a : 
        if i <=0 :
            cnt+=1
    
    if k >cnt :
        result = "YES"

    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        nk = input().split()

        n = int(nk[0])

        k = int(nk[1])

        a = list(map(int, input().rstrip().split()))

        result = angryProfessor(k, a)

        fptr.write(result + '\n')

    fptr.close()
    """
    #ver.Java
    Complete the angryProfessor function below.
    static String angryProfessor(int k, int[] a) {
        String result = "NO";
        int cnt = 0;
        for(int i= 0; i < a.length; i++){
            if(a[i] <=0){
                cnt++;
            }
        }

        if(k>cnt){
            result = "YES";
        }
        return result;
    }
    """
