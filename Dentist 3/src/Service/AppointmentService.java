package Service;

import Domain.Appointment;
import Domain.Patient;
import Repository.AppointmentRepo;
import Repository.PatientRepo;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentService
{
    private AppointmentRepo aRepo;

    public AppointmentService(AppointmentRepo aRepo)
    {
        this.aRepo = aRepo;
    }

    public void add(Appointment a)
    {
        aRepo.add(a);
    }

    public void delete(Appointment a)
    {
        aRepo.delete(a);
    }

    public List<Appointment> getAll()
    {
        List<Appointment> appointmentList = new ArrayList<>();
        for (Appointment a :aRepo.findAll())
        {

            appointmentList.add(a);
        }
        return appointmentList;
    }

}
