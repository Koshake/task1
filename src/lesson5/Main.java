package lesson5;

public class Main {

    public static void main(String[] args) {
        Person[] personArr = new Person[5];

        personArr[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com",
                "892312312", 30000, 30);
        personArr[1] = new Person("Sergeev Sergei", "Engineer", "serg@mailbox.com",
                "892312312", 30000, 30);
        personArr[2] = new Person("Dmitriev Dmitri", "Engineer", "dd@mailbox.com",
                "892312312", 50000, 50);
        personArr[3] = new Person("Mihailov Mihail", "Engineer", "mmm@mailbox.com",
                "892312312", 60000, 41);
        personArr[4] = new Person("Andreev Andrei", "Engineer", "aa@mailbox.com",
                "892312312", 60000, 50);

        for (int i = 0; i < personArr.length; i++) {
            if (personArr[i].getAge() > 40) {
                personArr[i].info();
            }
        }
    }
}
