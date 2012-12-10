A ZK add-on for pushState. 

It base on [Ashish's article], but provide a Java wrapper,
so you don't need write any JavaScript code.

### How to Setup? ###
* download [ZKPS.jar] and put it in `WEB-INF/lib`
* add this code block in your `WEB-INF/zk.xml`

		<listener>
			<listener-class>org.zkoss.pushState.PushStateDesktopInit</listener-class>
		</listener>
		<language-config>
			<addon-uri>/WEB-INF/pushState-addon.xml</addon-uri>
		</language-config>
		
* add a file name `pushState-addon.xml` in `WEB-INF`, the content is

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
* When browser's history changed, 'onPopupState' will be invoke and get a `PopupStateEvent`.
  you can use `event.getState()` (in Java) or `event.state` (in ZUL) to get the state pushed before.

You can also test the `index.zul` or `simpleText.zul` code.

Any feedback is wellcome \囧/

### Reference ###
* [ZK-502]
* [Ashish's article]

[ZKPS.jar]: https://github.com/downloads/MontyPan/ZKPushState/ZKPS.jar
[ZK-502]: http://tracker.zkoss.org/browse/ZK-502
[Ashish's article]: http://blog.zkoss.org/index.php/2012/03/30/history-management-with-html5-history-api-in-zk/