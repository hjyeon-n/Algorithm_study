# Programmers

| 문제 이름                       | 문제 링크                                                    |
| ------------------------------- | ------------------------------------------------------------ |
| [줄 서는 방법](#줄-서는-방법)   | [줄 서는 방법](https://programmers.co.kr/learn/courses/30/lessons/12936) |
| [영어 끝말잇기](#영어-끝말잇기) | [영어 끝말잇기](https://programmers.co.kr/learn/courses/30/lessons/12981) |

<br>

<hr>

#### #줄 서는 방법

[줄 서는 방법 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.04/%EC%A4%84%20%EC%84%9C%EB%8A%94%20%EB%B0%A9%EB%B2%95.java)

나는 백트래킹을 이용해서 순열로 경우의 수를 구하고 k번째 값을 반환하는 식으로 문제를 풀었는데 효율성에서 바로 틀렸다...

정확성 테스트에서도 오랜 시간 걸릴 것이라 예상했지만 역시...😥

모든 경우의 수를 구하기엔 무리가 있어서 k번에 해당하는 경우만 구할 수 있도록 해야 할 것 같은데 도무지 감이 잡히지 않아서 다른 사람들의 풀이를 참고했다. 수학을 못하는 게 이럴 때 너무 힘이 든다.😭

<br>

전체적인 풀이는 [여기](http://blog.naver.com/PostView.nhn?blogId=jwyoon25&logNo=221347789536&categoryNo=0&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView&userTopListOpen=true&userTopListCount=5&userTopListManageOpen=false&userTopListCurrentPage=1)에서 참고하면 된다.

<br>

<hr>

#### #영어 끝말잇기

[영어 끝말잇기 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.04/%EC%98%81%EC%96%B4%20%EB%81%9D%EB%A7%90%EC%9E%87%EA%B8%B0.java)

 HashSet을 이용해서 풀었고 레벨1이어도 놀랍지 않을 쉬운 난이도였다. 슬슬 레벨2에서 졸업하고 레벨3 문제를 집중적으로 풀어야겠다...

이 문제는 몇 번째 사람이 또 그 사람이 몇 번째 말을 했을 때를 반환하면 되는 문제인데 나머지 연산을 이용하면 쉽게 풀 수 있다.

예를 들어 4명이 끝말잇기를 했을 때 9번째에서 탈락자가 생긴다고 가정하면, 

9 / 4 는 2, 나머지는 1이 된다. 즉, 첫 번째 사람이 탈락하고, 첫 번째 사람은 세 번째 (2 + 1)로 말했을 때 탈락하게 된다.

<br>

1. 첫 번째 단어의 길이를 확인한다 1이하이면 곧바로 {1, 1} 값을 리턴한다.
2. 단어의 마지막 글자를 last에 넣고 중복 여부를 확인하기 위해 Set을 선언해 단어를 넣어준다.
3. words의 길이만큼 반복문을 돌면서 탈락자가 있는지 탐색한다.
4. 단어의 길이와 last 값, set 중복 여부를 확인한다. 만약, 하나라도 규칙에 위배된다면 위에서 언급했던 방식처럼 배열을 만들어 반환한다. 이때, 주의해야 할 점은 배열이기 때문에 9가 아니라 8처럼 1만큼 줄어들기 때문에 자신의 몇 번째 탈락하는지 확인하는 부분에서 1을 더해준다.
5. 반복문을 빠져나오면 끝말잇기가 성공적으로 끝났다는 의미이므로 {0, 0}을 반환한다.

