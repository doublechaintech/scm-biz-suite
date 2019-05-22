
MODELNAME=retailscm
java -jar ~/githome/splitter.jar ${MODELNAME}
cd ~/githome/${MODELNAME}-biz-suite/bizui&& yarn install && yarn build && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/bizui && rsync -avz   dist/* philip@demo2.doublechaintech.com:~/resin-3.1.12/webapps/ROOT/admin/${MODELNAME}/



