plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Cucumber
    testImplementation("io.cucumber:cucumber-java:7.20.1")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.20.1")
    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    // Selenium
    implementation("org.seleniumhq.selenium:selenium-java:4.32.0")
    implementation("org.seleniumhq.selenium:selenium-devtools-v136:4.32.0")
    // WebDriverManager
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    // Allure for JUnit 5 and Cucumber
    testImplementation("io.qameta.allure:allure-cucumber7-jvm:2.27.0")
}

allure {
    version.set("2.27.0")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("cucumber.plugin", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
    systemProperty("allure.results.directory", "build/allure-results")
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}

tasks.register<Exec>("openAllureReport") {
    commandLine("allure", "open", "build/reports/allure-report/allureReport")
}
