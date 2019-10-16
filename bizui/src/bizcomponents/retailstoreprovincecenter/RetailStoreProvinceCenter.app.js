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
<<<<<<< HEAD
  AutoComplete,
  Input,Button
} from 'antd'
=======
  AutoComplete,Row, Col,
  Input,Button
} from 'antd'
import TopMenu from '../../launcher/TopMenu'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD

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
=======
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



const userBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};


const searchBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 12,
  xl: 12,
  
};


const naviBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};

>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

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
<<<<<<< HEAD
    // 把一级 Layout 的 children 作为菜单项
    // this.menus = getNavData().reduce((arr, current) => arr.concat(current.children), [])
    this.state = {
=======
     this.state = {
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
  
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/retailStoreProvinceCenter/${this.props.retailStoreProvinceCenter.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
             </Menu.Item>
             
		 <Menu.Item key="homepage">
               <Link to={"/home"}><Icon type="home" /><span>回到主页</span></Link>
             </Menu.Item>
             
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}列表`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/retailStoreProvinceCenter/${this.props.retailStoreProvinceCenter.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
             </Menu.Item>
      
=======
  	const userContext = null
    return (
	  <Menu
        theme="dark"
        mode="inline"
        
        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}
        style={{ width: '256px' }}
       >
           

             <Menu.Item key="dashboard">
               <Link to={`/retailStoreProvinceCenter/${this.props.retailStoreProvinceCenter.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		
        
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
           </Menu>
    )
  }
  



  getProvinceCenterDepartmentSearch = () => {
    const {ProvinceCenterDepartmentSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "省中心",
      role: "provinceCenterDepartment",
      data: state._retailStoreProvinceCenter.provinceCenterDepartmentList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterDepartmentListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterDepartmentCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreProvinceCenter.provinceCenterDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterDepartmentSearchFormParameters,
      searchParameters: {...state._retailStoreProvinceCenter.searchParameters},
      expandForm: state._retailStoreProvinceCenter.expandForm,
      loading: state._retailStoreProvinceCenter.loading,
      partialList: state._retailStoreProvinceCenter.partialList,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, 
      referenceName: 'provinceCenter', 
      listName: 'provinceCenterDepartmentList', ref:state._retailStoreProvinceCenter, 
<<<<<<< HEAD
      listDisplayName: '省中心列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ProvinceCenterDepartmentSearch)
  }
  getProvinceCenterDepartmentCreateForm = () => {
   	const {ProvinceCenterDepartmentCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "provinceCenterDepartment",
      data: state._retailStoreProvinceCenter.provinceCenterDepartmentList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterDepartmentListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterDepartmentCount,
<<<<<<< HEAD
      currentPage: state._retailStoreProvinceCenter.provinceCenterDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterDepartmentSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, referenceName: 'provinceCenter', listName: 'provinceCenterDepartmentList', ref:state._retailStoreProvinceCenter, listDisplayName: '省中心列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/list`,
      currentPage: state._retailStoreProvinceCenter.provinceCenterDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterDepartmentSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, referenceName: 'provinceCenter', listName: 'provinceCenterDepartmentList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ProvinceCenterDepartmentCreateForm)
  }
  
  getProvinceCenterDepartmentUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {ProvinceCenterDepartmentUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreProvinceCenter.selectedRows,
      role: "provinceCenterDepartment",
      currentUpdateIndex: state._retailStoreProvinceCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, listName: 'provinceCenterDepartmentList', ref:state._retailStoreProvinceCenter, listDisplayName: '省中心列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, listName: 'provinceCenterDepartmentList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ProvinceCenterDepartmentUpdateForm)
  }

  getProvinceCenterEmployeeSearch = () => {
    const {ProvinceCenterEmployeeSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "省中心员工",
      role: "provinceCenterEmployee",
      data: state._retailStoreProvinceCenter.provinceCenterEmployeeList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterEmployeeListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterEmployeeCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreProvinceCenter.provinceCenterEmployeeCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterEmployeeSearchFormParameters,
      searchParameters: {...state._retailStoreProvinceCenter.searchParameters},
      expandForm: state._retailStoreProvinceCenter.expandForm,
      loading: state._retailStoreProvinceCenter.loading,
      partialList: state._retailStoreProvinceCenter.partialList,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, 
      referenceName: 'provinceCenter', 
      listName: 'provinceCenterEmployeeList', ref:state._retailStoreProvinceCenter, 
<<<<<<< HEAD
      listDisplayName: '省中心员工列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ProvinceCenterEmployeeSearch)
  }
  getProvinceCenterEmployeeCreateForm = () => {
   	const {ProvinceCenterEmployeeCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "provinceCenterEmployee",
      data: state._retailStoreProvinceCenter.provinceCenterEmployeeList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterEmployeeListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterEmployeeCount,
<<<<<<< HEAD
      currentPage: state._retailStoreProvinceCenter.provinceCenterEmployeeCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterEmployeeSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, referenceName: 'provinceCenter', listName: 'provinceCenterEmployeeList', ref:state._retailStoreProvinceCenter, listDisplayName: '省中心员工列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/list`,
      currentPage: state._retailStoreProvinceCenter.provinceCenterEmployeeCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterEmployeeSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, referenceName: 'provinceCenter', listName: 'provinceCenterEmployeeList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ProvinceCenterEmployeeCreateForm)
  }
  
  getProvinceCenterEmployeeUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {ProvinceCenterEmployeeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreProvinceCenter.selectedRows,
      role: "provinceCenterEmployee",
      currentUpdateIndex: state._retailStoreProvinceCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, listName: 'provinceCenterEmployeeList', ref:state._retailStoreProvinceCenter, listDisplayName: '省中心员工列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, listName: 'provinceCenterEmployeeList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ProvinceCenterEmployeeUpdateForm)
  }

  getRetailStoreCityServiceCenterSearch = () => {
    const {RetailStoreCityServiceCenterSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "双链小超城市服务中心",
      role: "retailStoreCityServiceCenter",
      data: state._retailStoreProvinceCenter.retailStoreCityServiceCenterList,
      metaInfo: state._retailStoreProvinceCenter.retailStoreCityServiceCenterListMetaInfo,
      count: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.retailStoreCityServiceCenterSearchFormParameters,
      searchParameters: {...state._retailStoreProvinceCenter.searchParameters},
      expandForm: state._retailStoreProvinceCenter.expandForm,
      loading: state._retailStoreProvinceCenter.loading,
      partialList: state._retailStoreProvinceCenter.partialList,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, 
      referenceName: 'belongsTo', 
      listName: 'retailStoreCityServiceCenterList', ref:state._retailStoreProvinceCenter, 
<<<<<<< HEAD
      listDisplayName: '双链小超城市服务中心列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreCityServiceCenterSearch)
  }
  getRetailStoreCityServiceCenterCreateForm = () => {
   	const {RetailStoreCityServiceCenterCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreCityServiceCenter",
      data: state._retailStoreProvinceCenter.retailStoreCityServiceCenterList,
      metaInfo: state._retailStoreProvinceCenter.retailStoreCityServiceCenterListMetaInfo,
      count: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCount,
<<<<<<< HEAD
      currentPage: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.retailStoreCityServiceCenterSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, referenceName: 'belongsTo', listName: 'retailStoreCityServiceCenterList', ref:state._retailStoreProvinceCenter, listDisplayName: '双链小超城市服务中心列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/list`,
      currentPage: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.retailStoreCityServiceCenterSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, referenceName: 'belongsTo', listName: 'retailStoreCityServiceCenterList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreCityServiceCenterCreateForm)
  }
  
  getRetailStoreCityServiceCenterUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {RetailStoreCityServiceCenterUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreProvinceCenter.selectedRows,
      role: "retailStoreCityServiceCenter",
      currentUpdateIndex: state._retailStoreProvinceCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, listName: 'retailStoreCityServiceCenterList', ref:state._retailStoreProvinceCenter, listDisplayName: '双链小超城市服务中心列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, listName: 'retailStoreCityServiceCenterList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreCityServiceCenterUpdateForm)
  }


  
  buildRouters = () =>{
  	const {RetailStoreProvinceCenterDashboard} = GlobalComponents
<<<<<<< HEAD
  	const {RetailStoreProvinceCenterPreference} = GlobalComponents
=======
  	const {RetailStoreProvinceCenterPermission} = GlobalComponents
  	const {RetailStoreProvinceCenterProfile} = GlobalComponents
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	const routers=[
  	{path:"/retailStoreProvinceCenter/:id/dashboard", component: RetailStoreProvinceCenterDashboard},
<<<<<<< HEAD
  	{path:"/retailStoreProvinceCenter/:id/preference", component: RetailStoreProvinceCenterPreference},
=======
  	{path:"/retailStoreProvinceCenter/:id/profile", component: RetailStoreProvinceCenterProfile},
  	{path:"/retailStoreProvinceCenter/:id/permission", component: RetailStoreProvinceCenterPermission},
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	
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
<<<<<<< HEAD
     const { breadcrumb }  = this.props

     //const {RetailStoreProvinceCenterEditDetail} = GlobalComponents
     //const {RetailStoreProvinceCenterViewDetail} = GlobalComponents
     
     
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
     
     
     // Don't show popup menu when it is been collapsed
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
          />
          {currentBreadcrumb.map((item)=>{
            return (<Link  key={item.link} to={`${item.link}`} className={styles.breadcrumbLink}> &gt;{item.name}</Link>)

          })}
         </div>
          <div className={styles.right}  >
          <Button type="primary"  icon="logout" onClick={()=>this.logout()}>
          退出</Button>
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
=======
     
  
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
     const renderBreadcrumbMenuItem=(breadcrumbMenuItem)=>{

      return (
      <Menu.Item key={breadcrumbMenuItem.link}>
      <Link key={breadcrumbMenuItem.link} to={`${breadcrumbMenuItem.link}`} className={styles.breadcrumbLink}>
        <Icon type="heart" style={{marginRight:"10px",color:"red"}} />
        {renderBreadcrumbText(breadcrumbMenuItem.name)}
      </Link></Menu.Item>)

     }
     const breadcrumbMenu=()=>{
      const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
      return ( <Menu mode="vertical"> 
      {currentBreadcrumb.map(item => renderBreadcrumbMenuItem(item))}
      </Menu>)
  

     }
     const { Search } = Input;
     const layout = (
     <Layout>
 <Header>
          
        <Row type="flex" justify="start" align="bottom">
        
        <Col {...naviBarResponsiveStyle} >
            <Dropdown overlay= {this.getNavMenuItems(this.props.retailStoreProvinceCenter)}>
              <a  className={styles.menuLink}>
                <Icon type="unordered-list" style={{fontSize:"20px", marginRight:"10px"}}/> 菜单
              </a>
            </Dropdown>            
            <Dropdown overlay={breadcrumbMenu()}>
              <a  className={styles.menuLink}>
                <Icon type="down" style={{fontSize:"20px", marginRight:"10px"}}/> 快速转到
              </a>
            </Dropdown>
        </Col>
        <Col  className={styles.searchBox} {...searchBarResponsiveStyle}  > 
          
          <Search size="default" placeholder="请输入搜索条件, 查找功能，数据和词汇解释,暂未实现" enterButton 
            style={{ marginLeft:"10px",marginTop:"7px",width:"100%"}} />
          </Col>
          <Col  {...userBarResponsiveStyle}  > 
            <Dropdown overlay= { <TopMenu {...this.props} />} className={styles.right}>
                <a  className={styles.menuLink}>
                  <Icon type="user" style={{fontSize:"20px",marginRight:"10px"}}/> 账户
                </a>
            </Dropdown>
            
           </Col>  
         
         </Row>
        </Header>
       <Layout>
       
         
         <Layout>
         
            
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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



