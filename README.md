This is a Kotlin Multiplatform project targeting Android, iOS.

The basic navigation flow works similar to the Panorama control in Windows Phone - one big and parallel-scrolling background image, a big and parallel-scrolling thin text, and the horizontal paging content.

Actually, I always wanted to make a Windows Phone like app for a reason, and my favorite controls were the Pivot control and the Panorama control - mostly the latter one because of the scrolling background image and big texts.

Not tested on iOS device yet, only on my A55 and in an iOS simulator, so it might will change later if the big image cause problems on iOS. :) In simulator, I couldn't see any problem, but that means nothing as far as I know.

Screenshots:

<img src="https://github.com/user-attachments/assets/c256dbda-cd06-4666-8f79-09553b6bff46" width="240">

<img src="https://github.com/user-attachments/assets/3568d3fe-2710-4147-8725-dac28d453735" width="240">

<img src="https://github.com/user-attachments/assets/0e8de3a9-3246-4625-b93c-5c0c4fbdeecf" width="240">

Video:

[https://drive.google.com/file/d/1DSBn0iWkX1jF4t90TrHwggbc8QRZiQ8A/view?usp=sharing](https://drive.google.com/file/d/1RUqskwUlkjhlapHk7pgf3v4wDAGt0W-z/view?usp=sharing)

Planned features:

- Recipe list of areas and ingredients and in browser.
- Show recipe selected from the recipe list.
- Mark recipes as favorite, and show them on a new tab.
- Print recipes to PDF file.
- Read recipes aloud (maybe plus an option to read it paragraph-by-paragraph).

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
