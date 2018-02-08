/*
Prueba desarrollador almundo por Juan Daniel Patiño
 */
package controller;

import model.*;


/**
 * Clase encargada de manejar todas las llamadas.
 */
public class Dispatcher  {



    private final CallCenter callCenter;


    /**
     * Constructor
     * @param callCenter Call center al cual se pertenece
     */
    public Dispatcher(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    /**
     * Función encargada de asignar las nuevas llamadas.
     *
     * @param call Llamada a procesar
     * @throws InterruptedException Error al crear el hilo
     */
    public void dispatchCall(Call call) throws InterruptedException {
        Employee employee=findFreeEmployee();
        if (employee!=null){
            call.setState(CallStateEnum.ACTIVE);
            System.out.println("Empleado: " + employee.getName() + " Toma la llamada numero: " + call.getClientName() + " con duración de " + call.getDuration() + " ms");
            employee.getTakenCalls().add(call);
            new Thread(call).start();

        }
        else{
            System.out.println("No se encontro ningun empleado libre. por favor espere un momento...");
            Thread.sleep(10000);
            employee=findFreeEmployee();
            if (employee!=null){
                call.setState(CallStateEnum.ACTIVE);
                System.out.println("Empleado: " + employee.getName() + " Toma la llamada. numero: " + call.getClientName());
                employee.getTakenCalls().add(call);
                new Thread(call).start();

            }
            else{
                System.out.println("No se encontro ningun empleado libre");
                call.setState(CallStateEnum.LOST);
            }
        }


    }

    /**
     * Función encargada de buscar un empleado libre según la siguiente prioridad operador, supervisor y director.
     *
     * @return empleado libre
     */
    private Employee findFreeEmployee(){
        Employee employee=null;
        employee=findFreeOperator();
        if(employee==null){
            employee=findFreeSupervisor();
        }

        if(employee==null){
            employee=findFreeDirector();
        }
        return employee;
    }

    /**
     * Función encargada de encontrar un operador libre.
     *
     * @return operador libre
     */
    public Employee findFreeOperator(){
        for (Employee employee:callCenter.getEmployeeList()) {
            if (employee.getTakenCalls().isEmpty() && employee instanceof Operator){
                return employee;
            }
            Boolean freeEmploye=true;
            for (Call call:employee.getTakenCalls()) {
                if(call.getState().equals(CallStateEnum.ACTIVE)){
                    freeEmploye=false;
                }
            }
            if (freeEmploye && employee instanceof Operator){
                return employee;
            }
        }
        return null;
    }

    /**
     * Función encargada de encontrar un supervisor libre.
     *
     * @return supervisor libre
     */
    public Employee findFreeSupervisor(){
        for (Employee employee:callCenter.getEmployeeList()) {
            if (employee.getTakenCalls().isEmpty() && employee instanceof Operator){
                return employee;
            }
            Boolean freeEmploye=true;
            for (Call call:employee.getTakenCalls()) {
                if(call.getState().equals(CallStateEnum.ACTIVE)){
                    freeEmploye=false;
                }
            }
            if (freeEmploye && employee instanceof Supervisor){
                return employee;
            }
        }
        return null;
    }

    /**
     * Función encargada de encontrar un director libre.
     *
     * @return director libre
     */
    public Employee findFreeDirector(){
        for (Employee employee:callCenter.getEmployeeList()) {
            if (employee.getTakenCalls().isEmpty() && employee instanceof Operator){
                return employee;
            }
            Boolean freeEmploye=true;
            for (Call call:employee.getTakenCalls()) {
                if(call.getState().equals(CallStateEnum.ACTIVE)){
                    freeEmploye=false;
                }
            }
            if (freeEmploye && employee instanceof Director){
                return employee;
            }
        }
        return null;
    }


}
