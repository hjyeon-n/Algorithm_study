# Codility

| 문제 이름                                       |
| ----------------------------------------------- |
| [BinaryGap](#BinaryGap)                         |
| [CyclicRotation](#CyclicRotation)               |
| [MissingInteger](#MissingInteger)               |
| [OddOccurrencesInArray](#OddOccurrencesInArray) |

<br>

<hr>

#### #BinaryGap

[BinaryGap 소스 코드](https://github.com/hjyeon-n/Algorithm_study/tree/master/Codility/2020.07/BinaryGap)

이진수로 바꾼 후, 처음 나오는 1과 다음 1이 나올 때까지의 거리를 구하면 되는 문제.

이 문제는 7월에 한 번, 9월에 한 번 풀었다. 물론 9월의 코드가 더 깔끔하다! ☺ 풀이는 9월 기준이다.

<br>

나는 이진수를 자바의 toBinaryString 메소드를 이용해서 구했다. 문자열로 반환되기 때문에 charAt으로 문자 하나하나를 비교하면 된다. 만약 1일 때는 gap과 현재 max를 비교해서 더 큰 값을 gap에 넣어주고, 1이 아닐 때는 gap을 하나씩 증가시키면 된다.

<br>

<hr>

#### #CyclicRotation

[CyclicRotation 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Codility/2020.07/CyclicRotation.java)

주어진 K 수만큼 오른쪽으로 이동한 결과를 반환하면 되는 간단한 문제.

1. 배열의 크기가 0이 될 수 있다는 조건은 없지만, 만약 0이라면 더 볼 필요도 없이 그대로 배열을 반환해줘야 한다.

2. K가 0이거나 K가 주어진 배열의 길이와 같은 수라면 오른쪽으로 이동해도 결국 같은 배열 모양이 되기 때문에 그대로 배열을 반환해준다. K가 A의 길이의 배수라면 같은 경우이기 때문에 이 경우도 A를 반환해 주면 된다.
3. 컴퓨터 과학에서는 두 사람이 서로 자리를 바꾸기 위해서는 의자가 3개 필요하다는 농담처럼 이 문제도 tmp라는 변수를 만들어 마지막 인덱스에 저장된 값을 tmp에 넣고 모든 배열들을 오른쪽으로 이동시킨다. 그리고 0번째 인덱스에 tmp 값을 넣어주면 모든 배열의 값을 오른쪽으로 이동시킨 것과 동일하게 된다.

<br>

<hr>

#### #MissingInteger

[MissingInteger 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Codility/2020.07/MissingInteger.java)

배열에 나타나지 않은 자연수 중 가장 작은 수를 반환하면 되는 문제.

1. 가장 작은 수를 알아내기 위해서 우선 오름차순으로 정렬한다.
2. 0보다 큰 수를 찾아야 하기 때문에 음수는 건너뛴다.
3. 자연수인 경우에는 현재 자연수 중 최솟값인 1로 초기화된 answer와 비교한 후 만약 현재 A의 값이 answer보다 작다면 answer 크기를 늘린다.
4. answer를 출력한다.

<br>

<hr>

#### #OddOccurrencesInArray

[OddOccurrencesInArray 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Codility/2020.07/OddOccurrencesInArray.java)

짝이 맞지 않는 값을 고르면 되는 문제.

이 문제를 푼지 3개월이 지나서 어떻게 풀었는지 기억은 잘 안 나지만 아마 효율성에서 계속 감점이 돼서 다른 사람 풀이를 참고했던 것 같다. 문제는 비트 연산(XOR)을 이용해서 풀었다.