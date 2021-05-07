#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 무지의 먹방 라이브
문제: 2019 카카오 신입 공채
유형: 그리디
날짜: 2021-05-07
이름: @namgonkim
*/

using namespace std;

// 음식 번호인 second 기준 오름차순 정렬
bool compare(pair<int, int> a, pair<int, int> b) {
	if (a.second < b.second) return true;
	else return false;
}

int solution(vector<int> food_times, long long k) {
	long long answer = 0;
	long long sums = 0;
	int len = food_times.size();
	for (int i = 0; i < len; i++) {
		sums = sums + food_times[i];
	}
	// 고장난 시간 안에 음식을 다 먹었을 경우 -1 반환
	if (sums <= k) return -1;
	
	// 음식 시간, 음식 번호 우선순위 큐 저장
	priority_queue<pair<int, int>> pq;
	for (int i = 0; i < len; i++) {
		pq.push(make_pair(-food_times[i], i + 1)); // 최소힙 사용해서 음식 시간이 작으면 앞자리로옴
	}

	
	// 초기 값 세팅
	sums = 0;
	long long prev = 0;
	// k보다 작아질 때까지 진행
	// 가장 짧은 음식을 모두 먹는 시간 = (현재 제일 높은 큐에 있는 음식 시간 - 이전에 먹은 음식 시간) * 현재 남은 음식 개수
	while (sums + ((-pq.top().first - prev) * len) <= k) {
		// 현재 남은 음식 중 가장 짧은 음식 시간을 가지는 정보를 빼내기
		long long now_food_time = -pq.top().first;
		pq.pop();
		// 해당 음식을 전부 먹는 만큼의 시간 처리
		sums = sums + (now_food_time - prev) * len;
		len = len - 1;
		prev = now_food_time;
	}
	// 남은 음식 중 몇 번째 음식인지 확인
	vector<pair<int, int>> remains;
	// 큐가 빌때까지 진행
	while (!pq.empty()) {
		// 남은 음식에 대한 정보 꺼내기
		long long food_time = -pq.top().first;
		int food_idx = pq.top().second;
		pq.pop();
		// 정확한 정보로 저장
		remains.push_back(make_pair(food_time, food_idx));
	}
	// 남은 음식 번호순 정렬
	sort(remains.begin(), remains.end(), compare);
	// 고장난 시간 k - 먹은 시간 sums을 먹고 남은 음식 개수로 나눈 나머지가 음식 번호가 있는 곳.
	answer = (k - sums) % len;
		
	return remains[answer].second;
}

int main() {
	long long k = 5;
	vector<int> data = { 3,1,2 };
	
	int answer = solution(data, k);
	cout << answer << endl;
	return 0;
}