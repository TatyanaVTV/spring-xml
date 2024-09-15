plugins {
    id("java")
}

group = "ru.vtvhw"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

//    implementation("org.springframework.boot:spring-boot-starter-test:3.3.3")
    implementation("org.springframework:spring-context:6.1.12")
}

tasks.test {
    useJUnitPlatform()
}