package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.domain.Appointment;
import main.domain.Patient;
import main.service.AppointmentService;
import main.service.PatientService;

import java.util.ArrayList;
import java.util.List;

public class Controller
{
    @FXML
    private TableView<Patient> patientTable;
    @FXML
    private TableView<Appointment> appointmentTable;

    @FXML
    private TextField namePatientField, agePatientField, phonePatientField, dateAppointmentField, hourAppointmentField, patientAppointmentField, statusAppointmentField, problemAppointmentField;

    @FXML
    private Text idPatientLabel, idAppointmentLabel;

    private PatientService patientService;
    private AppointmentService appointmentService;

    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private ObservableList<Appointment> appointments = FXCollections.observableArrayList();

    public Controller() { }

    @FXML
    public void initialize()
    {
        patientTable.getSelectionModel().selectedItemProperty().addListener((observable, oldItem, newItem) -> showPatient(newItem));
        patientTable.setItems(patients);

        System.out.println(appointmentTable);
        appointmentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldItem, newItem) -> showAppointment(newItem));
        appointmentTable.setItems(appointments);
    }

    private void showPatient(Patient newItem)
    {
        if(newItem == null)
            clearPatientFields();
        else
        {
            idPatientLabel.setText(""+newItem.getId());
            namePatientField.setText(newItem.getName());
            agePatientField.setText(""+newItem.getAge());
            phonePatientField.setText(newItem.getPhoneNo());
        }

    }

    private void clearPatientFields()
    {
        idPatientLabel.setText("");
        namePatientField.setText("");
        agePatientField.setText("");
        phonePatientField.setText("");
    }

    private void showAppointment(Appointment newItem)
    {
        if(newItem == null)
            clearAppointmentFields();
        else
        {
            idAppointmentLabel.setText(""+newItem.getId());
            dateAppointmentField.setText(newItem.getDate());
            hourAppointmentField.setText(newItem.getHour());
            patientAppointmentField.setText(""+newItem.getPatientId());
            statusAppointmentField.setText(newItem.getStatus());
            problemAppointmentField.setText(newItem.getProblem());
        }
    }

    private void clearAppointmentFields()
    {
        idAppointmentLabel.setText("");
        dateAppointmentField.setText("");
        hourAppointmentField.setText("");
        patientAppointmentField.setText("");
        statusAppointmentField.setText("");
        problemAppointmentField.setText("");
    }

    public void setPatientService(PatientService pserv)
    {
        this.patientService = pserv;
        List<Patient> lp = pserv.getAll();
        patients.addAll(lp);
    }

    public void setAppointmentService(AppointmentService aserv)
    {
        this.appointmentService = aserv;
        List<Appointment> la = aserv.getAll();
        appointments.addAll(la);
    }

    @FXML
    private void addPatient(ActionEvent e)
    {
        String name = namePatientField.getText();
        String ageS = agePatientField.getText();
        String phone = phonePatientField.getText();

        if("".equals(name) || "".equals(ageS) || "".equals(phone))
        {
            showErrorMessage("You need to fill all fields");
            return;
        }
        try
        {
            int age = Integer.parseInt(ageS);
            Patient p = new Patient(name,age,phone);
            p = patientService.adauga(p);
            patients.add(p);
        }
        catch (NumberFormatException ex)
        {
            showErrorMessage("Error while inserting data" + ex);
        }
    }

    @FXML
    private void clearPatient(ActionEvent e)
    {
        clearPatientFields();
        patientTable.getSelectionModel().clearSelection();
    }

    @FXML
    private void deletePatient(ActionEvent e)
    {
        int selectedIndex = patientTable.getSelectionModel().getSelectedIndex();

        if(selectedIndex < 0)
        {
            showErrorMessage("You need to select a patient from table");
            return;
        }
        else
        {
            patients.remove(selectedIndex);
        }
    }

    @FXML
    private void addAppointment(ActionEvent e)
    {
        String date = dateAppointmentField.getText();
        String hour = hourAppointmentField.getText();
        String patientS = patientAppointmentField.getText();
        String status = statusAppointmentField.getText();
        String problem = problemAppointmentField.getText();

        if("".equals(date) || "".equals(hour) || "".equals(patientS) || "".equals(status) || "".equals(problem))
        {
            showErrorMessage("You need to fill all fields");
            return;
        }
        try
        {
            int patient = Integer.parseInt(patientS);
            Appointment a = new Appointment(date,hour,patient,status,problem);
            a = appointmentService.adauga(a);
            appointments.add(a);
        }
        catch (NumberFormatException ex)
        {
            showErrorMessage("Error while inserting data" + ex);
        }
    }

    @FXML
    private void clearAppointment(ActionEvent e)
    {
        clearAppointmentFields();
        appointmentTable.getSelectionModel().clearSelection();
    }

    @FXML
    private void deleteAppointment(ActionEvent e)
    {
        int selectedIndex = appointmentTable.getSelectionModel().getSelectedIndex();

        if(selectedIndex < 0)
        {
            showErrorMessage("You need to select an appointment from table");
            return;
        }
        else
        {
            appointments.remove(selectedIndex);
        }
    }

    void showErrorMessage(String text)
    {
        Alert messsage = new Alert(Alert.AlertType.ERROR);
        messsage.setTitle("Error message");
        messsage.setContentText(text);
        messsage.showAndWait();
    }
}
