package com.aprendiz.ragp.proyectopsp8;

public class CProject {
    //Declaración de variables
    private int id;
    private String nombre;
    private int time;

    //Constructor vacio de CProject
    public CProject() {
    }

    //Constructor para crear el objeto de la clase CProject
    public CProject(int id, String nombre, int time) {
        this.id = id;
        this.nombre = nombre;
        this.time = time;
    }

    //Getter and Setter de las varaibles de la clase CProject
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
