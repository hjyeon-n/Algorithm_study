# GROUP BY

| 문제 링크                                                    | 문제 이름                                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [고양이와 개는 몇 마리 있을까](https://programmers.co.kr/learn/courses/30/lessons/59040) | [고양이와 개는 몇 마리 있을까](#고양이와-개는-몇-마리-있을까) |
| [동명 동물 수 찾기](https://programmers.co.kr/learn/courses/30/lessons/59041) | [동명 동물 수 찾기](#동명-동물-수-찾기)                      |
| [입양 시각 구하기(1)](https://programmers.co.kr/learn/courses/30/lessons/59412) | [입양 시각 구하기(1)](#입양-시각-구하기(1))                  |
| [입양 시각 구하기(2)](https://programmers.co.kr/learn/courses/30/lessons/59413) | [입양 시각 구하기(2)](#입양-시각-구하기(2))                  |

<br>

<hr>

#### #고양이와 개는 몇 마리 있을까

```sql
SELECT ANIMAL_TYPE, COUNT(*)
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;
```

<br>

#### #동명 동물 수 찾기

``` sql
SELECT NAME, COUNT(NAME)
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
HAVING COUNT(NAME) >= 2
ORDER BY NAME;
```

<br>

#### #입양 시각 구하기(1)

```sql
SELECT HOUR(DATETIME) AS HOUR, COUNT(DATETIME)
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) BETWEEN '09:00' AND '19:59'
GROUP BY HOUR(DATETIME)
ORDER BY HOUR;
```

<br>

#### #입양 시각 구하기(2)

``` sql
SET @HOUR := -1;
SELECT @HOUR := @HOUR + 1 AS HOUR, (SELECT COUNT(*) FROM ANIMAL_OUTS WHERE HOUR(DATETIME) = @HOUR) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR BETWEEN 0 AND 23
ORDER BY HOUR;
```