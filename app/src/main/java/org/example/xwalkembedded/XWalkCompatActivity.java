package org.example.xwalkembedded;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.xwalk.core.XWalkActivityDelegate;
import org.xwalk.core.XWalkDialogManager;

/**
 * AppCompat version of XWalkActivity
 */

public abstract class XWalkCompatActivity extends AppCompatActivity {
    private XWalkActivityDelegate mActivityDelegate;

    protected abstract void onXWalkReady();

    protected void onXWalkFailed() {
        this.finish();
    }

    protected XWalkDialogManager getDialogManager() {
        return this.mActivityDelegate.getDialogManager();
    }

    public boolean isXWalkReady() {
        return this.mActivityDelegate.isXWalkReady();
    }

    public boolean isSharedMode() {
        return this.mActivityDelegate.isSharedMode();
    }

    public boolean isDownloadMode() {
        return this.mActivityDelegate.isDownloadMode();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Runnable cancelCommand = new Runnable() {
            public void run() {
                XWalkCompatActivity.this.onXWalkFailed();
            }
        };
        Runnable completeCommand = new Runnable() {
            public void run() {
                XWalkCompatActivity.this.onXWalkReady();
            }
        };
        this.mActivityDelegate = new XWalkActivityDelegate(this, cancelCommand, completeCommand);
    }

    protected void onResume() {
        super.onResume();
        this.mActivityDelegate.onResume();
    }
}
