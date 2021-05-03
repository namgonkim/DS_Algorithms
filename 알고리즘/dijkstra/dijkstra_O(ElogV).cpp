#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: O(ElogV)
문제: 우선순위 큐(힙)을 이용한 다익스트라 알고리즘
유형: 다익스트라 알고리즘
날짜: 2021-05-03
이름: @namgonkim
*/
using namespace std;

int n, m;               // 노드의 개수, 간선 개수
int start;              // 시작 노드 번호
const int INF = 1e9;    // 무한의 값

vector<pair<int,int>> graph[100001];
priority_queue<pair<int, int>> pq;
vector<int>dist;

/* 다익스트라 알고리즘 (우선순위 큐, 최소 힙)*/
int dijkstra(int start) {
    int answer = 0;
    // 1. 시작 노드로 가기 위한 최단 경로는 0으로 설정하여 큐에 삽입   
    pq.push(make_pair(0, start));
    // 2. 시작 노드 초기화
    dist[start] = 0;
    // 3. 큐가 비어있을 때까지 진행
    while (!pq.empty()) {
        // 4. 최단 거리가 가장 짧은 노드에 대한 정보 꺼내기
        int distance = -pq.top().first; // 최소 힙
        int now = pq.top().second;
        pq.pop();
        // 5. 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if (dist[now] < distance) {
            continue;
        }
        // 6. 현재 노드와 인접한 다른 노드들을 확인
        for (int i = 0; i < graph[now].size(); i++) {
            int cost = distance + graph[now][i].second;
            // 7. 현 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
            if (cost < dist[graph[now][i].first]) {
                dist[graph[now][i].first] = cost;
                pq.push(make_pair(-cost, graph[now][i].first)); // 최소 힙
            }
        }
    }
    return answer;
}

int main() {
    cin >> n >> m >> start;
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