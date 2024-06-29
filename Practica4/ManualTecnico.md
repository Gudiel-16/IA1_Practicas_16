# Manual Tecnico

## Introduccion

Este manual técnico describe el proceso de desarrollo y configuración de una aplicación de realidad aumentada (AR) utilizando el componente Model Target de Vuforia. El objetivo de esta aplicación es identificar un objeto específico a través de la cámara de un dispositivo móvil, resaltar el objeto y señalar tres de sus partes distintivas. Este documento detalla los pasos necesarios para la configuración del entorno de desarrollo, la integración de Vuforia con Unity, la creación y entrenamiento del modelo 3D del objeto, y la generación del archivo APK ejecutable para su implementación en dispositivos móviles.

El uso del componente Model Target de Vuforia permite el reconocimiento preciso de objetos tridimensionales, lo que es esencial para aplicaciones en sectores como la manufactura, educación, y marketing. La implementación exitosa de este proyecto demuestra competencias en el manejo de tecnologías AR y en el desarrollo de aplicaciones móviles interactivas.

## Instalacion de Unity

* Ir al enlace y descargar: https://unity.com/products
    * Descargar el Unity Personal.
* Abrir el instalador.
    * Next a todo.
* Al tener instaldo Unity Hub, iniciamos sesion. 
* Nos pedira instalar Unity Editor.
    * Si no ir a Installs `->` Install Editor y lo va instalar.

## Instalacion de Vuforia

* Ir al enlace: https://developer.vuforia.com/home
    * Ir a downloads.
    * En el apartado de SDK:
        * Damos en Download for Unity.
        * Creamos cuanta o iniciamos sesion. 
        * Al estar logueados damos nuevamente en Download for Unity.
        * Nos descargara el package.
    * En el apartado de Tools:
        * Damos en Download Model Target Generator for Windows.
        * Nos descargara un .zip, dentro viene el instalador.
        * Next a todo.

## Imagenes o modelos 3D

* Ir al enlace: https://sketchfab.com/
* Buscar el modelo que vamos a utilizar.
    * Descargar el modelo en los siguientes formatos:
        * .fbx
        * .glb
* Modelo descargado:
    * Lamborghini Aventador Lowpoly Mobile game

![Lambo](./images/01.png)
![Lambo](./images/02.jpeg)

* Modelo real:

![Lambo](./images/03.jpeg)

## Crear Proyecto en Unity

* Abrimos Unity Hub.
    * New project.
    * Elegimos 3D.
    * Damos un nombre.
    * Elegimos la ubicacion a guardar proyecto.
    * Click en Create project.

## Crear el Model Target

* Abrimos Model Target Generator.
    * Damos en Create `->` Model Target.
    * En CAD Model, seleccionamos nuestro modelo en formato .glb
    * Damos un nombre.
    * Elegimos la ubicacion.
    * Click en Create.
    * Elegimos el vector que deseamos (lado de como queremos ver el modelo), click en Confirm.
    * Elegimos las dimensiones de nuestro modelo, medidas que se ajusten al modelo real, click en Confirm.
    * Seleccionamos la opcion de Non-Realistic Appearance, click en Apply Coloring.
    * Click en Next Step.
    * Elegimos la opcion de Default, click en Confirm.
    * Selecionamos la opcion de Create Advanced View, click en Next Step.
    * Selecionamos la opcion de Full 360, click en Next Step.
    * Click en Create Full 360 view.
    * Click en Generate Advanced Model Target.
    * Click en Create Database.
    * Seleccionamos nuestro model target, click en Add Model Target.
    * Click en Train, para entrenar el objeto, puede tardar unos minutos.
    * Cuando termine, damos click en Export y guardamos en la ubicacion deseada.

    ![Train](./images/04.jpeg)

## Configuracion de camara de realidad aumentada y licencia.

* Al tener abierto el proyecto en Unity Editor:
    * Agarramos el packege de vuforia y lo arrastramos en la parte de Assets de Unity Editor, nos abrira una ventana:
        * Verificamos que este todo seleccionado.
        * Click en Import.
        * Click en Update (si nos aparece).
    * En la parte izquierda, eliminamos el archivo Main Camera.
    * Click en el boton `+` y seleccionamos Vuforia Engine `->` AR Camera, click en Acept.
    * Damos click en ARCamera, nos abrira un menu de lado derecho.
        * Buscamos y damos click en donde dice Open Vuforia Engine configuration, tenemos que agregar la licencia en App License Key.
            * Vamos a la pagina de Vuforia y nos logueamos.
                * Click en My Account.
                * Click en Licenses.
                * Para crear una licencia click donde dice Get Basic.
                * Damos un nombre, click en check y click en Confirm.
                * Damos click en la licencia creada, nos mostrara un string, la copiamos.
                * Vamos a Unity Editor, donde dice App License Key, pegamos el string.

