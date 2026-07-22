# maven-application-project

mkdir -p ~/.m2
nano ~/.m2/settings.xml


settings.xml













<settings>
    <servers>
        <server>
            <id>nexus-snapshots</id>
            <username>admin</username>
            <password>admin@1234</password>
        </server>

        <server>
            <id>nexus-releases</id>
            <username>admin</username>
            <password>admin@1234</password>
        </server>
    </servers>
</settings>



installation of nexus:



sudo apt update
sudo apt install wget tar -y


cd ~

wget https://download.sonatype.com/nexus/3/nexus-3.94.0-12-linux-x86_64.tar.gz \
  -O nexus.tar.gz


tar -xzf nexus.tar.gz

mv nexus-3.94.0-12 nexus


cd ~/nexus/bin
./nexus run


cat ~/sonatype-work/nexus3/admin.password


install java maven and run application



sudo apt update
sudo apt install git openjdk-17-jdk maven -y



mvn clean package


java -jar target/employee-portal-1.0.0-SNAPSHOT.jar


pom.xml config


<distributionManagement>
    <snapshotRepository>
        <id>nexus-snapshots</id>
        <name>Nexus Snapshot Repository</name>
        <url>http://10.128.0.17:8081/repository/maven-snapshots/</url>
    </snapshotRepository>

    <repository>
        <id>nexus-releases</id>
        <name>Nexus Release Repository</name>
        <url>http:/10.128.0.17:8081/repository/maven-releases/</url>
    </repository>
</distributionManagement>


Remove annonymous user





Installing sonarqube and practical lab:

sudo apt update
sudo apt install openjdk-17-jdk unzip wget -y

wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-25.7.0.110598.zip


unzip sonarqube-25.7.0.110598.zip



cd ~/sonarqube-25.7.0.110598/bin/linux-x86-64

./sonar.sh start

./sonar.sh status

mvn clean verify sonar:sonar \
-Dsonar.projectKey=employee-portal \
-Dsonar.projectName=employee-portal \
-Dsonar.host.url=http://localhost:9000 \
-Dsonar.token=YOUR_TOKEN


mkdir -p src/main/java/com/example/employeeportal/service

nano src/main/java/com/example/employeeportal/service/BadCodeService.java


package com.example.employeeportal.service;

import java.io.FileInputStream;
import java.io.IOException;

public class BadCodeService {

    private String password = "Admin@123";
    private String unusedField = "Not required";

    public void processEmployee(String employeeName) {

        String unusedLocalVariable = "Unused value";

        if (employeeName != null) {
            if (!employeeName.isEmpty()) {
                if (employeeName.equals("admin")) {
                    System.out.println("Admin employee logged in");
                }
            }
        }
    }

    public int calculateBonus(int salary) {
        if (salary > 100000) {
            return salary * 10 / 100;
        } else {
            return salary * 10 / 100;
        }
    }

    public void readEmployeeFile(String fileName) {
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            inputStream.read();
        } catch (IOException exception) {
        }
    }

    public void duplicateProcessOne() {
        System.out.println("Starting employee processing");
        System.out.println("Validating employee details");
        System.out.println("Checking employee department");
        System.out.println("Checking employee salary");
        System.out.println("Calculating employee benefits");
        System.out.println("Updating employee status");
        System.out.println("Saving employee information");
        System.out.println("Sending employee notification");
        System.out.println("Completing employee processing");
        System.out.println("Employee processing completed");
    }

    public void duplicateProcessTwo() {
        System.out.println("Starting employee processing");
        System.out.println("Validating employee details");
        System.out.println("Checking employee department");
        System.out.println("Checking employee salary");
        System.out.println("Calculating employee benefits");
        System.out.println("Updating employee status");
        System.out.println("Saving employee information");
        System.out.println("Sending employee notification");
        System.out.println("Completing employee processing");
        System.out.println("Employee processing completed");
    }

    public boolean checkEmployee(String employeeName) {
        if (employeeName == "Karthikeya") {
            return true;
        }

        return false;
    }
}




Poper code:

package com.example.employeeportal.service;

import java.io.FileInputStream;
import java.io.IOException;

public class BadCodeService {

    public void processEmployee(String employeeName) {
        if (employeeName == null || employeeName.isBlank()) {
            return;
        }

        if ("admin".equalsIgnoreCase(employeeName)) {
            System.out.println("Admin employee logged in");
        }
    }

    public int calculateBonus(int salary) {
        return salary * 10 / 100;
    }

    public void readEmployeeFile(String fileName) {
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            inputStream.read();
        } catch (IOException exception) {
            System.err.println(
                "Unable to read employee file: " + exception.getMessage()
            );
        }
    }

    public boolean checkEmployee(String employeeName) {
        return "Karthikeya".equals(employeeName);
    }
}
