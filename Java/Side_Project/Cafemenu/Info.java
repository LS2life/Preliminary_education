package chapter07;

import java.util.Scanner;

public class Info {
    String iceA = "���̽� �Ƹ޸�ī��";   //�߿� ��������
    String hotA = "������ �Ƹ޸�ī��";
    String moca = "���� ��ī";
    String cafu = "īǪġ��";
    String green = "�׸�Ƽ";
    String hotCoco = "������ ���ھ�";
    String hotMil = "������ ����";
    String choice = "�� �����ϼ̽��ϴ�.";
    String oder = " ���� �ֹ��ϼ̽��ϴ�.";


    public void num1() {             //�ٹ� �޴�
        int count = 1;

        System.out.println("�������. �ΰ����� �ٹ� 602ȣ �Դϴ�.");
        System.out.println("�ֹ��Ͻðھ��?");
        System.out.println("      <�޴�>");
        System.out.println(count + ". " + iceA + "	3.0 ");
        System.out.println(++count + ". " + hotA + "	3.5 ");
        System.out.println(++count + ". " + moca + "	4.5 ");
        System.out.println(++count + ". " + cafu + "	4.5 ");
        System.out.println(++count + ". " + green + "		5.0 ");
        System.out.println(++count + ". " + hotCoco + "	5.0 ");
        System.out.println(++count + ". " + hotMil + "	3.5");
    }

    public int num2() {          //���� ����
        int menu = 0;

        System.out.print("�ֹ���ȣ : ");

        Scanner scen = new Scanner(System.in);
        menu = scen.nextInt();

        switch (menu) {
            case 1:
                System.out.println(iceA + choice);
                break;
            case 2:
                System.out.println(hotA + choice);
                break;
            case 3:
                System.out.println(moca + choice);
                break;
            case 4:
                System.out.println(cafu + choice);
                break;
            case 5:
                System.out.println(green + choice);
                break;
            case 6:
                System.out.println(hotCoco + choice);
                break;
            case 7:
                System.out.println(hotMil + choice);
                break;
            default:
                System.out.println("������ ����� �޴��� ������.");
                System.out.println("ȭ���� �޴��� ������ �ּ���.");
                break;   //�޴� �� ��ȣ �Է½� �ݺ���� �߰� �ʿ�.
        }

        return menu;
    }

    public int count(int serv) {     //���� ����
        int ea = 0;

        System.out.print("������ �Է����ּ��� : ");
        Scanner scen = new Scanner(System.in);
        ea = scen.nextInt();

        switch (serv) {
            case 1:
                System.out.println(iceA + "  " + ea + oder);
                break;
            case 2:
                System.out.println(hotA + "  " + ea + oder);
                break;
            case 3:
                System.out.println(moca + "  " + ea + oder);
                break;
            case 4:
                System.out.println(cafu + "  " + ea + oder);
                break;
            case 5:
                System.out.println(green + "  " + ea + oder);
                break;
            case 6:
                System.out.println(hotCoco + "  " + ea + oder);
                break;
            case 7:
                System.out.println(hotMil + "  " + ea + oder);
                break;
            default:
                break;
        }

        return ea;
    }
}
