package chapter07;

import java.util.Scanner;

public class LogMarket {
    class LogMarket {
        private String name;
        private String address;
        private char bloodType;
        private int phone;
        private int number;
        private int tall;
        private int heartBit;
        private int bloodPressure;
        private float vision;
        private int liverCount;
        private int otherMedicalHistory;
        private int amount;

        public LogMarket(String na, String add, char bT, int pho, int num, int tal, int hea, int bP, float vis, int lc, int omh, int amo) {
            name = na;
            address = add;
            bloodType = bT;
            phone = pho;
            number = num;
            tall = tal;
            heartBit = hea;
            bloodPressure = bP;
            vision = vis;
            liverCount = lc;
            otherMedicalHistory = omh;
            amount = amo;
        }

        public int personalInfomation() {
            System.out.println("���� : " + name);
            System.out.println("�ּ� : " + address);
            System.out.println("������ : " + bloodType);
            System.out.println("��ȭ��ȣ : " + phone);
            System.out.println("�ֹε�Ϲ�ȣ : " + number);
            System.out.println("���� : " + tall);
            System.out.println("��սɹڼ� : " + heartBit);
            System.out.println("���� : " + bloodPressure);
            System.out.println("�÷� : " + vision);
            System.out.println("����ġ : " + liverCount);
            System.out.println("��Ÿ���� : " + otherMedicalHistory);
            System.out.println("����ݾ� : " + amount + '\n');
            return amount;
        }

        public int deposit(int value) {
            amount += value;
            return amount;
        }

        public int withdraw(int value) {
            amount -= value;
            return amount;

        }

        public int memo(int value) {
            if (value == 5) {
                System.out.println("�������� �����ϼ̽��ϴ�.");
                System.out.println("������ �����ۼ��� �ְڽ��ϴ�.");
                Scanner scen = new Scanner(System.in);
                how = scen.nextInt();

            }
        }

    }
