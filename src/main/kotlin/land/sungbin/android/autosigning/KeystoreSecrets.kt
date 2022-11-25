/*
 * Developed by 2022 Ji Sungbin
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/android-autosigning-plugin/blob/main/LICENSE
 */

package land.sungbin.android.autosigning

/**
 * The keystore secrets.
 *
 * @param storePath The path to the keystore file
 * @param storePassword The keystore password
 * @param keyAlias The key alias
 * @param keyPassword The key password
 */
data class KeystoreSecrets(
    val storePath: String,
    val storePassword: String,
    val keyAlias: String,
    val keyPassword: String,
)