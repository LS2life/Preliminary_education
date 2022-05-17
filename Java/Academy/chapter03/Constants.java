package chapter03;

//��Ŭ���� â ����
//Window>Show View
//â ���̾ƿ� �ʱ�ȭ
//Window>Perspective>Reset
public class Constants {
    //main ctrl+spacebar�ڵ��ϼ�
    //�����̵�:alt+ȭ��ǥ
    public static void main(String[] args) {
        //����
        int num1 = 10;
        int num2 = 50;
        System.out.println("1: " + num1);
        num1 = 15;
        System.out.println("2: " + num1);
        num1 = 20;
        System.out.println("3: " + num1);
        //0-�Ϲ����� 1-������
        int auth = 0;
        auth = 1;
        System.out.println(auth);
        //���
        final int MAX_SIZE = 100;
        //maxSize=150;
        System.out.println(MAX_SIZE);
        //���ͷ�
        int num3 = 10;
        //���� ���ͷ�->int
        //int +-21��
        //int>long
        System.out.println(3147483647l);
        System.out.println(3147483647L);
        //�Ǽ� double
        System.out.println(3.14d);
        System.out.println(3.14D);
        System.out.println(3.14f);
        System.out.println(3.14F);
        //���� ����
        //1,000/ 1,000,000
        int num4 = 1_000_000;

    }
}
