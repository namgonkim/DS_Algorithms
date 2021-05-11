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
제목: 자물쇠와 열쇠
문제: 2020 카카오 신입 공채
유형: 구현
날짜: 2021-05-11
이름: @namgonkim

//  자물쇠 영역 내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며 열쇠의 돌기와 자물쇠의 돌기가 만나서는 안된다.
*/

using namespace std;

int n = 0;	// 자물쇠 사이즈
int m = 0;	// 열쇠 사이즈

vector<vector<int>> rightRotate(vector<vector<int>> key) {
	vector<vector<int>> keyR(key.size(),vector<int>(key[0].size(),0));
	for (int i = 0; i < key.size(); i++) {
		for (int j = 0; j < key[i].size(); j++) {
			// 시계방향 90도 회전
			keyR[i][j] = key[key[i].size() - j - 1][i];
		}
	}
	return keyR;
}

// key[y][x]를 기준으로 열쇠를 보드판에 맞춰봄
bool findKey(int y, int x, vector<vector<int>> key, vector<vector<int>> board) {
	bool find = true;
	int b = board.size();

	// key를 더한다
	for (int i = y; i < y + m; i++) {
		for (int j = x; j < x + m; j++) {
			board[i][j] += key[i - y][j - x];
		}
	}

	// 자물쇠가 맞는지 확인
	for (int i = m; i < b - m; i++) {
		for (int j = m; j < b - m; j++) {
			// 계속 1이 나오면 continue
			if (board[i][j] == 1) continue;
			// 하나라도 1이 아닐 경우 false
			else {
				return false;
			}
		}
	}

	return find;
}

// 완전탐색을 이용해 회전 + key[y][x] 탐색을 진행한다.
bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
	bool answer = false;
	
	n = lock.size();
	m = key.size();
	// 가로 세로가 m+n+m만큼의 크기인 큰 보드판
	int b = n + (m * 2);
	vector<vector<int>> board(b, vector<int>(b, 0));
	// 보드판 중앙에 자물쇠 넣기
	for (int i = m; i < m + n; i++) {
		for (int j = m; j < m + n; j++) {
			board[i][j] = lock[i - m][j - m];
		}
	}
	// 4방향으로 회전하면서 완전탐색
	for (int i = 0; i < 4; i++) {

		// 키 회전
		key = rightRotate(key);

		// 완전 탐색
		for (int y = 0; y < b - m; y++) {
			for (int x = 0; x < b - m; x++) {

				// board판 중앙에 있는 자물쇠lock에 key[y][x]를 넣어서 맞는지 확인
				if (findKey(y, x, key, board)) {
					answer = true;
					return answer;
				}

			}
		}

	}

	
	return answer;
}

int main() {

	//	[[0, 0, 0], [1, 0, 0], [0, 1, 1]]
	//	[[1, 1, 1], [1, 1, 0], [1, 0, 1]]
	vector<vector<int>> key = {
		{0, 0, 0},
		{1, 0, 0},
		{0, 1, 1}
	};
	vector<vector<int>> lock = {
		{1, 1, 1},
		{1, 1, 0},
		{1, 0, 1}
	
	};

	bool answer = solution(key, lock);
	cout << answer << endl;
	
	return 0;

}

