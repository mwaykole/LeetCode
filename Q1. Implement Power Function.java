// Problem Description
// Implement pow(A, B) % C.
// In other words, given A, B and C, Find (AB % C).
// Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.


// Problem Constraints
// -109 <= A <= 109
// 0 <= B <= 109
// 1 <= C <= 109


// Input Format
// Given three integers A, B, C.


// Output Format
// Return an integer.


// Example Input
// Input 1:
// A = 2
// B = 3
// C = 3
// Input 2:
// A = 3
// B = 3
// C = 1

public class Solution {
    public int pow(int A, int B, int C) {
        // Handling negative A by making it positive within the mod space
        A = A % C;
        if (A < 0) {
            A += C;
        }
        
        // Helper function to perform modular exponentiation
        return modExp(A, B, C);
    }
    
    // Function to calculate (A^B) % C using modular exponentiation
    private int modExp(int A, int B, int C) {
        if (B == 0) {
            return 1 % C;  // Base case: A^0 is 1
        }
        
        long half = modExp(A, B / 2, C);  // Recursively calculate A^(B/2) % C
        half = (half * half) % C;  // Square the result
        
        if (B % 2 != 0) {
            half = (half * A) % C;  // If B is odd, multiply by A
        }
        
        return (int) half;  // Return result as an integer
    }
}
