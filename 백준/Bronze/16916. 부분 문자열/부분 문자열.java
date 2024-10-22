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

    public static int kmp(char[] str, char[] pattern) {
        int j=0;
        // 전체 문자열을 순회하면서
        for(int i=0;i<str.length;i++) {
            // 문자열 단어와 패턴 단어가 다르는동안 테이블의 j-1 값을 j로 변경한다. 즉 j를 뒤로 물린다.
            while(j > 0 && str[i] != pattern[j]) {
                j = table[j-1];
            }
            // 문자열 단어와 패턴 단어가 같을 때
            if(str[i] == pattern[j]) {
                // 패턴 길이까지 도달했다면
                if(j == pattern.length - 1) {
                    // 찾았음
                    // 추가로 더 뽑으려면
//                     j = table[j]; // (j를 앞으로 넘긴다)
                    return 1;
                } else {
                    j += 1;
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
