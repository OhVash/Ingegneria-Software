package it.unipr.Proxy;

public class App {
	public void go() {
		ThirdPartyYoutubeLib aYTservice = new ThirdPartyYoutubeClass();
		ThirdPartyYoutubeLib aYTProxy = new ProxyYT(aYTservice);
		YTManager manager = new YTManager(aYTProxy);

		manager.reactOnUserInput("123");
		manager.reactOnUserInput("124");
		
		aYTProxy.downloadVideo("234");
		aYTProxy.downloadVideo("234");
		aYTProxy.downloadVideo("234");
		
		manager.reactOnUserInput("12322");
	}
	
	public static void main(String[] args) {
		new App().go();
	}

}
