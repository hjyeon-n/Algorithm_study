# Greedy Algorithm

| 문제 번호 | 이름                        |
| --------- | --------------------------- |
| 11399     | [ATM](#ATM)                 |
| 11047     | [동전 0](#동전-0)           |
| 1931      | [회의실 배정](#회의실-배정) |
| 5585      | [거스름돈](#거스름돈)       |
| 2217      | [로프](#로프)               |
| 2812      | [크게 만들기](#크게-만들기) |
| 1092      | [배](#배)                   |

<br>

<hr>

#### #ATM

[ATM 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.07/Solution_11399.java  )

자존감 올려주는 문제💪

사람이 돈을 인출하는 데 필요한 시간의 합의 최솟값을 구하기 위해서는 시간이 적게 걸리는 사람 순으로 정렬을 하면 된다.

1. 사람 수와 걸리는 시간을 입력 받기

2. 소요 시간을 배열에 저장한 뒤 정렬

3. 앞사람의 걸리는 시간만큼 더해줘야 하기 때문에 sum 배열을 선언

4. 두 번째 사람의 소요 시간(sum[1]) = 첫 번째 사람의 소요 시간(sum[0]) + 두 번째 사람의 소요시간(arr[1])<br>

   세 번째 사람의 소요 시간(sum[2]) = 두 번째 사람의 소요시간(sum[1]) + 세 번째 사람의 소요시간(arr[2]) <br>

   ... <br>

   이런 식의 논리가 전개되도록 loop 짜기

5. 최종값인 rslt는 sum의 값을 더하면 구할 수 있다.

<br>

<hr>

#### #동전 0

[동전 0 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.07/Solution_11047.java )

최소의 동전을 사용해 그 값을 k원으로 만들기 위해서는 가치가 높은 동전을 이용하면 된다.

1. 오름차순으로 입력을 받아 배열에 저장
2. 배열의 가장 끝 원소가 가장 가치가 높은 동전이기 때문에 역순으로 계산
3. 동전의 개수를 구하기 위해 k원을 동전의 가치만큼 나눠 그 몫을 동전의 수를 세는 rslt에 더해줌
4. k원을 앞서 구한 동전의 가치만큼 제외해야 하기 때문에 3번의 나머지로 k를 다시 초기화

<br>

<hr>

#### #회의실 배정

[회의실 배정 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.07/Solution_1931.java   )

문제를 잘 읽어야 한다. '최대 사용할 수 있는 회의의 최대 개수'를 구해야 하기 때문에 시작시간이나 소요 시간을 기준으로 정렬하는 것이 아니라 끝나는 시간을 기준으로 정렬해야 회의를 최대한 많이 할 수 있다.

무엇보다 Comparator를 사용해 한 인덱스를 기준으로 다른 인덱스의 값들을 정렬하는 게 가장 어려웠다...😫



1. 시작 시간과 끝나는 시간을 각각 arr1[], arr2[]에 입력 받는다.
2. 종료 시간이 같을 경우 시작시간으로 정렬하고, 그렇지 않으면 종료 시간 기준으로 정렬한다.
3. 정렬 후, 종료 시간과 다음의 시작 시간을 비교

<br>

<hr>

#### #거스름돈

[거스름돈 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.07/Solution_5585.java)

동전 0과 비슷한 문제지만 더 쉽다.

잔돈의 개수가 최소가 되게 돌려주려면 가치가 큰 동전으로 돌려줘야 한다. 예를 들어서, 500원을 잔돈으로 돌려주려면 100원짜리 동전 5개 혹은 500원짜리 동전 1개으로 돌려줄 수 있는데 잔돈의 개수가 최소가 되기 위해서는 100원보다 가치가 큰 500원 동전으로 돌려주면 된다.



1. "1000엔짜리 지폐 한 장을 냈을 때" 라는 조건이 있기 때문에 1000에서 입력값만큼 빼준다.
2. 내림차순으로 정렬된 동전 배열을 선언한다.
3. 잔액이 0원이 되거나 동전 배열의 길이까지 반복문을 돌리면서 잔액(거스름돈)을 큰 동전부터 나누기 연산을 사용해 동전의 개수를 구하고 동전의 개수를 구하는 cnt에 더해주고, 나머지 연산을 사용해 남은 잔액을 구해준다.

<br>

<hr>

#### #로프

[로프 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.07/Solution_2217.java)

문제를 잘 읽지 않아서 한참 헤맸다.  처음엔 밧줄 전부를 사용하는 문제로 착각해서 당연히 최대 중량이 가장 작은 값을 기준으로 로프의 수 k만큼 곱해야 하는 줄 알았다...😓

**"모든 로프를 사용할 필요는 없고, 임의의 로프를 몇 개 골라서 사용할 수 있다"** 

예를 들어 로프가 3개, 각각의 로프의 w는 각각 5, 4, 3이라고 한다면 병렬로 연결하여 최대 중량을 구하기 위해서는 중량이 큰 순서부터 정렬 뒤에 하나씩 꺼내서 중량이 가장 작은 로프의 중량에 병렬로 연결된 로프의 수만큼 곱하면 된다.

즉, 먼저 5를 꺼내면 **최대 중량은 5 * 1 = 5**

그 후에 4를 꺼내면 **최대 중량은 4 * 2 = 8**

마지막으로 3을 꺼내면 **최대 중량은 3 * 3 = 9**



1. k와 밧줄의 w를 입력 받아 배열(arr)에 저장한다.
2. arr[]를 내림차순으로 정렬한다.
3. 각각의 경우에 최대 중량을 구하기 위해 rope[] 배열을 선언한다.
4. rope[]에 arr[] * 꺼낸 밧줄의 수를 저장한다.
5. rope를 정렬한 뒤, 최댓값인 rope[n]을 출력하면 된다.

<br>

<hr>

#### #크게 만들기

[크게 만들기 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.07/Solution_2812.java)

처음에는 단순히 그냥 입력 받은 값을 내림차순으로 정렬한 뒤에 뒤에서부터 k개만큼 제외시키면 되는 문제인 줄 알았다. 이상해서 반례 찾아보다가 값은 그대로 입력받되, 전에 받았던 수보다 작은 수가 입력되면 제외시키고 그게 k개가 되면 나머지 숫자들은 제외하지 않고 그대로 입력이 되는 방식이었다. 이를 위해서 스택을 사용할 수 있지만 스택과 큐의 성격을 갖는 덱을 사용해 해결했다.

1. N자리 숫자를 입력 받아 arr[] 배열에 저장한다.
2. 덱을 선언한 뒤, arr[0]을 삽입한다.
3. arr의 길이만큼 반복하되, arr의 값이 하나 들어올 때마다 덱이 비어있지 않고 덱의 마지막 값(가장 최근에 넣었던 값)보다 arr의 값이 크고, 제외할 k의 개수가 아직 남아있을 때를 고려하여 이 과정을 while문으로 반복한다. 
   + 처음에는 if로 해도 될 줄 알았는데 같은 값이 연속으로 들어갈 수 있기 때문에 (예를 들어, k = 2인 667436) 반복문을 사용한다.
4. arr[]의 값을 덱의 마지막 값에 삽입한다.
5. 덱의 사이즈가 0이 될 때까지 덱의 첫 번째 값을 삭제하면서 그 값을 출력한다.

<br>

<hr>

#### #배

[배 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.07/Solution_1092.java) 🚢

모든 박스를 배로 옮기는 데 최소 시간을 구해야 하기 때문에 크레인과 박스의 무게를 큰 순서부터 정렬을 해야 한다.

(예를 들어 크레인의 무게 제한이 10 6 9, 각 박스의 무게가 2, 10, 9, 4, 10일 때 정렬하지 않았을 경우 걸리는 최소 시간은 3분, 정렬했을 때 걸리는 최소 시간은 2분)

1. 입력을 받고 crane[] (크레인의 무게 제한), box 리스트 (박스의 무게) 를 내림차순으로 정렬한다.
2. 최소 시간을 구하기 위해 int형 min을 선언하고, 0으로 초기화 한다.
3. box 리스트에 남은 원소가 없을 때까지 반복문을 돌면서 크레인에 박스를 싣는 과정을 구현한다.
4. 크레인의 배열이 다 끝날 때까지 크레인에 박스를 실을 수 있으면 (즉, 박스의 무게보다 크레인의 무게 제한이 더 크면) box 리스트에서 해당 원소를 삭제한 뒤, 크레인의 인덱스인 idx를 늘려주고 박스의 인덱스인 i는 0으로 초기화한다. 만약, 박스를 실을 수 없으면 박스의 인덱스인 i를 늘려주고 다시 처음으로 돌아간다.
5. 4번의 과정을 거친 후, min을 하나 늘려주고 만약 min이 박스의 개수인 m보다 더 커지면 모든 박스를 배에 옮길 수 없기 때문에 -1을 출력한다.
