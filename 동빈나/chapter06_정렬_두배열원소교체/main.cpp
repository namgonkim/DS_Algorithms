#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<stdio.h>
/*
제목: 두 배열의 원소 교체
문제: 배열 A에 있는 원소와 배열 B에 있는 원소를 K번만큼 바꿨을 때 A배열의 합이 최대가 될 수 있도록 하는 프로그램
유형: 정렬
날짜: 2021-04-28
이름: @namgonkim
*/
using namespace std;

// call by reference 
void swapping(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// A의 최소 값과 B의 최대 값을 찾으면서 바꾼다.
int solution(vector<int>& arrA, vector<int>& arrB, int n, int k) {
    int answer = 0;
    // 1. A 오름차순 정렬, B 내림차순 정렬
    sort(arrA.begin(), arrA.end());
    sort(arrB.begin(), arrB.end(), greater<>());
    // 2. 검색
    for (int i = 0; i < n; i++) {
        // 3. A배열의 최소 값이 B배열의 최대 값보다 작을 경우에만 교체
        if (arrA[i] < arrB[i]) {
            swapping(&arrA[i], &arrB[i]); // call by reference 
            k = k - 1;
        }
        else {
            // 4. 종료: 더 이상 A 배열의 최소 값이 B 배열의 최대 값과 바꿀거리가 없을 때
            break;
        }
        // 4. k번만큼만 진행하고 종료
        if (k == 0)
            break;
    }
    // 5. 합산
    for (int i = 0; i < n; i++) {
        answer = answer + arrA[i];
    }
    return answer;
}

int main() {
    
    int n, k;
    cin >> n >> k;
    vector<int> arrA(n), arrB(n);
    for (int i = 0; i < n; i++) {
        cin >> arrA[i];
    }
    for (int i = 0; i < n; i++) {
        cin >> arrB[i];
    }
    int answer = solution(arrA, arrB, n, k);
    cout << answer << endl;
    return 0;
}