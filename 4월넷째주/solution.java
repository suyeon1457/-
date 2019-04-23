import java.util.*;
class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Integer> qu = new LinkedList<Integer>();
		for (int i : priorities) {
			qu.offer(i);
		}
		int i = 0;
		while (!qu.isEmpty()) {
			boolean bool = true;
			Integer v1 = qu.poll();
			for (Integer v2 : qu) {
				if (v1.intValue() < v2.intValue()) {
					qu.offer(v1);
					bool = false;
					if (location == 0) {
						location = qu.size();
					}
					break;
				}
			}
			if (bool) {
				answer++;
			}
			if (location == i) {
				break;
			}
			if (location > 0) {
				location--;
			}
		}
		return answer;
	}
}
