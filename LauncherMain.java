package it.unipr.ingsw.concurrency.esame062224;

public class LauncherMain {
	
	public static void main(String[] args) {
        Launcher launcher = new LauncherImpl();
        
        // Creiamo un esempio di Runnable
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Running in thread: " + Thread.currentThread().getName() + " - Iteration: " + i);
                try {
                    Thread.sleep(1000); // Dorme per 1 secondo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Ripristina lo stato di interruzione
                }
            }
        };

        // Utilizza il launcher per eseguire il Runnable
        launcher.execute(task);

        System.out.println("Launcher has started the thread and exited immediately.");
    }

}
