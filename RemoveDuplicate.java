public class RemoveDuplicate {
    

    public static int removeDuplicates(int[] nums){

        if (nums.length ==0)
            return 0;

        int slow =0;

        for (int fast =1;fast<nums.length;fast++){
            if(nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;

    }

    public static void main(String[] args) {
        // Test Case 1: mixed duplicates
        int[] nums1 = {1, 1, 2, 3, 3, 4};
        int k1 = removeDuplicates(nums1);
        System.out.print("Test 1 → k = " + k1 + " | Result: ");
        for (int i = 0; i < k1; i++) System.out.print(nums1[i] + " ");
        System.out.println();

        // Test Case 2: longer array
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = removeDuplicates(nums2);
        System.out.print("Test 2 → k = " + k2 + " | Result: ");
        for (int i = 0; i < k2; i++) System.out.print(nums2[i] + " ");
        System.out.println();

        // Test Case 3: all duplicates
        int[] nums3 = {3, 3, 3, 3};
        int k3 = removeDuplicates(nums3);
        System.out.print("Test 3 → k = " + k3 + " | Result: ");
        for (int i = 0; i < k3; i++) System.out.print(nums3[i] + " ");
        System.out.println();

        // Test Case 4: no duplicates
        int[] nums4 = {1, 2, 3, 4};
        int k4 = removeDuplicates(nums4);
        System.out.print("Test 4 → k = " + k4 + " | Result: ");
        for (int i = 0; i < k4; i++) System.out.print(nums4[i] + " ");
        System.out.println();

        // Test Case 5: single element
        int[] nums5 = {7};
        int k5 = removeDuplicates(nums5);
        System.out.print("Test 5 → k = " + k5 + " | Result: ");
        for (int i = 0; i < k5; i++) System.out.print(nums5[i] + " ");
        System.out.println();
    }
}
