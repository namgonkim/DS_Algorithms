#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 도시 분할 계획
문제: 서로 연결된 N개의 집으로 이루어진 마을을 2개의 마을로 분할하는데 M개의 길에 대한 최소한의 유지비용을 들 수 있도록 프로그램을 작성
유형: 최소 신장 트리(크루스칼 알고리즘)
날짜: 2021-05-06
이름: @namgonkim
*/

using namespace std;

int n, m;	// 집 개수, 도로 개수
vector<int> parent;	// 부모 노드를 담은 배열
vector<pair<int, pair<int, int>>> costs; // 도로에 대한 비용을 담은 배열

// 서로 연결된 노드들인지, 부모 노드가 같은지 확인
int find_parent(vector<int>& parent, int x) {
	if (parent[x] != x) {
		parent[x] = find_parent(parent, parent[x]);
	}
	return parent[x];
}

// 유니온 집합. 부모 노드로 합침. 두 집 간의 마을 형성
void union_parent(vector<int>& parent, int a, int b) {
	a = find_parent(parent, a);
	b = find_parent(parent, b);
	if (a < b) {
		parent[b] = a;
	}
	else {
		parent[a] = b;
	}

}

// 하나의 최소 신장 트리를 구하고, 그 안에서 가장 큰 비용을 가지는 도로를 끊는다.
int solution() {
	int answer = 0;
	int final_cost = 0;

	// 도로 비용을 담은 배열 오름차순
	sort(costs.begin(), costs.end());
	// 사이클을 찾아나가면서 최소 신장트리 진행
	for (int i = 0; i < m; i++) {
		int a = costs[i].second.first;
		int b = costs[i].second.second;
		int cost = costs[i].first;

		// 부모 노드가 같지 않다면 사이클이 발생하지 않는 것. 이는 최소 신장트리가 될 수 있는 노드들
		if (find_parent(parent, a) != find_parent(parent, b)) {
			// 유니온 집합
			union_parent(parent, a, b);
			// 최소 신장 트리 비용 합
			answer = answer + cost;
			// 제일 마지막에 발생한 신장트리 찾아놓는다.
			final_cost = cost;
		}
	}

	// 마지막이 제일 큰 비용이라 빼주면 2개 마을로 분할하면서 최소한의 비용이 가능함.
	answer = answer - final_cost;
	return answer;
}

int main() {
	
	// 집 개수와 도로 개수를 파악
	cin >> n >> m;
	// 부모 노드 배열 세팅
	parent.resize(n + 1, 0);
	// 부모 배열을 자기 자신으로 초기화
	for (int i = 1; i <= n; i++) {
		parent[i] = i;
	}
	// 각 도로에 대한 비용을 입력받고 정보 저장
	for (int i = 0; i < m; i++) {
		int a, b, cost;	// a집에서 b집으로 가는 길의 비용 cost
		cin >> a >> b >> cost;
		costs.push_back(make_pair(cost, (make_pair(a, b))));
	}
	
	int answer = solution();
	cout << answer << endl;

	return 0;
}