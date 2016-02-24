#Todo:
adb install -r VideoLocker/build/outputs/apk/VideoLocker-dev-debug.apk
adb shell am start -n org.edx.mobile/.view.LoginActivity
adb shell wm size 160x579 density 160
adb shell screencap -p | perl -pe 's/\x0D\x0A/\x0A/g' > LoginActivity.png