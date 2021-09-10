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
  AutoComplete,Row, Col,
  Input,Button,Tooltip,
} from 'antd'

import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './ConsumerOrder.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';
import TopMenu from '../../launcher/TopMenu'
import SwitchAppMenu from '../../launcher/SwitchAppMenu'

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


const naviBarResponsiveStyle = {
  xs: 10,
  sm: 10,
  md: 10,
  lg: 8,
  xl: 8,

};



const searchBarResponsiveStyle = {
  xs: 4,
  sm: 4,
  md: 4,
  lg: 8,
  xl: 8,

};

const userBarResponsiveStyle = {
  xs: 10,
  sm: 10,
  md: 10,
  lg: 8,
  xl: 8,

};



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

/*
const currentAppName=()=>{

  const targetApp = sessionObject('targetApp')
  return targetApp.title

}
*/

const currentAppName=()=>{

  const sysConfig=window.sysConfig
  const targetApp = sessionObject('targetApp')
  const {logo}=sysConfig()
  return <span><img width="25px" src={logo} style={{marginRight:"10px"}}/>{targetApp.title}</span>

}





class ConsumerOrderBizApp extends React.PureComponent {
constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
      showSearch: false,
      searchKeyword:''
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
      return ['/consumerOrder/']
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

 getNavMenuItems = (targetObject, style, customTheme) => {


    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
    const mode =style || "inline"
    const theme = customTheme || "light"
	const {objectId}=targetApp;
  	const userContext = null
  	const viewGroupIconNameOf=window.viewGroupIconNameOf
    const viewGroupDisplayNameOf=window.viewGroupDisplayNameOf

    return (
	  <Menu
        theme="dark"
        mode="inline"

        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}

       >

       <Menu.Item key="workbench">
        <Link to={`/consumerOrder/${this.props.consumerOrder.id}/workbench`}><Icon type="solution" style={{marginRight:"20px"}}/><span>工作台</span></Link>
      </Menu.Item>

        
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu id={`submenu-vg${index}`}  key={`vg${index}`} title={<span><Icon type={viewGroupIconNameOf('consumer_order',`${groupedMenuItem.viewGroup}`)} style={{marginRight:"20px"}} /><span>{viewGroupDisplayNameOf('consumer_order',`${groupedMenuItem.viewGroup}`)}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}
    </SubMenu>

        )}
        )}



           </Menu>
    )
  }

  getSelectedRows=()=>{
    const {state} = this.props.location

    if(!state){
      return null
    }
    if(!state.selectedRows){
      return null
    }
    if(state.selectedRows.length === 0){
      return null
    }
    return state.selectedRows[0]

  }

  getOwnerId=()=>{
    const {state} = this.props.location

    if(!state){
      return null
    }
    if(!state.ownerId){
      return null
    }

    return state.ownerId

  }



  getConsumerOrderLineItemSearch = () => {
    const {ConsumerOrderLineItemSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('consumer_order_line_item','consumer_order.consumer_order_line_item_list',false),
      role: "consumerOrderLineItem",
      data: state._consumerOrder.consumerOrderLineItemList,
      metaInfo: state._consumerOrder.consumerOrderLineItemListMetaInfo,
      count: state._consumerOrder.consumerOrderLineItemCount,
      returnURL: `/consumerOrder/${state._consumerOrder.id}/workbench`,
      currentPage: state._consumerOrder.consumerOrderLineItemCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderLineItemSearchFormParameters,
      searchParameters: {...state._consumerOrder.searchParameters},
      expandForm: state._consumerOrder.expandForm,
      loading: state._consumerOrder.loading,
      partialList: state._consumerOrder.partialList,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id,
      referenceName: 'bizOrder',
      listName: 'consumerOrderLineItemList', ref:state._consumerOrder,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderLineItemSearch)
  }

  getConsumerOrderLineItemCreateForm = () => {
   	const {ConsumerOrderLineItemCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "consumerOrderLineItem",
      data: state._consumerOrder.consumerOrderLineItemList,
      metaInfo: state._consumerOrder.consumerOrderLineItemListMetaInfo,
      count: state._consumerOrder.consumerOrderLineItemCount,
      returnURL: `/consumerOrder/${state._consumerOrder.id}/list`,
      currentPage: state._consumerOrder.consumerOrderLineItemCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderLineItemSearchFormParameters,
      loading: state._consumerOrder.loading,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id || this.getOwnerId(), referenceName: 'bizOrder', listName: 'consumerOrderLineItemList', ref:state._consumerOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ConsumerOrderLineItemCreateForm)
  }

  getConsumerOrderLineItemUpdateForm = () => {
    const userContext = null
  	const {ConsumerOrderLineItemUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._consumerOrder.selectedRows,
      role: "consumerOrderLineItem",
      currentUpdateIndex: state._consumerOrder.currentUpdateIndex || 0,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id || this.getOwnerId(), listName: 'consumerOrderLineItemList', ref:state._consumerOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderLineItemUpdateForm)
  }

  getConsumerOrderShippingGroupSearch = () => {
    const {ConsumerOrderShippingGroupSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('consumer_order_shipping_group','consumer_order.consumer_order_shipping_group_list',false),
      role: "consumerOrderShippingGroup",
      data: state._consumerOrder.consumerOrderShippingGroupList,
      metaInfo: state._consumerOrder.consumerOrderShippingGroupListMetaInfo,
      count: state._consumerOrder.consumerOrderShippingGroupCount,
      returnURL: `/consumerOrder/${state._consumerOrder.id}/workbench`,
      currentPage: state._consumerOrder.consumerOrderShippingGroupCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderShippingGroupSearchFormParameters,
      searchParameters: {...state._consumerOrder.searchParameters},
      expandForm: state._consumerOrder.expandForm,
      loading: state._consumerOrder.loading,
      partialList: state._consumerOrder.partialList,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id,
      referenceName: 'bizOrder',
      listName: 'consumerOrderShippingGroupList', ref:state._consumerOrder,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderShippingGroupSearch)
  }

  getConsumerOrderShippingGroupCreateForm = () => {
   	const {ConsumerOrderShippingGroupCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "consumerOrderShippingGroup",
      data: state._consumerOrder.consumerOrderShippingGroupList,
      metaInfo: state._consumerOrder.consumerOrderShippingGroupListMetaInfo,
      count: state._consumerOrder.consumerOrderShippingGroupCount,
      returnURL: `/consumerOrder/${state._consumerOrder.id}/list`,
      currentPage: state._consumerOrder.consumerOrderShippingGroupCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderShippingGroupSearchFormParameters,
      loading: state._consumerOrder.loading,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id || this.getOwnerId(), referenceName: 'bizOrder', listName: 'consumerOrderShippingGroupList', ref:state._consumerOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ConsumerOrderShippingGroupCreateForm)
  }

  getConsumerOrderShippingGroupUpdateForm = () => {
    const userContext = null
  	const {ConsumerOrderShippingGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._consumerOrder.selectedRows,
      role: "consumerOrderShippingGroup",
      currentUpdateIndex: state._consumerOrder.currentUpdateIndex || 0,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id || this.getOwnerId(), listName: 'consumerOrderShippingGroupList', ref:state._consumerOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderShippingGroupUpdateForm)
  }

  getConsumerOrderPaymentGroupSearch = () => {
    const {ConsumerOrderPaymentGroupSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('consumer_order_payment_group','consumer_order.consumer_order_payment_group_list',false),
      role: "consumerOrderPaymentGroup",
      data: state._consumerOrder.consumerOrderPaymentGroupList,
      metaInfo: state._consumerOrder.consumerOrderPaymentGroupListMetaInfo,
      count: state._consumerOrder.consumerOrderPaymentGroupCount,
      returnURL: `/consumerOrder/${state._consumerOrder.id}/workbench`,
      currentPage: state._consumerOrder.consumerOrderPaymentGroupCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderPaymentGroupSearchFormParameters,
      searchParameters: {...state._consumerOrder.searchParameters},
      expandForm: state._consumerOrder.expandForm,
      loading: state._consumerOrder.loading,
      partialList: state._consumerOrder.partialList,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id,
      referenceName: 'bizOrder',
      listName: 'consumerOrderPaymentGroupList', ref:state._consumerOrder,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderPaymentGroupSearch)
  }

  getConsumerOrderPaymentGroupCreateForm = () => {
   	const {ConsumerOrderPaymentGroupCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "consumerOrderPaymentGroup",
      data: state._consumerOrder.consumerOrderPaymentGroupList,
      metaInfo: state._consumerOrder.consumerOrderPaymentGroupListMetaInfo,
      count: state._consumerOrder.consumerOrderPaymentGroupCount,
      returnURL: `/consumerOrder/${state._consumerOrder.id}/list`,
      currentPage: state._consumerOrder.consumerOrderPaymentGroupCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderPaymentGroupSearchFormParameters,
      loading: state._consumerOrder.loading,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id || this.getOwnerId(), referenceName: 'bizOrder', listName: 'consumerOrderPaymentGroupList', ref:state._consumerOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ConsumerOrderPaymentGroupCreateForm)
  }

  getConsumerOrderPaymentGroupUpdateForm = () => {
    const userContext = null
  	const {ConsumerOrderPaymentGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._consumerOrder.selectedRows,
      role: "consumerOrderPaymentGroup",
      currentUpdateIndex: state._consumerOrder.currentUpdateIndex || 0,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id || this.getOwnerId(), listName: 'consumerOrderPaymentGroupList', ref:state._consumerOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderPaymentGroupUpdateForm)
  }

  getConsumerOrderPriceAdjustmentSearch = () => {
    const {ConsumerOrderPriceAdjustmentSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('consumer_order_price_adjustment','consumer_order.consumer_order_price_adjustment_list',false),
      role: "consumerOrderPriceAdjustment",
      data: state._consumerOrder.consumerOrderPriceAdjustmentList,
      metaInfo: state._consumerOrder.consumerOrderPriceAdjustmentListMetaInfo,
      count: state._consumerOrder.consumerOrderPriceAdjustmentCount,
      returnURL: `/consumerOrder/${state._consumerOrder.id}/workbench`,
      currentPage: state._consumerOrder.consumerOrderPriceAdjustmentCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderPriceAdjustmentSearchFormParameters,
      searchParameters: {...state._consumerOrder.searchParameters},
      expandForm: state._consumerOrder.expandForm,
      loading: state._consumerOrder.loading,
      partialList: state._consumerOrder.partialList,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id,
      referenceName: 'bizOrder',
      listName: 'consumerOrderPriceAdjustmentList', ref:state._consumerOrder,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderPriceAdjustmentSearch)
  }

  getConsumerOrderPriceAdjustmentCreateForm = () => {
   	const {ConsumerOrderPriceAdjustmentCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "consumerOrderPriceAdjustment",
      data: state._consumerOrder.consumerOrderPriceAdjustmentList,
      metaInfo: state._consumerOrder.consumerOrderPriceAdjustmentListMetaInfo,
      count: state._consumerOrder.consumerOrderPriceAdjustmentCount,
      returnURL: `/consumerOrder/${state._consumerOrder.id}/list`,
      currentPage: state._consumerOrder.consumerOrderPriceAdjustmentCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderPriceAdjustmentSearchFormParameters,
      loading: state._consumerOrder.loading,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id || this.getOwnerId(), referenceName: 'bizOrder', listName: 'consumerOrderPriceAdjustmentList', ref:state._consumerOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ConsumerOrderPriceAdjustmentCreateForm)
  }

  getConsumerOrderPriceAdjustmentUpdateForm = () => {
    const userContext = null
  	const {ConsumerOrderPriceAdjustmentUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._consumerOrder.selectedRows,
      role: "consumerOrderPriceAdjustment",
      currentUpdateIndex: state._consumerOrder.currentUpdateIndex || 0,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id || this.getOwnerId(), listName: 'consumerOrderPriceAdjustmentList', ref:state._consumerOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderPriceAdjustmentUpdateForm)
  }

  getRetailStoreMemberGiftCardConsumeRecordSearch = () => {
    const {RetailStoreMemberGiftCardConsumeRecordSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store_member_gift_card_consume_record','consumer_order.retail_store_member_gift_card_consume_record_list',false),
      role: "retailStoreMemberGiftCardConsumeRecord",
      data: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordList,
      metaInfo: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordListMetaInfo,
      count: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordCount,
      returnURL: `/consumerOrder/${state._consumerOrder.id}/workbench`,
      currentPage: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordCurrentPageNumber,
      searchFormParameters: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordSearchFormParameters,
      searchParameters: {...state._consumerOrder.searchParameters},
      expandForm: state._consumerOrder.expandForm,
      loading: state._consumerOrder.loading,
      partialList: state._consumerOrder.partialList,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id,
      referenceName: 'bizOrder',
      listName: 'retailStoreMemberGiftCardConsumeRecordList', ref:state._consumerOrder,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberGiftCardConsumeRecordSearch)
  }

  getRetailStoreMemberGiftCardConsumeRecordCreateForm = () => {
   	const {RetailStoreMemberGiftCardConsumeRecordCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "retailStoreMemberGiftCardConsumeRecord",
      data: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordList,
      metaInfo: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordListMetaInfo,
      count: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordCount,
      returnURL: `/consumerOrder/${state._consumerOrder.id}/list`,
      currentPage: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordCurrentPageNumber,
      searchFormParameters: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordSearchFormParameters,
      loading: state._consumerOrder.loading,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id || this.getOwnerId(), referenceName: 'bizOrder', listName: 'retailStoreMemberGiftCardConsumeRecordList', ref:state._consumerOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreMemberGiftCardConsumeRecordCreateForm)
  }

  getRetailStoreMemberGiftCardConsumeRecordUpdateForm = () => {
    const userContext = null
  	const {RetailStoreMemberGiftCardConsumeRecordUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._consumerOrder.selectedRows,
      role: "retailStoreMemberGiftCardConsumeRecord",
      currentUpdateIndex: state._consumerOrder.currentUpdateIndex || 0,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id || this.getOwnerId(), listName: 'retailStoreMemberGiftCardConsumeRecordList', ref:state._consumerOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberGiftCardConsumeRecordUpdateForm)
  }


  getRequestTypeStepForm = () => {
    const userContext = null
  	 const {ChangeRequestStepForm} = GlobalComponents
    return connect(state => ({
      selectedRows: state._consumerOrder.selectedRows,
      role: "cq",
      currentUpdateIndex: state._consumerOrder.currentUpdateIndex,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, listName: 'nolist', ref:state._consumerOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestStepForm)
  }



  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '双链小超全流程供应链系统'
    return title
  }

  buildRouters = () =>{
    const {ConsumerOrderWorkbench} = GlobalComponents

    const {ConsumerOrderDashboard} = GlobalComponents
  	const {ConsumerOrderPermission} = GlobalComponents
  	const {ConsumerOrderProfile} = GlobalComponents


    const routers=[
    {path:"/consumerOrder/:id/workbench", component: ConsumerOrderWorkbench},
    {path:"/consumerOrder/:id/dashboard", component: ConsumerOrderDashboard},
  	{path:"/consumerOrder/:id/profile", component: ConsumerOrderProfile},
  	{path:"/consumerOrder/:id/permission", component: ConsumerOrderPermission},



  	{path:"/consumerOrder/:id/list/consumerOrderLineItemList", component: this.getConsumerOrderLineItemSearch()},
  	{path:"/consumerOrder/:id/list/consumerOrderLineItemCreateForm", component: this.getConsumerOrderLineItemCreateForm()},
  	{path:"/consumerOrder/:id/list/consumerOrderLineItemUpdateForm", component: this.getConsumerOrderLineItemUpdateForm()},
 
  	{path:"/consumerOrder/:id/list/consumerOrderShippingGroupList", component: this.getConsumerOrderShippingGroupSearch()},
  	{path:"/consumerOrder/:id/list/consumerOrderShippingGroupCreateForm", component: this.getConsumerOrderShippingGroupCreateForm()},
  	{path:"/consumerOrder/:id/list/consumerOrderShippingGroupUpdateForm", component: this.getConsumerOrderShippingGroupUpdateForm()},
 
  	{path:"/consumerOrder/:id/list/consumerOrderPaymentGroupList", component: this.getConsumerOrderPaymentGroupSearch()},
  	{path:"/consumerOrder/:id/list/consumerOrderPaymentGroupCreateForm", component: this.getConsumerOrderPaymentGroupCreateForm()},
  	{path:"/consumerOrder/:id/list/consumerOrderPaymentGroupUpdateForm", component: this.getConsumerOrderPaymentGroupUpdateForm()},
 
  	{path:"/consumerOrder/:id/list/consumerOrderPriceAdjustmentList", component: this.getConsumerOrderPriceAdjustmentSearch()},
  	{path:"/consumerOrder/:id/list/consumerOrderPriceAdjustmentCreateForm", component: this.getConsumerOrderPriceAdjustmentCreateForm()},
  	{path:"/consumerOrder/:id/list/consumerOrderPriceAdjustmentUpdateForm", component: this.getConsumerOrderPriceAdjustmentUpdateForm()},
 
  	{path:"/consumerOrder/:id/list/retailStoreMemberGiftCardConsumeRecordList", component: this.getRetailStoreMemberGiftCardConsumeRecordSearch()},
  	{path:"/consumerOrder/:id/list/retailStoreMemberGiftCardConsumeRecordCreateForm", component: this.getRetailStoreMemberGiftCardConsumeRecordCreateForm()},
  	{path:"/consumerOrder/:id/list/retailStoreMemberGiftCardConsumeRecordUpdateForm", component: this.getRetailStoreMemberGiftCardConsumeRecordUpdateForm()},
 

  	]

  	const {extraRoutesFunc} = this.props;
  	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
  	const finalRoutes = routers.concat(extraRoutes)

  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}
  	  	</Switch>)


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

   toggleSwitchText=()=>{
    const { collapsed } = this.props
    if(collapsed){
      return "打开菜单"
    }
    return "关闭菜单"

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
     const breadcrumbBar=()=>{
      const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
      return ( <div mode="vertical">
      {currentBreadcrumb.map(item => renderBreadcrumbBarItem(item))}
      </div>)


     }


	const jumpToBreadcrumbLink=(breadcrumbMenuItem)=>{
      const { dispatch} = this.props
      const {name,link} = breadcrumbMenuItem
      dispatch({ type: 'breadcrumb/jumpToLink', payload: {name, link }} )

     }

	 const removeBreadcrumbLink=(breadcrumbMenuItem)=>{
      const { dispatch} = this.props
      const {link} = breadcrumbMenuItem
      dispatch({ type: 'breadcrumb/removeLink', payload: { link }} )

     }

     const renderBreadcrumbBarItem=(breadcrumbMenuItem)=>{

      return (
     <Tag
      	key={breadcrumbMenuItem.link} color={breadcrumbMenuItem.selected?"#108ee9":"grey"}
      	style={{marginRight:"1px",marginBottom:"1px"}} closable onClose={()=>removeBreadcrumbLink(breadcrumbMenuItem)} >
        <span onClick={()=>jumpToBreadcrumbLink(breadcrumbMenuItem)}>
        	{renderBreadcrumbText(breadcrumbMenuItem.name)}
        </span>
      </Tag>)

     }



     const { Search } = Input;
     const showSearchResult=()=>{

        this.setState({showSearch:true})

     }
     const searchChange=(evt)=>{

      this.setState({searchKeyword :evt.target.value})

    }
    const hideSearchResult=()=>{

      this.setState({showSearch:false})

    }

    const {searchLocalData}=GlobalComponents.ConsumerOrderBase

    const renderMenuSwitch=()=>{
      const  text = collapsed?"开启左侧菜单":"关闭左侧菜单"
      const icon = collapsed?"pic-left":"pic-center"

      return (

        <Tooltip placement="bottom" title={text}>


      <a  className={styles.menuLink} onClick={()=>this.toggle()} style={{marginLeft:"20px",minHeight:"20px"}}>
        <Icon type={icon} style={{marginRight:"10px"}}/>
      </a>  </Tooltip>)

     }


       const layout = (
     <Layout>
 		<Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>

        <Row type="flex" justify="start" align="bottom">

        <Col {...naviBarResponsiveStyle} >
          <a className={styles.menuLink}  style={{fontSize:"20px"}}>{currentAppName()}</a>

        </Col>
        <Col  className={styles.searchBox} {...searchBarResponsiveStyle}  >
         <Search size="default" placeholder="请输入搜索条件, 查找功能，数据和词汇解释，关闭请点击搜索结果空白处"
            enterButton onFocus={()=>showSearchResult()} onChange={(evt)=>searchChange(evt)}
            style={{ marginLeft:"10px",marginTop:"7px",width:"100%"}} />
          </Col>
          <Col  {...userBarResponsiveStyle}  >
          <Row>
          <Col  span={10}  > </Col>
          <Col  span={2}  >  {renderMenuSwitch()}</Col>
          <Col  span={6}  >
	          <Dropdown overlay={<SwitchAppMenu {...this.props} />} style={{marginRight:"100px"}} className={styles.right}>
                <a  className={styles.menuLink} >
                <Icon type="appstore" style={{marginRight:"5px"}}/>切换应用
                </a>
              </Dropdown>
          </Col>

          <Col  span={6}  >
            <Dropdown overlay= { <TopMenu {...this.props} />} className={styles.right}>
                <a  className={styles.menuLink}>
                <Icon type="user" style={{marginRight:"5px"}}/>账户
                </a>
            </Dropdown>
            </Col>

          </Row>
            </Col>
         </Row>
        </Header>
       <Layout style={{  marginTop: 44 }}>


       <Layout>

      {this.state.showSearch&&(

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.consumerOrder,this.state.searchKeyword)}</div>

      )}
       </Layout>


         <Layout>
       <Sider
          trigger={null}
          collapsible
          collapsed={collapsed}
          breakpoint="md"
          onCollapse={() => this.onCollapse(collapsed)}
          collapsedWidth={50}
          className={styles.sider}
        >

         {this.getNavMenuItems(this.props.consumerOrder,"inline","dark")}

        </Sider>

         <Layout>
         <Layout><Row type="flex" justify="start" align="bottom">{breadcrumbBar()} </Row></Layout>

           <Content style={{ margin: '24px 24px 0', height: '100%' }}>

           {this.buildRouters()}
           </Content>
          </Layout>
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
  consumerOrder: state._consumerOrder,
  ...state,
}))(ConsumerOrderBizApp)



