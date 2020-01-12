import java.util.*;

class Solution {
    public static int bridge(int[][] b, int n) {
        // b : 비용을 오름차순으로 정렬한 배열
        // n : 섬 개수
        int count = 0; // 현재 추가된 다리의 수
        int sum = 0; // 다리 건설 최소 비용 변수
        int i = 0; // b 배열을 순회하기위한 변수
        int cost; // 비용 임시 변수
        int s1, s2; // 같은 섬인지 확인하기 위한 변수
        int[] s = new int[n];
        for(int j = 0; j < n; j++){
            s[j] = j;
        }
        while(count < n-1) {
            s1 = s[b[i][0]];
            s2 = s[b[i][1]];
            cost = b[i][2];
            if(s1 != s2) {
                for(int j = 0; j < s.length; j++) {
                    if(s[j] == s2) {
                        s[j] = s1;
                    }
                }
                sum += cost; // 다리 건설 비용
                count++; // 선택된 다리의 수를 증가
            }
            i++;
        }
        return sum;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] t = new int[costs.length][3];
        // 비용을 기준으로 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        answer = bridge(costs,n);

        return answer;
    }
}
