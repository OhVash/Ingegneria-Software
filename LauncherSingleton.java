package it.unipr.esame24062024;


public class LauncherSingleton implements Launcher {
	private static LauncherSingleton instance;
	private static int max_job = 10;
	private int counter_active_job;
	
	public LauncherSingleton() {
		counter_active_job = 0;
	}
	@Override
	public void activate(Job job) {
		synchronized (job) {
			while (counter_active_job == max_job) {
				try {
					job.wait();
				} catch (Exception e) {
					Thread.currentThread().interrupt();				}
			}
			
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try{
						job.perform();
					} finally {
						synchronized (job) {
							counter_active_job--;
							System.out.println("[FINALLY] Job terminato. Job attivi = " + counter_active_job);
							job.notify();
						}
					}
				}
			};
			
			Thread thread = new Thread(runnable);
			counter_active_job++;
			thread.start();
			System.out.println("[ACTIVATE] avviato Thread:  " + thread.getName() + " ed ho " + counter_active_job + " job attivi");
			
			}
		}

	
	public static LauncherSingleton getInstance() {
		LauncherSingleton result = instance;
		if (result == null) {
			synchronized (LauncherSingleton.class) {
				result = instance;
				if (result == null) {
					instance = result = new LauncherSingleton();
				}
			}
		}
		return result;
	}

}
