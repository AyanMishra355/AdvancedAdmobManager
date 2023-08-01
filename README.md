
# Advanced Admob Manager

**Introducing Advanced Admob Manager** - a free Android library designed to simplify the integration of Admob ads into your app. With this powerful tool, you can effortlessly add banner, interstitial, and rewarded ads with just a few lines of code. Plus, the library optimizes the ad code, ensuring faster loading and increased visibility to your users.


## Key Benefits :- 

- **User-Friendly**: Adding ads is a breeze, even for beginners.
- **Performance Boost**: Optimized ad code for faster loading and better results.
- **Customizable**: Tailor the ads' appearance and control their display as per your preferences.


## Additional Details :-

- **Open Source**: You can explore and modify the code as needed.
- **Compatibility**: Works seamlessly with Android versions 8.0 and above..
- **Tested Formats**: Verified compatibility with banner, interstitial, and rewarded ads.

Enhance your app's monetization effortlessly with Advanced Admob Manager - a reliable and easy-to-use solution for integrating Admob ads into your Android app.


## Using Advanced Admob Manager Library in your Android application :-

Step 1. Add the JitPack repository to your build file

```
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```
Step 2. Add the dependency

```
dependencies {

    //for google mobile ads SDK 
    implementation 'com.google.android.gms:play-services-ads:X.X.X'

    //for advanced admob manager library
    implementation 'com.github.AyanMishra355:AdvancedAdmobManager:X.X.X'

	}
```

**Replace X.X.X with the specific version or release tag you want to use.**

Step 3. Add your AdMob app ID ([**identified in the AdMob UI**](https://support.google.com/admob/answer/7356431)) to your app's AndroidManifest.xml file

```
<manifest>
    <application>
        <!-- Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713 -->
        <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="ca-app-pub-xxxxxxxxxxxxxxxx~yyyyyyyyyy"/>
    </application>
</manifest>
```
In a real app, use your actual AdMob app ID, not the one listed above. If you're just looking to experiment with the SDK in a Hello World app, you can use the sample app ID shown above.

Step 4. To optimize initialization and ad loading, add this to your AndroidManifest.xml

```
<manifest>
    <application>
	<!-- Optimize initialization -->
        <meta-data
          android:name="com.google.android.gms.ads.flag.OPTIMIZE_INITIALIZATION"
          android:value="true"/>
	<!-- Optimize ad loading -->
	 <meta-data
          android:name="com.google.android.gms.ads.flag.OPTIMIZE_AD_LOADING"
          android:value="true"/>
    </application>
</manifest>
```
There are two optimization flags available: OPTIMIZE_INITIALIZATION and OPTIMIZE_AD_LOADING. Once they're turned on, the initialization and ad loading tasks that require extended processing time are offloaded to background threads.

**Most Importent Part**

Step 5. Enabling hardware acceleration

```
<application android:hardwareAccelerated="true">
    <!-- For activities that use ads, hardwareAcceleration should be true. -->
    <activity android:hardwareAccelerated="true" />
    <!-- For activities that don't use ads, hardwareAcceleration can be false. -->
    <activity android:hardwareAccelerated="false" />
</application>
```
If your app does not behave properly with hardware acceleration turned on globally, you can control it for individual activities as well.

## Usage :- (You can check our demo app)

Step 1. Then initialize it in onCreate() Method of application class :

```
advancedAdmobManager.initializeAds(this)
```

Step 2. Set the Ad Unit ID:

```
AdvancedAdUnit.interstitialAdUnitID = "ca-app-pub-3940256099942544/1033173712"
```
**//Apply the same process for other ads as well.**

Step 3. Load ads using Advanced Admob Manager 

```
advancedAdmobManager.loadInterstitialAd( this, object : AdmobManagerInterfaces.InterstitialLoadCallback {

                override fun onInterstitialAdLoaded(interstitialAd: InterstitialAd) {

                   //InterstitialAd loaded Successfully

                }

                override fun onInterstitialAdFailedToLoad(adError: LoadAdError) {

                    //InterstitialAd load Failed

                }

            })

```

**//Apply the same process for other ads as well.**

Step 4. Show ads using Advanced Admob Manager

```
 advancedAdmobManager.showInterstitialAd( this, object : AdmobManagerInterfaces.InterstitialAdCallback {

                override fun onAdClicked() {

                    // Called when a click is recorded for an ad.
                    
                }

                override fun onAdDismissedFullScreenContent() {

                    // Called when ad is dismissed.
                    
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {

                    // Called when ad fails to show.

                }

                override fun onAdImpression() {

                    // Called when an impression is recorded for an ad.

                }

                override fun onAdShowedFullScreenContent() {

                    // Called when ad is shown.

                }

            })
```
**//Apply the same process for other ads as well.**

### Notice
* In the future, we will also add ad loading in the background.
* Additionally, we will fix bugs and add new features.

**If you've found this library useful, please give it a :star: on GitHub! It's a great way to show your appreciation and help the project grow.**

**Thank You So Much :heart:** 
