package modelA;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {

        /*
        1. Create a couple of students
        2. Create a queue
        3. Insert students in the queue
        4. View the queue
        5. Remove the last student inserted in the queue
        6. Visualize the new queue
        7. Copy the stack into a file
        */

        File f = new File("Test");
        GenericQueue<Person> g1 = new GenericQueue<>();
        Person p1 = new Student("Ivan", "Perez", 165465);
        Person p5 = new Student("Alex", "Perez", 45464);
        Person p2 = new Student("Jose", "Perez", 445686);
        Person p3 = new Student("Lucas", "Hernandez", 89996);
        Person p4 = new Student("Felipe", "Ruiz", 12345);


        g1.add(p1);
        g1.add(p2);
        g1.add(p3);
        g1.add(p4);
        g1.add(p5);


//        System.out.println(g1);
//        System.out.println();
//        System.out.println(g1.removeElementAtIndex(3));
//        System.out.println();
//        System.out.println(g1);
//        System.out.println();
//        System.out.println();

        g1.save(f);
        System.out.println(g1.load(f));
    }

}