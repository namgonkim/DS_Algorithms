#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 신장 트리
문제: 크루스칼 알고리즘 활용 신장 트리 구하기
유형: 최소 신장 트리(Spanning Tree)
날짜: 2021-05-04
이름: @namgonkim
*/

using namespace std;
/* '크루스칼 알고리즘'

1. 간선 데이터를 비용에 따라 오름차순으로 정렬한다.
2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인한다.
	1) 사이클이 발생하지 않는 경우 최소 신장 트리에 포함시킨다.
	2) 사이클이 발생하는 경우 최소 신장 트리에 포함시키지 않는다.
3. 모든 간선에 대해 [2]번의 과정을 반복한다.
*/
int vertex, edge;		// 노드 개수, 간선 개수
vector<pair<int, pair<int,int>>> edges;		// 간선에 대한 비용 배열
vector<int> parent;		// 각 노드들에 대한 부모 노드들을 담은 배열

// 부모 노드 찾기, 특정 원소가 속한 집합 찾기
int find_parent(vector<int>& parent, int x) {
	// 루트 노드가 아니면 루트 노드를 찾을 때까지 재귀적으로 호출
	if (parent[x] != x) {
		parent[x] = find_parent(parent, parent[x]);
	}

	return parent[x];
}

// 두 원소가 속한 집합을 합치기
void union_parent(vector<int>& parent, int a, int b) {
	a = find_parent(parent, a);
	b = find_parent(parent, b);
	// 더 작은 번호면 부모노드 이도록 함
	if (a < b) {
		parent[b] = a;
	}
	else
		parent[a] = b;
}

int solution() {
	int answer = 0;

	// 간선을 비용순으로 정렬
	sort(edges.begin(), edges.end());

	// 간선을 하나씩 확인
	for (int i = 0; i < edges.size(); i++) {
		int cost = edges[i].first;
		int a = edges[i].second.first;
		int b = edges[i].second.second;

		// 사이클이 발생하지 않는 경우에만 유니온 집합
		if (find_parent(parent, a) != find_parent(parent, b)) {
			union_parent(parent, a, b);
			answer = answer + cost; // 비용을 더해 나간다.
		}
	}

	return answer;
}

int main() {

	int result = 0;
	// 노드와 간선에 대한 정보 입력
	cin >> vertex >> edge;
	// 부모 테이블 초기화
	parent.resize(vertex + 1, 0);

	// 부모 테이블에서 모든 노드의 부모를 자기 자신으로 초기화
	for (int i = 1; i <= vertex; i++) {
		parent[i] = i;
	}

	// 모든 간선에 대한 정보 입력받기
	for (int i = 0; i < edge; i++) {
		int a, b, cost;
		cin >> a >> b >> cost;
		// 비용순으로 정렬하기 위해 첫 번째 원소를 비용으로 설정
		edges.push_back(make_pair(cost, make_pair(a, b)));
	}

	result = solution();

	cout << result << endl;
	
	return 0;
}
