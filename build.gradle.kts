plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Cucumber
    testImplementation("io.cucumber:cucumber-java:7.20.1")
    testImplementation("io.cucumber:cucumber-junit:7.20.1")
    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    // Selenium
    testImplementation("org.seleniumhq.selenium:selenium-java:4.8.0")
    // WebDriverManager
    testImplementation("io.github.bonigarcia:webdrivermanager:5.8.0")
    // Allure for JUnit 5 and Cucumber
    testImplementation("io.qameta.allure:allure-cucumber7-jvm:2.24.0")
    testImplementation("io.qameta.allure:allure-junit5:2.24.0")


}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}