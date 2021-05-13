# 퀵 소트(퀵 정렬)
* 정렬 알고리즘 중 가장 많이 사용되는 알고리즘
* 평균 시간 복잡도 O(NlogN), 최악의 경우 시간 복잡도 O(N^2)
* 많은 정렬 알고리즘 중 매우 빠른 편에 속함

## 알고리즘 원리
* 특정 값(Pivot)을 기준으로 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꿔나간다.
* 따라서 Pivot의 값을 어떻게 설정하느냐에 따라 시간 복잡도가 달라질 수 있는데, 일반적으로는 리스트의 가장 왼쪽에 있는 데이터를 Pivot으로 설정한다.
* [Pivot | Pivot보다 작은 값 | Pivot보다 큰 값]으로 위치가 바뀌었다면, [Pivot보다 작은 값 | Pivot | Pivot보다 큰 값] 형태로 Pivot을 넣고 왼쪽과 오른쪽을 분할한다.
* 각 왼쪽과 오른쪽에 대해 다시 위와 같은 과정을 반복한다.

## 소스 코드

```cpp
void quick_sort(vector<int> array, int start, int end) {
  
  if(start >= end) {
    return ;
  }
  int pivot = start;
  int left = start + 1;
  int right = end;
  
  while(left <= right) {
    // 피봇보다 큰 데이터를 찾을 때까지 반복
    while(left <= end && array[left] <= array[pivot]) {
      left += 1;
    }
    // 피봇보다 작은 데이터를 찾을 때까지 반복
    while(right > start && array[right] >= array[pivot]) {
      right -= 1;
    }
    // 엇갈렸다면 작은데이터와 피봇을 교체
    if(left > right) {
      swap(array[right], array[pivot]);
    }
    // 엇갈리지 않았다면 큰 데이터와 피봇을 교체
    else{
      swap(array[left], array[pivot]);
    }
  }
  // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 퀵 정렬 수행
  quick_sort(array, start, right - 1);
  quick_sort(array, right + 1, end);
}
```
