#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<stdio.h>
/*
제목: 음료수 얼려먹기
문제: 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램
유형: DFS/BFS
날짜: 2021-04-26
이름: @namgonkim
*/
using namespace std;

// 상 하 좌 우
int dx[4] = {  0, 0, -1, 1 };
int dy[4] = { -1, 1,  0, 0 };
vector<vector<int>> graph;
vector<vector<bool>> visited;
int n, m; // 세로, 가로

/*재귀 DFS를 이용해 인접한 구멍끼리 묶는다.*/
void dfs(int y, int x) {
    visited[y][x] = true;
    // 2. 인접 노드(구멍) 상하좌우 탐색
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        // 3. 배열 범위를 초과하지 않고
        if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
            // 4. 방문하지 않은 구멍이라면 탐색
            if (visited[ny][nx] == false && graph[ny][nx] == 0) {
                dfs(ny, nx);
            }
        }
    }
    return;
}

int solution(int n, int m) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            // 1. 현재 좌표를 방문하지 않았고 구멍(0)이라면 깊이우선탐색(DFS) 시작
            if (visited[i][j] == false && graph[i][j] == 0) {
                dfs(i, j);
                answer = answer + 1; // 인접 노드 탐색이 끝나면 아이스크림 생성 개수 증가
            }
        }
    }

    return answer;
    
}
int main() {
    cin >> n >> m;
    graph.resize(n, vector<int>(m, 0));
    visited.resize(n, vector<bool>(m, false));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            // TIL. %1d: 연속된 숫자를 1개씩 쪼개서 배열에 저장한다.
            scanf("%1d", &graph[i][j]);
        }
    }
    int answer = solution(n, m);
    cout << answer << endl;
    return 0;
}