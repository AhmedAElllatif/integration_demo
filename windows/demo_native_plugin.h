#ifndef FLUTTER_PLUGIN_DEMO_NATIVE_PLUGIN_H_
#define FLUTTER_PLUGIN_DEMO_NATIVE_PLUGIN_H_

#include <flutter/method_channel.h>
#include <flutter/plugin_registrar_windows.h>

#include <memory>

namespace demo_native_plugin {

class DemoNativePlugin : public flutter::Plugin {
 public:
  static void RegisterWithRegistrar(flutter::PluginRegistrarWindows *registrar);

  DemoNativePlugin();

  virtual ~DemoNativePlugin();

  // Disallow copy and assign.
  DemoNativePlugin(const DemoNativePlugin&) = delete;
  DemoNativePlugin& operator=(const DemoNativePlugin&) = delete;

  // Called when a method is called on this plugin's channel from Dart.
  void HandleMethodCall(
      const flutter::MethodCall<flutter::EncodableValue> &method_call,
      std::unique_ptr<flutter::MethodResult<flutter::EncodableValue>> result);
};

}  // namespace demo_native_plugin

#endif  // FLUTTER_PLUGIN_DEMO_NATIVE_PLUGIN_H_
