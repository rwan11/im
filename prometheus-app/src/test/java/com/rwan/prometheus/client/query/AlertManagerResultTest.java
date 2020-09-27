package com.rwan.prometheus.client.query;

import com.rwan.prometheus.client.converter.ConvertUtil;
import com.rwan.prometheus.client.converter.am.AlertManagerResultItem;
import com.rwan.prometheus.client.converter.am.DefaultAlertManagerResult;
import junit.framework.TestCase;

public class AlertManagerResultTest extends TestCase {
		private String testAlertManagerData="{\"status\":\"success\",\"data\":{\"activeAlertmanagers\":[]}}";

	public void testParser() {
		DefaultAlertManagerResult result = ConvertUtil.convertAlertManagerResultString(testAlertManagerData);
		System.out.println("-----" +result.getResult().size());

		for(AlertManagerResultItem data : result.getResult()) {
			System.out.println("=======>\n" + data);
		}
	}
}
