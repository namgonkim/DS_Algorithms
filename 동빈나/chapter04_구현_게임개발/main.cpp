#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
/*
제목: 게임 개발
문제: 게임 캐릭터가 방문한 칸의 수를 출력하는 프로그램
유형: 구현
날짜: 2021-04-26
이름: @namgonkim
*/
using namespace std;

// [y][x] =  북, 동, 남, 서
int dy[4] = { -1, 0, 1, 0 }; // y 는 위아래 움직임
int dx[4] = { 0, 1, 0, -1 };  // x 는 양옆 움직임

int px = -1, py = -1, dir = -1; // 현재 위치 x,y 방향
vector<vector<bool>> visit;  // 육지 중 가본 곳

int direction() {
    dir = dir - 1;
    if (dir == -1) // 북쪽에서 서쪽으로 갈때
        dir = 3;
    return dir;
}

int solution(vector<vector<int>> &map, int n, int m) {
    int turn_count = 0; // 방향 전환 횟수
    int count = 1; // 움직임 횟수
    int nx, ny = -1; // 움직임
    visit[py][px] = true;
    while (true) {
        // 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향(반시계 90도)으로 차례대로 갈 곳을 정한다.
        int direct = direction();
        ny = py + dy[direct];
        nx = px + dx[direct];
        // 2. 왼쪽 방향에 가보지 않은 칸이 존재, 그쪽으로 한칸 이동
        if (visit[ny][nx] == false && map[ny][nx] == 0) { // 육지: 0
            visit[ny][nx] = true; // 방문
            py = ny;
            px = nx;
            count = count + 1;    // 움직임 횟수 체크
            turn_count = 0;       // 방향 전환 횟수 초기화
        }
        // 3. 가보지 않은 칸이 없다면, 회전
        else {
            turn_count = turn_count + 1;
        }
        // 4. 네 방향이 바다인 경우, 바라보는 방향을 유지한 채 뒤로 이동
        if (turn_count == 4) {
            ny = py - dy[direct];
            nx = px - dx[direct];
            // 5. 뒤쪽이 바다라면 움직임을 멈춤
            if (map[ny][nx] == 1)
                break;
            // 6. 뒤쪽이 육지라면 뒤로 이동
            else {
                py = ny;
                px = nx;
            }
            turn_count = 0;
        }
        
    }
    return count;
    
}
int main() {
    int n, m; // 세로, 가로
    cin >> n >> m;
    vector<vector<int>> map(n, vector<int>(m, 0));
    visit.resize(n + 1, vector<bool>(m + 1, false));
    cin >> px >> py >> dir; 
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> map[i][j]; // 바다: 1 육지: 0
        }
    }
    int answer = solution(map, n, m);
    cout << answer << endl;
    
    return 0;
}