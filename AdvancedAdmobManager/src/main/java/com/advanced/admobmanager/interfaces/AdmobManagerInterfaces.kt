package com.advanced.admobmanager.interfaces

import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd

class AdmobManagerInterfaces {
    interface BannerAdCallback {
        fun onAdClicked()
        fun onAdClosed()
        fun onAdFailedToLoad(adError: LoadAdError?)
        fun onAdImpression()
        fun onAdOpened()
        fun onAdLoaded()
    }

    interface InterstitialLoadCallback {
        fun onInterstitialAdLoaded(interstitialAd: InterstitialAd)
        fun onInterstitialAdFailedToLoad(adError: LoadAdError)
    }

    interface InterstitialAdCallback {
        fun onAdClicked()
        fun onAdDismissedFullScreenContent()
        fun onAdFailedToShowFullScreenContent(adError: AdError)
        fun onAdImpression()
        fun onAdShowedFullScreenContent()
    }

    interface RewardedLoadCallback {
        fun onRewardedAdLoaded(rewardedAd: RewardedAd)
        fun onRewardedAdFailedToLoad(adError: LoadAdError)
    }

    interface RewardedAdCallback {
        fun onUserEarnedRewardListener(rewardItem: RewardItem)
        fun onAdClicked()
        fun onAdDismissedFullScreenContent()
        fun onAdFailedToShowFullScreenContent(adError: AdError)
        fun onAdImpression()
        fun onAdShowedFullScreenContent()
    }

    interface RewardedInterstitialLoadCallback {
        fun onRewardedInterstitialAdLoaded(rewardedInterstitialAd: RewardedInterstitialAd)
        fun onRewardedInterstitialAdFailedToLoad(adError: LoadAdError)
    }

    interface RewardedInterstitialAdCallback {
        fun onUserEarnedRewardListener(rewardItem: RewardItem)
        fun onAdClicked()
        fun onAdDismissedFullScreenContent()
        fun onAdFailedToShowFullScreenContent(adError: AdError)
        fun onAdImpression()
        fun onAdShowedFullScreenContent()
    }
}