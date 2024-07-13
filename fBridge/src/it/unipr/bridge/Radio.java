package it.unipr.bridge;

public class Radio implements Device {
	
	private boolean on = false;
	private int volume = 20;
	private int channel = 1;
	@Override
	public boolean isEnabled() {
		return on;
	}
	@Override
	public void enable() {
		on = true;
		
	}
	@Override
	public void disable() {
		on = false;
	}
	@Override
	public void setVolume(int percent) {
		if (percent >= 0 && percent <=100) {
			volume = percent;
		}
		
	}
	@Override
	public int getVolume() {
		return volume;
	}
	@Override
	public void setChannel(int channel) {
		if (channel>0) {
			this.channel=channel;
		}
	}
	@Override
	public int getChannel() {
		return channel;
	}
	
	@Override
	public String toString() {
		return "Radio [power: " + on + ", volume: " + volume + ", channel: " + channel + "]";
				
	}
	


}