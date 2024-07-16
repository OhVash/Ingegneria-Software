package it.unipr.ingsw.concurrency.esame090224;

public class ResourceManager {
	private static volatile ResourceManager instance;
	private ResourceImpl[] resources;
	
	public ResourceManager() {
		resources = new ResourceImpl[10];
		for (int i = 0; i < resources.length; i++) {
			resources[i] = new ResourceImpl(i);
		}
	}
	
	public static ResourceManager getInstance() {
		if (instance==null) {
			synchronized (ResourceManager.class) {
				if (instance == null) {
					instance = new ResourceManager();
				}
			}
		}
		return instance;
	}
	
	public synchronized Resource acquire(int id) {
		ResourceImpl resource = resources[id];
		resource.acquire();
		return resource;
	}
}
