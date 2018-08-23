package com.aprendiz.ragp.proyectopsp8;

public class Results {

    //Declaración de variables de la clase Results
    private String phase;
    private int time;
    private float percent;

    //Constructor vacion
    public Results() {
    }

    //Constructor para la creación de objetos de la clase Results


    public Results(String phase, int time, float percent) {
        this.phase = phase;
        this.time = time;
        this.percent = percent;
    }

    //Getter and Setter de las varibles de la clase Results
    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
