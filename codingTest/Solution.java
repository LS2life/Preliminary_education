import java.security.KeyStore.LoadStoreParameter;

public class Solution {

    // 특정 문자 제거하기
    public String solution(String my_string, String letter) {
        return my_string.replace(letter,""); 
    }

    // 문자 반복 출력하기
    public String solution(String my_string, int n) {
        String answer = my_string * n;
        return answer;
    }

    public void main(String[] args) {

        // String my_string = "abcdef";
        // String letter = "f";
        // solution(my_string, letter);


        // String my_string = "hello";
        // int letter = 3;
        // solution(my_string, n);

    }

}
