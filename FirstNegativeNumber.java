import java.util.ArrayList;
// import java.util.LinkedList;
import java.util.List;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 80};
        List<Integer> list = new ArrayList<>();
        
        list = negativeNumber(arr, 3);
        System.out.println(list);
    }

    public static List<Integer> negativeNumber(int[] arr, int k) {

        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        int size = arr.length;

        while (j < size) {
            if (arr[j] < 0) {
                list.add(arr[j]);
                System.out.println(list);
            }

            if ((j - i + 1) < k) {
                j++;
            }

            else if ((j - i + 1) == k) {

                if (list.size() == 0) {

                    ans.add(0);

                } 
                else {
                    int a = list.get(0);
                    ans.add(a);

                    if (arr[i] == a) {
                        
                        list.remove(0);

                    }
                }
                i++;
                j++;
            }
        }

        return ans;
    }

}
