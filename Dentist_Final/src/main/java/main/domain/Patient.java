package main.domain;

public class Patient implements Identifiable<Integer>
{
    private int id;
    private String name;
    private int age;
    private String phoneNo;

    public Patient() { }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    public Patient(String name, int age, String phoneNo)
    {
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
    }

    public Patient(int id, String name, int age, String phoneNo)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
    }

    @Override
    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
