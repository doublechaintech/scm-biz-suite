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
import styles from './RetailStoreOrder.app.less'
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




class RetailStoreOrderBizApp extends React.PureComponent {
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
      return ['/retailStoreOrder/']
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
               <Link to={`/retailStoreOrder/${this.props.retailStoreOrder.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
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
               <Link to={`/retailStoreOrder/${this.props.retailStoreOrder.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
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
               <Link to={`/retailStoreOrder/${this.props.retailStoreOrder.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getRetailStoreOrderLineItemSearch = () => {
    const {RetailStoreOrderLineItemSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "双链小超订单行项目",
      role: "retailStoreOrderLineItem",
      data: state._retailStoreOrder.retailStoreOrderLineItemList,
      metaInfo: state._retailStoreOrder.retailStoreOrderLineItemListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderLineItemCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreOrder.retailStoreOrderLineItemCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderLineItemSearchFormParameters,
      searchParameters: {...state._retailStoreOrder.searchParameters},
      expandForm: state._retailStoreOrder.expandForm,
      loading: state._retailStoreOrder.loading,
      partialList: state._retailStoreOrder.partialList,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'retailStoreOrderLineItemList', ref:state._retailStoreOrder, 
<<<<<<< HEAD
      listDisplayName: '双链小超订单行项目列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderLineItemSearch)
  }
  getRetailStoreOrderLineItemCreateForm = () => {
   	const {RetailStoreOrderLineItemCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreOrderLineItem",
      data: state._retailStoreOrder.retailStoreOrderLineItemList,
      metaInfo: state._retailStoreOrder.retailStoreOrderLineItemListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderLineItemCount,
<<<<<<< HEAD
      currentPage: state._retailStoreOrder.retailStoreOrderLineItemCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderLineItemSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, referenceName: 'bizOrder', listName: 'retailStoreOrderLineItemList', ref:state._retailStoreOrder, listDisplayName: '双链小超订单行项目列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/list`,
      currentPage: state._retailStoreOrder.retailStoreOrderLineItemCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderLineItemSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, referenceName: 'bizOrder', listName: 'retailStoreOrderLineItemList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderLineItemCreateForm)
  }
  
  getRetailStoreOrderLineItemUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {RetailStoreOrderLineItemUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreOrder.selectedRows,
      role: "retailStoreOrderLineItem",
      currentUpdateIndex: state._retailStoreOrder.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, listName: 'retailStoreOrderLineItemList', ref:state._retailStoreOrder, listDisplayName: '双链小超订单行项目列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, listName: 'retailStoreOrderLineItemList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderLineItemUpdateForm)
  }

  getRetailStoreOrderShippingGroupSearch = () => {
    const {RetailStoreOrderShippingGroupSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "生超订单送货分组",
      role: "retailStoreOrderShippingGroup",
      data: state._retailStoreOrder.retailStoreOrderShippingGroupList,
      metaInfo: state._retailStoreOrder.retailStoreOrderShippingGroupListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderShippingGroupCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreOrder.retailStoreOrderShippingGroupCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderShippingGroupSearchFormParameters,
      searchParameters: {...state._retailStoreOrder.searchParameters},
      expandForm: state._retailStoreOrder.expandForm,
      loading: state._retailStoreOrder.loading,
      partialList: state._retailStoreOrder.partialList,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'retailStoreOrderShippingGroupList', ref:state._retailStoreOrder, 
<<<<<<< HEAD
      listDisplayName: '生超订单送货分组列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderShippingGroupSearch)
  }
  getRetailStoreOrderShippingGroupCreateForm = () => {
   	const {RetailStoreOrderShippingGroupCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreOrderShippingGroup",
      data: state._retailStoreOrder.retailStoreOrderShippingGroupList,
      metaInfo: state._retailStoreOrder.retailStoreOrderShippingGroupListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderShippingGroupCount,
<<<<<<< HEAD
      currentPage: state._retailStoreOrder.retailStoreOrderShippingGroupCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderShippingGroupSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, referenceName: 'bizOrder', listName: 'retailStoreOrderShippingGroupList', ref:state._retailStoreOrder, listDisplayName: '生超订单送货分组列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/list`,
      currentPage: state._retailStoreOrder.retailStoreOrderShippingGroupCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderShippingGroupSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, referenceName: 'bizOrder', listName: 'retailStoreOrderShippingGroupList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderShippingGroupCreateForm)
  }
  
  getRetailStoreOrderShippingGroupUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {RetailStoreOrderShippingGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreOrder.selectedRows,
      role: "retailStoreOrderShippingGroup",
      currentUpdateIndex: state._retailStoreOrder.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, listName: 'retailStoreOrderShippingGroupList', ref:state._retailStoreOrder, listDisplayName: '生超订单送货分组列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, listName: 'retailStoreOrderShippingGroupList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderShippingGroupUpdateForm)
  }

  getRetailStoreOrderPaymentGroupSearch = () => {
    const {RetailStoreOrderPaymentGroupSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "生超订单付款组",
      role: "retailStoreOrderPaymentGroup",
      data: state._retailStoreOrder.retailStoreOrderPaymentGroupList,
      metaInfo: state._retailStoreOrder.retailStoreOrderPaymentGroupListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderPaymentGroupCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreOrder.retailStoreOrderPaymentGroupCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderPaymentGroupSearchFormParameters,
      searchParameters: {...state._retailStoreOrder.searchParameters},
      expandForm: state._retailStoreOrder.expandForm,
      loading: state._retailStoreOrder.loading,
      partialList: state._retailStoreOrder.partialList,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'retailStoreOrderPaymentGroupList', ref:state._retailStoreOrder, 
<<<<<<< HEAD
      listDisplayName: '生超订单付款组列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderPaymentGroupSearch)
  }
  getRetailStoreOrderPaymentGroupCreateForm = () => {
   	const {RetailStoreOrderPaymentGroupCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreOrderPaymentGroup",
      data: state._retailStoreOrder.retailStoreOrderPaymentGroupList,
      metaInfo: state._retailStoreOrder.retailStoreOrderPaymentGroupListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderPaymentGroupCount,
<<<<<<< HEAD
      currentPage: state._retailStoreOrder.retailStoreOrderPaymentGroupCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderPaymentGroupSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, referenceName: 'bizOrder', listName: 'retailStoreOrderPaymentGroupList', ref:state._retailStoreOrder, listDisplayName: '生超订单付款组列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/list`,
      currentPage: state._retailStoreOrder.retailStoreOrderPaymentGroupCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderPaymentGroupSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, referenceName: 'bizOrder', listName: 'retailStoreOrderPaymentGroupList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderPaymentGroupCreateForm)
  }
  
  getRetailStoreOrderPaymentGroupUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {RetailStoreOrderPaymentGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreOrder.selectedRows,
      role: "retailStoreOrderPaymentGroup",
      currentUpdateIndex: state._retailStoreOrder.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, listName: 'retailStoreOrderPaymentGroupList', ref:state._retailStoreOrder, listDisplayName: '生超订单付款组列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, listName: 'retailStoreOrderPaymentGroupList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderPaymentGroupUpdateForm)
  }

  getGoodsSearch = () => {
    const {GoodsSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "货物",
      role: "goods",
      data: state._retailStoreOrder.goodsList,
      metaInfo: state._retailStoreOrder.goodsListMetaInfo,
      count: state._retailStoreOrder.goodsCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreOrder.goodsCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.goodsSearchFormParameters,
      searchParameters: {...state._retailStoreOrder.searchParameters},
      expandForm: state._retailStoreOrder.expandForm,
      loading: state._retailStoreOrder.loading,
      partialList: state._retailStoreOrder.partialList,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, 
      referenceName: 'retailStoreOrder', 
      listName: 'goodsList', ref:state._retailStoreOrder, 
<<<<<<< HEAD
      listDisplayName: '货物列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(GoodsSearch)
  }
  getGoodsCreateForm = () => {
   	const {GoodsCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "goods",
      data: state._retailStoreOrder.goodsList,
      metaInfo: state._retailStoreOrder.goodsListMetaInfo,
      count: state._retailStoreOrder.goodsCount,
<<<<<<< HEAD
      currentPage: state._retailStoreOrder.goodsCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.goodsSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, referenceName: 'retailStoreOrder', listName: 'goodsList', ref:state._retailStoreOrder, listDisplayName: '货物列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/list`,
      currentPage: state._retailStoreOrder.goodsCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.goodsSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, referenceName: 'retailStoreOrder', listName: 'goodsList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(GoodsCreateForm)
  }
  
  getGoodsUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {GoodsUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreOrder.selectedRows,
      role: "goods",
      currentUpdateIndex: state._retailStoreOrder.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, listName: 'goodsList', ref:state._retailStoreOrder, listDisplayName: '货物列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, listName: 'goodsList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(GoodsUpdateForm)
  }


  
  buildRouters = () =>{
  	const {RetailStoreOrderDashboard} = GlobalComponents
<<<<<<< HEAD
  	const {RetailStoreOrderPreference} = GlobalComponents
=======
  	const {RetailStoreOrderPermission} = GlobalComponents
  	const {RetailStoreOrderProfile} = GlobalComponents
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	const routers=[
  	{path:"/retailStoreOrder/:id/dashboard", component: RetailStoreOrderDashboard},
<<<<<<< HEAD
  	{path:"/retailStoreOrder/:id/preference", component: RetailStoreOrderPreference},
=======
  	{path:"/retailStoreOrder/:id/profile", component: RetailStoreOrderProfile},
  	{path:"/retailStoreOrder/:id/permission", component: RetailStoreOrderPermission},
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	
  	{path:"/retailStoreOrder/:id/list/retailStoreOrderLineItemList", component: this.getRetailStoreOrderLineItemSearch()},
  	{path:"/retailStoreOrder/:id/list/retailStoreOrderLineItemCreateForm", component: this.getRetailStoreOrderLineItemCreateForm()},
  	{path:"/retailStoreOrder/:id/list/retailStoreOrderLineItemUpdateForm", component: this.getRetailStoreOrderLineItemUpdateForm()},
   	
  	{path:"/retailStoreOrder/:id/list/retailStoreOrderShippingGroupList", component: this.getRetailStoreOrderShippingGroupSearch()},
  	{path:"/retailStoreOrder/:id/list/retailStoreOrderShippingGroupCreateForm", component: this.getRetailStoreOrderShippingGroupCreateForm()},
  	{path:"/retailStoreOrder/:id/list/retailStoreOrderShippingGroupUpdateForm", component: this.getRetailStoreOrderShippingGroupUpdateForm()},
   	
  	{path:"/retailStoreOrder/:id/list/retailStoreOrderPaymentGroupList", component: this.getRetailStoreOrderPaymentGroupSearch()},
  	{path:"/retailStoreOrder/:id/list/retailStoreOrderPaymentGroupCreateForm", component: this.getRetailStoreOrderPaymentGroupCreateForm()},
  	{path:"/retailStoreOrder/:id/list/retailStoreOrderPaymentGroupUpdateForm", component: this.getRetailStoreOrderPaymentGroupUpdateForm()},
   	
  	{path:"/retailStoreOrder/:id/list/goodsList", component: this.getGoodsSearch()},
  	{path:"/retailStoreOrder/:id/list/goodsCreateForm", component: this.getGoodsCreateForm()},
  	{path:"/retailStoreOrder/:id/list/goodsUpdateForm", component: this.getGoodsUpdateForm()},
     	
  	
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

     //const {RetailStoreOrderEditDetail} = GlobalComponents
     //const {RetailStoreOrderViewDetail} = GlobalComponents
     
     
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

		 {this.getNavMenuItems(this.props.retailStoreOrder)}
		 
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
            <Dropdown overlay= {this.getNavMenuItems(this.props.retailStoreOrder)}>
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
  retailStoreOrder: state._retailStoreOrder,
  ...state,
}))(RetailStoreOrderBizApp)



