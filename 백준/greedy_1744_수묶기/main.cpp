#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
/*
제목: 수 묶기
문제: 수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성
유형: 그리디
날짜: 2021-04-23
이름: @namgonkim
*/
using namespace std;

/*
숫자 별 음수, 0, 양수 그룹을 만든다.
음수는 음수끼리의 곱을, 0과 1은 덧셈만을, 양수역시 곱셈을 진행한다.
예외1. 만약 음수가 홀수개일때 0도 있으면 0*음수를 통해 한 수를 지울 수 있지 않나.
       이 경우 음수*음수 로 진행하다 제일 큰, 즉 0에 가까운 음수를 0과 곱해 지워준다.
*/
int solution(vector<int>& data, int n) {
    int answer = 0;
    bool zero_flag = false;
    vector<int> positive;
    vector<int> negative;
    // 0. 숫자 별 그룹 지정
    for (int i = 0; i < n; i++) {
        // 1. 음수 배열 저장
        if (data[i] < 0) {
            negative.push_back(data[i]);
        }
        // 2. 1보다 큰 양수 배열 저장
        else if (data[i] > 1) {
            positive.push_back(data[i]);
        }
        // 예외1. 0이 존재한다면?
        else if (data[i] == 0) {
            zero_flag = true;
        }
        else {
            // 3. 0과 1이라면 덧셈 미리해둠
            answer = answer + data[i]; 
        }
    }
    // 4. 음수는 오름차순, 양수는 내림차순 정렬 실시
    sort(negative.begin(), negative.end());
    sort(positive.begin(), positive.end(), greater<>());
    int nega_len = negative.size();
    int posi_len = positive.size();

    // 5. 음수 그룹 곱 진행 - 길이가 짝수라면 그대로 진행, 홀수라면 마지막 수는 덧셈처리
    if (nega_len % 2 == 0) {
        for (int i = 0; i < nega_len; i = i + 2) {
            answer = answer + (negative[i] * negative[i + 1]);
        }
    }
    else {
        for (int i = 0; i < nega_len - 1; i = i + 2) {
            answer = answer + (negative[i] * negative[i + 1]);
        }
        // 예외1. 0이 존재할 때
        if (zero_flag == true) {
            // 0이 여러개로 존재하든 1개이든 1번만 음수 중 가장 큰 수를 0과 곱하도록 한다.
            answer = answer + (negative[nega_len - 1] * 0);
        }
        else {
            answer = answer + (negative[nega_len - 1]);
        }
    }

    // 6. 양수 그룹 곱 진행 - 길이가 짝수라면 묶어서 곱셈처리, 홀수라면 마지막 수는 덧셈처리.
    if (posi_len % 2 == 0) {
        for (int i = 0; i < posi_len; i = i + 2) {
            answer = answer + (positive[i] * positive[i + 1]);
        }
    }
    else {
        for (int i = 0; i < posi_len-1; i = i + 2) {
            answer = answer + (positive[i] * positive[i + 1]);
        }
        answer = answer + (positive[posi_len - 1]);
    }
    
    return answer;
}
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<int> data(n, 0);
    for (int i = 0; i < n; i++) {
        cin >> data[i];
    }
    int answer = solution(data, n);
    cout << answer << endl;
    return 0;
}