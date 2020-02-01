import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 나간 지점 기준으로 오름차순
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] r1, int[] r2) {
                return r1[1] - r2[1];
            }
        });
        
        int answer = 0,chk = -30000;
        for(int i=0; i<routes.length; i++) {
            int in = routes[i][0];
            int out = routes[i][1];
            if(in>out){
                break;
            }
            if(chk<in){
                answer++;
                chk=out;
            }
        }
        return answer;
    }
}