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
제목: 특정 거리의 도시찾기
문제: 특정 도시 X로부터 출발해 도달할 수 있는 모든 도시 중, 최단 거리가 K인 모든 도시의 번호를 출력하는 프로그램 작성
유형: BFS
날짜: 2021-05-17
이름: @namgonkim

*/

using namespace std;

const int MAX = 1000001;
vector<int> graph[MAX];
vector<bool> visited;
int n, m; // 도시 개수 n 도로 개수 m

/* k: 최단 거리 K, x: 출발 도시의 번호 */
vector<int> solution(int k, int x) {
	vector<int> map;
	vector<int> answer;
	map.resize(n + 1, 0);
	queue<int> q;
	// 초기값 세팅
	q.push(x);
	visited[x] = true;
	map[x] = 0;
	// BFS 알고리즘 진행
	while (!q.empty()) {
		// 현재 노드 큐에서 꺼내기
		int now = q.front();
		q.pop();
		// 현재 노드와 인접한 노드 탐색
		for (int i = 0; i < graph[now].size(); i++) {
			int next = graph[now][i];
			// 아직 탐색하지 않았다면 길찾기 진행
			if (visited[next] == false) {
				q.push(next);
				visited[next] = true;
				// 도시와 도시 사이 거리정보 입력
				map[next] = map[now] + 1;
			}
		}
	}

	// k거리인 도시만 가져온 뒤 정렬
	for (int i = 0; i < n+1; i++) {
		if (map[i] == k) answer.push_back(i);
	}
	// 거리가 k인 도시가 없으면 -1 반환
	if (answer.size() == 0)
		answer.push_back(-1);

	sort(answer.begin(), answer.end());
	return answer;
}

int main() {

	int k, x; // 거리 정보 k, 출발 도시 번호 x
	cin >> n >> m >> k >> x;
	// 방문 초기화
	visited.resize(n + 1, false);
	// 각 노드가 연결된 정보를 입력
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b; // a에서 b로 가는 길이 있다.
		graph[a].push_back(b);
	}
	
	// 알고리즘 진행
	vector<int> answer = solution(k, x);
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i] << endl;
	}

}
