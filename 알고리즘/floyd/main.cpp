#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 플로이드 워셜
문제: 플로이드 워셜 알고리즘을 활용해 모든 지점에서 다른 모든 지점까지의 최단 경로를 구하기
유형: 플로이드 워셜 알고리즘
날짜: 2021-05-03
이름: @namgonkim
*/

using namespace std;

const int INF = 1e9;
int n, m; // 노드 개수, 간선 개수
vector<vector<int>> graph;


/* 플로이드 워셜 */
void solution() {

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 정점 i에서 j로 가는 길. i에서 k를 거쳐 j로 가는게 i에서 j로 가는 것보다 짧을 경우 업데이트
                // distance[i,j] = min(distance[i,j], distance[i,n] + distance[n,j]
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
            }
        }
    }
}

int main() {
    cin >> n >> m;
    // 1. 2차원 그래프를 만들고, 모든 값을 무한으로 초기화
    graph.resize(n + 1, vector<int>(n + 1, INF));
    // 2. 자기 자신으로 가는 비용을 0으로 초기화
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == j) {
                graph[i][j] = 0;
            }
        }
    }
    // 3. 간선에 대한 정보 입력받고 그 값으로 초기화
    for (int i = 0; i < m; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        graph[a][b] = c;
    }
    // 4. 플로이드 워셜 알고리즘 수행
    solution();

    // 5. 결과 출력
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (graph[i][j] == INF) {
                cout << "INF" << " ";
            }
            else
                cout << graph[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}