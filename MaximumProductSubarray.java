/*Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/
public class MaximumProductSubarray {
    class Solution {
        public int maxProduct(int[] nums) {
            int maxProd = nums[0];
            int minProd = nums[0];
            int result = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int curr = nums[i];

                // Store maxProd temporarily because minProd update depends on old maxProd
                int tempMax = Math.max(curr, Math.max(curr * maxProd, curr * minProd));
                minProd = Math.min(curr, Math.min(curr * maxProd, curr * minProd));
                maxProd = tempMax;

                result = Math.max(result, maxProd);
            }

            return result;
        }
    }
    
