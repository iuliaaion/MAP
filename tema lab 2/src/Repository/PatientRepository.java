package Repository;
import Domain.Patient;

import java.util.ArrayList;

public class PatientRepository implements Repository<Integer, Patient> {
    private ArrayList<Patient> patients;

    public PatientRepository() {
        this.patients = new ArrayList<>();
    }

    public PatientRepository(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public boolean patientExist(Integer id){
        for(Patient patient:this.patients){
            if(patient.getId().equals(id))
                return true;
        }
        return false;
    }

    @Override
    public void add(Patient elem) throws Exception {
        if(this.patientExist(elem.getId()))
            throw new Exception("Patient already exist!");
        else
            this.patients.add(elem);
    }

    @Override
    public void delete(Patient elem) throws Exception {
        if(!this.patientExist(elem.getId()))
            throw new Exception("Patient doesn't exist!");
        else
            this.patients.remove(elem);
    }

    @Override
    public void update(Patient elem, Integer integer) throws Exception {
        if(!this.patientExist(elem.getId()))
            throw new Exception("Patient doesn't exist!");
        else{
            Patient patient=this.findByID(integer);
            patient=elem;
        }
    }

    @Override
    public Patient findByID(Integer integer) throws Exception {
        for(Patient patient:this.patients){
            if(patient.getId().equals(integer))
                return patient;
        }
        throw new Exception("Patient doesn't exsit!");
    }

    @Override
    public Iterable<Patient> findAll() {
        return this.patients;
    }
}
