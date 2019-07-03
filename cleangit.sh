# !/bin/bash

git add .
git commit -m"commit for removing extra files"
git pull
git push
git filter-branch --force --index-filter 'git rm -r —cached --ignore-unmatch bizcore/WEB-INF/retailscm_core_src/META-INF/retailscm_mysql.sql' --prune-empty --tag-name-filter cat -- --all
git filter-branch --force --index-filter 'git rm -r —cached --ignore-unmatch bizcore/.gradle' --prune-empty --tag-name-filter cat -- --all
git filter-branch --force --index-filter 'git rm -r —cached --ignore-unmatch bizcore/WEB-INF/caf_custom_src/META-INF/infra.properties' --prune-empty --tag-name-filter cat -- --all
git filter-branch --force --index-filter 'git rm -r —cached --ignore-unmatch bizcore/WEB-INF/lib' --prune-empty --tag-name-filter cat -- --all
git filter-branch --force --index-filter 'git rm -r —cached --ignore-unmatch bizcore/README.md' --prune-empty --tag-name-filter cat -- --all
git filter-branch --force --index-filter 'git rm -r —cached --ignore-unmatch bizcore/build' --prune-empty --tag-name-filter cat -- --all
git filter-branch --force --index-filter 'git rm -r —cached --ignore-unmatch bizui/dist' --prune-empty --tag-name-filter cat -- --all
git commit -m"remove  extra class"
git push origin --force --all


