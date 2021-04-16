#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;
/*
문제: 숫자 카드 게임
유형: 그리디
날짜: 2021-04-16
이름: @namgonkim
 */

// 각 행마다 가장 작은 수를 찾고, 그 중 가장 높은 수를 반환한다.
int solution(vector<vector<int>>&data, int n, int m) {
    int answer = 0;
    vector<int> res;
    /* 방법 1: sort 함수 활용 */
    for (int i = 0; i < n; i++) {
        // 1. 행마다 가장 작은 수를 찾도록 정렬
        sort(data[i].begin(), data[i].end());
        // 2. 작은 수 추출
        res.push_back(data[i][0]);
    }
    // 3. 작은 수 배열 정렬
    sort(res.begin(), res.end());
    // 4. 가장 큰 수 반환
    answer = res[res.size() - 1];

    answer = 0;

    /* 방법 2: min_element, max_element 함수 활용 */
    for (int i = 0; i < n; i++) {
        // 1. min_element를 활용해 각 행마다 작은 수 찾고, res에 저장
        res.push_back(*min_element(data[i].begin(), data[i].end()));
    }
    // 2. max_element를 활용해 그 중 가장 큰 수 반환
    answer = *max_element(res.begin(), res.end());
    return answer;
}
int main() {
    int n, m;
    vector<vector<int>> data;
    int num;
    cin >> n >> m;
    data.resize(n, vector<int>(m, 0));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> num;
            data[i][j] = num;
        }
    }
    int answer = solution(data, n, m);
    cout << answer << endl;

    return 0;
}