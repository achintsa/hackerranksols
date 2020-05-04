#!/bin/python

import math
import os
import random
import re
import sys

# Complete the hourglassSum function below.
def hourglassSum(arr):
    #this is a comment [[1,1,1],[2,2,2],[3,3,3]]
    # [[1,1,1],
    #[2,2,2],
    #[3,3,3]]
    maxSum = -63

    for rowIdx in xrange(4):
        for colIdx in xrange(4):
            hour_glass_sum = arr[rowIdx][colIdx] + arr[rowIdx][colIdx + 1] + arr[rowIdx]                [colIdx + 2] + \
            arr[rowIdx + 1][colIdx + 1] + \
            arr[rowIdx+2][colIdx] + arr[rowIdx+2][colIdx + 1] + arr[rowIdx+2][colIdx + 2]
            if hour_glass_sum > maxSum:
                maxSum = hour_glass_sum
            #print arr[rowIdx][colIdx] ,

    return maxSum



if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr = []

    for _ in xrange(6):
        arr.append(map(int, raw_input().rstrip().split()))

    result = hourglassSum(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
