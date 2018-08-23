package com.aprendiz.ragp.proyectopsp8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.ViewAnimationUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ManagerDB {
    GestorDB gestorDB;
    SQLiteDatabase db;
    Context context;

    //Constructor para el manejo de clase
    public ManagerDB(Context context) {
        this.context = context;
    }

    //Método para abrir la base de datos en modo lectura
    private void openReadDB(){
        gestorDB = new GestorDB(context);
        db = gestorDB.getReadableDatabase();
    }

    //Método para abrir la base de datos en modo escritura
    private void openWriteDB(){
        gestorDB = new GestorDB(context);
        db = gestorDB.getWritableDatabase();
    }

    //Método para cerrar la base de datos
    private void closeDB(){
        db.close();
    }

    //Método para el ingreso de projectos a la base de datos
    public void inputProject(CProject project){
        openWriteDB();
        ContentValues values = new ContentValues();
        values.put("NOMBRE",project.getNombre());
        values.put("TIME",project.getTime());
        db.insert("PROJECT",null,values);
        closeDB();
    }

    //Método para el ingreso de timelogs a la base de datos
    public void inputTimeLog(CTimeLog timeLog){
        openWriteDB();
        ContentValues values = new ContentValues();
        values.put("PHASE",timeLog.getPhase());
        values.put("START",timeLog.getStart());
        values.put("INTERRUPCION",timeLog.getInterruption());
        values.put("STOP",timeLog.getStop());
        values.put("DELTA",timeLog.getDelta());
        values.put("COMMMETS",timeLog.getComments());
        values.put("PROJECT",timeLog.getProject());
        db.insert("TIMELOG",null,values);
        closeDB();
    }

    //Método para el ingreso de defectlogs a la base de datos
    public void inputDefectLog(CDefectLog defectLog){
        openWriteDB();
        ContentValues values = new ContentValues();
        values.put("DATE",defectLog.getDate());
        values.put("TYPE",defectLog.getType());
        values.put("PHASEI",defectLog.getPhaseI());
        values.put("PHASER",defectLog.getPhaseR());
        values.put("FIXTIME",defectLog.getFixTime());
        values.put("COMMMETS",defectLog.getComments());
        values.put("PROJECT",defectLog.getProject());
        db.insert("DEFECTLOG",null,values);
        closeDB();
    }


    //Update

    //Método para la actualización del tiempo en los projectos a la base de datos
    public void updateProject(CProject project){
        openWriteDB();
        ContentValues values = new ContentValues();
        values.put("NOMBRE",project.getNombre());
        values.put("TIME",project.getTime());
        db.update("PROJECT",values,"IDPROJECT="+project.getId()+";",null);
        closeDB();
    }

    //Método para la actualización de timelogs a la base de datos
    public void updateTimeLog(CTimeLog timeLog){
        openWriteDB();
        ContentValues values = new ContentValues();
        values.put("PHASE",timeLog.getPhase());
        values.put("START",timeLog.getStart());
        values.put("INTERRUPCION",timeLog.getInterruption());
        values.put("STOP",timeLog.getStop());
        values.put("DELTA",timeLog.getDelta());
        values.put("COMMMETS",timeLog.getComments());
        db.update("TIMELOG",values,"IDTIMELOG="+timeLog.getId()+";",null);
        closeDB();
    }

    //Método para la actualización de defectlogs a la base de datos
    public void updateDefectLog(CDefectLog defectLog){
        openWriteDB();
        ContentValues values = new ContentValues();
        values.put("DATE",defectLog.getDate());
        values.put("TYPE",defectLog.getType());
        values.put("PHASEI",defectLog.getPhaseI());
        values.put("PHASER",defectLog.getPhaseR());
        values.put("FIXTIME",defectLog.getFixTime());
        values.put("COMMMETS",defectLog.getComments());
        db.update("DEFECTLOG",values,"IDDEFECTLOG="+defectLog.getId()+";",null);
        closeDB();
    }


    //Delete

    //Método para la eliminación de projectos
    public void deleteProject(CProject project){
        openWriteDB();
        db.delete("PROJECT","IDPROJECT="+project.getId()+";",null);
        closeDB();
    }

    //Método para la eliminación de timelogs
    public void deleteTimeLog(CTimeLog timeLog){
        openWriteDB();
        db.delete("TIMELOG","IDTIMELOG="+timeLog.getId()+";",null);
        closeDB();
    }

    //Método para la eliminación de defectlogs
    public void deleteDefectLog(CDefectLog defectLog){
        openWriteDB();
        db.delete("DEFECTLOG","IDDEFECTLOG="+defectLog.getId()+";",null);
        closeDB();
    }


    //Función para listar los proyectos
    public List<CProject> projectList(){
        openReadDB();
        List<CProject> results = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM PROJECT;",null);
        if (cursor.moveToFirst()){
            do {
                CProject project = new CProject();
                project.setId(cursor.getInt(0));
                project.setNombre(cursor.getString(1));
                project.setTime(cursor.getInt(2));

                results.add(project);

            }while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return results;
    }


    //Función para listar los timelogs
    public List<CTimeLog> timeLogsList(int project){
        openReadDB();
        List<CTimeLog> results = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM TIMELOG WHERE IDPROJECT="+project+";",null);
        if (cursor.moveToFirst()){
            do {
                CTimeLog timeLog = new CTimeLog();
                timeLog.setId(cursor.getInt(0));
                timeLog.setPhase(cursor.getString(1));
                timeLog.setStart(cursor.getString(2));
                timeLog.setInterruption(cursor.getInt(3));
                timeLog.setStop(cursor.getString(4));
                timeLog.setDelta(cursor.getInt(5));
                timeLog.setComments(cursor.getString(6));
                timeLog.setProject(cursor.getInt(7));
                results.add(timeLog);

            }while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return results;
    }



    //Función para listar los timelogs
    public List<CDefectLog> defectLogsList(int project){
        openReadDB();
        List<CDefectLog> results = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM TIMELOG WHERE IDPROJECT="+project+";",null);
        if (cursor.moveToFirst()){
            do {
                CDefectLog defectLog = new CDefectLog();
                defectLog.setId(cursor.getInt(0));
                defectLog.setDate(cursor.getString(1));
                defectLog.setType(cursor.getString(2));
                defectLog.setPhaseI(cursor.getString(3));
                defectLog.setPhaseR(cursor.getString(4));
                defectLog.setFixTime(cursor.getString(5));
                defectLog.setComments(cursor.getString(6));
                defectLog.setProject(cursor.getInt(7));
                results.add(defectLog);

            }while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return results;
    }

    //Función para listar el Time In Phase
    public List<Results> timeInPhase(int project){
        List<Results> resultsList = new ArrayList<>();
        openReadDB();
        Cursor cursor =db.rawQuery("SELECT TIME FROM PROJECT WHERE IDPROJECT ="+project+";",null);
        int tiempoT = 0;
        if (cursor.moveToFirst()){
            do {
                tiempoT=cursor.getInt(0);
            }while (cursor.moveToNext());

        }

        cursor.close();

        for (int i=0;i<Constants.listPhases.length;i++){
            Cursor cursorM = db.rawQuery("SELECT DELTA FROM TIMELOG WHERE PHASE="+Constants.listPhases[i]+";",null);
            Results results = new Results();
            int tiempo=0;
            if (cursorM.moveToFirst()){
                do {
                    tiempo+=cursor.getInt(0);
                }while (cursorM.moveToNext());
            }

            if (tiempoT!=0 && tiempo!=0){

                float tmp1 = tiempo, tmp2=tiempoT;
                double tmpR = (tmp1/tmp2)*100;

                BigDecimal bigDecimal = new BigDecimal(tmpR);

                float percent = bigDecimal.setScale(2, RoundingMode.HALF_UP).floatValue();
                results = new Results(Constants.listPhases[i],tiempo,percent);
            }else {
                results = new Results(Constants.listPhases[i],0,0);
            }

            resultsList.add(results);

            cursorM.close();
        }

        cursor.close();
        closeDB();

        return resultsList;
    }

    //Función para listar los Defects Injected In Phase
    public List<Results> defectsInjectInPhase(int project){
        List<Results> resultsList = new ArrayList<>();
        openReadDB();
        Cursor cursor =db.rawQuery("SELECT * FROM DEFECTLOG WHERE IDPROJECT ="+project+";",null);
        int tiempoT = 0;
        if (cursor.moveToFirst()){
            do {
                tiempoT++;
            }while (cursor.moveToNext());

        }

        cursor.close();

        for (int i=0;i<Constants.listPhases.length;i++){
            Cursor cursorM = db.rawQuery("SELECT * FROM DEFECTLOG WHERE PHASEI="+Constants.listPhases[i]+";",null);
            Results results = new Results();
            int tiempo=0;
            if (cursorM.moveToFirst()){
                do {
                    tiempo++;
                }while (cursorM.moveToNext());
            }

            if (tiempoT!=0 && tiempo!=0){

                float tmp1 = tiempo, tmp2=tiempoT;
                double tmpR = (tmp1/tmp2)*100;

                BigDecimal bigDecimal = new BigDecimal(tmpR);

                float percent = bigDecimal.setScale(2, RoundingMode.HALF_UP).floatValue();
                results = new Results(Constants.listPhases[i],tiempo,percent);
            }else {
                results = new Results(Constants.listPhases[i],0,0);
            }

            resultsList.add(results);

            cursorM.close();
        }

        cursor.close();
        closeDB();

        return resultsList;
    }

    //Función para listar los Defects Removed In Phase
    public List<Results> defectsRemovedInPhase(int project){
        List<Results> resultsList = new ArrayList<>();
        openReadDB();
        Cursor cursor =db.rawQuery("SELECT * FROM DEFECTLOG WHERE IDPROJECT ="+project+";",null);
        int tiempoT = 0;
        if (cursor.moveToFirst()){
            do {
                tiempoT++;
            }while (cursor.moveToNext());

        }

        cursor.close();

        for (int i=0;i<Constants.listPhases.length;i++){
            Cursor cursorM = db.rawQuery("SELECT * FROM DEFECTLOG WHERE PHASER="+Constants.listPhases[i]+";",null);
            Results results = new Results();
            int tiempo=0;
            if (cursorM.moveToFirst()){
                do {
                    tiempo++;
                }while (cursorM.moveToNext());
            }

            if (tiempoT!=0 && tiempo!=0){

                float tmp1 = tiempo, tmp2=tiempoT;
                double tmpR = (tmp1/tmp2)*100;

                BigDecimal bigDecimal = new BigDecimal(tmpR);

                float percent = bigDecimal.setScale(2, RoundingMode.HALF_UP).floatValue();
                results = new Results(Constants.listPhases[i],tiempo,percent);
            }else {
                results = new Results(Constants.listPhases[i],0,0);
            }

            resultsList.add(results);

            cursorM.close();
        }

        cursor.close();
        closeDB();

        return resultsList;
    }



}
