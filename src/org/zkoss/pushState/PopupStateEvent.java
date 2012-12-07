package org.zkoss.pushState;

import java.util.Map;

import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.event.Event;

@SuppressWarnings("serial")
public class PopupStateEvent extends Event {
	private final Map<String, Object> _state;
	
	public PopupStateEvent(String name, Map<String, Object> state) {
		super(name);
		this._state = state;
	}
	
	public Map<String, Object> getState() {
		return _state;
	}


	public static PopupStateEvent getPopupStateEvent(AuRequest request) {
		return new PopupStateEvent(request.getCommand(), request.getData());
	}
}
