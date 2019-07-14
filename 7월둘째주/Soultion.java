class Solution {
    public int solution(int[][] baseball) {
        int answer = 0;
        for(int j = 123 ; j<=987 ; j++){
            String checkNumStr = Integer.toString(j);
            String[] checkNum = checkNumStr.split("");

            // 세자리 같은 수, 0이 포함되면 건너뛰기
            if(checkNum[0].equals(checkNum[1]) || checkNum[1].equals(checkNum[2]) || checkNum[0].equals(checkNum[2]) || checkNumStr.contains("0")){
                continue;
            }
            for(int i = 0 ; i<baseball.length ; i++){
                int strike = 0;
                int ball = 0;

                // baseball 배열 비교
                // 스트라이크 부분
                String[] baseballStr = Integer.toString(baseball[i][0]).split("");
                if(baseballStr[0].equals(checkNum[0])){
                    strike++;
                }
                if(baseballStr[1].equals(checkNum[1])){
                    strike++;
                }
                if(baseballStr[2].equals(checkNum[2])){
                    strike++;
                }
                if(strike != baseball[i][1]){
                    break;
                }
                // 볼 부분
                if(baseballStr[0].equals(checkNum[1]) || baseballStr[0].equals(checkNum[2])){
                    ball++;
                }
                if(baseballStr[1].equals(checkNum[0]) || baseballStr[1].equals(checkNum[2])){
                    ball++;
                }
                if(baseballStr[2].equals(checkNum[0]) || baseballStr[2].equals(checkNum[1])){
                    ball++;
                }
                if(ball != baseball[i][2]){
                    break;
                }
                if(i == baseball.length -1){
                    answer++;
                }
            }
        }
        return answer;
    }
}
