import java.util.Stack;
class Solution {
    public int solution(String stick) {
        int answer = 0; // 절단된 쇠막대기 결과값
        String stick_point = stick.replace("()","p"); // 레이저 포인트 한글자로 변환
        Stack<String> stack = new Stack<>(); //자른 쇠막대기 스택
        
        for(int i=0;i<stick_point.length();i++){             
            if(stick_point.charAt(i)=='('){// 여는 괄호 스택저장
                stack.push("(");
            }
            else if(stick_point.charAt(i)=='p'){// 레이저 포인트시 스택 값 저장
                answer += stack.size();
            }
            else if(stick_point.charAt(i)==')'){// 다자른 막대기 +1 및 스택에서 빼기
                if(stack.size() > 0){
                    stack.pop();   
                }
                answer += 1;
            }
        }
        return answer;
    }
}