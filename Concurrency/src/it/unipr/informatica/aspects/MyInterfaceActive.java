package it.unipr.informatica.aspects;

import it.unipr.informatica.aspects.model.Active;

public interface MyInterfaceActive extends Active<MyInterfaceActive> {
    void doSomething();
}
