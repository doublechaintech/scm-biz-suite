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
import styles from './Warehouse.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'

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




class WarehouseBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
    // 把一级 Layout 的 children 作为菜单项
    // this.menus = getNavData().reduce((arr, current) => arr.concat(current.children), [])
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
      return ['/warehouse/']
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
  
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/warehouse/${this.props.warehouse.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
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
               <Link to={`/warehouse/${this.props.warehouse.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getStorageSpaceSearch = () => {
    const {StorageSpaceSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "存货区",
      role: "storageSpace",
      data: state._warehouse.storageSpaceList,
      metaInfo: state._warehouse.storageSpaceListMetaInfo,
      count: state._warehouse.storageSpaceCount,
      currentPage: state._warehouse.storageSpaceCurrentPageNumber,
      searchFormParameters: state._warehouse.storageSpaceSearchFormParameters,
      searchParameters: {...state._warehouse.searchParameters},
      expandForm: state._warehouse.expandForm,
      loading: state._warehouse.loading,
      partialList: state._warehouse.partialList,
      owner: { type: '_warehouse', id: state._warehouse.id, 
      referenceName: 'warehouse', 
      listName: 'storageSpaceList', ref:state._warehouse, 
      listDisplayName: '存货区列表' }, // this is for model namespace and
    }))(StorageSpaceSearch)
  }
  getStorageSpaceCreateForm = () => {
   	const {StorageSpaceCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "storageSpace",
      data: state._warehouse.storageSpaceList,
      metaInfo: state._warehouse.storageSpaceListMetaInfo,
      count: state._warehouse.storageSpaceCount,
      currentPage: state._warehouse.storageSpaceCurrentPageNumber,
      searchFormParameters: state._warehouse.storageSpaceSearchFormParameters,
      loading: state._warehouse.loading,
      owner: { type: '_warehouse', id: state._warehouse.id, referenceName: 'warehouse', listName: 'storageSpaceList', ref:state._warehouse, listDisplayName: '存货区列表'}, // this is for model namespace and
    }))(StorageSpaceCreateForm)
  }
  
  getStorageSpaceUpdateForm = () => {
  	const {StorageSpaceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._warehouse.selectedRows,
      role: "storageSpace",
      currentUpdateIndex: state._warehouse.currentUpdateIndex,
      owner: { type: '_warehouse', id: state._warehouse.id, listName: 'storageSpaceList', ref:state._warehouse, listDisplayName: '存货区列表' }, // this is for model namespace and
    }))(StorageSpaceUpdateForm)
  }

  getSmartPalletSearch = () => {
    const {SmartPalletSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "智能托盘",
      role: "smartPallet",
      data: state._warehouse.smartPalletList,
      metaInfo: state._warehouse.smartPalletListMetaInfo,
      count: state._warehouse.smartPalletCount,
      currentPage: state._warehouse.smartPalletCurrentPageNumber,
      searchFormParameters: state._warehouse.smartPalletSearchFormParameters,
      searchParameters: {...state._warehouse.searchParameters},
      expandForm: state._warehouse.expandForm,
      loading: state._warehouse.loading,
      partialList: state._warehouse.partialList,
      owner: { type: '_warehouse', id: state._warehouse.id, 
      referenceName: 'warehouse', 
      listName: 'smartPalletList', ref:state._warehouse, 
      listDisplayName: '智能托盘列表' }, // this is for model namespace and
    }))(SmartPalletSearch)
  }
  getSmartPalletCreateForm = () => {
   	const {SmartPalletCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "smartPallet",
      data: state._warehouse.smartPalletList,
      metaInfo: state._warehouse.smartPalletListMetaInfo,
      count: state._warehouse.smartPalletCount,
      currentPage: state._warehouse.smartPalletCurrentPageNumber,
      searchFormParameters: state._warehouse.smartPalletSearchFormParameters,
      loading: state._warehouse.loading,
      owner: { type: '_warehouse', id: state._warehouse.id, referenceName: 'warehouse', listName: 'smartPalletList', ref:state._warehouse, listDisplayName: '智能托盘列表'}, // this is for model namespace and
    }))(SmartPalletCreateForm)
  }
  
  getSmartPalletUpdateForm = () => {
  	const {SmartPalletUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._warehouse.selectedRows,
      role: "smartPallet",
      currentUpdateIndex: state._warehouse.currentUpdateIndex,
      owner: { type: '_warehouse', id: state._warehouse.id, listName: 'smartPalletList', ref:state._warehouse, listDisplayName: '智能托盘列表' }, // this is for model namespace and
    }))(SmartPalletUpdateForm)
  }

  getSupplierSpaceSearch = () => {
    const {SupplierSpaceSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "供应商的空间",
      role: "supplierSpace",
      data: state._warehouse.supplierSpaceList,
      metaInfo: state._warehouse.supplierSpaceListMetaInfo,
      count: state._warehouse.supplierSpaceCount,
      currentPage: state._warehouse.supplierSpaceCurrentPageNumber,
      searchFormParameters: state._warehouse.supplierSpaceSearchFormParameters,
      searchParameters: {...state._warehouse.searchParameters},
      expandForm: state._warehouse.expandForm,
      loading: state._warehouse.loading,
      partialList: state._warehouse.partialList,
      owner: { type: '_warehouse', id: state._warehouse.id, 
      referenceName: 'warehouse', 
      listName: 'supplierSpaceList', ref:state._warehouse, 
      listDisplayName: '供应商的空间列表' }, // this is for model namespace and
    }))(SupplierSpaceSearch)
  }
  getSupplierSpaceCreateForm = () => {
   	const {SupplierSpaceCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "supplierSpace",
      data: state._warehouse.supplierSpaceList,
      metaInfo: state._warehouse.supplierSpaceListMetaInfo,
      count: state._warehouse.supplierSpaceCount,
      currentPage: state._warehouse.supplierSpaceCurrentPageNumber,
      searchFormParameters: state._warehouse.supplierSpaceSearchFormParameters,
      loading: state._warehouse.loading,
      owner: { type: '_warehouse', id: state._warehouse.id, referenceName: 'warehouse', listName: 'supplierSpaceList', ref:state._warehouse, listDisplayName: '供应商的空间列表'}, // this is for model namespace and
    }))(SupplierSpaceCreateForm)
  }
  
  getSupplierSpaceUpdateForm = () => {
  	const {SupplierSpaceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._warehouse.selectedRows,
      role: "supplierSpace",
      currentUpdateIndex: state._warehouse.currentUpdateIndex,
      owner: { type: '_warehouse', id: state._warehouse.id, listName: 'supplierSpaceList', ref:state._warehouse, listDisplayName: '供应商的空间列表' }, // this is for model namespace and
    }))(SupplierSpaceUpdateForm)
  }

  getReceivingSpaceSearch = () => {
    const {ReceivingSpaceSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "收货区",
      role: "receivingSpace",
      data: state._warehouse.receivingSpaceList,
      metaInfo: state._warehouse.receivingSpaceListMetaInfo,
      count: state._warehouse.receivingSpaceCount,
      currentPage: state._warehouse.receivingSpaceCurrentPageNumber,
      searchFormParameters: state._warehouse.receivingSpaceSearchFormParameters,
      searchParameters: {...state._warehouse.searchParameters},
      expandForm: state._warehouse.expandForm,
      loading: state._warehouse.loading,
      partialList: state._warehouse.partialList,
      owner: { type: '_warehouse', id: state._warehouse.id, 
      referenceName: 'warehouse', 
      listName: 'receivingSpaceList', ref:state._warehouse, 
      listDisplayName: '收货区列表' }, // this is for model namespace and
    }))(ReceivingSpaceSearch)
  }
  getReceivingSpaceCreateForm = () => {
   	const {ReceivingSpaceCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "receivingSpace",
      data: state._warehouse.receivingSpaceList,
      metaInfo: state._warehouse.receivingSpaceListMetaInfo,
      count: state._warehouse.receivingSpaceCount,
      currentPage: state._warehouse.receivingSpaceCurrentPageNumber,
      searchFormParameters: state._warehouse.receivingSpaceSearchFormParameters,
      loading: state._warehouse.loading,
      owner: { type: '_warehouse', id: state._warehouse.id, referenceName: 'warehouse', listName: 'receivingSpaceList', ref:state._warehouse, listDisplayName: '收货区列表'}, // this is for model namespace and
    }))(ReceivingSpaceCreateForm)
  }
  
  getReceivingSpaceUpdateForm = () => {
  	const {ReceivingSpaceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._warehouse.selectedRows,
      role: "receivingSpace",
      currentUpdateIndex: state._warehouse.currentUpdateIndex,
      owner: { type: '_warehouse', id: state._warehouse.id, listName: 'receivingSpaceList', ref:state._warehouse, listDisplayName: '收货区列表' }, // this is for model namespace and
    }))(ReceivingSpaceUpdateForm)
  }

  getShippingSpaceSearch = () => {
    const {ShippingSpaceSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "发货区",
      role: "shippingSpace",
      data: state._warehouse.shippingSpaceList,
      metaInfo: state._warehouse.shippingSpaceListMetaInfo,
      count: state._warehouse.shippingSpaceCount,
      currentPage: state._warehouse.shippingSpaceCurrentPageNumber,
      searchFormParameters: state._warehouse.shippingSpaceSearchFormParameters,
      searchParameters: {...state._warehouse.searchParameters},
      expandForm: state._warehouse.expandForm,
      loading: state._warehouse.loading,
      partialList: state._warehouse.partialList,
      owner: { type: '_warehouse', id: state._warehouse.id, 
      referenceName: 'warehouse', 
      listName: 'shippingSpaceList', ref:state._warehouse, 
      listDisplayName: '发货区列表' }, // this is for model namespace and
    }))(ShippingSpaceSearch)
  }
  getShippingSpaceCreateForm = () => {
   	const {ShippingSpaceCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "shippingSpace",
      data: state._warehouse.shippingSpaceList,
      metaInfo: state._warehouse.shippingSpaceListMetaInfo,
      count: state._warehouse.shippingSpaceCount,
      currentPage: state._warehouse.shippingSpaceCurrentPageNumber,
      searchFormParameters: state._warehouse.shippingSpaceSearchFormParameters,
      loading: state._warehouse.loading,
      owner: { type: '_warehouse', id: state._warehouse.id, referenceName: 'warehouse', listName: 'shippingSpaceList', ref:state._warehouse, listDisplayName: '发货区列表'}, // this is for model namespace and
    }))(ShippingSpaceCreateForm)
  }
  
  getShippingSpaceUpdateForm = () => {
  	const {ShippingSpaceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._warehouse.selectedRows,
      role: "shippingSpace",
      currentUpdateIndex: state._warehouse.currentUpdateIndex,
      owner: { type: '_warehouse', id: state._warehouse.id, listName: 'shippingSpaceList', ref:state._warehouse, listDisplayName: '发货区列表' }, // this is for model namespace and
    }))(ShippingSpaceUpdateForm)
  }

  getDamageSpaceSearch = () => {
    const {DamageSpaceSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "残次货物存放区",
      role: "damageSpace",
      data: state._warehouse.damageSpaceList,
      metaInfo: state._warehouse.damageSpaceListMetaInfo,
      count: state._warehouse.damageSpaceCount,
      currentPage: state._warehouse.damageSpaceCurrentPageNumber,
      searchFormParameters: state._warehouse.damageSpaceSearchFormParameters,
      searchParameters: {...state._warehouse.searchParameters},
      expandForm: state._warehouse.expandForm,
      loading: state._warehouse.loading,
      partialList: state._warehouse.partialList,
      owner: { type: '_warehouse', id: state._warehouse.id, 
      referenceName: 'warehouse', 
      listName: 'damageSpaceList', ref:state._warehouse, 
      listDisplayName: '残次货物存放区列表' }, // this is for model namespace and
    }))(DamageSpaceSearch)
  }
  getDamageSpaceCreateForm = () => {
   	const {DamageSpaceCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "damageSpace",
      data: state._warehouse.damageSpaceList,
      metaInfo: state._warehouse.damageSpaceListMetaInfo,
      count: state._warehouse.damageSpaceCount,
      currentPage: state._warehouse.damageSpaceCurrentPageNumber,
      searchFormParameters: state._warehouse.damageSpaceSearchFormParameters,
      loading: state._warehouse.loading,
      owner: { type: '_warehouse', id: state._warehouse.id, referenceName: 'warehouse', listName: 'damageSpaceList', ref:state._warehouse, listDisplayName: '残次货物存放区列表'}, // this is for model namespace and
    }))(DamageSpaceCreateForm)
  }
  
  getDamageSpaceUpdateForm = () => {
  	const {DamageSpaceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._warehouse.selectedRows,
      role: "damageSpace",
      currentUpdateIndex: state._warehouse.currentUpdateIndex,
      owner: { type: '_warehouse', id: state._warehouse.id, listName: 'damageSpaceList', ref:state._warehouse, listDisplayName: '残次货物存放区列表' }, // this is for model namespace and
    }))(DamageSpaceUpdateForm)
  }

  getWarehouseAssetSearch = () => {
    const {WarehouseAssetSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "仓库资产",
      role: "warehouseAsset",
      data: state._warehouse.warehouseAssetList,
      metaInfo: state._warehouse.warehouseAssetListMetaInfo,
      count: state._warehouse.warehouseAssetCount,
      currentPage: state._warehouse.warehouseAssetCurrentPageNumber,
      searchFormParameters: state._warehouse.warehouseAssetSearchFormParameters,
      searchParameters: {...state._warehouse.searchParameters},
      expandForm: state._warehouse.expandForm,
      loading: state._warehouse.loading,
      partialList: state._warehouse.partialList,
      owner: { type: '_warehouse', id: state._warehouse.id, 
      referenceName: 'owner', 
      listName: 'warehouseAssetList', ref:state._warehouse, 
      listDisplayName: '仓库资产列表' }, // this is for model namespace and
    }))(WarehouseAssetSearch)
  }
  getWarehouseAssetCreateForm = () => {
   	const {WarehouseAssetCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "warehouseAsset",
      data: state._warehouse.warehouseAssetList,
      metaInfo: state._warehouse.warehouseAssetListMetaInfo,
      count: state._warehouse.warehouseAssetCount,
      currentPage: state._warehouse.warehouseAssetCurrentPageNumber,
      searchFormParameters: state._warehouse.warehouseAssetSearchFormParameters,
      loading: state._warehouse.loading,
      owner: { type: '_warehouse', id: state._warehouse.id, referenceName: 'owner', listName: 'warehouseAssetList', ref:state._warehouse, listDisplayName: '仓库资产列表'}, // this is for model namespace and
    }))(WarehouseAssetCreateForm)
  }
  
  getWarehouseAssetUpdateForm = () => {
  	const {WarehouseAssetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._warehouse.selectedRows,
      role: "warehouseAsset",
      currentUpdateIndex: state._warehouse.currentUpdateIndex,
      owner: { type: '_warehouse', id: state._warehouse.id, listName: 'warehouseAssetList', ref:state._warehouse, listDisplayName: '仓库资产列表' }, // this is for model namespace and
    }))(WarehouseAssetUpdateForm)
  }


  
  buildRouters = () =>{
  	const {WarehouseDashboard} = GlobalComponents
  	const {WarehousePreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/warehouse/:id/dashboard", component: WarehouseDashboard},
  	{path:"/warehouse/:id/preference", component: WarehousePreference},
  	
  	
  	
  	{path:"/warehouse/:id/list/storageSpaceList", component: this.getStorageSpaceSearch()},
  	{path:"/warehouse/:id/list/storageSpaceCreateForm", component: this.getStorageSpaceCreateForm()},
  	{path:"/warehouse/:id/list/storageSpaceUpdateForm", component: this.getStorageSpaceUpdateForm()},
   	
  	{path:"/warehouse/:id/list/smartPalletList", component: this.getSmartPalletSearch()},
  	{path:"/warehouse/:id/list/smartPalletCreateForm", component: this.getSmartPalletCreateForm()},
  	{path:"/warehouse/:id/list/smartPalletUpdateForm", component: this.getSmartPalletUpdateForm()},
   	
  	{path:"/warehouse/:id/list/supplierSpaceList", component: this.getSupplierSpaceSearch()},
  	{path:"/warehouse/:id/list/supplierSpaceCreateForm", component: this.getSupplierSpaceCreateForm()},
  	{path:"/warehouse/:id/list/supplierSpaceUpdateForm", component: this.getSupplierSpaceUpdateForm()},
   	
  	{path:"/warehouse/:id/list/receivingSpaceList", component: this.getReceivingSpaceSearch()},
  	{path:"/warehouse/:id/list/receivingSpaceCreateForm", component: this.getReceivingSpaceCreateForm()},
  	{path:"/warehouse/:id/list/receivingSpaceUpdateForm", component: this.getReceivingSpaceUpdateForm()},
   	
  	{path:"/warehouse/:id/list/shippingSpaceList", component: this.getShippingSpaceSearch()},
  	{path:"/warehouse/:id/list/shippingSpaceCreateForm", component: this.getShippingSpaceCreateForm()},
  	{path:"/warehouse/:id/list/shippingSpaceUpdateForm", component: this.getShippingSpaceUpdateForm()},
   	
  	{path:"/warehouse/:id/list/damageSpaceList", component: this.getDamageSpaceSearch()},
  	{path:"/warehouse/:id/list/damageSpaceCreateForm", component: this.getDamageSpaceCreateForm()},
  	{path:"/warehouse/:id/list/damageSpaceUpdateForm", component: this.getDamageSpaceUpdateForm()},
   	
  	{path:"/warehouse/:id/list/warehouseAssetList", component: this.getWarehouseAssetSearch()},
  	{path:"/warehouse/:id/list/warehouseAssetCreateForm", component: this.getWarehouseAssetCreateForm()},
  	{path:"/warehouse/:id/list/warehouseAssetUpdateForm", component: this.getWarehouseAssetUpdateForm()},
     	
  	
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

     //const {WarehouseEditDetail} = GlobalComponents
     //const {WarehouseViewDetail} = GlobalComponents
     
     
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

		 {this.getNavMenuItems(this.props.warehouse)}
		 
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
  warehouse: state._warehouse,
  ...state,
}))(WarehouseBizApp)



