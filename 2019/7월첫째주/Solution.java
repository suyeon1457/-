import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 내림차순으로 배열정렬 : [112123,112] -> [112,112123]
        Arrays.sort(phone_book);
        //반복문을 통해 접두어 확인 체크
        for(int i = 0; i < phone_book.length; i++){
            for(int j = i+1; j < phone_book.length; j++){
                if(phone_book[j].startsWith(phone_book[i])){
                    answer = false;
                    break;
                }
            }
            if(answer == false){
                break;
            }
        }
        return answer;
    }
}