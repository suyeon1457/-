import java.util.*;
class Solution {
    public int solution(int[] weight) {
        // 오름차순 정렬
        Arrays.sort(weight);
        // 최솟값 세팅
        int answer = 1;
        for(int i = 1 ; i < weight.length ; i++){
            // 1보다 작다면 멈춤
            if(weight[0] > 1){
                break;
            }
            // 다음 저울추의 무게가 총 저울추 무게 더한 값보다 클때 멈춤 
            if(weight[i] > answer + 1){
                answer += 1;
                break;
            }
            // 저울추 무게 합
            answer += weight[i];
            // 마지막 배열의 합까지 앞 조건에 해당이 안되었으면
            if(weight.length == (i+1)){
                answer += 1;
            }
        }
        return answer;
    }
}