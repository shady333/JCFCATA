# JCFCATA
Json Configuration File Creator for Automation Testing on Android

This application wil help you to automaticaly generate json files which is used in android automation.

The file looks like:
```
{
  "capabilities": [
    {
      "browserName": "Android",
      "version": "6.0.1",
                 "seleniumProtocol": "WebDriver",
      "platform": "ANDROID",
      "maxInstances": 1,
                 "udid": "DEVICE_UDID"
    }
  ],
  "configuration": {
    "cleanUpCycle": 2000,
    "timeout": 180000,
    "proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
    "url": "http://localhost:7777/wd/hub",
    "host": "localhost",
    "port": 7777,
    "maxSession": 1,
    "register": true,
    "registerCycle": 5000,
    "hubPort": 4444,
    "hubHost": "localhost"
  }
}
```
