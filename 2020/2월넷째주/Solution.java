class Solution {
    static int answer = 0,tg = 0, nLen = 0;
    static int[] arrNum = null;

    public static void dfs(int sum,int idx) {
        if(idx == nLen){
            if(tg == sum){
                answer += 1;
            }
            return;
        }

        dfs(sum+arrNum[idx],idx+1);
        dfs(sum-arrNum[idx],idx+1);
    }

    public int solution(int[] numbers, int target) {
        tg = target;
        nLen = numbers.length;
        arrNum = new int[nLen];

        for(int i = 0; i<nLen; i++){
            arrNum[i] = numbers[i];
        }

        dfs(0,0);

        return answer;
    }
}
