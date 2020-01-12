class Solution {
  public String solution(int n) {
      String answer = "";
      int nameoji = 0;
      while( n > 0 ){
          nameoji = n % 3;
          n = n / 3;

          if(nameoji == 0){
              answer = "4" + answer;
              n -= 1;
          }else{
              answer = Integer.toString(nameoji)+answer;
          }
      }
      return answer;
  }
}
