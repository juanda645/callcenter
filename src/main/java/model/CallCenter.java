/*
Prueba desarrollador almundo por Juan Daniel Patiño
 */
package model;


import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el Call Center.
 *
 */

public class CallCenter {

    private List<Employee> employeeList = new ArrayList<Employee>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
