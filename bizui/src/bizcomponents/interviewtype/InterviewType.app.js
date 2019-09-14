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
import styles from './InterviewType.app.less'
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




class InterviewTypeBizApp extends React.PureComponent {
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
      return ['/interviewType/']
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
               <Link to={`/interviewType/${this.props.interviewType.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getEmployeeInterviewSearch = () => {
    const {EmployeeInterviewSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "员工面试",
      role: "employeeInterview",
      data: state._interviewType.employeeInterviewList,
      metaInfo: state._interviewType.employeeInterviewListMetaInfo,
      count: state._interviewType.employeeInterviewCount,
      currentPage: state._interviewType.employeeInterviewCurrentPageNumber,
      searchFormParameters: state._interviewType.employeeInterviewSearchFormParameters,
      searchParameters: {...state._interviewType.searchParameters},
      expandForm: state._interviewType.expandForm,
      loading: state._interviewType.loading,
      partialList: state._interviewType.partialList,
      owner: { type: '_interviewType', id: state._interviewType.id, 
      referenceName: 'interviewType', 
      listName: 'employeeInterviewList', ref:state._interviewType, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeInterviewSearch)
  }
  getEmployeeInterviewCreateForm = () => {
   	const {EmployeeInterviewCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "employeeInterview",
      data: state._interviewType.employeeInterviewList,
      metaInfo: state._interviewType.employeeInterviewListMetaInfo,
      count: state._interviewType.employeeInterviewCount,
      currentPage: state._interviewType.employeeInterviewCurrentPageNumber,
      searchFormParameters: state._interviewType.employeeInterviewSearchFormParameters,
      loading: state._interviewType.loading,
      owner: { type: '_interviewType', id: state._interviewType.id, referenceName: 'interviewType', listName: 'employeeInterviewList', ref:state._interviewType, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeInterviewCreateForm)
  }
  
  getEmployeeInterviewUpdateForm = () => {
    const userContext = null
  	const {EmployeeInterviewUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._interviewType.selectedRows,
      role: "employeeInterview",
      currentUpdateIndex: state._interviewType.currentUpdateIndex,
      owner: { type: '_interviewType', id: state._interviewType.id, listName: 'employeeInterviewList', ref:state._interviewType, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeInterviewUpdateForm)
  }


  
  buildRouters = () =>{
  	const {InterviewTypeDashboard} = GlobalComponents
  	const {InterviewTypePermission} = GlobalComponents
  	const {InterviewTypeProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/interviewType/:id/dashboard", component: InterviewTypeDashboard},
  	{path:"/interviewType/:id/profile", component: InterviewTypeProfile},
  	{path:"/interviewType/:id/permission", component: InterviewTypePermission},
  	
  	
  	
  	{path:"/interviewType/:id/list/employeeInterviewList", component: this.getEmployeeInterviewSearch()},
  	{path:"/interviewType/:id/list/employeeInterviewCreateForm", component: this.getEmployeeInterviewCreateForm()},
  	{path:"/interviewType/:id/list/employeeInterviewUpdateForm", component: this.getEmployeeInterviewUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.interviewType)}
		 
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
  interviewType: state._interviewType,
  ...state,
}))(InterviewTypeBizApp)



