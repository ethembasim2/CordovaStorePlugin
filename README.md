# Cordova - Redirect to Store and Service Availability Check

This plugin is created to serve Huawei Mobile Services and Google Mobile Servies availability check on the Android platform and based on the availability of the platform redirect to store.


## Usage

1. Add plugin to your projects.

```sh
cordova plugin add https://github.com/ethembasim2/CordovaStorePlugin.git
```

2. Redirect to Store:

```javascript
cordova.plugins.Store.redirectToStore('YOUR_PACKAGE_NAME');
```
2. Redirect to Store by Service Availability:
```javascript
try{
    cordova.plugins.ServiceAvailability.checkAvailableService("", service => {
        if(service == 'GMS'){
            cordova.plugins.Store.redirectToStore('PACKAGE_NAME_GOOGLE');
        }
        else if(service == 'HMS'){
            cordova.plugins.Store.redirectToStore('PACKAGE_NAME_HUAWEI');
        }
    }, _err => {
        console.log('No Service Available');
    })
}
catch(_e) {
    console.log(JSON.stringify(_e, "\n", 4));
}
```