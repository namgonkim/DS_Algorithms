#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/*
문제: 공유기 설치
설명: C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램
유형: 이진 탐색
날짜: 2021.06.18
*/

int n, c; // 집의 개수, 공유기 개수

// 각 집의 좌표가 최대 10억까지이므로, 이진 탐색을 이용해 문제를 해결
int solution(vector<int> router){
    sort(router.begin(), router.end());
    // 인접한 두 집 사이 최소, 최대 거리
    int start = 1;
    int end = router[n-1] - router[0];
    int result = 0;
    // 두 집 사이 거리가 같아질 때까지 이진 탐색
    while(start <= end) {
        // 공유기 설치 횟수
        int cnt = 1;
        // 첫 집에는 항상 공유기 설치
        int access = router[0];
        // 거리 이분 탐색을 위한 mid
        int mid = (start + end) / 2;
        // 공유기를 설치
        for(int i=0;i<n;i++) {
            // 현 집이 첫 집에서 mid 만큼 떨어져 있다면 공유기 설치
            if(router[i] >= access + mid){
                // 공유기를 설치하고 다음으로 설치할 공유기 위치를 찾기 위해 현 위치로 변경
                access = router[i];
                cnt += 1; // 카운트 증가
            }
        }
        // 공유기 설치 횟수가 C개 이상이라면 mid를 두 공유기 사이 최대 거리로 등록
        if(cnt >= c) {
            start = mid + 1; // 또 다른 케이스가 있는지 인접 거리를 늘림.
            result = mid; // 최적의 결과 저장
        }
        // C보다 작다면 mid를 줄여 인접 거리를 짧게 함.
        else {
            end = mid - 1;
        }
    }
    return result;
}

int main() {
    
    cin >> n >> c;
    vector<int> router;
    for(int i=0; i<n; i++){
        int num;
        cin >> num;
        router.push_back(num); // 집의 좌표
    }
    
    int answer = solution(router);
    cout << answer << endl;
    return 0;
}