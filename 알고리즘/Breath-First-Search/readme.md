# BFS (Breath First Search)
 * 너비 우선 탐색 알고리즘
 * 가까운 노드부터 탐색하는 알고리즘

## 동작 원리
 1) 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
 2) 큐큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리를 한다.
 3) [2]번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.

## 수도코드
```cpp
void bfs(graph, start, visited){

  // 큐 생성 및 시작 노드 큐 저장
  queue<int> q;
  q.push(start);
  // 현재 노드를 방문 처리
  visited[start] = true;
  // 큐가 빌 때까지 반복
  while(!q.empty()) {
    // 큐에서 하나의 원소 꺼내기
    int v = q.front();
    q.pop();
    print(v + "\n");
    // 해당 원소와 인접하며 아직 방문하지 않은 원소들을 큐에 삽입
    for(i in graph[v]) {
      if(visited[i] == false) {
        q.push(i);
        visited[i] = true;
      }
    }
  }
}

```
