#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 서로소 집합
문제: 서로소 집합 알고리즘
유형: union find
날짜: 2021-05-04
이름: @namgonkim
*/

using namespace std;

// 특정 원소가 속한 집합 찾기
int find_parent(vector<int>& parent, int x) {
	// 루트 노드가 아니면, 루트 노드를 찾을 때까지 재귀적 호출
	if (parent[x] != x) {
		parent[x] = find_parent(parent, parent[x]);
	}
	return parent[x];
}

// 두 원소가 속한 집합을 찾기
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

int main() {
	// 노드 개수 v, 간선 개수 e
	int v, e;
	cin >> v >> e;
	// 부모 테이블
	vector<int> parent;
	parent.resize(v + 1, 0);

	// 부모 테이블에서 부모를 자기자신으로 초기화
	for (int i = 1; i <= v; i++) {
		parent[i] = i;
	}
	
	// 사이클 발생 여부
	bool cycle = false;

	// union 연산을 수행
	for (int i = 0; i < e; i++) {
		int a, b;
		cin >> a >> b;
		// 사이클이 발생했는지 확인
		if (find_parent(parent, a) == find_parent(parent, b)) {
			cycle = true;
			break;
		}
		// 발생하지 않았다면 합집합 수행
		else
			union_parent(parent, a, b);
	}

	// 각 원소가 속한 집합 찾고 출력
	cout << "각 원소가 속한 집합: ";
	for (int i = 1; i <= v; i++) {
		cout << find_parent(parent, i) << " ";
	}
	cout << endl;

	// 부모 테이블 출력
	cout << "각 원소가 속한 집합: ";
	for (int i = 1; i <= v; i++) {
		cout << parent[i] << " ";
	}
	cout << endl;

	// 사이클 발생 여부
	if (cycle == true) cout << "사이클 발생" << endl;
	else cout << "사이클 발행 안함" << endl;

	return 0;
}
