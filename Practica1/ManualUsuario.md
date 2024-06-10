# Manual De Usuario: Bibliotecta Central

## Introducción

Este manual de usuario proporciona las instrucciones necesarias para utilizar el sistema automatizado para el registro y gestión de libros en la Biblioteca Central de la Universidad San Carlos de Guatemala. El sistema utiliza UiPath Studio y UiPath Orchestrator para automatizar la lectura y validación de códigos ISBN.


## Requisitos del Sistema

* UiPath Studio instalado.
* Acceso a UiPath Orchestrator.
* Archivo Excel con los códigos ISBN de los libros a procesar.

## Instrucciones de Uso

1. **Preparación del Archivo Excel:** Antes de iniciar el proceso, asegúrese de tener un archivo Excel con los ISBN de los libros que desea registrar. 

![Excel ISBN](/Practica1/images/1.png)

2. **Configuración del Orquestador:** Crear una Cola en UiPath Orchestrator

* Ingrese al UiPath Orchestrator.
* Cree una nueva cola con el nombre ISBNs_#pareja en la carpeta Practica1_#pareja.
* Configure los parámetros necesarios para la cola.

3. **Subir el Proceso al Orquestador:**

* En UiPath Studio, publique el proceso de lectura y búsqueda de ISBNs.
* En el Orquestador, cree un nuevo Job utilizando el proceso publicado y asígnele la cola creada anteriormente.

![publish procces](/Practica1/images/3.png)

![Transacciones](/Practica1/images/2.png)

4. **Validación y Resultados:** Verificación de Resultados

* Al finalizar el proceso, revise el archivo Excel generado con los resultados de la búsqueda.

El archivo Excel tendrá el siguiente formato:

![Resultados](/Practica1/images/4.png)

![Resultados](/Practica1/images/5.png)



