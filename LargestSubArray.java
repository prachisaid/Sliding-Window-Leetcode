public class LargestSubArray {
    public static void main(String[] args) {
        int[] nums = {4, 1, 1, 1, 2, 3, 5};

        System.out.println(largestSubArray(nums, 4));
    }

    private static int largestSubArray(int[] arr, int k){
        int i = 0, j = 0, sum = 0, max = 0;
        
        while(j < arr.length){

            sum += arr[j];
            
            if(sum < k){
                j++;
            }

            else if(sum == k){
                max = Math.max(max, j - i + 1);
                j++;
            }

            if(sum > k){
                while(sum > k){
                    sum = sum - arr[i];
                    i++;
                }
                if(sum == k){
                    max = Math.max(max, j-i+1);
                }
                j++;
            }


        }

        return max;
    }
}
