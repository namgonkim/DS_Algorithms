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
제목: 기둥과 보 설치
문제: 2020 카카오 신입 공채
유형: 구현
날짜: 2021-05-17
이름: @namgonkim

규칙:	1.기둥은 바닥 위에 있거나 보의 한쪽 끝부분 위에 있거나, 또는 다른 기둥 위에 있어야 한다.
		2.보는 한쪽 끝부분이 기둥 위에 있거나, 또는 양쪽 끝부분이 다른 보와 동시에 연결되어 있어야 한다.

입력: [x,y,a,b] 형태의 배열 build_frame
	  [y][x] x와 y 좌표
	  [a] 0: 기둥 / 1: 보
	  [b] 0: 삭제 / 1: 설치
	  
출력: [x,y,a] x,y 좌표, 0 기둥 or 1 보
*/

using namespace std;

vector<vector<int>> graph;
int m = 0;

// return 하는 배열은 x좌표 기준으로 오름차순 정렬하며, x좌표가 같을 경우 y좌표 기준으로 오름차순 정렬, xy가 모두 같으면 기둥 0이 보 1보다 앞에 온다.
bool compare(vector<int> a, vector<int> b) {
	if (a[0] == b[0]) {
		if (a[1] == b[1]) {
			return a[2] < b[2];
		}
		return a[1] < b[1];
	}
	else
		return a[0] < b[0];
}

vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
	vector<vector<int>> answer;
	m = build_frame.size();
	// N x N 크기
	graph.resize(n + 1, vector<int>(n + 1, 0));
	// 바닥을 모두 1로 변경
	for (int i = 0; i < n + 1; i++) {
		graph[0][i] = 1;
	}
	// 기둥, 보 설치 or 제거 작업 진행
	for (int i = 0; i < m; i++) {
		// build_frame에서 각각 x,y,a,b 정보 추출
		int x = build_frame[i][0];
		int y = build_frame[i][1];
		int data = build_frame[i][2];
		int cmd = build_frame[i][3];

		// 설치하는 경우
		if (cmd == 1) {
			// 기둥을 설치하는 경우
			if (data == 0) {
				// 바닥 위에 있거나 보의 한쪽 끝부분 위에 있거나, 또는 다른 기둥 위에 있어야 한다 -> 시작점이 1로 되면 된다.
				if (graph[y][x] == 1) {
					// 기둥 설치 - 기둥이 튀어나가지 않게 설치, 튀어나가면 설치하지 않는다.
					if (y + 1 <= n) {
						graph[y + 1][x] = 1;
						answer.push_back({ x, y, data });
					}
				}
				else
					continue;
			}
			// 보를 설치하는 경우
			else {
				// 한쪽 끝부분이 기둥 위에 있거나, 또는 양쪽 끝부분이 다른 보와 동시에 연결되어 있어야 한다.
				if (graph[y][x] == 1) {
					// 기둥에 보를 설치
					if (graph[y - 1][x] == 1) {
						graph[y][x + 1] = 1;
						answer.push_back({ x,y,data });
					}
					// 보와 보 사이에 설치할 때
					else if (graph[y][x + 1] == 1 && graph[y][x-1] == 1) {
						answer.push_back({ x,y,data });
					}
					
				}
				// 현재 좌표에 설치된 상황이 아닐 때
				else {
					// 보를 설치하려는 오른편에 기둥이 있으면 된다.
					if (graph[y][x + 1] == 1 && graph[y - 1][x + 1] == 1) {
						graph[y][x] = 1;
						answer.push_back({ x,y,data });
					}
				}
				
			}
		}
		// 제거하는 경우
		else {
			int del = -1;
			for (int i = 0; i < answer.size(); i++) {
				if (answer[i][0] == x && answer[i][1] == y && answer[i][2] == data) {
					del = i;
					break;
				}
			}
			if (del == -1) continue;
			// 제거해보고 맞는 구조물인지 확인한다.
			graph[y][x] = 0;
			answer.erase(answer.begin() + del);

			if()
		}
	}
	sort(answer.begin(), answer.end(), compare);
	return answer;
}

int main() {

	int n = 5;
	// [[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]
	// [0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]
	vector<vector<int>> build_frame = {
		{0,0,0,1},
		{2,0,0,1},
		{4,0,0,1},
		{0,1,1,1},
		{1,1,1,1},
		{2,1,1,1},
		{3,1,1,1},
		{2,0,0,0},
		{1,1,1,0},
		{2,2,0,1}
	};
	vector<vector<int>> answer = solution(n, build_frame);

	for (int i = 0; i < answer.size(); i++) {
		for (int j = 0; j < answer[i].size(); j++) {
			cout << answer[i][j] << " ";
		}
		cout << endl;
	}
}