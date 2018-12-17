
import React, { Component } from 'react';
import dva, { connect } from 'dva';
import { Router, Route } from 'dva/router';

import LauncherModel from './Launcher.model'
import LauncherRouter from './Launcher.router'
import CommunityModel from '../bizcomponents/community/Community.model'
import UserDomainModel from '../bizcomponents/userdomain/UserDomain.model'
import CommunityUserModel from '../bizcomponents/communityuser/CommunityUser.model'

const createLauncherApp =()=>
{
    const app = dva();
    app.model(LauncherModel);
    app.model(UserDomainModel);
    app.model(CommunityModel);
    app.model(CommunityUserModel);
    
    
    app.router(({history}) => <LauncherRouter />);
    return app;
}

export default createLauncherApp;

