package org.zkoss.pushState;

import java.util.Map;

import org.zkoss.json.JSONValue;
import org.zkoss.zk.ui.util.Clients;

public class PushState {
	/**
	 * A ZK wrapper of JS <code>history.pushState()</code>.
	 * @param state The state of new url.
	 * @param title The browser title, but most browser does not implement.
	 * @param url New url. 
	 */
	public static void push(Map<String, Object> state, String title, String url) {
		StringBuffer js = new StringBuffer("history.pushState(");
		js.append(JSONValue.toJSONString(state));
		js.append(",'");
		js.append(title);
		js.append("','");
		js.append(url);
		js.append("')");
		Clients.evalJavaScript(js.toString());
	}
}