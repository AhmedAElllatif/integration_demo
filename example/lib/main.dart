import 'package:demo_native_plugin/demo_native_plugin_method_channel.dart';
import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final MethodChannelDemoNativePlugin methodChannelDemoNativePlugin = MethodChannelDemoNativePlugin();

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: InkWell(
              onTap: (){
                try {
                   methodChannelDemoNativePlugin.getPlatformVersion();
                } on PlatformException {
                  return;
                }
              },
              child: const Text('click me')),
        ),
      ),
    );
  }
}
