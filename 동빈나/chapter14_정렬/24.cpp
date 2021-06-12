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
제목: 안테나
문제: 집들의 위치 값이 주어질 때, 안테나를 설치할 위치를 선택하는 프로그램을 작성
유형: 정렬
날짜: 2021-06-12
이름: @namgonkim
*/

using namespace std;

// 안테나를 설치하는 집 후보 중 중간 집에 설치하면 최소거리가 된다.
int solution(int n, vector<int>& map) {
	int answer = 0;
	// 집 후보 정렬
	sort(map.begin(), map.end());
	// 중간 집 선택
	answer = map[(n - 1) / 2];

	return answer;
}

int main() {

	int n, k;
	cin >> n;
	vector<int> map;
	for (int i = 0; i < n; i++) {
		cin >> k;
		map.push_back(k);
	}

	int answer = solution(n, map);
	cout << answer << endl;
	return 0;

}