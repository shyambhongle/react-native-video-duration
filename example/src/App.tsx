import * as React from 'react';

import { StyleSheet, Text, Pressable } from 'react-native';
import { getVideoDuration } from 'react-native-video-duration';

export default function App() {
  const onPressHandler = () => {
    console.log(getVideoDuration);
  };
  return (
    <Pressable style={styles.container} onPress={onPressHandler}>
      <Text>Test Package Linked</Text>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
