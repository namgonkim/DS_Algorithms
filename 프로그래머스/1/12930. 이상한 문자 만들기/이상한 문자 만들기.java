class Solution {
    public String solution(String s) {
        String answer = "";
        // 한 단어씩 다 배열에 저장 
        String[] tokens = s.split("");
        // 문자의 인덱스
        int idx = 0;
        for(String token : tokens) {
            // System.out.println("["+token+"]");
            // 공백을 만나면 인덱스를 0으로 초기화, 아닐때는 덧셈
            if(token.equals(" ")) {
                idx = 0;
            } else {
                idx += 1;
            }
            
            // 인덱스가 2로 나눠질때 대문자로 변환 아닐때 소문자로 변환
            if(idx % 2 != 0) {
                token = token.toUpperCase();
            } else {
                token = token.toLowerCase();
            }
            // 재결합
            answer = answer + token;
        }
        
        return answer;
    }
}