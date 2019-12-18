

MODELNAME=retailscm
DEST_HOST=philip@demo.doublechaintech.com
# java -jar ~/githome/splitter.jar ${MODELNAME}
cd ~/githome/${MODELNAME}-biz-suite/bizui && yarn build && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/bizui && rsync -avz   dist/* ${DEST_HOST}:~/resin-3.1.12/webapps/ROOT/admin/${MODELNAME}/

