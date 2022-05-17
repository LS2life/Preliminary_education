package chapter07;

import java.util.concurrent.TimeUnit;


public class Cafe {                                //���� ����
    public void main(String[] args) {
        int num3 = 0;
        int num4 = 0;
        int market = 0;
        int log = 0;

        Info serv = new Info();
        Amount coun = new Amount();
        LogMarket logM = new LogMarket();

        serv.num1();                //�޴� ���
        num3 = serv.num2();            //�޴� ���� num3 ����
        num4 = serv.count(num3);    //�������� ���� num4 ����
        coun.pay(num3, num4);        //����
        market = coun.cardCash();    //�������� �Է� market ����
        log = coun.hold(market);            //�������� �Է¿��� ��� ����


    }
}
//    �̿ϼ�

/* �޼ҵ� Method - ��� ü�輺 ü��
 *  main�� �޼ҵ� ����?   {} �߰�ȣ ���� ������� ���� ����ȴ�.
 *  �߰�ȣ ���°� �޼ҵ�
 */

