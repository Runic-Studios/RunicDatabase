plugins {
    `java-library`
    `maven-publish`
}

group = "com.runicrealms.plugin"
version = "1.0-SNAPSHOT"
val artifactName = "database"

dependencies {
    compileOnly(commonLibs.taskchain)
    compileOnly(commonLibs.springdatamongodb)
    compileOnly(commonLibs.spigot)
    compileOnly(commonLibs.mongodbdriversync)
    compileOnly(commonLibs.mongodbdrivercore)
    compileOnly(commonLibs.jedis)
    compileOnly(commonLibs.paper)
    compileOnly(project(":Projects:Restart"))
    compileOnly(project(":Projects:Common"))
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.runicrealms.plugin"
            artifactId = artifactName
            version = "1.0-SNAPSHOT"
            from(components["java"])
        }
    }
}