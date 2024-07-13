package it.unipr.bridge;

//si può estendere la classe abstraction

public class AdvancedRemoteControl extends RemoteControl {
	public AdvancedRemoteControl (Device device) {
		super(device);
	}
	
	public void mute() {
		device.setVolume(0);
	}
}
