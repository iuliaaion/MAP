package Domain;

import java.io.Serializable;

public class Patient implements Identifiable<Integer> , Serializable
{
    private Integer ID;
    private String name;
    private int age;
    private String phoneNo;

    public Patient()
    {
        ID = 0;
        name = "";
        age = 0;
        phoneNo = "";
    }

    public Patient(Integer ID, String name, int age, String phoneNo)
    {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public String toString()
    {
        return this.ID + "," + this.name + "," + this.age + "," + this.phoneNo;
    }

    public int compareTo(Patient p)
    {
        if(this.age < p.age)
            return -1;
        if(this.age == p.age)
            return 0;

        return 1;
    }

}
