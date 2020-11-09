import java.util.Objects;

public class Pet implements Comparable<Pet>
{
    private int id;
    private String name;
    private int age;
    private String type;
    private String breed;

    //constructors
    public Pet(int id, String name, int age,String type, String breed)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
        this.breed = breed;
    }

    public Pet()
    {
        id = 0;
        name = "";
        age = 0;
        type = "";
        breed = "";
    }

    //getters
    public int getId() {
        return id;
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

    //setters
    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Pet)
        {
            Pet pet = (Pet) o;
            return id == pet.id &&
                    age == pet.age &&
                    Objects.equals(name, pet.name) &&
                    Objects.equals(type, pet.type) &&
                    Objects.equals(breed, pet.breed);
        }
        return false;
    }

    //toString
    @Override
    public String toString()
    {
        return this.id + "," + this.name + "," + this.age + "," + this.type + ","+ this.breed;

    }

    //compareTo method based on age
    public int compareTo(Pet p)
    {
        if(this.age < p.age)
            return -1;
        if(this.age == p.age)
            return 0;

        return 1;
    }

}
