package Repository;

import Domain.Patient;

import java.io.*;
import java.util.Map;

public class SerializationPatientRepo extends AbstractRepo<Integer, Patient>
{
    public String filename;

    public SerializationPatientRepo(String filename)
    {
        this.filename = filename;
        readFromFile();
    }

    private void readFromFile()
    {
        try(ObjectInputStream o = new ObjectInputStream(new FileInputStream(this.filename)))
        {
            this.map = (Map<Integer,Patient>) o.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            throw new ExceptionRepository(e);
        }
    }

    private void writeToFile()
    {
        try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(this.filename)))
        {
            o.writeObject(this.map);
        }
        catch (IOException e)
        {
            throw new ExceptionRepository(e);
        }
    }

    @Override
    public void add(Patient patient)
    {
        try
        {
            super.add(patient);
            writeToFile();
        }
        catch (RuntimeException e)
        {
            throw new ExceptionRepository(e);
        }
    }

    @Override
    public void delete(Patient patient)
    {
        try
        {
            super.delete(patient);
            writeToFile();
        }
        catch (RuntimeException e)
        {
            new ExceptionRepository(e);
        }
    }

    @Override
    public void update(Patient patient, Integer id)
    {
        try
        {
            super.update(patient,id);
            writeToFile();
        }
        catch (RuntimeException e)
        {
            throw new ExceptionRepository(e);
        }
    }
}