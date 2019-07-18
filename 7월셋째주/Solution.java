import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //내림차순 정렬
		Arrays.sort(lost);
		Arrays.sort(reserve);
        //총학생수에서 잃어버린 사람 빼기
		answer = n - lost.length;
        //중복제거
		for(int i = 0 ; i<reserve.length;i++){
			for(int j = 0 ; j<lost.length;j++){
	            if(reserve[i] == lost[j]){
	            	answer++;
	            	reserve[i] = 0;
	            	lost[j] = 0;
                    break;
	            }
			}
        }
        //여벌 학생 앞뒤학생에게 빌려줌
        for(int i = 0 ; i<reserve.length;i++){
			for(int j = 0 ; j<lost.length;j++){
	            if(reserve[i] != 0 && lost[j]!= 0 &&(reserve[i]-1 == lost[j] || reserve[i]+1 == lost[j])){
	            	answer++;
	            	reserve[i] = 0;
	            	lost[j] = 0;
                    break;
	            }
			}
        }
        return answer;
    }
}