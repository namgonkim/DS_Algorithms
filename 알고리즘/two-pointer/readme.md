# 투 포인터 알고리즘
* 선형 시간[O(N)]안에 해결할 수 있는 알고리즘
* 리스트에 순차적으로 접근할 때, 두 점을 이용해 위치를 기록하면서 처리하는 기법

## 투 포인터 알고리즘 설명
1. 시작점(start)와 끝점(end)이 첫 번째 원소의 인덱스(0)을 가리키도록 한다.
2. 현재 부분 합이 M과 같다면, 카운트한다.
3. 현재 부분 합이 M보다 작거나 같다면, end를 1 증가시킨다.
4. 현재 부분 합이 M보다 크다면, start를 1 증가시킨다.
5. 모든 경우를 확인할 때까지 2~4번까지의 과정을 반복한다.


* 자연수로 구성된 수열에서 합이 5인 부분 연속 수열의 개수를 고려해라.
[1,2,3,2,5]

### 코드
```python
# 데이터의 개수 n과 부분 연속 수열의 합 m을 입력 받기
n, m = 5, 5
data = [1,2,3,4,5]

result = 0 # 카운터인 결과
summary = 0
end = 0
# start를 차례대로 증가시키며 반복
for start in range(n):
    # end를 가능한만큼 이동시키기
    while summary < m and end < n:
        summary += data[end]
        end += 1
        # 부분 합이 m일 때 카운트 증가하기
        if summary == m:
            result += 1
        summary -= data[start]     
```

# Prefix Sum(구간 합)
* O(N + M) 시간 복잡도를 가지는 알고리즘
* 구간의 합을 빠르게 구하는데 이용된다.

## 알고리즘 설명
1. prefix sum을 계산하여 배열 p에 저장한다
2. 매 m개의 쿼리 정보를 확인할 때, 구간 합은 p[R] - p[L-1]이다
```
arr = [10,20,30,40,50]
----- prefix 계산 ------
p = [ 0,    10,   30,   60,   100,  150  ]
    [ p[0], p[1], p[2], p[3], p[4], p[5] ]
```
```python
n=5
data = [10,20,30,40,50]

# prefix sum 배열 계산
summary = 0
prefix_sum = [0]
for i in data:
    summary += i
    prefix_sum.append(summary)

# 구간 합 계산
left = 3
right = 4
print(prefix_sum[right] - prefix_sum[left-1])
```

