class Solution {
  public String solution(String s) {
      String answer = "";
      String[] arr = s.split(" ");//문자열 공백기준 배열만들기

      int max = Integer.parseInt(arr[0]); //최대값 넣을 변수
      int min = Integer.parseInt(arr[0]); //최소값 넣을 변수

      for(int i = 0; i < arr.length; i++) {
        //비교할 값 세팅 - int형으로 변환
        int val = Integer.parseInt(arr[i]);
        //최대값         
        if(max<val) {
         max = val;
        }
        //최소값
        if(min>val) {
         min = val;
        }
      }
      
      answer = String.valueOf(min)+" "+String.valueOf(max);
      return answer;
  }
}