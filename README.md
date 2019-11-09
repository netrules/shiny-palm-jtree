# shiny-palm-jtree
Project using JSP and Servlet with different functions.

- Need Netbeans 8.2 with JRE 1.8.111 to run `unapec-jsp-mserver`.
- To run `unapec-jsp`, preferably use JRE13+ (for Maven compat).
- Corba-interfc files have explanation to run commands. 
	- https://docs.oracle.com/javase/7/docs/technotes/guides/idl/jidlExample.html (needs JAVA_HOME path set to 1.8.111)
		> idlj -fall  Hello.idl
		> start orbd -ORBInitialPort 1050
		> start java HelloServer -ORBInitialPort 1050 -ORBInitialHost localhost
		> java HelloClient -ORBInitialPort 1050 -ORBInitialHost localhost
		
Etc libraries are self explanatory or can be investigated. Good luck.