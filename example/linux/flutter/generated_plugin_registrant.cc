//
//  Generated file. Do not edit.
//

// clang-format off

#include "generated_plugin_registrant.h"

#include <demo_native_plugin/demo_native_plugin.h>

void fl_register_plugins(FlPluginRegistry* registry) {
  g_autoptr(FlPluginRegistrar) demo_native_plugin_registrar =
      fl_plugin_registry_get_registrar_for_plugin(registry, "DemoNativePlugin");
  demo_native_plugin_register_with_registrar(demo_native_plugin_registrar);
}
