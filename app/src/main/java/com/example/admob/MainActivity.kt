package com.example.admob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.advanced.admobmanager.adunit.AdvancedAdUnit
import com.advanced.admobmanager.interfaces.AdmobManagerInterfaces
import com.advanced.admobmanager.manager.AdvancedAdmobManager
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd

class MainActivity : AppCompatActivity() {

    private val advancedAdmobManager: AdvancedAdmobManager = AdvancedAdmobManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize layouts
        val interstitialAd: Button = findViewById(R.id.interstitialAd)
        val rewardedAd: Button = findViewById(R.id.rewardedAd)
        val rewardedInterstitialAd: Button = findViewById(R.id.rewardedInterstitialAd)
        val adView: AdView = findViewById(R.id.adView)

        //initialize ads
        advancedAdmobManager.initializeAds(this)

        //loading ads
        loadBannerAd(adView)
        loadInterstitialAd()
        loadRewardedAd()
        loadRewardedInterstitialAd()

        //setup all button click
        interstitialAd.setOnClickListener {
            showInterstitialAd()
        }

        rewardedAd.setOnClickListener {
            showRewardedAd()
        }

        rewardedInterstitialAd.setOnClickListener {
            showRewardedInterstitialAd()
        }

    }

    private fun loadBannerAd(adView: AdView) {

        advancedAdmobManager.loadBannerAd(
            adView,
            object : AdmobManagerInterfaces.BannerAdCallback {
                override fun onAdClicked() {
                    TODO("Not yet implemented")
                }

                override fun onAdClosed() {
                    TODO("Not yet implemented")
                }

                override fun onAdFailedToLoad(adError: LoadAdError?) {
                    TODO("Not yet implemented")
                }

                override fun onAdImpression() {
                    TODO("Not yet implemented")
                }

                override fun onAdOpened() {
                    TODO("Not yet implemented")
                }

                override fun onAdLoaded() {
                    TODO("Not yet implemented")
                }
            })

    }


    private fun loadInterstitialAd() {
        // You can use both to setup ad unit ID
        AdvancedAdUnit.interstitialAdUnitID = "ca-app-pub-3940256099942544/1033173712"

        advancedAdmobManager.loadInterstitialAd(
            this,
            object : AdmobManagerInterfaces.InterstitialLoadCallback {

                override fun onInterstitialAdLoaded(interstitialAd: InterstitialAd) {
                    Toast.makeText(
                        this@MainActivity,
                        "InterstitialAd loaded Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onInterstitialAdFailedToLoad(adError: LoadAdError) {
                    Toast.makeText(
                        this@MainActivity,
                        "InterstitialAd load Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
    }

    private fun showInterstitialAd() {
        advancedAdmobManager.showInterstitialAd(
            this@MainActivity,
            object : AdmobManagerInterfaces.InterstitialAdCallback {
                override fun onAdClicked() {

                }

                override fun onAdDismissedFullScreenContent() {
                    loadInterstitialAd()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {

                }

                override fun onAdImpression() {

                }

                override fun onAdShowedFullScreenContent() {

                }

            })
    }

    private fun loadRewardedAd() {

        // You can use both to setup ad unit ID
        AdvancedAdUnit.rewardedAdUnitID = "ca-app-pub-3940256099942544/5224354917"

        advancedAdmobManager.loadRewardedAd(
            this,
            object : AdmobManagerInterfaces.RewardedLoadCallback {
                override fun onRewardedAdLoaded(rewardedAd: RewardedAd) {
                    Toast.makeText(
                        this@MainActivity,
                        "RewardedAd loaded Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onRewardedAdFailedToLoad(adError: LoadAdError) {
                    Toast.makeText(this@MainActivity, "Rewarded Adload Failed", Toast.LENGTH_SHORT)
                        .show()
                    Log.d("LoadAdError", adError.toString())
                }

            })

    }

    private fun showRewardedAd() {

        advancedAdmobManager.showRewardedAd(
            this@MainActivity,
            object : AdmobManagerInterfaces.RewardedAdCallback {
                override fun onUserEarnedRewardListener(rewardItem: RewardItem) {
                    TODO("Not yet implemented")
                }

                override fun onAdClicked() {
                    TODO("Not yet implemented")
                }

                override fun onAdDismissedFullScreenContent() {
                    loadRewardedAd()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    TODO("Not yet implemented")
                }

                override fun onAdImpression() {
                    TODO("Not yet implemented")
                }

                override fun onAdShowedFullScreenContent() {
                    TODO("Not yet implemented")
                }

            })

    }

    private fun loadRewardedInterstitialAd() {

        // You can use both to setup ad unit ID
        AdvancedAdUnit.rewardedInterstitialAdUnitID = "ca-app-pub-3940256099942544/5354046379"

        advancedAdmobManager.loadRewardedInterstitialAd(
            this,
            object : AdmobManagerInterfaces.RewardedInterstitialLoadCallback {

                override fun onRewardedInterstitialAdLoaded(rewardedInterstitialAd: RewardedInterstitialAd) {
                    Toast.makeText(
                        this@MainActivity,
                        "RewardedInterstitialAd loaded Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onRewardedInterstitialAdFailedToLoad(adError: LoadAdError) {
                    Toast.makeText(
                        this@MainActivity,
                        "RewardedInterstitialAd load Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })

    }

    private fun showRewardedInterstitialAd() {

        advancedAdmobManager.showRewardedInterstitialAd(
            this@MainActivity,
            object : AdmobManagerInterfaces.RewardedInterstitialAdCallback {
                override fun onUserEarnedRewardListener(rewardItem: RewardItem) {
                    TODO("Not yet implemented")
                }

                override fun onAdClicked() {
                    TODO("Not yet implemented")
                }

                override fun onAdDismissedFullScreenContent() {
                    loadRewardedInterstitialAd()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    TODO("Not yet implemented")
                }

                override fun onAdImpression() {
                    TODO("Not yet implemented")
                }

                override fun onAdShowedFullScreenContent() {
                    TODO("Not yet implemented")
                }

            })

    }

}