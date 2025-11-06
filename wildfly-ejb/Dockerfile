FROM quay.io/wildfly/wildfly:27.0.0.Final-jdk17

# Déploie ton EJB
COPY ejb1.jar /opt/jboss/wildfly/standalone/deployments/

# Expose les ports internes du conteneur (pas forcément ceux de l’hôte)
EXPOSE 8080 9990
