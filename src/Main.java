import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager=new StudentManager();
        Scanner input=new Scanner(System.in);
        while (true){
            System.out.println("1-Add Student");
            System.out.println("2-Display Student");
            System.out.println("3-Update Student");
            System.out.println("4-Delete Student");
            System.out.println("5-Search Student");
            System.out.println("6-Count Student");
            System.out.println("7-Sort Students By ID");
            System.out.println("8-Sort Students By Name");
            System.out.println("9-Exit");
            int choice= input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter name Student");
                    String name= input.nextLine();

                    System.out.println("enter age");
                    int age=input.nextInt();
                    input.nextLine();

                    System.out.println("Enter id");
                    int id= input.nextInt();
                    input.nextLine();

                    System.out.println("Enter major");
                    String major=input.nextLine();

                    Student s = new Student(name, id, age, major);

                    if (manager.addStudent(s)) {
                        System.out.println("Student added successfully");
                    } else {
                        System.out.println("ID already exists");
                    }
                    break;
                case 2:
                    manager.displayStudents();
                    break;
                case 3:

                    System.out.println("Enter Id");
                    id = input.nextInt();
                    input.nextLine();
                    s = manager.findStudentById(id);
                    if (s==null){
                        System.out.println("Student not found");
                        break;

                    }
                    else {
                        System.out.println(s);
                    }


                    System.out.println("Enter  new name Student");
                    String newName= input.nextLine();
                    if (!newName.isEmpty()) {
                        s.setName(newName);
                    }

                    System.out.println("enter new age");
                    int newAge = s.getAge();
                    String ageInput = input.nextLine();
                    if (!ageInput.isEmpty()) {
                        newAge = Integer.parseInt(ageInput);
                        s.setAge(newAge);
                    }


                    System.out.println("Enter  new major");
                    String newMajor=input.nextLine();

                    if (!newMajor.isEmpty()){
                        s.setMajor(newMajor);
                    }

                    break;
                case 4:
                    System.out.println("Enter id");
                    id = input.nextInt();
                    input.nextLine();
                    manager.deleteStudent(id);
                    break;
                case 5:
                    System.out.println("Enter student id");
                    id = input.nextInt();
                    input.nextLine();
                    s = manager.findStudentById(id);
                    if (s!=null){
                        System.out.println(s);
                    }
                    else {
                        System.out.println("Student not found");
                    }
                    break;
                case 6:
                    System.out.println(manager.countStudents());
                case 7:
                    manager.sortStudentsById();
                    manager.displayStudents();
                case 8:
                    manager.sortStudentsByName();
                    manager.displayStudents();
                case 9:
                    return;
                default:

            }
        }
    }
}
