public class Student {
    private String name;
    private  int id;
    private int age;
    private String major;

    public Student(String name, int id, int age, String  major) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.major = major;
    }
    public String getName() {
        return name;}
    public int getId() {
        return id;}
    public int getAge() {
        return age;}
    public String getMajor() {
        return major;}

    public void setName(String name) {
        this.name = name;}
    public void setAge(int age) {
        this.age = age;}
    public void setMajor(String newMajor) {
        this.major = newMajor;}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }
}

