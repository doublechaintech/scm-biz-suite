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
import styles from './SupplyOrder.app.less'
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




class SupplyOrderBizApp extends React.PureComponent {
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
      return ['/supplyOrder/']
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
               <Link to={`/supplyOrder/${this.props.supplyOrder.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/supplyOrder/${this.props.supplyOrder.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getSupplyOrderLineItemSearch = () => {
    const {SupplyOrderLineItemSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "供应订单行项目",
      role: "supplyOrderLineItem",
      data: state._supplyOrder.supplyOrderLineItemList,
      metaInfo: state._supplyOrder.supplyOrderLineItemListMetaInfo,
      count: state._supplyOrder.supplyOrderLineItemCount,
      currentPage: state._supplyOrder.supplyOrderLineItemCurrentPageNumber,
      searchFormParameters: state._supplyOrder.supplyOrderLineItemSearchFormParameters,
      searchParameters: {...state._supplyOrder.searchParameters},
      expandForm: state._supplyOrder.expandForm,
      loading: state._supplyOrder.loading,
      partialList: state._supplyOrder.partialList,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'supplyOrderLineItemList', ref:state._supplyOrder, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderLineItemSearch)
  }
  getSupplyOrderLineItemCreateForm = () => {
   	const {SupplyOrderLineItemCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "supplyOrderLineItem",
      data: state._supplyOrder.supplyOrderLineItemList,
      metaInfo: state._supplyOrder.supplyOrderLineItemListMetaInfo,
      count: state._supplyOrder.supplyOrderLineItemCount,
      currentPage: state._supplyOrder.supplyOrderLineItemCurrentPageNumber,
      searchFormParameters: state._supplyOrder.supplyOrderLineItemSearchFormParameters,
      loading: state._supplyOrder.loading,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, referenceName: 'bizOrder', listName: 'supplyOrderLineItemList', ref:state._supplyOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SupplyOrderLineItemCreateForm)
  }
  
  getSupplyOrderLineItemUpdateForm = () => {
    const userContext = null
  	const {SupplyOrderLineItemUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._supplyOrder.selectedRows,
      role: "supplyOrderLineItem",
      currentUpdateIndex: state._supplyOrder.currentUpdateIndex,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, listName: 'supplyOrderLineItemList', ref:state._supplyOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderLineItemUpdateForm)
  }

  getSupplyOrderShippingGroupSearch = () => {
    const {SupplyOrderShippingGroupSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "供应订单送货分组",
      role: "supplyOrderShippingGroup",
      data: state._supplyOrder.supplyOrderShippingGroupList,
      metaInfo: state._supplyOrder.supplyOrderShippingGroupListMetaInfo,
      count: state._supplyOrder.supplyOrderShippingGroupCount,
      currentPage: state._supplyOrder.supplyOrderShippingGroupCurrentPageNumber,
      searchFormParameters: state._supplyOrder.supplyOrderShippingGroupSearchFormParameters,
      searchParameters: {...state._supplyOrder.searchParameters},
      expandForm: state._supplyOrder.expandForm,
      loading: state._supplyOrder.loading,
      partialList: state._supplyOrder.partialList,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'supplyOrderShippingGroupList', ref:state._supplyOrder, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderShippingGroupSearch)
  }
  getSupplyOrderShippingGroupCreateForm = () => {
   	const {SupplyOrderShippingGroupCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "supplyOrderShippingGroup",
      data: state._supplyOrder.supplyOrderShippingGroupList,
      metaInfo: state._supplyOrder.supplyOrderShippingGroupListMetaInfo,
      count: state._supplyOrder.supplyOrderShippingGroupCount,
      currentPage: state._supplyOrder.supplyOrderShippingGroupCurrentPageNumber,
      searchFormParameters: state._supplyOrder.supplyOrderShippingGroupSearchFormParameters,
      loading: state._supplyOrder.loading,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, referenceName: 'bizOrder', listName: 'supplyOrderShippingGroupList', ref:state._supplyOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SupplyOrderShippingGroupCreateForm)
  }
  
  getSupplyOrderShippingGroupUpdateForm = () => {
    const userContext = null
  	const {SupplyOrderShippingGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._supplyOrder.selectedRows,
      role: "supplyOrderShippingGroup",
      currentUpdateIndex: state._supplyOrder.currentUpdateIndex,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, listName: 'supplyOrderShippingGroupList', ref:state._supplyOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderShippingGroupUpdateForm)
  }

  getSupplyOrderPaymentGroupSearch = () => {
    const {SupplyOrderPaymentGroupSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "供应订单付款组",
      role: "supplyOrderPaymentGroup",
      data: state._supplyOrder.supplyOrderPaymentGroupList,
      metaInfo: state._supplyOrder.supplyOrderPaymentGroupListMetaInfo,
      count: state._supplyOrder.supplyOrderPaymentGroupCount,
      currentPage: state._supplyOrder.supplyOrderPaymentGroupCurrentPageNumber,
      searchFormParameters: state._supplyOrder.supplyOrderPaymentGroupSearchFormParameters,
      searchParameters: {...state._supplyOrder.searchParameters},
      expandForm: state._supplyOrder.expandForm,
      loading: state._supplyOrder.loading,
      partialList: state._supplyOrder.partialList,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'supplyOrderPaymentGroupList', ref:state._supplyOrder, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderPaymentGroupSearch)
  }
  getSupplyOrderPaymentGroupCreateForm = () => {
   	const {SupplyOrderPaymentGroupCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "supplyOrderPaymentGroup",
      data: state._supplyOrder.supplyOrderPaymentGroupList,
      metaInfo: state._supplyOrder.supplyOrderPaymentGroupListMetaInfo,
      count: state._supplyOrder.supplyOrderPaymentGroupCount,
      currentPage: state._supplyOrder.supplyOrderPaymentGroupCurrentPageNumber,
      searchFormParameters: state._supplyOrder.supplyOrderPaymentGroupSearchFormParameters,
      loading: state._supplyOrder.loading,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, referenceName: 'bizOrder', listName: 'supplyOrderPaymentGroupList', ref:state._supplyOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SupplyOrderPaymentGroupCreateForm)
  }
  
  getSupplyOrderPaymentGroupUpdateForm = () => {
    const userContext = null
  	const {SupplyOrderPaymentGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._supplyOrder.selectedRows,
      role: "supplyOrderPaymentGroup",
      currentUpdateIndex: state._supplyOrder.currentUpdateIndex,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, listName: 'supplyOrderPaymentGroupList', ref:state._supplyOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderPaymentGroupUpdateForm)
  }

  getGoodsSearch = () => {
    const {GoodsSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "货物",
      role: "goods",
      data: state._supplyOrder.goodsList,
      metaInfo: state._supplyOrder.goodsListMetaInfo,
      count: state._supplyOrder.goodsCount,
      currentPage: state._supplyOrder.goodsCurrentPageNumber,
      searchFormParameters: state._supplyOrder.goodsSearchFormParameters,
      searchParameters: {...state._supplyOrder.searchParameters},
      expandForm: state._supplyOrder.expandForm,
      loading: state._supplyOrder.loading,
      partialList: state._supplyOrder.partialList,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'goodsList', ref:state._supplyOrder, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsSearch)
  }
  getGoodsCreateForm = () => {
   	const {GoodsCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "goods",
      data: state._supplyOrder.goodsList,
      metaInfo: state._supplyOrder.goodsListMetaInfo,
      count: state._supplyOrder.goodsCount,
      currentPage: state._supplyOrder.goodsCurrentPageNumber,
      searchFormParameters: state._supplyOrder.goodsSearchFormParameters,
      loading: state._supplyOrder.loading,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, referenceName: 'bizOrder', listName: 'goodsList', ref:state._supplyOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(GoodsCreateForm)
  }
  
  getGoodsUpdateForm = () => {
    const userContext = null
  	const {GoodsUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._supplyOrder.selectedRows,
      role: "goods",
      currentUpdateIndex: state._supplyOrder.currentUpdateIndex,
      owner: { type: '_supplyOrder', id: state._supplyOrder.id, listName: 'goodsList', ref:state._supplyOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsUpdateForm)
  }


  
  buildRouters = () =>{
  	const {SupplyOrderDashboard} = GlobalComponents
  	const {SupplyOrderPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/supplyOrder/:id/dashboard", component: SupplyOrderDashboard},
  	{path:"/supplyOrder/:id/preference", component: SupplyOrderPreference},
  	
  	
  	
  	{path:"/supplyOrder/:id/list/supplyOrderLineItemList", component: this.getSupplyOrderLineItemSearch()},
  	{path:"/supplyOrder/:id/list/supplyOrderLineItemCreateForm", component: this.getSupplyOrderLineItemCreateForm()},
  	{path:"/supplyOrder/:id/list/supplyOrderLineItemUpdateForm", component: this.getSupplyOrderLineItemUpdateForm()},
   	
  	{path:"/supplyOrder/:id/list/supplyOrderShippingGroupList", component: this.getSupplyOrderShippingGroupSearch()},
  	{path:"/supplyOrder/:id/list/supplyOrderShippingGroupCreateForm", component: this.getSupplyOrderShippingGroupCreateForm()},
  	{path:"/supplyOrder/:id/list/supplyOrderShippingGroupUpdateForm", component: this.getSupplyOrderShippingGroupUpdateForm()},
   	
  	{path:"/supplyOrder/:id/list/supplyOrderPaymentGroupList", component: this.getSupplyOrderPaymentGroupSearch()},
  	{path:"/supplyOrder/:id/list/supplyOrderPaymentGroupCreateForm", component: this.getSupplyOrderPaymentGroupCreateForm()},
  	{path:"/supplyOrder/:id/list/supplyOrderPaymentGroupUpdateForm", component: this.getSupplyOrderPaymentGroupUpdateForm()},
   	
  	{path:"/supplyOrder/:id/list/goodsList", component: this.getGoodsSearch()},
  	{path:"/supplyOrder/:id/list/goodsCreateForm", component: this.getGoodsCreateForm()},
  	{path:"/supplyOrder/:id/list/goodsUpdateForm", component: this.getGoodsUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.supplyOrder)}
		 
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
  supplyOrder: state._supplyOrder,
  ...state,
}))(SupplyOrderBizApp)



