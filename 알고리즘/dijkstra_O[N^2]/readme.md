# 다익스트라 알고리즘
* 최단 경로 알고리즘의 대표적인 알고리즘
* 한 지점에서 다른 특정 지점까지의 최단 경로를 구해야하는 경우
* 보통 그래프를 이용해 표현
* 각 지점은 노드(Node)로, 지점간 연결된 도로는 간선(Edge)으로 표현
* 그 사이의 거리는 거리(Dist)라고 부른다.
* 음의 간선이 없을 때 정상적으로 동작함
* 매번 '가장 비용이 적은 노드'를 선택하는 과정을 반복하기에 그리디 알고리즘으로 분류되기도 한다.

## 원리
1. 출발 노드를 설정한다.
2. 최단 거리 테이블을 초기화한다.
3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다.
4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
5. 위 과정에서 3과 4번을 반복한다.

## 코어
``` cpp
// 새로 가장 까운 정점으로 정점 u가 뽑혔다면 정점 u를 거쳐 다른 정점까지 가는 거리와 기존에 해당 정점까지의 거리를 비교해 거리가 더 가까운 값을 기준으로 업데이트
distance[w] = min(distance[w], distance[u] + weight[u][w])
```

## 수도코드
```cpp
dijkstra(start){
  // 시작 노드 설정 및 시작 노드 인접 테이블 설정
  dist[start] = 0, visited[start] = true;
  for(int j to graph[start]){
    int adj_index = graph[start][j]`s index;
    dist[adj_index] = graph[start][j]`s dist cost;
  }
  // 시작 노드 제외 전체 n-1개의 노드에 대해 반복
  for(int i to n-1){
    // 방문하지 않은 노드 중 최단 거리가 가장 짧은 노드 선택
    int u = getSmallestNode();
    // 방문 처리
    visited[u] = true
    // 현재 노드와 인접한 노드 확인
    for(int j to graph[now]){
      int cost = dist[u] + graph[now][j]`s dist cost;
      // 현 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
      if(cost < dist[graph[now][j]`s index])
        dist[graph[now][j]`s index] = cost; // 그럴경우 최단 경로 업데이트
    }
  }
}
```
