package com.advanced.admobmanager.adunit

import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd

class AdvancedAdUnit {
    companion object {
        var adsEnable: Boolean = true
        var bannerAdUnitID = ""
        var interstitialAdUnitID = ""
        var rewardedAdUnitID = ""
        var rewardedInterstitialAdUnitID = ""

        var interstitialAd: InterstitialAd? = null
        var rewardedAd: RewardedAd? = null
        var rewardedInterstitialAd: RewardedInterstitialAd? = null
    }
}