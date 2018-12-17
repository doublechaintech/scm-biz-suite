import React from 'react';
import PropTypes from 'prop-types';
import { Layout, Menu, Icon, Avatar, Dropdown, Tag, message, Spin } from 'antd';
import DocumentTitle from 'react-document-title';
import { connect } from 'dva';
import { Link, Route, Redirect, Switch } from 'dva/router';
import moment from 'moment';
import groupBy from 'lodash/groupBy';
import { ContainerQuery } from 'react-container-query';
import classNames from 'classnames';
import styles from './Community.app.less';
import CommunityDashboard from './Community.dashboard';
import CommunityEditDetail from './Community.editdetail';

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';

import InvitationCodeSearch from '../invitationcode/InvitationCode.search';
import InvitationCodeCreateForm from '../invitationcode/InvitationCode.createform';
import InvitationCodeUpdateForm from '../invitationcode/InvitationCode.updateform';

import HomePageSearch from '../homepage/HomePage.search';
import HomePageCreateForm from '../homepage/HomePage.createform';
import HomePageUpdateForm from '../homepage/HomePage.updateform';

import EncyclopediaItemSearch from '../encyclopediaitem/EncyclopediaItem.search';
import EncyclopediaItemCreateForm from '../encyclopediaitem/EncyclopediaItem.createform';
import EncyclopediaItemUpdateForm from '../encyclopediaitem/EncyclopediaItem.updateform';

import TaskPageSearch from '../taskpage/TaskPage.search';
import TaskPageCreateForm from '../taskpage/TaskPage.createform';
import TaskPageUpdateForm from '../taskpage/TaskPage.updateform';

import CommunityUserSearch from '../communityuser/CommunityUser.search';
import CommunityUserCreateForm from '../communityuser/CommunityUser.createform';
import CommunityUserUpdateForm from '../communityuser/CommunityUser.updateform';

import TaskSearch from '../task/Task.search';
import TaskCreateForm from '../task/Task.createform';
import TaskUpdateForm from '../task/Task.updateform';

import GroupPageSearch from '../grouppage/GroupPage.search';
import GroupPageCreateForm from '../grouppage/GroupPage.createform';
import GroupPageUpdateForm from '../grouppage/GroupPage.updateform';

import ThreadSearch from '../thread/Thread.search';
import ThreadCreateForm from '../thread/Thread.createform';
import ThreadUpdateForm from '../thread/Thread.updateform';

const { Header, Sider, Content } = Layout;
const { SubMenu } = Menu;

const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
};

