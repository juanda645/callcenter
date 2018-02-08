/*
Prueba desarrollador almundo por Juan Daniel Patiño
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa empleados
 *
 */
public abstract class Employee  {

    private String name;
    private List<Call> takenCalls = new ArrayList<Call>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Call> getTakenCalls() {
        return takenCalls;
    }

    public void setTakenCalls(List<Call> takenCalls) {
        this.takenCalls = takenCalls;
    }
}
