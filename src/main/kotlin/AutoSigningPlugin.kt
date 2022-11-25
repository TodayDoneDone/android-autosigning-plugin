/*
 * Developed by 2022 Ji Sungbin
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/android-autosigning-plugin/blob/main/LICENSE
 */

import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import land.sungbin.android.autosigning.SigningInfo
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByType

class AutoSigningPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            if (!pluginManager.hasPlugin("com.android.application")) {
                throw GradleException("This plugin must be applied after the Android application plugin.")
            }
            val signingInfo = project.extensions.create<SigningInfo>("signingInfo")
            val androidComponents = project.extensions.getByType(AndroidComponentsExtension::class.java)

            androidComponents.finalizeDsl {
                if (signingInfo.isInit()) {
                    val (keystorePath, keystoreSecrets) = signingInfo
                    val keystoreFile = file(keystorePath)

                    if (keystoreFile.exists()) {
                        val (storePath, storePassword, keyAlias, keyPassword) = keystoreSecrets(keystoreFile)
                        val extension = extensions.getByType<BaseAppModuleExtension>()

                        extension.apply {
                            signingConfigs {
                                create("release") {
                                    storeFile = file(storePath)
                                    this.storePassword = storePassword
                                    this.keyAlias = keyAlias
                                    this.keyPassword = keyPassword
                                }
                            }

                            buildTypes {
                                release {
                                    signingConfig = signingConfigs.getByName("release")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}