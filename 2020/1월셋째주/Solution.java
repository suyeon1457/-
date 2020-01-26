import java.util.*;

class Solution {
  // 문자열 시간 숫자 분으로 변경
  public static int getIntTime(String str){
      String[] timeArr = str.split(":");
      int h = Integer.parseInt(timeArr[0]);
      int m = Integer.parseInt(timeArr[1]);
      int time = ((h==0) ? 0 : h*60)+m;
      return time;
  }

  public String solution(int n, int t, int m, String[] timetable) {
      ArrayList<Integer> timeList = new ArrayList();
      for(int i = 0 ; i < timetable.length ; i++) {
          timeList.add(getIntTime(timetable[i]));
      }
      // 오름차순 정렬
      Collections.sort(timeList);

      int answerInt = 540;// 셔틀 시작 시간 "09:00"
      int count;
      int listIdx=0;
      // 셔틀 반복 운행
      for(int i = 0 ; i < n ; i++) {
          count = 1;
          for(int j = listIdx ; j < timeList.size() ; j++) {
              if((count-1) >= m){
                  break;
              }
              // 셔틀 운행 시간보다 작거나 같을때
              if(timeList.get(j) <= answerInt){
                  // 다른사람 다 탔을때
                  if (i == (n-1) && count == m) {
                    answerInt = timeList.get(j)-1;
                    break;
                }
                else {
                    count++;
                    listIdx++;
                }
            }
            else {
                break;
            }
          }
          // 셔틀 운행 간격 더하기
          if((i+1) != n){
              answerInt += t;
          }
      }
      // "HH:MM" 형식으로 변경
      String hh = Integer.toString(answerInt/60);
      String mm = Integer.toString(answerInt%60);
      String answer = (hh.length()==1)?"0"+hh:hh;
      answer += ":";
      answer += (mm.length()==1)?"0"+mm:mm;
      System.out.println(answer);
      return answer;
  }
}