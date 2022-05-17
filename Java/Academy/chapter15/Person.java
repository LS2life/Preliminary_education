package chapter15;

//Value Object VOŬ����
//Data trasper Object DTOŬ����
public class Person extends Object {

    private String name;
    private int salary;

    public static void main(String[] args) {
        Person[] persons = new Person[100];
        Person person = new Person();
        person.setName("���ڹ�");
        person.setSalary(2800);
        persons[0] = person;
        System.out.println(persons[0].toString());

        for (int i = 0; i < persons.length; i++) {
            Person person1 = new Person();
            person1.setName("���ڹ�" + i);
            person1.setSalary(2800 + i);
            persons[i] = person1;
        }
        int salaryMean = 0;
        for (int i = 0; i < persons.length; i++) {
            salaryMean += persons[i].getSalary();
        }
        salaryMean = salaryMean / persons.length;
        System.out.println("�������:" + salaryMean);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Person [name=" + name + ", salary=" + salary + "]";
    }
}


















