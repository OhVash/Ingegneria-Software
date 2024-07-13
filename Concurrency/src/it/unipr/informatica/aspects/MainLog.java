package it.unipr.informatica.aspects;


public class MainLog implements MyInterfaceLog {
    @Override
    public void doSomething(String message) {
        System.out.println("Doing something: " + message);
    }

    public static void main(String[] args) {
        MainLog myObject = new MainLog();
        MyInterfaceLog proxyObject = LoggingAspect.attach(myObject);

        proxyObject.doSomething("Hello, world!"); // Il metodo verrà loggato
    }
}


