import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.hieult.durian.configureBuildType
import com.hieult.durian.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class DurianApplicationConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            pluginManager.apply {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<BaseAppModuleExtension>{
                configureKotlinAndroid(this)
                configureBuildType(this)
                buildFeatures{
                    buildConfig = true
                }
            }
        }

    }
}