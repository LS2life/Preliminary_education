package chapter05;

public class BreakBasic {

    public static void main(String[] args) {
        // ó�� ������ 5�� ������� 7�� ����� ���� ã�� �ݺ���
        int num = 1;
        boolean search = false;
        while (num < 1000) {
            if ((num % 5 == 0) && (num % 7 == 0)) {
                search = true;
                break;
            }
            num++;
        }
        if (search) {
            System.out.println("ã�� ����: " + num);
        } else {
            System.out.println("���� ã�� ���߽��ϴ�");
        }
    }

}






