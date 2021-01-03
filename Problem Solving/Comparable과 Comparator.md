# Comparable과 Comparator 😎

Comparator 문제만 나올 때마다 계속 찾아보다가 더이상 미룰 수 없기에... 정리해둔다✍

<br>

Comparable과 Comparator의 차이는 이렇다.

**Comparable - 기본 정렬기준을 구현하는 데 사용.**

**Comparator - 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용.** 

하나하나 자세히 살펴보자. 😉

<br>

### Comparable 🐱

Comparable은 기본 정렬기준을 구현하는 데 사용된다고 했는데 대표적인 예는 이와 같다.

>  Arrays.sort(arr)는 **String 의 Comparable 구현에 의해 정렬**된 것.

<br>

**Comparable 인터페이스를 클래스에 구현**

```
public class Student implements Comparable<Student>{
    private int score;
    private int stNum;

    public int compareTo(Student student){
        int a = this.score
        int b = student.score;
        if (a < b) {
            return 1;
        }
        else if (a > b) {
       		return -1;
        } 
        return 0;
    }
```

정렬하고 싶은 클래스에 'implements Comparable<ClassName>' 을 붙인 다음 `compareTo()` 라는 메서드를 오버라이드해 준다. `compareTo()` 메서드의 인자로는 객체가 들어오는데, 이 메소드의 역할은`compareTo()` 를 호출한 객체 (this) 와 인자로 들어온 객체를 가지고 값을 비교한 후 1, 0, 또는 -1을 반환한다.

`compareTo()`는 직접적으로 개발자가 호출하는 방식이 아니라, Comparable 인터페이스가 구현된 클래스 객체들이 담겨있는 배열을 sort하게 되면 자동으로 각 객체들에 대해서 이 메소드가 호출되면서 각각의 객체들끼리 비교를 수행하게 된다.

1이 리턴되면 두 객체의 자리가 바뀌며, 0이나 -1일 경우엔 바뀌지 않는다. '**현재 객체의 값 > 인자로 들어온 객체의 값' 일 때 1을 반환하면 오름차순 정렬이 되며, -1을 반환하면 내림차순 정렬이 된다.** 또는 반환 값은 그대로 두고 부등호만 반대로 바꿔도 오름차순/내림차순이 바뀐다.

> Arrays.sort(records); // records가 배열일 경우
> Collections.sort(records); // records가 ArrayList일 경우

<br>

#### ➕ 문자열에서의 compareTo

문자열에서의 `compareTo()`는 친절하게 0, - 1, 1 같은 정수만 반환하는 게 아니다.😂

예시를 들어보자.

```
String str = "abcd";

 // 1) 비교대상에 문자열이 포함되어있을 경우

System.out.println( str.compareTo("abcd") ); // 0 (같은 경우는 숫자나 문자나 0을 리턴)

System.out.println( str.compareTo("ab") ); // 2

System.out.println( str.compareTo("a") ); // 3

System.out.println( str.compareTo("c") ); // -2    

System.out.println( "".compareTo(str) ); // -4 

// 2) 비교대상과 전혀 다른 문자열인 경우

System.out.println( str.compareTo("zefd") ); // -25

System.out.println( str.compareTo("ABCD") ); // 32
```

<br>

아니... 이게 무슨 소리야? 🤯 싶지만 차근차근 보면 이해가 된다‼

```
str.compareTo("ab") // 2

str.compareTo("a") // 3
```

"**abcd**" 에 "**ab**" 가 **포함**되어 있으며, 그럴 경우에는 **서로의 문자열 길이의 차이값을 반환**한다. 나머지도 마찬가지.

<br>

```
"".compareTo(str) // 4
```

이 경우엔 공란과 비교하기 때문에 그냥 **문자열의 길이를 반환**한다.

<br>

```
str.compareTo("c") // -2
```

이 경우엔 "**abcd**"와 달리 첫 부분이 "**c**"로 나오기 때문에 더 보지도 않는다! 이 경우에 `compareTo()`는 모두 같은 방식으로 반환해 준다.

`compareTo()`는 int값을 반환하기 때문에 **문자를 int값으로 반환하기 위해** "**아스키코드**" 를 사용한다. 

따라서, 아스키코드를 사용한 방식으로 각 문자열에서 가장 낮은 아스키코드의 차이값을 반환한다.

예시에서는 "abcd"에서 가장 낮은 값을 가진것은 "a" 이며, "c" 에서 당연히 가장 낮은 값은 "c"이므로

아스키코드의 차이값은 **a = 97 / c = 99 이기 때문에 순서에 따라 -2값이 **반환된다.

<br>

```
str.compareTo("zefd") // -25

str.compareTo("ABCD") // 32
```

이 경우도 마찬가지로 **a = 97 / z = 122이기 때문에 -25가 반환된다.** 

또한 `compareTo()`는 대소문자를 구별하므로, **a = 97 / A = 65이기 때문에 32가 반환된다.**

<br>

<hr>

### Comparator 🐶

Comparator 이건 또 뭐야...😫 싶지만 생각보다 꽤 익숙하다. 대표적인 예는 이와 같다.

> Arrays.sort(arr, Collections.reverseOrder());

`Collections.reverseOrder()`는 Comparator 객체이다. Comparator는 직접 구현해야 하지만, 내림차순은 자주 사용되기 때문에 Collections에서 기본으로 제공해주고 있다.

<br>

**Comparator 사용하기**

Comparable 방법의 경우,  `compareTo()`  메소드는 한 클래스에 하나만 있어야 하기 때문에 정렬 기준도 하나밖에 될 수 없다. 다른 정렬 기준도 선택할 수 있게 하고 싶다면 Comparator을 사용하면 된다!

```
Collections.sort(arr, new Comparator<Student>() {
	@Override
	public int compare(Student o1, Student o2) {
		int a = o1.score;
		int b = o2.score;
		if (a > b) {
			return -1;
		}
		if (a < b) {
			return 1;
		}
		return 0;	
	}
});
```

Collections.sort() 는 Comparable 방법처럼 하나의 인자만 받을 수도 있지만, 2번째 인자를 추가로 받을 수도 있다. 2번째 인자로 Comparator라는 인터페이스가 들어갈 수 있으며(즉, 익명 클래스로 사용), 이 안에다가 `compare()`  메소드를 오버라이드해주면 된다.

`compare()`  메소드를 작성하는 방법은 `compareTo()` 와 유사하지만 여기선 비교할 클래스 안에 메서드를 정의한 게 아니므로 this랑 파라미터를 비교하는게 아니라 파라미터 두 개를 (o1, o2) 받아서 서로 비교하게 된다.

+ 양수가 리턴 되는 경우 현재 Object가 앞
+ 음수가 리턴 되는 경우 현재 Object가 뒤
+ 0이 리턴되는 경우 동일 값으로 간주하고 입력순서 유지

정렬 기준을 선택하는 변수를 만든 다음 그 변수 값에 따라 서로 다른 Collections.sort() 가 실행되도록 만들어주면 여러 기준으로 정렬할 수 있다.

<br>

<hr>

[참고1](https://gsmesie692.tistory.com/165)

[참고2](https://cwondev.tistory.com/15)

[참고3](https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html)

[참고4](https://codechacha.com/ko/java-sorting-array/)

[참고5](https://mine-it-record.tistory.com/133)