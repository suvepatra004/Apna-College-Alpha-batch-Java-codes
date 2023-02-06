
import java.util.*;

// import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

// import javax.swing.plaf.synth.SynthSpinnerUI;

public class main2 {
    public static void swap(int a, int b) { // Call by value

        int temp = a;
        a = b;
        b = temp;
        System.out.println("\nInside function a = " + a + " b = " + b);
    }

    public static int fact(int num) { // Factorial number

        int f = 1;
        for (int i = 1; i <= num; i++) {
            f = f * i;
        }

        return f;
    }

    public static int binocoeff(int n, int r) { // Binomial coefficient

        int fact_n = fact(n);
        int fact_r = fact(r);
        int fact_nr = fact(n - r);

        int BinomialCoeff = fact_n / (fact_r * fact_nr);

        return BinomialCoeff;
    }

    public static boolean isPrime(int n) { // check if prime or not

        if (n % 2 != 0 && n % n == 0) {

            return true;
        }
        if (n == 1 || n == 0) {
            return false;

        } else {
            return false;
        }
    }

    public static int primeRange(int n) { // prime number between the range of number

        for (int i = 1; i <= n; i++) {
            if (isPrime(i) == true) {
                System.out.print(i + " ");
            }
        }
        return 1;
    }

    public static void biToDec(int biNum) { // conversion of a number from binary number to decimal

        int myNum = biNum;
        int decNum = 0;
        int pow = 0;

        while (biNum > 0) {
            int lastDigit = biNum % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2, pow));

