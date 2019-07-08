import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,
  Input,Button
} from 'antd'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './SecUser.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'
import BizAppTool from '../../common/BizApp.tool'

const { Header, Sider, Content } = Layout
const { SubMenu } = Menu
const {
  defaultFilteredNoGroupMenuItems,
  defaultFilteredMenuItemsGroup,
  defaultRenderMenuItem,

} = BizAppTool


const filteredNoGroupMenuItems = defaultFilteredNoGroupMenuItems
const filteredMenuItemsGroup = defaultFilteredMenuItemsGroup
const renderMenuItem=defaultRenderMenuItem



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
}




class SecUserBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/secUser/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  	const userContext = null
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/secUser/${this.props.secUser.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		<SubMenu key="sub4" title={<span><Icon type="setting" /><span>{appLocaleName(userContext,"Setting")}</span></span>} >
       			<Menu.Item key="profile">
               		<Link to={`/secUser/${this.props.secUser.id}/permission`}><Icon type="safety-certificate" /><span>{appLocaleName(userContext,"Permission")}</span></Link>
             	</Menu.Item>
             	<Menu.Item key="permission">
               		<Link to={`/secUser/${this.props.secUser.id}/profile`}><Icon type="cluster" /><span>{appLocaleName(userContext,"Profile")}</span></Link>
             	</Menu.Item> 
      
        	</SubMenu>
        
           </Menu>
    )
  }
  



  getUserAppSearch = () => {
    const {UserAppSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "User App",
      role: "userApp",
      data: state._secUser.userAppList,
      metaInfo: state._secUser.userAppListMetaInfo,
      count: state._secUser.userAppCount,
      currentPage: state._secUser.userAppCurrentPageNumber,
      searchFormParameters: state._secUser.userAppSearchFormParameters,
      searchParameters: {...state._secUser.searchParameters},
      expandForm: state._secUser.expandForm,
      loading: state._secUser.loading,
      partialList: state._secUser.partialList,
      owner: { type: '_secUser', id: state._secUser.id, 
      referenceName: 'secUser', 
      listName: 'userAppList', ref:state._secUser, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserAppSearch)
  }
  getUserAppCreateForm = () => {
   	const {UserAppCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "userApp",
      data: state._secUser.userAppList,
      metaInfo: state._secUser.userAppListMetaInfo,
      count: state._secUser.userAppCount,
      currentPage: state._secUser.userAppCurrentPageNumber,
      searchFormParameters: state._secUser.userAppSearchFormParameters,
      loading: state._secUser.loading,
      owner: { type: '_secUser', id: state._secUser.id, referenceName: 'secUser', listName: 'userAppList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(UserAppCreateForm)
  }
  
  getUserAppUpdateForm = () => {
    const userContext = null
  	const {UserAppUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._secUser.selectedRows,
      role: "userApp",
      currentUpdateIndex: state._secUser.currentUpdateIndex,
      owner: { type: '_secUser', id: state._secUser.id, listName: 'userAppList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserAppUpdateForm)
  }

  getLoginHistorySearch = () => {
    const {LoginHistorySearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Login History",
      role: "loginHistory",
      data: state._secUser.loginHistoryList,
      metaInfo: state._secUser.loginHistoryListMetaInfo,
      count: state._secUser.loginHistoryCount,
      currentPage: state._secUser.loginHistoryCurrentPageNumber,
      searchFormParameters: state._secUser.loginHistorySearchFormParameters,
      searchParameters: {...state._secUser.searchParameters},
      expandForm: state._secUser.expandForm,
      loading: state._secUser.loading,
      partialList: state._secUser.partialList,
      owner: { type: '_secUser', id: state._secUser.id, 
      referenceName: 'secUser', 
      listName: 'loginHistoryList', ref:state._secUser, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LoginHistorySearch)
  }
  getLoginHistoryCreateForm = () => {
   	const {LoginHistoryCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "loginHistory",
      data: state._secUser.loginHistoryList,
      metaInfo: state._secUser.loginHistoryListMetaInfo,
      count: state._secUser.loginHistoryCount,
      currentPage: state._secUser.loginHistoryCurrentPageNumber,
      searchFormParameters: state._secUser.loginHistorySearchFormParameters,
      loading: state._secUser.loading,
      owner: { type: '_secUser', id: state._secUser.id, referenceName: 'secUser', listName: 'loginHistoryList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(LoginHistoryCreateForm)
  }
  
  getLoginHistoryUpdateForm = () => {
    const userContext = null
  	const {LoginHistoryUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._secUser.selectedRows,
      role: "loginHistory",
      currentUpdateIndex: state._secUser.currentUpdateIndex,
      owner: { type: '_secUser', id: state._secUser.id, listName: 'loginHistoryList', ref:state._secUser, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LoginHistoryUpdateForm)
  }


  
  buildRouters = () =>{
  	const {SecUserDashboard} = GlobalComponents
  	const {SecUserPermission} = GlobalComponents
  	const {SecUserProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/secUser/:id/dashboard", component: SecUserDashboard},
  	{path:"/secUser/:id/profile", component: SecUserProfile},
  	{path:"/secUser/:id/permission", component: SecUserPermission},
  	
  	
  	
  	{path:"/secUser/:id/list/userAppList", component: this.getUserAppSearch()},
  	{path:"/secUser/:id/list/userAppCreateForm", component: this.getUserAppCreateForm()},
  	{path:"/secUser/:id/list/userAppUpdateForm", component: this.getUserAppUpdateForm()},
   	
  	{path:"/secUser/:id/list/loginHistoryList", component: this.getLoginHistorySearch()},
  	{path:"/secUser/:id/list/loginHistoryCreateForm", component: this.getLoginHistoryCreateForm()},
  	{path:"/secUser/:id/list/loginHistoryUpdateForm", component: this.getLoginHistoryUpdateForm()},
     	
  	
  	]
  	
  	const {extraRoutesFunc} = this.props;
	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
    const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '双链小超全流程供应链系统'
    return title
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
     const userContext = null
     const renderBreadcrumbText=(value)=>{
     	if(value==null){
     		return "..."
     	}
     	if(value.length < 10){
     		return value
     	}
     
     	return value.substring(0,10)+"..."
     	
     	
     }
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const layout = (
     <Layout>
        <Header>
          
          <div className={styles.left}>
          <img
            src="./favicon.png"
            alt="logo"
            onClick={this.toggle}
            className={styles.logo}
          /><Link key={"__home"} to={"/home"} className={styles.breadcrumbLink}><Icon type="home" />&nbsp;{appLocaleName(userContext,"Home")}</Link>
          {currentBreadcrumb.map((item)=>{
            return (<Link  key={item.link} to={`${item.link}`} className={styles.breadcrumbLink}><Icon type="caret-right" />{renderBreadcrumbText(item.name)}</Link>)

          })}
         </div>
          <div className={styles.right}  >
          <Button type="primary"  icon="logout" onClick={()=>this.logout()}>
          {appLocaleName(userContext,"Exit")}</Button>
          </div>
          
        </Header>
       <Layout>
         <Sider
           trigger={null}
           collapsible
           collapsed={collapsed}
           breakpoint="md"
           onCollapse={()=>this.onCollapse(collapsed)}
           collapsedWidth={56}
           className={styles.sider}
         >

		 {this.getNavMenuItems(this.props.secUser)}
		 
         </Sider>
         <Layout>
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  secUser: state._secUser,
  ...state,
}))(SecUserBizApp)



