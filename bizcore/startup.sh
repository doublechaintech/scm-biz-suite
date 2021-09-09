#!/bin/bash

echo "开始编译应用程序";
project_dir=${SKYNET_OUTPUT_FOLDER:-~/githome}/shuxiang
docker run --rm -v $project_dir:/root/app -v `echo ~`/.gradle:/root/.gradle dockerhub.doublechaintech.cn/basic/gradle
rm -rf ~/sky/webapps/shuxiang
rm -rf ~/sky/statics/shuxiang
mkdir -p ~/sky/webapps/shuxiang ~/sky/statics/shuxiang
unzip -o $project_dir/build/libs/shuxiang.war -d ~/sky/webapps/shuxiang
cp -r $project_dir/statics/* ~/sky/statics/shuxiang
echo "开始编译界面"
docker run --rm -v $project_dir/admin:/root/admin -w /root/admin node:9-alpine sh -c 'yarn --registry https://registry.npm.taobao.org install && yarn --registry https://registry.npm.taobao.org run build'
mkdir -p ~/sky/statics/admin/shuxiang
cp -r $project_dir/admin/dist/* ~/sky/statics/admin/shuxiang
echo "开始编译数据罗盘"
docker run --rm -v $project_dir/datacompass:/root/datacompass -w /root/datacompass node:9-alpine sh -c 'yarn --registry https://registry.npm.taobao.org install && yarn --registry https://registry.npm.taobao.org run build'
mkdir -p ~/sky/statics/datacompass/shuxiang
cp -r $project_dir/datacompass/build/* ~/sky/statics/datacompass/shuxiang
container_count=`docker ps -f name=demo_resin -f name=demo_nginx -q|wc -l`
if [ $container_count -lt 3 ]; then
    echo "启动应用"
    docker-compose -p demo -f $project_dir/docker-compose.yml down
    docker-compose -p demo -f $project_dir/docker-compose.yml up -d
fi

