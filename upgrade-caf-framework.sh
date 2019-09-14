MODELNAME=retailscm
cd ~/githome/skynet-common-app-framework/ && git pull
cd ~/githome/${MODELNAME}-biz-suite && cp -Ra ~/githome/skynet-common-app-framework/WEB-INF/caf_core_src/*  bizcore/WEB-INF/caf_core_src/
cd ~/githome/${MODELNAME}-biz-suite && cp -Ra ~/githome/skynet-common-app-framework/WEB-INF/caf_custom_src/META-INF/infra.xml  bizcore/WEB-INF/META-INF/caf_custom_src/














