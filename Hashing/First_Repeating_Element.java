/**
 * Q3. First Repeating Element
 * 
 * Problem Description:
 * Given an integer array A of size N, find the first repeating element in it.
 * We need to find the element that occurs more than once and whose index of the
 * first occurrence is the smallest.
 * 
 * If there is no repeating element, return -1.
 * 
 * Problem Constraints:
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 10^9
 * 
 * Input Format:
 * The first and only argument is an integer array A of size N.
 * 
 * Output Format:
 * Return an integer denoting the first repeating element.
 * 
 * Example Input:
 * Input 1:
 *   A = [10, 5, 3, 4, 3, 5, 6]
 * Input 2:
 *   A = [6, 10, 5, 4, 9, 120]
 * 
 * Example Output:
 * Output 1:
 *   5
 * Output 2:
 *   -1
 */

 import java.util.HashMap;

 public class Solution {
 
     /**
      * Approach:
      * 1. Traverse through the array and use a HashMap to store elements and their
      *    first occurrence indices.
      * 2. If an element is already present in the map, it's a repeating element.
      *    Compare its first occurrence index with the current minimum index of
      *    repeating elements and update if it's smaller.
      * 3. After completing the loop, if a repeating element was found, return the
      *    element at the minimum index of repetition. Otherwise, return -1.
      * 
      * Time Complexity: O(N) - We traverse the array once.
      * Space Complexity: O(N) - We use additional space for the HashMap.
      */
 
     public int solve(int[] arr) {
         HashMap<Integer, Integer> hm = new HashMap<>();
         int minIndex = Integer.MAX_VALUE;
 
         // Traverse the array to find the first repeating element with the smallest index
         for (int i = 0; i < arr.length; i++) {
             if (hm.containsKey(arr[i])) {
                 // If element is repeated, update minIndex if needed
                 minIndex = Math.min(minIndex, hm.get(arr[i]));
             } else {
                 // Otherwise, store the element and its index
                 hm.put(arr[i], i);
             }
         }
 
         // Check if a repeating element was found
         if (minIndex == Integer.MAX_VALUE) {
             return -1; // No repeating element found
         } else {
             // Return the first repeating element
             return arr[minIndex];
         }
     }
 }
 