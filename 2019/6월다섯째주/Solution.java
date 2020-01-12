class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 내림차순 정렬
        for(int i = 0; i<citations.length; i++){
            for(int j = i+1 ; j<citations.length; j++){
                if(citations[i] < citations[j]){
                    int temp = citations[i];
                    citations[i] = citations[j];
                    citations[j] = temp;
                }
            }
        }
        
        // H-Index 구하기
        for(int i = 0; i<citations.length; i++){
            if((i+1) == citations[i]){// 순위와 인용횟수가 같은 경우
                answer = i+1;
                break;
            } 
            else if((i+1) > citations[i]){// 순위와 인용횟수가 작을 경우
                answer = i;// +1을 안해줌으로써 전순위가 들어감
                break;
            } 
            else{// 순위보다 인용횟수가 클때는 결과 값에 +1
                answer += 1;
            }
        }
        return answer;
    }
}