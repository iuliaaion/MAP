package Repository;

import Domain.Patient;

import java.io.*;

public class FilePatientRepo extends AbstractRepo<Integer, Patient>
{
    private String filename;

    public FilePatientRepo(String filename)
    {
        this.filename = filename;
        readFromFile();
    }

    private void readFromFile()
    {
        try(BufferedReader buffer = new BufferedReader(new FileReader(filename)))
        {
            String line = null;

            while((line = buffer.readLine()) != null)
            {
                String[] el = line.split(";");

                if(el.length != 4)
                {
                    System.out.println("Line is not valid!" + line);
                    continue;
                }

                try
                {
                    int id = Integer.parseInt(el[0]);
                    int age = Integer.parseInt(el[2]);
                    Patient patient = new Patient(id, el[1], age, el[3]);
                    super.add(patient);
                }
                catch (NumberFormatException noException)
                {
                    System.err.println("Invalid id format!" + el[0] + "Invalid age format" + el[2]);
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
            for(Patient patient : findAll())
            {
                String s = patient.getID() + ";" + patient.getName() + ";" +  patient.getAge() + ";" + patient.getPhoneNo();
                p.println(s);
            }
        }
        catch (FileNotFoundException e)
        {
            throw new ExceptionRepository("Error while writing in file" + e);
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
            throw new ExceptionRepository(e);
        }
    }

    @Override
    public void update(Patient patient, Integer id)
    {
        try
        {
            super.update(patient, id);
            writeToFile();
        }
        catch (RuntimeException e)
        {
            throw new ExceptionRepository(e);
        }
    }

}