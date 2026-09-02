pluginManagement {
	repositories {
		gradlePluginPortal()
		google()
		mavenCentral()
	}
}

rootProject.name = "demo-1-http-get"
include(":app")

pluginManagement {
	plugins {
		id("com.android.application") version "8.2.2"
		kotlin("android") version "1.9.10"
	}
}
