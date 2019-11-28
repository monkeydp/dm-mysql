rootProject.name = "dm-mysql"
includeBuild("../dm-plugin") {
    dependencySubstitution {
        substitute(module("com.monkeydp.daios.dm:dm-plugin")).with(project(":"))
    }
}
includeBuild("../dm-base") {
    dependencySubstitution {
        substitute(module("com.monkeydp.daios.dm:dm-base")).with(project(":"))
    }
}
includeBuild("../../dms-sdk") {
    dependencySubstitution {
        substitute(module("com.monkeydp.daios.dms:dms-sdk")).with(project(":"))
    }
}
includeBuild("../../tools") {
    dependencySubstitution {
        substitute(module("com.monkeydp:tools")).with(project(":"))
    }
}