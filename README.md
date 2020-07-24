This is a reproduction of a bug with the Android WebView and HLS playback. [Bug report](https://issuetracker.google.com/issues/162013007) in the Google issue tracker.

### Running the example project

1. Download the project folder
2. Open it in Android Studio 4
3. Run on a [physical or virtual] device

### Bug description
The application has a single activity with a WebView in it. It shows an HTML page with a video in it, loading from an HLS stream.

After the manifest has loaded, the playback starts and the player shows the scrobbler sliding along and the correct remaining time of the video.

When testing the same HTML page in Chrome on the same emulator device the video plays back just fine. Below is a table of the emulators I've tried and the results.

The standalone HTML version can be found here: https://stream-test.vercel.app.

### Observations
A warning/error that is printed a lot to the console during playback is

```
E/eglCodecCommon: glUtilsParamSize: unknow param 0x000085b5
```

It is printed for all of the versions that are failing, **but also** when running on API version 26 (which is working).

#### Version information / test table
| Target   | CPU/ABI | API | Reported UA (in app) | in-app OK | Chrome OK |
|----------|:-------:|----:|--------------------:|----------:|----------:|
| Android 6.0 (Google APIs) | x86 | 23 | Mozilla/5.0 (Linux; Android 6.0; Android SDK built for x86 Build/MASTER; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/44.0.2403.119 Mobile Safari/537.36 | ❌ | ✅ |
| Android 7.0 (Google APIs) | x86 | 24 | Mozilla/5.0 (Linux; Android 7.0; Android SDK built for x86 Build/NYC; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/69.0.3497.100 Mobile Safari/537.36 | ❌ | ✅ |
| Android 7.1.1 (Google APIs) | x86 | 25 | Mozilla/5.0 (Linux; Android 7.1.1; Android SDK built for x86 Build/NYC; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/69.0.3497.100 Mobile Safari/537.36 | ❌ | ✅ |
| Android 8.0 (Google APIs) | x86 | 26 | Mozilla/5.0 (Linux; Android 8.0.0; Android SDK built for x86 Build/OSR1.180418.024; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/69.0.3497.100 Mobile Safari/537.36 | ✅ | ✅ |
| Android 8.1 (Google APIs) | x86 | 27 | Mozilla/5.0 (Linux; Android 8.1.0; Android SDK built for x86 Build/OSM1.180201.031; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/69.0.3497.100 Mobile Safari/537.36 | ❌ | ✅ |
| Android 9.0 (Google APIs) | x86_64 | 28 | Mozilla/5.0 (Linux; Android 9; Android SDK built for x86_64 Build/PSR1.180720.120; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/69.0.3497.100 Mobile Safari/537.36 | ✅ | ✅ |
| Android 10.0 (Google APIs) | x86 | 29 | Mozilla/5.0 (Linux; Android 10; Android SDK built for x86 Build/QSR1.200403.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/74.0.3729.185 Mobile Safari/537.36 | ✅ | ✅ |
| Android 11.0 (Google APIs) | x86 | 30 | Mozilla/5.0 (Linux; Android 11; sdk_gphone_x86_arm Build/RPB2.200611.012; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/83.0.4103.101 Mobile Safari/537.36 | ✅ | ✅ |
| Android 11.0 (Google Play) | x86 | R | Mozilla/5.0 (Linux; Android 10.0.99; Build/RPP1.200123.017; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/80.0.3987.9 Mobile Safari/537.36 | ✅ | ✅ |


### Expected behavior
Since the videos are playing without problems on the stock browser for all the API versions above I did expect them to work inside the WebView as well.

Also, the stream working in version 26 and 28 and above, but not in version 27 is weird.