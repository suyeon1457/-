class Solution {
  public long solution(int n) {
      long answer = fibo(n);
      return answer % 1234567;
  }
  public long fibo(int n) {
      if(n <= 1)
          return n;
      else{
        long[] fibArray = new long[n+1];
        fibArray[0] = 1;
        fibArray[1] = 2;
        for (int i = 2; i <= n; i++) {
          fibArray[i] = (fibArray[i-1] + fibArray[i-2]) % 1234567;
        }
        return fibArray[n-1];
      }
  }
}