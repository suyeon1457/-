import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 해시세팅
        HashMap<String, ArrayList<String>> clothesHash = new HashMap<>();
        for(int i = 0 ; i<clothes.length ; i++){
            ArrayList arr = new ArrayList();
            if(clothesHash.containsKey(clothes[i][1])){
                arr = clothesHash.get(clothes[i][1]);
            }
            arr.add(clothes[i][0]);
            clothesHash.put(clothes[i][1],arr);
        }
        // 해시 반복문
        for ( Map.Entry<String, ArrayList<String>> entry : clothesHash.entrySet() ) {
            answer *= entry.getValue().size()+1;
        }
        return answer-1;
    }
}
