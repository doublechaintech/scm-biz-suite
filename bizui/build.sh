# !/bin/bash
DATE=`date '+%Y-%m-%d %H:%M:%S'`
commit "make a temporay commit on $DATE"
yarn build
rsync -avz   dist/* philipz@philip.doublechaintech.cn:/home/philipz/resin-3.1.12/webapps/ROOT/admin/retailscm/
~/tool/mails philip_chang@163.com "Build RetailSCM Console DONE" "please start to use it https://test01.nodeart.net/admin/index.html#"

