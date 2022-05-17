package chapter07;

public class BucketList {

    private String name;
    private String goal;
    private String season;

    public static void main(String[] args) {
        BucketList bucketList = new BucketList();
        bucketList.setName("John Doe");
        bucketList.setGoal("�ؿ� ���� - �߸�");
        bucketList.setSeason("���� �ް�");
        bucketList.printBucket();
        bucketList.cheerUp();

        BucketList bucketList2 = new BucketList();
        bucketList2.setName("Foo Bar");
        bucketList2.setGoal("���Ƹ� ���� - �౸");
        bucketList2.setSeason("���� ���� ��");
        bucketList2.printBucket();
        bucketList2.cheerUp();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void printBucket() {
        System.out.println("�̸�: " + name);
        System.out.println("��ǥ: " + goal);
        System.out.println("����: " + season);
    }

    public void cheerUp() {
        System.out.println("�� �̷���!!");
    }
}









