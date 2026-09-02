pluginManagement {
	repositories {
		gradlePluginPortal()
		google()
		mavenCentral()
	}
	plugins {
		id("com.android.application") version "8.2.2"
		kotlin("android") version "1.9.10"
	}
}

rootProject.name = "demo-1-http-get"
include(":app")
