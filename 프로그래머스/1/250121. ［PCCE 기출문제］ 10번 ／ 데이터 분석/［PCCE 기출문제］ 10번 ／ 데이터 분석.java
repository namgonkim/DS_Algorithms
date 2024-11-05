import java.util.*;
class Solution {    
    // data에서 ext값이 val_ext보다 작은 데이터만 뽑고 sort_by 기준으로 오름차순 정렬 
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        // ext 찾기
        int idx = getSearchItem(ext);
        // sort_by 찾기
        int orderBy = getSearchItem(sort_by);
        // val_ext보다 작은 데이터 뽑기 
        for(int[] req : data) {
            if(req[idx] < val_ext) {
                list.add(req);
            }
        }
        // 정렬
        Collections.sort(list, (o1, o2) -> o1[orderBy] - o2[orderBy]);
        
        int[][] answer = new int[list.size()][4];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int getSearchItem(String ext) {
        if(ext.equals("code")) {
            return 0;
        } else if(ext.equals("date")) {
            return 1;
        } else if(ext.equals("maximum")) {
            return 2;
        } else if(ext.equals("remain")) {
            return 3;
        }
        return 0;
    }
}