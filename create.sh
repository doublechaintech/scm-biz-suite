# !/bin/bash

projectname="$1-biz-suite"
git clone https://github.com/philipgreat/client-biz-suite.git  $projectname 
rm -rf $projectname/.git
echo "$projectname" >> $projectname/projectname
echo "copying bizcore..........$projectname/bizcore/"
cp -Ra skynet-common-app-framework/*  "$projectname/bizcore/"
echo "moving folder to upper structure...."
mv $projectname/bizcore/viewlayers/* $projectname/bizcore
mv $projectname/bizcore/statics/* $projectname/bizcore
echo "copying bizui..........to $projectname/bizui/"
cp -Ra skynet-react-framework/. "$projectname/bizui/"
rm -rf "$projectname/bizui/.git"
rm -rf "$projectname/bizui/src/axios/config.js"
rm -rf "$projectname/bizcore/.classpath"
rm -rf "$projectname/bizcore/.project"
echo "repalcing __project_name__ to $projectname in gitinit.sh"
sed -i -e  "s/__project_name__/$projectname/g" $projectname/gitinit.sh 
echo "repalcing __project_name__ to $projectname in deploy.sh"
sed -i -e  "s/__project_name__/$projectname/g" $projectname/deploy.sh 
echo "done....do not forget create an EMPTY git repository!!"



