package main.repository;

import main.domain.Patient;

public class PatientRepo extends InMemoryRepo<Integer, Patient>
{
    public PatientRepo()
    {
        loadPatients();
    }

    public Patient save(Patient p)
    {
        p.setId(IDgenerator.getNextId());
        super.save(p);
        return p;
    }

    private void loadPatients()
    {
        save(new Patient("Inna",21,"0789654321"));

        save(new Patient("Sam",78,"0798123456"));
        save(new Patient("Andrew",50,"0764648434"));
        save(new Patient("Louisa",35,"0799541289"));
    }
}
