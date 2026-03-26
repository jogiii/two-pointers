import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();

        // Test 1: Expected [[-1,-1,2],[-1,0,1]]
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1: " + ts.threeSum(nums1));

        // Test 2: Expected []
        int[] nums2 = {0, 1, 1};
        System.out.println("Test 2: " + ts.threeSum(nums2));

        // Test 3: Expected [[0,0,0]]
        int[] nums3 = {0, 0, 0};
        System.out.println("Test 3: " + ts.threeSum(nums3));

        // Test 4: Expected [[-2,0,2],[-2,1,1]]
        int[] nums4 = {-4, -2, -2, -2, 0, 1, 2, 2, 2};
        System.out.println("Test 4: " + ts.threeSum(nums4));
    }

    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<nums.length-2;i++){


            if(i>0 && nums[i] ==nums[i-1])
                continue;
// if array is sorted and current num is +ve then positive + positive + positive > 0    (can NEVER equal 0)
            if(nums[i]>0)
                break;


            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];

                if(sum ==0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //[1,1,2]
                    //L->L ^
                    //to skip duplicates
                    while(left < right && nums[left] == nums[left+1])
                        left++;
                    //[1,2,2]
                    // ^  R<-R       

                    while(left<right && nums[right] == nums[right-1])
                        right--;

                    left++;
                    right--;
                }else if(sum <0){
                    left++;
                }else{
                    right--;
                }
            }




        }
        return result;
    }
    
}
