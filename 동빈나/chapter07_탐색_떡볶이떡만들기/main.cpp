#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<stdio.h>
/*
제목: 떡볶이 떡 만들기
문제: 손님이 요청한 총길이만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최대값을 구하는 프로그램
유형: 이진 탐색
날짜: 2021-04-29
이름: @namgonkim
*/
using namespace std;

int n, m; // 떡 개수, 손님이 요청한 떡의 길이
vector<int> riceCake; // 떡집에 있는 떡 배열

/* 이진 탐색을 이용해 최대한 덜 짜르는 선에서 최대 높이의 떡을 제공하도록 한다 */
int binary_search(vector<int>& riceCake, int target, int start, int end) {
    
    int finder = 0;
    while (start <= end) {
        int mid = (start + end) / 2;
        int lestCakeSum = 0;
        // 2-1. 자른 떡을 계산한다.
        for (int i = 0; i < n; i++) {
            // 2-2. 자르려는 길이보다 큰 떡만 자르고 계산한다.
            if (mid < riceCake[i])
                lestCakeSum = lestCakeSum + (riceCake[i] - mid);
        }
        // 2-3. 자르고 합한 떡 길이가 손님이 요청한 최대한의 떡길이와 일치한 경우
        if (lestCakeSum == target) {
            return mid;
        }
        // 2-4. 자르고 합한 떡 길이가 작을 경우(떡이 부족함) 더 많이 자르기
        else if (lestCakeSum < target) {
            end = mid - 1;
        }
        // 2-5. 자르고 합한 떡 길이가 큰 경우(떡의 양이 충분함) 덜 자르기
        else {
            start = mid + 1;
            // 2-6. 최대한 제공해줄 수 있는 떡의 길이 저장
            finder = mid;
        }
    }
    return finder;
}

int solution() {
    // 1. 젤 긴 떡 길이 찾기
    int maxCake = *max_element(riceCake.begin(), riceCake.end());
    // 2. 이진 탐색을 활용해 최대 높이 찾기
    int answer = binary_search(riceCake, m, 0, maxCake);
    return answer;
}

int main() {
    cin >> n >> m; 
    riceCake.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> riceCake[i];
    }
    int answer = solution();
    cout << answer << endl;
    return 0;
}