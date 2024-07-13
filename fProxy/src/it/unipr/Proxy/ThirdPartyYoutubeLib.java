package it.unipr.Proxy;

//interfaccia di un servizio rempoto.
public interface ThirdPartyYoutubeLib {
	String listsVideos();
	String getVideoInfo(String id);
	void downloadVideo(String id);

}
