package com.rwan.prometheus.client.converter.am;


public class AlertManagerResultItem {

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "AlertManagerResultItem [url=" + url + "]";
	}


}
