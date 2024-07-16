package it.unipr.ingsw.concurrency.esame090224;

public interface Resource {
	public int getID();
	public int use();
	public void release();
}
