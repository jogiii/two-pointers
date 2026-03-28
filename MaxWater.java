public class MaxWater {

    public int maxArea(int[] heights){

        int maxWater =0;
        int left =0;
        int right = heights.length;

        while(left <right){

            int width = right-left;
            int height = Math.min(heights[left], heights[right]);
            int area = height*width;
            maxWater = Math.max(maxWater, area);

            if(heights[left] <=heights[right])
                left++;
            else
                right--;
        }
        return maxWater;
    }
    
}
