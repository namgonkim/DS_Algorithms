#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 팀 결성
문제: 학선생님이 M개의 연산을 수행할 수 있을 때, N개의 학생 팀에 대해 '같은 팀 여부 확인' 연산에 대한 결과를 출력하는 프로그램 작성
유형: 서로소 집합 알고리즘
날짜: 2021-05-06
이름: @namgonkim
*/

using namespace std;

int n, m;			// 학생 인원 및 팀 수, 연산의 갯수
int cmd, a, b;		// 연산, 학생a 학생b
vector<int> parent;	// 부모 노드 담은 배열

// 부모 노드가 다르면 다른 팀
int find_parent(vector<int>& parent, int x) {
	if (parent[x] != x) {
		parent[x] = find_parent(parent, parent[x]);
	}
	return parent[x];
}

// 같은 팀이 될 수 있도록 부모 노드를 설정
void union_parent(vector<int>& parent, int a, int b) {
	a = find_parent(parent, a);
	b = find_parent(parent, b);
	if (a < b) {
		parent[b] = a;
	}
	else
		parent[a] = b;
}

int main() {

	cin >> n >> m;
	// 팀 구분을 위한 부모 노드 0으로 초기화
	parent.resize(n + 1, 0);
	// 처음에는 모든 학생이 다른팀으로 구분되도록 자기자신을 부모노드로 설정.
	for (int i = 1; i <= n; i++) {
		parent[i] = i;
	}
	vector<string> answer;
	// 연산 정보와 팀에 대한 정보 입력받기
	for (int i = 0; i < m; i++) {
		cin >> cmd >> a >> b;
		// cmd가 0이라면 팀 합치기 (union_parent)
		if (cmd == 0) {
			union_parent(parent, a, b);
		}
		// cmd가 1이라면 같은 팀 여부 확인하기 (find_parent)
		else {
			int parent_a = find_parent(parent, a);
			int parent_b = find_parent(parent, b);

			if (parent_a == parent_b) {
				answer.push_back("YES");
			}
			else
				answer.push_back("NO");
		}
	}
	
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i] << endl;
	}

	return 0;
}