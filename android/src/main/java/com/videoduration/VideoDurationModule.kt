package com.videoduration

import android.media.MediaMetadataRetriever
import android.net.Uri
import android.provider.MediaStore
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import java.util.HashMap

class VideoDurationModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return "VideoDurationModule"
  }

  @ReactMethod
  fun getVideoDuration(uri: String, promise: Promise) {
    val retriever = MediaMetadataRetriever()
    try {
      val context = reactApplicationContext
      val videoUri = Uri.parse(uri)
      val dataSource = if (videoUri.scheme == "content") {
        MediaStore.Video.Media.EXTERNAL_CONTENT_URI
      } else {
        videoUri
      }
      retriever.setDataSource(context, videoUri)
      val duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
      retriever.release()
      if (duration != null) {
        promise.resolve(duration)
      } else {
        promise.reject("VIDEO_DURATION_ERROR", "Duration not available")
      }
    } catch (e: Exception) {
      promise.reject("VIDEO_DURATION_ERROR", e.message)
    }
  }


  companion object {
    const val NAME = "VideoDuration"
  }
}
