import 'package:flutter/services.dart';

class MethodChannelDemoNativePlugin {

  MethodChannel methodChannel = const MethodChannel('demo_native_plugin');

  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod('methodApp');
    return version;
  }
}
