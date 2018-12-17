import React, { Component } from 'react';
import { Router, Route, hashHistory, IndexRedirect } from 'react-router';
import Launcher from './Launcher.js'
import HomeScreen from './HomeScreen.js'
import LoginForm from './LoginForm.js'
import Page from './Page'
import CommunityAppInfo from '../bizcomponents/community'
import CommunityBizApp from '../bizcomponents/community/Community.app.js'
import CommunityDashboard from '../bizcomponents/community/Community.dashboard.js'

import InvitationCodeBizApp from '../bizcomponents/invitationcode/InvitationCode.app.js'
import InvitationCodeDashboard from '../bizcomponents/invitationcode/InvitationCode.dashboard.js'

import HomePageBizApp from '../bizcomponents/homepage/HomePage.app.js'
import HomePageDashboard from '../bizcomponents/homepage/HomePage.dashboard.js'

import SlideBizApp from '../bizcomponents/slide/Slide.app.js'
import SlideDashboard from '../bizcomponents/slide/Slide.dashboard.js'

import EncyclopediaItemBizApp from '../bizcomponents/encyclopediaitem/EncyclopediaItem.app.js'
import EncyclopediaItemDashboard from '../bizcomponents/encyclopediaitem/EncyclopediaItem.dashboard.js'

import TaskPageBizApp from '../bizcomponents/taskpage/TaskPage.app.js'
import TaskPageDashboard from '../bizcomponents/taskpage/TaskPage.dashboard.js'

import TaskFilterBizApp from '../bizcomponents/taskfilter/TaskFilter.app.js'
import TaskFilterDashboard from '../bizcomponents/taskfilter/TaskFilter.dashboard.js'

import CommunityUserBizApp from '../bizcomponents/communityuser/CommunityUser.app.js'
import CommunityUserDashboard from '../bizcomponents/communityuser/CommunityUser.dashboard.js'

import PatientInfoBizApp from '../bizcomponents/patientinfo/PatientInfo.app.js'
import PatientInfoDashboard from '../bizcomponents/patientinfo/PatientInfo.dashboard.js'

import UserSkillBizApp from '../bizcomponents/userskill/UserSkill.app.js'
import UserSkillDashboard from '../bizcomponents/userskill/UserSkill.dashboard.js'

import MessageFilterBizApp from '../bizcomponents/messagefilter/MessageFilter.app.js'
import MessageFilterDashboard from '../bizcomponents/messagefilter/MessageFilter.dashboard.js'

import UserMessageBizApp from '../bizcomponents/usermessage/UserMessage.app.js'
import UserMessageDashboard from '../bizcomponents/usermessage/UserMessage.dashboard.js'

import TaskBizApp from '../bizcomponents/task/Task.app.js'
import TaskDashboard from '../bizcomponents/task/Task.dashboard.js'

import TaskAssigmentBizApp from '../bizcomponents/taskassigment/TaskAssigment.app.js'
import TaskAssigmentDashboard from '../bizcomponents/taskassigment/TaskAssigment.dashboard.js'

import TaskHidingBizApp from '../bizcomponents/taskhiding/TaskHiding.app.js'
import TaskHidingDashboard from '../bizcomponents/taskhiding/TaskHiding.dashboard.js'

import TaskResolvingBizApp from '../bizcomponents/taskresolving/TaskResolving.app.js'
import TaskResolvingDashboard from '../bizcomponents/taskresolving/TaskResolving.dashboard.js'

import TaskRewardBizApp from '../bizcomponents/taskreward/TaskReward.app.js'
import TaskRewardDashboard from '../bizcomponents/taskreward/TaskReward.dashboard.js'

import TaskLikeBizApp from '../bizcomponents/tasklike/TaskLike.app.js'
import TaskLikeDashboard from '../bizcomponents/tasklike/TaskLike.dashboard.js'

import TaskReplyBizApp from '../bizcomponents/taskreply/TaskReply.app.js'
import TaskReplyDashboard from '../bizcomponents/taskreply/TaskReply.dashboard.js'

import TaskBestAnswerSettingBizApp from '../bizcomponents/taskbestanswersetting/TaskBestAnswerSetting.app.js'
import TaskBestAnswerSettingDashboard from '../bizcomponents/taskbestanswersetting/TaskBestAnswerSetting.dashboard.js'

