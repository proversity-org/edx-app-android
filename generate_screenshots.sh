echo "Generating screenshots...."
emulator -avd circleci-android21 -no-skin -no-audio -no-window & adb wait-for-device
adb devices -l
adb install -r ~/edx-app-android/VideoLocker/build/outputs/apk/VideoLocker-prod-release.apk
AppPackage=org.proversity.edx.mobile #Todo: Change package
cd VideoLocker/src/main/play/en-GB/listing/phoneScreenshots/
adb shell am start -n $AppPackage/.view.LoginActivity -W
adb shell screencap -p | perl -pe 's/\x0D\x0A/\x0A/g' > LoginActivity.png
adb shell am force-stop $AppPackage
adb shell am start -n $AppPackage/.view.RegisterActivity -W
adb shell screencap -p | perl -pe 's/\x0D\x0A/\x0A/g' > RegisterActivity.png