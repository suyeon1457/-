import java.util.Stack;
class Solution {
    public int solution(String stick) {
        int answer = 0; // ���ܵ� �踷��� �����
        String stick_point = stick.replace("()","p"); // ������ ����Ʈ �ѱ��ڷ� ��ȯ
        Stack<String> stack = new Stack<>(); //�ڸ� �踷��� ����
        
        for(int i=0;i<stick_point.length();i++){             
            if(stick_point.charAt(i)=='('){// ���� ��ȣ ��������
                stack.push("(");
            }
            else if(stick_point.charAt(i)=='p'){// ������ ����Ʈ�� ���� �� ����
                answer += stack.size();
            }
            else if(stick_point.charAt(i)==')'){// ���ڸ� ����� +1 �� ���ÿ��� ����
                if(stack.size() > 0){
                    stack.pop();   
                }
                answer += 1;
            }
        }
        return answer;
    }
}