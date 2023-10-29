plugins {
	java
	id("org.springframework.boot") version "2.7.17"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

//extra["queryDslVersion"] = "5.0.0"

val queryDslVersion: String = "4.4.0"

group = "com"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

sourceSets {
	main {
		java {
			setSrcDirs(listOf("$projectDir/src/main/java", "$projectDir/build/generated"))
		}
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")

	runtimeOnly("com.h2database:h2")

	// Lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// QueryDSL
//	implementation("com.querydsl:querydsl-jpa:${queryDslVersion}")
//	annotationProcessor("javax.persistence:javax.persistence-api")
//	annotationProcessor("javax.annotation:javax.annotation-api")
//	annotationProcessor("com.querydsl:querydsl-apt:${queryDslVersion}:jpa")

	implementation("com.querydsl:querydsl-jpa")
	implementation("com.querydsl:querydsl-core")
	implementation("com.querydsl:querydsl-collections")
	annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jpa") // querydsl JPAAnnotationProcessor 사용 지정
	annotationProcessor("jakarta.annotation:jakarta.annotation-api") // java.lang.NoClassDefFoundError (javax.annotation.Generated) 대응 코드
	annotationProcessor("jakarta.persistence:jakarta.persistence-api") // java.lang.NoClassDefFoundError (javax.annotation.Entity) 대응 코드
}

// QueryDsl Start
val querydslDir = "src/main/generated"

tasks.withType<JavaCompile> {
	options.generatedSourceOutputDirectory = file(querydslDir)
}

sourceSets {
//	main.java.srcDirs += [ generated ]
	main {
		java {
			srcDir(querydslDir)
		}
	}
}

tasks.register("cleanGenerated") {
	doLast {
		delete(file(querydslDir))
	}
}

// QueryDsl End

tasks.withType<Test> {
	useJUnitPlatform()
}
