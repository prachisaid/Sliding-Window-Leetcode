import java.util.HashMap;

public class LongestSubstring {
    public static void main(String[] args) {
        String str = "aabacbebebe";

        System.out.println(countSubstring(str, 3));
    }

    private static int countSubstring(String str, int k){
        // int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int j = 0, i = 0, max = 0;

        while(j < str.length()){
            char c = str.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }

            System.out.println(map);

            if(map.size() < k){
                j++;
            }

            else if(map.size() == k){
                max = Math.max(max, j - i + 1);
                j++;
            }

            else if(map.size() > k){
                while(map.size() > k){
                    char ch = str.charAt(i);
                    map.put(ch, map.get(ch)-1);
                    if(map.get(ch) == 0){
                        map.remove(ch);
                    }
                    i++;
                }
                j++;
            }
        }

        return max;
    }
}
