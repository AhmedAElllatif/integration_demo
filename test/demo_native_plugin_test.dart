import 'package:flutter_test/flutter_test.dart';
import 'package:demo_native_plugin/demo_native_plugin.dart';
import 'package:demo_native_plugin/demo_native_plugin_platform_interface.dart';
import 'package:demo_native_plugin/demo_native_plugin_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockDemoNativePluginPlatform
    with MockPlatformInterfaceMixin
    implements DemoNativePluginPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final DemoNativePluginPlatform initialPlatform = DemoNativePluginPlatform.instance;

  test('$MethodChannelDemoNativePlugin is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelDemoNativePlugin>());
  });

  test('getPlatformVersion', () async {
    DemoNativePlugin demoNativePlugin = DemoNativePlugin();
    MockDemoNativePluginPlatform fakePlatform = MockDemoNativePluginPlatform();
    DemoNativePluginPlatform.instance = fakePlatform;

    expect(await demoNativePlugin.getPlatformVersion(), '42');
  });
}
