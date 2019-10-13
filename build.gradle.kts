plugins {
    distribution
    // kotlin
    kotlin("jvm") version "1.2.71"
}

distributions {
    main {
        contents {
            from("src/main/kotlin") {
                into("classes")
            }
            from("assembly")
        }
    }
}

group = "com.monkeydp.daios.dm"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // monkeydp
    implementation("com.monkeydp:tools")
    implementation("com.monkeydp.daios.dms:dms-sdk")
    implementation("com.monkeydp.daios.dm:dm-base")
    // junit
    testImplementation("junit:junit:4.12")
}
