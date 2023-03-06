package com.live.deeplib.vpnmodule;

import static com.live.deeplib.vpnmodule.AppPreference.isFullScreenShow;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.live.deeplib.vpnmodule.AppPreference;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Interstitial_Ads_SplashBack {
    private InterstitialAd mInterstitialAd_admob;
    private AdManagerInterstitialAd adManagerInterstitialAd;

    public void Show_Ads(Activity source_class) {

        AppPreference appPreference = new AppPreference(source_class);
        if(appPreference.getBackflag().equals("on") && Constant.Back_Counter % Integer.parseInt(appPreference.getBackcount()) == 0)  {
            if (appPreference.get_Ad_Flag().equals("admob")) {
                Show_AdsAdmob(source_class);
            } else
                Show_AdsAdx(source_class);
        }
        else{
            source_class.finish();
        }
        Constant.Back_Counter++;
    }

    public void Show_AdsAdmob(Activity source_class) {
        AppPreference preference = new AppPreference(source_class);
        if (preference.get_Ad_Status().equalsIgnoreCase("on") && preference.isConnected()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(source_class, preference.get_Splash_Interstitial_Id(), adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    mInterstitialAd_admob = interstitialAd;
                    mInterstitialAd_admob.show(source_class);
                    mInterstitialAd_admob.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            mInterstitialAd_admob = null;
                            isFullScreenShow = false;
                            source_class.finish();

                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            super.onAdShowedFullScreenContent();
                            mInterstitialAd_admob = null;
                            isFullScreenShow = true;

                        }

                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            isFullScreenShow = false;

                            source_class.finish();

                        }

                        @Override
                        public void onAdImpression() {
                            super.onAdImpression();
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    mInterstitialAd_admob = null;
                    isFullScreenShow = false;

                    source_class.finish();

                }
            });
        } else {

            source_class.finish();

        }
    }

    public void Show_AdsAdx(Activity source_class) {
        AppPreference preference = new AppPreference(source_class);
        if (preference.get_Ad_Status().equalsIgnoreCase("on") && preference.isConnected()) {
            AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            AdManagerInterstitialAd.load(source_class, preference.get_Splash_Interstitial_Id(), adRequest, new AdManagerInterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                    adManagerInterstitialAd = interstitialAd;
                    adManagerInterstitialAd.show(source_class);
                    adManagerInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            adManagerInterstitialAd = null;
                            isFullScreenShow = false;


                            source_class.finish();
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            super.onAdShowedFullScreenContent();
                            adManagerInterstitialAd = null;
                            isFullScreenShow = true;

                        }

                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            isFullScreenShow = false;


                            source_class.finish();
                        }

                        @Override
                        public void onAdImpression() {
                            super.onAdImpression();
                        }
                    });
                }


                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    adManagerInterstitialAd = null;
                    isFullScreenShow = false;


                    source_class.finish();
                }
            });
        } else {

            source_class.finish();
        }
    }

}