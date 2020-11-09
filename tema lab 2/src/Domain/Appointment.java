package Domain;

import java.util.Date;
import java.util.Objects;

public class Appointment implements Identifiable<Integer>  {
    private Integer id;
    private String date;
    private Integer patientId;

    public Appointment(Integer id, String date, Integer patientId) {
        this.id = id;
        this.date = date;
        this.patientId = patientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", patientId=" + patientId +
                '}';
    }
}
