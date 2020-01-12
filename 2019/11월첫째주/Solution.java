class Solution {
    int count=0;
    public int[][] solution(int n) {
        int[][] answer = new int[(int)Math.pow(2, n)-1][2];
        Hanoi(n,1,2,3,answer);
        return answer;
    }
    public void Hanoi(int n,int a,int b,int c,int[][] result){
    if(n==1){
        result[count][0] = a;
        result[count][1] = c;
        count++;
        //System.out.printf("1.  %d >> %d,%d%n",a,c,count );
    }
    else{
        Hanoi(n-1,a,c,b,result);
        result[count][0] = a;
        result[count][1] = c;
        count++;
        //System.out.printf("2.  %d >> %d,%d%n",a,c,count );
        Hanoi(n-1,b,a,c,result);
    }
  }
}