import TaskReplyLikeBizApp from '../bizcomponents/taskreplylike/TaskReplyLike.app.js'
import TaskReplyLikeDashboard from '../bizcomponents/taskreplylike/TaskReplyLike.dashboard.js'

import GroupPageBizApp from '../bizcomponents/grouppage/GroupPage.app.js'
import GroupPageDashboard from '../bizcomponents/grouppage/GroupPage.dashboard.js'

import GroupFilterBizApp from '../bizcomponents/groupfilter/GroupFilter.app.js'
import GroupFilterDashboard from '../bizcomponents/groupfilter/GroupFilter.dashboard.js'

import ThreadBizApp from '../bizcomponents/thread/Thread.app.js'
import ThreadDashboard from '../bizcomponents/thread/Thread.dashboard.js'

import ThreadHidingBizApp from '../bizcomponents/threadhiding/ThreadHiding.app.js'
import ThreadHidingDashboard from '../bizcomponents/threadhiding/ThreadHiding.dashboard.js'

import ThreadReplyBizApp from '../bizcomponents/threadreply/ThreadReply.app.js'
import ThreadReplyDashboard from '../bizcomponents/threadreply/ThreadReply.dashboard.js'

import ThreadApprovalBizApp from '../bizcomponents/threadapproval/ThreadApproval.app.js'
import ThreadApprovalDashboard from '../bizcomponents/threadapproval/ThreadApproval.dashboard.js'

import ThreadCompletionBizApp from '../bizcomponents/threadcompletion/ThreadCompletion.app.js'
import ThreadCompletionDashboard from '../bizcomponents/threadcompletion/ThreadCompletion.dashboard.js'

import ThreadCancelingBizApp from '../bizcomponents/threadcanceling/ThreadCanceling.app.js'
import ThreadCancelingDashboard from '../bizcomponents/threadcanceling/ThreadCanceling.dashboard.js'

import ThreadRegistrationBizApp from '../bizcomponents/threadregistration/ThreadRegistration.app.js'
import ThreadRegistrationDashboard from '../bizcomponents/threadregistration/ThreadRegistration.dashboard.js'

import ThreadLikeBizApp from '../bizcomponents/threadlike/ThreadLike.app.js'
import ThreadLikeDashboard from '../bizcomponents/threadlike/ThreadLike.dashboard.js'

import ThreadReplyLikeBizApp from '../bizcomponents/threadreplylike/ThreadReplyLike.app.js'
import ThreadReplyLikeDashboard from '../bizcomponents/threadreplylike/ThreadReplyLike.dashboard.js'

import FanBizApp from '../bizcomponents/fan/Fan.app.js'
import FanDashboard from '../bizcomponents/fan/Fan.dashboard.js'

import FollowBizApp from '../bizcomponents/follow/Follow.app.js'
import FollowDashboard from '../bizcomponents/follow/Follow.dashboard.js'

import BonusPointBizApp from '../bizcomponents/bonuspoint/BonusPoint.app.js'
import BonusPointDashboard from '../bizcomponents/bonuspoint/BonusPoint.dashboard.js'

import ExperiencePointBizApp from '../bizcomponents/experiencepoint/ExperiencePoint.app.js'
import ExperiencePointDashboard from '../bizcomponents/experiencepoint/ExperiencePoint.dashboard.js'

import UserDomainBizApp from '../bizcomponents/userdomain/UserDomain.app.js'
import UserDomainDashboard from '../bizcomponents/userdomain/UserDomain.dashboard.js'

import SecUserBizApp from '../bizcomponents/secuser/SecUser.app.js'
import SecUserDashboard from '../bizcomponents/secuser/SecUser.dashboard.js'

import SecUserBlockingBizApp from '../bizcomponents/secuserblocking/SecUserBlocking.app.js'
import SecUserBlockingDashboard from '../bizcomponents/secuserblocking/SecUserBlocking.dashboard.js'

import UserAppBizApp from '../bizcomponents/userapp/UserApp.app.js'
import UserAppDashboard from '../bizcomponents/userapp/UserApp.dashboard.js'

import ObjectAccessBizApp from '../bizcomponents/objectaccess/ObjectAccess.app.js'
import ObjectAccessDashboard from '../bizcomponents/objectaccess/ObjectAccess.dashboard.js'

import LoginHistoryBizApp from '../bizcomponents/loginhistory/LoginHistory.app.js'
import LoginHistoryDashboard from '../bizcomponents/loginhistory/LoginHistory.dashboard.js'



export default class LauncherRouter extends Component {
   
