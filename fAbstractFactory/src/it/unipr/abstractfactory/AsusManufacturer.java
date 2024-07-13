package it.unipr.abstractfactory;

public class AsusManufacturer extends Company {

	@Override
	public Gpu createGpu() {
		return new AsusGpu();
	}

	@Override
	public Monitor createMonitor() {
		return new AsusMonitor();
	}
	

}
