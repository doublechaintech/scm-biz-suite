
#cd bizui && yarn build && cd ../
ssh -p 20000 philip@app.doublechaintech.com "mkdir -p ~/resin-3.1.16/webapps/ROOT/admin/retailscm/"
rsync -avz -e "ssh -p 20000" bizui/dist/* philip@demo.doublechaintech.com:~/resin-3.1.16/webapps/ROOT/admin/retailscm/

#rsync -avz bizui/dist/* philip@demo.doublechaintech.com:~/resin-3.1.12/webapps/ROOT/admin/webaccess/
#rsync -avz data/* philip@demo.doublechaintech.com:~/resin-3.1.12/webapps/webaccess/


