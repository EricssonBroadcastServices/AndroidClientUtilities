[![Release](https://jitpack.io/v/EricssonBroadcastServices/AndroidClientUtilities.svg)](https://jitpack.io/#EricssonBroadcastServices/AndroidClientUtilities)

# Exposure

* [Features](#features)
* [License](https://github.com/EricssonBroadcastServices/AndroidClientUtilities/blob/master/LICENSE)
* [Requirements](#requirements)
* [Installation](#installation)
* [Documentation](https://jitpack.io/com/github/EricssonBroadcastServices/AndroidClientUtilities/master-SNAPSHOT/javadoc/)
* [Release Notes](#release-notes)
* [Upgrade Guides](#upgrade-guides)

## Features

- [x] ISO-8601 DateTime format conversion

## Requirements

* `Android` 4.4+

## Installation

### JitPack
Releases are available on [JitPack](https://jitpack.io/#EricssonBroadcastServices/AndroidClientUtilities) and can be automatically imported to your project using Gradle dependency management.

Add the jitpack.io repository to your project **build.gradle**:
```gradle
allprojects {
 repositories {
    jcenter()
    maven { url "https://jitpack.io" }
 }
}
```

Then add the dependency to your module **build.gradle**:
```gradle
dependencies {
    compile 'com.github.EricssonBroadcastServices:utilities:{version}'
}
```

Note: do not add the jitpack.io repository under *buildscript {}*

## Release Notes
Release specific changes can be found in the [CHANGELOG](https://github.com/EricssonBroadcastServices/AndroidClientUtilities/blob/master/CHANGELOG.md).

## Upgrade Guides
Major changes between releases will be documented with special [Upgrade Guides](https://github.com/EricssonBroadcastServices/AndroidClientUtilities/blob/master/UPGRADE_GUIDE.md).
