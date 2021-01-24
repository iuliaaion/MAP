package Service;

import Domain.Patient;
import Repository.PatientRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientService
{
    private PatientRepo pRepo;

    public PatientService(PatientRepo pRepo)
    {
        this.pRepo = pRepo;
    }

    public void add(Patient p)
    {
        pRepo.add(p);
    }

    public void delete(Patient p)
    {
        pRepo.delete(p);
    }

    public List<Patient> getAll()
    {
        List<Patient> patientList = new ArrayList<>();
        for (Patient p :pRepo.findAll())
        {

            patientList.add(p);
        }
        return patientList;
    }

}
