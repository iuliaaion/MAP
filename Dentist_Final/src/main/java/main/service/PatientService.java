package main.service;

import main.domain.Patient;
import main.repository.PatientRepo;

import java.util.ArrayList;
import java.util.List;

public class PatientService
{
    private PatientRepo pRepo;

    public PatientService(PatientRepo pRepo)
    {
        this.pRepo = pRepo;
    }

    public Patient adauga(Patient p)
    {
        return pRepo.save(p);
    }

    public List<Patient> getAll()
    {
        List<Patient> lp = new ArrayList<>();

        for(Patient p:pRepo.findAll())
        {
            lp.add(p);
        }

        return lp;
    }
}
