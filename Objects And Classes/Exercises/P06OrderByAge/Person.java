package P23ObjectsAndClasses_Exercises.P06OrderByAge;

public class Person {
    private String name;
    private String iD;
    private int age;

    public Person(String name, String iD, int age) {
        this.name = name;
        this.iD = iD;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getiD() {
        return this.iD;
    }

    public int getAge() {
        return this.age;
    }

}
