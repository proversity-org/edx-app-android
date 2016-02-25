emulator -avd JubJub -no-skin -no-audio -no-window & adb wait-for-device
adb install -r VideoLocker/build/outputs/apk/VideoLocker-prod-release.apk
AppPackage=org.proversity.edx.mobile #Todo: Change package
adb shell am start -n $AppPackage/.view.LoginActivity -W
adb shell screencap -p | perl -pe 's/\x0D\x0A/\x0A/g' > src/main/play/en-GB/listing/phoneScreenshots/LoginActivity.png
adb shell am force-stop $AppPackage
adb shell am start -n $AppPackage/.view.RegisterActivity -W
adb shell screencap -p | perl -pe 's/\x0D\x0A/\x0A/g' > src/main/play/en-GB/listing/phoneScreenshots/RegisterActivity.png