
MODELNAME=retailscm
java -jar ~/githome/splitter.jar ${MODELNAME}
# cd ~/githome/${MODELNAME}-biz-suite/&& git pull --allow-unrelated-histories && cd ../
cd ~/githome/${MODELNAME}-biz-suite/bizcore&& gradle classes && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/ && rsync -avz   bizcore/* philip@demo2.doublechaintech.com:~/resin-3.1.12/webapps/${MODELNAME}/