![Train](./images/05.jpeg)

## Configuracion de proyecto

* Al tener abierto el proyecto en Unity Editor:
    * Click en el boton `+` y seleccionamos Vuforia Engine `->` Model target.
    * Si nos aparece una ventana damos en skip.
    * Despues que termino de entranar el modelo y lo exportamos, abrimos la carpeta y buscamos el archivo Unity package File.
        * Arrastramos el archivo en la parte de Assets de Unity Editor.
        * Nos abrira una ventana, click en Import.
    * Damos click en el archivo ModelTarget generado y en la parte izquierda, donde dice database seleccionamos el modelo con el nombre que le dimos cuando entrenamos el modelo.
    * Ya nos aparecera nuestro modelo y podemos editarlo.
* Dentro de la descarga .fbx (nos descarga un .zip), descomprimimos, buscamos la carpeta source, el archivo que esta dentro lo importamos en assets `->` Recources del Unity Editor, esto va ser como que cuando la camara detecte el objeto este se vea remarcado como azul.
    * Arrastramos ese modelo y lo ponemos como hijo del archivo ModelTarget.
    * Lo que esta deliniado en anaranja es el objeto que acabamos de poner.
    * Cambioamos las dimensiones para que cubra al objeto ModelTarget (objeto que sale totalmente en blanco).
* Para que se vea como resaltado en azul o otros estilos, buscamos en el navegador assetstoreunity.com
    * Nos logueamos.
    * Buscamos paquete: Ultimate 10+ Shaders
    * Click en Open in Unity
    * Si ya lo teniamos
        * Click en my assets
        * Nos apareceran los paquetes, damos click en Open in Unity.
        * Click en Open link.
        * Nos aparecera una ventana en nuestra PC y damos Import.
* Para utilizar, click en nustra clase hijo, que es el archivo fbx que importamos
    * En la parte derecha nos aparecera una opcion de Materials
    * Seleccionamos el estilo que queremos.
* Para agregar un texto, click en `+` luego en 3D Object `->` Text. (lo agregamos como hijo del ModelTarget)
    * Click en import TMP Essencials.

![Train](./images/08.jpeg)

![Train](./images/09.jpeg)

![Train](./images/10.jpeg)

![Train](./images/11.jpeg)

## Simulator de Unity Editor

* Configuramos nuestro dispositivo:
    * Click en File `->` Build Settings.
    * Seleccionamos Android, nos aparecera una ventana para instalar complementos, los instalamos, cerramos Unity Editor y volvemos abrir.
    * Entramos nuevamente hasta el punto anterior.
    * Click en Switch plattform.
* Para probar, en la parte superior damos click en Simulator.
    * Nos apareceran dispositivos en los que queremos probar, podemos descargar dispositivos adicionales.
    * Seleccionamos un dispositivo.
    * En la pare superior damos click en el icono de play.
    
## Compilar para Android

* Click en File `->` Build settings.
* Click en Android.
* Click en Player Settings.
    * En la opcion de Player.
        * Minimum API Level: Oreo 8.0
        * Target API Level: highest installed
        * Scriping Backend: IL2CPP
        * Target Architectures, seleccinonar: ARMv1, ARM64
        * Cerrar ventana.
* Click en Build.
    * Seleccionamos lugar a guardar.

## Compilar para IOS

1. Abrir el proyecto en Unity.
    * Vaya a File `->` Build Settings.
    * Seleccione iOS como plataforma.
    * Haga clic en Switch Platform.
    * Configure las opciones de compilación según sus necesidades.
    * Haga clic en Player Settings y complete los detalles de su aplicación.
    * Haga clic en Build y elija una ubicación para guardar el proyecto exportado.
    * Abrir el Proyecto en Xcode

2. Navegue a la carpeta donde guardó el proyecto exportado desde Unity.
    * Abra el archivo .xcworkspace generado con Xcode.
    * Espere a que Xcode configure y cargue todos los archivos necesarios.
    * Configurar el Proyecto en Xcode

3. En Xcode: 
    * Seleccione su proyecto en la barra lateral izquierda.
    * Vaya a la pestaña General.
    * Asegúrese de que la Bundle Identifier sea única y esté correctamente configurada.
    * Seleccione su equipo de desarrollo de Apple en la sección Signing & Capabilities.
    * Active las capacidades necesarias para su aplicación, como Camera y ARKit.

## Pruebas

![Test](./images/06.jpeg)

![Test](./images/07.jpeg)
