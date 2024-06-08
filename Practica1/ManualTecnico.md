# Manual Tecnico

## Conexcion al orquestador

1. Ingresar e iniciar sesion:
    * https://cloud.uipath.com/
2. Ingresamos a la opcion de `Orchestrator`.
3. Ingresamos a la opcion de `Tenant`.
4. Vamos a la opcion de `Machines`.
    * Verificamos que nos salga nuestra maquina.
5. Vamos a la opcion de de `Manage Access`.
    * Buscamos nuestro usuario, click en los 3 puntos y `edit`.
    * Paso 1 por defecto.
    * Paso 2 por defecto.
    * Paso 3:
        * Activamos el `check` de `Enable this user to run unattended automations`.
        * Seleccionamos la opcion de `Specific Windows credentials`.
        * Ingresamos el `Domain\Username`.
            * Para ver el dominio en CMD de nuestra PC, es con el comando `whoamI`.
        * Ingresamos el password de nuestra PC.
    * Click en `Update`.

## Crear carpeta en el orquestador

1. Ingresamos a la opcion de `Orchestrator`.
2. Ingresamos a la opcion de `Tenant`.
3. Click en `New Folder`.
    * Damos un nombre, este caso `Practica1_16`.

## Configurar la maquina a la carpeta

1. Ingresamos a nuestra carpeta `Practica1_16`.
2. Vamos a `Settings`.
3. Vamos a `Machines`.
4. Click en `Manage Machines in Folder`.
5. Seleccionamos nuestra maquina configurada anteriormente.
6. Click en `Update`.

## Publicar nuestro processo en el orquestador

1. En `UIPath Studio` en la parte inferior derecha, aparecen los nombres de las carpetas que ya existen en el orquestador, si no aparece la carpeta que creamos damos en `Refresh` (A un lado de donde aparecen los nombres de carpetas).
2. En la parte superiror, damos click en `Publish`.
3. Ingresamos el `Package Name`.
4. Click en `Next`.
5. En `Publish to` dejamos la opcion de `Orchestador tenant processess Feed`.
6. Click en `Publish`.

## Crear el proceso y ejecutar en el orquestador

1. Ingresamos a nuestra carpeta `Practica1_16`.
2. Vamos a `Automations`.
3. Vamos a `Processes`.
4. Click en `Add process`.
5. En `Package Source Name` seleccionamos el proceso publicado con su version.
6. Click en `Next`.
7. Paso 2, click en `Next`.
8. Paso 3:
    * Ingresamos el `Display Name` o dejamos en blanco para que ponga el nombre por default (en este caso se dejo en blanco).
9. Click en `Create`.
10. Click en `Close`.
11. Para ejecutar:
    * Click en icono de `play (Start a job)`.
    * En la ventana que nos sale:
        * Verificar el nombre del proceso a ejecutar.
        * Cuenta y maquina (Se deja por defecto si solo tenemos una cuenta y maquina).

## Crear cola en el orquestador

1. Ingresamos a nuestra carpeta `Practica1_16`.
2. Vamos a `Queues`.
3. Click en `Add Queues`.
    * Click en `Create a new queue`.
    * Ingresamos `Name`, en este caso `ISBNs_16`.
4. Click en `Add`.
5. Para ver las transacciones:
    * Click en `3 puntos`.
    * Click en `View Transactions`.