import java.util.*;
import java.io.*;

public class Main {
    public static int[] back;
    public static void main(String args[]) throws Exception {
        
        // reader.readLine()
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        back = new int[n+1];
        for(int i=1;i<=n;i++) {
            back[i] = i;
        }
        
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // a와 b 바구니 번호를 변경 
            int temp = back[b];
            back[b] = back[a];
            back[a] = temp;
        }
        
        for(int i=1;i<=n;i++) System.out.println(back[i]);
    }
}