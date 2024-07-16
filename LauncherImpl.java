package it.unipr.ingsw.concurrency.esame070624;

import java.util.Iterator;

import it.unipr.ingsw.concurrency.pool.ExecutorService;
import it.unipr.ingsw.concurrency.pool.Executors;
import it.unipr.ingsw.concurrency.pool.Future;
import it.unipr.ingsw.concurrency.pool.exceptions.ExecutionException;

public class LauncherImpl implements Launcher {
	private final int N;
	private int total = 0;
	private ExecutorService executorService;
	private Future<Integer> future;

	private LauncherImpl(int n) {
		this.N = n;
		this.executorService = Executors.newFixedThreadPool(n);
	}
	@SuppressWarnings("unchecked")
	@Override
	public synchronized int start(Activity[] activities) {
		if (activities.length!=N) {
			throw new IllegalArgumentException();
		}
		
		try {
			if (future!=null) {
				future.get(); //attendo che l'attività precedente sia completata.
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		 for (int i = 0; i < activities.length; i++) {
			Activity activity = activities[i];
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					activity.perform();
				}
			};
			future = (Future<Integer>) executorService.submit(runnable);
		}
		
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
