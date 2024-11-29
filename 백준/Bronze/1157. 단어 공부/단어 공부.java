import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {

        // reader.readLine()
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] c = st.nextToken().toUpperCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<c.length;i++) {
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
        }
        int max = 0;
        // 가장 많이 사용된 알파벳 
        for(char key : map.keySet()) {
            if(map.get(key) > max) max = map.get(key);
        }
        int cnt = 0;
        char answer = 0;
        for(char key : map.keySet()) {
            if(map.get(key) == max) {
                cnt++;
                answer = key;
            }
        }
        if(cnt > 1) {
            System.out.println("?");
        } else {
            System.out.println(answer + "");
        }
    }
}