package domain;

public class Pet implements Identifiable<Integer>
{
    private Integer ID;
    private String name;
    private int age;
    private String type;
    private String breed;

    public Pet()
    {
        ID = 0;
        name = "";
        age = 0;
        type = "";
        breed = "";
    }

    public Pet(Integer ID, String name, int age,String type, String breed)
    {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.type = type;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getID()
    {
        return ID;
    }


    public void setID(Integer ID)
    {
        this.ID = ID;
    }



    public String toString()
    {
        return this.ID + "," + this.name + "," + this.age + "," + this.type + ","+ this.breed;

    }

    public int compareTo(Pet p)
    {
        if(this.age < p.age)
            return -1;
        if(this.age == p.age)
            return 0;

        return 1;
    }
}
