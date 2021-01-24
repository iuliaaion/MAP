package Repository;

import Domain.Appointment;

import java.io.*;
import java.util.Map;


public class SerializationAppointmentRepo extends AbstractRepo<Integer, Appointment>
{
    private String filename;

    public SerializationAppointmentRepo(String filename)
    {
        this.filename = filename;
        readFromFile();
    }

    private void readFromFile()
    {
        try(ObjectInputStream o = new ObjectInputStream(new FileInputStream(this.filename)))
        {
            this.map = (Map<Integer, Appointment>) o.readObject();
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
    public void add(Appointment appointment)
    {
        try
        {
            super.add(appointment);
            writeToFile();
        }
        catch (RuntimeException e)
        {
            throw new ExceptionRepository(e);
        }
    }

    @Override
    public void delete(Appointment appointment)
    {
        try
        {
            super.delete(appointment);
            writeToFile();
        }
        catch (RuntimeException e)
        {
            throw new ExceptionRepository(e);
        }
    }

    @Override
    public void update(Appointment appointment, Integer id)
    {
        try
        {
            super.update(appointment, id);
            writeToFile();
        }
        catch (RuntimeException e)
        {
            throw new ExceptionRepository(e);
        }
    }


}
