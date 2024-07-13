package it.unipr.bridge;
//L'implementazione dichiara metodi comuni a tutte le classi cocreteche la implementano.
//può differire dalla abstraction, tipicamente l'implementazione fornisce
//solo operazioni primitive, l'abstraction invece operazioni di più alto livello rispetto le primitive

public interface Device {
	boolean isEnabled();
	void enable();
	void disable();
	void setVolume(int percent);
	int getVolume();
	void setChannel(int channel);
	int getChannel();
}
