#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 커리큘럼
문제: N개의 강의 정보가 주어졌을 때, N개의 강의에 대해 수강하기까지 걸리는 최소 시간을 각각 출력하는 프로그램 작성.
유형: 위상 정렬
날짜: 2021-05-06
이름: @namgonkim
*/

using namespace std;

const int MAX = 501;
int n;						// 강의 개수
vector<int> graph[MAX];	// 노드들이 연결된 간선 정보
vector<int> indegree;		// 선 수후 과목을 위한 진입차수 정보
vector<int> lec_time;		// 노드(강의과목)에 대한 강의 시간 정보

// 위상 정렬을 수행하면서 매번 간선 정보를 확인해 시간 값을 저장 및 갱신한다.
vector<int> solution() {
	vector<int> answer(n+1,0);
	// 수행 결과를 담을 리스트 세팅(초기 강의 시간 정보 담음)
	for (int i = 1; i <= n; i++) {
		answer[i] = lec_time[i];
	}
	queue<int> q;
	// 첫 시작을 위해 진입차수가 0인 노드(강의 번호)를 큐에 삽입
	for (int i = 1; i <= n; i++) {
		if (indegree[i] == 0) {
			q.push(i);
		}
	}
	// 큐가 빌때까지 진행
	while (!q.empty()) {
		// 큐에서 원소(강의 번호)를 꺼내기
		int now = q.front();
		q.pop();

		// 해당 강의 번호와 연결된 강의들(선수후과목)에 대한 탐색
		for (int i = 0; i < graph[now].size(); i++) {
			// 인접한 강의 next = [ 노드 연결 정보를 담은 graph 배열 [ 현재 강의 now <-> 선수후관계(인접)인 i 과목 ] ]
			int next = graph[now][i];
			// 인접한 강의에 대해 현재보다 강의 시간이 더 긴 경우, 결과 테이블을 갱신한다.
			answer[next] = max(answer[next], answer[now] + lec_time[next]);
			// 진입차수를 1 뺸다
			indegree[next] -= 1;
			// 새롭게 진입차수가 0이 되는 강의를 큐에 삽입한다
			if (indegree[next] == 0) {
				q.push(next);
			}
		}
	}

	
	return answer;
}

int main() {
	
	// 강의의 수를 입력받고 각 배열(그래프, 진입차수, 강의시간) 세팅
	cin >> n;
	graph->resize(n + 1, 0);
	indegree.resize(n + 1, 0);
	lec_time.resize(n + 1, 0);

	// 강의 시간, 선 이수 과목의 번호 정보 입력받기
	for (int i = 1; i <= n; i++) {
		// 강의 시간 입력받기
		int time;
		cin >> time; // 첫 입력값은 강의시간
		lec_time[i] = time;
		// 이수과목의 번호 입력(-1이 나오면 종료)
		int prev;
		while (true) {
			cin >> prev;
			if (prev == -1) break;
			indegree[i] += 1;			// 진입차수 증가
			graph[prev].push_back(i);	// i과목의 선이수과목은 prev
		}
	}
	// N개의 강의에 대해 수강하기까지 걸리는 최소 시간 각각 출력
	vector<int> answer = solution();
	for (int i = 1; i <= n; i++) {
		cout << answer[i] << endl;
	}
	return 0;
}