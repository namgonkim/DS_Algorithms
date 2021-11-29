#include <iostream>
#include <vector>
#include <algorithm>
/*
페라메트릭 서치: 원하는 조건을 만족하는 가장 알맞은 값을 찾는 것
범위 내에 조건을 만족하는 가장 큰 값을 찾으라는 최적화 무넺일 때 이진 탐색으로 결정 문제를 해결하며 범위를 좁혀나간다.
현재 길이로 자르면 조건을 만족하는가를 확인한 뒤, 조건의 만족 여부에 따라 탐색 범위를 좁혀 해결한다.
범위를 좁힐 때 이진 탐색을 활용해 절반씩 탐색 범위를 좁혀나간다.
*/
using namespace std;

int main(void) {
    long long n, k;
    vector<long long> v;
    // 시작점과 끝점 설정
    long long start = 0;
    long long end = 0;
    long long mid = 0;
    long long cnt = 0;
    long long result = 0;
    cin >> n >> k;
    for(int i=0;i<n;i++) {
        int num;
        cin >> num;
        v.push_back(num);
        if(end < v[i])
            end = v[i];
    }

    // 이진 탐색 수행
    while (start <= end)
    {
        cnt = 0;
        mid = (start + end) / 2;

        if(mid == 0) {
            cout << "1\n";
            return 0;
        }
        for (int i=0;i<n;i++)
        {
            cnt = cnt + (v[i] / mid);
        }
        // 필요한 랜선의 개수가 잘라서 생성된 랜선 개수보다 적다면
        if (cnt < k)
        {
            end = mid - 1;
        }
        // 필요한 랜선의 개수가 충분한 경우
        else
        {
            // 현재 결과에 입력
            result = mid;
            start = mid + 1; // 더 크게 자를 수 있는 랜선 최대 길이를 찾기 위해
        }
    }

    cout << result << "\n";

    return 0;
}