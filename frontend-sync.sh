
MODELNAME=retailscm
java -jar ~/githome/splitter.jar ${MODELNAME}
cd ~/githome/${MODELNAME}-biz-suite/bizui&& yarn install && yarn build && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/bizui && rsync -avz   dist/* philipz@philip.doublechaintech.cn:~/resin-3.1.12/webapps/ROOT/admin/${MODELNAME}/


