# !/bin/bash
projectname="retailscm-biz-suite"
echo "# $projectname " >> README.md
git init
git add -A .
git commit -m "first commit"
git remote add origin https://github.com/doublechaintech/$projectname.git
git push -u origin master
