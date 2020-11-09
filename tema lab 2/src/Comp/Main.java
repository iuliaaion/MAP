package Comp;

import Domain.Patient;
import Domain.Appointment;
import Repository.PatientRepository;
import Repository.AppointmentRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        AppointmentRepository appointmentRepository=new AppointmentRepository();
        PatientRepository patientRepository=new PatientRepository();
        Scanner scan = new Scanner(System.in);
        int index;
        index=1;
        while(index>0 && index<8){
            System.out.println("Menu");
            System.out.println("1-Add patient");
            System.out.println("2-Add appointment");
            System.out.println("3-Cancel appointment");
            System.out.println("4-Get report for a date");
            System.out.println("5-Show all appointments");
            System.out.println("6-Show all patients");
            System.out.println("7-Get report for a patient");
            System.out.println("0-Exit");
            System.out.println("Choose an option");
            index=Integer.parseInt(scan.nextLine());

            if(index==1){
                System.out.println("Input the id");
                Integer id=Integer.parseInt(scan.nextLine());
                System.out.println("Input the name");
                String name=scan.nextLine();
                System.out.println("Input the age");
                Integer age=Integer.parseInt(scan.nextLine());
                System.out.println("Input the phone number");
                String pn= scan.nextLine();
                System.out.println("Input the patient's problem");
                String problem=scan.nextLine();
                Patient patient=new Patient(id,name,age,pn,problem);
                try {
                    patientRepository.add(patient);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(index==2){
                System.out.println("Input the id");
                Integer id=Integer.parseInt(scan.nextLine());
                System.out.println("Input the date (Format dd/mm/yyyy)");
                String date=scan.nextLine();
                System.out.println("Input the patient id");
                boolean patientExist=false;
                Integer patientId=null;
                while(patientExist==false) {
                    patientId=Integer.parseInt(scan.nextLine());
                    patientExist=patientRepository.patientExist(patientId);
                    if(patientExist==false)
                        System.out.println("Patient doesn't exist.Pleas input other id!");
                }
                Appointment appointment=new Appointment(id,date,patientId);
                try{
                    appointmentRepository.add(appointment);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(index==3){
                System.out.println("Input the appointment id");
                Integer id=Integer.parseInt(scan.nextLine());
                try {
                    appointmentRepository.delete(appointmentRepository.findByID(id));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(index==4){
                System.out.println("Input the date (Format dd/mm/yyyy)");
                String date= scan.nextLine();
                for(Appointment appointment:appointmentRepository.getReportByDate(date))
                    System.out.println(appointment);
            }
            else if(index==5){
                for(Appointment appointment:appointmentRepository.findAll())
                    System.out.println(appointment);
            }
            else if(index==6){
                for(Patient patient:patientRepository.findAll())
                    System.out.println(patient);
            }
            else if(index==7){
                System.out.println("Input the patient id");
                Integer id=Integer.parseInt(scan.nextLine());
                for(Appointment appointment:appointmentRepository.getClientReport(id))
                    System.out.println(appointment);
            }
            else if(index==0)
                break;
        }
    }
}
