import java.util.regex.Pattern;
class Solution {
  public String solution(String s) {
      String answer = "";
      // 문자열 소문자로 변환
      s = s.toLowerCase();
      // 변환한 소문자를 공백 기준으로 자르기
      String[] words = s.split(" ");
      // 단어별로 구성된 배열 반복문
      for(String word : words) {
          // 앞자리 알파벳 체크
          boolean c = Pattern.matches("^[a-z]*$", word);
          // 알파벳이라면 대문자로 변환
          if(c){
              if(word.length()>0){
                  word = word.substring(0,1).toUpperCase() + word.substring(1);
              }
            // System.out.println(word.length());
          }
          answer += word+" ";
      }
      // 마지막 공백 제거
      answer = answer.substring(0, answer.length()-1);
      // 문자열 길이가 다를때 마지막 문자 추가 처리
      if(s.length() != answer.length()){
          answer+=s.substring(s.length()-1);
      }
      return answer;
  }
}
