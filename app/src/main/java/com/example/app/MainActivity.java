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

        // A simpler example yielding the same result, without the videojs stuff.
        /*
        mWebView.loadData("" +
                "<html>" +
                "   <body>" +
                "       <video " +
                "           style=\"max-width:100%\" " +
                "           autoplay " +
                "           controls " +
                "           muted " +
                "           loop " +
                "           src=\"https://stream.mux.com/XQbmVjPSu02s9IdToMDULqtDoSYauU02EI.m3u8\"" +
                "       >" +
                "   </body>" +
                "</html>", "text/html", "utf8"
        );
        */

        mWebView.loadData("" +
                "<!DOCTYPE html>\n" +
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
                "    <source src=\"https://stream.mux.com/XQbmVjPSu02s9IdToMDULqtDoSYauU02EI.m3u8\" type=\"application/x-mpegURL\"/>\n" +
                "  </video-js>\n" +
                "  \n" +
                "  <script>\n" +
                "    videojs(document.querySelector('video-js'), {\n" +
                "      autoplay: true,\n" +
                "      loop: true,\n" +
                "      muted: true,\n" +
                "      controls: true,\n" +
                "      html5: {\n" +
                "        hls: {\n" +
                "          overrideNative: !videojs.browser.IS_SAFARI,\n" +
                "        }\n" +
                "      }\n" +
                "    }, function yo() {\n" +
                "      document.getElementById('version').innerHTML = navigator.userAgent;\n" +
                "    })\n" +
                "  </script>\n" +
                "</body>\n" +
                "</html>", "text/html", "utf8"
        );
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
