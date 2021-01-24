package Repository;

import Domain.Appointment;

import java.io.*;

public class FileAppointmentRepo extends AbstractRepo<Integer, Appointment>
{
    private String filename;

    public FileAppointmentRepo(String filename)
    {
        this.filename = filename;
        readFromFile();
    }

    private void readFromFile()
    {
        try(BufferedReader buffer = new BufferedReader(new FileReader(filename)))
        {
            String line = null;

            while ((line = buffer.readLine()) != null)
            {
                String[] el = line.split(";");

                if(el.length != 6)
                {
                    System.err.println("Line is not valid!" + line);
                    continue;
                }

                try
                {
                    int id = Integer.parseInt(el[0]);
                    int patientId = Integer.parseInt(el[3]);
                    Appointment appointment = new Appointment(id, el[1], el[2], patientId, el[4], el[5]);
                    super.add(appointment);
                }
                catch (NumberFormatException noException)
                {
                    System.err.println("Invalid id format!" + el[0] + "Invalid patiend id format!" + el[3]);
                }
            }
        }
        catch (IOException e)
        {
            throw new ExceptionRepository("Error while reading the file!" + e);
        }
    }

    private void writeToFile()
    {
        try(PrintWriter p = new PrintWriter(filename))
        {
            for(Appointment appointment : findAll())
            {
                String s = appointment.getID() + ";" + appointment.getDate() + ";" + appointment.getHour() + ";" + appointment.getPacientID() + ";" + appointment.getStatus() + ";" + appointment.getProblem();
                p.println(s);
            }
        }
        catch (IOException e)
        {
            throw new ExceptionRepository("Error while writing the file!" + e);
        }
    }

    @Override
    public void add(Appointment a)
    {
        try
        {
            super.add(a);
            writeToFile();
        }
        catch (RuntimeException e)
        {
            throw new ExceptionRepository(e);
        }
    }

    @Override
    public void delete(Appointment a)
    {
        try
        {
            super.delete(a);
            writeToFile();
        }
        catch (RuntimeException e)
        {
            throw new ExceptionRepository(e);
        }
    }

    @Override
    public void update(Appointment a, Integer id)
    {
        try
        {
            super.update(a,id);
            writeToFile();
        }
        catch (RuntimeException e)
        {
            throw new ExceptionRepository(e);
        }
    }
}