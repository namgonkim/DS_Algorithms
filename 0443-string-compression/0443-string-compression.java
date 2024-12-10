class Solution {
    public int compress(char[] chars) {
        // 배열을 새로 선언하지 말고 기존 문자열을 가지고 중복 문자를 압축한 문자열의 길이를 반환.
        int n = chars.length;
        int idx = 0;
        
        for(int i=0; i<n;) {
            char prev = chars[i];
            int count = 0; // 같은 문자 체크 카운트 
            // 문자열 최종 길이를 넘기지 않으면서 같은 문자인지 확인 
            while(i<n && prev == chars[i]) {
                count++;
                i++;
                // System.out.println("prev: " + prev + ", count: " + count);
            }
            // 중복검사 끝나면 배열에 값 변경 
            chars[idx++] = prev;
            // 카운트 저장 : 2 이상부터만 
            if(count > 1) {
                for(char c : String.valueOf(count).toCharArray()) {
                    chars[idx++] = c;
                } 
            }
        }
        
        return idx;
    }
}