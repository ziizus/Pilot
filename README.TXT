-Список эмуляторов
emulator -list-avds

-Список тестируемых устройств
adb devices

- Старт эмулятора
emulator -avd Pixel_3a_XL_API_29 -netdelay none -netspeed full
emulator -avd Galaxy_Nexus_API_28 -netdelay none -netspeed full
emulator -avd Nexus_5X_API_29_Android_10 -netdelay none -netspeed full



- Установка на устройстве apk
adb -s XEDDU18804000040 install -t c:\apk\eribank.apk
adb -s emulator-5554 install -t c:\apk\eribank.apk


- Как узнать appPackage мобильного приложения
(http://www.automationtestinghub.com/apppackage-and-appactivity-name/)
Один из способов:
- adb shell
- dumpsys window windows | grep -E mCurrentFocus

com.amazon.mShop.android.shopping/com.amazon.mShop.startup.StartupLocalizationSelectionActivity


