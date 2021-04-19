#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;
/*
문제: 모두의 마블
유형: 그리디
날짜: 2021-04-19
이름: @namgonkim
 */

// 제일 큰 수를 기준으로 덧붙인 카드를 만들어 나간다.
int solution(int n, vector<int> &level) {
    int answer = 0;
    int cardA = 0;
    // 1. 큰 수부터 내림차순 정렬
    sort(level.begin(), level.end(), std::greater<>());
    // 2. 가장 큰 수를 표준 카드 A로 지정(업그레이드 된 카드 A의 레벨은 변하지 않음)
    cardA = level[0];
    
    for (int i = 1; i < n; i++) {
        // 3. A를 기준으로 카드 X 만들고 합산
        answer = answer + (cardA + level[i]);

    }
    
    return answer;
}
int main() {

    int n = 0, num = 0;
    int answer = 0;
    vector<int> level;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> num;
        level.push_back(num);
    }
    answer = solution(n, level);

    cout << answer << endl;

    return 0;
}