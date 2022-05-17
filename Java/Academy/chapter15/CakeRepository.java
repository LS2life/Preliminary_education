package chapter15;

public class CakeRepository {

    private int count = 10;
    private int stored = 0;
    private Cake[] cakeArr = new Cake[count];

    public static void main(String[] args) {
        CakeRepository cakeRepository = new CakeRepository();
//		Cake cake=new Cake();
//		cakeRepository.storeCake(cake);
        cakeRepository.storeCake(new Cake());
        cakeRepository.storeCake(new CheeseCake());
        cakeRepository.storeCake(new BananaCake());
        cakeRepository.storeCake(new MangoCake());
        CheeseCake cheeseCake = new CheeseCake();
        Person person = new Person();
        System.out.println(cheeseCake instanceof Cake);
//		System.out.println(person instanceof Cake);
        if (cheeseCake instanceof Cake) {
            System.out.println("cheeseCake is subclass of Cake");
        }
    }

    public void storeCake(Cake cake) {
        cakeArr[stored++] = cake;
    }

}



















