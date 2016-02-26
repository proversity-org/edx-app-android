emulator -avd <avd> -no-skin -no-audio -no-window & adb wait-for-device
adb install -r build/outputs/apk/VideoLocker-prod-release.apk
AppPackage=<package>
ScreenshotsDir=src/main/play/en-GB/listing/phoneScreenshots
adb shell am start -n $AppPackage/.view.LoginActivity -W
adb shell screencap -p | perl -pe 's/\x0D\x0A/\x0A/g' > $ScreenshotsDir/LoginActivity.png
adb shell am force-stop $AppPackage
adb shell am start -n $AppPackage/.view.RegisterActivity -W
adb shell screencap -p | perl -pe 's/\x0D\x0A/\x0A/g' > $ScreenshotsDir/RegisterActivity.png
adb shell am force-stop $AppPackage
adb shell am start -n $AppPackage/.view.SplashActivity -W
adb shell screencap -p | perl -pe 's/\x0D\x0A/\x0A/g' > $ScreenshotsDir/SplashActivity.png
adb shell am force-stop $AppPackage
adb shell am start -n $AppPackage/.view.LaunchActivity -W
adb shell screencap -p | perl -pe 's/\x0D\x0A/\x0A/g' > $ScreenshotsDir/LaunchActivity.png
adb shell am force-stop $AppPackage
adb shell am start -n $AppPackage/.view.MyCoursesListActivity -W
adb shell screencap -p | perl -pe 's/\x0D\x0A/\x0A/g' > $ScreenshotsDir/MyCoursesListActivity.png
