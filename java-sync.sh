
<<<<<<< HEAD
=======
export SDKMAN_DIR="$HOME/.sdkman"
[[ -s "$HOME/.sdkman/bin/sdkman-init.sh" ]] && source "$HOME/.sdkman/bin/sdkman-init.sh"


>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
MODELNAME=retailscm
DEST_HOST=philip@demo.doublechaintech.com
cd ~/githome/${MODELNAME}-biz-suite/ && rm -rf bizcore/WEB-INF/${MODELNAME}_core_src
java -jar ~/githome/splitter.jar ${MODELNAME}
<<<<<<< HEAD
# cd ~/githome/${MODELNAME}-biz-suite/&& git pull --allow-unrelated-histories && cd ../
=======
cd ~/githome/${MODELNAME}-biz-suite/&& git pull --allow-unrelated-histories && cd ../
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
cd ~/githome/${MODELNAME}-biz-suite/bizcore&& gradle classes && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/ && rsync -avz   bizcore/* ${DEST_HOST}:~/resin-3.1.12/webapps/${MODELNAME}/


