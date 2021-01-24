package main.service;

import main.domain.Appointment;
import main.repository.AppointmentRepo;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService
{
    private AppointmentRepo aRepo;

    public AppointmentService(AppointmentRepo aRepo)
    {
        this.aRepo = aRepo;
    }

    public Appointment adauga(Appointment a)
    {
        return aRepo.save(a);
    }

    public List<Appointment> getAll()
    {
        List<Appointment> la = new ArrayList<>();
        for(Appointment a:aRepo.findAll())
        {
            la.add(a);
        }

        return la;
    }
}
