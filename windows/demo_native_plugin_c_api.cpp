#include "include/demo_native_plugin/demo_native_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "demo_native_plugin.h"

void DemoNativePluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  demo_native_plugin::DemoNativePlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
