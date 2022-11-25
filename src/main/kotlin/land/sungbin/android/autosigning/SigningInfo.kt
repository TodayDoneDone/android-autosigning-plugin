/*
 * Developed by 2022 Ji Sungbin
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/android-autosigning-plugin/blob/main/LICENSE
 */

@file:Suppress("unused")

package land.sungbin.android.autosigning

import java.io.File

@AutoSigningPluginDsl
open class SigningInfo {
    /**
     * The path to the keystore file.
     */
    open lateinit var keystorePath: String

    private lateinit var keystoreSecretsLambda: (keystoreFile: File) -> KeystoreSecrets

    /**
     * Lambda to get [KeystoreSecrets].
     *
     * keystoreSecrets - param: keystoreFile The keystore file.
     */
    fun keystoreSecrets(keystoreSecrets: (keystoreFile: File) -> KeystoreSecrets) {
        keystoreSecretsLambda = keystoreSecrets
    }

    internal operator fun component1() = keystorePath
    internal operator fun component2() = keystoreSecretsLambda

    internal fun isInit() = ::keystorePath.isInitialized && ::keystoreSecretsLambda.isInitialized
}