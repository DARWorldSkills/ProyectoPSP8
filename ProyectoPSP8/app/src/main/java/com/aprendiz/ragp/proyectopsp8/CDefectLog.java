package com.aprendiz.ragp.proyectopsp8;

public class CDefectLog {
    //Declaración de varaibles
    private int id, project;
    private String date, type, phaseI, phaseR, fixTime, comments;

    //Constructor vacio de CDefectLog
    public CDefectLog() {
    }

    //Constructor para la creación del objeto de la clase CDefectLog
    public CDefectLog(int id, int project, String date, String type, String phaseI, String phaseR, String fixTime, String comments) {
        this.id = id;
        this.project = project;
        this.date = date;
        this.type = type;
        this.phaseI = phaseI;
        this.phaseR = phaseR;
        this.fixTime = fixTime;
        this.comments = comments;
    }

    //Getter and Setter para las variables de la clase CDefectLog


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhaseI() {
        return phaseI;
    }

    public void setPhaseI(String phaseI) {
        this.phaseI = phaseI;
    }

    public String getPhaseR() {
        return phaseR;
    }

    public void setPhaseR(String phaseR) {
        this.phaseR = phaseR;
    }

    public String getFixTime() {
        return fixTime;
    }

    public void setFixTime(String fixTime) {
        this.fixTime = fixTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
