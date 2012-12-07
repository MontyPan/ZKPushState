A ZK add-on for pushState.

### How to Setup? ###
* download [ZKPS.jar] and put it in WEB-INF/lib
* add this code block in your WEB-INF/zk.xml

		<listener>
			<listener-class>org.zkoss.pushState.PushStateDesktopInit</listener-class>
		</listener>
		<language-config>
			<addon-uri>/WEB-INF/pushState-addon.xml</addon-uri>
		</language-config>
		
* add a file name `pushState-addon.xml` in WEB-INF, the content is

		<?xml version="1.0" encoding="UTF-8"?>
		<language>
			<language-name>xhtml</language-name>
			<javascript>
			$(window).bind("popstate", function(event) {
				var preState = event.originalEvent.state;
				if (preState) {
					zAu.send(
						new zk.Event(
							null, 
							"onPopupState",
							preState
						)
					);
				}
			});
			</javascript>
		</language>
		
* start programming...  \囧/

### How to Use? ###
* Call `PushState.push()` will assign a new url and push a state of it.
* Select a component and add 'onPopupState' attribute.
* 

You can also run the [example.zul](example.zul).

### Reference ###
* [ZK-502]
* [Ashish's article]

[ZK-502]: http://tracker.zkoss.org/browse/ZK-502
[Ashish's article]: http://blog.zkoss.org/index.php/2012/03/30/history-management-with-html5-history-api-in-zk/