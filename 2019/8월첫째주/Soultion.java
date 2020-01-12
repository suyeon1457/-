class Solution {
    public int[] solution(int[] prices) {
        // 결과 배열 선언
        int[] answer = new int[prices.length];
        // 금액 배열 반복문
        for(int i=0;i<prices.length;i++){
            int count = 0; // 떨어지지 않은 기간
            // 현재 값 이후 배열 반복문
            for(int j=i+1;j<prices.length;j++){
                // 값이 같거나 커질때
                if(prices[i] <= prices[j]){
                    count++;
                }else{
                    //값이 떨어졌을때
                    count++;
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}