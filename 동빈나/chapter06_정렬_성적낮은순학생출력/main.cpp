#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<queue>
#include<stdio.h>
/*
제목: 성적이 낮은 순서로 학생 출력하기
문제: 모든 학생의 이름을 성적이 낮은 순서대로 출력 (성적이 동일한 학생은 자유롭게 출력)
유형: 정렬
날짜: 2021-04-28
이름: @namgonkim
*/
using namespace std;

// 정렬 비교 함수
bool compare(pair<string, int> left, pair<string, int> right) {
    // 2. 성적이 낮은 순서대로 정렬(오름차순)
    if (left.second < right.second)
        // 3. 왼쪽이 오른쪽 보다 작으면 true 반환? -> 작도록 만들어라는 의미
        return true;
    else
        return false;
}

vector<pair<string, int>> solution(vector<pair<string,int>>& array) {
    // 1. 내림차순 정렬 - 커스터마이징
    sort(array.begin(), array.end(), compare);
    return array;
}
int main() {
    int n;
    cin >> n;
    vector<pair<string, int>> array(n);
    for (int i = 0; i < n; i++) {
        cin >> array[i].first >> array[i].second;
    }
    vector<pair<string, int>> answer = solution(array);
    for (int i = 0; i < n; i++) {
        cout << answer[i].first << " ";
    }
    cout << endl;
    return 0;
}