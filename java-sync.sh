
MODELNAME=retailscm
DEST_HOST=philip@demo.doublechaintech.com
cd ~/githome/${MODELNAME}-biz-suite/ && rm -rf bizcore/WEB-INF/${MODELNAME}_core_src
java -jar ~/githome/splitter.jar ${MODELNAME}
# cd ~/githome/${MODELNAME}-biz-suite/&& git pull --allow-unrelated-histories && cd ../
cd ~/githome/${MODELNAME}-biz-suite/bizcore&& gradle classes && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/ && rsync -avz   bizcore/* ${DEST_HOST}:~/resin-3.1.12/webapps/${MODELNAME}/


