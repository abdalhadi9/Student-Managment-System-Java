import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager  {
    private ArrayList<Student> students;
    public StudentManager(){
        students=new ArrayList<>();
        loadFromFile();
    }
    public void sortStudentsByName(){
        students.sort(Comparator.comparing(Student::getName));
    }
    public void sortStudentsById(){
        students.sort(Comparator.comparingInt(Student::getId));
    }


    public int countStudents(){
        return   students.size();
    }

    public void loadFromFile() {

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("students.txt")
            );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String major = data[3];

                Student student = new Student(name, id, age, major);

                students.add(student);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("File not found or error reading file");
        }
    }
    public boolean addStudent(Student student) {

        if (findStudentById(student.getId()) != null) {
            return false;
        }

        students.add(student);
        saveToFile();
        return true;
    }

    private void saveToFile() {
        try {
            FileWriter writer = new FileWriter("students.txt");

            for (Student s : students) {

                writer.write(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getAge() + "," +
                                s.getMajor() + "\n"
                );

            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error while saving file");
        }

    }

    public void displayStudents(){
        for (Student s:students){
            System.out.println(s);
        }
        if (students.isEmpty()){
            System.out.println("No Student is available");
        }
    }
    public Student findStudentById(int id){

        for (Student s:students){
            if (s.getId()==id){
                return s;
            }

        }
        return null;
    }
    public Student updateStudent(int id, String newName, int newAge, String newMajor){
        Student s=findStudentById(id);
        if (s!=null){
            s.setName(newName);
            s.setAge(newAge);
            s.setMajor(newMajor);
            saveToFile();
            return s;
        }

        return null;
    }
    public Student deleteStudent(int id){
        Student s=findStudentById(id);
        if (s!=null){
            students.remove(s);
            saveToFile();
            return s;
        }
        return null;

    }

}

