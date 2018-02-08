/*
Prueba desarrollador almundo por Juan Daniel Patiño
 */
package model;

/**
 *Enumerador que representa los diferentes estados de una llamada.
 *
 */
public enum CallStateEnum {

    ACTIVE("Llamada activa"),
    FINISH("Llamada finalizada"),
    LOST("Llamada perdida"),
    NEW_CALL("Nueva llamdada entrante");

    private String displayName;
    private String userStateName;

    /**
     * Obtiene el enumerador a partir del displayName
     *
     * @param displayName displayName actual
     */
    CallStateEnum(String displayName) {
        this.displayName = displayName;
        userStateName = name();
    }

    public String getDisplayName() {
        return displayName;
    }
}
