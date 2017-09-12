package org.example.xwalkembedded;

import android.os.Bundle;
import android.view.WindowManager;

import org.xwalk.core.XWalkView;

public class MainActivity extends XWalkCompatActivity {
    private static final String SITE_URL = "https://www.youtube.com/leanback";
    private XWalkView mXWalkView;

    @Override
    protected void onXWalkReady() {
        mXWalkView.loadUrl(SITE_URL);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mXWalkView = findViewById(R.id.xWalkView);
    }
}
