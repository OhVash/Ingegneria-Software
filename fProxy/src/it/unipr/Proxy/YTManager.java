package it.unipr.Proxy;

public class YTManager {
	protected ThirdPartyYoutubeLib service;
	
	public YTManager(ThirdPartyYoutubeLib service) {
		this.service = service;
	}
	
	public void renderVideoPage(String id) {
		String info = service.getVideoInfo(id);
		System.out.println("Rendering video page for " + info);
	}
	
	public void renderListPanel() {
		String list = service.listsVideos();
		System.out.println("Rendering list of videos: " + list);
	}
	
	public void reactOnUserInput(String videoId) {
		renderVideoPage(videoId);
		renderListPanel();
	}

}
