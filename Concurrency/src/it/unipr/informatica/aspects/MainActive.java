package it.unipr.informatica.aspects;


import it.unipr.informatica.aspects.model.ActiveHandler;

public class MainActive implements MyInterfaceActive {
    public void doSomething() {
        System.out.println("Doing something! " );
    }

    public static void main(String[] args) {
    	MainActive myObject = new MainActive();
        ActiveHandler<MyInterfaceActive> handler = ActiveAspect.attach(MyInterfaceActive.class, myObject);

        MyInterfaceActive activeObject = handler.get();
        activeObject.doSomething(); // Esegue doSomething in modo asincrono
       
        handler.shutdown(); // Arresta l'esecuzione asincrona
    }
}
