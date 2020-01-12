class Solution
{
    public int chkPalindrome(String s){
        // int len = s.length();
        // int left = 0;
        // int right = len - 1;
        // while((right - left) > 1){
        //     // System.out.println(s.substring(right,right+1));
        //     // System.out.println(s.substring(left,left+1));
        //     if(s.substring(right,right+1).equals(s.substring(left,left+1))){
        //         return 0;
        //     }
        //     left += 1;
        //     right -=1;
        // }
        // return 1;
        StringBuffer reverse = new StringBuffer(s);
        String reverseStr = reverse.reverse().toString();
        if(s.equals(reverseStr)){
            return 1;
        }
        return 0;
    }
    
    public int solution(String s)
    {
        int answer = 0; // 최종결과값
        int len = s.length();
        for(int i = 0; i<len; i++){
            // System.out.println("i:"+Integer.toString(i));
            for(int j = len; j>i; j--){
                // System.out.println("j:"+Integer.toString(j));
                // System.out.println(s.substring(i,j));
                // System.out.println(chkPalindrome(s.substring(i,j)));
                if(chkPalindrome(s.substring(i,j)) == 1){
                    // System.out.println(s.substring(i,j).length()>answer);
                    if(s.substring(i,j).length() > answer){
                        answer = s.substring(i,j).length();
                    }
                }
            }
        }
        return answer;
    }
}