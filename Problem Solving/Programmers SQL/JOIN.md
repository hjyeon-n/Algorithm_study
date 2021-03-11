# JOIN

| 문제 링크                                                    | 문제 이름                                             |
| ------------------------------------------------------------ | ----------------------------------------------------- |
| [없어진 기록 찾기](https://programmers.co.kr/learn/courses/30/lessons/59042) | [없어진 기록 찾기](#없어진-기록-찾기)                 |
| [있었는데요 없었습니다](https://programmers.co.kr/learn/courses/30/lessons/59043) | [있었는데요 없었습니다](#있었는데요-없었습니다)       |
| [오랜 기간 보호한 동물(1)](https://programmers.co.kr/learn/courses/30/lessons/59044) | [오랜 기간 보호한 동물(1)](#오랜-기간-보호한-동물(1)) |
| [보호소에서 중성화한 동물](https://programmers.co.kr/learn/courses/30/lessons/59045) | [보호소에서 중성화한 동물](#보호소에서-중성화한-동물) |

<br>

<hr>

#### #없어진 기록 찾기

``` sql
SELECT b.ANIMAL_ID, b.NAME 
FROM ANIMAL_INS as a RIGHT OUTER JOIN ANIMAL_OUTS as b ON a.ANIMAL_ID = b.ANIMAL_ID 
WHERE a.ANIMAL_ID IS NULL
```

``` sql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS
WHERE ANIMAL_ID NOT IN(SELECT ANIMAL_ID
                      FROM ANIMAL_INS);
```

<br>

#### #있었는데요 없었습니다

``` sql
SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.DATETIME > O.DATETIME
ORDER BY I.DATETIME;
```

<br>

#### #오랜 기간 보호한 동물(1)

``` sql
SELECT I.NAME, I.DATETIME
FROM ANIMAL_INS I LEFT OUTER JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE O.ANIMAL_ID IS NULL
ORDER BY I.DATETIME
LIMIT 3;
```

<br>

#### #보호소에서 중성화한 동물

``` sql
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O
USING (ANIMAL_ID)
WHERE I.SEX_UPON_INTAKE LIKE '%Intact%' AND O.SEX_UPON_OUTCOME NOT LIKE '%Intact%'
```

``` sql
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.SEX_UPON_INTAKE LIKE '%Intact%' AND O.SEX_UPON_OUTCOME NOT LIKE '%Intact%'
```

``` sql
SELECT ANIMAL_ID, ANIMAL_TYPE, NAME
FROM ANIMAL_INS
WHERE SEX_UPON_INTAKE LIKE '%Intact%' AND ANIMAL_ID IN (SELECT ANIMAL_ID
                                                FROM ANIMAL_OUTS
                                                WHERE SEX_UPON_OUTCOME NOT LIKE '%Intact%')
ORDER BY ANIMAL_ID;
```

