import { NativeModules, Platform } from 'react-native';
const VideoDuration = NativeModules.VideoDurationModule;

export async function getVideoDuration(videoPath: String): Promise<Number> {
  const result = await VideoDuration.getVideoDuration(videoPath);
  if (result && result > 0) {
    return Platform.OS === 'android' ? result / 1000 : result;
  }
  return 0;
}
