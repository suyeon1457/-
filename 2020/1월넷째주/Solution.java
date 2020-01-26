import java.util.*;

class Solution {
    // 이분탐색 재귀 함수
    public static int binarySearch(int[] arr, int start, int end, int m) {
        int mid = (start + end) / 2;
        long total = 0;
        
        for (int i = 0; i < arr.length; i++){
            if(mid > arr[i]){
                total += arr[i];
            } else{
                total += mid;
            }
        }
        // 금액 체크해서 start와 end 값 다시 설정
        if (total > m && start == end){
            start -= 1;
            end -= 1;
        }
        else if (total > m){
            end = mid;
        }
        else{
            start = mid + 1;
        }
        // start가 end보다 크거나 총금액이 예산과 같으면
        if( start > end || total == m){
            return mid;
        }
        return binarySearch(arr, start, end, m);
    }
    public int solution(int[] budgets, int M) {
        // 오름차순 정렬
        Arrays.sort(budgets);
        
        int answer = 0;
        int start = 0;
        int end = budgets[budgets.length-1];
        
        answer = binarySearch(budgets, start, end, M);
        return answer;
    }
}