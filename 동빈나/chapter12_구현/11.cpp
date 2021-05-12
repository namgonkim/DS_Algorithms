#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
#include<string>
#include<stack>

/*
제목: 뱀
문제: 삼성전자 SW역량테스트
유형: 구현
날짜: 2021-05-11
이름: @namgonkim

//  사과의 위치와 뱀의 이동경로가 주어질 때 게임이 몇 초에 끝나는지 계산하라
*/

using namespace std;

// 우(동) 하(남) 좌(서) 상(북)
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int n, k; // 보드의 크기 , 사과의 개수
vector<vector<int>> board; // 보드판 [기본0 사과1 뱀2]

int l; // 뱀의 방향 변환 횟수
vector<pair<int, char>> moves; // 뱀 방향 변환 정보
queue<pair<int, int>> snake; // 뱀 위치 정보

int turn(pair<int, char> direct, int pos) {
	int direction = pos;
	// 왼쪽L 혹은 오른쪽D
	if (direct.second == 'L') {
		direction = direction - 1;
	}
	else {
		direction = direction + 1;
	}
	if (direction == -1) direction = 3;
	else if (direction == 4) direction = 0;

	return direction;
}

// 방향 전환하는 시간대 구하기
pair<int,char> turning_time(int time) {
	
	for (int i = 0; i < l; i++) {
		if (moves[i].first == time) {
			return moves[i];
		}
	}
	// 없으면 빈값 반환
	return make_pair(0,0);
}

int solution() {
	int answer = 0;
	// 시작 정보 세팅
	int y = 1, x = 1;
	int pos = 0;
	board[y][x] = 2;
	snake.push({ y,x });
	while (true) {
		int nx = x + dx[pos];
		int ny = y + dy[pos];

		// 벽 안에서 움직임을 진행하는 경우
		if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
			// 뱀의 몸통을 만났다면 종료
			if (board[ny][nx] == 2) {
				answer = answer + 1;
				break;
			}
			// 사과를 만났을 경우
			if (board[ny][nx] == 1) {
				board[ny][nx] = 2;
				snake.push({ ny,nx });
			}
			// 사과가 아닌 경우 이동 후 꼬리를 제거
			else if(board[ny][nx] == 0){
				// 머리 주입
				board[ny][nx] = 2;
				snake.push({ ny,nx }); 

				// 꼬리 제거
				int py = snake.front().first;
				int px = snake.front().second;
				snake.pop();
				board[py][px] = 0;
			}
		}
		// 벽을 만났다면 종료
		else {
			answer = answer + 1;
			break;
		}
		// 다음 위치로 머리를 이동
		y = ny;
		x = nx;

		// 시간 더하기
		answer = answer + 1;

		// 방향 전환하는지
		pair<int, char> direct = turning_time(answer);
		// 방향 전환 한다면(빈값이 아니라면)
		if(direct.first != 0)
			pos = turn(direct, pos);
	}


	return answer;
}

int main() {
	// 보드의 크기, 사과의 개수
	cin >> n >> k;
	// (1,1) 에서 (n,n) 만큼의 보드판
	board.resize(n+1, vector<int>(n+1, 0));

	// 각 사과별 위치
	for (int i = 0; i < k; i++) {
		int a, b;
		// 사과 위치 정보 저장
		cin >> a >> b;
		board[a][b] = 1;
	}

	// 뱀의 방향 변환 횟수 L
	cin >> l;
	for (int i = 0; i < l; i++) {
		int x;
		char c;
		cin >> x >> c;
		// 뱀 방향 변환 정보 저장.(X초 후에 왼쪽L 혹은 오른쪽D 90도 방향전환)
		moves.push_back({ x, c });
	}

	int answer = solution();
	cout << answer << endl;

	return 0;
}

