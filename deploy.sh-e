# !/bin/bash

function deploy(){
    local projname="__project_name__"

    if [ -z "$projname" ]; then
       echo "no project name provided"
       return 1
    fi
    echo "deploying project ........................ $projname"	
    #return 5
    ssh    philipz@philip.doublechaintech.cn "mkdir resin-3.1.12/webapps/$projname"
    rsync -avz   bizcore/* philipz@philip.doublechaintech.cn:/home/philipz/resin-3.1.12/webapps/$projname/
    ssh    philipz@philip.doublechaintech.cn "rm resin-3.1.12/webapps/$projname/WEB-INF/lib"
    ssh    philipz@philip.doublechaintech.cn "mkdir resin-3.1.12/webapps/$projname/WEB-INF/lib"
    rsync -avz  bizcore/WEB-INF/lib/* philipz@philip.doublechaintech.cn:/home/philipz/resin-3.1.12/webapps/$projname/WEB-INF/lib/
    ssh    philipz@philip.doublechaintech.cn "mysql -uroot -p0254891276 -h 127.0.0.1 < resin-3.1.12/webapps/$projname/WEB-INF/classes/META-INF/${projname}_mysql.sql"
    ssh    philipz@philip.doublechaintech.cn "mkdir -p resin-3.1.12/webapps/ROOT/admin/$projname"
    ssh    philipz@philip.doublechaintech.cn "mkdir -p resin-3.1.12/webapps/ROOT/datacompass/$projname"
    rsync -avz   bizui/dist/* philipz@philip.doublechaintech.cn:/home/philipz/resin-3.1.12/webapps/ROOT/admin/$projname/

}


deploy 
