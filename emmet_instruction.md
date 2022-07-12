# Emmet?
	html문 사용자에게는 필수가 아닐까?
	미리 정해진 태그 이름이 없기 때문에 아무이름으로나 태그를 생성할 수 있다.

## 사용법

### 기본구조 생성!

-  html:5 을 입력후 tab 키를 입력하면 아래와 같이 html 기본 구문이생긴다.<br />
- :memo: 이하 구문에서 탭 키 입력은 [tab]\(으)로 표기 합니다. 

```html
    <!doctype html>
    <html lang="en" >
    <head >
      <meta charset="UTF-8" >
      <meta name="viewport" content="width=device-width, user-scalable=no,  
        initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" >
        <meta http-equiv="X-UA-Compatible" content="ie=edge" >
        <title >Document</title >
    </head >
    <body >

    </body >
    </html >
```

- hello world[tab]
```html
    <helloworld></helloworld>
```
<br />

### \> 오른쪽부등호(Greater than; 그레이터 댄)
- 자식요소를 생성할 수 있습니다.
```
    div>ul>li[tab]
```
```html
    <div>
        <ul>
            <li></li>
        </ul>
    </div>
```
<br />

### \+ 더하기(plus sign; 플러스 사인)
- 형제요소(같은 단계에 위치한 요소)를 생성할 수 있습니다.
```
    div+p+bq[tab]
```
```html
    <div></div>
    <p></p>
    <blockquote></blockquote>
```
<br />

### \^ 누승(circumflex; 서컴플랙스)
- 한 단계 위에 요소를 배치할 수 있습니다.<br />
- ^^^ 위로 이동하고 싶은 단계만큼 사용 가능합니다.<br />
```
    div+div>p>span+em^bq[tab]
```
```html
    <div></div>
    <div>
        <p>
            <span></span>
            <em></em>
        </p>
        <blockquote></blockquote>
    </div>
```
<br />

### \* 별표(asterisk) 에스터리스크
- 요소의 출력 횟수.
```
    ul>li*5[tab]
```
```html
    <ul>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
```
<br />

### \() 소괄호(left/right parenthesis; 퍼렌써시)
```
    div>(header>ul>li*2>a)+footer>p[tab]
```
```html
    <div>
        <header>
            <ul>
                <li><a href=""></a></li>
                <li><a href=""></a></li>
            </ul>
        </header>
        <footer>
            <p></p>
        </footer>
    </div>
```
<br />

### \#id  .class
- id 또는 class에 속성 입력
```
    div#header+div.page+div#footer.class1.class2.class3[tab]
```
```html
    <div id="header"></div>
    <div class="page"></div>
    <div id="footer" class="class1 class2 class3"></div>
```
<br />

### [attr] 표기법

