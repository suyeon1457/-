class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int user = 1;
        int count = 1;
        boolean chk = false;

        String lastWord = words[0].substring(words[0].length()-1);
        String firstWord = lastWord;
        String[] words_arr = new String[words.length];
        words_arr[0] = words[0];

        for(int i=1; i<words.length; i++) {
            words_arr[i] = words[i];

            if(user == n){
                user = 1;
            } else {
                user = user + 1;
            }

            for(int j=0; j<words_arr.length; j++) {
                if(j == i){
                    break;
                }
                if(words_arr[j].equals(words[i])){
                    answer[0] = user;
                    answer[1] = count;
                    chk = true;
                    break;
                }
            }
            lastWord = words[i-1].substring(words[i-1].length()-1);
            firstWord = words[i].substring(0,1);

            if(!(lastWord.equals(firstWord))){
                answer[0] = user;
                answer[1] = count;
                chk = true;
            }

            if(chk){
                break;
            }

            if((i+1) % n == 0){
                count += 1;
            }
        }
        return answer;
    }
}
