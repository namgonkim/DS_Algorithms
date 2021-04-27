#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<queue>
#include<stdio.h>
/*
제목: 미로탈출
문제: 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하는 프로그램
유형: DFS/BFS
날짜: 2021-04-27
이름: @namgonkim
*/
using namespace std;

vector<vector<int>>graph;
vector<vector<bool>>visited;
int n, m; // 세로 가로
// 상 하 좌 우
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { -1, 1, 0, 0 };

/* BFS 활용해 문제 해결 */
int bfs(int x, int y) {
    int count = 0;
    queue<pair<int, int>>q;
    // 1. 시작점을 큐에 쌓고 방문했음을 기록
    q.push(make_pair(y,x));
    visited[y][x] = true;
    // 2. 그래프의 노드를 탐색
    while (!q.empty()) {
        // 3. 제일 먼저 나갈 큐의 노드 거리 정보를 꺼내고 pop
        x = q.front().second;
        y = q.front().first;
        q.pop();
        // 4. 현재 노드 위치에서 네 방향 노드 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 5. 미로 내부 공간일 경우이면서
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                // 5. 방문한 적이 없고, 괴물이 없는(1) 경우라면
                if (visited[ny][nx] == false && graph[ny][nx] == 1) {
                    // 6. 노드 거리 정보를 push, 방문 체크, 움직인 칸 갯수 추가
                    visited[ny][nx] = true;
                    q.push(make_pair(ny, nx));
                    graph[ny][nx] = graph[y][x] + 1;
                }
            }
        }
    }
    // 7. 출구까지 도달하는 최소 이동 갯수
    count = graph[n - 1][m - 1];
    return count;
}

/* BFS는 시작지점에서 가까운 노드부터 차례대로 그래프의 모든 노드를 탐색하기 때문에 이 문제에 효과적이다 */
int solution() {
    int x = 0, y = 0; // 시작지점
    int answer = bfs(x, y);
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
    int answer = solution();
    cout << answer << endl;
    return 0;
}