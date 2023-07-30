package com.advanced.admobmanager.manager

import android.app.Activity
import android.content.Context
import com.advanced.admobmanager.adunit.AdvancedAdUnit
import com.advanced.admobmanager.interfaces.AdmobManagerInterfaces
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback


class AdvancedAdmobManager {

    fun initializeAds(context: Context) {
        if (AdvancedAdUnit.adsEnable) {
            MobileAds.initialize(context) {}
        }
    }

    // Start BannerAd ------------------------------------------------------------>

    fun loadBannerAd(
        adView: AdView,
        callback: AdmobManagerInterfaces.BannerAdCallback
    ) {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        adView.adListener = object : AdListener() {
            override fun onAdClicked() {
                callback.onAdClicked()
            }

            override fun onAdClosed() {
                callback.onAdClosed()
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                callback.onAdFailedToLoad(adError)
            }

            override fun onAdImpression() {
                callback.onAdImpression()
            }

            override fun onAdLoaded() {
                callback.onAdLoaded()
            }

            override fun onAdOpened() {
                callback.onAdOpened()
            }
        }
    }

    // Start InterstitialAd ------------------------------------------------------------>

    fun loadInterstitialAd(
        context: Context,
        callback: AdmobManagerInterfaces.InterstitialLoadCallback
    ) {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            context,
            AdvancedAdUnit.interstitialAdUnitID,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    AdvancedAdUnit.interstitialAd = interstitialAd
                    callback.onInterstitialAdLoaded(interstitialAd)
                }

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    AdvancedAdUnit.interstitialAd = null
                    callback.onInterstitialAdFailedToLoad(adError)
                }
            })
    }

    fun showInterstitialAd(
        activity: Activity,
        callback: AdmobManagerInterfaces.InterstitialAdCallback
    ) {
        if (AdvancedAdUnit.interstitialAd != null) {
            AdvancedAdUnit.interstitialAd?.show(activity)

            AdvancedAdUnit.interstitialAd?.fullScreenContentCallback =
                object : FullScreenContentCallback() {
                    override fun onAdClicked() {
                        callback.onAdClicked()
                    }

                    override fun onAdDismissedFullScreenContent() {
                        callback.onAdDismissedFullScreenContent()
                        AdvancedAdUnit.interstitialAd = null
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                        callback.onAdFailedToShowFullScreenContent(adError)
                    }

                    override fun onAdImpression() {
                        callback.onAdImpression()
                    }

                    override fun onAdShowedFullScreenContent() {
                        callback.onAdShowedFullScreenContent()
                    }
                }
        }
    }

    // End InterstitialAd ------------------------------------------------------------>

    // Start RewardedAd ------------------------------------------------------------>

    fun loadRewardedAd(
        context: Context,
        callback: AdmobManagerInterfaces.RewardedLoadCallback
    ) {
        val adRequest = AdRequest.Builder().build()

        RewardedAd.load(
            context,
            AdvancedAdUnit.rewardedAdUnitID,
            adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedAd) {
                    AdvancedAdUnit.rewardedAd = ad
                    callback.onRewardedAdLoaded(ad)
                }

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    AdvancedAdUnit.rewardedAd = null
                    callback.onRewardedAdFailedToLoad(adError)
                }
            })
    }

    fun showRewardedAd(
        activity: Activity,
        callback: AdmobManagerInterfaces.RewardedAdCallback
    ) {
        if (AdvancedAdUnit.rewardedAd != null) {
            AdvancedAdUnit.rewardedAd?.let { ad ->
                ad.show(activity) { rewardItem ->
                    // Handle the reward.
                    callback.onUserEarnedRewardListener(rewardItem)
                }
            }

            AdvancedAdUnit.rewardedAd?.fullScreenContentCallback =
                object : FullScreenContentCallback() {
                    override fun onAdClicked() {
                        callback.onAdClicked()
                    }

                    override fun onAdDismissedFullScreenContent() {
                        AdvancedAdUnit.rewardedAd = null
                        callback.onAdDismissedFullScreenContent()
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                        AdvancedAdUnit.rewardedAd = null
                        callback.onAdFailedToShowFullScreenContent(adError)
                    }

                    override fun onAdImpression() {
                        callback.onAdImpression()
                    }

                    override fun onAdShowedFullScreenContent() {
                        callback.onAdShowedFullScreenContent()
                    }
                }
        }
    }

    // End RewardedAd ------------------------------------------------------------>

    // Start RewardedInterstitialAd ------------------------------------------------------------>

    fun loadRewardedInterstitialAd(
        context: Context,
        callback: AdmobManagerInterfaces.RewardedInterstitialLoadCallback
    ) {
        val adRequest = AdRequest.Builder().build()

        RewardedInterstitialAd.load(
            context,
            AdvancedAdUnit.rewardedInterstitialAdUnitID,
            adRequest,
            object : RewardedInterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedInterstitialAd) {
                    AdvancedAdUnit.rewardedInterstitialAd = ad
                    callback.onRewardedInterstitialAdLoaded(ad)
                }

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    AdvancedAdUnit.rewardedInterstitialAd = null
                    callback.onRewardedInterstitialAdFailedToLoad(adError)
                }
            })
    }

    fun showRewardedInterstitialAd(
        activity: Activity,
        callback: AdmobManagerInterfaces.RewardedInterstitialAdCallback
    ) {
        if (AdvancedAdUnit.rewardedInterstitialAd != null) {
            AdvancedAdUnit.rewardedInterstitialAd?.let { ad ->
                ad.show(activity) { rewardItem ->
                    // Handle the reward.
                    callback.onUserEarnedRewardListener(rewardItem)
                }
            }

            AdvancedAdUnit.rewardedInterstitialAd?.fullScreenContentCallback =
                object : FullScreenContentCallback() {
                    override fun onAdClicked() {
                        callback.onAdClicked()
                    }

                    override fun onAdDismissedFullScreenContent() {
                        AdvancedAdUnit.rewardedInterstitialAd = null
                        callback.onAdDismissedFullScreenContent()
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                        AdvancedAdUnit.rewardedInterstitialAd = null
                        callback.onAdFailedToShowFullScreenContent(adError)
                    }

                    override fun onAdImpression() {
                        callback.onAdImpression()
                    }

                    override fun onAdShowedFullScreenContent() {
                        callback.onAdShowedFullScreenContent()
                    }
                }
        }
    }

    // End RewardedInterstitialAd ------------------------------------------------------------>

}