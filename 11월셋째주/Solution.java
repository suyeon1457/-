class Solution {
  public int[] solution(int n, int s) {
      if(s < n){
      	int[] answer = {-1};
      	return answer;
      }
      int share = s/n;
      int rest = s%n;
      int[] answer = new int[n];
      //몫을 배열에 넣어줌
      for(int i = 0 ; i < answer.length ; i++){
      	answer[i] = share;
      }
      //나머지 값들 뒷 배열에 차례로 +1
      for(int i = 1 ; i <= rest ; i++){
      	answer[answer.length-i] += 1;
      }
      return answer;
  }
}