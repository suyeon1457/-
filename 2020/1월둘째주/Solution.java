import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int tf = 1;
        int check = 0;
        for (int i = 0; i < skill_trees.length; i ++) {
            String skil_str = skill_trees[i];
            for (int j = 0; j < skil_str.length(); j ++) {
                // skil_str[j]와 find_num 비교하기
                int find_num = skill.indexOf(skil_str.charAt(j));
                // 범위에 맞지 않을 경우
                if (find_num < 0 || find_num > 30) {
                    continue;
                }
                // 체크된 개수랑 indexOf()한 개수가 틀릴경우
                if (find_num != check) {
                    tf = 0;
                    break;
                } else {
                    // 동일한 문자가 있을경우 통과하면
                    check ++;
                }
            }
            if (tf != 0) {
                answer ++;
            }
            check = 0;
            tf = 1;
        }
        return answer;
    }
}
