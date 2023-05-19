public class MinimumSum2 {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(maximumSubarraySum(arr, 3));
    }

    static int maximumSubarraySum(int[] nums, int k){
        int i = 0;
        int j = 0;
        int max = 0;
        int size  = nums.length;
        int sum = 0;

        while(j < size){
            sum = sum + nums[j];
            System.out.println(sum);

            if((j - i + 1) < k){
                j++;
            }

            else if((j-i+1) == k){
                max = Math.max(max, sum);
                sum = sum - nums[i];
                i++;
                j++;
            }
        }

       return max;
    }
}
