package it.unipr.bridge;

//L'astrazione definisce le interacce per il controllo
// mantiene il riferimento ad un oggetto dell'implementazione e gli delega il lavoro.

public class RemoteControl {
	
	protected Device device;
	
	public RemoteControl (Device device) {
		this.device = device;
	}
	
	public void togglePower() {
		if (device.isEnabled()) {
			device.disable();
		} else {
			device.enable();
		}
	}
	
	public void volumeDown() {
		device.setVolume(device.getVolume()-10);
	}
	
	public void volumeUp() {
		device.setVolume(device.getVolume()+10);
	}
	
	public void channelDown() {
		device.setChannel(device.getChannel()-1);
	}
	
	public void channelUp() {
		device.setChannel(device.getChannel()+1);
	}
}
