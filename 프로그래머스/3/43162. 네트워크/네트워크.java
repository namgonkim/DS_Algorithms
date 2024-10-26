import java.util.*;
class Solution {
    public static int[] parent;
    // 1 0 0 0 1
    // 0 1 1 0 0 
    // 0 1 1 1 0
    // 0 0 1 1 1
    // 1 0 0 1 1
    
    public static int findParent(int x) {
        if(parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }
    
    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        for(int i=0;i<computers.length;i++) {
            for(int j=0;j<computers.length;j++) {
                if(i!=j && computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        int answer = 0;
        // parent 테이블에서 다른 원소 나오면 +1 
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<parent.length;i++) {
            set.add(findParent(parent[i]));
        }
        return set.size();
    }
}