import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfK{
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,9, 9, 9};
        System.out.println(maximumSubarraySum(arr, 3));
    }

    static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set= new HashSet<>();
        long res=0,sum=0;
        int s=0;
        for(int e=0;e<nums.length;e++){
            sum+=nums[e];
            if(set.contains(nums[e])){
                s=e;
                sum=nums[e];
                set.clear();
            }
            if((e-s+1)==k){
                res=Math.max(sum,res);
                set.remove(nums[s]);
                sum-=nums[s++];
            }
            set.add(nums[e]);
        }
        return res;
    }
}