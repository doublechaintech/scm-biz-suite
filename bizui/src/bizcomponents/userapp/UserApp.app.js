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
import styles from './UserApp.app.less'
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




class UserAppBizApp extends React.PureComponent {
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
      return ['/userApp/']
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
               <Link to={`/userApp/${this.props.userApp.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		
        
           </Menu>
    )
  }
  



  getQuickLinkSearch = () => {
    const {QuickLinkSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "快速链接",
      role: "quickLink",
      data: state._userApp.quickLinkList,
      metaInfo: state._userApp.quickLinkListMetaInfo,
      count: state._userApp.quickLinkCount,
      currentPage: state._userApp.quickLinkCurrentPageNumber,
      searchFormParameters: state._userApp.quickLinkSearchFormParameters,
      searchParameters: {...state._userApp.searchParameters},
      expandForm: state._userApp.expandForm,
      loading: state._userApp.loading,
      partialList: state._userApp.partialList,
      owner: { type: '_userApp', id: state._userApp.id, 
      referenceName: 'app', 
      listName: 'quickLinkList', ref:state._userApp, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(QuickLinkSearch)
  }
  getQuickLinkCreateForm = () => {
   	const {QuickLinkCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "quickLink",
      data: state._userApp.quickLinkList,
      metaInfo: state._userApp.quickLinkListMetaInfo,
      count: state._userApp.quickLinkCount,
      currentPage: state._userApp.quickLinkCurrentPageNumber,
      searchFormParameters: state._userApp.quickLinkSearchFormParameters,
      loading: state._userApp.loading,
      owner: { type: '_userApp', id: state._userApp.id, referenceName: 'app', listName: 'quickLinkList', ref:state._userApp, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(QuickLinkCreateForm)
  }
  
  getQuickLinkUpdateForm = () => {
    const userContext = null
  	const {QuickLinkUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userApp.selectedRows,
      role: "quickLink",
      currentUpdateIndex: state._userApp.currentUpdateIndex,
      owner: { type: '_userApp', id: state._userApp.id, listName: 'quickLinkList', ref:state._userApp, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(QuickLinkUpdateForm)
  }

  getListAccessSearch = () => {
    const {ListAccessSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "访问列表",
      role: "listAccess",
      data: state._userApp.listAccessList,
      metaInfo: state._userApp.listAccessListMetaInfo,
      count: state._userApp.listAccessCount,
      currentPage: state._userApp.listAccessCurrentPageNumber,
      searchFormParameters: state._userApp.listAccessSearchFormParameters,
      searchParameters: {...state._userApp.searchParameters},
      expandForm: state._userApp.expandForm,
      loading: state._userApp.loading,
      partialList: state._userApp.partialList,
      owner: { type: '_userApp', id: state._userApp.id, 
      referenceName: 'app', 
      listName: 'listAccessList', ref:state._userApp, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ListAccessSearch)
  }
  getListAccessCreateForm = () => {
   	const {ListAccessCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "listAccess",
      data: state._userApp.listAccessList,
      metaInfo: state._userApp.listAccessListMetaInfo,
      count: state._userApp.listAccessCount,
      currentPage: state._userApp.listAccessCurrentPageNumber,
      searchFormParameters: state._userApp.listAccessSearchFormParameters,
      loading: state._userApp.loading,
      owner: { type: '_userApp', id: state._userApp.id, referenceName: 'app', listName: 'listAccessList', ref:state._userApp, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ListAccessCreateForm)
  }
  
  getListAccessUpdateForm = () => {
    const userContext = null
  	const {ListAccessUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userApp.selectedRows,
      role: "listAccess",
      currentUpdateIndex: state._userApp.currentUpdateIndex,
      owner: { type: '_userApp', id: state._userApp.id, listName: 'listAccessList', ref:state._userApp, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ListAccessUpdateForm)
  }

  getObjectAccessSearch = () => {
    const {ObjectAccessSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "对象访问",
      role: "objectAccess",
      data: state._userApp.objectAccessList,
      metaInfo: state._userApp.objectAccessListMetaInfo,
      count: state._userApp.objectAccessCount,
      currentPage: state._userApp.objectAccessCurrentPageNumber,
      searchFormParameters: state._userApp.objectAccessSearchFormParameters,
      searchParameters: {...state._userApp.searchParameters},
      expandForm: state._userApp.expandForm,
      loading: state._userApp.loading,
      partialList: state._userApp.partialList,
      owner: { type: '_userApp', id: state._userApp.id, 
      referenceName: 'app', 
      listName: 'objectAccessList', ref:state._userApp, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ObjectAccessSearch)
  }
  getObjectAccessCreateForm = () => {
   	const {ObjectAccessCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "objectAccess",
      data: state._userApp.objectAccessList,
      metaInfo: state._userApp.objectAccessListMetaInfo,
      count: state._userApp.objectAccessCount,
      currentPage: state._userApp.objectAccessCurrentPageNumber,
      searchFormParameters: state._userApp.objectAccessSearchFormParameters,
      loading: state._userApp.loading,
      owner: { type: '_userApp', id: state._userApp.id, referenceName: 'app', listName: 'objectAccessList', ref:state._userApp, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ObjectAccessCreateForm)
  }
  
  getObjectAccessUpdateForm = () => {
    const userContext = null
  	const {ObjectAccessUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userApp.selectedRows,
      role: "objectAccess",
      currentUpdateIndex: state._userApp.currentUpdateIndex,
      owner: { type: '_userApp', id: state._userApp.id, listName: 'objectAccessList', ref:state._userApp, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ObjectAccessUpdateForm)
  }


  
  buildRouters = () =>{
  	const {UserAppDashboard} = GlobalComponents
  	const {UserAppPermission} = GlobalComponents
  	const {UserAppProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/userApp/:id/dashboard", component: UserAppDashboard},
  	{path:"/userApp/:id/profile", component: UserAppProfile},
  	{path:"/userApp/:id/permission", component: UserAppPermission},
  	
  	
  	
  	{path:"/userApp/:id/list/quickLinkList", component: this.getQuickLinkSearch()},
  	{path:"/userApp/:id/list/quickLinkCreateForm", component: this.getQuickLinkCreateForm()},
  	{path:"/userApp/:id/list/quickLinkUpdateForm", component: this.getQuickLinkUpdateForm()},
   	
  	{path:"/userApp/:id/list/listAccessList", component: this.getListAccessSearch()},
  	{path:"/userApp/:id/list/listAccessCreateForm", component: this.getListAccessCreateForm()},
  	{path:"/userApp/:id/list/listAccessUpdateForm", component: this.getListAccessUpdateForm()},
   	
  	{path:"/userApp/:id/list/objectAccessList", component: this.getObjectAccessSearch()},
  	{path:"/userApp/:id/list/objectAccessCreateForm", component: this.getObjectAccessCreateForm()},
  	{path:"/userApp/:id/list/objectAccessUpdateForm", component: this.getObjectAccessUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.userApp)}
		 
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
  userApp: state._userApp,
  ...state,
}))(UserAppBizApp)



