package com.sk.flutter_hot_fix;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;


//import com.idlefish.flutterboost.FlutterBoost;
//import com.idlefish.flutterboost.Platform;
//import com.idlefish.flutterboost.Utils;
//import com.idlefish.flutterboost.interfaces.INativeRouter;
import androidx.multidex.MultiDexApplication;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import java.util.Map;

import io.flutter.FlutterInjector;
import io.flutter.app.FlutterApplication;
import io.flutter.embedding.android.FlutterView;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.FlutterMain;

/**
 * |                   quu..__
 * |                    $$  `---.__
 * |                     "$        `--.                          ___.---uuudP
 * |                      `$           `.__.------.__     __.---'      $$$$"              .
 * |                        "          -'            `-.-'            $$$"              .'|
 * |                          ".                                       d$"             _.'  |
 * |                            `.   /                              ..."             .'     |
 * |                              `./                           ..::-'            _.'       |
 * |                               /                         .:::-'            .-'         .'
 * |                              :                          ::''\          _.'            |
 * |                             .' .-.             .-.           `.      .'               |
 * |                             : /'$$|           .@"$\           `.   .'              _.-'
 * |                            .'|$$|          |$$,$$|           |  <            _.-'
 * |                            | `:$$:'          :$$$$$:           `.  `.       .-'
 * |                            :                  `"--'             |    `-.     \
 * |                           :$$.       ==             .$$$.       `.      `.    `\
 * |                           |$$:                      :$$$:        |        >     >
 * |                           |$'     `..'`..'          `$$$'        x:      /     /
 * |                            \                                   xXX|     /    ./
 * |                             \                                xXXX'|    /   ./
 * |                             /`-.                                  `.  /   /
 * |                            :    `-  ...........,                   | /  .'
 * |                            |         ``:::::::'       .            |<    `.
 * |                            |             ```          |           x| \ `.:``.
 * |                            |                         .'    /'   xXX|  `:`M`M':.
 * |                            |    |                    ;    /:' xXXX'|  -'MMMMM:'
 * |                            `.  .'                   :    /:'       |-'MMMM.-'
 * |                             |  |                   .'   /'        .'MMM.-'
 * |                             `'`'                   :  ,'          |MMM<
 * |                               |                     `'            |tbap\
 * |                                \                                  :MM.-'
 * |                                 \                 |              .''
 * |                                  \.               `.            /
 * |                                   /     .:::::::.. :           /
 * |                                  |     .:::::::::::`.         /
 * |                                  |   .:::------------\       /
 * |                                 /   .''               >::'  /
 * |                                 `',:                 :    .'
 * |
 * |                                                      `:.:'
 * |
 * |
 * |
 *
 * @author SK on 2020/6/18
 */


public class AppApplication extends FlutterApplication {


    // ??????sophix???????????????attachBaseContext
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Beta.installTinker();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(this, "34c01a08f1", true);
    }

    //??????flutterboost
//    private void initFlutterBoost() {
//        INativeRouter router =new INativeRouter() {
//            @Override
//            public void openContainer(Context context, String url, Map<String, Object> urlParams, int requestCode, Map<String, Object> exts) {
//                String  assembleUrl= Utils.assembleUrl(url,urlParams);
//            }
//
//        };
//
//        FlutterBoost.BoostLifecycleListener boostLifecycleListener= new FlutterBoost.BoostLifecycleListener(){
//
//            @Override
//            public void beforeCreateEngine() {
//
//            }
//
//            @Override
//            public void onEngineCreated() {
//
//                // ??????MethodChannel?????????flutter??????getPlatformVersion??????
//                MethodChannel methodChannel = new MethodChannel(FlutterBoost.instance().engineProvider().getDartExecutor(), "flutter_native_channel");
//                methodChannel.setMethodCallHandler((call, result) -> {
//
//                    if (call.method.equals("getPlatformVersion")) {
//                        result.success(Build.VERSION.RELEASE);
//                    } else {
//                        result.notImplemented();
//                    }
//
//                });
//
//                // ??????PlatformView viewTypeId??????flutter??????viewType??????
////                FlutterBoost
////                        .instance()
////                        .engineProvider()
////                        .getPlatformViewsController()
////                        .getRegistry()
////                        .registerViewFactory("plugins.test/view", new TextPlatformViewFactory(StandardMessageCodec.INSTANCE));
//
//            }
//
//            @Override
//            public void onPluginsRegistered() {
//
//            }
//
//            @Override
//            public void onEngineDestroy() {
//
//            }
//
//        };
//
//        //
//        // AndroidManifest.xml ?????????????????? flutterEmbedding ????????????
//        //
//        //   <meta-data android:name="flutterEmbedding"
//        //               android:value="2">
//        //    </meta-data>
//        // GeneratedPluginRegistrant ??????????????? ?????????????????????
//        //
//        // ???????????????????????????
//        // FlutterBoost.instance().engineProvider().getPlugins().add(new FlutterPlugin());
//        // GeneratedPluginRegistrant.registerWith()?????????engine ??????????????????????????????????????????
//        //
//
//        Platform platform= new FlutterBoost
//                .ConfigBuilder(this,router)
//                .isDebug(true)
//                .whenEngineStart(FlutterBoost.ConfigBuilder.ANY_ACTIVITY_CREATED)
//                .renderMode(FlutterView.RenderMode.texture)
//                .lifecycleListener(boostLifecycleListener)
//                .build();
//        FlutterBoost.instance().init(platform);
//    }
}
