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
제목: 경쟁적 전염
문제: 시험관의 크기와 바이러스의 위치 정보가 주어졌을 때, S초가 지난 후 (x,y)에 존재하는 바이러스의 종류를 출력하는 프로그램
유형: BFS
날짜: 2021-05-18
이름: @namgonkim

*/

using namespace std;

int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };

// S초 뒤, N x N 크기 시험관, 바이러스의 종류 1~k번
int s = 0, n = 0, k = 0;
// 2차원 크기 시험관, 큐에 담을 데이터 정보 넣는 배열, bfs 를 위한 큐 생성
vector<vector<int>> graph;
vector<vector<int>> datas;
queue<vector<int>> map;

/* 바이러스 번호가 낮은 순부터 정렬 */
bool compare(vector<int> a, vector<int> b) {
	if (a[0] < b[0]) return true;
	else return false;
}

/* 바이러스 전염 진행 bfs 알고리즘 */
void infection() {
	
	
	while (!map.empty()) {

		// 큐에서 바이러스 정보(종류/시간대/위치) 꺼내기
		int virus = map.front()[0];
		int time = map.front()[1];
		int x = map.front()[2];
		int y = map.front()[3];

		map.pop();

		// 해당 시간에 도달하면 종료
		if (time == s) break;

		// 인접한 공간에 대해 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 전염 진행, 큐에 푸시
			if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
				if (graph[ny][nx] == 0) {
					graph[ny][nx] = virus;
					map.push({ virus, time + 1, nx, ny });
				}
			}
		}

	}
}

int solution(int x, int y) {
	int answer = 0;
	
	// 초기 바이러스가 있는 곳을 찾아 리스트에 저장
	for (int i = 1; i < n + 1; i++) {
		for (int j = 1; j < n + 1; j++) {
			if (graph[i][j] != 0) {
				// datas {바이러스종류/시간/x/y}
				datas.push_back({graph[i][j], 0, j, i});
			}
		}
	}

	// 리스트를 바이러스 번호가 낮은 순으로 정렬
	sort(datas.begin(), datas.end(), compare);
	// 초기 바이러스 정보를 큐에 저장
	for (int i = 0; i < datas.size(); i++) {
		map.push(datas[i]);
	}
	// 빈 공간 전염 bfs 알고리즘 진행
	infection();
	// 해당 위치에 있는 바이러스 출력
	answer = graph[x][y];
	return answer;
}

int main() {
	
	// 시험관 크기, 바이러스 종류 정보 받기
	cin >> n >> k;
	// 벡터 초기화
	graph.resize(n + 1, vector<int>(n + 1, 0));
	// 시험관 내 바이러스 분포 정보 받기
	for (int i = 1; i < n + 1; i++) {
		for (int j = 1; j < n + 1; j++) {
			cin >> graph[i][j];
		}
	}
	// S초 뒤에 (x,y)에 존재하는 바이러스 정보 받기
	int x, y;
	cin >> s >> x >> y;
	// 알고리즘 진행 및 결과 출력
	int answer = solution(x, y);
	cout << answer << endl;

	return 0;
}
