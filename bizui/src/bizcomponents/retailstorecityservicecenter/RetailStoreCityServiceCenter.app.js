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
import styles from './RetailStoreCityServiceCenter.app.less'
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




class RetailStoreCityServiceCenterBizApp extends React.PureComponent {
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
      return ['/retailStoreCityServiceCenter/']
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
               <Link to={`/retailStoreCityServiceCenter/${this.props.retailStoreCityServiceCenter.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
               		<Link to={`/retailStoreCityServiceCenter/${this.props.retailStoreCityServiceCenter.id}/permission`}><Icon type="safety-certificate" /><span>{appLocaleName(userContext,"Permission")}</span></Link>
             	</Menu.Item>
             	<Menu.Item key="permission">
               		<Link to={`/retailStoreCityServiceCenter/${this.props.retailStoreCityServiceCenter.id}/profile`}><Icon type="cluster" /><span>{appLocaleName(userContext,"Profile")}</span></Link>
             	</Menu.Item> 
      
        	</SubMenu>
        
           </Menu>
    )
  }
  



  getCityPartnerSearch = () => {
    const {CityPartnerSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "城市合伙人",
      role: "cityPartner",
      data: state._retailStoreCityServiceCenter.cityPartnerList,
      metaInfo: state._retailStoreCityServiceCenter.cityPartnerListMetaInfo,
      count: state._retailStoreCityServiceCenter.cityPartnerCount,
      currentPage: state._retailStoreCityServiceCenter.cityPartnerCurrentPageNumber,
      searchFormParameters: state._retailStoreCityServiceCenter.cityPartnerSearchFormParameters,
      searchParameters: {...state._retailStoreCityServiceCenter.searchParameters},
      expandForm: state._retailStoreCityServiceCenter.expandForm,
      loading: state._retailStoreCityServiceCenter.loading,
      partialList: state._retailStoreCityServiceCenter.partialList,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, 
      referenceName: 'cityServiceCenter', 
      listName: 'cityPartnerList', ref:state._retailStoreCityServiceCenter, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CityPartnerSearch)
  }
  getCityPartnerCreateForm = () => {
   	const {CityPartnerCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "cityPartner",
      data: state._retailStoreCityServiceCenter.cityPartnerList,
      metaInfo: state._retailStoreCityServiceCenter.cityPartnerListMetaInfo,
      count: state._retailStoreCityServiceCenter.cityPartnerCount,
      currentPage: state._retailStoreCityServiceCenter.cityPartnerCurrentPageNumber,
      searchFormParameters: state._retailStoreCityServiceCenter.cityPartnerSearchFormParameters,
      loading: state._retailStoreCityServiceCenter.loading,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, referenceName: 'cityServiceCenter', listName: 'cityPartnerList', ref:state._retailStoreCityServiceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(CityPartnerCreateForm)
  }
  
  getCityPartnerUpdateForm = () => {
    const userContext = null
  	const {CityPartnerUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCityServiceCenter.selectedRows,
      role: "cityPartner",
      currentUpdateIndex: state._retailStoreCityServiceCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, listName: 'cityPartnerList', ref:state._retailStoreCityServiceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CityPartnerUpdateForm)
  }

  getPotentialCustomerSearch = () => {
    const {PotentialCustomerSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "潜在的客户",
      role: "potentialCustomer",
      data: state._retailStoreCityServiceCenter.potentialCustomerList,
      metaInfo: state._retailStoreCityServiceCenter.potentialCustomerListMetaInfo,
      count: state._retailStoreCityServiceCenter.potentialCustomerCount,
      currentPage: state._retailStoreCityServiceCenter.potentialCustomerCurrentPageNumber,
      searchFormParameters: state._retailStoreCityServiceCenter.potentialCustomerSearchFormParameters,
      searchParameters: {...state._retailStoreCityServiceCenter.searchParameters},
      expandForm: state._retailStoreCityServiceCenter.expandForm,
      loading: state._retailStoreCityServiceCenter.loading,
      partialList: state._retailStoreCityServiceCenter.partialList,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, 
      referenceName: 'cityServiceCenter', 
      listName: 'potentialCustomerList', ref:state._retailStoreCityServiceCenter, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PotentialCustomerSearch)
  }
  getPotentialCustomerCreateForm = () => {
   	const {PotentialCustomerCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "potentialCustomer",
      data: state._retailStoreCityServiceCenter.potentialCustomerList,
      metaInfo: state._retailStoreCityServiceCenter.potentialCustomerListMetaInfo,
      count: state._retailStoreCityServiceCenter.potentialCustomerCount,
      currentPage: state._retailStoreCityServiceCenter.potentialCustomerCurrentPageNumber,
      searchFormParameters: state._retailStoreCityServiceCenter.potentialCustomerSearchFormParameters,
      loading: state._retailStoreCityServiceCenter.loading,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, referenceName: 'cityServiceCenter', listName: 'potentialCustomerList', ref:state._retailStoreCityServiceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(PotentialCustomerCreateForm)
  }
  
  getPotentialCustomerUpdateForm = () => {
    const userContext = null
  	const {PotentialCustomerUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCityServiceCenter.selectedRows,
      role: "potentialCustomer",
      currentUpdateIndex: state._retailStoreCityServiceCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, listName: 'potentialCustomerList', ref:state._retailStoreCityServiceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PotentialCustomerUpdateForm)
  }

  getCityEventSearch = () => {
    const {CityEventSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "城市活动",
      role: "cityEvent",
      data: state._retailStoreCityServiceCenter.cityEventList,
      metaInfo: state._retailStoreCityServiceCenter.cityEventListMetaInfo,
      count: state._retailStoreCityServiceCenter.cityEventCount,
      currentPage: state._retailStoreCityServiceCenter.cityEventCurrentPageNumber,
      searchFormParameters: state._retailStoreCityServiceCenter.cityEventSearchFormParameters,
      searchParameters: {...state._retailStoreCityServiceCenter.searchParameters},
      expandForm: state._retailStoreCityServiceCenter.expandForm,
      loading: state._retailStoreCityServiceCenter.loading,
      partialList: state._retailStoreCityServiceCenter.partialList,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, 
      referenceName: 'cityServiceCenter', 
      listName: 'cityEventList', ref:state._retailStoreCityServiceCenter, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CityEventSearch)
  }
  getCityEventCreateForm = () => {
   	const {CityEventCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "cityEvent",
      data: state._retailStoreCityServiceCenter.cityEventList,
      metaInfo: state._retailStoreCityServiceCenter.cityEventListMetaInfo,
      count: state._retailStoreCityServiceCenter.cityEventCount,
      currentPage: state._retailStoreCityServiceCenter.cityEventCurrentPageNumber,
      searchFormParameters: state._retailStoreCityServiceCenter.cityEventSearchFormParameters,
      loading: state._retailStoreCityServiceCenter.loading,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, referenceName: 'cityServiceCenter', listName: 'cityEventList', ref:state._retailStoreCityServiceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(CityEventCreateForm)
  }
  
  getCityEventUpdateForm = () => {
    const userContext = null
  	const {CityEventUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCityServiceCenter.selectedRows,
      role: "cityEvent",
      currentUpdateIndex: state._retailStoreCityServiceCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, listName: 'cityEventList', ref:state._retailStoreCityServiceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CityEventUpdateForm)
  }

  getRetailStoreSearch = () => {
    const {RetailStoreSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "双链小超",
      role: "retailStore",
      data: state._retailStoreCityServiceCenter.retailStoreList,
      metaInfo: state._retailStoreCityServiceCenter.retailStoreListMetaInfo,
      count: state._retailStoreCityServiceCenter.retailStoreCount,
      currentPage: state._retailStoreCityServiceCenter.retailStoreCurrentPageNumber,
      searchFormParameters: state._retailStoreCityServiceCenter.retailStoreSearchFormParameters,
      searchParameters: {...state._retailStoreCityServiceCenter.searchParameters},
      expandForm: state._retailStoreCityServiceCenter.expandForm,
      loading: state._retailStoreCityServiceCenter.loading,
      partialList: state._retailStoreCityServiceCenter.partialList,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, 
      referenceName: 'cityServiceCenter', 
      listName: 'retailStoreList', ref:state._retailStoreCityServiceCenter, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreSearch)
  }
  getRetailStoreCreateForm = () => {
   	const {RetailStoreCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "retailStore",
      data: state._retailStoreCityServiceCenter.retailStoreList,
      metaInfo: state._retailStoreCityServiceCenter.retailStoreListMetaInfo,
      count: state._retailStoreCityServiceCenter.retailStoreCount,
      currentPage: state._retailStoreCityServiceCenter.retailStoreCurrentPageNumber,
      searchFormParameters: state._retailStoreCityServiceCenter.retailStoreSearchFormParameters,
      loading: state._retailStoreCityServiceCenter.loading,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, referenceName: 'cityServiceCenter', listName: 'retailStoreList', ref:state._retailStoreCityServiceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreCreateForm)
  }
  
  getRetailStoreUpdateForm = () => {
    const userContext = null
  	const {RetailStoreUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCityServiceCenter.selectedRows,
      role: "retailStore",
      currentUpdateIndex: state._retailStoreCityServiceCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCityServiceCenter', id: state._retailStoreCityServiceCenter.id, listName: 'retailStoreList', ref:state._retailStoreCityServiceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreUpdateForm)
  }


  
  buildRouters = () =>{
  	const {RetailStoreCityServiceCenterDashboard} = GlobalComponents
  	const {RetailStoreCityServiceCenterPermission} = GlobalComponents
  	const {RetailStoreCityServiceCenterProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/retailStoreCityServiceCenter/:id/dashboard", component: RetailStoreCityServiceCenterDashboard},
  	{path:"/retailStoreCityServiceCenter/:id/profile", component: RetailStoreCityServiceCenterProfile},
  	{path:"/retailStoreCityServiceCenter/:id/permission", component: RetailStoreCityServiceCenterPermission},
  	
  	
  	
  	{path:"/retailStoreCityServiceCenter/:id/list/cityPartnerList", component: this.getCityPartnerSearch()},
  	{path:"/retailStoreCityServiceCenter/:id/list/cityPartnerCreateForm", component: this.getCityPartnerCreateForm()},
  	{path:"/retailStoreCityServiceCenter/:id/list/cityPartnerUpdateForm", component: this.getCityPartnerUpdateForm()},
   	
  	{path:"/retailStoreCityServiceCenter/:id/list/potentialCustomerList", component: this.getPotentialCustomerSearch()},
  	{path:"/retailStoreCityServiceCenter/:id/list/potentialCustomerCreateForm", component: this.getPotentialCustomerCreateForm()},
  	{path:"/retailStoreCityServiceCenter/:id/list/potentialCustomerUpdateForm", component: this.getPotentialCustomerUpdateForm()},
   	
  	{path:"/retailStoreCityServiceCenter/:id/list/cityEventList", component: this.getCityEventSearch()},
  	{path:"/retailStoreCityServiceCenter/:id/list/cityEventCreateForm", component: this.getCityEventCreateForm()},
  	{path:"/retailStoreCityServiceCenter/:id/list/cityEventUpdateForm", component: this.getCityEventUpdateForm()},
   	
  	{path:"/retailStoreCityServiceCenter/:id/list/retailStoreList", component: this.getRetailStoreSearch()},
  	{path:"/retailStoreCityServiceCenter/:id/list/retailStoreCreateForm", component: this.getRetailStoreCreateForm()},
  	{path:"/retailStoreCityServiceCenter/:id/list/retailStoreUpdateForm", component: this.getRetailStoreUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.retailStoreCityServiceCenter)}
		 
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
  retailStoreCityServiceCenter: state._retailStoreCityServiceCenter,
  ...state,
}))(RetailStoreCityServiceCenterBizApp)



