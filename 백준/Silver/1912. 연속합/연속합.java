import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i+1] = Integer.parseInt(st.nextToken());
        }
        // 지금 값이 이전까지 더한값 + 지금 값 보다 크면 지금값, 작으면 이전까지 더한값 + 지금 값
        // dp[i] = dp[i-1] + arr[i] or arr[i] to max
        int max = arr[1];
        for(int i=1;i<=n;i++) {
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}