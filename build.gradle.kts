import Build_gradle.Profile.MYSQL_57
import Build_gradle.Profile.MYSQL_80
import com.monkeydp.daios.dm.plugin.ext.config
import com.monkeydp.daios.dm.plugin.ext.copyLibsToDist
import org.gradle.api.JavaVersion.VERSION_1_8
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    dependencies {
        classpath("com.monkeydp.daios.dm:dm-plugin:+")
    }
}
apply(plugin = "com.monkeydp.daios.dm.plugin")

plugins {
    distribution
    // kotlin
    val kotlinVersion = "1.3.50"
    kotlin("jvm") version kotlinVersion
    // aspectj
    id("io.freefair.aspectj.post-compile-weaving") version "4.1.5"
}

group = "com.monkeydp.daios.dm"
version = "0.0.4-SNAPSHOT"
java.sourceCompatibility = VERSION_1_8

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = VERSION_1_8.toString()
    }
}

dependencies {
    // base
    api("com.monkeydp.daios.dm:dm-base")
    // aspect
    aspect("com.monkeydp.daios.dms:dms-sdk") { setTransitive(false) }
    testAspect("com.monkeydp.daios.dms:dms-sdk") { setTransitive(false) }
    // test
    testImplementation("junit:junit:4.12")
}

distributions {
    main {
        contents.from(config.dist.sourcePaths) { into(config.dist.destPath) }
    }
}
tasks.distZip { dependsOn(tasks.compileJava, tasks.copyLibsToDist) }

enum class Profile {
    MYSQL_57,
    MYSQL_80
}

val profile = MYSQL_57
when (profile) {
    MYSQL_57 -> {
        dependencies {
            implementation("mysql:mysql-connector-java:5.1.47")
        }
    }
    MYSQL_80 -> {
        dependencies {
            implementation("mysql:mysql-connector-java:8.0.15")
        }
    }
}