class CommunityBizApp extends React.PureComponent {
  constructor(props) {
    super(props);
    // 把一级 Layout 的 children 作为菜单项
    // this.menus = getNavData().reduce((arr, current) => arr.concat(current.children), []);
    this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    };
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout);
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    });
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)];
    currentMenuSelectedKeys.splice(-1, 1);
    if (currentMenuSelectedKeys.length === 0) {
      return ['/community/'];
    }
    return currentMenuSelectedKeys;
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props;
    const keys = pathname.split('/').slice(1);
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key];
    }
    return keys;
  }
  getNavMenuItems = (objectId) => {
    return (
      <SubMenu title={
        <span>
          <Icon type="profile" />
          <span>社区</span>
        </span>}
      >

        <Menu.Item>
          <Link to={`/community/${objectId}/list/invitationCodeList`}>邀请码</Link>
        </Menu.Item>
        <Menu.Item>
          <Link to={`/community/${objectId}/list/homePageList`}>主页</Link>
        </Menu.Item>
        <Menu.Item>
          <Link to={`/community/${objectId}/list/encyclopediaItemList`}>百科全书条目</Link>
        </Menu.Item>
        <Menu.Item>
          <Link to={`/community/${objectId}/list/taskPageList`}>任务页面</Link>
        </Menu.Item>
        <Menu.Item>
          <Link to={`/community/${objectId}/list/communityUserList`}>社区用户</Link>
        </Menu.Item>
        <Menu.Item>
          <Link to={`/community/${objectId}/list/taskList`}>任务</Link>
        </Menu.Item>
        <Menu.Item>
          <Link to={`/community/${objectId}/list/groupPageList`}>群组页面</Link>
        </Menu.Item>
        <Menu.Item>
          <Link to={`/community/${objectId}/list/threadList`}>主贴</Link>
        </Menu.Item>
      </SubMenu>
    );
  }


  getInvitationCodeSearch = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.invitationCodeList,
      count: state._community.invitationCodeCount,
      currentPage: state._community.invitationCodeCurrentPageNumber,
      searchFormParameters: state._community.invitationCodeSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(InvitationCodeSearch);
  }
  getInvitationCodeCreateForm = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.invitationCodeList,
      count: state._community.invitationCodeCount,
      currentPage: state._community.invitationCodeCurrentPageNumber,
      searchFormParameters: state._community.invitationCodeSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(InvitationCodeCreateForm);
  }
  
  getInvitationCodeUpdateForm = () => {
    return connect(state => ({
      selectedRows: state._community.selectedRows,
      currentUpdateIndex: state._community.currentUpdateIndex,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(InvitationCodeUpdateForm);
  }

  getHomePageSearch = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.homePageList,
      count: state._community.homePageCount,
      currentPage: state._community.homePageCurrentPageNumber,
      searchFormParameters: state._community.homePageSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(HomePageSearch);
  }
  getHomePageCreateForm = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.homePageList,
      count: state._community.homePageCount,
      currentPage: state._community.homePageCurrentPageNumber,
      searchFormParameters: state._community.homePageSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(HomePageCreateForm);
  }
  
  getHomePageUpdateForm = () => {
    return connect(state => ({
      selectedRows: state._community.selectedRows,
      currentUpdateIndex: state._community.currentUpdateIndex,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(HomePageUpdateForm);
  }

  getEncyclopediaItemSearch = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.encyclopediaItemList,
      count: state._community.encyclopediaItemCount,
      currentPage: state._community.encyclopediaItemCurrentPageNumber,
      searchFormParameters: state._community.encyclopediaItemSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(EncyclopediaItemSearch);
  }
  getEncyclopediaItemCreateForm = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.encyclopediaItemList,
      count: state._community.encyclopediaItemCount,
      currentPage: state._community.encyclopediaItemCurrentPageNumber,
      searchFormParameters: state._community.encyclopediaItemSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(EncyclopediaItemCreateForm);
  }
  
  getEncyclopediaItemUpdateForm = () => {
    return connect(state => ({
      selectedRows: state._community.selectedRows,
      currentUpdateIndex: state._community.currentUpdateIndex,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(EncyclopediaItemUpdateForm);
  }

  getTaskPageSearch = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.taskPageList,
      count: state._community.taskPageCount,
      currentPage: state._community.taskPageCurrentPageNumber,
      searchFormParameters: state._community.taskPageSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(TaskPageSearch);
  }
  getTaskPageCreateForm = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.taskPageList,
      count: state._community.taskPageCount,
      currentPage: state._community.taskPageCurrentPageNumber,
      searchFormParameters: state._community.taskPageSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(TaskPageCreateForm);
  }
  
  getTaskPageUpdateForm = () => {
    return connect(state => ({
      selectedRows: state._community.selectedRows,
      currentUpdateIndex: state._community.currentUpdateIndex,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(TaskPageUpdateForm);
  }

  getCommunityUserSearch = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.communityUserList,
      count: state._community.communityUserCount,
      currentPage: state._community.communityUserCurrentPageNumber,
      searchFormParameters: state._community.communityUserSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(CommunityUserSearch);
  }
  getCommunityUserCreateForm = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.communityUserList,
      count: state._community.communityUserCount,
      currentPage: state._community.communityUserCurrentPageNumber,
      searchFormParameters: state._community.communityUserSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(CommunityUserCreateForm);
  }
  
  getCommunityUserUpdateForm = () => {
    return connect(state => ({
      selectedRows: state._community.selectedRows,
      currentUpdateIndex: state._community.currentUpdateIndex,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(CommunityUserUpdateForm);
  }

  getTaskSearch = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.taskList,
      count: state._community.taskCount,
      currentPage: state._community.taskCurrentPageNumber,
      searchFormParameters: state._community.taskSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(TaskSearch);
  }
  getTaskCreateForm = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.taskList,
      count: state._community.taskCount,
      currentPage: state._community.taskCurrentPageNumber,
      searchFormParameters: state._community.taskSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(TaskCreateForm);
  }
  
  getTaskUpdateForm = () => {
    return connect(state => ({
      selectedRows: state._community.selectedRows,
      currentUpdateIndex: state._community.currentUpdateIndex,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(TaskUpdateForm);
  }

  getGroupPageSearch = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.groupPageList,
      count: state._community.groupPageCount,
      currentPage: state._community.groupPageCurrentPageNumber,
      searchFormParameters: state._community.groupPageSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(GroupPageSearch);
  }
  getGroupPageCreateForm = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.groupPageList,
      count: state._community.groupPageCount,
      currentPage: state._community.groupPageCurrentPageNumber,
      searchFormParameters: state._community.groupPageSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(GroupPageCreateForm);
  }
  
  getGroupPageUpdateForm = () => {
    return connect(state => ({
      selectedRows: state._community.selectedRows,
      currentUpdateIndex: state._community.currentUpdateIndex,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(GroupPageUpdateForm);
  }

  getThreadSearch = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.threadList,
      count: state._community.threadCount,
      currentPage: state._community.threadCurrentPageNumber,
      searchFormParameters: state._community.threadSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(ThreadSearch);
  }
  getThreadCreateForm = () => {
    return connect(state => ({
      rule: state.rule,
      data: state._community.threadList,
      count: state._community.threadCount,
      currentPage: state._community.threadCurrentPageNumber,
      searchFormParameters: state._community.threadSearchFormParameters,
      loading: state._community.loading,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(ThreadCreateForm);
  }
  
  getThreadUpdateForm = () => {
    return connect(state => ({
      selectedRows: state._community.selectedRows,
      currentUpdateIndex: state._community.currentUpdateIndex,
      owner: { type: '_community', id: state._community.id }, // this is for model namespace and
    }))(ThreadUpdateForm);
  }

  getPageTitle = () => {
    // const { location } = this.props;
    // const { pathname } = location;
    const title = '帮帮兔社区运营中心';
    return title;
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1);
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    });
  }
   toggle = () => {
     const { collapsed } = this.props;
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     });
   }

   render() {
     // const { collapsed, fetchingNotices,loading } = this.props;
     const { collapsed } = this.props;
     // Don't show popup menu when it is been collapsed
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     };
     const layout = (
       <Layout>
         <Sider
           trigger={null}
           collapsible
           collapsed={collapsed}
           breakpoint="md"
           onCollapse={this.onCollapse}
           width={256}
           className={styles.sider}
         >
           <div className={styles.logo}>
             <img src="./scm.svg" alt="logo" onClick={this.toggle} />
             <Link to="/home"> <h1>社区</h1></Link>
           </div>

           <Menu
             theme="dark"
             mode="inline"
             {...menuProps}
             onOpenChange={this.handleOpenChange}
             selectedKeys={this.getCurrentMenuSelectedKeys()}
             style={{ margin: '16px 0', width: '100%' }}
           >
           
                 <Menu.Item >   
        <Link to={"/community/"+this.props.community.id+"/dashboard"}><Icon type='dashboard' /><span>仪表板</span></Link>
        
      </Menu.Item>
      <Menu.Item >   
        <Link to={"/community/"+this.props.community.id+"/editDetail"}><Icon type='edit' /><span>详情编辑</span></Link>
        
      </Menu.Item>
             {this.getNavMenuItems(this.props.community.id)}
           </Menu>
         </Sider>
         <Layout>
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
             <Switch>
               <Route path="/community/:id/dashboard" component={CommunityDashboard} />
               <Route path="/community/:id/editDetail" component={CommunityEditDetail} />

               <Route path="/community/:id/list/invitationCodeList" component={this.getInvitationCodeSearch()} />
               <Route path="/community/:id/list/invitationCodeCreateForm" component={this.getInvitationCodeCreateForm()} />
               <Route path="/community/:id/list/invitationCodeUpdateForm" component={this.getInvitationCodeUpdateForm()} />

               <Route path="/community/:id/list/homePageList" component={this.getHomePageSearch()} />
               <Route path="/community/:id/list/homePageCreateForm" component={this.getHomePageCreateForm()} />
               <Route path="/community/:id/list/homePageUpdateForm" component={this.getHomePageUpdateForm()} />

               <Route path="/community/:id/list/encyclopediaItemList" component={this.getEncyclopediaItemSearch()} />
               <Route path="/community/:id/list/encyclopediaItemCreateForm" component={this.getEncyclopediaItemCreateForm()} />
               <Route path="/community/:id/list/encyclopediaItemUpdateForm" component={this.getEncyclopediaItemUpdateForm()} />

               <Route path="/community/:id/list/taskPageList" component={this.getTaskPageSearch()} />
               <Route path="/community/:id/list/taskPageCreateForm" component={this.getTaskPageCreateForm()} />
               <Route path="/community/:id/list/taskPageUpdateForm" component={this.getTaskPageUpdateForm()} />

               <Route path="/community/:id/list/communityUserList" component={this.getCommunityUserSearch()} />
               <Route path="/community/:id/list/communityUserCreateForm" component={this.getCommunityUserCreateForm()} />
               <Route path="/community/:id/list/communityUserUpdateForm" component={this.getCommunityUserUpdateForm()} />

               <Route path="/community/:id/list/taskList" component={this.getTaskSearch()} />
               <Route path="/community/:id/list/taskCreateForm" component={this.getTaskCreateForm()} />
               <Route path="/community/:id/list/taskUpdateForm" component={this.getTaskUpdateForm()} />

               <Route path="/community/:id/list/groupPageList" component={this.getGroupPageSearch()} />
               <Route path="/community/:id/list/groupPageCreateForm" component={this.getGroupPageCreateForm()} />
               <Route path="/community/:id/list/groupPageUpdateForm" component={this.getGroupPageUpdateForm()} />

               <Route path="/community/:id/list/threadList" component={this.getThreadSearch()} />
               <Route path="/community/:id/list/threadCreateForm" component={this.getThreadCreateForm()} />
               <Route path="/community/:id/list/threadUpdateForm" component={this.getThreadUpdateForm()} />
              
             </Switch>
           </Content>
         </Layout>
       </Layout>
     );
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     );
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  community: state._community,
  ...state,
}))(CommunityBizApp);



