//
//  MediaRetriverModule.swift
//  MediaInfo
//
//  Created by marco on 29/11/23.
//

import Foundation
import AVFoundation
import os.log


@objc(VideoDuration)
class VideoDuration: NSObject {
  
  @objc
  func getVideoDuration(_ param: URL, resolver resolve: @escaping RCTPromiseResolveBlock, rejecter reject: @escaping RCTPromiseRejectBlock) {
    do {
      let asset = AVURLAsset(url: param)
      let duration = asset.duration
      let durationTime = CMTimeGetSeconds(duration)
      resolve(durationTime)
    } catch {
      reject("ERROR_CODE", "An error occurred", error)
    }
}
  
  @objc
  static func requiresMainQueueSetup() -> Bool {
    return true
  }
}
