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
     * The path to the secret file.
     */
    open lateinit var secretPath: String

    private lateinit var keystoreSecretsLambda: (secretFile: File) -> KeystoreSecrets

    /**
     * Lambda to get [KeystoreSecrets].
     */
    fun keystoreSecrets(builder: (secretFile: File) -> KeystoreSecrets) {
        keystoreSecretsLambda = builder
    }

    internal operator fun component1() = secretPath
    internal operator fun component2() = keystoreSecretsLambda

    internal fun isInit() = ::secretPath.isInitialized && ::keystoreSecretsLambda.isInitialized
}