import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public static class Heap {
        private ArrayList<Integer> heap = new ArrayList<>();
        public void insert(int val) {
            heap.add(val);
            Collections.sort(heap);
        }
        // 최댓값 삭제
        public int maxDelete() {
            if (heap.isEmpty()) {
                return 0;
            }
            int deleteItem = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            return deleteItem;
        }
        // 최솟값 삭제
        public int minDelete() {
            if (heap.isEmpty()) {
                return 0;
            }
            int deleteItem = heap.get(0);
            heap.remove(0);
            return deleteItem;
        }
    }
    public int[] solution(String[] operations) {
        Heap heap = new Heap();
        for (int i = 0; i < operations.length; i ++) {
            String[] splitStr = operations[i].split(" ");
            if (splitStr[0].equals("I")) {
                // I 숫자 : 큐에 주어진 숫자를 삽입
                int val = Integer.parseInt(splitStr[1]);
                heap.insert(val);
            } else if (splitStr[1].equals("1")) {
                // D 1 : 큐에서 최댓값을 삭제
                heap.maxDelete();
            } else {
                // D -1 : 큐에서 최솟값을 삭제
                heap.minDelete();
            }
        }
        int maxVal = heap.maxDelete();
        int minVal = heap.minDelete();
        if(maxVal == 0 || minVal == 0){
            minVal = 0;
            maxVal = 0;
        }
        int[] answer = {maxVal, minVal};
        return answer;
    }
}
