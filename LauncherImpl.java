package it.unipr.ingsw.concurrency.esame062224;

public class LauncherImpl implements Launcher {

	@Override
	public void execute(Runnable runnable) {
		Thread t = new Thread(runnable);
		t.start();
	}

}
