package com.live.deeplib.vpnmodule;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.NativeAd;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Native_Ads_Preload_1 {
    public static Context context;
    public static AppPreference preference;
    public static Native_Ads_Preload_1 mInstance;

    com.google.android.gms.ads.nativead.NativeAd nativeBannerAd1;


    public Native_Ads_Preload_1(Context activity) {
        context = activity;
        preference = new AppPreference(activity);

    }

    public static Native_Ads_Preload_1 getInstance(Context mContext) {
        context = mContext;
        preference = new AppPreference(mContext);
        if (mInstance == null) {
            mInstance = new Native_Ads_Preload_1(mContext);
        }
        return mInstance;
    }

    private static AdSize getAdSize(Context context) {
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;
        int adWidth = (int) (widthPixels / density);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adWidth);
    }

    public void addNativeAd(ViewGroup viewGroup, boolean isList) {
        new Native_Ads_Static(context).Native_Ads(viewGroup);
        String type = isList ? new AppPreference(context).getNativeTypeList() : new AppPreference(context).getNativeTypeOther();
        switch (type) {
            case "banner":
                Native_Banner_Ads(viewGroup);
                break;

            case "small":
                Native_Small_Ads(viewGroup);
                break;

            case "medium":
                Native_Medium_Size(viewGroup);
                break;

            case "large":
                Native_Large_Size(viewGroup);
                break;
        }
    }


    public void Native_Banner_Ads(final ViewGroup viewGroup) {
        NativeAd nativeAd = Native_Ads_Load.getNextNativeAd();
        if (nativeAd != null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.am_activity_native_ads_temp, viewGroup, false);
            final TemplateView templateView = inflate.findViewById(R.id.my_template_small);
            inflate.findViewById(R.id.my_template_small).setVisibility(View.GONE);
            templateView.setVisibility(View.GONE);
            NativeTemplateStyle build = new NativeTemplateStyle.Builder().build();
            templateView.setVisibility(View.VISIBLE);
            templateView.setStyles(build);
            templateView.setNativeAd(nativeAd);
            Button button = templateView.findViewById(R.id.cta);
            String a = preference.getAdbtcolor();
            button.setBackgroundColor(Color.parseColor("#" + a));
            viewGroup.setVisibility(View.VISIBLE);
            viewGroup.removeAllViews();
            viewGroup.addView(inflate);

        } else {
            viewGroup.setVisibility(View.GONE);
            Qureka_Predchamp_Native_Banner(viewGroup);
        }
    }

    public void Native_Small_Ads(final ViewGroup viewGroup) {
        NativeAd nativeAd = Native_Ads_Load.getNextNativeAd();
        if (nativeAd != null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.am_activity_native_ads_temp1, viewGroup, false);
            final TemplateView templateView = inflate.findViewById(R.id.my_template_small);
            inflate.findViewById(R.id.my_template_small).setVisibility(View.GONE);
            templateView.setVisibility(View.GONE);
            NativeTemplateStyle build = new NativeTemplateStyle.Builder().build();
            templateView.setVisibility(View.VISIBLE);
            templateView.setStyles(build);
            templateView.setNativeAd(nativeAd);
            Button button = templateView.findViewById(R.id.cta);
            String a = preference.getAdbtcolor();
            button.setBackgroundColor(Color.parseColor("#" + a));
            viewGroup.setVisibility(View.VISIBLE);
            viewGroup.removeAllViews();
            viewGroup.addView(inflate);

        } else {
            viewGroup.setVisibility(View.GONE);
            Qureka_Predchamp_Native_Banner(viewGroup);
        }
    }

    public void Native_Medium_Size(final ViewGroup viewGroup) {
        NativeAd nativeAd = Native_Ads_Load.getNextNativeAd();
        if (nativeAd != null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.am_activity_native_ads_temp1, viewGroup, false);
            final TemplateView templateView = inflate.findViewById(R.id.my_template_large);
            inflate.findViewById(R.id.my_template_small).setVisibility(View.GONE);
            templateView.setVisibility(View.GONE);
            NativeTemplateStyle build = new NativeTemplateStyle.Builder().build();
            templateView.setVisibility(View.VISIBLE);
            templateView.setStyles(build);
            templateView.setNativeAd(nativeAd);
            Button button = templateView.findViewById(R.id.cta);
            String a = preference.getAdbtcolor();
            button.setBackgroundColor(Color.parseColor("#" + a));
            viewGroup.removeAllViews();
            viewGroup.addView(inflate);


        } else {
            viewGroup.setVisibility(View.GONE);
            Qureka_Predchamp_Native(viewGroup);
        }
    }

    public void Native_Large_Size(final ViewGroup viewGroup) {
        NativeAd nativeAd = Native_Ads_Load.getNextNativeAd();
        if (nativeAd != null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.am_activity_native_ads_temp, viewGroup, false);
            final TemplateView templateView = inflate.findViewById(R.id.my_template_large);
            inflate.findViewById(R.id.my_template_small).setVisibility(View.GONE);
            templateView.setVisibility(View.GONE);
            NativeTemplateStyle build = new NativeTemplateStyle.Builder().build();
            templateView.setVisibility(View.VISIBLE);
            templateView.setStyles(build);
            templateView.setNativeAd(nativeAd);
            Button button = templateView.findViewById(R.id.cta);
            String a = preference.getAdbtcolor();
            button.setBackgroundColor(Color.parseColor("#" + a));
            viewGroup.removeAllViews();
            viewGroup.addView(inflate);


        } else {
            viewGroup.setVisibility(View.GONE);
            Qureka_Predchamp_Native(viewGroup);
        }
    }

    private void Qureka_Predchamp_Native(final ViewGroup BannerContainer) {
        if (preference.get_Ad_Status().equalsIgnoreCase("on")) {
            if (preference.get_Qureka_Flag().equalsIgnoreCase("qureka")) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_qureka_native_ads, null, false);
                Random r = new Random();
                int i1 = r.nextInt(4 + 1);
                ((ImageView) view.findViewById(R.id.img_banner)).setImageResource(Constant.qureka_native[i1]);
                ((TextView) view.findViewById(R.id.tv_appname)).setText(Constant.qureka_header[i1]);
                ((TextView) view.findViewById(R.id.tv_desc)).setText(Constant.qureka_description[i1]);
                Glide.with(context).load(Constant.qureka_icon[i1]).into((ImageView) view.findViewById(R.id.img_logo));
                view.findViewById(R.id.btn_install).setOnClickListener(v -> Constant.Open_Qureka(context));
                BannerContainer.removeAllViews();
                BannerContainer.addView(view);
            } else if (preference.get_Qureka_Flag().equalsIgnoreCase("predchamp")) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_qureka_native_ads, null, false);
                Random r = new Random();
                int i1 = r.nextInt(4 + 1);
                Glide.with(context).load(Constant.predchamp_icon[i1]).into((ImageView) view.findViewById(R.id.img_logo));
                ((TextView) view.findViewById(R.id.tv_appname)).setText(Constant.predchamp_header[i1]);
                ((TextView) view.findViewById(R.id.tv_desc)).setText(Constant.predchamp_description[i1]);
                ((ImageView) view.findViewById(R.id.img_banner)).setImageResource(Constant.predchamp_native[i1]);
                view.findViewById(R.id.btn_install).setOnClickListener(v -> Constant.Open_Qureka(context));
                BannerContainer.removeAllViews();
                BannerContainer.addView(view);
            } else {
                new Native_Ads_Static(context).Native_Ads(BannerContainer);
            }
        }
    }

    private void Qureka_Predchamp_Native_Banner(final ViewGroup BannerContainer) {
        if (preference.get_Ad_Status().equalsIgnoreCase("on")) {

            if (preference.get_Qureka_Flag().equalsIgnoreCase("qureka")) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_qureka_native_banner_ads, null, false);
                Random r = new Random();
                int i1 = r.nextInt(4 + 1);
                ((TextView) view.findViewById(R.id.tv_appname)).setText(Constant.qureka_header[i1]);
                ((TextView) view.findViewById(R.id.tv_desc)).setText(Constant.qureka_description[i1]);
                Glide.with(context).load(Constant.qureka_icon[i1]).into((ImageView) view.findViewById(R.id.img_logo));
                view.findViewById(R.id.btn_install).setOnClickListener(v -> Constant.Open_Qureka(context));
                BannerContainer.setVisibility(View.VISIBLE);
                BannerContainer.removeAllViews();
                BannerContainer.addView(view);
            } else if (preference.get_Qureka_Flag().equalsIgnoreCase("predchamp")) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_qureka_native_banner_ads, null, false);
                Random r = new Random();
                int i1 = r.nextInt(4 + 1);
                ((TextView) view.findViewById(R.id.tv_appname)).setText(Constant.predchamp_header[i1]);
                ((TextView) view.findViewById(R.id.tv_desc)).setText(Constant.predchamp_description[i1]);
                Glide.with(context).load(Constant.predchamp_icon[i1]).into((ImageView) view.findViewById(R.id.img_logo));
                view.findViewById(R.id.btn_install).setOnClickListener(v -> Constant.Open_Qureka(context));
                BannerContainer.setVisibility(View.VISIBLE);

                BannerContainer.removeAllViews();
                BannerContainer.addView(view);
            } else {
                new Native_Ads_Static(context).Native_Banner_Ads(BannerContainer);
            }
        }
    }

    private void Qureka_Predchamp_Adaptive(final ViewGroup BannerContainer) {
        if (preference.get_Ad_Status().equalsIgnoreCase("on")) {
            if (preference.get_Qureka_Flag().equalsIgnoreCase("qureka")) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_qureka_adaptive_ads, null, false);
                Random r = new Random();
                int i1 = r.nextInt(4 + 1);
                ((ImageView) view.findViewById(R.id.img_banner)).setImageResource(Constant.qureka_banner[i1]);
                view.setOnClickListener(v -> Constant.Open_Qureka(context));
                BannerContainer.removeAllViews();
                BannerContainer.addView(view);
            } else if (preference.get_Qureka_Flag().equalsIgnoreCase("predchamp")) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_qureka_adaptive_ads, null, false);
                Random r = new Random();
                int i1 = r.nextInt(4 + 1);
                ((ImageView) view.findViewById(R.id.img_banner)).setImageResource(Constant.predchamp_banner[i1]);
                view.setOnClickListener(v -> Constant.Open_Qureka(context));
                BannerContainer.removeAllViews();
                BannerContainer.addView(view);
            } else {
                new Native_Ads_Static(context).Adaptive_Banner(BannerContainer);
            }
        }
    }
}
