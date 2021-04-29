#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<stdio.h>
/*
제목: 부품 찾기
문제: 손님이 요청한 부품이 매장에 있으면 yes, 없으면 no 출력하는 프로그램
유형: 이진 탐색
날짜: 2021-04-29
이름: @namgonkim
*/
using namespace std;

int n, m;

/* 이진 탐색 소스코드 */
bool binary_search(vector<int>data, int target, int start, int end) {
    while (start <= end) {
        // 1. 중간 인덱스 설정
        int mid = (start + end) / 2; 
        // 2. 타겟을 찾으면 종료
        if (data[mid] == target) {
            return true;
        }
        // 3. 타겟이 중간 인덱스의 값보다 작다면 끝 인덱스 = 중간 인덱스 -1 로 변경(탐색 경우를 줄여나감)
        else if (data[mid] > target) {
            end = mid - 1;
        }
        // 4. 타겟이 중간 인덱스 값보다 크다면 첫 인덱스 = 중간 인덱스 + 1로 변경
        else {
            start = mid + 1;
        }
    }
    return false;
}

/* 찾으려는 타겟을 순차적으로 이진 탐색 알고리즘에 적용시켜 찾는다. */
vector<string> solution(vector<int>&data, vector<int>&finder) {
    vector<string> answer;
    for (int i = 0; i < m; i++) {
        bool exists = binary_search(data, finder[i], 0, n - 1);
        if (exists == true) {
            answer.push_back("yes");
        }
        else {
            answer.push_back("no");
        }
    }
    
    return answer;
}

int main() {

    cin >> n;
    vector<int> data(n);
    for (int i = 0; i < n; i++) {
        cin >> data[i];
    }
    cin >> m;
    vector<int> finder(m);
    for (int i = 0; i < m; i++) {
        cin >> finder[i];
    }
    vector<string> answer = solution(data, finder);

    for (int i = 0; i < answer.size(); i++) {
        cout << answer[i] << " ";
    }

    return 0;
}