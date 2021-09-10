../daas-start-kit/gencode.sh  retailscm.xml all  ./
#mysql -uroot -p0254891276 -h127.0.0.1  --default-character-set=UTF8 retailscm < data/retailscm_mysql.sql
cd bizcore && gradle classes && cd ../
#cd bizui && yarn build

#public Object collect(WebaccessUserContext userContext, String userId, String userAgent, String remoteIp, String referralURL, String accessingURL ) throws Exception {
	

#curl http://localhost:8080/webaccess/platformManager/collect/123/Chrome/1.1.1.1/http%3A%2F%2Flocalhost%3A8000%2F/http%3A%2F%2Fdemo.site.com/#
