@echo off
REM ----------------------------------------------------
REM Script pour déployer tous les EJB JAR dans Docker
REM ----------------------------------------------------

REM Nom du conteneur WildFly
set CONTAINER_NAME=wildfly-ejb27

REM Dossier local contenant les JARs
set LOCAL_DIR=C:\chemin\vers\vos\ejb_jars

REM Boucle sur tous les fichiers .jar
for %%f in (%LOCAL_DIR%\*.jar) do (
    echo Déploiement de %%~nxf dans %CONTAINER_NAME%...
    docker cp "%%f" %CONTAINER_NAME%:/opt/jboss/wildfly/standalone/deployments/
)

echo Tous les JARs ont été copiés dans le conteneur !
pause
