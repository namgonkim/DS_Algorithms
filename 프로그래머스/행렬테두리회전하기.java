package solution;

import java.util.*;
/*
이름: 행렬 테두리 회전하기
유형: 구현
날짜: 2021.06.23
 */
class Solution {

    static int[][] maps;
    final static int MIN = 10001;

    public static int rotation(int y1, int x1, int y2, int x2){
        int minor = MIN;
        int next;
        int prev;

        // 오른쪽(왼쪽으로 맞춘다)
        // 도착점 저장
        next = maps[y1][x2];
        for(int i=x2;i > x1; i--) {
            maps[y1][i] = maps[y1][i-1];
        }

        // 아래(위쪽으로 맞춘다)
        // 전 도착점 및 현 도착점 저장
        prev = next;
        next = maps[y2][x2];
        for(int i=y2; i > y1+1; i--) {
            maps[i][x2] = maps[i-1][x2];
        }
        // 전 도착점 변경
        maps[y1+1][x2] = prev;


        // 왼쪽(오른쪽으로 맞춘다)
        prev = next;
        next = maps[y2][x1];
        for(int i=x1; i < x2-1; i++) {
            maps[y2][i] = maps[y2][i+1];
        }
        // 전 도착점 변경
        maps[y2][x2-1] = prev;

        // 위(아래쪽으로 맞춘다)
        for(int i=y1; i < y2-1; i++) {
            maps[i][x1] = maps[i+1][x1];
        }
        // 전 도착점 변경
        maps[y2-1][x1] = next;

        // 최소값 찾기
        for(int i=x1;i <= x2;i++) {
            minor = Math.min(minor, maps[y1][i]);
            minor = Math.min(minor, maps[y2][i]);
        }
        for(int i=y1; i<= y2;i++){
            minor = Math.min(minor, maps[i][x1]);
            minor = Math.min(minor, maps[i][x2]);
        }

    return minor;
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        maps = new int[rows][columns];
        int num = 1;

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                maps[i][j] = num++;
            }
        }
        int idx = 0;
        for(int[] node : queries) {
            answer[idx++] = rotation(node[0]-1, node[1]-1, node[2]-1, node[3]-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        //6	6	[[2,2,5,4],[3,3,6,6],[5,1,6,3]]	            [8, 10, 25]
        //3	3	[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
        //100	97	[[1,1,100,97]]	                        [1]
        int rows = 6;
        int columns = 6;
        int[][] queries = {
                {2,2,5,4},{3,3,6,6},{5,1,6,3}
        };
        int[] answer = solution(rows, columns, queries);
        for(int i : answer) System.out.println(i);
    }
}