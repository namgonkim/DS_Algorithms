#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
/*
제목: 전자레인지
문제: 주어진 요리시간 T초를 맞추기 위한 최소버튼 조작 방법을 구하는 프로그램을 작성
유형: 그리디
날짜: 2021-04-25
이름: @namgonkim
*/
using namespace std;
// 시간이 큰 버튼부터 눌러나간다.
int solution(vector<int>& answer, int times) {
    vector<int>btn = { 300, 60, 10 };
    // 예외. 3개의 버튼으로 T초를 맞출 수 없으면 음수 -1을 출력
    if (times % 10 != 0) {
        return -1;
    }
    int i = 0, rem = 0;
    // 1. 주어진 요리시간을 모두 맞출때까지 루프를 돌린다.
    while (times != 0) {
        // 2. 남은 요리시간이 등록버튼보다 클 때
        if (times >= btn[i]) {
            // 3. 버튼 횟수, 버튼을 누르고 남은 요리시간을 저장한다.
            answer[i] = times / btn[i];
            rem = times % btn[i];
            times = rem;
        }
        // 4. 다음 버튼으로 이동
        i = i + 1;
    }
    
    return 1;
}
int main() {

    int T = 0;
    cin >> T;
    vector<int>result(3, 0);
    int ans = solution(result, T);
    if (ans == -1)
        cout << ans << endl;
    else {
        for (int i = 0; i < 3; i++) {
            cout << result[i] << " ";
        }
        cout << endl;
    }
    return 0;
}