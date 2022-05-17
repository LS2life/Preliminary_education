package chapter15;

public class YummyCakeOverriding {
    public static void main(String[] args) {
        //����Ŭ������ �����ν��Ͻ��� ���� �� ����
//		CheeseCake cake=new Cake();
        //���� Ŭ������ ���� �ν��Ͻ��� ���� �� �ִ�
        Cake cake1 = new Cake();
        Cake cake2 = new Cake();
        Cake cake3 = new Cake();
        Cake cheeseCake1 = new CheeseCake();
        Cake cheeseCake2 = new CheeseCake();
        Cake cheeseCake3 = new CheeseCake();
        Cake strawberryCheeseCake1 = new StrawberryCheeseCake();
        Cake strawberryCheeseCake2 = new StrawberryCheeseCake();
        Cake strawberryCheeseCake3 = new StrawberryCheeseCake();
        Cake[] cakeArr = new Cake[12];
        cakeArr[0] = cake1;
        cakeArr[1] = cake2;
        cakeArr[2] = cake3;
        cakeArr[3] = cheeseCake1;
        cakeArr[4] = cheeseCake2;
        cakeArr[5] = cheeseCake3;
        cakeArr[6] = strawberryCheeseCake1;
        cakeArr[7] = strawberryCheeseCake2;
        cakeArr[8] = strawberryCheeseCake3;
        cakeArr[9] = new BananaCake();
        cakeArr[10] = new BananaCake();
        cakeArr[11] = new BananaCake();
        //�޼ҵ� �������̵� - ������ - �ڵ��� ���� �پ��
        for (int i = 0; i < cakeArr.length; i++) {
            cakeArr[i].yummy();
        }
    }

}




