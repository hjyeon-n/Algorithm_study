# Implementation

| 문제 번호                                          | 이름                      |
| ---------------------------------------------- | ----------------------- |
| [14499](https://www.acmicpc.net/problem/14499) | [주사위 굴리기](#주사위-굴리기)     |
| [3190](https://www.acmicpc.net/problem/3190)   | [뱀](#뱀)                 |
| [16236](https://www.acmicpc.net/problem/16236) | [아기 상어](#아기-상어)⭐        |
| [5430](https://www.acmicpc.net/problem/5430)   | [AC](#AC)               |
| [11656](https://www.acmicpc.net/problem/11656) | [접미사 배열](#접미사-배열)       |
| [1748](https://www.acmicpc.net/problem/1748)   | [수 이어 쓰기 1](#수-이어-쓰기-1) |
| [17144](https://www.acmicpc.net/problem/17144) | [미세먼지 안녕!](#미세먼지-안녕!)   |

<br>

<hr>

#### #주사위 굴리기

[주사위 굴리기 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.10/Solution_14499.java)🎲

정말 오랫동안 풀었다...😫 예전에 풀려고 시도했다가 문제도 이해 안 돼서 미루다가 오늘 결국 풀었는데 이번에도 문제 이해가 힘들어서 각티슈에 숫자 써서 직접 돌려봤다...😇 참고로, 삼성 SW 역량 테스트 기출문제이다.

<br>

이 문제는 주사위 굴리는 과정만 잘 알면 금방 풀 수 있다. 그렇지만 난... 아주 오래 걸렸지...🤯

1. 처음 시도했던 방법은 Dice라는 객체를 선언해서 만약 1이 가장 윗면일 때, 동서남북이 무슨 숫자인지를 나타내는 방법을 사용했다. 후에 Dice 타입의 dices 배열을 선언해서 객체들을 넣어주었다.  이때 동서남북은 전개도를 중심으로 잡았다.
2. 1번의 방법이 잘 안 되기도 하고 실제로 주사위를 굴려봤더니 내가 생각한 방향대로 움직이지 않아서 다른 풀이를 아주 잠깐 참고 했더니, 동쪽으로 이동할 때 바뀌는 주사위의 면을 갱신해 줘야 한다길래 동서남북 모든 방향을 움직여서 규칙을 찾아냈다.
3. 2번도 마찬가지로 안 되길래 뭐지...싶어서 다시 풀이를 찬찬히 읽어보고 드디어 해결책을 알아냈다.

<br>

문제에서 주어진 전개도에 따라 표는 이렇게 채워질 것이다.

![image](https://user-images.githubusercontent.com/62419307/95010924-f4990800-0667-11eb-8f95-9213cd71f949.png)

| 윗면  | 아랫면 | 앞   | 뒤   | 오른쪽 | 왼쪽  |
| --- | --- | --- | --- | --- | --- |
| 1   | 6   | 5   | 2   | 3   | 4   |

<br>

이 주사위를 동쪽으로 굴린다고 가정하자. 그러면 표는 이렇게 바뀔 것이다.

| 윗면  | 아랫면 | 앞   | 뒤   | 오른쪽 | 왼쪽  |
| --- | --- | --- | --- | --- | --- |
| 4   | 3   | 5   | 2   | 1   | 6   |

그렇기 때문에 동쪽 (comm = 1)일 땐, 코드는 이와 같다.

```java
dice[1] = tmp[4]; // 윗면이 새로운 윗면 값으로 초기화된다.
dice[3] = tmp[1]; 
dice[4] = tmp[6];
dice[6] = tmp[3];
```

<br>

만약 초기의 주사위를 서쪽으로 굴린다고 가정하자.

| 윗면  | 아랫면 | 앞   | 뒤   | 오른쪽 | 왼쪽  |
| --- | --- | --- | --- | --- | --- |
| 3   | 4   | 5   | 2   | 6   | 1   |

```java
dice[1] = tmp[3]; // 윗면이 새로운 윗면 값으로 초기화된다.
dice[3] = tmp[6]; 
dice[4] = tmp[1];
dice[6] = tmp[4];
```

<br>

마찬가지로, 북쪽으로 굴린다고 가정하자.

| 윗면  | 아랫면 | 앞   | 뒤   | 오른쪽 | 왼쪽  |
| --- | --- | --- | --- | --- | --- |
| 5   | 2   | 6   | 1   | 3   | 4   |

```java
dice[1] = tmp[5]; // 윗면이 새로운 윗면 값으로 초기화된다.
dice[2] = tmp[1]; 
dice[5] = tmp[6];
dice[6] = tmp[2];
```

<br>

마지막으로, 남쪽으로 굴린다.

| 윗면  | 아랫면 | 앞   | 뒤   | 오른쪽 | 왼쪽  |
| --- | --- | --- | --- | --- | --- |
| 2   | 5   | 1   | 6   | 3   | 4   |

```java
dice[1] = tmp[2]; // 윗면이 새로운 윗면 값으로 초기화된다.
dice[2] = tmp[6]; 
dice[5] = tmp[1];
dice[6] = tmp[5];
```

<br>

또한 주사위를 굴릴 때, 범위를 넘어가지 않게 주의해야 하는데 나의 경우는, 처음에 주사위를 굴리고 나서 출력 여부만 범위를 따졌는데 생각해 보니 이미 주사위를 굴릴 때 값이 갱신되기 때문에 그 전에 범위를 따져봐야 한다. 😊

<br>

<hr>

#### #뱀

[뱀 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.10/Solution_3190.java)🐍

어려울 줄 알았는데 침착하게 생각하니 금방 풀 수 있었다. 삼성 SW 역량 테스트 기출 문제 골드 5 난이도 중 가장 쉽게 풀었던 것 같다! 문제에 큐와 덱 태그도 있었는데 그래서 큐와 덱을 사용해서 문제를 풀려고 노력했다. 큐는 방향 변환 명령들을 저장하는 데 사용하고, 덱은 뱀의 몸통을 나타내기 위해서 사용했다. 특히, 사과를 만나지 않았을 때 꼬리를 당겨와야 하는데 이를 덱을 이용했다.

따라서 큐는 좌표와 명령어를 저장하는 Command 객체로, 덱은 좌표를 저장하는 Location 객체 타입으로 정했다. 

<br>

1. 방향 변환은 큐에 저장하고, 사과의 위치는 이차원 배열에서 2로 표시했다. 
2. 시간을 세야 하기 때문에 cnt를 0으로 정의하고, 문제에서 주어진대로 시작점은 1, 1로 정해준 후에 덱에 해당 좌표를 삽입한다. 처음엔 오른쪽으로 이동해야 하기 때문에 direction을 오른쪽인 D로 설정한다.
3. 큐의 첫 번째 항목이 가리키는 시간이 현재 시간이 같은지 비교하고, 만약 같다면 현재 위치와 명령어를 기준으로 새로운 위치를 잡아준다.
4. direction에 맞춰서 좌표 값을 조정해 준다.
5. 4번에서 맞춘 nx, ny 값이 벽 범위 안인지 확인한다. 만약 벽에 부딪힌다면 break해서 반복문에서 빠져나온다.
6. 벽의 범위 안이지만 뱀의 머리가 향할 지점이 뱀의 몸통 즉, 1이라면 마찬가지로 break한다.
7. 만약 사과 즉, 2라면 뱀의 머리가 향하고 있는 좌표를 덱에 추가해 주고 좌표 값을 1로 표시해 뱀의 몸통임을 나타낸다.
8. 만약 빈칸이라면 뱀의 머리는 그대로고 꼬리는 당겨져야 하기 때문에 덱의 첫 번째 값, 그러니까 제일 먼저 넣은 값을 빼낸 뒤 그 좌표에 대해서 0으로 표시해 뱀이 앞으로 이동했음을 나타낸다.
9. 반복문에서 빠져나왔다면 cnt를 출력한다.

<br>

방향 변환에서 제일 오래 걸렸는데, 

```
왼쪽으로 돌리기 = (현재 방향 + 3) % 4
오른쪽으로 돌리기 = (현재 방향 + 1) % 4
```

이 방식을 사용하면 쉽게 변환이 가능하다고 한다! 물론 dx, dy는 시계방향 즉, 북동남서나 반시계 방향을 가리켜야 한다. [참고](https://bcp0109.tistory.com/entry/%EB%B0%B1%EC%A4%80-3190%EB%B2%88-%EB%B1%80-Java-Python)

<br>

<hr>

⭐⭐⭐⭐⭐

#### #아기 상어

[아기 상어 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.10/Solution_16236.java)🦈

삼성 SW 역량 테스트 기출 문제다. 거리가 가장 가까운 물고기를 찾는 게 조금 까다로웠지만 어렵진 않았다. 나는 Comparator를 활용했다.

<br>

1. 입력을 받으면서 아기 상어의 현위치를 찾는다.
2. 처음부터 먹을 수 있는 물고기가 없는 경우를 제외하기 위해 현재 아기 상어의 위치를 기준으로 bfs 탐색을 한다.
3. bfs 탐색에서 아기 상어의 크기보다 작은 물고기를 만나면 fish 리스트에 넣어 물고기의 위치와 함께 거리를 기억해 둔다.
4. 만약, 아기 상어의 크기와 작거나 같은 물고기들을 만나면 지나갈 수 있기 때문에 경로를 파악하는 queue에 해당 좌표를 삽입한다.
5. 메인으로 돌아와 3번의 fish 결과가 아무것도 없을 경우, 먹을 수 있는 물고기가 없는 것이기 때문에 0을 출력하고 끝낸다.
6. 만약 3번의 결과가 있는 경우, 먹을 수 있는 물고기 중 가장 가까운 물고기를 찾기 위해 ArraySort 함수를 호출한다.
7. ArraySort에서는 거리가 가까운 물고기를 우선적으로 찾기 위해, time을 기준으로 오름차순으로 정렬하고 만약 거리가 같은 물고기가 많다면 위쪽에서 가장 가까운 물고기를 찾기 위해 다시 x 좌표를 기준으로 정렬, 또 다시 왼쪽에서 가장 가까운 물고기를 찾기 위해 y좌표를 기준으로 정렬한다. (정렬을 위해 fish 자료구조를 큐 대신 리스트를 사용한 것!) 
8. fish의 첫 번째 값으로 아기 상어가 이동하고, 아기 상어가 있었던 곳은 0을 넣어 빈 칸으로 만들어준다.
9. cnt를 추가해 물고기 수를 세고, 만약에 아기 상어의 크기와 cnt가 같다면 아기 상어의 크기를 1만큼 늘려주고 cnt를 0으로 초기화해 다시 물고기의 수를 센다.
10. 위 과정을 fish가 없을 때까지 반복하면서 time에 fish의 거리를 더해나가다 더 이상 먹을 물고기가 없으면 time을 출력하고 종료한다.

<br>

우선순위 큐로도 풀 수 있을 것 같은데 아직 낯설어서 일단은 List로 풀었다! 다음엔 우선순위 큐로도 풀어봐야지! (일단 별표시!)

<br>

<hr>

#### #AC

[AC 소스 코드](https://github.com/hjyeon-n/Algorithm_study/tree/master/BOJ/2020.10)

📌 [2023.01.08 업데이트](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2023.01/Solution_5430.java)

어우 문제 보고 쉽겠는데? 싶었는데 시간초과가 나서 이전 풀이 확인해 보고 깜짝 놀랬다ㅎ..

이 문제의 키포인트는 "실제로 문자열을 뒤집지 않는 것"이다. 진짜 뒤집는 척만 하기 위해 flag 변수를 따로 둬야 한다.

그리고 배열이나 리스트 자료구조의 경우 remove 시에 인덱스 이동이 필요해서 O(N) 만큼의 시간 복잡도가 발생한다. 따라서 이 문제에선 정방향, 역방향일 때 첫 번째 문자를 제거할 생각으로 deque로 구현했다.

역시 난이도가 올라갈수록 효율성이 중요해지는 것 같다...

<br>

<u>✍ 여기서부터 이전 풀이!</u>

구현은 어렵지 않은데 시간 초과가 엄청나게 났던 문제.

문자열을 뒤집는 R 명령에 대해서 실제로 문자열을 뒤집기 위해 StringBuilder의 reverse까지 사용했는데, 문제 태그가 덱인 이유가 있었다. 실제로 뒤집지 않고 방향 조정만 해 주고 출력 및 삭제가 이루어져야 한다. 또한 출력 과정에도 단순히 String을 사용하는 게 아니라 StringBuilder를 사용해 시간을 단축시켜야 한다! 😏

<br>

1. 주어지는 배열은 문자열로 주어지고 괄호로 묶여있기 때문에 substring으로 괄호를 제거하고, split을 통해서 ','를 중심으로 문자열을 쪼갠 뒤, 해당 문자열 배열을 덱에 삽입한다.
2. 명령어를 Character 형식으로 쪼개 R일 땐 방향 전환을 위해 direction 값을 반대로 바꿔준다.
3. D일 땐 문자 하나를 삭제해야 하는데 cnt를 비교해서 만약 0보다 작을 경우 error이기 때문에 반복문에서 빠져나와 error를 출력한다.
4. 만약, cnt가 0보다 크거나 같을 때는 direction에 따라 거꾸로 삭제하는지 앞에서 삭제하는지 구분해서 문자를 삭제해 준다.
5. 문자열 출력 시, 맨 마지막 원소에 대해서는 괄호를 붙이지 않는다는 점과 괄호로 다시 묶어줘야 한다는 점에 주의해서 덱의 원소를 전부 출력한다.

<br>

<hr>

#### #접미사 배열

[접미사 배열](https://github.com/hjyeon-n/Algorithm_study/tree/master/BOJ/2020.10/Solution_11656)

역시 실버4... 금방 풀었다. 처음에는 O^2으로 풀었는데, 맞긴 했지만 시간이 너무 오래 걸려서 찾아보니 substring으로 하는 게 좋을 것 같아서 고쳐 보니 시간도 단축되었다. substring으로 접미사들을 자르고 list에 넣어 이를 정렬하면 된다. 별도의 풀이는 생략!

<br>

<hr>

#### #수 이어 쓰기 1

[수 이어 쓰기 1 소스 코드](https://github.com/hjyeon-n/Algorithm_study/tree/master/BOJ/2020.10)

난이도도 어렵지 않아서 금방 풀 수 있을 것이라고 생각했는데 난데없이 시간초과 나서 당황했다.

처음에는 자릿수 문제겠구나 싶어서 cnt += (int)(Math.log10(i) + 1);를 사용해서 자릿수로 구하려고 했는데 시간초과가 났다.

자릿수를 구하기 위해서 반복문을 돌려 나누면 똑같이 시간 초과가 날 것 같아서 고민했다.

그래서 다른 사람들처럼 자릿수가 바뀌는 지점인 10, 100 등 **10으로 나누면 나머지가 0인 경우에 cnt를 하나 올려주는 방식**으로 풀었다.

코드는 어렵지 않으므로 풀이는 생략했다!

<br>

<hr>

#### #미세먼지 안녕!

[미세먼지 안녕! 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.10/Solution_17144.java)

삼성 SW 역량 테스트 기출 문제이다. 삼성은 어려운 알고리즘을 요구하기 보다는 구현 능력을 보는 것 같다. 물론 많은 문제를 푼 건 아니라 일반화하긴 힘들지만... 이 문제도 약간의 노가다(?)가 섞인 구현 문제였다.

미세먼지 확산이 어떻게 진행되는지 감이 잡히지 않아서 어려웠는데 (심지어 예제도 이해가 안 됐다가 포기했었다) **확산된 미세먼지는 이번 회차에서 더하지 않고 기존의 미세먼지만큼 확산시키고 다음 턴이 진행되기 전 더하는 과정**이라고 생각하니 어렵진 않았다.

이 문제는 하나하나 뜯어서 설명하기 힘들어서 주석을 꼼꼼히 달아놨다. 그래서 별도의 풀이는 없음!