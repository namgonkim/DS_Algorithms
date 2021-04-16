#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;
/*
문제: 큰 수의 법칙
유형: 그리디
날짜: 2021-04-16
이름: @namgonkim
 */
int solution(vector<int>&data, int len, int m, int k) {
    int answer = 0;
    int firstBig = 0, secondBig = 0;
    // 1. 오름차순 정렬
    sort(data.begin(), data.end());
    // 2. 가장 큰수, 다음으로 큰 수 찾기
    firstBig = data[len - 1];
    secondBig = data[len - 2];

    // 3. 가장 큰수와 다음으로 큰 수가 k번 이상으로 연속되지 않게 조합하여 m번만큼 더하기
    while (1) {
        // 가장 큰수를 k번만큼 더한다.
        for (int i = 0; i < k; i++) {
            if (m == 0) break; // 루프 종료 조건: 더하다가 m이면 종료
            answer = answer + firstBig;
            m = m - 1;
        }
        if (m == 0) break;
        // k번 이상으로 연속되지 않도록 다음으로 큰 수를 더한다.
        else {
            answer = answer + secondBig;
            m = m - 1;
        }
    }

    
    return answer;
}
int main() {
    int datalen, m, k;
    vector<int> data;
    int num;
    cin >> datalen >> m >> k;
    for (int i = 0; i < datalen; i++) {
        cin >> num;
        data.push_back(num);
    }
    int answer = solution(data, datalen, m, k);
    cout << answer << endl;

    return 0;
}