# Data Structure

| 문제 번호                                    | 이름                                  |
| -------------------------------------------- | ------------------------------------- |
| [6198](https://www.acmicpc.net/problem/6198) | [옥상 정원 꾸미기](#옥상-정원-꾸미기) |

<br>

<hr>

#### #옥상 정원 꾸미기

[옥상 정원 꾸미기 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.03/Solution_6198.java)

처음 봤을 땐 [빗물](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2020.09/Dynamic%20Programming.md#%EB%B9%97%EB%AC%BC) 문제랑 비슷하다고 생각했는데 더 생각해 보니 [탑](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2020.10/Data%20Structure.md#%ED%83%91) 문제와도 비슷했다. 

(사실 제일 처음 봤을 때 이 첨부 사진은 왜 있는 거지... 였다. 🙄)

아쉽게도 스스로 풀지는 못했고 다른 사람 풀이를 참고했다. 😂

1. 입력을 받으면서 stack이 비어있는지 확인한다.
2. 만약 비어있지 않으면 stack의 top 값과 입력 값인 h를 비교한다. 
3. h가 크거나 같다면 stack에 있는 값은 오른쪽 건물들을 더이상 보지 못하므로 stack에서 값을 빼낸다. 
4. h가 작다면 오른쪽을 더 볼 수 있으므로 break하고 현재 stack의 크기 즉, 볼 수 있는 건물의 수를 더한다.
5. 3번과 4번 과정을 stack이 전부 빌 때까지 한다.
6. 현재 stack의 크기(오른쪽을 볼 수 있는 건물들이 남아있다.)를 cnt에 더한다.
7. h가 크거나 같더라도 while 반복문이 있기 때문에 h보다 작은 값들 즉, 더이상 오른쪽 건물을 볼 수 있는 값들은 전부 빠지고 h보다 큰 건물만 존재하기 때문에 h를 삽입한다. 반대의 경우라도 stack에 남아 있는 값들은 h보다 큰 값들이기 때문에 h를 삽입한다.
8. 입력 값을 전부 받으면 cnt를 출력한다.