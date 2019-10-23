rootProject.name = "dm-mysql"
includeBuild("../../dms-sdk") {
    dependencySubstitution {
        substitute(module("com.monkeydp.daios.dms:dms-sdk")).with(project(":"))
    }
}