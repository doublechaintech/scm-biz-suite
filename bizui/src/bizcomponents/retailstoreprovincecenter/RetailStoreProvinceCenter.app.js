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
import styles from './RetailStoreProvinceCenter.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'

const  {  filterForMenuPermission } = PermissionSettingService

const isMenuItemForDisplay = (item, targetObject, targetComponent) => {
  return true
}

const filteredMenuItems = (targetObject, targetComponent) => {
    const menuData = sessionObject('menuData')
    const isMenuItemForDisplayFunc = targetComponent.props.isMenuItemForDisplayFunc||isMenuItemForDisplay
    return menuData.subItems.filter(item=>filterForMenuPermission(item,targetObject,targetComponent)).filter(item=>isMenuItemForDisplayFunc(item,targetObject,targetComponent))
}



const { Header, Sider, Content } = Layout
const { SubMenu } = Menu

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




class RetailStoreProvinceCenterBizApp extends React.PureComponent {
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
      return ['/retailStoreProvinceCenter/']
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
               <Link to={`/retailStoreProvinceCenter/${this.props.retailStoreProvinceCenter.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/retailStoreProvinceCenter/${this.props.retailStoreProvinceCenter.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getProvinceCenterDepartmentSearch = () => {
    const {ProvinceCenterDepartmentSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "省中心",
      role: "provinceCenterDepartment",
      data: state._retailStoreProvinceCenter.provinceCenterDepartmentList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterDepartmentListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterDepartmentCount,
      currentPage: state._retailStoreProvinceCenter.provinceCenterDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterDepartmentSearchFormParameters,
      searchParameters: {...state._retailStoreProvinceCenter.searchParameters},
      expandForm: state._retailStoreProvinceCenter.expandForm,
      loading: state._retailStoreProvinceCenter.loading,
      partialList: state._retailStoreProvinceCenter.partialList,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, 
      referenceName: 'provinceCenter', 
      listName: 'provinceCenterDepartmentList', ref:state._retailStoreProvinceCenter, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProvinceCenterDepartmentSearch)
  }
  getProvinceCenterDepartmentCreateForm = () => {
   	const {ProvinceCenterDepartmentCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "provinceCenterDepartment",
      data: state._retailStoreProvinceCenter.provinceCenterDepartmentList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterDepartmentListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterDepartmentCount,
      currentPage: state._retailStoreProvinceCenter.provinceCenterDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterDepartmentSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, referenceName: 'provinceCenter', listName: 'provinceCenterDepartmentList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ProvinceCenterDepartmentCreateForm)
  }
  
  getProvinceCenterDepartmentUpdateForm = () => {
    const userContext = null
  	const {ProvinceCenterDepartmentUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreProvinceCenter.selectedRows,
      role: "provinceCenterDepartment",
      currentUpdateIndex: state._retailStoreProvinceCenter.currentUpdateIndex,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, listName: 'provinceCenterDepartmentList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProvinceCenterDepartmentUpdateForm)
  }

  getProvinceCenterEmployeeSearch = () => {
    const {ProvinceCenterEmployeeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "省中心员工",
      role: "provinceCenterEmployee",
      data: state._retailStoreProvinceCenter.provinceCenterEmployeeList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterEmployeeListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterEmployeeCount,
      currentPage: state._retailStoreProvinceCenter.provinceCenterEmployeeCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterEmployeeSearchFormParameters,
      searchParameters: {...state._retailStoreProvinceCenter.searchParameters},
      expandForm: state._retailStoreProvinceCenter.expandForm,
      loading: state._retailStoreProvinceCenter.loading,
      partialList: state._retailStoreProvinceCenter.partialList,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, 
      referenceName: 'provinceCenter', 
      listName: 'provinceCenterEmployeeList', ref:state._retailStoreProvinceCenter, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProvinceCenterEmployeeSearch)
  }
  getProvinceCenterEmployeeCreateForm = () => {
   	const {ProvinceCenterEmployeeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "provinceCenterEmployee",
      data: state._retailStoreProvinceCenter.provinceCenterEmployeeList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterEmployeeListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterEmployeeCount,
      currentPage: state._retailStoreProvinceCenter.provinceCenterEmployeeCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterEmployeeSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, referenceName: 'provinceCenter', listName: 'provinceCenterEmployeeList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ProvinceCenterEmployeeCreateForm)
  }
  
  getProvinceCenterEmployeeUpdateForm = () => {
    const userContext = null
  	const {ProvinceCenterEmployeeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreProvinceCenter.selectedRows,
      role: "provinceCenterEmployee",
      currentUpdateIndex: state._retailStoreProvinceCenter.currentUpdateIndex,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, listName: 'provinceCenterEmployeeList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProvinceCenterEmployeeUpdateForm)
  }

  getRetailStoreCityServiceCenterSearch = () => {
    const {RetailStoreCityServiceCenterSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "双链小超城市服务中心",
      role: "retailStoreCityServiceCenter",
      data: state._retailStoreProvinceCenter.retailStoreCityServiceCenterList,
      metaInfo: state._retailStoreProvinceCenter.retailStoreCityServiceCenterListMetaInfo,
      count: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCount,
      currentPage: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.retailStoreCityServiceCenterSearchFormParameters,
      searchParameters: {...state._retailStoreProvinceCenter.searchParameters},
      expandForm: state._retailStoreProvinceCenter.expandForm,
      loading: state._retailStoreProvinceCenter.loading,
      partialList: state._retailStoreProvinceCenter.partialList,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, 
      referenceName: 'belongsTo', 
      listName: 'retailStoreCityServiceCenterList', ref:state._retailStoreProvinceCenter, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreCityServiceCenterSearch)
  }
  getRetailStoreCityServiceCenterCreateForm = () => {
   	const {RetailStoreCityServiceCenterCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreCityServiceCenter",
      data: state._retailStoreProvinceCenter.retailStoreCityServiceCenterList,
      metaInfo: state._retailStoreProvinceCenter.retailStoreCityServiceCenterListMetaInfo,
      count: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCount,
      currentPage: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.retailStoreCityServiceCenterSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, referenceName: 'belongsTo', listName: 'retailStoreCityServiceCenterList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreCityServiceCenterCreateForm)
  }
  
  getRetailStoreCityServiceCenterUpdateForm = () => {
    const userContext = null
  	const {RetailStoreCityServiceCenterUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreProvinceCenter.selectedRows,
      role: "retailStoreCityServiceCenter",
      currentUpdateIndex: state._retailStoreProvinceCenter.currentUpdateIndex,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, listName: 'retailStoreCityServiceCenterList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreCityServiceCenterUpdateForm)
  }


  
  buildRouters = () =>{
  	const {RetailStoreProvinceCenterDashboard} = GlobalComponents
  	const {RetailStoreProvinceCenterPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/retailStoreProvinceCenter/:id/dashboard", component: RetailStoreProvinceCenterDashboard},
  	{path:"/retailStoreProvinceCenter/:id/preference", component: RetailStoreProvinceCenterPreference},
  	
  	
  	
  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterDepartmentList", component: this.getProvinceCenterDepartmentSearch()},
  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterDepartmentCreateForm", component: this.getProvinceCenterDepartmentCreateForm()},
  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterDepartmentUpdateForm", component: this.getProvinceCenterDepartmentUpdateForm()},
   	
  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterEmployeeList", component: this.getProvinceCenterEmployeeSearch()},
  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterEmployeeCreateForm", component: this.getProvinceCenterEmployeeCreateForm()},
  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterEmployeeUpdateForm", component: this.getProvinceCenterEmployeeUpdateForm()},
   	
  	{path:"/retailStoreProvinceCenter/:id/list/retailStoreCityServiceCenterList", component: this.getRetailStoreCityServiceCenterSearch()},
  	{path:"/retailStoreProvinceCenter/:id/list/retailStoreCityServiceCenterCreateForm", component: this.getRetailStoreCityServiceCenterCreateForm()},
  	{path:"/retailStoreProvinceCenter/:id/list/retailStoreCityServiceCenterUpdateForm", component: this.getRetailStoreCityServiceCenterUpdateForm()},
     	
  	
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
     const { breadcrumb }  = this.props
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
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

		 {this.getNavMenuItems(this.props.retailStoreProvinceCenter)}
		 
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
  retailStoreProvinceCenter: state._retailStoreProvinceCenter,
  ...state,
}))(RetailStoreProvinceCenterBizApp)



