import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        List<String> arr_w = new ArrayList<String>();
        int w_chk = 0;
        for(int i = 0; i<words.length; i++){
            if(target.equals(words[i])){
                w_chk += 1;
            }
            arr_w.add(words[i]);
        }
        if(w_chk == 0){
            return answer;
        }

        while(arr_w.size() != 0){
            char[] b_List = begin.toCharArray();
            char[] t_List = target.toCharArray();

            int cheack = b_List.length-1;
            for(int i=0;i<arr_w.size();i++){
                int count= 0;
                int t_count = 0;
                char[] compare = arr_w.get(i).toCharArray();
                for(int j=0;j<b_List.length;j++){
                    if(b_List[j]==compare[j]){
                        count++;
                    }
                    if(b_List[j]==t_List[j]){
                        t_count++;
                    }
                }
                if(t_count==cheack){
                    answer++;
                    return answer;
                }

                if(count==cheack){
                    begin = arr_w.get(i);
                    arr_w.remove(i);
                    answer++;
                }
            }
        }
        return 0;
    }
}
