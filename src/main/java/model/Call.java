/*
Prueba desarrollador almundo por Juan Daniel Patiño
 */
package model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase que representa la llamada, la cual implementa la interface Runnable para manejar la concurrencia.
 *
 */
public class Call implements Runnable{

    private int duration;
    private CallStateEnum state;
    private String clientName;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CallStateEnum getState() {
        return state;
    }

    public void setState(CallStateEnum state) {
        this.state = state;
    }


    /**
     * Hilo que procesa la llamada de forma concurrente
     *
     */
    public void run() {
        try {
            Thread.sleep(this.duration);
            this.state=CallStateEnum.FINISH;
            System.out.println("Lammada "+this.clientName +" finalizada");
        } catch (InterruptedException ex) { // Sleep puede lanzar una excepción que aborte la ejecución del hilo.
            Logger.getLogger(Call.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        }
    }
}
