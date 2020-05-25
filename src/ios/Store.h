//
// Created by e00747641 on 5/25/2020.
//

#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>

@interface Market : CDVPlugin

- (void)redirectToStore:(CDVInvokedUrlCommand *)command;

@end
