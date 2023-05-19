import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfSubarray {
    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<>();
    }

    static int [] maximumOfSubarrays(int[] arr, int k){
        
        int i = 0, j = 0;
        int size = arr.length;
        int [] ans = new int[size-k+1];
        Deque<Integer> q = new LinkedList<>();

        while(j < size){
            if(q.size() == 0){
                q.add(arr[j]);
            }
            else{
                while(q.size() > 0 && q.peekLast() < arr[j]){
                    q.removeLast();
                }
                q.add(arr[j]);
            }

            if(j - i + 1 < k){
                j++;
            }

            if (j - i + 1 == k){
                ans[i] = q.peek();

                if(arr[i] == q.peek()){
                    q.removeFirst();
                }

                i++;
                j++;
            }
        }

        return ans;
        
    }
}
