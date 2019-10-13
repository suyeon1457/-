import java.util.Queue;
import java.util.LinkedList;

public class Truck {
    int weight = 0;
    int bridge = 0;
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> q = new LinkedList<Truck>();// 대기 트럭
        Queue<Truck> q2 = new LinkedList<Truck>();//다리 건너는 트럭

        for(int w : truck_weights){
            Truck t = new Truck();
            t.weight = w;
            t.bridge = 0;
            q.add(t);
        }

        int time = 0;//걸린 시간
        while(!(q.isEmpty() && q2.isEmpty())){
            time++;

            Truck done = null;// 다리를 지난 트럭
            int weight_chk = 0;// 건너는 트럭 무게 체크

            //건너는 트럭 체크
            for (Truck truck : q2) {
                weight_chk += truck.weight;
                truck.bridge++;//건너는 트럭 다리 수 count

                //해당 트럭이 다리 다 건너면 제외
                if (truck.bridge > bridge_length) {
                    done = truck;
                }
            }
            if(done != null){
                weight_chk -= done.weight;
                q2.remove(done);
            }

            if (!q.isEmpty() && (q2.size() < bridge_length)) {
                Truck truck = q.peek();
                //해당 대기 트럭 무게와 다리 건너는 트럭 무게가 조건에 맞을때
                if (truck.weight + weight_chk <= weight) {
                    //대기 트럭에서 빼기
                    q.remove(truck);
                    //다리 건너는 트럭으로 넣기
                    q2.add(truck);
                    //해당 트럭 다리 count
                    truck.bridge++;
                }
            }
        }
        return time;
    }
}
