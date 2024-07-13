package it.unipr.abstractfactory;

public abstract class Company {
	
	public Gpu orderGpu() {
		Gpu gpu = createGpu();
		gpu.assemble();
		return gpu;
	}
	
	public Monitor orderMonitor() {
		Monitor monitor = createMonitor();
		monitor.assemble();
		return monitor;
	}

	public abstract Gpu createGpu();
	
	public abstract Monitor createMonitor();
}
