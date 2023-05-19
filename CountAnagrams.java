import java.util.HashMap;
// import java.util.Map;

public class CountAnagrams {
    public static void main(String[] args) {
        System.out.println("Answer : " + countAnagrams("aabaabaa", "aaba"));
    }

    static int countAnagrams(String str, String ptr){
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < ptr.length(); i++){
            char c = ptr.charAt(i);

            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }

        int count = map.size(), i = 0, j = 0;

        while(j < ptr.length()){
            System.out.println(map);
            char c = str.charAt(j);

            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
            }

            // for (Map.Entry<Character, Integer> mapEntries : map.entrySet()){
            //     if(mapEntries.getValue() == 0){
            //         count--;
            //         System.out.println(mapEntries.getKey() + " value " + mapEntries.getValue());
            //         System.out.println(count);
            //     }
            // }

            if(j - i + 1 < ptr.length()){
                j++;
            }

            if(j - i + 1 == ptr.length()){
                if(count == 0){
                    ans++;
                }

                if(map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i), map.get(str.charAt(i))+1);
                }

                if(count == 1){
                    count++;
                }

                i++;
                j++;
            }
            // System.out.println(count);
            
        }

        return ans;
    }
}
