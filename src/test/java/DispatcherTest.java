import controller.Dispatcher;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class DispatcherTest {


    private CallCenter callCenter= new CallCenter();
    private Dispatcher dispatcher;
    @Before
    public void setup() {
        dispatcher= new Dispatcher(callCenter);
        for (int i=0; i<7; i++) {
            Operator employee= new Operator();
            employee.setName("Operador"+i);
            callCenter.getEmployeeList().add(employee);
        }
        for (int i=0; i<2; i++) {
            Supervisor supervisor= new Supervisor();
            supervisor.setName("Supervisor"+i);
            callCenter.getEmployeeList().add(supervisor);
        }
        for (int i=0; i<1; i++) {
            Director director= new Director();
            director.setName("Director"+i);
            callCenter.getEmployeeList().add(director);
        }

    }

    @Test
    public void tenCallsTest() throws InterruptedException {
        System.out.println("TEST 10 LLAMADAS:");
        Dispatcher dispatcher= new Dispatcher(callCenter);
        Random aleatorio = new Random(System.currentTimeMillis());
        for (int i=0; i<10; i++) {
            Call call=new Call();
            call.setClientName(i+"");
            call.setDuration(((int) (5 + ( 11 - 5 ) * aleatorio.nextDouble()))*1000);
            call.setState(CallStateEnum.NEW_CALL);
            dispatcher.dispatchCall(call);
        }
        Thread.sleep(20000);
        int takenCalls=0;
        for (Employee employee:callCenter.getEmployeeList()) {
            for (Call call:employee.getTakenCalls()) {
                Assert.assertEquals(CallStateEnum.FINISH,call.getState());
                takenCalls++;
            }
        }
        Assert.assertEquals(10,takenCalls);


    }

    @Test
    public void moreThanTenCallsTest() throws InterruptedException {
        System.out.println("TEST MÁS DE 10 LLAMADAS:");

        Random aleatorio = new Random(System.currentTimeMillis());
        for (int i=0; i<11; i++) {
            Call call=new Call();
            call.setClientName(i+"");
            call.setDuration(((int) (5 + ( 11 - 5 ) * aleatorio.nextDouble()))*1000);
            call.setState(CallStateEnum.NEW_CALL);
            dispatcher.dispatchCall(call);
        }
        Thread.sleep(20000);
        int takenCalls=0;
        for (Employee employee:callCenter.getEmployeeList()) {
            for (Call call:employee.getTakenCalls()) {
                Assert.assertEquals(CallStateEnum.FINISH,call.getState());
                takenCalls++;
            }
        }
        Assert.assertEquals(11,takenCalls);


    }

    @Test
    public void findOperator()   {
        Employee employee= dispatcher.findFreeOperator();
        Assert.assertNotEquals(null,employee);
    }
    @Test
    public void findSupervisor()   {
        Employee employee= dispatcher.findFreeSupervisor();
        Assert.assertNotEquals(null,employee);
    }

    @Test
    public void findDirector()   {
        Employee employee= dispatcher.findFreeDirector();
        Assert.assertNotEquals(null,employee);
    }

}
