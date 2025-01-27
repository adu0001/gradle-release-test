plugins {
	java
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
	id("pl.allegro.tech.build.axion-release") version "1.18.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


version = scmVersion.version

scmVersion{

	localOnly.set(true)
	useHighestVersion.set(true)
	releaseOnlyOnReleaseBranches.set(true)
	releaseBranchNames.add("main")
	versionCreator { versionFromTag, _ -> versionFromTag }
	tag{
		prefix.set("elf-dataflow-")

	}
	repository.type.set("git")

}



tasks.withType<Test> {
	useJUnitPlatform()
}