    render() {
        //console.log(JSON.stringify(this.props));
        return (
            <Router history={hashHistory}>
                <Route path={'/'} component={Page}>
                    <IndexRedirect to="home" />
                    <Route path={'home'} component={Launcher}/>
                    
                
                    <Route path={'communityApp'} component={CommunityBizApp}>
                      <Route path={'dash/:communityId'} component={CommunityDashboard}/>
                      <Route path={'list/:communityId'} component={CommunityDashboard}/>
                    
                     </Route>
   
              
                 <Route path={'invitationCodeApp'} component={InvitationCodeBizApp}>
                    <Route path={'dash'} component={InvitationCodeDashboard}/>
                    <Route path={'list'} component={InvitationCodeDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'homePageApp'} component={HomePageBizApp}>
                    <Route path={'dash'} component={HomePageDashboard}/>
                    <Route path={'list'} component={HomePageDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'slideApp'} component={SlideBizApp}>
                    <Route path={'dash'} component={SlideDashboard}/>
                    <Route path={'list'} component={SlideDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'encyclopediaItemApp'} component={EncyclopediaItemBizApp}>
                    <Route path={'dash'} component={EncyclopediaItemDashboard}/>
                    <Route path={'list'} component={EncyclopediaItemDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'taskPageApp'} component={TaskPageBizApp}>
                    <Route path={'dash'} component={TaskPageDashboard}/>
                    <Route path={'list'} component={TaskPageDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'taskFilterApp'} component={TaskFilterBizApp}>
                    <Route path={'dash'} component={TaskFilterDashboard}/>
                    <Route path={'list'} component={TaskFilterDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'communityUserApp'} component={CommunityUserBizApp}>
                    <Route path={'dash'} component={CommunityUserDashboard}/>
                    <Route path={'list'} component={CommunityUserDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'patientInfoApp'} component={PatientInfoBizApp}>
                    <Route path={'dash'} component={PatientInfoDashboard}/>
                    <Route path={'list'} component={PatientInfoDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'userSkillApp'} component={UserSkillBizApp}>
                    <Route path={'dash'} component={UserSkillDashboard}/>
                    <Route path={'list'} component={UserSkillDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'messageFilterApp'} component={MessageFilterBizApp}>
                    <Route path={'dash'} component={MessageFilterDashboard}/>
                    <Route path={'list'} component={MessageFilterDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'userMessageApp'} component={UserMessageBizApp}>
                    <Route path={'dash'} component={UserMessageDashboard}/>
                    <Route path={'list'} component={UserMessageDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'taskApp'} component={TaskBizApp}>
                    <Route path={'dash'} component={TaskDashboard}/>
                    <Route path={'list'} component={TaskDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'taskAssigmentApp'} component={TaskAssigmentBizApp}>
                    <Route path={'dash'} component={TaskAssigmentDashboard}/>
                    <Route path={'list'} component={TaskAssigmentDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'taskHidingApp'} component={TaskHidingBizApp}>
                    <Route path={'dash'} component={TaskHidingDashboard}/>
                    <Route path={'list'} component={TaskHidingDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'taskResolvingApp'} component={TaskResolvingBizApp}>
                    <Route path={'dash'} component={TaskResolvingDashboard}/>
                    <Route path={'list'} component={TaskResolvingDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'taskRewardApp'} component={TaskRewardBizApp}>
                    <Route path={'dash'} component={TaskRewardDashboard}/>
                    <Route path={'list'} component={TaskRewardDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'taskLikeApp'} component={TaskLikeBizApp}>
                    <Route path={'dash'} component={TaskLikeDashboard}/>
                    <Route path={'list'} component={TaskLikeDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'taskReplyApp'} component={TaskReplyBizApp}>
                    <Route path={'dash'} component={TaskReplyDashboard}/>
                    <Route path={'list'} component={TaskReplyDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'taskBestAnswerSettingApp'} component={TaskBestAnswerSettingBizApp}>
                    <Route path={'dash'} component={TaskBestAnswerSettingDashboard}/>
                    <Route path={'list'} component={TaskBestAnswerSettingDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'taskReplyLikeApp'} component={TaskReplyLikeBizApp}>
                    <Route path={'dash'} component={TaskReplyLikeDashboard}/>
                    <Route path={'list'} component={TaskReplyLikeDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'groupPageApp'} component={GroupPageBizApp}>
                    <Route path={'dash'} component={GroupPageDashboard}/>
                    <Route path={'list'} component={GroupPageDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'groupFilterApp'} component={GroupFilterBizApp}>
                    <Route path={'dash'} component={GroupFilterDashboard}/>
                    <Route path={'list'} component={GroupFilterDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'threadApp'} component={ThreadBizApp}>
                    <Route path={'dash'} component={ThreadDashboard}/>
                    <Route path={'list'} component={ThreadDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'threadHidingApp'} component={ThreadHidingBizApp}>
                    <Route path={'dash'} component={ThreadHidingDashboard}/>
                    <Route path={'list'} component={ThreadHidingDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'threadReplyApp'} component={ThreadReplyBizApp}>
                    <Route path={'dash'} component={ThreadReplyDashboard}/>
                    <Route path={'list'} component={ThreadReplyDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'threadApprovalApp'} component={ThreadApprovalBizApp}>
                    <Route path={'dash'} component={ThreadApprovalDashboard}/>
                    <Route path={'list'} component={ThreadApprovalDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'threadCompletionApp'} component={ThreadCompletionBizApp}>
                    <Route path={'dash'} component={ThreadCompletionDashboard}/>
                    <Route path={'list'} component={ThreadCompletionDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'threadCancelingApp'} component={ThreadCancelingBizApp}>
                    <Route path={'dash'} component={ThreadCancelingDashboard}/>
                    <Route path={'list'} component={ThreadCancelingDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'threadRegistrationApp'} component={ThreadRegistrationBizApp}>
                    <Route path={'dash'} component={ThreadRegistrationDashboard}/>
                    <Route path={'list'} component={ThreadRegistrationDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'threadLikeApp'} component={ThreadLikeBizApp}>
                    <Route path={'dash'} component={ThreadLikeDashboard}/>
                    <Route path={'list'} component={ThreadLikeDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'threadReplyLikeApp'} component={ThreadReplyLikeBizApp}>
                    <Route path={'dash'} component={ThreadReplyLikeDashboard}/>
                    <Route path={'list'} component={ThreadReplyLikeDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'fanApp'} component={FanBizApp}>
                    <Route path={'dash'} component={FanDashboard}/>
                    <Route path={'list'} component={FanDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'followApp'} component={FollowBizApp}>
                    <Route path={'dash'} component={FollowDashboard}/>
                    <Route path={'list'} component={FollowDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'bonusPointApp'} component={BonusPointBizApp}>
                    <Route path={'dash'} component={BonusPointDashboard}/>
                    <Route path={'list'} component={BonusPointDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'experiencePointApp'} component={ExperiencePointBizApp}>
                    <Route path={'dash'} component={ExperiencePointDashboard}/>
                    <Route path={'list'} component={ExperiencePointDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'userDomainApp'} component={UserDomainBizApp}>
                    <Route path={'dash'} component={UserDomainDashboard}/>
                    <Route path={'list'} component={UserDomainDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'secUserApp'} component={SecUserBizApp}>
                    <Route path={'dash'} component={SecUserDashboard}/>
                    <Route path={'list'} component={SecUserDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'secUserBlockingApp'} component={SecUserBlockingBizApp}>
                    <Route path={'dash'} component={SecUserBlockingDashboard}/>
                    <Route path={'list'} component={SecUserBlockingDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'userAppApp'} component={UserAppBizApp}>
                    <Route path={'dash'} component={UserAppDashboard}/>
                    <Route path={'list'} component={UserAppDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'objectAccessApp'} component={ObjectAccessBizApp}>
                    <Route path={'dash'} component={ObjectAccessDashboard}/>
                    <Route path={'list'} component={ObjectAccessDashboard}/>
                    
                  </Route>
   
              
                 <Route path={'loginHistoryApp'} component={LoginHistoryBizApp}>
                    <Route path={'dash'} component={LoginHistoryDashboard}/>
                    <Route path={'list'} component={LoginHistoryDashboard}/>
                    
                  </Route>
                
                </Route>   
                   
            </Router>
        );
    }
}

/*


export default class LauncherRouter extends Component {
   
    render() {
        console.log(JSON.stringify(this.props));
        return (
            <Router history={hashHistory}>
                <Route path={'/'} component={Launcher}>
                    <Route path={'/login'} component={LoginForm}/> 
                    <Route path={'/home'} component={HomeScreen}/>                    
                </Route>        
            </Router>
        );
    }
}



*/