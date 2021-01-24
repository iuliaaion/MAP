package main.domain;

public class Appointment implements Identifiable<Integer>
{
    private int id;
    private String date;
    private String hour;
    private int patientId;
    private String status;
    private String problem;

    public Appointment() { }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", patientId=" + patientId +
                ", status='" + status + '\'' +
                ", problem='" + problem + '\'' +
                '}';
    }

    public Appointment(String date, String hour, int patientId, String status, String problem)
    {
        this.date = date;
        this.hour = hour;
        this.patientId = patientId;
        this.status = status;
        this.problem = problem;
    }

    public Appointment(int id, String date, String hour, int patientId, String status, String problem) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.patientId = patientId;
        this.status = status;
        this.problem = problem;
    }

    @Override
    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