            pow++;
            biNum = biNum / 10;
        }

        System.out.println("Decimal form of " + myNum + " = " + decNum);
    }

    public static void decTobin(int n) { // conversion of a number from decimal to binary

        int bin = 0;
        int pow = 0;
        int dec = n;
        while (n > 0) {
            int rem = n % 2;

            bin = bin + (rem * (int) Math.pow(10, pow));
            pow++;
            n = n / 2;
        }

        System.out.println("Binary form of " + dec + " = " + bin);
    }

    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static int linearSearch(int num[], int key) {

        for (int i = 0; i < num.length; i++) {
            if (num[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int largestNum(int number[]) {
        int largest = Integer.MIN_VALUE; // -infinity
        int smallest = Integer.MAX_VALUE; // +infenity

        for (int i = 0; i < number.length; i++) {
            if (largest < number[i]) { // finds the largest value
                largest = number[i];
            }

            if (smallest > number[i]) { // finds the smallest value
                smallest = number[i];
            }
        }
        System.out.println("The smallest value is : " + smallest);
        return largest;
    }

    public static int binarySearch(int number[], int key) { // Time complexity is O(log n);
        int start = 0, end = number.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // comparisons of the left and right cases
            if (number[mid] == key) {
                return mid;
            }
            if (number[mid] < key) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return -1; //
    }

    public static void reverseArray(int number[]) {
        int first = 0, last = number.length - 1;

        while (first < last) {
            // swap
            int temp = number[last];
            number[last] = number[first];
            number[first] = temp;

            first++;
            last--;
        }
    }

    public static void arrayPairs(int arr[]) { // Time complexity O(n2)
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + current + ", " + arr[j] + ")  ");
                total++;
            }
            System.out.println();
        }
        System.out.println("Total pair of numbers are : " + total);
    }

    public static void printSubarray(int arr[]) { // Time complexity is O(n3)
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i + 1; j < arr.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // BRUTE FORCE METHOD
    public static void maxSubarraySum(int arr[]) { // Time complexity is O(n3)
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currSum = 0;
                for (int k = start; k <= end; k++) {
                    // subarray sum
                    currSum += arr[k];
                }
                System.out.println(currSum);
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("maximum sum : " + maxSum);
    }

    // PREFIX ARRAY METHOD
    public static void maxSubarraySum2(int arr[]) { // Time complexity is O(n2)
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];

        // calculate prefix array
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;

                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("maximum sum : " + maxSum);
    }

    // KADANE'S ALGORITM
    public static void maxSubarraySum3(int arr[]) { // Time complexity is O(n)
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println("maximum sub-array sum : " + maxSum);
    }

    // TRAPPING RAIN WATER
    // height = [4,2,0,6,3,2,5] width = 1
    public static int trappingWater(int height[]) { // Time complexity O(n)
        int n = height.length;
        // calculate left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // calculate right max boundary
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // loop
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            // water level = min(leftMax, rightMax)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            // trapWater = (waterLevel - height[i]) * 1
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    public static void printDec(int n) { // print numbers in decreasing manner n to 1
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    public static void printInc(int n) { // print numbers in increasing manner 1 to n
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static int fact2(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact2(n - 1);
    }

    public static int sumNatural(int n) { // sum of N natural numbers
        if (n == 1) {
            return 1;
        }
        return n + sumNatural(n - 1);
    }

    public static int fibonacci(int n) { // Fibonacci series using recursion
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2); // Time complexity O(2^n) space complexity O(n)
    }

    public static boolean isSirted(int arr[], int i) { // Check if a array is sorted or not
        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) { // Time complecity O(n) = Space complexity
            return false;
        }

        return isSirted(arr, i + 1);
    }

    public static int firstOccurance(int arr[], int i, int key) {
        if (i == arr.length) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return firstOccurance(arr, i + 1, key);
    }

    public static int lastOccurance(int arr[], int i, int key) {
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOccurance(arr, i + 1, key);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int Power(int x, int n) { // find to the power of x
        if (n == 0) {
            return 1;
        }

        return x * Power(x, n - 1); // Time complexity is O(n)
    }

    public static int PowerOpt(int x, int n) { // optimized method of finding the to the power
        if (n == 0) {
            return 1;
        }
        int halfPow = PowerOpt(x, n / 2);
        int halfPowSq = halfPow * halfPow;

        if (n % 2 != 0) {
            halfPowSq = x * halfPowSq;
        }

        return halfPowSq;
    }

    public static int tilingProblem(int n) { // 2 x n (floor size)
        if (n == 0 || n == 1) {
            return 1;
        }
        // vertical tiles
        int fn1 = tilingProblem(n - 1);

        // horizontal tiles
        int fn2 = tilingProblem(n - 2);

        // total number of ways
        return fn1 + fn2;
    }

    public static void removeDuplicate(String str, int idx, StringBuilder newstr, boolean map[]) {
        if (idx == str.length()) { // remove duplicates in a string
            System.out.println(newstr);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // Duplicates
            removeDuplicate(str, idx + 1, newstr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx + 1, newstr.append(currChar), map);
        }
    }

    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        // total pair = single choice + (n-1) * pair choice
        // return friendsPairing(n-1) + (n-1) * friendsPairing(n-2)
        return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);
    }

    public static void binString(int n, int lastPlace, String str) { // Print the Binary Number String(n) without having
                                                                     // consecutive 1
        if (n == 0) {
            System.out.println(str);
            return;
        }

        binString(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            binString(n - 1, 1, str + "1");
        }
    }

    public static void oddEvenOfBinary(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 1) {
            System.out.println("Odd number");
        } else {
            System.out.println("Even number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if(newBit == 0) {
        // return clearIthBit(n, i);
        // } else {
        // return setIthBit(n, i);
        // }

        // OR
        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static int binarySearch(int key, int arr[]) {

        int start = 0;
        int end = arr.length - 1;
        int mid = start;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // int arr[] = { 2, 3, 5, 67, 89, 99 };
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // int loc = linearSearch(arr, 20); // Time complexity is O(n)
        // System.out.println("\nThe number found in the location " + loc);

        // int height[] = { 4, 2, 0, 6, 3, 2, 5, };
        // System.out.println(trappingWater(height));

        int arr[] = { 23, 34, 45, 56, 67 };
        int n = sc.nextInt();
        System.out.println(n + " is present at the location --> " + binarySearch(n, arr));
        int len = arr.length;
        System.out.println("The length of the array is " + len);
    }
}
