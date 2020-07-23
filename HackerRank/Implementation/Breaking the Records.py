#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the breakingRecords function below.
def breakingRecords(scores):
    #return 자료형...
    max_score = scores[0]
    min_score = scores[0]
    maxcount = 0
    mincount = 0
    for score in scores :
        if( score > max_score): 
            max_score = score  
            maxcount+=1
        
        if( min_score > score) :
            min_score = score
            mincount+=1
    return [maxcount, mincount]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    scores = list(map(int, input().rstrip().split()))

    result = breakingRecords(scores)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
