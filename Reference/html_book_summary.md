># HTML5

- ## Doc string 선언
  - Doc = Documentation
  - W3c HTML5 명세 근거로 HTML 타입의 웹문서 최상단에 반드시 독스트링 표기 합니다.
  - 버전별로 독스트링의 선언방법이 상이. 
   
  ```html
  <!DOCTYPE html>
  ```
<br>

- ### 기본구조

  - <태그 속성 = "속성값">
  - 하기(下記)는  html태그 내부의 lang(Language)속성을 ko(korea)로 하겠다는 선언입니다.
  ```html
  <!DOCTYPE html>
  <html lang="ko">
  </html>
  ```  
<br>

>## head(헤드) 태그(Tag)
 
- 웹을 움직이는 머리입니다.
- 사용자가 신경쓰지 않아도 되는, 개발자만 신경쓰면 되는 부분 입니다.

  ```html
  <!DOCTYPE html>
  <html lang="ko">
    <head>
    </head>
  </html>
  ```  

- ### 메타(meta) Tag 

  - 웹페이지(webpage)의 추가정보를 전달합니다.
 
  ```html
  <!DOCTYPE html>
  <html lang="ko">
    <head>
      <meta charset="UTF-8" /> 
      <meta name="viewport" 
            content="width=device-width, initial-scale=1.0" />
    </head>
  </html>
  ```  
<br>

- ### 링크(link) tag, 릴(rel) 속성

  - link : Webpage의 추가정보르 전달.
  - rel = Relationship, 현재 문서와 링크된 문서의 연관관계를 명시합니다.
   
  ```html
  <!DOCTYPE html>
  <html lang="ko">
    <head>
      <meta charset="UTF-8" />
      <meta name="viewport" 
            content="width=device-width, initial-scale=1.0" />
      <link rel="icon" href="ironicon.ico" />
    </head>
  </html>
  ```  
<br>

- ### 타이틀(title) tag

  - Webpage에 들어가는 제목.

  ```html
  <!DOCTYPE html>
  <html lang="ko">
    <head>
      <meta charset="UTF-8" />
      <meta name="viewport" 
            content="width=device-width, initial-scale=1.0" />
      <link rel="icon" href="ironicon.ico" />
      <title>Svelte?  Vite?  App?? </title>
    </head>
  </html>
  ```  
<br>

- ### 스크립트(script) tag

  - 스크립트를 번역하면 '영화나 방송의 대본' 정도입니다. 
  - #### src 속성(attribute)
    - src = source
  
  ```html
  <!DOCTYPE html>
  <html lang="ko">
    <head>
      <meta charset="UTF-8" />
      <meta name="viewport"
            content="width=device-width, initial-scale=1.0" />
      <link rel="icon" href="ironicon.ico" />
      <title>Svelte?  Vite?  App?? </title>
      <script src="#" ></script >
  </head>
  </html>
  ```  
<br>

- ### 스타일(style) tag

  - Webpage에 스타일시트를 추가합니다.
  ```html
  <!DOCTYPE html>
  <html lang="ko">
    <head>
      <meta charset="UTF-8" />
      <meta name="viewport"
            content="width=device-width, initial-scale=1.0" />
      <link rel="icon" href="ironicon.ico" />
      <title>Svelte?  Vite?  App?? </title>
      <script src="#" ></script >
      <style></style>
    </head>
  </html>
  ```  
<br>

- ### 베이스(base) tag

  - Webpage의 기본경로를 지정합니다.
  ```html
  <!DOCTYPE html>
  <html lang="ko">
    <head>
      <meta charset="UTF-8" />
      <meta name="viewport"
            content="width=device-width, initial-scale=1.0" />
      <link rel="icon" href="ironicon.ico" />
      <title>Svelte?  Vite?  App?? </title>
      <script src="#" ></script >
      <style></style>
      <base href="#">
    </head>
  </html>
  ```  
<br>

>## body(바디) tag 
- 사용자가 보는 Webpage 입니다. 
  ```html
  <!DOCTYPE html>
  <html lang="ko">
    <head>
      <meta charset="UTF-8" />
      <meta name="viewport"
            content="width=device-width, initial-scale=1.0" />
      <link rel="icon" href="ironicon.ico" />
      <title>Svelte?  Vite?  App?? </title>
      <script src="#" ></script >
      <style></style>
      <base href="#">
    </head>
    <body>
   
    </body>
  </html>
  ```  
<br>

- ### :memo: 이하 구문에서는 해당 tag만 간략히 작성합니다.
 
- ### H1~6 
 
  - 제목글자(Header) tag
  ```html
  <h1>h1~6 제목글자 tag</h1> 
  ```  
  -  글자형태 tag
  ```html
  <h1>h1~6 제목글자 tag</h1> 
  <h2><b>굵은글자 태그</b></h2>
  <h2><i>이텔릭 태그</i></h2>
  <h2><small>작은글자 태그</small></h2>
  <h2><sup>윗첨자 태그</sup></h2>
  <h2><sub>아래첨자 태그</sub></h2>
  <h2><ins>밑줄 글자 태그</ins></h2>
  <h2><del>취소선</del></h2> 
  ```  
<br>

- ### 줄바꿈 tag
  ```html
  <br>
  ```

- ### 수평줄 tag
  ```html
  <hr>
  ```
<br>

- ### p tag
  - p = paragraph 
  - 본문글자 tag, 하나의 단락을 만들 수 있습니다. 
  ```html
  <p>본문 단락 생성</p>
  ```
  
