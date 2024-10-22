import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        // reader.readLine()
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int cnt = 0; // 그룹 단어 카운트
        for(int i=0; i<n; i++) {
            Set<Character> set = new HashSet<>();
            String str = br.readLine();
            char[] word = str.toCharArray();
            char checker = word[0];
            boolean isGroupWord = true;
            for(int j=0;j<word.length;j++) {
                // 새로운 단어면? 셋에 추가하고 체커 이동 
                if(!set.contains(word[j])) {
                    set.add(word[j]);
                    checker = word[j];
                }
                // 기존의 단어면? 체커랑 같은지 확인
                else {
                    // 체커랑도 다른데 기존에 있다? 연속된 문자가 아님 에러 
                    if(checker != word[j]) {
                        isGroupWord = false;
                        break;
                    }
                }
            }
            if(isGroupWord) cnt += 1;
        }
        System.out.println(cnt);
    }
}