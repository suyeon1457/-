import java.util.*;

class Solution {
    static ArrayList<String> answer = new ArrayList<String>();
    static ArrayList<String> temp = new ArrayList<String>();
    static ArrayList<Boolean> visit = new ArrayList<Boolean>();

    public static Boolean dfs(String from, String[][] tickets, int cnt){
        temp.add(from);
        // 주어진 항공권 모두 사용했는지 체크
        if (cnt == tickets.length){
            answer = temp;
            return true;
        }

        for (int i = 0 ; i < tickets.length ; i++){
            if (from.equals(tickets[i][0]) && visit.get(i) == false){
              visit.set(i, true);
              boolean success = dfs(tickets[i][1], tickets, cnt + 1);
              if (success){
                  return true;
              }
              visit.set(i, false);
            }
        }
        temp.remove(temp.size() - 1);
        return false;
	}
    public static void sortArray(String[][] arr) {
        Arrays.sort(arr, new Comparator<String[]>() {
          public int compare(String[] arr1, String[] arr2) {
             if(arr1[0].compareTo(arr2[0]) != 0)
              return arr1[0].compareTo(arr2[0]);
             else
                return arr1[1].compareTo(arr2[1]);
          }
        });
    }
    public String[] solution(String[][] tickets) {
        // tickets 알파벳 순 정렬
        sortArray(tickets);
        // 방문 체크 배열 세팅
        for (int i = 0 ; i < tickets.length ; i++){
            visit.add(false);
            // System.out.println(tickets[i][0]+","+tickets[i][1]);
        }
        // 항상 ICN 공항에서 출발
        dfs("ICN", tickets, 0);

        // arrayList인 경로 array로 변경
        String[] answerArr = new String[answer.size()];
        answerArr = answer.toArray(answerArr);

        return answerArr;
    }
}
