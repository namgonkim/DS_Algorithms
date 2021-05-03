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

## O(V^2)과 O(ElogV)
* O(V^2)의 시간복잡도를 가지는 다익스트라
  - V는 노드의 개수를 의미
  - 직관적이고 쉽게 이해할 수 있음
  - 각 단계마다 <b>방문하지 않은 노드 중 최단 거리가 가장 짧은 노드를 선택</b>하기 위해 매 단계마다 1차원 리스트의 모든 원소를 순차 탐색
  
* O(ElogV)의 시간복잡도를 가지는 다익스트라
  - V는 노드의 개수, E는 간선의 개수
  - 힙 자료구조를 사용해 인접한 노드 중 최단 거리가 가장 짧은 노드를 빠르게 찾음
  - 현재 가장 가까운 노드를 저장하기 위한 목적으로 우선순위 큐를 추가로 이용

## 수도코드 O(V^2)
* ```cpp vector<bool>visited ```를 이용해 방문하지 않은 노드에 대해 거리가 가장 짧은 노드를 찾아 해당 노드와 인접한 노드까지의 거리를 구하고, 경로의 길이가 더 짧을 경우 업데이트한다.
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
    for(int j to graph[u]){
      int cost = dist[u] + graph[u][j]`s dist cost;
      // 현 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
      if(cost < dist[graph[u][j]`s index])
        dist[graph[u][j]`s index] = cost; // 그럴경우 최단 경로 업데이트
    }
  }
}
```

## 수도코드 O(ElogV)
* 우선순위 큐(힙) 자료구조를 활용해 거리가 가장 짧은 노드를 자연스럽게 찾고 그 거리를 구해 더 짧을 경우 업데이트한다.
```cpp
dijkstra(start){
  // 1. 시작 노드로 가기 위한 경로 0으로 설정하고 큐에 삽입, 시작 노드 초기화
  pq.push(make_pair(0,start)); // pair<dist cost, dist node index>
  dist[start] = 0;
  // 2. 큐가 비어있을때까지 진행
  while(!pq.empty()){
    // 3. 최단 거리가 가장 짧은 노드에 대한 정보(우선순위 큐 top에 저장되어 있음) 꺼내기
    int distance = -pq.top().first; // dist cost
    int now = pq.top().second;      // dist node index
    pq.pop();
    
    // 4. 현재 노드가 이미 처리된 적이 있다면 무시
    if(dist[now] < distance) continue;
    
    // 6. 현재 노드와 인접한 노드들을 확인
    for(int i to graph[now].size(), i++) {
      // 7. 현 노드를 거쳐 인접 노드로 이동
      int cost = distance + graph[now][i]`s dist cost;
      // 8. 현 노드를 거쳐 인접 노드로 이동하는 거리가 더 짧을 경우
      if(cost < dist[graph[now][i]`s index]){
        dist[graph[now][i]`s index] = cost // 해당 노드까지 가는 최단 경로 업데이트
        pq.push(make_pair(-cost, graph[now][i]`s index)) // 최신 최단 경로 정보 큐에 삽입
      }
    }
  }
}
```
