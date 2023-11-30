#import <Foundation/Foundation.h>

#import "React/RCTBridgeModule.h"
@interface
RCT_EXTERN_MODULE(VideoDuration, NSObject)
RCT_EXTERN_METHOD(getVideoDuration:
   (NSURL *) param
   resolver:(RCTPromiseResolveBlock) resolve
   rejecter:(RCTPromiseRejectBlock)reject
)
@end
