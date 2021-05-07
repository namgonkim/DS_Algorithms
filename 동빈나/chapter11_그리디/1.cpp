#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 모험가 길드
문제: N명의 모험가 정보가 주어졌을 때, 여행을 떠날 수 있는 그룹의 최대 값을 구하는 프로그램
유형: 그리디
날짜: 2021-05-07
이름: @namgonkim
*/

using namespace std;

/* 항상 최소한의 모험가의 수만으로 그룹을 형성해 최대한의 그룹을 만드는 것이 핵심 */
// 오름차순 정렬 후 현재 그룹에 포함된 모험가의 수가 현재 확인하고 있는 공포도보다 크거나 같다면 이를 그룹으로 설정
int solution(vector<int> people, int n){
	int answer = 0;
	int count = 0;
	// 오름차순 정렬
	sort(people.begin(), people.end());
	// 공포도가 낮은 모험가부터 진행
	for (int i = 0; i < people.size(); i++) {
		// 그룹에 포함시키기
		count = count + 1;
		// 현재 그룹에 포함된 모험가의 수(count)가 공포도보다 크거나 같으면
		if (count >= people[i]) {
			// 그룹으로 결성
			answer = answer + 1;
			// 기존 그룹에 포함된 모험가 초기화
			count = 0;
		}
	}
	

	return answer;
}

int main() {
	int n;
	vector<int> people;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		people.push_back(num);
	}

	int answer = solution(people, n);
	cout << answer << endl;

	return 0;
}