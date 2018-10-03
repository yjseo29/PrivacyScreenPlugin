/**
 * PrivacyScreenPlugin.java Cordova Plugin Implementation
 * Created by Tommy-Carlos Williams on 18/07/14.
 * Copyright (c) 2014 Tommy-Carlos Williams. All rights reserved.
 * MIT Licensed
 */
package org.devgeeks.privacyscreen;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.WindowManager;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

/**
 * This class sets the FLAG_SECURE flag on the window to make the app
 *  private when shown in the task switcher
 */
public class PrivacyScreenPlugin extends CordovaPlugin {

  private SharedPreferences sharedPref;

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {

    sharedPref = cordova.getActivity().getSharedPreferences("NativeStorage", Activity.MODE_PRIVATE);

    String privacy = sharedPref.getString("privacy", "false");

    if(privacy.equals("true")){
      super.initialize(cordova, webView);
      Activity activity = this.cordova.getActivity();
      activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
    }
  }
}
