class Solution {
  public String solution(String s) {
      String answer = "";
      String[] arr = s.split(" ");//���ڿ� ������� �迭�����

      int max = Integer.parseInt(arr[0]); //�ִ밪 ���� ����
      int min = Integer.parseInt(arr[0]); //�ּҰ� ���� ����

      for(int i = 0; i < arr.length; i++) {
        //���� �� ���� - int������ ��ȯ
        int val = Integer.parseInt(arr[i]);
        //�ִ밪         
        if(max<val) {
         max = val;
        }
        //�ּҰ�
        if(min>val) {
         min = val;
        }
      }
      
      answer = String.valueOf(min)+" "+String.valueOf(max);
      return answer;
  }
}