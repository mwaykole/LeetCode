import java.util.HashMap;

public class Solution {

    /*
     * Problem:
     * Given an array of integers `arr` and an integer `k`, your task is to count the number 
     * of subarrays whose sum equals `k`. A subarray is defined as a contiguous portion of the array.
     * 
     * Example:
     * Input: arr = [1, 2, 3], k = 3
     * Output: 2
     * Explanation: The subarrays [1, 2] and [3] both sum to 3.
     *
     * Approach:
     * This solution uses the "prefix sum" technique combined with a HashMap to count the number
     * of subarrays whose sum equals the given value 'k'.
     * 
     * 1. We iterate through the array, maintaining a running sum (prefix sum).
     * 2. For each element, we check if the prefix sum minus the target sum 'k' exists in our HashMap.
     *    If it does, this means there exists a subarray ending at the current index that sums to 'k'.
     * 3. We then update the frequency of the current prefix sum in the HashMap.
     * 
     * The key insight here is that if the difference between the current prefix sum and 'k' exists 
     * in the HashMap, then we've found a valid subarray. By keeping track of all previous prefix sums,
     * we can efficiently check for such subarrays in linear time.
     */

    public int solve(int[] arr, int k) {
        // Map to store the frequency of prefix sums
        HashMap<Integer, Integer> map = new HashMap<>();
        // Base case: If the prefix sum is exactly 'k', it is counted (psum - k = 0)
        map.put(0, 1);

        int psum = 0;  // Running prefix sum
        int count = 0; // Counter for the number of subarrays that sum to 'k'

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            psum += arr[i]; // Update the prefix sum by adding the current element
            int target = psum - k; // The target we are looking for: psum - k

            // If the target exists in the map, it means there is a subarray with sum 'k'
            if (map.containsKey(target)) {
                count += map.get(target); // Add the number of times this target was encountered
            }

            // Add the current prefix sum to the map or update its frequency
            map.put(psum, map.getOrDefault(psum, 0) + 1);
        }

        return count; // Return the total count of subarrays whose sum equals 'k'
    }
}
