import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        FourSum fs = new FourSum();

        // Test 1: Expected [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        System.out.println("Test 1: " + fs.fourSum(nums1, 0));

        // Test 2: Expected [[2,2,2,2]]
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println("Test 2: " + fs.fourSum(nums2, 8));

        // Test 3: Expected []
        int[] nums3 = {1, 2, 3, 4};
        System.out.println("Test 3: " + fs.fourSum(nums3, 100));

      // ✅ long target
    }

    public List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int a = 0;a<n-3;a++){
            if(a>0 && nums[a] == nums[a-1])
                continue;

            for(int b=a+1;b<n-2;b++){
                if(b>a+1 && nums[b] == nums[b-1])
                    continue;

                int left = b+1;
                int right = n-1;

                while(left<right){
                    long sum = (long)nums[a]+nums[b]+nums[left]+nums[right];

                    if(sum == target){
                        result.add(Arrays.asList(nums[a],nums[b],nums[left],nums[right]));

                        while(left<right && nums[left] == nums[left+1])
                            left++;

                        while(left<right && nums[right]==nums[right-1])
                            right--;

                        left++;
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;

        
    }
    
}
