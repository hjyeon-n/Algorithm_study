# Dynamic Programming

| 문제 번호 | 이름                         |
| --------- | ---------------------------- |
| 12865     | [평범한 배낭](#평범한-배낭)⭐ |
| 1904      | [01타일](01타일)             |

<br>

<hr>

⭐⭐⭐⭐⭐

#### #평범한 배낭

[평범한 배낭 소스 코드](https://github.com/hjyeon-n/Algorithm_study/tree/master/BOJ/2020.08/Solution_12865) 

아무 생각없이 덤볐다가 깨갱...😟 

처음엔 N이 5라면, 1 ~ 5 / 2 ~ 5 ... 이런 식으로 비교하려고 했다. DP 같지도 않고, 뭔가 이상하다 생각했는데 역시나 틀렸다.

틀린 후에 냅색 알고리즘에 대해서 조금 공부하고 문제를 풀었다. [참고](https://fbtmdwhd33.tistory.com/60?category=737465)

1차원으로 푸는 게 좀 더 빠르고 메모리도 적게 들겠지만 아직은 이해가 잘 되지 않아서 2차원으로 푸는 연습을 해야겠다.

링크에 잘 설명이 되어있긴 하지만, 나중의 내가 또 무슨 말이지... 할 수 있어서 다시 한 번 정리한다.

i의 값은 물건의 순서, j는 물건의 무게. dp[i] [j]는 해당 차례 물건과 무게에서의 얻을 수 있는 최대 가치

<br>

입력값이 이렇게 들어왔다고 가정하자.

```
4 7
6 13
4 8
3 6
5 12
```

<br>

1번 물건은 무게가 6, 가치가 13이다. 따라서 무게 6부터 1번을 담을 수 있고, 이전에는 담을 수 없으므로 모두 0이다.

| 순서 / 무게 | 무게 1 | 무게 2 | 무게 3 | 무게 4 | 무게 5 | 무게 6 | 무게 7 |
| ----------- | ------ | ------ | ------ | ------ | ------ | ------ | ------ |
| **1번**     | 0      | 0      | 0      | 0      | 0      | 13     | 13     |
| **2번**     |        |        |        |        |        |        |        |
| **3번**     |        |        |        |        |        |        |        |
| **4번**     |        |        |        |        |        |        |        |

<br>

2번 물건은 무게가 4, 가치가 8이다. 따라서 무게 4부터 2번을 담을 수 있다. 하지만 무게 6일 때는 1번을 담을 수도 있고 2번을 담을 수도 있다. 하지만 2개를 담기엔  K인 7을 넘기 때문에 둘 중 가치가 더 큰 물건을 넣어야 한다. 따라서 무게 6부터는 1번 물건을 넣어야 한다.

| 순서 / 무게 | 무게 1 | 무게 2 | 무게 3 | 무게 4 | 무게 5 | 무게 6 | 무게 7 |
| ----------- | ------ | ------ | ------ | ------ | ------ | ------ | ------ |
| **1번**     | 0      | 0      | 0      | 0      | 0      | 13     | 13     |
| **2번**     | 0      | 0      | 0      | 8      | 8      | 13     | 13     |
| **3번**     |        |        |        |        |        |        |        |
| **4번**     |        |        |        |        |        |        |        |

<br>

세 번째는 무게가 3, 가치가 6이다. 따라서 무게 3부터 3번 물건을 담을 수 있다. 무게 4부터는 2번을 담을 수도 있고 3번을 담을 수도 있다. 이때 2개를 담아도 K 값을 넘지 않으므로 2개를 가방에 넣는다. 무게 5부터는 이전의 값과 현재 최댓값을 비교해 최댓값을 넣어주면 된다.

| 순서 / 무게 | 무게 1 | 무게 2 | 무게 3 | 무게 4 | 무게 5 | 무게 6 | 무게 7 |
| ----------- | ------ | ------ | ------ | ------ | ------ | ------ | ------ |
| **1번**     | 0      | 0      | 0      | 0      | 0      | 13     | 13     |
| **2번**     | 0      | 0      | 0      | 8      | 8      | 13     | 13     |
| **3번**     | 0      | 0      | 6      | 14     | 14     | 14     | 14     |
| **4번**     |        |        |        |        |        |        |        |

<br>

4번 물건은 무게가 5, 가치가 12이다. 이전과 마찬가지로 무게 5 전에는 이전의 최댓값을 넣어주면 된다. 무게 5일 때는 5번 물건을 넣을 수도 있고 이전의 최댓값에 해당하는 물건들을 그대로 둘 수도, 아니면 5번 무게를 포함할 수도 있다. 하지만 K값을 넘으므로 모두 넣을 수는 없고 최댓값과 5번 물건의 가치를 비교한 후 큰 값을 넣어준다.

| 순서 / 무게 | 무게 1 | 무게 2 | 무게 3 | 무게 4 | 무게 5 | 무게 6 | 무게 7 |
| ----------- | ------ | ------ | ------ | ------ | ------ | ------ | ------ |
| **1번**     | 0      | 0      | 0      | 0      | 0      | 13     | 13     |
| **2번**     | 0      | 0      | 0      | 8      | 8      | 13     | 13     |
| **3번**     | 0      | 0      | 6      | 14     | 14     | 14     | 14     |
| **4번**     | 0      | 0      | 6      | 14     | 14     | 14     | 14     |

따라서 가방에 넣을 수 있는 최대 가치는 dp[n] [k] = 14 이다.

<br>

과정은 이해해도 점화식을 짜기 힘들 수 있다. 이 문제는 크게 두 가지의 경우가 있다.

1. 배낭에 현재 물건을 담는 경우
2. 현재 물건을 담지 않는 경우

1번의 경우엔 배낭에 물건을 담으면서 K의 값이 그만큼 줄어들어야 한다. 

✔ 따라서 점화식은 dp[i] [j] = dp[i - 1] [j - 현재 물건 무게] + 현재 물건 가치

2번의 경우엔 물건을 담지 않기 때문에 이전의 값을 가지고 오면 된다.

✔ 따라서 점화식은 dp[i] [j] = dp[i - 1] [j];



우리는 이 중에서 최댓값을 찾아야 하기 때문에 결국 최종 점화식은

✔ dp[i] [j] = Math.max(dp[i - 1] [j], dp[i - 1] [j - 현재 물건 무게 + 현재 물건 가치);

<br>

<hr>

#### #01타일

[01타일 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.08/Solution_1904.java)

사실 풀이라고 하기에도 민망하다... 너무 쉬워서...

이번에도 점화식을 구하기 위해서 규칙을 찾던 중 수가 피보나치 수열인 걸 발견하고 바로 풀었다. 하지만 피보나치 수열이 이루어지는 이유가 있을 거라고 생각해서 문제를 더 분석해 보았다.

0은 무조건 2개 이상의 짝수로 나와야 하고 1은 어떤 수가 와도 상관이 없다.

예를 들어서 N = 5라면,

첫 번째 자리에 들어올 수 있는 수는 0 또는 1이다. 1은 뒤에 어떤 수가 나와도 상관 없기 때문에 N -1 즉, N이 4일 때와 같은 경우의 수가 나올 것이다. 하지만 0으로 시작할 경우 0이 2개 이상으로 나와야 하기 때문에 N - 2 자리 수 즉, N이 3일 때와 같은 경우의 수가 나올 것이라 예상할 수 있다. 

✔ 따라서 점화식은 dp[n] = dp[n - 1] + dp[n - 2]