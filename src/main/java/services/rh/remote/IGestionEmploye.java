package services.rh.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Collaborateur;
import models.Employer;

@Remote
public interface IGestionEmploye {
    public void addEmploye(Employer employe, Collaborateur collaborateur);
    public void updateEmploye(Employer employe, Collaborateur collaborateur);
    public void deleteEmploye(int employeId);
    public Employer getEmployeById(int employeId);
    public List<Employer> getAllEmployes();
}
