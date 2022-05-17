package chapter07;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Amount {
    int defVal = 0;    //�غ�
    int how = 0;

    public int cardCash() {                     //���� ���
        System.out.println("���� ����� �������ּ���.");
        System.out.println("1. ���� ����");
        System.out.println("2. ī�� ����");
        System.out.println("3. ���� ����");
        System.out.println("4. ��Ʈ���� ����");
        System.out.println("5. ��ü���Ⱒ��");
        System.out.println("6. ������, ������");

        System.out.print("���� ���� : ");
        Scanner scen = new Scanner(System.in);
        how = scen.nextInt();

        switch (how) {
            case 1:
                System.out.println("Cash�� ���� �ӽ�ũ! and I am Ironman. 3000�� �� ���..");
                break;
            case 2:
                System.out.println("3�� �Һ��ϸ� 3����� ���� ���� ���տ�! �ض��� ������ ī�� �� �� ����!");
                break;
            case 3:
                System.out.println("�⸧�����̼̱���!�ܻ� �ص����");
                break;
            case 4:
                System.out.println("�� �� ���� ��̾��? ��~ �� �𸣽ô±���~ �Ѱ��� �ֽø�ǿ�.");
                break;
            case 5:
                System.out.println("�ϴ� ������� �����ϽǰԿ�.");
                break;
            case 6:
                System.out.println("DMZ�� �Ȼ��~");
                break;
            default:
                break;
        }

        return how;
    }

    public void pay(int value, int value2) {    //�ֹ� ���� ����

        switch (value) {
            case 1:
                defVal = 3000 * value2;
                break;
            case 2:
                defVal = 3500 * value2;
                break;
            case 3:
                defVal = 4500 * value2;
                break;
            case 4:
                defVal = 4500 * value2;
                break;
            case 5:
                defVal = 5000 * value2;
                break;
            case 6:
                defVal = 5000 * value2;
                break;
            case 7:
                defVal = 3500 * value2;
                break;
            default:
                break;
        }

        System.out.println(defVal + "�� ���� ���͵帮�ڽ��ϴ�.");
    }

    public int hold(int value) {

        if (value <= 4) {
            try {
                System.out.println("���� ���Դϴ�. 5�ʸ� ��ٷ� �ּ���.");
                System.out.println("����.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("����.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("��ƾ���.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("������������.");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("���� �Ϸ�Ǿ����ϴ�.");
            } catch (InterruptedException e) {
                System.err.format("IOException: %s%n", e);
            }
        }

        return value;

    }
}
