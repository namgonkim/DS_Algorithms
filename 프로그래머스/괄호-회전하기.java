import java.util.*;
/*
문제: 괄호 회전하기, 월간 코드 챌린지 시즌2
유형: 스택, 문자열 조합
날짜: 2021 08 31 화
*/
class Solution {

    public static int solution(String s) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        ArrayList<String> words = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        // 모든 괄호의 수 만들기
        for(int i=0;i<s.length();i++) {
            // 한칸씩 이동되며 i 부터 끝까지 문자열에 우선 삽입
            for(int j=i;j<s.length();j++) {
                sb.append(s.charAt(j));
            }
            
            // 남아있는 괄호, 즉 0~i까지에 대해 문자열 뒤에 삽입
            if(sb.length() < s.length()){
                for(int idx=0;idx<i;idx++){
                    sb.append(s.charAt(idx));
                }
            }
            // 괄호 문자열 저장 및 sb 초기화
            words.add(sb.toString());
            sb.delete(0, sb.length());
        }
        for(int i=0;i<words.size();i++) {
            String word = words.get(i);
            boolean wordIsCorrect = true;
            // 닫힌 문자열부터 시작하면 종료
            if(word.charAt(0) == ')' || word.charAt(0) == ']' || word.charAt(0) == '}') {
                continue;
            }
            for(int j=0;j<word.length();j++) {
                // 열린 문자열이면
                if(word.charAt(j) == '(' || word.charAt(j) == '[' || word.charAt(j) == '{') {
                    stack.push(word.charAt(j));
                }
                else{
                    // 큐에 데이터가 있어야 정상, 그래야 올바른 괄호 문자열
                    if(stack.isEmpty() == false){
                        char c = stack.pop();
                        if(c == '(' && word.charAt(j) == ')')
                            continue;
                        else if(c == '{' && word.charAt(j) == '}')
                            continue;
                        else if(c == '[' && word.charAt(j) == ']')
                            continue;
                        else {
                            wordIsCorrect = false;
                            break;
                        }

                    }
                    // 데이터가 없는데 ] 가 들어온다? 바로 올바르지 않음
                    else {
                        wordIsCorrect = false;
                        break;
                    }

                }
            }
            // 올바른 괄호 문자열인지와 큐에 데이터가 없는지 조사
            if(wordIsCorrect == true && stack.isEmpty())
                answer += 1;
        }

        return answer;
    }

    // 테스트 케이스
    public static void main(String[] args) {
        // s	result
        //"[](){}"	3
        //"}]()[{"	2
        //"[)(]"	0
        //"}}}"	0
        String[] s = {
                "[](){}", "}]()[{", "[)(]", "}}}"
        };
        for(int i=0;i<4;i++) {
            System.out.println(solution(s[i]));
        }
    }
}