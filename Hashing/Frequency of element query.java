/**
 * Problem Description:
 * XVY organizes a series of contests aimed at helping learners enhance their coding skills.
 * Each learner can participate in multiple contests, and their participation is represented 
 * by integers in an array. The goal is to identify how frequently each learner has participated 
 * in these contests. This information will help XVY determine which learners are participating 
 * the least, allowing them to provide targeted support and encouragement.
 * 
 * Given an array A that represents the participants of various contests, where each integer 
 * corresponds to a specific learner, and an array B containing the learners for whom you want to 
 * check participation frequency, your task is to find the frequency of each learner from array B 
 * in the array A and return a list containing all these frequencies.
 * 
 * Problem Constraints:
 * 1 <= |A| <= 10^5
 * 1 <= |B| <= 10^5
 * 1 <= A[i] <= 10^5
 * 1 <= B[i] <= 10^5
 * 
 * Input Format:
 * - First argument A is an array of integers.
 * - Second argument B is an array of integers denoting the queries.
 * 
 * Output Format:
 * Return an array of integers containing the frequency of each learner in B as found in array A.
 * 
 * Example Input:
 * Input 1:
 * A = [1, 2, 1, 1]
 * B = [1, 2]
 * 
 * Input 2:
 * A = [2, 5, 9, 2, 8]
 * B = [3, 2]
 * 
 * Example Output:
 * Output 1:
 * [3, 1]
 * 
 * Output 2:
 * [0, 2]
 */

 import java.util.ArrayList;
 import java.util.HashMap;
 
 public class Solution {
     public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
         HashMap<Integer, Integer> frequencyMap = new HashMap<>();
         ArrayList<Integer> result = new ArrayList<>();
 
         // Count frequency of each element in A
         for (int num : A) {
             frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
         }
 
         // Get the frequency for each element in B
         for (int query : B) {
             result.add(frequencyMap.getOrDefault(query, 0));
         }
 
         return result;
     }
 
     public static void main(String[] args) {
         Solution solution = new Solution();
         ArrayList<Integer> A = new ArrayList<>();
         A.add(1); A.add(2); A.add(1); A.add(1);
         ArrayList<Integer> B = new ArrayList<>();
         B.add(1); B.add(2);
 
         ArrayList<Integer> result = solution.solve(A, B);
         System.out.println(result); // Output: [3, 1]
     }
 }
 