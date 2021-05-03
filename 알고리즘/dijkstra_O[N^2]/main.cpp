#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<stdio.h>
/*
제목: O(N^2)
문제: 간단한 다익스트라 알고리즘
유형: 다익스트라 알고리즘
날짜: 2021-05-03
이름: @namgonkim
*/
using namespace std;

int n, m;               // 노드의 개수, 간선 개수
int start;              // 시작 노드 번호
const int INF = 1e9;    // 무한의 값

vector<pair<int,int>> graph[100001];
vector<bool>visited;
vector<int>dist;

/* 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환 */
int getSmallestNode() {
    int minVal = INF;
    int index = 0; // 가장 최단 거리가 짧은 노드의 인덱스
    for (int i = 1; i <= n; i++) {
        // 방문하지 않았고, 가장 작은 노드 찾기
        if (dist[i] < minVal && visited[i] == false) {
            minVal = dist[i];
            index = i;
        }
    }
    return index;
}

/* 다익스트라 알고리즘 */
int dijkstra(int start) {
    int answer = 0;
    // 1. 시작 노드 초기화
    dist[start] = 0;
    visited[start] = true;
    for (int j = 0; j < graph[start].size(); j++) {
        int adjIdx = graph[start][j].first; // 시작노드에서 인접한 노드 인덱스 세팅
        dist[adjIdx] = graph[start][j].second; // 해당 인접 노드들까지 가는 비용 세팅
    }
    // 2. 시작 노드를 제외한 전체 n-1개 노드에 대해 반복
    for (int i = 0; i < n-1; i++) {
        // 3. 현재 최단 거리가 가장 짧은 노드를 꺼내 방문 처리
        int now = getSmallestNode();
        visited[now] = true;
        // 4. 현재 노드와 연결된 다른 노드를 확인
        for (int j = 0; j < graph[now].size(); j++) {
            int cost = dist[now] + graph[now][j].second;
            // 5. 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
            if (cost < dist[graph[now][j].first]) {
                dist[graph[now][j].first] = cost;
            }
            
        }
    }
    return answer;
}

int main() {
    cin >> n >> m >> start;
    // 방문한 적이 있는지 체크하는 목적의 리스트
    visited.resize(n + 1, false);
    // 최단 거리 테이블을 무한으로 초기화
    dist.resize(n + 1, 1e9);
    int a, b, c; // a에서 b 노드로 가는 비용은 c
    // 모든 간선 정보를 입력받기
    for (int i = 1; i <= m; i++) {
        cin >> a >> b >> c;
        // a번 노드에서 b까지 가는데 c라는 비용이 걸림을 입력
        graph[a].push_back(make_pair(b,c));
    }

    /* 다익스트라 알고리즘 실행 */
    dijkstra(start); // 시작 노드부터 진행

    for (int i = 1; i <= n; i++) {
        if (dist[i] == INF)
            cout << "INFINITY" << endl;
        // start에서 부터 해당 노드까지 가는데 최단 거리 제공
        else
            cout << dist[i] << endl;
    }


    
    return 0;
}