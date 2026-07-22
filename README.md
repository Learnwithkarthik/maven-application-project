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



| Section                      | What it shows                                                                               | Why it is important                                                                               | What you should demonstrate                                                     |
| ---------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| **Overview**                 | Overall project health and latest analysis summary                                          | Gives a quick answer to whether the project is ready to proceed                                   | Show Quality Gate status, issues, coverage and duplication                      |
| **Issues**                   | Detailed list of detected reliability, security and maintainability problems                | Helps developers identify the exact file, line and rule that needs attention                      | Open an issue, show the affected line and explain the recommended fix           |
| **Security Hotspots**        | Security-sensitive code that requires manual review                                         | Some code may be risky depending on how it is used, even when it is not a confirmed vulnerability | Open a hotspot and explain why a developer or security reviewer must inspect it |
| **Measures**                 | Detailed metrics for reliability, security, maintainability, coverage, duplication and size | Helps teams understand the project beyond a simple pass/fail result                               | Compare new-code and overall-code measurements                                  |
| **Code**                     | Source-code structure, folders, files and metrics for individual files                      | Helps locate which package, class or file is contributing most to the problems                    | Open the intentionally bad Java file and show its issues                        |
| **Activity**                 | History of previous analyses and metric changes over time                                   | Shows whether code quality is improving or becoming worse                                         | Compare the baseline scan, bad-code scan and fixed-code scan                    |
| **Project Information**      | Project key, main branch and analysis-related information                                   | Helps confirm which project and branch were analyzed                                              | Show the project key used in the Maven command                                  |
| **Project Settings**         | Configuration for analysis, new code, permissions, integrations and exclusions              | Controls how SonarQube analyzes and evaluates the project                                         | Show the New Code definition and assigned Quality Gate                          |
| **Quality Gate**             | Final pass/fail decision based on configured quality conditions                             | Prevents poor-quality code from moving further through CI/CD                                      | Show the failed condition after adding bad code                                 |
| **Quality Profile**          | The collection of analysis rules enabled for a programming language                         | Determines which coding problems SonarQube searches for                                           | Explain that Java rules and Python rules are separate                           |
| **Branches / Pull Requests** | Analysis results for different branches or pull requests                                    | Helps prevent bad code from being merged into the main branch                                     | Explain how a feature branch can be checked before merge                        |
| **Administration**           | Server-wide settings, users, permissions, plugins and system configuration                  | Required for operating and securing the SonarQube platform                                        | Explain this as an administrator section, not a normal developer section        |







| Bug type                             | Example                                        | Possible impact            |
| ------------------------------------ | ---------------------------------------------- | -------------------------- |
| Null pointer risk                    | Calling a method on a value that may be `null` | Application crash          |
| Incorrect string comparison          | `name == "admin"`                              | Wrong condition result     |
| Resource leak                        | File or database connection not closed         | Memory/resource exhaustion |
| Infinite loop                        | Loop condition never becomes false             | Application hangs          |
| Unreachable or always-true condition | `if (x > 10 && x < 5)`                         | Incorrect program logic    |
| Identical branches                   | `if` and `else` return the same value          | Logic mistake              |
| Wrong exception handling             | Empty `catch` block                            | Failure is hidden          |
| Incorrect collection usage           | Modifying a collection while iterating         | Runtime exception          |
| Unsafe `Optional` usage              | Calling `optional.get()` without checking      | `NoSuchElementException`   |
| Ignored return value                 | Ignoring a method result that must be checked  | Incorrect execution        |
| Division-related problem             | Possible division by zero                      | Runtime exception          |
| Incorrect equality/hash logic        | `equals()` and `hashCode()` inconsistent       | Wrong collection behaviour |
| Thread-safety problem                | Shared mutable data used unsafely              | Inconsistent results       |
| Improper type conversion             | Unsafe cast                                    | `ClassCastException`       |

