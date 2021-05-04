#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 위상 정렬
문제: 순서가 정해져 있는 일련의 작업을 차례대로 수행할때 사용하는 알고리즘
유형: Topology Sort
날짜: 2021-05-04
이름: @namgonkim
*/

using namespace std;
/* '위상 정렬(Topology Sort)'

1. 진입차수(특정 노드로 들어오는 간선의 개수)가 0인 노드를 큐에 넣는다.
2. 큐가 빌 때까지 다음의 과정을 반복한다
	1) 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거한다.
	2) 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.
*/

const int MAX = 10001;
int v, e;				// 노드의 개수 간선의 개수
vector<int> indegree;	// 진입 차수
vector<int> graph[MAX];	// 노드와 노드 간 간선 정보

/* Topology Sort */
vector<int> solution() {
	vector<int> answer;
	queue<int>q;

	// 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
	for (int i = 1; i <= v; i++) {
		if (indegree[i] == 0) {
			q.push(i);
		}
	}
	// 큐가 빌때까지 반복
	while (!q.empty()) {
		// 큐에서 원소 꺼내기
		int now = q.front();
		answer.push_back(now);
		q.pop();

		// 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
		for (int i = 0; i < graph[now].size(); i++) {
			int next = graph[now][i];
			indegree[next] = indegree[next] - 1;

			// 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
			if (indegree[next] == 0)
				q.push(next);
		}
	}

	return answer;
}

int main() {

	vector<int> result ;
	// 노드 개수 간선 개수 정보 입력받기
	cin >> v >> e;
	// 모든 노드에 대한 진입차수 0으로 초기화
	indegree.resize(v + 1, 0);
	// 각 노드와 연결된 간선 정보들을 담기 위한 그래프 초기화
	graph->resize(v + 1, 0);
	
	// 방향 그래프의 모든 간선 정보를 입력받기
	for (int i = 0; i < e; i++) {
		int a, b;
		cin >> a >> b;
		graph[a].push_back(b);	// a에서 b로 이동이 가능
		// 진입 차수 1 증가
		indegree[b] += 1;
	}

	// 위상 정렬 함수
	result = solution();
	
	// 출력
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << endl;
	}
	
	return 0;
}
