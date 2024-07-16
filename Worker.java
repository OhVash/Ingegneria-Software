package it.unipr.ingsw.concurrency.esame090224;

import java.util.Random;

public class Worker implements Runnable {
	private final int id;
	private Logger logger;
	private ResourceManager resourceManager;

	public Worker(int id) {
		this.id = id;
		this.resourceManager = ResourceManager.getInstance();
		this.logger = new Logger();
	}
	@Override
	public void run() {
		for (int i = 0; i<10 ; i++) { //chiamo 10 volte la funzione do use
			try {
			Random random = new Random();
			int resourceId = random.nextInt(10); //id casuale della risorsa da acquisire
			Resource resource = resourceManager.acquire(resourceId);
			logger.log("id della risorsa: " + resourceId);
			doUse(resource);
			resource.release();
			
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		

	}
	
	public void doUse(Resource r) {
		int result = r.use();
		logger.log("Risultato di use" + result);
	}

}
