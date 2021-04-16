#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
vector<vector<bool>> visit;
int glo_m = 0;
int glo_n = 0;

void init(){
    visit.clear();
    visit.resize(m, vector<bool>(n, false));
    glo_m = 0;
    glo_n = 0;
    /*
    dx[4] = ~
    dy[4] = ~
    */
}

int fun(int y, int x, vector<vector<int>> &picture) {
    visit[y][x] = true;
    int count = 1;
    queue<pair<int, int>> q;
    q.push(make_pair(y, x));
    while (!q.empty()) {
        auto it = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = it.second + dx[i];
            int ny = it.first + dy[i];

            if (nx < 0 || ny < 0 || nx >= glo_n || ny >= glo_m) continue;
            if (visit[ny][nx] == false && picture[ny][nx] == picture[y][x]) {
                visit[ny][nx] = true;
                q.push(make_pair(ny, nx));
                count += 1;
            }
        }
    }

    return count;
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    // 전역 변수 초기화 안하니까 틀림. 이거 테케가 0,0으로 나와야 하는데 초기화 지대로 안되서 그런듯
    init(m,n);
    glo_m = m;
    glo_n = n;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (visit[i][j] == false && picture[i][j] != 0) {
                int areaSize = fun(i,j,picture);
                if (areaSize > max_size_of_one_area) max_size_of_one_area = areaSize;
                number_of_area += 1;
            }
        }
    }

    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}

int main() {
    vector<vector<int>> v = { {1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3} };
    int m = 6;
    int n = 4;
    vector<int> ans = solution(m, n, v);
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << "/";
    }
    cout << endl;
    return 0;
}
