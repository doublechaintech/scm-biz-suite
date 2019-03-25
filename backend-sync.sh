
MODELNAME=retailscm
java -jar ~/githome/splitter.jar ${MODELNAME}
cd ~/githome/${MODELNAME}-biz-suite/&& git pull --allow-unrelated-histories && cd ../
cd ~/githome/${MODELNAME}-biz-suite/bizcore&& gradle classes && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/ && rsync -avz   bizcore/* philipz@philip.doublechaintech.cn:~/resin-3.1.12/webapps/${MODELNAME}/
ssh philipz@philip.doublechaintech.cn "mysql -uroot -p0254891276 -h 127.0.0.1 < resin-3.1.12/webapps/${MODELNAME}/WEB-INF/${MODELNAME}_core_src/META-INF/${MODELNAME}_mysql.sql"

