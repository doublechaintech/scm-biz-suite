
MODELNAME=retailscm
java -jar ~/githome/splitter.jar ${MODELNAME}
# cd ~/githome/${MODELNAME}-biz-suite/&& git pull --allow-unrelated-histories && cd ../
cd ~/githome/${MODELNAME}-biz-suite/bizcore&& ~/.sdkman/candidates/gradle/5.2.1/bin/gradle classes && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/ && rsync -avz   bizcore/* philip@demo2.doublechaintech.com:~/resin-3.1.12/webapps/${MODELNAME}/
ssh philip@demo2.doublechaintech.com "mysql -uroot -p0254891276 -h 127.0.0.1 < resin-3.1.12/webapps/${MODELNAME}/WEB-INF/${MODELNAME}_core_src/META-INF/${MODELNAME}_mysql.sql"
cd ~/githome/${MODELNAME}-biz-suite/bizui&& yarn install && yarn build && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/bizui && rsync -avz   dist/* philip@demo2.doublechaintech.com:~/resin-3.1.12/webapps/ROOT/admin/${MODELNAME}/

