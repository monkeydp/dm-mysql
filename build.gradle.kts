import Build_gradle.Profile.MYSQL_57
import Build_gradle.Profile.MYSQL_80
import org.gradle.api.JavaVersion.VERSION_1_8
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    distribution
    // kotlin
    val kotlinVersion = "1.3.50"
    kotlin("jvm") version kotlinVersion
}

group = "com.monkeydp.daios.dm"
version = "0.0.2-SNAPSHOT"
java.sourceCompatibility = VERSION_1_8

dependencies {
    // base
    api("com.monkeydp.daios.dm:dm-base")
    // test
    testImplementation("junit:junit:4.12")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = VERSION_1_8.toString()
    }
}

val commonLibsDir = File("$rootDir/src/main/dist/libs/common")
tasks.register<Copy>("copyLibsToDist") {
    if (commonLibsDir.exists()) commonLibsDir.deleteRecursively()
    commonLibsDir.mkdir()
    from(configurations.runtimeClasspath.get().filter {
        it.name.matches("dm-base-.+\\.jar$".toRegex())
    })
    into(commonLibsDir)
}

distributions {
    main {
        contents {
            from("$buildDir/classes/kotlin/main/com") {
                into("classes/com")
            }
        }
    }
}
tasks.distZip { dependsOn(tasks.compileJava, tasks["copyLibsToDist"]) }


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