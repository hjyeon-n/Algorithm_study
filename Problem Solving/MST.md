# MST (Minumum Spanning Tree) 🌲

### Union-Find (유니온 파인드) 🔍

- 대표적 **그래프 알고리즘**으로 **합집합 찾기**라는 의미.
- **상호 배타적 집합(Disjoint-set)이라고도 한다.**
- 여러 노드가 존재할 때, 두 개의 노드를 선택해서 현재 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘.
- 2가지 연산으로 이루어져 있다.
  - **Find** : x가 어떤 집합에 포함되어 있는지 찾는 연산
  - **Union** : x와 y가 포함되어 있는 집합을 합치는 연산

<br>

![image](https://user-images.githubusercontent.com/62419307/91399190-84cd7b80-e878-11ea-83eb-4296778a9e3c.png)

위와 같이 모두 연결되지 않고 각자 자기 자신만을 집합의 원소로 가지고 있을 때, **모든 값이 자기 자신을 가리키도록 만든다.**

**i : 노드번호, P[i] : 부모 노드 번호** 를 의미하며, 즉 자기 자신이 어떤 부모에 포함되어 있는지를 의미한다. 이때 모두 연결되지 않았기 때문에 자신의 부모는 자신이다.

정리하면, Parent[i] = i로 간단히 표현할 수 있다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91399323-c4946300-e878-11ea-8758-e5506674fbe4.png)

![image](https://user-images.githubusercontent.com/62419307/91399368-d37b1580-e878-11ea-86b7-9e4b85348901.png)

**Union(1,2)**; **Union(3,4)** 를 해주어 위와 같이 노드를 연결해 보자. 그러면 위와 같이 표에 표현이 된다. 2번째 인덱스에 '1'이 들어가고, 4번 인덱스에 '3'이 들어가게 된다.

이와 같이 **부모를 합칠 때는 일반적으로 더 작은 값 쪽으로 합친다.** 이것을 **합침(Union) 과정**이라고 한다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91399608-38367000-e879-11ea-8594-043f3e246f90.png)

![image](https://user-images.githubusercontent.com/62419307/91399642-47b5b900-e879-11ea-9e60-d85daaea40a0.png)

위와 같이 1, 2, 3이 연결될 때는 1과 3은 부모가 다르기 때문에 '1과 3이 연결되었는지' 파악하기 힘들다. 이에 **재귀함수가 사용**된다.

3의 부모인 2를 먼저 찾고, 2의 부모인 1을 찾아 결과적으로 3의 부모는 1이 되는 것을 파악한다.

Union의 과정이 수행된 후에는 다음과 같은 표로 바뀐다.

![image](https://user-images.githubusercontent.com/62419307/91399746-7d5aa200-e879-11ea-9ed7-ce446989eb5a.png)

결국 1, 2, 3의 부모는 모두 1이기 때문에 이 세 가지 노드는 모두 같은 그래프에 속한다는 것을 알 수 있다.

해당 경로를 바꿔주는 과정은 아래와 같은 그림으로 변하게 된다.

![image](https://user-images.githubusercontent.com/62419307/91399808-9fecbb00-e879-11ea-9e83-3c6667963aeb.png)

<br>

<hr>

### Kruskal Algorithm (크루스칼 알고리즘) 😏

**가장 적은 비용으로 모든 노드를 연결하기 위해 사용**하는 알고리즘입니다.

- **최소 스패닝 트리**(MST, Minimum Spanning Tree)를 찾음으로써 간선의 가중치의 합이 최솟값이 되도록 하는 알고리즘.
  - **스패닝 트리** : 그래프에서 일부 간선을 선택해서 만든 트리.
  - **최소 스패닝 트리** : 스패닝 트리 중에 선택한 간선의 가중치의 합이 최소인 트리.

- 변의 개수 **E(간선)**, 꼭짓점의 개수 **V(노드)**라고 하면 이 알고리즘은 ***O*** **(E log V )**의 시간복잡도.
  - **E(간선)**: **거리**, **비용**에 해당되며 선에 해당되는 부분.
  - **V(노드)**: **정점**, **도시**에 해당되며 동그라미에 해당되는 부분.

<br>

![image](https://user-images.githubusercontent.com/62419307/91400485-b1829280-e87a-11ea-9e11-353188d7a5e4.png)

<br>

위의 그래프 경우엔 **노드는 6개**이고, **간선의 개수는 9개**.

<br>

**크루스칼 알고리즘은 다음과 같은 절차로 진행된다.**

**1. STEP(1) : 모든 간선들을 거리(비용,가중치)를 기준으로 오름차순으로 정렬한다.**

**2. STEP(2) :** **정렬된 간선을 순서대로 선택한다.**

**3. STEP(3) :** **선택한 간선의 두 정점이 연결되어 있지 않으면, 해당 두 정점을 연결시킨다.**

✔ 즉, 사이클 테이블을 통해 **두 점이 연결되어 있는지 여부를 파악**. (Union-Find 알고리즘 이용)

✔ 최소비용 신장 트리에서는 **사이클이 발생되면 안 되기** 때문.

<br>

![image](https://user-images.githubusercontent.com/62419307/91400719-176f1a00-e87b-11ea-9285-70e9910291a6.png)

**STEP(1)**은 위와 같이 모든 간선들을 **'거리(비용, 가중치)를 기준으로 먼저 오름차순 정렬'**을 수행.

<br>

![image](https://user-images.githubusercontent.com/62419307/91400761-2c4bad80-e87b-11ea-852e-70bc34bb7b89.png)

**STEP(2),(3)**을 진행한다. 위 그림을 보면 가중치가 가장 낮은 3이였던 간선을 선택한다. 두 노드를 연결해 준다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91402055-ee9b5480-e87b-11ea-9820-a03b944fefc3.png)

위 그림처럼 가중치가 낮은 두 번째 간선을 선택한다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91402608-15598b00-e87c-11ea-92f7-35b2bdd84b1b.png)

가중치가 낮은 세 번째 간선을 선택한다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91403000-315d2c80-e87c-11ea-8f61-9f3400704b85.png)

하지만 위와 같은 경우, 사이클이 발생하기 때문에 가중치가 낮은 네 번째 간선을 선택해서는 안 된다. 따라서 가중치가 낮은 다섯 번째 간선을 선택해야 한다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91404029-7da86c80-e87c-11ea-9cb5-a7e0c80bc1a6.png)

위 그림처럼 가장 가중치가 낮은 여섯 번째 간선을 선택한다. 6개의 모든 노드가 연결되었기 때문에 이 후에 있는 간선들은 확인하지 않아도 된다. 

<br>

### Prim Algorithm (프림 알고리즘) 😉

프림 알고리즘은 BFS와 같이 시작점을 기준으로 간선이 확장해나가는 방식이다. 대신 프림 알고리즘은 간선에 가중치가 있으며, 최소한의 비용을 갖는 트리를 만들어야 한다는 점에서 차이가 있다.

Prim's 알고리즘은 **최소 우선순위 큐**에서 가중치가 가장 작은 정점을 선택한 후, 그 정점의 인접한 정점들에 대해 key 값과 연결된 가중치 값을 비교하여 key값을 갱신할 지 말지 결정한다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91407994-125f9a00-e87e-11ea-88ea-1027671fb7f1.png)

초기 그래프의 모습이다. 어떤 정점도 선택되지 않았기 때문에 모든 정점은 inf로 초기화되어 있다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91408082-3622e000-e87e-11ea-9577-6e13d2ed178a.png)

시작 정점을 설정해 준다. 프림 알고리즘은 어떤 정점을 시작 정점으로 하든, 항상 같은 트리 결과가 나온다. 초기값으로는 0을 설정한다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91408197-636f8e00-e87e-11ea-9715-3c1a1cfbcb84.png)

