

import GlobalComponents from './'
import About from './about/About'
import { Router, Route, Switch } from 'dva/router'
const extra=[
    {path:'/about',component:About},
];
//<Route path="/bookSharingPlatform/" component={BookSharingPlatformBizApp} />
const ExtraRouter=()=>{

    return extra.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))
    //return null


} 

export default ExtraRouter;