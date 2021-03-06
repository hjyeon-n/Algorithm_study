# Programmers

| 문제 번호                                                    | 문제 이름                                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [가장 먼 노드](https://programmers.co.kr/learn/courses/30/lessons/49189) | [가장 먼 노드](#가장-먼-노드)                                |
| [불량 사용자](https://programmers.co.kr/learn/courses/30/lessons/64064) | [불량 사용자](#불량-사용자)⭐                                 |
| [게임 맵 최단거리](https://programmers.co.kr/learn/courses/30/lessons/1844) | [게임 맵 최단거리](#게임-맵-최단거리)                        |
| [x만큼 간격이 있는 n개의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12954) | [x만큼 간격이 있는 n개의 숫자](#x만큼-간격이-있는-n개의-숫자) |
| [순위 검색](https://programmers.co.kr/learn/courses/30/lessons/72412) | [순위 검색](#순위-검색)                                      |
| [정수 삼각형](https://programmers.co.kr/learn/courses/30/lessons/43105) | [정수 삼각형](#정수-삼각형)                                  |

<br>

<hr>

#### #가장 먼 노드

[가장 먼 노드 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.03/%EA%B0%80%EC%9E%A5%20%EB%A8%BC%20%EB%85%B8%EB%93%9C.java)

처음에는 DFS 문제인가 싶었는데 시작점이 1번으로 주어져있기도 하고 인접한 곳부터 순회해야 지나가는 간선의 수를 셀 수 있을 것 같아서 BFS로 풀었고, 생각한대로 잘 풀렸다!

1. 인접한 노드들을 표시하기 위해서 n + 1 크기의 이차원 배열을 선언한다. 또한, 간선의 수를 세면서 동시에 방문여부를 표시해줄 dist 배열을 선언한다.
2. 무방향 그래프이기 때문에 A와 B가 인접하다면 B도 A가 인접하다고 표시한다.
3. BFS 탐색을 시작한다.
4. 노드의 번호와 간선을 몇 개 지나쳤는지 확인하기 위해 Node 클래스를 선언한 뒤, Queue를 이 타입으로 지정한다.
5. 해당 정점을 기준으로 반복문을 활용해 인접한 노드가 있는지 만약 있다면, 방문 여부를 확인하고 dist를 정점의 cnt 값에 1을 더한 값으로 초기화 해주고 큐에도 값을 삽입한다. 이때, 1번 노드는 처음부터 방문하고 시작하기 때문에 반복문은 2번부터 시작한다.
6. 메인으로 돌아와 dist 배열을 오름차순으로 정렬해서 가장 마지막 값을 최댓값으로 정한다.
7. dist 배열의 끝부분부터 탐색을 시작하면서 최댓값과 같은 수가 몇 개 있는지 찾는다. 만약, 최댓값보다 작은 수가 발견된다면 나머지 수도 모두 최댓값보다 작은 수이기 때문에 break해서 빠져나온다.
8. answer를 출력한다. 

<br>

<hr>

⭐⭐⭐⭐⭐

#### #불량 사용자

[불량 사용자 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.03/%EB%B6%88%EB%9F%89%20%EC%82%AC%EC%9A%A9%EC%9E%90.java)

진짜 오랫동안 풀었는데 결국 스스로 풀지 못했다... 나는 백트래킹으로 후보군을 찾아서 banned_id와 비교하는 순으로 하려고 했었다. 

하나의 user_id가 banned_id에 하나만 대응해서 해결하려고 두 개의 방문 여부를 나타내는 배열을 함께 사용했는데 그렇게 하니까 이미 대응돼서 사라진 banned_id에 대응하는 user_id가 있을 때 문제가 생기고 또 다른 방식으로 풀려고 하니 비슷한 문제가 발생돼서 결국 다른 사람 풀이를 참고했다.

이 방식은 후보군을 찾아서 걸러내려고 했던 내 방식과 달리 후보군부터 골라내는 방식이다.

1. user_id의 길이만큼 반복문을 시작한다.
2. 만약 user_id와 banned_id의 길이가 같다면 반복문을 돌면서 문자가 같은지 확인한다. 이때, '*'일 때는 어떤 문자든 가능하다는 표시이기 때문에 continue로 넘어간다. 다른 문자가 발견됐다면 더이상 볼 필요가 없기 때문에 flag를 false로 하고 break 한다.
3. flag가 true면 불량 사용자의 후보이다. 다른 후보들을 구하기 위해 백트래킹한다.
4. banned_id를 다 돌고 나면 하나의 후보군을 다 구했다는 의미이기 때문에 중복을 피하기 위해 HashSet에 그 값을 넣는다.
5. 이때, 중복이 생기는 이유는 백트래킹해서 다시 dfs 함수로 진행하면 user_id의 길이만큼 반복문을 도는 반복인자 i가 0이 되는데 그렇게 되면 다시 user_id 배열의 처음부터 방문 여부를 확인하면서 탐색을 시작한다. 그렇게 되면 이 문제의 두 번째 예에서 frodo, crodo, abc123과 crodo, frodo, abc123 같은 결국엔 같은 집합이 중복이 되기 때문에 이를 피하기 위해 HashSet 자료구조를 사용한다.



이 문제의 키포인트는 백트래킹이다. 백트래킹 문제를 많이 풀었어서 어느정도 풀 수 있을 거라고 생각했는데 한참 멀었다는 생각이 든다. 풀 때는 너무너무 안 풀려서 짜증이 났는데 지금 보니 좋은 문제 같다. 나중에 정말 꼭꼭 풀어봐야지.

<br>

<hr>

#### #게임 맵 최단거리

[게임 맵 최단 거리 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.03/%EA%B2%8C%EC%9E%84%20%EB%A7%B5%20%EC%B5%9C%EB%8B%A8%EA%B1%B0%EB%A6%AC.java)

아주 기본적인 BFS 문제이다. 사실 level2도 아니고 level1에 있어도 무방한 문제...

다른 문제는 정말 고생하면서 풀어도 1점이나 2점밖에 안 주는데 이 문제는 4점을 줘서 띠용? 했다. 🙄

너무 기본 그 자체라 비슷한 문제인 [미로 탐색](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2020.07/BFS%2C%20DFS.md#%EB%AF%B8%EB%A1%9C-%ED%83%90%EC%83%89)의 풀이로 대체한다. 미로 탐색 문제의 경우엔 항상 도착할 수 있는 경우만 입력으로 주어지지만 이 문제는 -1로 반환한다는 점을 제외해서 사실상 동일하다. -1로 반환하는 것도 방문 여부를 확인해서 방문하지 않았다면 도달하지 않았다는 뜻이기 때문에 -1을 반환하면 된다.

<br>

<hr>

#### #x만큼 간격이 있는 n개의 숫자

[x만큼 간격이 있는 n개의 숫자 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.03/x%EB%A7%8C%ED%81%BC%20%EA%B0%84%EA%B2%A9%EC%9D%B4%20%EC%9E%88%EB%8A%94%20n%EA%B0%9C%EC%9D%98%20%EC%88%AB%EC%9E%90.java)

풀이하기엔 약간 양심 없는 문제이긴 한데... 처음엔 틀렸어서 풀이해 본다.

물론, 풀이 방법에는 문제가 없었다. 당연히 배수로 풀었는데 변수의 타입형이 문제였다.

문제에서 주어진 것처럼 x는 -10000000 이상, 10000000 이하인 정수이다. 즉, 연산 결과가 int의 범위를 넘어설 수 있다. 하지만 int와 int를 연산해서는 int만 반환되기 때문에 테스트케이스에서 틀린 것이다.

따라서, 매개변수로 주어진 int형 x를 long형 nx로 바꿔서 풀어야 문제를 해결할 수 있다.

<br>

<hr>

#### #순위 검색

[순위 검색 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.03/%EC%88%9C%EC%9C%84%20%EA%B2%80%EC%83%89.java)

query를 순회하면서 해당 쿼리랑 일치하는 info문의 인덱스들을 저장하고 이를 retainAll을 이용해서 교집합만 구하려고 했다.

정확성은 만점이었는데 역시나 효율성에서 0점이었다...😫

처음부터 효율성이 나갈 것 같아서 HashMap으로 풀어야 하나 고민했는데 이를 어떻게 HashMap으로 할지 고민을 했었다.

카카오 풀이 보니 역시나 Map으로 푸는 게 맞았지만, 접근법은 틀렸다... query를 순회하면서 그에 맞는 info를 찾기에는 시간이 너무 오래 걸리기 때문에 info부터 후보군을 구해야 한다는 게 차이점이었다.

1. 조합을 이용해서 info의 후보군을 찾는다. 즉, 경우의 수는 4^2 16이다.
2. 1번의 결과값을 key로 해서 점수를 value로 넣는다.
3. key 값에 대한 value를 오름차순으로 청렬한다.
4. query를 순회하면서 map을 사용해서 value를 불러온다.
5. value 중에 query의 점수보다 높은 지점을 찾아낸다. (lower bound)

<br>

이렇게 풀고나서도 계속 틀렸는데 3번을 2번의 조합에서 map의 value에 값을 추가하면서 정렬을 해준 탓에 시간 초과가 난 것 같다...💦

1. info의 점수들을 저장할 scoreList를 선언한다.
2. info를 순회하면서 score 부분은 따로 떼고 candidate로 만들어 이를 이용해서 조합을 구한다. 이때 조합은 1부터 4까지 뽑는 모든 경우의 수를 구한다.
3. 조합의 결과로 comb_arr을 공백없이 str에 묶어내고 map에 str을 key 값으로 갖고 있는지 확인한다. 만약 있다면 value 값을 가지고 온 뒤, 해당 점수를 추가해서 다시 map에 넣어준다. 만약 없다면, str을 key 값으로 하여 점수 값을 넣어준다.
4. 모든 경우의 수를 구하면 key 값을 기준으로 순회하면서 해당 key에 맞는 value를 오름차순으로 정렬한다. scoreList도 오름차순으로 정렬한다.
5. query를 순회하면서 점수는 떼어내고 "-"와 "and"를 생략해서 str을 만든다.
6. str이 만약 공백이라면 점수를 제외한 모든 조건이 없다는 뜻이므로 scoreList가 value가 된다.
7. str이 공백이 아니라면 해당 값이 map에 있는지 확인한다.
8. 값이 있다면 value 값인 list와 score를 이분 탐색으로 구한다. 이때 lower bound를 구하는 것이기 때문에 score보다 점수가 큰 값들 중 최솟값이 위치한 인덱스를 구할 수 있다. 이 값을 list의 size에서 빼서 value보다 큰 값이 몇 개인지 알아낸다.
9. str에 해당하는 값이 없다면, 존재하지 않은 info이기 때문에 answer에 0을 넣는다.
10. answer를 반환한다.

<br>

시간초과가 나기 전 이 풀이에서는 9번에 해당하는 코드가 없어서 자꾸 런타임 에러가 났다. 정말... 머리가 터질 뻔 했다.🤯

어찌됐건 잘 풀었다는 게 다행이다! level2라고는 했지만 7점이 할당된 거 보니 사실상 level2도 아닌 것 같다... 😂

<br>

<hr>

#### #정수 삼각형

[정수 삼각형 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.03/%EC%A0%95%EC%88%98%20%EC%82%BC%EA%B0%81%ED%98%95.java)

2020년 7월에 풀었던 BOJ의 [정수 삼각형](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2020.07/Dynamic%20Programming.md#%EC%A0%95%EC%88%98-%EC%82%BC%EA%B0%81%ED%98%95) 문제랑 똑같다. 이 문제를 처음 풀 때는 오래도 걸렸고, 정말 어떻게 풀어야 할지 몰라서 막막했다... 그리고 너무 인상 깊어서 다시 복습했었는데 역시 복습의 힘이라고 해야 하나 꽤 오래 지났는데도 비슷하게 풀 수 있었다...!

같은 문제이므로 풀이는 생략!