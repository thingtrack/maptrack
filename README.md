MapTrack Workbench
==================================

Sources for the official [Thingtrack](http://www.thingtrack.com/) maptrack application: http://www.thingtrack.com/

![Maptrack Workbench](https://cloud.githubusercontent.com/assets/1216181/8136985/6bc829ba-1140-11e5-888a-a2c87ffc5f58.png)

Running the App
==
Run the Maven 'install' for each project target and deploy the resulting WAR file to your Java application server.

Licenses
==
The source code is released under Apache 2.0.

The application uses: 
- [MySQL Connector v5.1.6](http://dev.mysql.com/downloads/connector/j/) framework by Oracle, which is released under GPL 2.0: http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
- [JPA Eclipse Link v2.4.2](http://www.eclipse.org/eclipselink/) framework by Eclipse, which is released under EPL v1.0 : http://www.eclipse.org/legal/epl-v10.html
- [Spring v3.0.5.RELEASE](https://spring.io/) framework by Spring, which is released under Apache License 2.0: http://www.apache.org/licenses/LICENSE-2.0.html
- [Vaadin v6.8.5](https://vaadin.com/home) framework by Vaadin, which is released under Apache License 2.0: http://www.
apache.org/licenses/LICENSE-2.0.html
- [Vaadin Touchkit v2.1.0](https://vaadin.com/add-ons/touchkit) framework by Vaadin Touchkit, which is released under Apache License 2.0: http://www.
apache.org/licenses/LICENSE-2.0.html
- [Spring Spring Stuff v1.0.28](https://vaadin.com/directory#!addon/spring-stuff) add-on by Archie Cobbs, which is released under Apache License 2.0: http://www.apache.org/licenses/LICENSE-2.0.html
- [OpenLayers Wrapper v1.2.0](https://vaadin.com/directory#!addon/openlayers-wrapper) add-on by Matti Tahvonen, which is released under Apache License 2.0: http://www.apache.org/licenses/LICENSE-2.0.html
- [FormBinder v2.0.0](https://vaadin.com/directory#!addon/formbinder) add-on by Matti Tahvonen, which is released under Apache License 2.0: http://www.apache.org/licenses/LICENSE-2.0.html
- [SuperImmediateTextField v1.0.0](https://vaadin.com/directory#!addon/superimmediatetextfield) add-on by Henrik Paul, which is released under Apache License 2.0: http://www.apache.org/licenses/LICENSE-2.0.html
- [AddThis v1.0.2](https://vaadin.com/directory#!addon/addthis) add-on by Sami Ekblad, which is released under Apache License 2.0: http://www.apache.org/licenses/LICENSE-2.0.html
- [Zxing v1.7](https://github.com/zxing/zxing) add-on by Sami Ekblad, which is released under Apache License 2.0: http://www.apache.org/licenses/LICENSE-2.0.html

Directory Structure
-------------------

	  |-konekti.map/ ................... Parent project pom with many common dependencies
	  |-konekti.map.dao.api/ ........... Persistence API
	  |-konekti.map.dao.impl/ .......... Persistence API Implementation
	  |-konekti.map.doamin/ ............ Domain Layer
	  |-konekti.map.service.api/ ....... Service API
	  |-konekti.map.service.impl/ ...... Service API Implementation	  
	  |-konekti.map.mobile/ ............ Mobile Web Application
	  |-konekti.map.workbench/ ......... Web Application
	  |-konekti.maven.parent/ .. ....... Pom Parent Project
	  |-license ........................ Commercial License
	  '-README.md ...................... Release readme