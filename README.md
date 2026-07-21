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
