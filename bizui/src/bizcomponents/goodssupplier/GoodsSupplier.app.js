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
import styles from './GoodsSupplier.app.less'
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




class GoodsSupplierBizApp extends React.PureComponent {
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
      return ['/goodsSupplier/']
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
               <Link to={`/goodsSupplier/${this.props.goodsSupplier.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
               		<Link to={`/goodsSupplier/${this.props.goodsSupplier.id}/permission`}><Icon type="safety-certificate" /><span>{appLocaleName(userContext,"Permission")}</span></Link>
             	</Menu.Item>
             	<Menu.Item key="permission">
               		<Link to={`/goodsSupplier/${this.props.goodsSupplier.id}/profile`}><Icon type="cluster" /><span>{appLocaleName(userContext,"Profile")}</span></Link>
             	</Menu.Item> 
      
        	</SubMenu>
        
           </Menu>
    )
  }
  



  getSupplierProductSearch = () => {
    const {SupplierProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Supplier Product",
      role: "supplierProduct",
      data: state._goodsSupplier.supplierProductList,
      metaInfo: state._goodsSupplier.supplierProductListMetaInfo,
      count: state._goodsSupplier.supplierProductCount,
      currentPage: state._goodsSupplier.supplierProductCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.supplierProductSearchFormParameters,
      searchParameters: {...state._goodsSupplier.searchParameters},
      expandForm: state._goodsSupplier.expandForm,
      loading: state._goodsSupplier.loading,
      partialList: state._goodsSupplier.partialList,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, 
      referenceName: 'supplier', 
      listName: 'supplierProductList', ref:state._goodsSupplier, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplierProductSearch)
  }
  getSupplierProductCreateForm = () => {
   	const {SupplierProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "supplierProduct",
      data: state._goodsSupplier.supplierProductList,
      metaInfo: state._goodsSupplier.supplierProductListMetaInfo,
      count: state._goodsSupplier.supplierProductCount,
      currentPage: state._goodsSupplier.supplierProductCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.supplierProductSearchFormParameters,
      loading: state._goodsSupplier.loading,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, referenceName: 'supplier', listName: 'supplierProductList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SupplierProductCreateForm)
  }
  
  getSupplierProductUpdateForm = () => {
    const userContext = null
  	const {SupplierProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._goodsSupplier.selectedRows,
      role: "supplierProduct",
      currentUpdateIndex: state._goodsSupplier.currentUpdateIndex,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, listName: 'supplierProductList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplierProductUpdateForm)
  }

  getSupplyOrderSearch = () => {
    const {SupplyOrderSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Supply Order",
      role: "supplyOrder",
      data: state._goodsSupplier.supplyOrderList,
      metaInfo: state._goodsSupplier.supplyOrderListMetaInfo,
      count: state._goodsSupplier.supplyOrderCount,
      currentPage: state._goodsSupplier.supplyOrderCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.supplyOrderSearchFormParameters,
      searchParameters: {...state._goodsSupplier.searchParameters},
      expandForm: state._goodsSupplier.expandForm,
      loading: state._goodsSupplier.loading,
      partialList: state._goodsSupplier.partialList,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, 
      referenceName: 'seller', 
      listName: 'supplyOrderList', ref:state._goodsSupplier, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderSearch)
  }
  getSupplyOrderCreateForm = () => {
   	const {SupplyOrderCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "supplyOrder",
      data: state._goodsSupplier.supplyOrderList,
      metaInfo: state._goodsSupplier.supplyOrderListMetaInfo,
      count: state._goodsSupplier.supplyOrderCount,
      currentPage: state._goodsSupplier.supplyOrderCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.supplyOrderSearchFormParameters,
      loading: state._goodsSupplier.loading,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, referenceName: 'seller', listName: 'supplyOrderList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SupplyOrderCreateForm)
  }
  
  getSupplyOrderUpdateForm = () => {
    const userContext = null
  	const {SupplyOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._goodsSupplier.selectedRows,
      role: "supplyOrder",
      currentUpdateIndex: state._goodsSupplier.currentUpdateIndex,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, listName: 'supplyOrderList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderUpdateForm)
  }

  getAccountSetSearch = () => {
    const {AccountSetSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Account Set",
      role: "accountSet",
      data: state._goodsSupplier.accountSetList,
      metaInfo: state._goodsSupplier.accountSetListMetaInfo,
      count: state._goodsSupplier.accountSetCount,
      currentPage: state._goodsSupplier.accountSetCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.accountSetSearchFormParameters,
      searchParameters: {...state._goodsSupplier.searchParameters},
      expandForm: state._goodsSupplier.expandForm,
      loading: state._goodsSupplier.loading,
      partialList: state._goodsSupplier.partialList,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, 
      referenceName: 'goodsSupplier', 
      listName: 'accountSetList', ref:state._goodsSupplier, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountSetSearch)
  }
  getAccountSetCreateForm = () => {
   	const {AccountSetCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "accountSet",
      data: state._goodsSupplier.accountSetList,
      metaInfo: state._goodsSupplier.accountSetListMetaInfo,
      count: state._goodsSupplier.accountSetCount,
      currentPage: state._goodsSupplier.accountSetCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.accountSetSearchFormParameters,
      loading: state._goodsSupplier.loading,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, referenceName: 'goodsSupplier', listName: 'accountSetList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AccountSetCreateForm)
  }
  
  getAccountSetUpdateForm = () => {
    const userContext = null
  	const {AccountSetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._goodsSupplier.selectedRows,
      role: "accountSet",
      currentUpdateIndex: state._goodsSupplier.currentUpdateIndex,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, listName: 'accountSetList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountSetUpdateForm)
  }


  
  buildRouters = () =>{
  	const {GoodsSupplierDashboard} = GlobalComponents
  	const {GoodsSupplierPermission} = GlobalComponents
  	const {GoodsSupplierProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/goodsSupplier/:id/dashboard", component: GoodsSupplierDashboard},
  	{path:"/goodsSupplier/:id/profile", component: GoodsSupplierProfile},
  	{path:"/goodsSupplier/:id/permission", component: GoodsSupplierPermission},
  	
  	
  	
  	{path:"/goodsSupplier/:id/list/supplierProductList", component: this.getSupplierProductSearch()},
  	{path:"/goodsSupplier/:id/list/supplierProductCreateForm", component: this.getSupplierProductCreateForm()},
  	{path:"/goodsSupplier/:id/list/supplierProductUpdateForm", component: this.getSupplierProductUpdateForm()},
   	
  	{path:"/goodsSupplier/:id/list/supplyOrderList", component: this.getSupplyOrderSearch()},
  	{path:"/goodsSupplier/:id/list/supplyOrderCreateForm", component: this.getSupplyOrderCreateForm()},
  	{path:"/goodsSupplier/:id/list/supplyOrderUpdateForm", component: this.getSupplyOrderUpdateForm()},
   	
  	{path:"/goodsSupplier/:id/list/accountSetList", component: this.getAccountSetSearch()},
  	{path:"/goodsSupplier/:id/list/accountSetCreateForm", component: this.getAccountSetCreateForm()},
  	{path:"/goodsSupplier/:id/list/accountSetUpdateForm", component: this.getAccountSetUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.goodsSupplier)}
		 
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
  goodsSupplier: state._goodsSupplier,
  ...state,
}))(GoodsSupplierBizApp)



