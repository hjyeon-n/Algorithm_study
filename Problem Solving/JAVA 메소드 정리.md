# JAVA 메소드 정리

TIL에도 정리되어있지만 더 보기 편하라고 여기에도 정리해 둔다! (2021.03.26)

| 바로가기 😎                  |
| --------------------------- |
| [Arrays](#Arrays)           |
| [Collection](#Collection)   |
| [Collections](#Collections) |
| [List](#List)               |
| [Map](#Map)                 |
| [Set](#Set)                 |
| [Stack](#Stack)             |
| [Queue](#Queue)             |
| [Math](#Math)               |
| [자료형](#자료형)           |
| [문자열](#문자열)           |

<br>

___

### #Arrays

- sort : 오름차순으로 정렬

```java
int[] arr = {5, 26, 1, 74, 59, 38};
Arrays.sort(arr);

for (int i = 0; i < arr.length; i++) {
     System.out.print(arr[i] + " ");
}
```

```
// 출력
1 5 26 38 59 74
```

<br>

- asList : 배열을 ArrayList로 변환

```java
Integer[] arr = {5, 26, 1, 74, 59, 38};
ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

for (int i : list) {
     System.out.print(i + " ");
}
```

```java
// 출력
5 26 1 74 59 38
```

<br>

### #Collection

컬렉션 계층 구조의 루트 인터페이스로, 하위 인터페이스에는 List, Map, Set 등 다양한 컬렉션들이 존재한다. Collection에 포함된 메소드는 하위 인터페이스에서도 사용이 가능하다.

```java
size() // 컬렉션의 크기 반환
equals(Object o) // 컬렉션 비교
isEmpty() // 컬렉션이 비어있는지 확인
contains(Object o) // 해당 값이 컬렉션에 있는지 확인
clear() // 컬렉션에 있는 모든 요소 제거
remove(Object o) // 컬렉션 내에서 해당 객체 삭제
removeIf(Predicate<? super E> filter) // 해당 조건에 만족하는 객체 삭제
addAll(Collection<? extends E> c) // 지정된 컬렉션의 모든 요소를 컬렉션에 추가
containsAll(Collection<?> c) // 컬렉션에 지정된 컬렉션의 모든 요소가 포함되어 있는지 여부를 반환
removeAll(Collection<?> c) // 지정된 컬렉션에 공통으로 포함된 컬렉션의 모든 요소를 제거
retainAll(Collection<?> c) // 지정된 컬렉션에 공통으로 포함된 컬렉션의 요소만 유지
```

<br>

### #Collections

- sort : 오름차순으로 정렬

```java
Integer[] arr = {5, 26, 1, 74, 59, 38};
ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

Collections.sort(list);
        
for (int i : list) {
    System.out.print(i + " ");
}
```

```java
// 출력
1 5 26 38 59 74
```

<br>

- max / min : 컬렉션 내의 최댓값 / 최솟값 반환

```java
System.out.println(Collections.max(list));
System.out.println(Collections.min(list));
```

```java
// 출력
74
1
```

<br>

### #List

- add : 리스트 끝에 원소 추가

```java
// List 인터페이스를 구현한 ArrayList를 사용
ArrayList<String> list = new ArrayList<String>();

list.add("one");
list.add("two");
list.add("three");
      
for (String str : list) {
			System.out.print(str + " ");
}
```

```java
// 출력
one two three
```

<br>

- get :  특정 인덱스 값 조회

```java
System.out.println(list.get(2));
```

```java
// 출력
three
```

<br>

- remove : 특정 값 삭제

  ✅ remove(int index) : 인덱스에 위치하는 값 삭제

  ✅ remove(Object o) : 특정 객체 삭제

```java
// 같은 일을 하는 코드 -> 아래의 코드 중 하나만 실행해야 함
list.remove("three");
list.remove(2);
```

```java
// 출력
one two
```

<br>

- contains : 특정 원소가 리스트 내에 있는지 판별

```java
System.out.println(list.contains("one"));
System.out.println(list.contains("three"));
```

```java
// 출력
true
false
```

<br>

- size : 리스트 크기 반환

```java
System.out.println(list.size());
```

```java
// 출력
2
```

<br>

### #Map

- put : Map에 key와 value 값 삽입

```java
// Map 인터페이스를 구현한 HashMap 사용
HashMap<Integer, String> map = new HashMap<Integer, String>(); 

map.put(1, "one");
map.put(2, "two");
map.put(3, "three");
```

<br>

- get : key와 매핑된 value 반환. 만약, key 값이 없을 땐 null을 반환

```java
System.out.println(map.get(1));
System.out.println(map.get(5));
```

```java
// 출력
one
null
```

<br>

- containsKey :  특정 key가 map에 있는지 판별

```java
System.out.println(map.containsKey(1));
System.out.println(map.containsKey(5));
```

```java
// 출력
true
false
```

<br>

- containsValue : 특정 value가 map에 있는지 판별

```java
System.out.println(map.containsValue("one"));
System.out.println(map.containsValue("five"));
```

```java
// 출력
true
false
```

<br>

- remove : 특정 key에 해당하는 값을 삭제

```java
map.remove(1);

// map의 값 출력
for(int key : map.keySet()){
    String value = map.get(key);
    System.out.println(key + " : " + value);
}
```

```java
// 출력
2 : two
3 : three
```

<br>

### #Set

- add : Set에 요소 추가

```java
// Set 인터페이스를 구현한 HashSet 사용
HashSet<String> set = new HashSet<String>();

set.add("one");
set.add("two");
set.add("three");
set.add("two");

Iterator<String> iter = set.iterator();
while(iter.hasNext()) {
			System.out.println(iter.next());
}
```

```java
// 출력
one
two
three
```

<br>

- containsAll : 한 Set에 있는 원소들이 다른 Set에 전부 포함되는지 확인. 즉, 부분집합인지 판별.

```java
// setA : 2, 5, 9, 12
// setB : 3, 6, 9, 12
System.out.println(setA.containsAll(setB));
```

```java
// 출력
false
```

<br>

- addAll : 한 Set에 있는 원소들과 다른 Set 원소들을 합침. 즉, 합집합을 의미함.

```java
// setA : 2, 5, 9, 12
// setB : 3, 6, 9, 12

setA.addAll(setB);
System.out.println(setA.toString());
```

```java
// 출력
[12, 2, 3, 5, 6, 9]
```

<br>

- removeAll : 다른 Set에 포함된 공통적인 원소를 제거. 즉, 차집합을 의미함.

```java
// setA : 2, 5, 9, 12
// setB : 3, 6, 9, 12

setA.removeAll(setB);
System.out.println(setA.toString());
```

```java
// 출력
[2, 5]
```

<br>

- retainAll : 다른 Set에 포함된 공통적인 원소들만 포함. 즉, 교집합을 의미함.

```java
// setA : 2, 5, 9, 12
// setB : 3, 6, 9, 12

setA.retainAll(setB);
System.out.println(setA.toString());
```

```java
// 출력
[12, 9]
```

<br>

### #Stack

- push : 스택의 top에 값을 삽입

```java
Stack<String> stack = new Stack<String>();

stack.push("one");
stack.push("two");
stack.push("three");

System.out.println(stack.toString());
```

```java
// 출력
[one, two, three]
```

<br>

- pop : 스택의 top 값을 반환한 뒤에 삭제

```java
System.out.println(stack.pop());
System.out.println(stack.toString());
```

```java
// 출력
three
[one, two]
```

<br>

- peek : 스택의 top 값 조회

```java
// 현재 스택 값 : [one, two]
System.out.println(stack.peek());
System.out.println(stack.toString());
```

```java
// 출력
two
[one, two]
```

<br>

### #Queue

- offer : 큐의 뒤에 데이터를 삽입. add도 같은 역할을 하지만, 큐의 크기가 꽉 찼을 경우에 add는 예외를 발생시키지만 offer는 false를 반환.

```java
Queue<String> queue = new LinkedList<String>();

queue.offer("one");
queue.offer("two");
queue.offer("three");

System.out.println(queue.toString());
```

```java
// 출력
[one, two, three]
```

<br>

- poll : 큐의 맨 앞에 위치한 값을 반환한 뒤에 삭제

```java
System.out.println(queue.poll());
System.out.println(queue.toString());
```

```java
// 출력
one
[two, three]
```

<br>

- peek : 큐의 맨 앞에 위치한 값을 반환

```java
System.out.println(queue.peek());
System.out.println(queue.toString());
```

```java
// 출력
two
[two, three]
```

<br>

### #Math

- max : 두 인자 중 더 큰 값을 반환

```java
System.out.println(Math.max(15, 24));
```

```java
// 출력
24
```

<br>

- min : 두 인자 중 더 작은 값을 반환

```java
System.out.println(Math.min(15, 24));
```

```java
// 출력
15
```

<br>

- abs : 절댓값을 반환

```java
System.out.println(Math.abs(15));
System.out.println(Math.abs(-8));
```

```java
// 출력
15
8
```

<br>

- pow : 제곱 값을 반환. 앞의 인자는 밑, 뒤의 인자는 지수를 뜻함.

```java
System.out.println(Math.pow(5, 2));
System.out.println(Math.pow(5, 3));
```

```java
// 출력
25.0
125.0
```

<br>

- sqrt : 제곱근 반환

```java
System.out.println(Math.sqrt(25));
System.out.println(Math.sqrt(16));
```

```java
// 출력
5.0
4.0
```

<br>

### #자료형

- parseInt : String을 int로 타입 변환. 단, 변환할 문자열이 숫자로 이루어져 있어야 한다. 또한 진수법 변환에도 사용된다.

```java
String str = "55";
System.out.println(str.getClass().getName());

int num = Integer.parseInt(str);
// 연산은 숫자형 타입만 가능
System.out.println("연산결과 = " + num + 5);

// 2진수를 10진수로 변환
System.out.println(Integer.parseInt("1010", 2));
```

```java
// 출력
java.lang.String
연산결과 = 60
10
```

<br>

- valueOf : String을 Integer 객체로 반환. 단, 변환할 문자열이 숫자로 이루어져 있어야 한다. 또는 int 타입을 Integer로 변환할 때도 사용한다.

```java
String str = "55";
System.out.println(Integer.valueOf(str));

int num = 90;
System.out.println(Integer.valueOf(num).getClass().getName());
```

```java
// 출력
55
java.lang.Integer
```

<br>

### #문자열

- startsWith : 문자열이 특정 문자로 시작되는지 판별

```java
String str = "Hello World";
System.out.println(str.startsWith("H"));
System.out.println(str.startsWith("h"));
```

```java
// 출력
true
false
```

<br>

- endswith : 문자열이 특정 문자로 끝나는지 판별

```java
String str = "Hello World";
System.out.println(str.endsWith("d"));
System.out.println(str.endsWith("D"));
```

```java
// 출력
true
false
```

<br>

- equals : String 문자열 값 비교

```java
String str = "apple";
System.out.println(str.equals("apple"));
System.out.println(str.equals("banana"));
```

```java
// 출력
true
false
```

<br>

- indexOf : 특정 문자가 대상 문자열의 몇 번째 인덱스에 위치하는지 반환

```java
String str = "apple";
System.out.println(str.indexOf("a"));
System.out.println(str.indexOf("p"));
```

```java
// 출력
0
1
```

<br>

- substring : 지정한 범위에 속하는 문자열 반환

```java
String str = "Hello World";
System.out.println(str.substring(0, 5));
System.out.println(str.substring(4));
```

```java
// 출력
Hello
o World
```

<br>

- replace : 특정 문자열을 새로운 문자열로 치환

```java
String str = "Hello World";
System.out.println(str.replace("Hello", "hello~"));
```

```java
// 출력
hello~ World
```

<br>

- toLowerCase : 문자열을 소문자로 변환

```java
String str = "HELLO WORLD";
System.out.println(str.toLowerCase());
```

```java
// 출력
hello world
```

<br>

- toUpperCase : 문자열을 대문자로 변환

```java
String str = "hello world";
System.out.println(str.toUpperCase());
```

```java
// 출력
HELLO WORLD
```

<br>

- trim : 문자열 앞뒤의 공백 제거. 단, 문자열 내부의 공백은 replace를 사용해야 함.

```java
String str = "         hello world       ";
System.out.println(str.trim());
```

```java
// 출력
hello world
```

<br>

- charAt : 문자열 특정 위치에 있는 문자 반환

```java
String str = "hello world";
System.out.println(str.charAt(4));
System.out.println(str.charAt(8));
```

```java
// 출력
o
r
```

<br>

- valueOf : 지정된 값을 String으로 변환

```java
System.out.println(String.valueOf(5.0)); // double
System.out.println(String.valueOf('A')); // char
```

```java
// 출력
5.0
A
```

<br>

- contains : 특정 문자열이 포함되어있는지 확인

```java
String str = "Hello World";

System.out.println(str.contains("Hello"));
System.out.println(str.contains("Hi"));
```

```java
// 출력
true
false
```

<br>

- split : 문자열을 특정 문자열을 기준으로 나눈 후, 배열을 반환

```java
String str = "Hello:World";
String[] split = str.split(":");

System.out.println(split[0]);
System.out.println(split[1]);
```

```java
// 출력
Hello
World
```

