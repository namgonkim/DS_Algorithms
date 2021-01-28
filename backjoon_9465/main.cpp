#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int dp[2][100001] = { 0, };
int arr[2][100001] = { 0, };

int main() {
    int T, n;
    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> n;
        // 테스트 케이스 주입
        for (int j = 0; j < n; j++) {
            cin >> arr[0][j];
        }
        for (int j = 0; j < n; j++) {
            cin >> arr[1][j];
        }
        //시작점은 무조건 0,0 이거나 1,0 둘중에 하나여야 한다.
        // 첫 시작점 주입
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        // 0,1이거나 1,1 같이 바로 다음번 ? arr현재 위치 + 대각선 방향의 첫 시작점 
        dp[0][1] = arr[0][1] + dp[1][0];
        dp[1][1] = arr[1][1] + dp[0][0];

        for (int j = 2; j < n; j++) {
            // max에서 비교하는게 뭐냐면
            // 지그재그로 가기 vs 한칸 건너띈 대각선 가기
            // 이 둘 사이에서 큰 값 찾는 것임.
            dp[0][j] = arr[0][j] + max(dp[1][j - 1], dp[1][j - 2]);
            dp[1][j] = arr[1][j] + max(dp[0][j - 1], dp[0][j - 2]);
        }
        if (dp[0][n - 1] > dp[1][n - 1])
            cout << dp[0][n - 1] << endl;
        else
            cout << dp[1][n - 1] << endl;

        
    }

    return 0;
}