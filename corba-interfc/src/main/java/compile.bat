:: https://www.jc-mouse.net/proyectos/corba-en-java-ejemplo-completo

:: Directorio de java SDK
:: SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_65"

:: direccion de las fuentes SRC de proyecto netbeans IDL "CorbaFiboInterface"
SET PATH_IDL="C:\Users\thisi\Desktop\tareas\Java\corba-interfc\src\main\java"

:: nombre del archivo IDL
SET IDL_NAME=Recollector.idl

:: comando para compilar
idlj -fall -td %PATH_IDL% %PATH_IDL%\%IDL_NAME%