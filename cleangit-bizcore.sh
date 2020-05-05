# !/bin/bash

git add .
git commit -m"commit for removing extra files"
git pull
git push
git filter-branch --force --index-filter 'git rm -r —cached --ignore-unmatch bizcore2' --prune-empty --tag-name-filter cat -- --all
git commit -m"remove  extra class"
git push origin --force --all


