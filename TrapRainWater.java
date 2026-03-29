public class TrapRainWater {

    public int trap(int[] height){

        /*
     * PROBLEM: Given an array of heights, calculate how much rainwater can be trapped.
     *
     * INTUITION:
     * Water trapped at any position = min(maxLeft, maxRight) - height[i]
     * We can't trap more water than the shorter wall on either side.
     *
     * APPROACH: Two Pointer (Optimal)
     * Instead of precomputing maxLeft[] and maxRight[] arrays (O(n) space),
     * we use two pointers moving towards each other (O(1) space).
     *
     * KEY INSIGHT:
     * We process the side with the SMALLER max wall first.
     * Why? Because water level is determined by min(maxLeft, maxRight).
     * If maxLeft <= maxRight → we KNOW the limiting wall is on the LEFT side.
     *   → water at left = maxLeft - height[left] (guaranteed, since right wall is taller)
     * If maxRight < maxLeft → we KNOW the limiting wall is on the RIGHT side.
     *   → water at right = maxRight - height[right] (guaranteed, since left wall is taller)
     *
     * EXAMPLE:
     * height = [0,1,0,2,1,0,1,3,2,1,2,1]
     *
     *     3       |
     *     2   |   | |   |
     *     1 | | | | | | | | |
     *       0 1 2 3 4 5 6 7 8 9 ...
     *
     * Total water trapped = 6
     */

        int left=0;
        int right = height.length-1;
        int maxLeft=0;
        int maxRight=0;
        int total=0;


        while(left <=right){
            if(maxLeft <=maxRight){
                /*
                 * LEFT SIDE PROCESSING:
                 * maxLeft is the smaller or equal wall → it's the bottleneck.
                 * We are SURE the right side has a wall >= maxLeft,
                 * so water won't spill to the right.
                 *
                 * Step 1: Update maxLeft with current height (new wall found?)
                 * Step 2: Water at this position = maxLeft - height[left]
                 *         (if height[left] == maxLeft → no water, diff = 0)
                 *         (if height[left] < maxLeft  → trapped water = diff)
                 *
                 * Example:
                 * maxLeft=1, maxRight=2, height[left]=0
                 * → maxLeft stays 1
                 * → water += 1 - 0 = 1 ✅
                 */
                maxLeft = Math.max(maxLeft, height[left]);
                total += maxLeft-height[left];
                left++;
            }
            else{
                /*
                 * RIGHT SIDE PROCESSING:
                 * maxRight is the smaller wall → it's the bottleneck.
                 * We are SURE the left side has a wall > maxRight,
                 * so water won't spill to the left.
                 *
                 * Step 1: Update maxRight with current height (new wall found?)
                 * Step 2: Water at this position = maxRight - height[right]
                 *
                 * Example:
                 * maxLeft=3, maxRight=2, height[right]=1
                 * → maxRight stays 2
                 * → water += 2 - 1 = 1 ✅
                 */
                maxRight = Math.max(maxRight, height[right]);
                total += maxRight-height[right];
                right--;
            }
        }
        return total;




    }



    // ...existing code...

    /*
     * APPROACH 2: Prefix/Suffix Arrays (O(n) Space)
     *
     * INTUITION:
     * For every position i, water trapped = min(maxLeft[i], maxRight[i]) - height[i]
     *
     * STEPS:
     * Step 1: Build maxLeft[]  → maxLeft[i]  = max height from index 0 to i (left side wall)
     * Step 2: Build maxRight[] → maxRight[i] = max height from index n-1 to i (right side wall)
     * Step 3: For each position: water = min(maxLeft[i], maxRight[i]) - height[i]
     *
     * EXAMPLE:
     * height   = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
     * maxLeft  = [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
     * maxRight = [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]
     * water    = [0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0] → total = 6 ✅
     *
     * DIFFERENCE vs Two Pointer:
     * ┌─────────────────┬──────────┬──────────┐
     * │                 │ Time     │ Space    │
     * ├─────────────────┼──────────┼──────────┤
     * │ Two Pointer     │ O(n)     │ O(1) ✅  │
     * │ Prefix Arrays   │ O(n)     │ O(n) ❌  │
     * └─────────────────┴──────────┴──────────┘
     */
    public int trapPrefixArrays(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        // Step 1: Build maxLeft array
        // maxLeft[i] = maximum height from index 0 to i
        int[] maxLeft = new int[n]; // setting first index
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        // Step 2: Build maxRight array
        // maxRight[i] = maximum height from index n-1 to i
        int[] maxRight = new int[n];
        maxRight[n - 1] = height[n - 1]; // setting last maxright
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        // Step 3: Calculate trapped water at each position
        // water[i] = min(maxLeft[i], maxRight[i]) - height[i]
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return total;
    }

    public static void main(String[] args) {
        TrapRainWater t = new TrapRainWater();

        int[] h1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Test 1: " + t.trap(h1)); // Expected: 6

        int[] h2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Test 2: " + t.trap(h2)); // Expected: 9
    }
    
}
