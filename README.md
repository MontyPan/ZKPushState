A ZK add-on for pushState. 

It base on [Ashish's article], but provide a Java wrapper,
so you don't need write any JavaScript code.

### How to Setup? ###
* Download [ZKPS.jar] and put it in `WEB-INF/lib`		
* Start programming...  \囧/

### How to Use? ###
* Call `PushState.push()` will assign a new url and push a state of it.
* When browser's history changed, 'onPopupState' will be invoke and get a `PopupStateEvent`.
  you can use `event.getState()` (in Java) or `event.state` (in ZUL) to get the state pushed before.

You can also test the `index.zul` or `simpleText.zul` code.

Any feedback is wellcome \囧/

### Support ZK Version ###
* ZK 6.0
* ZK 6.5

### Reference ###
* [ZK-502]
* [Ashish's article]

[ZKPS.jar]: http://zkpushstate.googlecode.com/files/ZKPS.jar
[ZK-502]: http://tracker.zkoss.org/browse/ZK-502
[Ashish's article]: http://blog.zkoss.org/index.php/2012/03/30/history-management-with-html5-history-api-in-zk/