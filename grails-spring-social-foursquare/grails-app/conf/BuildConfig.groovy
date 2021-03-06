def springSocialVersion = "1.0.0.RELEASE"

grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
		
		grailsPlugins()
		grailsHome()
	
		mavenLocal()
		mavenCentral()
	
		mavenRepo "http://maven.springframework.org/release"
		mavenRepo "http://maven.springframework.org/snapshot"
		mavenRepo "http://maven.springframework.org/milestone"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.18'
		compile 'org.springframework.social:spring-social-foursquare:1.0.9.SNAPSHOT'
    }

    plugins {
			  compile(":spring-security-core:1.2.4")
			  compile(":spring-social-core:0.1.31")
    }
}
