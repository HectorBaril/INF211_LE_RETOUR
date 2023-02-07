docker-compose -f ../docker/docker-compose.yml run --rm --entrypoint "mvn -f cabinet_recrutement-ejb/pom.xml hibernate-tools:hbm2java" maven
