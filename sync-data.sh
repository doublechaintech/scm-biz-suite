

rsync -avz -e "ssh -p 20000" data/* philip@demo.doublechaintech.com:~/
ssh -p 20000 philip@app.doublechaintech.com "mysql -uroot -p0254891276 -h 127.0.0.1 < ~/retailscm_mysql.sql"




