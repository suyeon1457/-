import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 큐생성
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0 ; i < scoville.length ; i++){
            queue.offer(scoville[i]);
        }
        while (!queue.isEmpty()) {
            // 큐에서 값을 2개 뽑아야하는데 남은 값이 1만 남았을 때
            if(queue.size() == 1){
                // 큐에 남은 값이 K보다 작다면 지금까지 체크한 횟수 초기화
                if(queue.poll() < K){
                    answer = 0;
                }
             break;
            }
            // 큐에서 가장 작은 값 뽑기
            int a = queue.poll();
            //K보다 크면 pass
            if(a > K){
             continue;
            }
            // 큐에서 가장 작은 값 뽑기2
            int b = queue.poll();
            //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
            queue.offer(a+(b*2));
            answer++;
        }
        //모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
        if(answer == 0){
           answer = -1;
        }
        //System.out.println(answer);
        return answer;
    }
}
