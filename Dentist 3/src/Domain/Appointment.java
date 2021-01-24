package Domain;

import Domain.Identifiable;

import java.io.Serializable;

public class Appointment implements Identifiable<Integer>, Serializable
{
            private Integer ID;
            private String date;
            private String hour;
            private Integer pacientID;
            private String status;
            private String problem;

            public Appointment()
            {
                ID = 0;
                date = "";
                hour = "";
                pacientID = 0;
                status = "";
                problem = "";
            }

            public Appointment(Integer ID, String date,String hour, Integer pacientID, String status, String problem)
            {
                this.ID = ID;
                this.date = date;
                this.hour = hour;
                this.pacientID = pacientID;
                this.status = status;
                this.problem = problem;
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

            public Integer getPacientID() {
                return pacientID;
            }

            public void setPacientID(Integer pacientID) {
                this.pacientID = pacientID;
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

            public Integer getID()
            {
                return ID;
            }

            public void setID(Integer ID)
            {
                this.ID = ID;
            }

            public String toString()
            {
                return this.ID + "," + this.date + "," + this.hour + "," + this.pacientID + "," + this.status + "," + this.problem;
            }

            public int compareTo(Domain.Appointment a)
            {
                if(this.pacientID < a.pacientID)
                    return -1;
                if(this.pacientID == a.pacientID)
                    return 0;

                return 1;
            }
        }

