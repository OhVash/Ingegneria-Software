package it.unipr.bridge;

public class Esempio1 {
	
	public void go () {
		Device tv = new Tv(); //device che effettua le operazioni
		RemoteControl remote = new RemoteControl(tv); //delega le operazioni all'implementazione device
		remote.togglePower();
		System.out.println(tv);
		
		remote.volumeUp();
		remote.channelUp();
		
		System.out.println(tv);
		
		Device radio = new Radio(); //device che effettua le operazioni
		AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(radio); //estende il remote con più funzionalità
		advancedRemote.togglePower();
		System.out.println(radio);
		
		advancedRemote.mute();
		System.out.println(radio);
		
		AdvancedRemoteControl advancedRemote2 = new AdvancedRemoteControl(tv);
		advancedRemote2.mute();
		System.out.println(tv);
		
		remote.togglePower();
		System.out.println(tv);
	}
	
	public static void main (String[] args) {
		new Esempio1().go();
	}

}
