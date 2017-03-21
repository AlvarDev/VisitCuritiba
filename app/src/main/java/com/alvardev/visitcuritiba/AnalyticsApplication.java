package com.alvardev.visitcuritiba;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;

import com.google.android.gms.analytics.Tracker;

/**
 * Created by alvardev on 21/03/17.
 * AnalyticsApplication
 */

public class AnalyticsApplication extends Application{

    private Tracker mTracker;

    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker("UA-94100854-1");
        }
        return mTracker;
    }
}
