
MODELNAME=retailscm
DEST_HOST=philip@demo.doublechaintech.com
cd ~/githome/${MODELNAME}-biz-suite/ && rm -rf bizcore/WEB-INF/${MODELNAME}_core_src
java -jar ~/githome/splitter.jar ${MODELNAME}
# cd ~/githome/${MODELNAME}-biz-suite/&& git pull --allow-unrelated-histories && cd ../
cd ~/githome/${MODELNAME}-biz-suite/bizcore&& ~/.sdkman/candidates/gradle/5.2.1/bin/gradle classes && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/ && rsync -avz   bizcore/* ${DEST_HOST}:~/resin-3.1.12/webapps/${MODELNAME}/
ssh ${DEST_HOST} "mysqldump -h127.0.0.1  -u root --password=0254891276 --skip-quick --skip-tz-utc --skip-dump-date --skip-set-charset --skip-quote-names --skip-comments ${MODELNAME} > backup/${MODELNAME}.$(date +%Y%m%dT%H%M%S).sql"
ssh ${DEST_HOST} "mysql -uroot -p0254891276 -h 127.0.0.1 < resin-3.1.12/webapps/${MODELNAME}/WEB-INF/${MODELNAME}_core_src/META-INF/${MODELNAME}_mysql.sql"

