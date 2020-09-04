# Back Tracking 🔍

| 문제 번호 | 이름          |
| --------- | ------------- |
| 14889     | 스타트와 링크 |

<br>

<hr>

#### #스타트와 링크

[스타트와 링크 소스 코드](https://github.com/hjyeon-n/Algorithm_study/tree/master/BOJ/2020.09/Solution_14889)

삼성 SW 역량 테스트 기출 문제. 난이도는 실버3이었는데 체감은 실버1쯤이었다.

몸이 좋지 않아서 중간중간 쉬는 바람에 엄청나게 오랜 시간동안 문제를 풀었다. 😥

<br>

**ver 1 풀이 과정**

문제는 스타트와 링크라는 두 팀으로 나누고 각 팀의 능력치를 더한 후 능력치의 차가 최소가 되는 값을 구하면 된다.

두 팀으로 나누는 경우가 조합과 같았기 때문에 [N과 M (2)](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.08/Solution_15650.java)을 참고했다.

두 팀으로 나누고 나서 경험치를 더하는 과정은 순열로 구했다. (지금 생각해 보면 이미 ij와 ji의 합을 더했기 때문에 이 과정은 전혀 필요가 없었다... 왜 이렇게 풀었는지 의문...) 

N의 범위가 작아 시간초과를 피할 수 있었지만, 뭔가 깔끔하지 않기도 했고 시간도 다른 사람과 비교했을 때 꽤 많이 소요됐기 때문에 다른 사람의 코드를 참고해서 다시 풀었다.

<br>

**ver 2 풀이 과정**

1. 팀에 들어가는 사람을 정하기 위해 마찬가지로 조합을 사용했다. ver1(이미 스타트에 사람을 집어넣고, 후에 스타트 팀에 없는 사람을 링크팀에 넣는 방식)과 다르게 동시에 스타트와 링크 팀에 팀원들을 넣었다.

2. 능력치를 더하는 기능의 cal이라는 함수를 정의해 ij, ji의 능력치를 더했다.

   능력치를 더하는 과정도 조합과 같은 방식으로 이루어진다.

   예를 들어, 스타트 팀에 1, 2, 3이 속해있다고 하자. (코드에선 0, 1, 2가 된다.)

   나올 수 있는 경우의 수는 1, 2 / 1, 3 / 2, 3이 되고 각각을 뒤집어 2, 1 / 3, 1 / 3, 2를 구해 더해주면 된다.

   **경우의 수를 잘 보면 앞의 값보다 뒤에 있는 값이 크다.** 따라서 코드 상에서는 

   ```java
   for (int i = 0; i < arr.length; i++) {
   	for (int j = i + 1; j < arr.length; j++) {
   		x = arr[i]; 
   		y = arr[j];
   		sum += s[x][y] + s[y][x]; // Sij + Sji
   	}
   }
   ```

   이와 같이 나오게 된다.

3. 스타트와 링크의 cal의 반환값을 빼서 min에 저장되어있는 값과 비교해 더 작은 값을 min에 저장한다.
