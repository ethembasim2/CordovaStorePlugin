/********* Store.m Cordova Plugin Implementation *******/

#import <Cordova/Store.h>

@implementation Store

- (void)redirectToStore:(CDVInvokedUrlCommand*)command
{
    [self.commandDelegate runInBackground:^{
        NSArray *args = command.arguments;
        NSString *appId = [args objectAtIndex:0];

        CDVPluginResult *pluginResult;
        if (appId) {
            NSString *url = [NSString stringWithFormat:@"itms-apps://itunes.apple.com/app/%@", appId];
            [[UIApplication sharedApplication] openURL:[NSURL URLWithString:url]];

            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
        } else {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Invalid application id: null was found"];
        }

        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }];
}

@end
