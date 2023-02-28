package com.live.deeplib.vpnmodule;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;

import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

import unified.vpn.sdk.CompletableCallback;
import unified.vpn.sdk.HydraTransportConfig;
import unified.vpn.sdk.OpenVpnTransportConfig;
import unified.vpn.sdk.SdkNotificationConfig;
import unified.vpn.sdk.TransportConfig;
import unified.vpn.sdk.UnifiedSdk;

public class MyApplication extends Application {
    private static final String CHANNELid = "vpn";

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(
                this,
                initializationStatus -> {
                });
        new AppOpenManager(this);
        AudienceNetworkAds.initialize(this);
        inithydra_Sdk();
    }

    private void inithydra_Sdk() {
        CreateNotification_Channel();
        List<TransportConfig> transportConfigList = new ArrayList<>();
        transportConfigList.add(HydraTransportConfig.create());
        transportConfigList.add(OpenVpnTransportConfig.tcp());
        transportConfigList.add(OpenVpnTransportConfig.udp());
        UnifiedSdk.update(transportConfigList, CompletableCallback.EMPTY);

        SdkNotificationConfig notificationConfig = SdkNotificationConfig.newBuilder()
                .title(getResources().getString(R.string.app_name))
                .channelId(CHANNELid)
                .build();
        UnifiedSdk.update(notificationConfig);

        UnifiedSdk.setLoggingLevel(Log.VERBOSE);
    }

    private void CreateNotification_Channel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int Importance = NotificationManager.IMPORTANCE_DEFAULT;
            String desc = "VPN Notification";
            CharSequence notification_name = "Sample VPN";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNELid, notification_name, Importance);
            notificationChannel.setDescription(desc);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