- ### a tag
  - a = anchor
  - Webpage 내부에서 특정 위치로 이동할 때 사용합니다.
   
  - ### href 속성(attribute)
   
  - href = hypertext reference(하이퍼텍스트 참조), 빈 링크는 #을 입력합니다.
  ```html
  <a href="https://www.naver.com"></a>
  <a href="#"></a>
  ```
<br>

- ### id 속성(identifier attribute)
  - id 이름을 href에 넣으면 href 클릭시 id쪽으로 이동.
  - 속성이 중복되면 먼저 나오는 쪽으로 이동.
  - 고유식별자용도로 사용. 중복금지.
  ```html
  <a herf = "#GoGoGo" ></a >
  ```

- <center>&downarrow;</center>

  ```html
  <h1 id = "#GoGoGo" ></h1 >
  ```
<br>  
 
- ### 목록 tag  
  ```html
  <ul>순서가 없는 목록 태그
      <li>
          Unordered List
          목록 요소
      </li>
  </ul>

  <ol>순서가 있는 목록 태그
      <il>
          Ordered List
          목록 요소
      </il>
  </ol> 
  ```
<br>

- ### 정의 tag
 
  - 사전처럼 정의 목록을 사용함.
  ```html
  <dl>
      <dt>dl 태그</dt>
      <dd>defintion list의 약자, 용어를 설명하는 목록으로 만든다.</dd>
      <dt>dt</dt>
      <dd>defintion term의 약자, 용어의 제목을 넣을 때 사용.</dd>
      <dt>dd</dt>
      <dd>defintion description의 약자, 용어를 설명할 때 사용.</dd>
  </dl>
  ```
<br>

- ### 테이블 tag

  - border ettribute : 표 테두리의 두께.
   
  ```html
  <table border="1">
  ```
  <br>
  
  - tr tag: table row tag, 열.
  - th tag: table header tag, 행 내부의 제목 셀.
  - td tag: table data, 행내부의 일반셀.
    - rowspan: 셀의 높이 지정.
    - colspa : 셀의 너비 지정.

  - cation, colgroup, thead, tbody, tfoot 태그 등도 있다.
  
  ```html
  <tr>표 내부의 행, 가로줄
    <th>행 내부의 제목 셀</th>
    <th>행 내부의 제목 셀</th>
  </tr>
  <tr>
    <td>행 내부의 일반 셀</td>
    <td>행 내부의 일반 셀</td>
  </tr>
  ```
<br>

- ### img tag
 
  - src ettribute: 이미지 경로 지정.
  - alt ettribute: 이미지가 없을 때 나오는 글자 지정.
  - placehold.it page: 이미지 가로세로 크기는 알고 있지만 이미지가 없을 때
  ```html
  <img src="http://placehold.it/300x200" alt="" width="" height="" />
  ```

- ### audio tag
 
  - src ettribute 로 불러옴. 
  - mp3, ogg, wav 만 사용가능.
  ```html
  <audio src="#"></audio>
  ```

- ### vidio tag
 
  - src ettribute 로 경로지정.
  - mp4, WebM, OGV
  ```html
  <video src="#"></video>
  ```
<br>

- ### label tag
 
  - 해당 id ettribute 에 대해 input tag를 설명하는데 사용. 
  - for ettribute 가 설명하고 있는 id ettribute 를 써 주어야한다.
  ```html
  <label for="search">input tag를 성명하는데 사용</label>
  ```
<br>

- ### input(입력양식) tag

  - 주로 form tag 내부에서 사용.

  - ### method ettribute

    - 입력데이터의 전달방식을 선택한다.
    - get 요청(request)
      - 주소에 데이터를 입력해서 보내는 방식.
  ```html
  <from method="get">
    <input id="search" tyep="text" name="search">
    <input type="submit">
  </from>
  ```
    
  - ### action ettribute

    - 입력데이터의 전달위치를 지정.
    - post 요청(request)
      - get과 달리 비공개로 데이터를 전달하는 방식.
  ```html
  <form action="post">
    <input id="search" tyep="text" name="search">
    <input type="submit">
  </form>
  ```
    
  - ### type ettribute
  
    - 입력양식(input form)의 형태(form)를 지정.
    - button, checkbox, file, hidden, image, password, radio, reset, submit, 
    text, value, color, date, datetime, datetime-local, email, month, 
    number, range, search, tel, time, url, week 등
  ```html
  <input id="search" tyep="text" name="search">
  <input type="submit">
  ```
<br>

- ### textarea tag

  - 여러줄 글자를 입력할 때 사용.
    - cols: 너비 지정.
    - rows: 높이 지정.
    - id  : identifier(식별자)
    - name: form control 요소의 값(value)를 서버로 전송하기위한 속성.
  ```html
  <textarea name="reple" id="reple" cols="30" rows="10">Type here.</textarea>
  ```
<br>  

- ### select tag
- 
  - 선택 양식을 생성
  ```html
  <select multiple="multiple" name="#" id="#" >
              <optgroup label="IronMan">
                  <option>MK.1</option>
                  <option>MK.2</option>
                  <option>MK.3</option>
                  <option>MK.4</option>
                  <option>MK.5</option>
              </optgroup>
              <optgroup label="AI">
                  <option>Dum-E</option>
                  <option>U</option>
                  <option>자비스</option>
                  <option>프라이데이</option>
                  <option>베로니카</option>
                  <option>이디스</option>
              </optgroup>
          </select >
  ```