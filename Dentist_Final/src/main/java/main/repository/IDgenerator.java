package main.repository;

public class IDgenerator
{
    private static int idGen = 1;

    public static int getNextId()
    {
        return idGen++;
    }
}
