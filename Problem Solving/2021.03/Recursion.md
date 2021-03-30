# Recursion

| 문제 번호                                    | 이름                  |
| -------------------------------------------- | --------------------- |
| [1769](https://www.acmicpc.net/problem/1769) | [3의 배수](#3의-배수) |

<br>

<hr>

#### #3의 배수

[3의 배수 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.03/Solution_1769.java)

실버5의 아주 쉬운 문제이다. 재귀가 많이 약한터라 틀릴까 봐 걱정이었지만 다행히 한방에 풀 수 있었다. base condition이 명확했기에 쉽게 풀 수 있었다.

base condition은 X의 길이가 1일 때 그 값이 3의 배수인지 확인하고 그 결과에 따라 YES / NO를 출력한 뒤 return 하여 재귀문에서 빠져나온다.

만약 base condition에 해당하지 않는다면 자릿수의 숫자들을 다 더한 뒤 그 값을 다시 X로 해서 재귀함수를 호출하면 된다.