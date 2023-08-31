package com.example.demo_native_plugin;

import android.Manifest;
import android.net.Uri;
import android.util.Log;


import java.util.Objects;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** DemoNativePlugin */
public class DemoNativePlugin extends AppCompatActivity implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    Log.e("Start Launch" , "OK");

    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "demo_native_plugin");
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    Log.e("Start Launch" , "OK");
    if (call.method.equals("methodApp")) {
      // Here sample code
      ActivityResultLauncher<String> activityResultLauncherTest = registerForActivityResult(
              new ActivityResultContracts.RequestPermission(),
              new ActivityResultCallback<Boolean>() {
                @Override
                public void onActivityResult(Boolean result) {

                }
              }
      );

      /// Another Example
      /*
            ActivityResultLauncher<String> mGetContent =
              registerForActivityResult(new ActivityResultContracts.GetContent(),
              uri -> {
                // Handle the returned Uri
              });
       */


      try {
        // problem here in this line when launch
        activityResultLauncherTest.launch(Manifest.permission.CAMERA);
        // Another Example
        // mGetContent.launch("image/*");


      }catch (Exception e){
        Log.e("Exception" , Objects.requireNonNull(e.getLocalizedMessage()));
      }

      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
