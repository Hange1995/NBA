export CATALINA_OPTS="$CATALINA_OPTS -Ddatabase.driver=org.postgresql.Driver"
export CATALINA_OPTS="$CATALINA_OPTS -Ddatabase.dialect=org.hibernate.dialect.PostgreSQL9Dialect"
export CATALINA_OPTS="$CATALINA_OPTS -Ddatabase.url=jdbc:postgresql://172.17.0.3:5432/nba"
export CATALINA_OPTS="$CATALINA_OPTS -Ddatabase.user=admin"
export CATALINA_OPTS="$CATALINA_OPTS -Ddatabase.password=password"
export CATALINA_OPTS="$CATALINA_OPTS -Dspring.profiles.active=dev"
export CATALINA_OPTS="$CATALINA_OPTS -Daws.region=us-east-1"
export CATALINA_OPTS="$CATALINA_OPTS -Daws.bucket.name=bucket-for-hange"
export CATALINA_OPTS="$CATALINA_OPTS -Daws.sqs=nba-hange"