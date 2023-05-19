import java.util.HashMap;

public class LongestSubStrNoRep {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(longestSubStr(str));
    }

    private static int longestSubStr(String str){
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

            if(map.size() > (j - i + 1)){
                j++;
            }

            else if(map.size() == (j - i + 1)){
                max = Math.max(max, j - i + 1);
                j++;
            }

            else if(map.size() < (j - i + 1)){
                while(map.size() < (j - i + 1)){
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
