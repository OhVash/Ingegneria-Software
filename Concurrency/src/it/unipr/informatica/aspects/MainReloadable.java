package it.unipr.informatica.aspects;



import it.unipr.informatica.aspects.model.ReloadableHandler;

public class MainReloadable {
    public static void main(String[] args) {
        try {
            String classPath = "/Users/alessandrovascelli/Desktop/Unipr/java/Concurrency/bin/it/unipr/informatica/aspects/"; // Specifica il percorso della tua classe
            String className = "MyReloadable";

            // Creazione del gestore di classe ricaricabile
            ReloadableHandler<MyReloadable> handler = ReloadableAspect.newHandler(MyReloadable.class, className, new String[] { classPath });

            // Caricamento della classe e creazione di una nuova istanza
            MyReloadable myObject = handler.newInstance();

            // Stampa del messaggio iniziale
            System.out.println("Message: " + myObject.getMessage());

            // Modifica del messaggio
            myObject.setMessage("Updated message!");

            // Stampa del messaggio aggiornato
            System.out.println("Updated Message: " + myObject.getMessage());

            // Ricaricamento della classe e creazione di una nuova istanza
            myObject = handler.newInstance();

            // Stampa del messaggio ricaricato (dovrebbe essere il messaggio originale)
            System.out.println("Reloaded Message: " + myObject.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

