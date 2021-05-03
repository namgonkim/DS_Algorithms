#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 미래 도시
문제: A가 1번회사에서 출발해 K번 회사를 방문한 뒤 X번 회사로 가는 최단 경로를 구하는 프로그램
유형: 플로이드 워셜 알고리즘
날짜: 2021-05-03
이름: @namgonkim
*/

using namespace std;

const int INF = 1e9;
int n, m;					// n 노드 갯수, m 간선 갯수
vector<vector<int>> graph;	// 2차원 그래프
int x, k;					// k회사를 거쳐 x 회사로 간다.

// 1를 1, u를 x, j를 k 라 가정했을 때, 1에서 k를 거쳐 x까지인 경우를 구하면 된다.
int solution() {
	int answer = 0;
	// 1. 플로이드 워셜 알고리즘 진행
	for (int u = 1; u <= n; u++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// 2. 최단 경로 구현
				graph[i][j] = min(graph[i][j], graph[i][u] + graph[u][j]);
			}
		}
	}
	// 3. 거리 구하기 1 to k + k to x
	answer = graph[1][k] + graph[k][x];
	// 4. 갈 수 없는 경우라면 -1을 반환
	if (answer >= INF)
		answer = -1;

	return answer;
}

int main() {
	cin >> n >> m;
	// 1. 그래프 초기화
	graph.resize(n + 1, vector<int>(n + 1, INF));
	// 2. 자기자신은 0으로 세팅
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == j) {
				graph[i][j] = 0;
			}
		}
	}
	// 3. 노드간 이동이 가능한 간선에 대한 거리 시간값 입력
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		// 양방향 이동이 가능
		graph[a][b] = 1;
		graph[b][a] = 1;
	}
	// 4. 들릴 회사 입력
	cin >> x >> k;
	// 5. 플로이드 워셜 진행
	int answer = solution();

	cout << answer << endl;
	return 0;
}
