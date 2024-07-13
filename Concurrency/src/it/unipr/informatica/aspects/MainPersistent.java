package it.unipr.informatica.aspects;

import java.io.IOException;
import it.unipr.informatica.aspects.model.PersistentHandler;

public class MainPersistent {
    public static void main(String[] args) {
        try {
            // Creazione di un oggetto MySerializableObject
            MySerializableObject initialObject = new MySerializableObject("Initial Value");

            // Associazione dell'oggetto con il gestore di persistenza
            PersistentHandler<MySerializableObject> handler = PersistentAspect.attach("myObject.dat", initialObject);

            // Ottenere l'oggetto gestito
            MySerializableObject myObject = handler.get();

            // Stampare il valore iniziale
            System.out.println("Initial Value: " + myObject.getValue());

            // Aggiornare il valore dell'oggetto
            myObject.setValue("Updated Value");

            // Salvare lo stato aggiornato nel file
            handler.commit();

            // Stampare il valore aggiornato
            System.out.println("Updated Value: " + myObject.getValue());
            //imposto un nuovo vallore sbagliato
            myObject.setValue("Wrong Value");
            
            // Stampare il valore aggiornato
            System.out.println("Wrongly Updated Value but no commit: " + myObject.getValue());

            // Ripristinare lo stato precedente
            handler.rollback();

            // Re-ottenere l'oggetto gestito dopo il rollback
            myObject = handler.get();

            // Stampare il valore ripristinato
            System.out.println("Restored Value after rollback: " + myObject.getValue());
            //salvo il valore ripristinanto
            handler.commit();
            
            //a fine lo riporto in stato iniziale
            myObject.setValue("Initial Value");
            handler.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
