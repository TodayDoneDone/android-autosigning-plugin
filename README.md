# android-autosigning-plugin

A Gradle plugin that automatically sets `release` signingConfigs when the given keystore is valid.

---

## Download ![maven-central](https://img.shields.io/maven-central/v/land.sungbin.android.autosigning/android.autosigning.plugin)

```gradle
plugins {
    id("land.sungbin.android.autosigning.plugin") version "$version"
}
```

## Usage

```gradle
signingInfo {
    secretPath = "$rootDir/keystore/secrets.txt"
    keystoreSecrets { secretFile ->
        val lines = secretFile.readLines()
        land.sungbin.android.autosigning.KeystoreSecrets(
            storePath = "$rootDir/keystore/quack.pepk",
            storePassword = lines[0],
            keyAlias = lines[1],
            keyPassword = lines[0],
        )
    }
}
```

## License

This project is licensed under the MIT License. Please refer to the [LICENSE file](LICENSE) for details.
