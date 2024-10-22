import java.util.*;
import java.io.*;

public class Main {
    public static int[] back;
    public static void main(String args[]) throws Exception {
        
        // reader.readLine()
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n: 공이랑 바구니의 1~n 번호, 바구니 갯수 / m: 공을 넣는 방법 주어짐
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        back = new int[n+1];
        Arrays.fill(back, 0);
        
        // a번 바구니부터 b번 바구니까지 c번 번호가 적혀져 있는 공을 넣는다.
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            for(int j=a;j<=b;j++) {
               back[j] = c;
            }
        }
        
        // 출력
        for(int i=1;i<back.length;i++) {
            System.out.println(back[i]);
        }
        
    }
}