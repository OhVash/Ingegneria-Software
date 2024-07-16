package it.unipr.esame24062024;

public class Main {
	public static void main(String[] args) {
		Launcher mainLauncher = LauncherSingleton.getInstance();
		Job job = new JobImpl();
		
		for(int i = 0; i<100; i++) {
			mainLauncher.activate(job);
		}
	}
}
