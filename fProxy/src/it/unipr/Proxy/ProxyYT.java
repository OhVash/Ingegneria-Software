package it.unipr.Proxy;
/*
 * per salvare velocità di connesione, possiamo fare cache dei risultati delle richieste e tenerli per un po di tempo
 * delega il lavoro al servizio vero e proprio solo se necessario.
 */

import java.util.HashMap;
import java.util.Map;

public class ProxyYT implements ThirdPartyYoutubeLib {
	private ThirdPartyYoutubeLib service;
	private String listCache;
	private Map<String, String> videoCacheMap = new HashMap<>();
	private boolean needReset;
	
	public ProxyYT(ThirdPartyYoutubeLib service) {
		this.service = service;
	}
	@Override
	public String listsVideos() {
		if (listCache == null || needReset) {
			listCache = service.listsVideos();
			
		}
		return listCache;
	}
	@Override
	public String getVideoInfo(String id) {
		if(!videoCacheMap.containsKey(id) || needReset) {
			videoCacheMap.put(id, service.getVideoInfo(id));
			System.out.println("Requested data from service");
		} else {
			System.out.println("Reading data from cache");
		}
		return videoCacheMap.get(id);
		
	}
	@Override
	public void downloadVideo(String id) {
		if(!videoCacheMap.containsKey(id) || needReset) {
			service.downloadVideo(id);
			getVideoInfo(id);
		} else {
			System.out.println("Video: " + id + " is already downloaded.");
		}
	}
	
	public void resetCache() {
		needReset = true;
		listCache = null;
		videoCacheMap.clear();
		needReset = false;
	}
	

}