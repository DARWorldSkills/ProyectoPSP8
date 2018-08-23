package com.aprendiz.ragp.proyectopsp8.Models;

public class Constants {
    //Declaración de constantes para la creación de la base de datos
    public static final String DATABASE_NAME = "psp.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TableProject = "CREATE TABLE PROJECT (IDPROJECT INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, TIME INTEGER);";
    public static final String TableTimeLog = "CREATE TABLE TIMELOG (IDTIMELOG INTEGER PRIMARY KEY AUTOINCREMENT, PHASE TEXT, START TEXT, INTERRUPCION INTEGER, STOP TEXT, DELTA INTEGER, COMMMETS TEXT, PROJECT INTEGER, " +
            "FOREIGN KEY (PROJECT) REFERENCES PROJECT (IDPROJECT));";
    public static final String TableDefectLog= "CREATE TABLE DEFECTLOG (IDDEFECTLOG INTEGER PRIMARY KEY AUTOINCREMENT, DATE TEXT, TYPE TEXT, PHASEI INTEGER, PHASER TEXT, FIXTIME INTEGER, COMMMETS TEXT, PROJECT INTEGER, " +
            "FOREIGN KEY (PROJECT) REFERENCES PROJECT (IDPROJECT));";

    //Constante para el listado de phases
    public static final String[] listPhases={
        "PLAN","DLD","CODE","COMPILE","UT","PM"
    };

}
