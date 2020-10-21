#include <vector>
#include <queue>
#include <iostream>
#include <algorithm>
#include <utility>

using namespace std;

int n, m, h;
vector<vector<vector<int>>>gr(101, vector<vector<int>>(101, vector <int>(101, 0)));
vector<vector<vector<bool>>>visit(101, vector<vector<bool>>(101, vector <bool>(101, false)));
queue<pair<pair<int, int>,int>>q;
int dz[6] = { 0,0,0,0,1,-1 };
int dx[6] = { 0,0,1,-1,0,0 };
int dy[6] = { 1,-1,0,0,0,0 };

void fun() {
    while (!q.empty()) {
        auto it = q.front();
        q.pop();

        for (int i = 0; i < 6; i++) {
            int nx = it.first.second + dx[i];
            int ny = it.first.first + dy[i];
            int nz = it.second + dz[i];

            if (nx < 0 || nx >=m || ny < 0 || ny >=n || nz < 0 || nz >=h) continue;
            if (gr[nz][ny][nx] == 0 && visit[nz][ny][nx] == false) {
                q.push(make_pair(make_pair(ny, nx),nz));
                gr[nz][ny][nx] = gr[it.second][it.first.first][it.first.second] + 1;
                visit[nz][ny][nx] = true;
            }
        }

    }
}

int main() {
    cin >> m >> n >> h;

    int answer = 0;
    for (int t = 0; t < h; t++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> gr[t][i][j];
                if (gr[t][i][j] == 1) {
                    q.push(make_pair(make_pair(i, j), t));
                    visit[t][i][j] = true;
                }
            }
        }
    }
    fun();
    for (int t = 0; t < h; t++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gr[t][i][j] == 0) {
                    cout << "-1" << endl;
                    return 0;
                }
                if (answer < gr[t][i][j])
                    answer = gr[t][i][j];
            }
        }
    }

    cout << (answer - 1) << endl;
    return 0;
}
