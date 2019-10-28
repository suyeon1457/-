class Solution {
  public int solution(int n) {
      int answer = 0;
      int tmp = 1;
      int tmp2 = 1;
      if(n <= 2){
          return n;
      } else {
        for(int i = 2; i<=n ; i++){
            answer = (tmp+tmp2) % 1000000007;
            tmp = tmp2;
            tmp2 = answer;
        }
      }
      return answer % 1000000007;
  }
}
