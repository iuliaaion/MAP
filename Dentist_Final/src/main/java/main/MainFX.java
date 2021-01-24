package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controller.Controller;
import main.repository.AppointmentRepo;
import main.repository.PatientRepo;
import main.service.AppointmentService;
import main.service.PatientService;
import main.service.ServiceException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MainFX extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        Parent root;
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("example.fxml"));
            root = loader.load();
            Controller ctrl = loader.getController();
            ctrl.setPatientService(getPatientService());
            ctrl.setAppointmentService(getAppointmentService());

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
            launch(args);
    }

    static PatientService getPatientService()
    {
        PatientRepo prepo = new PatientRepo();
        PatientService pserv = new PatientService(prepo);
        return pserv;
    }

    static AppointmentService getAppointmentService()
    {
        AppointmentRepo arepo = new AppointmentRepo();
        AppointmentService aserv = new AppointmentService(arepo);
        return aserv;
    }



}
