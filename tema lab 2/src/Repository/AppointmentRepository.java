package Repository;
import Domain.Appointment;

import java.util.ArrayList;

public class AppointmentRepository implements Repository<Integer, Appointment> {
    private ArrayList<Appointment> appointments;

    public AppointmentRepository() {
        this.appointments = new ArrayList<>();
    }

    public AppointmentRepository(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public boolean appointmentExist(Integer id){
        for(Appointment appointment:this.appointments){
            if(appointment.getId().equals(id))
                return true;
        }
        return false;
    }

    @Override
    public void add(Appointment elem) throws Exception {
        if(this.appointmentExist(elem.getId()))
            throw new Exception("Appointment already exist!");
        else
            this.appointments.add(elem);
    }

    @Override
    public void delete(Appointment elem) throws Exception {
        if(!this.appointmentExist(elem.getId()))
            throw new Exception("Appointment doesn't exist!");
        else
            this.appointments.remove(elem);
    }

    @Override
    public void update(Appointment elem, Integer integer) throws Exception {
        if(!this.appointmentExist(elem.getId()))
            throw new Exception("Appointment doesn't exist!");
        else{
            Appointment appointment=this.findByID(integer);
            appointment=elem;
        }
    }

    @Override
    public Appointment findByID(Integer integer) throws Exception {
        for(Appointment appointment:this.appointments){
            if(appointment.getId().equals(integer))
                return appointment;
        }
        throw new Exception("Appointment doesn't exsit!");
    }

    @Override
    public Iterable<Appointment> findAll() {
        return this.appointments;
    }

    public ArrayList<Appointment> getClientReport(Integer patientId){
        ArrayList<Appointment> appointments=new ArrayList<>();
        for(Appointment appointment:this.appointments) {
            if (appointment.getPatientId().equals(patientId))
                appointments.add(appointment);
        }
        return  appointments;
    }

    public ArrayList<Appointment> getReportByDate(String date){
        ArrayList<Appointment> appointments=new ArrayList<>();
        for(Appointment appointment:this.appointments) {
            if (appointment.getDate().equals(date))
                appointments.add(appointment);
        }
        return  appointments;
    }
}
