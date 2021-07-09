package programmers.codechallenge;

/*
문제 : 쿼드압축 트리 구현하기
유형 : 분할정복, 재귀
날짜 : 2021.07.09 (금)
 */
public class QuadCompression {
    static int zCount = 0;
    static int oCount = 0;

    public static void main(String[] args) {
        // [[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]	[4,9]
        // [[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],
        // [0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]	[10,15]

        QuadCompression qc = new QuadCompression();
        int[][] arr = {
                {1,1,0,0},
                {1,0,0,0},
                {1,0,0,1},
                {1,1,1,1}
        };
        int [] answer = qc.solution(arr);
        for(int item : answer){
            System.out.println(item);
        }

    }
    // 압축이 가능한지 확인하는 함수
    public boolean isCompress(int row, int col, int[][] arr, int size) {
        int finder = arr[row][col];
        for(int i=row;i<row+size;i++) {
            for(int j=col;j<col+size;j++) {
                if(arr[i][j] != finder){
                    return false;
                }
            }
        }
        return true;
    }
    // 쿼드트리 메인 함수
    public void QuadTree(int row, int col, int[][] arr, int size) {
        // 압축이 가능하면 압축할 번호를 카운트
        if(isCompress(row, col, arr, size) == true) {
            if(arr[row][col] == 0) zCount += 1;
            else oCount += 1;
            return;
        }
        // 아니라면 분할 정복 시작
        // 왼쪽 위
        QuadTree(row, col, arr, size/2);
        // 오른쪽 위
        QuadTree(row, col + size/2, arr, size/2);
        // 왼쪽 아래
        QuadTree(row + size/2, col, arr, size/2);
        // 오른쪽 아래
        QuadTree(row + size/2, col + size/2, arr, size/2);
    }

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int size = arr.length;
        QuadTree(0,0,arr,size);
        answer[0] = zCount;
        answer[1] = oCount;
        return answer;
    }
}