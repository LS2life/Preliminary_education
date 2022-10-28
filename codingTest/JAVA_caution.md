# 빽준 주의 JAVA

-   클래스명은 Main, package는 없어야 한다.

    ```java
    public class Main{

    }
    ```

<br />

-   Main 외 클래스는 inner 또는 public이 아닌 클래스 사용

-   Main 전역변수는 모두 static

-   Scanner sc = new Scanner(System.in); 느림.

    -   BufferedReader br = new bufferedReader(new InputStreamReader(System.in)); 으로 사용하자.

-   String은 split()보다 StringTokenizer로 작성하자.

```java
// Scanner로 작성
import java.util.Scanner;

public class Main {
    public static solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] dataArr = str.split(" ");
            int s = Integer.parseInt(dataArr[0]);

            for (int j = 1; j <= s; j++); {
                int data = Integer.parseInt(dataArr[j]);
                System.out.println(data);
            }
        }
    }

    public static void marn(String[] args) throws Exception {
        new Main().solution();
    }
}
```

```java
// BufferedReader로 작성.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fro (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            for (int j = 0; j < s; j++) {
                int data = Integer.parseInt(st.nextToken());
                System.out.println(data);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
```

-   System.out.println() 보다 BufferedWriter로 출력

```java
// BufferedReader로 작성. 다만 int를 바로 출력할 수 없다.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        fro (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            for (int j = 0; j < s; j++) {
                int data = Integer.parseInt(st.nextToken());
                bw.write(String.valueof(data));
                bw.newLine();
                // System.out.println(data);
            }
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
```
