import java.util.HashSet;
import java.util.Objects;

class Student implements Comparable<Student> {
    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if it's the same reference
        if (obj == null || getClass() != obj.getClass()) return false; // Ensure type compatibility
        Student student = (Student) obj;
        return Objects.equals(name, student.name); // Compare names for equality
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); // Generate hash code based on name
    }

    @Override
    public int compareTo(Student s) {
        return this.name.compareTo(s.name); // Compare names lexicographically
    }
}

public class Main {
    public static void main(String[] args) {
        HashSet<Student> studentSet = new HashSet<>();
        var s1 = new Student("sakshi", 10);
        var s2 = new Student("aditya", 15);
        var s3 = new Student("aditya", 20);
        var s4 = new Student("anju", 20);

        System.out.println(s2 == s3); // false, because they are different objects
        System.out.println(s2.equals(s3)); // true, because names are the same

        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3);
        studentSet.add(s4);

        // Print the set
        for (Student s : studentSet) {
            System.out.println("Name: " + s.name + ", RollNo: " + s.rollNo);
        }
    }
}
