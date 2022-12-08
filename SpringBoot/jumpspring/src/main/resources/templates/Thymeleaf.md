# 타임리프에 자주사용하는 속성

1. 분기문
    th:if="${question != null}"
    question 객체가 null이 아닌경우 해당 엘리먼트가 표시된다.
2. 반복문
    th:each="question:${questionList}"
    또는
    th:each="question,loop:${questionList}"

    추가한 loop 객체를 이용하여 루프 내에서 다음과 같은 속성을 사용할수 있다.

        loop.index - 반복 순서, 0부터 1씩 증가
        loop.count - 반복 순서, 1부터 1씩 증가
        loop.size - 반복 객체의 요소 갯수 (예: questionList의 요소 갯수)
        loop.first - 루프의 첫번째 순서인 경우 true
        loop.last - 루프의 마지막 순서인 경우 true
        loop.odd - 루프의 홀수번째 순서인 경우 true
        loop.even - 루프의 짝수번째 순서인 경우 true
        loop.current - 현재 대입된 객체 (예: 위의 경우 question과 동일)

3. 텍스트 속성
    해당 엘리먼트의 텍스트로 "값"을 출력한다.
    th:text="{question.subject}"

    텍스트는 th:text속성 대신에 다음처럼 대괄홀르 사용하여 값을 직접 출력할 수 있다.
    <tr th:each="$question : ${questionList}">
        <td>[[${question.subject}]]</td>
        <td>[[${question.createDate}]]</td>
    </tr>

# 링크주소

- 타임리프에서 링크의 주소는 th:href 속성을 사용한다. 
- 타임리프에서 th:href 처럼 URL 주소를 나타낼때는 반드시 @{ 문자와 } 문자 사이에 입력해야 한다.
- 그리고 URL 주소는 문자열 /question/detail/과 ${question.id} 값이 조합되어 /question/detail/${question.id}로 만들어졌다. 이때 좌우에 | 문자없이 다음과 같이 사용하면 오류가 발생한다.

```html
    <a th:href="@{/question/detail/${question.id}}" th:text="${question.subject}"></a>
```

- /question/detail/과 같은 문자열과 ${question.id}와 같은 자바 객체의 값을 더할 때는 반드시 다음처럼 |과 | 기호로 좌우를 감싸 주어야 한다.

```html
<a th:href="@{|/question/detail/${question.id}|}" th:text="${question.subject}"></a>
```