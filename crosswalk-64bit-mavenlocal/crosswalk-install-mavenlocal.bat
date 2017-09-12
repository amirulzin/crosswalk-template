@echo off
mvn install:install-file "-DgroupId=org.xwalk" "-DartifactId=xwalk_core_library" "-Dversion=23.53.589.4-64bit" "-Dpackaging=aar" "-Dfile=crosswalk-23.53.589.4-64bit.aar" "-DgeneratePom=true"
pause