import Controller.Controller;
import Domain.Appointment;
import Domain.Patient;
import Repository.AppointmentRepo;
import Repository.FilePatientRepo;
import Repository.PatientRepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Properties properties = new Properties();
            properties.load(new FileInputStream("Dentist.properties"));

            String requestFileName = properties.getProperty("PatientFile");

            if(requestFileName == null)
            {
                requestFileName="patients.txt";
                System.err.println("Requests file not found. Using default" + requestFileName);
            }

            FilePatientRepo filePatientRepo = new FilePatientRepo(requestFileName);

            System.out.println("Patients:");
            for(Patient p:filePatientRepo.findAll())
            {
                System.out.println(p);
            }
        }
        catch (IOException ex)
        {
            System.err.println("Error reading properties file" + ex);
        }
    }

    /*
    public static void test()
    {
        PatientRepo patient = new PatientRepo();
        AppointmentRepo appointment = new AppointmentRepo();

        Patient p1 = new Patient(1,"Sam",23,"0763789213");
        patient.add(p1);
        Patient p2 = new Patient(2,"Mia",17,"0763789213");
        patient.add(p2);
        Patient p3 = new Patient(3,"Lilly",45,"0723456989");
        patient.add(p3);
        Patient p4 = new Patient(4,"Iulia",21,"0764648434");
        patient.add(p4);
        Patient p5 = new Patient(5,"Inna",21,"0789654331");
        patient.add(p5);
        Patient p6 = new Patient(6,"Mary",36,"0799654321");
        patient.add(p6);

        Appointment a1 = new Appointment(1,"12/10/2020","10 am",2,"confirmed","caries");
        appointment.add(a1);
        Appointment a2 = new Appointment(2,"13/11/2020","6 pm",2,"canceled","scaling");
        appointment.add(a2);
        Appointment a3 = new Appointment(3,"13/11/2020","12 am",1,"confirmed","braces");
        appointment.add(a3);
        Appointment a4 = new Appointment(4,"15/11/2020","4 pm",3,"confirmed","caries");
        appointment.add(a4);
        Appointment a5 = new Appointment(5,"20/11/2020","2 pm",4,"pending","scaling");
        appointment.add(a5);
        Appointment a6 = new Appointment(6,"19/11/2020","8 am",5,"pending","caries");
        appointment.add(a6);
        Appointment a7 = new Appointment(7,"17/11/2020","4 pm",2,"confirmed","braces");
        appointment.add(a7);

        Controller aController = new Controller(appointment);
        Controller pController = new Controller(patient);

        System.out.println("Names of patients");
        pController.getAllPatientsName().forEach(System.out::println);

        System.out.println("\nDates for appointments");
        aController.getAllAppointmentsByDate().forEach(System.out::println);

        System.out.println("\nAll patients smaller than a given age");
        pController.getPatientByAge(30).forEach(System.out::println);

        System.out.println("\nAll appointments that are confirmed");
        aController.getConfirmedAppointments().forEach(System.out::println);

        System.out.println("\nAll patients starting with a given letter");
        pController.getPatientStartingWith().forEach(System.out::println);


    }

     */
}
