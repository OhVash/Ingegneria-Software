package it.unipr.Proxy;
/*
 * Concreta implementazione del service.
 */
public class ThirdPartyYoutubeClass implements ThirdPartyYoutubeLib {

	@Override
	public String listsVideos() {
		// simulate api
		return "List of yt videos";
	}

	@Override
	public String getVideoInfo(String id) {
		// // simulate data
		return "Videos info: " + id;
	}

	@Override
	public void downloadVideo(String id) {
		// simulate downloading
		System.out.println("Downloading video: " + id + "...");
		
	}
	
	

}
