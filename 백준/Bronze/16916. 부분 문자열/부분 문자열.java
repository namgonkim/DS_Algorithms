import java.util.*;
import java.io.*;

public class Main {
    public static int[] table;
    public static void makeTable(char[] pattern) {
        table = new int[pattern.length];
        Arrays.fill(table, 0);
        // 접두사와 접미사의 최대 일치 길이를 구하는 테이블
        // j는 같은 문자를 찾았을 때 +1, 다른 문자면 -1
        int j = 0;
        for(int i = 1; i < pattern.length; i++) {
            while(j > 0 && pattern[i] != pattern[j]) {
                j = table[j-1];
            }
            // i와 j 문자가 같다면 j에 1을 더하고 table의 i지점에 그 값을 넣는다.
            if(pattern[i] == pattern[j]) {
                j += 1;
                table[i] = j;
            }
        }
    }

    // 문자열 내 패턴을 찾는데 패턴이 찾아지지 않으면 문자열 내에서 마지막까지 찾은 문자의 직전 접미사를 패턴의 접두사 다음 문자 위치로 옮긴다. 
    public static int kmp(char[] str, char[] pattern) {
        int j=0;
        // 전체 문자열을 순회하면서
        for(int i=0;i<str.length;i++) {
            // 문자열과 패턴이 다르면 패턴의 인덱스를 조정한다. 마지막까지 찾은 접두사(공통문자열)의 끝부분을 패턴의 접미사 다음 문자로 이동, 언제까지? 0이 되거나 다음으로 찾는 문자가 같을떄까지
            while(j > 0 && str[i] != pattern[j]) {
                j = table[j-1];
            }
            // 문자열 단어와 패턴 단어가 같을 때
            if(str[i] == pattern[j]) {
                // 패턴 길이까지 도달했다면 찾은것
                if(j == pattern.length - 1) {
                    // 추가로 더 뽑으려면
//                     j = table[j]; // 현재 공통 문자열 길이(접두사 길이)만큼의 값을 j에 저장해 해당 문자부터 다시 점검하도록 한다. 왜? 직전에 찾은 패턴이 같았으니 그 뒤에 나오는 문자부터 찾을거고 그랬을 때 접두사 부분은 굳이 다시 보지 않아도 되기 때문.
                    return 1;
                } else {
                    j += 1; // i를 더하는 만큼 j도 더하며 서로의 다음 문자를 확인
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) throws Exception {

        // reader.readLine()
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        char[] p = br.readLine().toCharArray();
        // kmp 테이블
        makeTable(p);
        // 알고리즘
        int result = kmp(str, p);
        System.out.println(result);

    }
}
