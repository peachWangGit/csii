rem ===========================================================================================
rem JVM Configuration
rem ===========================================================================================

set BASE_DIR=%~dp0
set CLASSPATH=.;%BASE_DIR%conf;%CLASSPATH%

set "JAVA_OPT=-server -Xms4g -Xmx4g -Xmn2g"

set "JAVA_OPT=%JAVA_OPT% -Djava.ext.dirs=%BASE_DIR%..\lib"
rem JAVA_OPT="${JAVA_OPT} -Xdebug -Xrunjdwp:transport=dt_socket,address=9555,server=y,suspend=n"
set "JAVA_OPT=%JAVA_OPT% -cp %CLASSPATH%"


java %JAVA_OPT% -cp %CLASSPATH% com.csii.demo.usr.start.UsrStart