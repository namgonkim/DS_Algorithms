#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 키패드누르기
문제: 2020 카카오 인턴 1번
유형: 구현
날짜: 2021-05-07
이름: @namgonkim
*/

using namespace std;

/*
	1	2	3
	4	5	6
	7	8	9
	10	11	12
*/

string solution(vector<int> numbers, string hand) {
	string answer = "";
	// *은 10, # 11
	int left = 10, right = 12, left_dist = 0, right_dist = 0;
	for (int i = 0; i < numbers.size(); i++) {
		// 왼손으로 누르는 번호인 경우
		if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
			answer = answer + "L";
			left = numbers[i];
		}
		// 오른손으로 누르는 번호인 경우
		else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
			answer = answer + "R";
			right = numbers[i];
		}
		// 왼손 or 오른손인 경우
		else {
			
			// 0인 경우 11로 줌
			if (numbers[i] == 0) numbers[i] = 11;
			// 왼손 오른손 각 위치 찾기
			int left_count = abs(left - numbers[i]);
			int right_count = abs(right - numbers[i]);
			// 행 열 고려해 위치 찾아주기
			left_dist = (left_count / 3) + (left_count % 3); // 행 열 계산
			right_dist = (right_count / 3) + (right_count % 3); // 행 열 계산

			// 왼손 오른손 위치가 같을 경우
			if (left_dist == right_dist)
			{
				if (hand == "right")
				{
					answer += "R";
					right = numbers[i];
				}
				else
				{
					answer += "L";
					left = numbers[i];
				}
			}
			// 왼손이 오른손 보다 가까울 경우
			else if (left_dist < right_dist)
			{
				answer += "L";
				left = numbers[i];
			}
			// 오른손이 왼손보다 가까울 경우
			else
			{
				answer += "R";
				right = numbers[i];
			}
		}
	}
	
	return answer;
}

int main() {
	vector<int>numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
	// [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"
	// [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"
	// [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]		"right"
	string hand = "right";
	string answer = solution(numbers, hand);
	cout << answer << endl;
	return 0;
}