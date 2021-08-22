public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;

        if (name.length() > 4) {
            age += 4;
        }

        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        if(name.length() > 4) {
            this.setAge(this.getAge() + 4);
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
