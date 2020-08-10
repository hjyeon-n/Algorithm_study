# BFS/DFS
### BFS (Breadth-First Search)

: 너비 우선 탐색. 보통 최단 거리를 구할 때 사용

![image](https://user-images.githubusercontent.com/62419307/89103217-18af5180-d44b-11ea-9e5f-30bff5c22753.png)



![image](https://user-images.githubusercontent.com/62419307/89103232-37ade380-d44b-11ea-8477-e72715ec3348.png)



### DFS (Depth-First Search)

: 깊이 우선 탐색

![image](https://user-images.githubusercontent.com/62419307/89103291-a2f7b580-d44b-11ea-8007-3c51441129c5.png)



![image](https://user-images.githubusercontent.com/62419307/89103303-bb67d000-d44b-11ea-8f58-95d0beaa3f60.png)



### 언제 BFS 혹은 DFS를 사용하나요? 🙋‍♀️

- **BFS를 이용하는 경우**
  - 시작 지점에서 가장 가까운 것을 구하고 싶은 경우 
  - 탐색 범위 자체는 넓지만 어느정도 근처에 구하고 싶은 해가 존재하는 것을 알고 있는 경우
  - 탐색 범위가 굉장히 넒으며 dfs를 사용할 때 스택이 대량으로 사용될 경우 이다.

- **DFS를 이용하는 경우**

  - 모든 경로를 탐색하고 결과를 확인해야 하는 경우

  - 문자열 등을 탐색할 때 '사전 순서로 앞에오는 것'처럼 앞에서 검색해서 찾는 것이 빠를 경우 이다.

    

✔ 즉, 탐색 범위가 넓은 경우와 전체 탐색을 하지 않아도 될 경우는 BFS를 이용하고 전체 탐색이 필요하거나 순차적으로 찾을 필요가 있는 경우는 DFS를 사용하는 것이 좋다.