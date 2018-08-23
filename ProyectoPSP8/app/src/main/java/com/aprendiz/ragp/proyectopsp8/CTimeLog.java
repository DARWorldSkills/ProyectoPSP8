package com.aprendiz.ragp.proyectopsp8;

public class CTimeLog {
    //Declaración de variables
    private int id;
    private String phase;
    private String start;
    private int interruption,delta;
    private String stop;
    private String comments;
    private int project;

    //Constructor vacio de CTimeLog
    public CTimeLog() {
    }

    //Constructor para crear el objeto de la clase CTimeLog


    public CTimeLog(int id, String phase, String start, int interruption, int delta, String stop, String comments, int project) {
        this.id = id;
        this.phase = phase;
        this.start = start;
        this.interruption = interruption;
        this.delta = delta;
        this.stop = stop;
        this.comments = comments;
        this.project = project;
    }

    //Getter and Setter para todas varaibles de la clase CTimeLog
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public int getInterruption() {
        return interruption;
    }

    public void setInterruption(int interruption) {
        this.interruption = interruption;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }
}
