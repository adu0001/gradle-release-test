plugins {
	java
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
	id("net.researchgate.release") version "3.1.0"
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


release {
	failOnCommitNeeded = true
	failOnPublishNeeded = true
	failOnSnapshotDependencies = true
	failOnUnversionedFiles = true
	failOnUpdateNeeded = true
	revertOnFail = true
	preCommitText = ""
	preTagCommitMessage = "[Gradle Release Plugin] - pre tag commit: "
	tagCommitMessage = "[Gradle Release Plugin] - creating tag: "
	newVersionCommitMessage = "[Gradle Release Plugin] - new version commit: "
	tagTemplate = "${version}"
	versionPropertyFile = "gradle.properties"
	snapshotSuffix = "-SNAPSHOT"
	pushReleaseVersionBranch = null
	//scmAdapters = net.researchgate.release.GitAdapter

	git {
		requireBranch.set("main")
		pushToRemote.set("origin")
		pushToBranchPrefix.set("")
		commitVersionFileOnly.set(false)
		signTag.set(false)
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
