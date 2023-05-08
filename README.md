# ProyectoFCT
<h1 align="center"> GESTOR DE TICKETS </h1>
 <p align="left">
   <img src="https://img.shields.io/badge/spring--boot-v3.0.6-green">
  <img src="https://img.shields.io/badge/Status-En%20desarrollo-yellowgreen">
 </p>
 <h2>ÍNDICE</h2>
 <ul>
  <li>Descripción del proyecto</li>
  <li>Fucionalidades</li>
  <li>Herramientas utilizadas</li>
  <li>Instrucciones</li>
 </ul>
 <h2>DESCRIPCIÓN</h2>
 <p>El gestor de tickets nos permitirá extraer información de las transacciones del día de la tienda y el día que seleccionemos. Para ello, en primer lugar hay que introducir en la base de datos los archivos XML con las operaciones del día. Se podrán introducir los tickets uno a uno o todos los que estén alojados en una determinada carpeta a la vez. Esto último sería lo ideal, la idea es persistir en la base de datos todas las operaciones del día a la vez.</p>
 <p>Una vez tenemos los datos persistidos podremos seleccionar la fecha y la tienda de la que queremos consultar datos. Se verán unas tablas con información de los productos y formas de pago y también se podrá acceder a un resumen de las operaciones del día agrupadas por categoría.</p>
 <p>Pulsando un botón de la página podremos generar archivos XML y XLSX de estos resúmenes. Estos archivos se alojarán en una ruta determinada de nuestro ordenador.</p>
 <h2>HERRAMIENTAS UTILIZADAS</h2>
 <ul>
  <li>Java 17</li>
  <li>Spring Boot 3.0.6</li>
  <li>Wampserever 3.3.0</li>
  <li>Thyme Leaf</li>
  <li>Javascript</li>
 </ul>
 <h2>INSTRUCCIONES</h2>
 <p>Para la creación de este proyecto de Spring Boot he utilizado el IDE IntellyJ Idea y voy a explicar los pasos para arrancar el servicio con este IDE, aunque con otros como Eclipse es parecido.</p>
 <p>En primer lugar, hay que abrir el proyecto Maven. File ---> Open y seleccionamos la carpeta del proyecto</p>

![abrir_proyecto](https://user-images.githubusercontent.com/113421154/236774899-fb01d3ef-2de4-4c8e-b793-0da45c43a723.png)


<p>Para echar a andar el servicio la primera vez es necesario crear una configuración para ello. Para ello, nos vamos a Edit Configurations en la esquina superior derecha</p>

![editar_conf](https://user-images.githubusercontent.com/113421154/236775307-0feb0827-4422-454d-babd-dac22cdc306b.png)



<p>Y creamos una nueva configuración para Maven y seleccionamos en el recuadro de Run la opción spring-boot:run</p>

![editConf](https://user-images.githubusercontent.com/113421154/236772765-b02251ab-35fd-4d4f-825e-5531c1850d17.gif)
<p>Antes de arrancar el servicio es necesario crear la base de datos en nuestro gestor. El nombre debe ser FCT, como tenemos indicado en el archivo de configuración application properties. Ésto se debe a que al arrancar el proyecto Spring Boot va a buscar esa base de datos para crear las tablas. También es necesario que MySql utilice el puerto 3306 que viene por defecto y el usuario "root" sin contraseña.</p>
<p>
  
  ![application_properties](https://user-images.githubusercontent.com/113421154/236778151-cfeb96af-71c1-4817-8956-cc18d54dab48.png)

 </p>
<p>Para ellos vamos a nuestro wampserver y en abrimos phpmyadmin para gestionar la base de datos.</p>
  
![wampserver](https://user-images.githubusercontent.com/113421154/236776449-e944d2ae-88cd-477a-8ec8-12f4a3caeae4.png)
<p>Allí simplemente pulsamos en "Nueva" para crear una nueva base de datos a la que debemos llamar "fct"</p>
  ![phpMyAdmin](https://user-images.githubusercontent.com/113421154/236777096-21dfe055-4184-49d9-97c7-f5af8464cc7d.png)
  
<p>Por último, el proyecto utiliza unas tablas maestras que debemos tener con información. Hay que introducir el siguiente Script SQL: </p>
[ScriptTablasMaestras.txt](https://github.com/HectorVara/ProyectoFCT/files/11419494/ScriptTablasMaestras.txt)<br>
Después de esto ya podemos arrancar el proyecto Spring Boot con la configuración que hemos creado e irnos a https://localhost:8080 para empezar a navegar por la página

