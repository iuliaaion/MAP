package Controller;

import Domain.Appointment;
import Domain.Patient;
import Repository.Repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller
{
    Repo repo;

    public Controller(Repo repo)
    {
        this.repo = repo;
    }

    //get all patients by name
    public List<String> getAllPatientsName()
    {
        Iterable<Patient> iterator = repo.findAll();
        List<Patient> list = new ArrayList<>();
        iterator.forEach(list::add);

        return list.stream().map(Patient::getName).distinct().collect(Collectors.toList());
    }

    //get all appointments by date
    public List<String> getAllAppointmentsByDate()
    {
        Iterable<Appointment> iterator = repo.findAll();
        List<Appointment> list = new ArrayList<>();
        iterator.forEach(list::add);

        return list.stream().map(Appointment::getDate).distinct().sorted().collect(Collectors.toList());
    }

    //patients that have a smaller age than the one given
    public List<Patient> getPatientByAge(int age)
    {
        Iterable<Patient> iterator = repo.findAll();
        List<Patient> list = new ArrayList<>();
        iterator.forEach(list::add);

        return list.stream().filter(s->s.getAge() < age).collect(Collectors.toList());
    }

    //appointments that have confirmed status
    public List<Appointment> getConfirmedAppointments()
    {
        Iterable<Appointment> iterator = repo.findAll();
        List<Appointment> list = new ArrayList<>();
        iterator.forEach(list::add);

        return list.stream().filter(s->s.getStatus().equals("confirmed")).collect(Collectors.toList());
    }

    //patients starting with a given letter
    public List<Patient> getPatientStartingWith()
    {
        Iterable<Patient> iterator = repo.findAll();
        List<Patient> list = new ArrayList<>();
        iterator.forEach(list::add);

        return list.stream().filter(s->s.getName().startsWith("M")).collect(Collectors.toList());
    }

}
