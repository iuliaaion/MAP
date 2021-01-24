package main.repository;

import main.domain.Appointment;

public class AppointmentRepo extends InMemoryRepo<Integer, Appointment>
{
    public AppointmentRepo()
    {
        loadApppointments();
    }

    public Appointment save(Appointment a)
    {
        a.setId(IDgenerator.getNextId());
        super.save(a);
        return a;
    }

    private void loadApppointments()
    {
        save(new Appointment("15/12/2020","12 am",2,"confirmed","caries"));

        save(new Appointment("12/12/2020","10 am",1,"pending","scaling"));
        save(new Appointment("18/12/2020","5 pm",4,"canceled","braces"));
        save(new Appointment("15/12/2020","3 pm",4,"confirmed","scaling"));
        save(new Appointment("20/12/2020","2 pm",3,"canceled","caries"));
    }
}
