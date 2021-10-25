# Berlin Uhr

## System requirements
- Android Studio 2020.3.1 or newer (desirable but not required)
- Android 5.0 device or newer (emulator from Android Studio suitable too )

## Installation
Clone this repository (master branch) and import into **Android Studio** , plug your physical device or start an emulator. 
Hit run 'app' (^R) https://developer.android.com/studio/run to install the application.
You can also build the app from command line: https://developer.android.com/studio/build/building-cmdline

## Implementation and thoughts
In normal production there are many questions to be asked and many details to be clarified before embarking on this task. 
First of all, I noticed that the color does not carry any additional information in this watch, 
and therefore I assume that the very first designer who takes on this project will change the color scheme, 
and maybe the shape and location of the lamps. Therefore, in the architecture of the application, I tried to take this into account - that 
is the reason I created so many interfaces.

## ToDos
Add more Unit and UI tests 
Delete all unnecessary dependencies and files
SplashScreen and/or ProgressBar
User input time converters
Use of Jetpack Compose
Consider adding multiple lamp color schemes and themes
