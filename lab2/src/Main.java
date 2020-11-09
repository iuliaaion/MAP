import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Pet> Pets = new ArrayList<>();
        Pets.add(new Pet(1,"Harry",5,"dog","Bichon"));
        Pets.add(new Pet(2,"Mia",3,"cat","Scottish Fold"));
        Pets.add(new Pet(3,"Sam",1,"rabbit","Lion Head"));
        Pets.add(new Pet(4,"Zoe",2,"dog","Huski"));

        //print pets
        for(Pet i:Pets)
        {
            System.out.println(i);
        }

        //youngest pet
        Pet p1 = Collections.min(Pets);
        System.out.println("\n Youngest pet:" + p1);

        //oldest pet
        Pet p2 = Collections.max(Pets);
        System.out.println("\n Oldest pet:" + p2 + "\n");

        //alphabetical order for names
        System.out.println("Sorted pets based on their names:");
        Collections.sort(Pets, new PetComparator());
        for(int x=0; x<Pets.size(); x++)
        {

            System.out.println(Pets.get(x));
        }

    }

    public static class PetComparator implements Comparator<Pet>
    {
        public int compare(Pet a,Pet b)
        {
            return a.getName().compareTo(b.getName());
        }
    }
}
