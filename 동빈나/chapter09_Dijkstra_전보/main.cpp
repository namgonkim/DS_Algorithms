#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 전보
문제: 도시의 번호와 통로 정보를 이용해 도시 C에서 보낸 메세지를 받게되는 도시의 개수와 도시들이 모두 메세지를 받는 데까지 걸리는 시간을 구하는 프로그램
유형: 최단 경로 찾기 알고리즘
날짜: 2021-05-03
이름: @namgonkim
*/

using namespace std;

const int INF = 1e9;	// 무한수
int n, m, c;			// 도시개수, 통로 개수, 메세지 보내는 도시
int x, y, z;			// 통로에 대한 정보 x -> y, 전달되는 시간 z
vector<pair<int, int>> graph[30001];
priority_queue<pair<int, int>> pq;
vector<int> dist;

void dijkstra(int start) {
	// 초기값 세팅
	pq.push(make_pair(0, start));
	dist[start] = 0;
	// 우선순위 큐가 빌때까지 진행
	while (!pq.empty()) {
		// 우선 순위가 가장 높은, 가장 최단 경로를 가지는 노드 정보 꺼내기
		int distance = -pq.top().first;
		int now = pq.top().second;
		pq.pop();
		// 이미 최단 경로를 찾은, 처리된 적이 있는 노드라면 무시
		if (dist[now] < distance) {
			continue;
		}
		// 해당 노드의 인접 노드에 대한 최단 경로 구하기
		for (int i = 0; i < graph[now].size(); i++) {
			// 인접 노드를 거친 경로
			int cost = distance + graph[now][i].second;
			// 새 경로가 기존 경로보다 짧다면 업데이트, 큐에 삽입
			if (cost < dist[graph[now][i].first]) {
				dist[graph[now][i].first] = cost;
				pq.push(make_pair(-cost, graph[now][i].first)); // 최소힙 방식의 최단경로와 해당 인덱스 삽입.
			}
		}
	}
}

pair<int,int> solution(int start) {
	pair<int, int> answer;
	
	// 다익스트라 알고리즘 진행
	dijkstra(start);
	
	int count = 0;		// 메세지 받는 도시의 총 개수
	int max_time = 0;	// 가장 오래 걸리는 시간 = 총 걸리는 시간

	// 자기자신을 제외한 연결된 도시들을 찾아나간다.
	for (int i = 2; i < dist.size(); i++) {
		if (dist[i] != INF) {
			count += 1;
			max_time = max(dist[i], max_time);
		}
	}

	answer.first = count;
	answer.second = max_time;

	return answer;
}

int main() {
	cin >> n >> m >> c;
	// 최단 경로 테이블 초기화
	dist.resize(n + 1, INF);
	// 2차원 경로 그래프 입력
	for (int i = 0; i < m; i++) {
		cin >> x >> y >> z;
		graph[x].push_back(make_pair(y, z));
	}
	// 알고리즘 진행
	pair<int, int> answer = solution(c);
	// 결과값 출력
	cout << answer.first << " " << answer.second << endl;

	return 0;
}
