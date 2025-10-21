plugins {
    id("com.android.application") version "8.9.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.25" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.8.3" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}