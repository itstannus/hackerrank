package javabasic;


class Person {
    Person() {
        System.out.println("Person class Constructor");
    }
}

// subclass Student extending the Person class
class Student extends Person {
    Student() {
        // invoke or call parent class constructor
//        super(); implicit call to super

        System.out.println("Student class Constructor");
    }

    Student(int x) {
        // invoke or call parent class constructor
//        super(); implicit call to super
        this();
        System.out.println("Student class param Constructor");

    }
}

// Driver Program
class ConstructorExample {
    public static void main(String[] args) {
        Student s = new Student(5);
    }
}
