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
제목: 연구소
문제: NxM크기의 연구소에서 바이러스를 피해 안전한 영역 크기의 최대값을 구하는 프로그램
유형: DFS
날짜: 2021-05-17
이름: @namgonkim

*/

using namespace std;

int n, m; // 세로 n 가로 m
vector<vector<int>> graph;

int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };

vector<vector<int>> map;
int result = 0; // 최대로 안전한 영역 결과값


// 바이러스 확산에 대한 dfs알고리즘
void dfs(int y, int x) {

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		// 상하좌우 탐색해 바이러스 확산
		if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
			if (map[ny][nx] == 0) {
				map[ny][nx] = 2;
				// 인접한 방에 대해서도 dfs
				dfs(ny, nx);
			}
		}
	}
}

// 벽을 세울 수 있는 모든 경우의 수를 고려하면서, 벽3개를 세우면 DFS를 통해 안전한 영역의 크기를 구하고, 이 과정의 전체 중 가장 영역이 큰 값을 출력한다.
void solution(int count) {

	// 벽을 3개 다 세우면 안전한 영역 찾기 진행
	if (count == 3) {
		// DFS 진행할 임시 그래프 초기화 및 세팅
		map.resize(n + 1, vector<int>(m + 1, 0));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = graph[i][j];
			}
		}

		// 바이러스에 대한 DFS 진행
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					dfs(i, j);
				}
			}
		}
		
		// 해당 그래프에 대한 안전한 영역
		int safe = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					safe += 1;
				}
			}
		}
		result = max(result, safe);
		return;
	}

	// 벽 세우기
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (graph[i][j] == 0) {
				graph[i][j] = 1;
				count += 1;
				solution(count);
				graph[i][j] = 0;
				count -= 1;
			}
		}
	}
}

int main() {

	cin >> n >> m;

	graph.resize(n, vector<int>(m, 0));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> graph[i][j];
		}
	}

	solution(0);
	cout << result << endl;
}
