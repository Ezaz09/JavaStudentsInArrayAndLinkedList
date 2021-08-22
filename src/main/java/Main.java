/*
1) Создать класс "студенты". Добавить штук 5 в ArrayList
2) у студентов поля age, name
3) Всем у кого имя больше 4 букв - увеличить возраст на 4 года

Потом. Тот же самый ArrayList или LinkedList —--> занеси туда студентов. Удали все несовершенолетних.
 */

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        ArrayList<Student> firstGroupOfStudents = new ArrayList<>();
        LinkedList<Student> secondGroupOfStudents = new LinkedList<>();

        // Заполняем группы студентами
        pushNewStudentsToListOfStudents(firstGroupOfStudents, faker);
        pushNewStudentsToListOfStudents(secondGroupOfStudents, faker);

        // Выводим список первой и второй групп студентов перед проверкой на возраст
        System.out.println("-------Список студентов первой и второй групп перед проверкой возраста-------");
        System.out.println(firstGroupOfStudents);
        System.out.println(secondGroupOfStudents);
        System.out.println("-----------------------------------------------------------------------------");

        // Проверяем возраст студентов, если возраст < 18 - удаляем
        removeStudentsFromListOfStudentsIfTheyAreMinor(firstGroupOfStudents);
        removeStudentsFromListOfStudentsIfTheyAreMinor(secondGroupOfStudents);

        // Выводим список первой и второй групп студентов
        System.out.println("-------Список студентов первой и второй групп после проверки возраста-------");
        System.out.println(firstGroupOfStudents);
        System.out.println(secondGroupOfStudents);
        System.out.println("-----------------------------------------------------------------------------");
    }

    public static void pushNewStudentsToListOfStudents(ArrayList<Student> students, Faker faker) {
        for (int i = 0; i < 5; i++) {
            students.add(new Student(getRandomName(faker), i < 1 ? i : getRandomNumberUsingInts(0, 28)));
        }
    }


    public static void pushNewStudentsToListOfStudents(LinkedList<Student> students, Faker faker) {
        for (int i = 0; i < 5; i++) {
            students.add(new Student(getRandomName(faker), i < 1 ? i : getRandomNumberUsingInts(0, 28)));
        }
    }

    public static void removeStudentsFromListOfStudentsIfTheyAreMinor(ArrayList<Student> students) {
        ArrayList<Student> listOfStudentsForRemoveFromGroup = new ArrayList<>();

        // Проверяем студентов на несовершеннолетие, если такие есть - помещаем в список на удаление
        for (Student student :
                students) {
            if (student.getAge() < 18) {
                listOfStudentsForRemoveFromGroup.add(student);
            }
        }

        // Проходимся по списку студентов на удаление - удаляем студентов из группы
        for (Student studentForRemove :
                listOfStudentsForRemoveFromGroup) {
            students.remove(studentForRemove);
        }
    }

    public static void removeStudentsFromListOfStudentsIfTheyAreMinor(LinkedList<Student> students) {
        LinkedList<Student> listOfStudentsForRemoveFromGroup = new LinkedList<>();

        // Проверяем студентов на несовершеннолетие, если такие есть - помещаем в список на удаление
        for (Student student :
                students) {
            if (student.getAge() < 18) {
                listOfStudentsForRemoveFromGroup.add(student);
            }
        }

        // Проходимся по списку студентов на удаление - удаляем студентов из группы
        for (Student studentForRemove :
                listOfStudentsForRemoveFromGroup) {
            students.remove(studentForRemove);
        }
    }

    public static String getRandomName(Faker faker) {
        return faker.name().fullName();
    }

    public static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
}
