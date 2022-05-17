package chapter10;

public class InstCnt {
    public static void main(String[] args) {
        System.out.println(ClassVar.instNum);
        Car car = new Car();
        car.myCar();
    }

}
