# String

| 문제 번호                                    | 이름                                  |
| -------------------------------------------- | ------------------------------------- |
| [3613](https://www.acmicpc.net/problem/3613) | [Java vs C++](#Java-vs-C++)           |
| [7785](https://www.acmicpc.net/problem/7785) | [회사에 있는 사람](#회사에-있는-사람) |
| [9012](https://www.acmicpc.net/problem/9012) | [괄호](#괄호)                         |
| [4949](https://www.acmicpc.net/problem/4949) | [균형잡힌 세상](#균형잡힌-세상)       |

<br>

<hr>

#### #Java vs C++

[Java vs C++ 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.03/Solution_3613.java)

코딩테스트를 볼 때마다 음... 문자열을 확실히 많이 공부해야겠구나 느끼지만 항상 미뤄왔었는데 오늘은 문제를 빨리 풀어야 했어서 문자열 문제 중 가장 쉬운 문제를 풀었다.

근데... 생각보다 예외 조건이 많았다... 😂

처음엔 단순히 입력 받은 문자열 str에 "_"가 있는지 없는지에 따라 C++, JAVA를 구분해서 풀었는데 Error를 출력해야 하는 조건도 있기 때문에 더 많은 예외조건이 필요하다.

C++일 때는

1. 문자열 첫부분과 끝부분에 "_"가 와서는 안 된다.
2. 대문자를 포함하면 안 된다.
3. "_"가 연속으로 나오면 안 된다.

<br>

JAVA일 때는

1. 문자열 첫부분이 대문자가 나오면 안 된다.

<br>

이 부분만 신경 쓰면 문제를 어렵지 않게 풀 수 있다. 그래서 실버5 난이도인가 보다. 이 문제에서는 `Character.isUpperCase()` 함수를 알고 있으면 쉽게 풀 수 있다. 그 전에는 아스키코드로만 대문자인지 소문자인지 판별했는데 이 함수가 있으면 바로 구할 수 있어서 편하다!

<br>

<hr>

#### #회사에 있는 사람

[회사에 있는 사람 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.03/Solution_7785.java)

아무 생각 없이 ArrayList를 사용하면 되겠거니 했는데 시간초과로 틀렸다. 

ArrayList는 해당 값을 찾기 위해 완전 탐색을 하기 때문에 바로 접근할 수 있는 HashSet이나 HashMap을 사용해야 한다.

두 번째로 풀었을 땐 HashMap으로 풀고 key 값을 HashSet에 저장하고 Iterator를 사용해서 다시 ArrayList에 넣는 작업을 거쳤는데 그냥 처음부터 HashSet으로 풀고 ArrayList에 넣으면 된다. 정답 코드도 그렇게 제출했다.

<br>

<hr>

#### #괄호

[괄호 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.07/Solution_9012.java)

사실 문자열 문제도 아니고 예전에 푼 문제지만 별도의 풀이가 없어서 짧막하게 풀이한다!

스택 문제이고 닫는 괄호일 때 stack의 top 값에 해당하는 괄호의 열린 괄호인지 확인하고 괄호가 올바른지 그렇지 않은지 판별하는 문제이다.

stack에 값이 남아있다면 대응되는 괄호가 없다는 뜻이기 때문에 불완전하고 마찬가지로 stack에 닫힌 괄호부터 들어가면 불완전하다.

<br>

<hr>

#### #균형잡힌 세상

[균형잡힌 세상 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.03/Solution_4949.java)

문자열 문제인 줄 알고 풀었는데 사실 괄호랑 똑같은 문제다...!