# Ubuntu
<hr>

## apt command
deb 패키지 설치위치 `/var/cache/apt/archive` 
- update
- upgrate
- install
- reinstall
- remove
- purge
- autoremove
- list
	- | grep packge_name	특정 패키지 설치확인
	- --installed 			설치된 패키지 유형만 나열
	- --upgradeble			업그레이드 가능한 패키지 목록
- search [package_name]		지정된 패키지 검색
- show [package_name]		패키지 정보 검색

## 검색

- --version 버전 확인 
- which 	PATH에 설정된 디렉토리만 검색
- whereis 
- locate

## jdk package 설치

```ubuntu
# java --version 버전확인
# apt update && upgrade
# apt install [openjdk 11 또는 8]
# vim ~/.bashrc


	export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java))))
	export PATH=$PATH:$JAVA_HOME/bin


# vim /etc/profile


	export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/bin/java
	export PATH=$JAVA_HOME/bin:$PATH
	export CLASSPATH=$CLASSPATH:$JAVA_HOME/lib 


# source ~/.bashrc
# source /etc/profile
# echo $JAVA_HOME
```