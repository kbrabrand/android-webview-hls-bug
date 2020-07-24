package com.example.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private WebView mWebView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.loadData("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width\">\n" +
                "  <title>JS Bin</title>\n" +
                "  <link href=\"https://vjs.zencdn.net/7.6.5/video-js.css\" rel=\"stylesheet\">\n" +
                "  <script src=\"https://vjs.zencdn.net/7.6.5/video.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div id=\"version\"></div>\n" +
                "  <video-js controls>\n" +
                "    <source src=\"https://stream.mux.com/XQbmVjPSu02s9IdToMDULqtDoSYauU02EI.m3u8\" />\n" +
                "  </video-js>\n" +
                "  \n" +
                "  <script>\n" +
                "    videojs(document.querySelector('video-js'), {\n" +
                "      autoplay: true,\n" +
                "      loop: true,\n" +
                "      muted: true,\n" +
                "      controls: true,\n" +
                "      html5: {\n" +
                "        loop: true," +
                "        muted: true," +
                "        autoplay: true," +
                "        hls: {\n" +
                "          overrideNative: !videojs.browser.IS_SAFARI,\n" +
                "        }\n" +
                "      }\n" +
                "    }, function yo() {\n" +
                "      document.getElementById('version').innerHTML = navigator.userAgent;\n" +
                "    })\n" +
                "  </script>\n" +
                "</body>\n" +
                "</html>", "text/html", "utf8");
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
