MODELNAME=retailscm
# manual for now, unstable cd ~/githome/skynet-common-app-framework/ && git pull
rm -rf ~/githome/-biz-suite/bizcore/WEB-INF/caf_core_src/com/skynet/paymentservice/
cd ~/githome/${MODELNAME}-biz-suite && cp -Ra ~/githome/skynet-common-app-framework/WEB-INF/caf_core_src/*  bizcore/WEB-INF/caf_core_src/
cd ~/githome/${MODELNAME}-biz-suite && cp -Ra ~/githome/skynet-common-app-framework/WEB-INF/caf_custom_src/META-INF/infra.xml  bizcore/WEB-INF/caf_custom_src/META-INF/














<<<<<<< HEAD
=======


>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
