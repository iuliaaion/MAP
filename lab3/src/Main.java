import domain.Pet;
import repository.PetRepo;


public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Testing \n");
        PetRepo repo = new PetRepo();

        //testing add() and findAll() function
        repo.add(new Pet(1,"Harry",5,"dog","Bichon"));
        repo.add(new Pet(2,"Mia",3,"cat","Scottish Fold"));
        repo.add(new Pet(3,"Sam",1,"rabbit","Lion Head"));
        repo.add(new Pet(4,"Zoe",2,"dog","Huski"));

        System.out.println("Add pets");
        for(Pet i:repo.findAll())
        {
            System.out.println(i);
        }

        //testing delete() function
        repo.delete(new Pet(3,"Sam",1,"rabbit","Lion Head"));

        System.out.println("\n");
        System.out.println("Delete pet");
        for(Pet i:repo.findAll())
        {
            System.out.println(i);
        }

        //testing update() function
        repo.update(new Pet(4,"Zian",2,"dog","Huski"),4);
        System.out.println("\n");
        System.out.println("Update pet");
        for(Pet i:repo.findAll())
        {
            System.out.println(i);
        }

        //testing findByID() function
        System.out.println("\n");
        System.out.println("Find by ID");
        System.out.println(repo.findByID(2));



    }
}
