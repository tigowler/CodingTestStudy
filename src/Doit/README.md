## 📚『Do it! 알고리즘 코딩 테스트』문제 풀이
| 구분 | 문제 링크 | 코드 링크 | 복습 |
| -------- | -------- | -------- | -------- |
| 구간합 | [💡Q11660](https://www.acmicpc.net/problem/11660) | [🔗Link](https://github.com/tigowler/CodingTestStudy/blob/main/src/Doit/DataStructure_03/P11660.java) | 🔥 |
| 구간합 | [💡Q10986](https://www.acmicpc.net/problem/10986) | [🔗Link](https://github.com/tigowler/CodingTestStudy/blob/main/src/Doit/DataStructure_03/P10986.java) | 🔥 |
| 투포인터 | [💡Q2018](https://www.acmicpc.net/problem/2018) | [🔗Link](https://github.com/tigowler/CodingTestStudy/blob/main/src/Doit/DataStructure_03/P2018.java) |  |
| 투포인터 | [💡Q1940](https://www.acmicpc.net/problem/1940) | [🔗Link](https://github.com/tigowler/CodingTestStudy/blob/main/src/Doit/DataStructure_03/P1940.java) |  |
| 투포인터 | [💡Q1253](https://www.acmicpc.net/problem/1253) | [🔗Link](https://github.com/tigowler/CodingTestStudy/blob/main/src/Doit/DataStructure_03/P1253.java) | 🔥 |
| 슬라이딩 윈도우 | [💡Q12891](https://www.acmicpc.net/problem/12891) | [🔗Link](https://github.com/tigowler/CodingTestStudy/blob/main/src/Doit/DataStructure_03/P12891.java) | 🔥 |
| 슬라이딩 윈도우 | [💡Q11003](https://www.acmicpc.net/problem/11003) | [🔗Link](https://github.com/tigowler/CodingTestStudy/blob/main/src/Doit/DataStructure_03/P11003.java) | 🔥 |
| 스택 | [💡Q1874](https://www.acmicpc.net/problem/1874) | [🔗Link](https://github.com/tigowler/CodingTestStudy/blob/main/src/Doit/DataStructure_03/P1874.java) | 🔥 |
| 스택 | [💡Q17298](https://www.acmicpc.net/problem/17298) | [🔗Link](https://github.com/tigowler/CodingTestStudy/blob/main/src/Doit/DataStructure_03/P17298.java) | 🔥 |
| 큐 | [💡Q2164](https://www.acmicpc.net/problem/2164) | [🔗Link](https://github.com/tigowler/CodingTestStudy/blob/main/src/Doit/DataStructure_03/P2164.java) |  |
| 우선순위 큐 | [💡Q11286](https://www.acmicpc.net/problem/11286) | [🔗Link](https://github.com/tigowler/CodingTestStudy/blob/main/src/Doit/DataStructure_03/P11286.java) | 🔥 |
<br>

---
## 📌 Stack
```java
import java.util.Stack;

Stack<Integer> s = new Stack<>();
s.push(0);
s.pop();
s.peek();
```
<br>  

## 📌 Queue
```java
import java.util.Queue;

Queue<Integer> q = new LinkedList<>();
q.add(0); //rear에 새로운 데이터 삽입
q.poll(); //front 데이터 삭제 & 확인
q.peek(); //front 데이터 확인
```
<br>  

## 📌 Priority Queue
```java
import java.util.PriorityQueue;

PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 낮은 우선순위 순
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // 높은 우선순위 순

// 정렬 기준 정의 예시
PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
    int abs1 = Math.abs(o1);
    int abs2 = Math.abs(o2);
    if (abs1==abs2) return o1>o2 ? 1: -1;
    else return abs1-abs2;
});
```

