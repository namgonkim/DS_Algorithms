class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        // 1부터 s len/2 단위로 차례차례 압축 
        for(int i=1; i<= s.length()/2; i++) {
            // 압축된 문자열을 저장하는 sb 
            StringBuffer sb = new StringBuffer();
            String prevStr = "";
            int count = 1;
            
            // 단위로 문자열 자르기 
            for(int j=0; j <= s.length()-i; j=j+i) {
                // j부터 j+i (i는 압축 기준)까지 자른다
                String curStr = s.substring(j, j+i);
                
                if(prevStr.equals(curStr)) {
                    count++;
                    continue;
                }
                // 더이상 같지 않으면서 카운트가 최소 2 이상이면 압축 문자열에 카운트+문자열 담기 
                else if(count > 1) {
                    sb.append(count + prevStr);
                    count = 1;
                } 
                // 더이상 같지 않지만 카운트가 1이면 문자열만 담기
                else {
                    sb.append(prevStr);
                }
                
                // 다음 문자열 찾기 전에 현재 문자열 저장 
                prevStr = curStr;
            }
            // 끝나고 뒤에 남은 문자열도 저장 
            if(count > 1) sb.append(count+prevStr);
            else sb.append(prevStr);
            
            // s 길이가 압축 단위로 나뉘지 않을때 남는 문자열 추가 저장 
            // s.length() - s.length()%i ? 나머지로 떨어지는 값만큼 뺀 길이
            if(s.length() % i != 0) sb.append(s.substring(s.length() - s.length()%i, s.length()));
            
            // System.out.println(sb.toString());
            
            // 가장 짧은 문자열 길이 찾아서 answer에 반환 
            answer = Math.min(answer, sb.toString().length());
        }
        
        return answer;
    }
}