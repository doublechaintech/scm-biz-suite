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
import styles from './SupplyOrderConfirmation.app.less'
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




class SupplyOrderConfirmationBizApp extends React.PureComponent {
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
      return ['/supplyOrderConfirmation/']
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
               <Link to={`/supplyOrderConfirmation/${this.props.supplyOrderConfirmation.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
               		<Link to={`/supplyOrderConfirmation/${this.props.supplyOrderConfirmation.id}/permission`}><Icon type="safety-certificate" /><span>{appLocaleName(userContext,"Permission")}</span></Link>
             	</Menu.Item>
             	<Menu.Item key="permission">
               		<Link to={`/supplyOrderConfirmation/${this.props.supplyOrderConfirmation.id}/profile`}><Icon type="cluster" /><span>{appLocaleName(userContext,"Profile")}</span></Link>
             	</Menu.Item> 
      
        	</SubMenu>
        
           </Menu>
    )
  }
  



  getConsumerOrderSearch = () => {
    const {ConsumerOrderSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Consumer Order",
      role: "consumerOrder",
      data: state._supplyOrderConfirmation.consumerOrderList,
      metaInfo: state._supplyOrderConfirmation.consumerOrderListMetaInfo,
      count: state._supplyOrderConfirmation.consumerOrderCount,
      currentPage: state._supplyOrderConfirmation.consumerOrderCurrentPageNumber,
      searchFormParameters: state._supplyOrderConfirmation.consumerOrderSearchFormParameters,
      searchParameters: {...state._supplyOrderConfirmation.searchParameters},
      expandForm: state._supplyOrderConfirmation.expandForm,
      loading: state._supplyOrderConfirmation.loading,
      partialList: state._supplyOrderConfirmation.partialList,
      owner: { type: '_supplyOrderConfirmation', id: state._supplyOrderConfirmation.id, 
      referenceName: 'confirmation', 
      listName: 'consumerOrderList', ref:state._supplyOrderConfirmation, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderSearch)
  }
  getConsumerOrderCreateForm = () => {
   	const {ConsumerOrderCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "consumerOrder",
      data: state._supplyOrderConfirmation.consumerOrderList,
      metaInfo: state._supplyOrderConfirmation.consumerOrderListMetaInfo,
      count: state._supplyOrderConfirmation.consumerOrderCount,
      currentPage: state._supplyOrderConfirmation.consumerOrderCurrentPageNumber,
      searchFormParameters: state._supplyOrderConfirmation.consumerOrderSearchFormParameters,
      loading: state._supplyOrderConfirmation.loading,
      owner: { type: '_supplyOrderConfirmation', id: state._supplyOrderConfirmation.id, referenceName: 'confirmation', listName: 'consumerOrderList', ref:state._supplyOrderConfirmation, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ConsumerOrderCreateForm)
  }
  
  getConsumerOrderUpdateForm = () => {
    const userContext = null
  	const {ConsumerOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._supplyOrderConfirmation.selectedRows,
      role: "consumerOrder",
      currentUpdateIndex: state._supplyOrderConfirmation.currentUpdateIndex,
      owner: { type: '_supplyOrderConfirmation', id: state._supplyOrderConfirmation.id, listName: 'consumerOrderList', ref:state._supplyOrderConfirmation, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderUpdateForm)
  }

  getSupplyOrderSearch = () => {
    const {SupplyOrderSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Supply Order",
      role: "supplyOrder",
      data: state._supplyOrderConfirmation.supplyOrderList,
      metaInfo: state._supplyOrderConfirmation.supplyOrderListMetaInfo,
      count: state._supplyOrderConfirmation.supplyOrderCount,
      currentPage: state._supplyOrderConfirmation.supplyOrderCurrentPageNumber,
      searchFormParameters: state._supplyOrderConfirmation.supplyOrderSearchFormParameters,
      searchParameters: {...state._supplyOrderConfirmation.searchParameters},
      expandForm: state._supplyOrderConfirmation.expandForm,
      loading: state._supplyOrderConfirmation.loading,
      partialList: state._supplyOrderConfirmation.partialList,
      owner: { type: '_supplyOrderConfirmation', id: state._supplyOrderConfirmation.id, 
      referenceName: 'confirmation', 
      listName: 'supplyOrderList', ref:state._supplyOrderConfirmation, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderSearch)
  }
  getSupplyOrderCreateForm = () => {
   	const {SupplyOrderCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "supplyOrder",
      data: state._supplyOrderConfirmation.supplyOrderList,
      metaInfo: state._supplyOrderConfirmation.supplyOrderListMetaInfo,
      count: state._supplyOrderConfirmation.supplyOrderCount,
      currentPage: state._supplyOrderConfirmation.supplyOrderCurrentPageNumber,
      searchFormParameters: state._supplyOrderConfirmation.supplyOrderSearchFormParameters,
      loading: state._supplyOrderConfirmation.loading,
      owner: { type: '_supplyOrderConfirmation', id: state._supplyOrderConfirmation.id, referenceName: 'confirmation', listName: 'supplyOrderList', ref:state._supplyOrderConfirmation, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SupplyOrderCreateForm)
  }
  
  getSupplyOrderUpdateForm = () => {
    const userContext = null
  	const {SupplyOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._supplyOrderConfirmation.selectedRows,
      role: "supplyOrder",
      currentUpdateIndex: state._supplyOrderConfirmation.currentUpdateIndex,
      owner: { type: '_supplyOrderConfirmation', id: state._supplyOrderConfirmation.id, listName: 'supplyOrderList', ref:state._supplyOrderConfirmation, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderUpdateForm)
  }


  
  buildRouters = () =>{
  	const {SupplyOrderConfirmationDashboard} = GlobalComponents
  	const {SupplyOrderConfirmationPermission} = GlobalComponents
  	const {SupplyOrderConfirmationProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/supplyOrderConfirmation/:id/dashboard", component: SupplyOrderConfirmationDashboard},
  	{path:"/supplyOrderConfirmation/:id/profile", component: SupplyOrderConfirmationProfile},
  	{path:"/supplyOrderConfirmation/:id/permission", component: SupplyOrderConfirmationPermission},
  	
  	
  	
  	{path:"/supplyOrderConfirmation/:id/list/consumerOrderList", component: this.getConsumerOrderSearch()},
  	{path:"/supplyOrderConfirmation/:id/list/consumerOrderCreateForm", component: this.getConsumerOrderCreateForm()},
  	{path:"/supplyOrderConfirmation/:id/list/consumerOrderUpdateForm", component: this.getConsumerOrderUpdateForm()},
   	
  	{path:"/supplyOrderConfirmation/:id/list/supplyOrderList", component: this.getSupplyOrderSearch()},
  	{path:"/supplyOrderConfirmation/:id/list/supplyOrderCreateForm", component: this.getSupplyOrderCreateForm()},
  	{path:"/supplyOrderConfirmation/:id/list/supplyOrderUpdateForm", component: this.getSupplyOrderUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.supplyOrderConfirmation)}
		 
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
  supplyOrderConfirmation: state._supplyOrderConfirmation,
  ...state,
}))(SupplyOrderConfirmationBizApp)



