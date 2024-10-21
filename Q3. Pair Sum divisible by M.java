/*
Q3. Pair Sum divisible by M

Problem Description:
--------------------
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

Since the answer may be large, return the answer modulo (10^9 + 7).

Note: Ensure to handle integer overflow when performing the calculations.

Problem Constraints:
--------------------
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^6

Input Format:
-------------
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format:
--------------
Return the total number of pairs for which the sum is divisible by B, modulo (10^9 + 7).

Example Input 1:
----------------
A = [1, 2, 3, 4, 5]
B = 2

Example Output 1:
-----------------
4

Example Explanation 1:
----------------------
The valid pairs are:
- (1, 3) with sum = 4, which is divisible by 2
- (1, 5) with sum = 6, which is divisible by 2
- (2, 4) with sum = 6, which is divisible by 2
- (3, 5) with sum = 8, which is divisible by 2

Example Input 2:
----------------
A = [5, 17, 100, 11]
B = 28

Example Output 2:
-----------------
1

Example Explanation 2:
----------------------
The valid pair is:
- (17, 11) with sum = 28, which is divisible by 28.

Explanation of the Solution:
----------------------------
The core idea is to use modulo arithmetic to simplify the problem. We calculate the remainder of each element in the array when divided by B.
Then, we pair elements based on their remainders:
- Elements with remainder 0 can pair among themselves.
- Elements with remainder r can pair with elements whose remainder is B - r.
- We handle the special case where remainder r == B / 2 separately (such elements must pair among themselves).

The result is computed modulo (10^9 + 7) to avoid overflow.

Steps:
1. Create an array to count the frequency of each remainder when dividing elements by B.
2. For elements with remainder 0, calculate how many pairs can be formed.
3. For each remainder r, find how many pairs can be formed with remainder B - r.
4. Take care of the case where r == B / 2, where elements pair among themselves.
5. Return the result modulo (10^9 + 7).

Dry Run:
--------
For A = [1, 2, 3, 4, 5] and B = 2:

Step 1: Calculate remainders
- 1 % 2 = 1
- 2 % 2 = 0
- 3 % 2 = 1
- 4 % 2 = 0
- 5 % 2 = 1

Remainder count: [2, 3] (two elements with remainder 0 and three elements with remainder 1)

Step 2: Count pairs
- Pairs with remainder 0: (2, 4) → 1 pair
- Pairs with remainder 1: (1, 3), (1, 5), (3, 5) → 3 pairs

Total: 4 pairs

Final result: 4

Solution:
---------
*/

public class Solution {
    public int solve(int[] A, int B) {
        // Define the modulo constant
        int MOD = 1000000007;
        
        // Array to store the count of remainders when divided by B
        int[] remainderCount = new int[B];
        
        // Count the frequency of each remainder
        for (int num : A) {
            int remainder = num % B;
            remainderCount[remainder]++;
        }
        
        // To store the result (number of pairs)
        long count = 0;
        
        // Case 1: Pairs of elements where both have remainder 0
        count += (long) remainderCount[0] * (remainderCount[0] - 1) / 2;
        
        // Case 2: Pairs of elements with remainder r and B - r
        for (int r = 1; r <= B / 2; r++) {
            if (r == B - r) {
                // Special case where r == B - r, like r = B/2 (pair among themselves)
                count += (long) remainderCount[r] * (remainderCount[r] - 1) / 2;
            } else {
                // Pair remainder r with B - r
                count += (long) remainderCount[r] * remainderCount[B - r];
            }
            count %= MOD;  // Take modulo to prevent overflow
        }
        
        // Return the result modulo 10^9 + 7
        return (int) (count % MOD);
    }
}