어떤 한 정점의 초기값을 0으로 설정해 두었기 때문에 그 정점이 시작 정점이 된다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91408294-9ade3a80-e87e-11ea-9ef0-b39a98e35925.png)

첫 번째로 가중치가 9인 간선을 확인한다. (어떤 점을 선택하든 결과는 같기 때문에 랜덤으로 선정했다.) Step 3에서 시작 정점과 가중치가 9인 간선으로 연결된 정점의 key 값은 inf였다.

즉 가중치 = 9 , key 값 = inf

**9 < inf 이므로 정점의 key 값을 가중치의 값으로 바꿔준다.**

<br>

![image](https://user-images.githubusercontent.com/62419307/91408427-d1b45080-e87e-11ea-831a-f1ff80950fd6.png)

![image](https://user-images.githubusercontent.com/62419307/91408467-e42e8a00-e87e-11ea-97d2-d103e445c931.png)

![image](https://user-images.githubusercontent.com/62419307/91408528-f8728700-e87e-11ea-90d2-2a39d002b66b.png)



![image](https://user-images.githubusercontent.com/62419307/91408591-0fb17480-e87f-11ea-8a90-b46adff4a2c8.png)

시작 정점에 대해서 모든 간선들을 확인해 보았다. 그러면 이제 다음 정점을 선택하기 위해 최소 우선 순위 큐에서 key 값이 가장 작은 정점을 고른다. 현재 우선 순위 큐에는 { 5 , 7 , inf , 6 , inf , 9 } 가 있으므로 가장작은 값은 5이다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91408730-47202100-e87f-11ea-8ade-4da6ea4a746b.png)

key 값이 5인 정점과 연결된 간선들 보니 가중치가 10인 간선이 있고, 이 간선과 연결된 정점의 key 값은 7이다.

가중치 = 10  > 7 = key 값이므로 key 값을 변경하지 않는다.

<br>

key 값을 변경하는 것은 가중치보다 key 값이 더 클 경우에만 해당된다.

연결된 간선이 1개 밖에 없으므로 다시 최소 우선순위 큐에서 또 정점을 골라야 하고, 위와 같은 과정을 반복하면 최종 결과가 나온다.

<br>

![image](https://user-images.githubusercontent.com/62419307/91408874-89e1f900-e87f-11ea-9c51-9ad144fd95f5.png)

<br>

[유니온 파인드 참고](https://brenden.tistory.com/33)

[크루스칼 참고](https://brenden.tistory.com/36)

[프림 참고](https://victorydntmd.tistory.com/102)