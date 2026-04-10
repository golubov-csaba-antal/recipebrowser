This is a Kotlin Multiplatform project targeting Android, iOS.

The basic navigation flow works similar to the Panorama control in Windows Phone - one big and parallel-scrolling background image, a big and parallel-scrolling thin text, and the horizontal paging content.

Not tested on iOS yet, only on my A55, so it might will change later if the big image cause problems on iOS. :)

Screenshots:

<img src="https://github.com/user-attachments/assets/c8050bc1-52a9-43c8-8156-f13eeb353fe1" width="240">

<img src="https://github.com/user-attachments/assets/e337d601-2ce9-4c7f-a6ea-07e6756d636a" width="240">

<img src="https://github.com/user-attachments/assets/f7d04bbf-3292-497f-9065-e0ae13e0748f" width="240">

Video:

https://drive.google.com/file/d/1DSBn0iWkX1jF4t90TrHwggbc8QRZiQ8A/view?usp=sharing

The modules of the project

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./composeApp/src/jvmMain/kotlin)
    folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

### Build and Run Android Application

To build and run the development version of the Android app, use the run configuration from the run widget
in your IDE’s toolbar or build it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```

### Build and Run iOS Application

To build and run the development version of the iOS app, use the run configuration from the run widget
in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
