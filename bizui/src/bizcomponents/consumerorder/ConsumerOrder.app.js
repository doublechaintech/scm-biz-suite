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
import styles from './ConsumerOrder.app.less'
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




class ConsumerOrderBizApp extends React.PureComponent {
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
               <Link to={`/consumerOrder/${this.props.consumerOrder.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
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
               <Link to={`/consumerOrder/${this.props.consumerOrder.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getConsumerOrderLineItemSearch = () => {
    const {ConsumerOrderLineItemSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "消费者订单行项目",
      role: "consumerOrderLineItem",
      data: state._consumerOrder.consumerOrderLineItemList,
      metaInfo: state._consumerOrder.consumerOrderLineItemListMetaInfo,
      count: state._consumerOrder.consumerOrderLineItemCount,
      currentPage: state._consumerOrder.consumerOrderLineItemCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderLineItemSearchFormParameters,
      searchParameters: {...state._consumerOrder.searchParameters},
      expandForm: state._consumerOrder.expandForm,
      loading: state._consumerOrder.loading,
      partialList: state._consumerOrder.partialList,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'consumerOrderLineItemList', ref:state._consumerOrder, 
      listDisplayName: '消费者订单行项目列表' }, // this is for model namespace and
    }))(ConsumerOrderLineItemSearch)
  }
  getConsumerOrderLineItemCreateForm = () => {
   	const {ConsumerOrderLineItemCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "consumerOrderLineItem",
      data: state._consumerOrder.consumerOrderLineItemList,
      metaInfo: state._consumerOrder.consumerOrderLineItemListMetaInfo,
      count: state._consumerOrder.consumerOrderLineItemCount,
      currentPage: state._consumerOrder.consumerOrderLineItemCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderLineItemSearchFormParameters,
      loading: state._consumerOrder.loading,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, referenceName: 'bizOrder', listName: 'consumerOrderLineItemList', ref:state._consumerOrder, listDisplayName: '消费者订单行项目列表'}, // this is for model namespace and
    }))(ConsumerOrderLineItemCreateForm)
  }
  
  getConsumerOrderLineItemUpdateForm = () => {
  	const {ConsumerOrderLineItemUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._consumerOrder.selectedRows,
      role: "consumerOrderLineItem",
      currentUpdateIndex: state._consumerOrder.currentUpdateIndex,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, listName: 'consumerOrderLineItemList', ref:state._consumerOrder, listDisplayName: '消费者订单行项目列表' }, // this is for model namespace and
    }))(ConsumerOrderLineItemUpdateForm)
  }

  getConsumerOrderShippingGroupSearch = () => {
    const {ConsumerOrderShippingGroupSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "消费订单送货分组",
      role: "consumerOrderShippingGroup",
      data: state._consumerOrder.consumerOrderShippingGroupList,
      metaInfo: state._consumerOrder.consumerOrderShippingGroupListMetaInfo,
      count: state._consumerOrder.consumerOrderShippingGroupCount,
      currentPage: state._consumerOrder.consumerOrderShippingGroupCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderShippingGroupSearchFormParameters,
      searchParameters: {...state._consumerOrder.searchParameters},
      expandForm: state._consumerOrder.expandForm,
      loading: state._consumerOrder.loading,
      partialList: state._consumerOrder.partialList,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'consumerOrderShippingGroupList', ref:state._consumerOrder, 
      listDisplayName: '消费订单送货分组列表' }, // this is for model namespace and
    }))(ConsumerOrderShippingGroupSearch)
  }
  getConsumerOrderShippingGroupCreateForm = () => {
   	const {ConsumerOrderShippingGroupCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "consumerOrderShippingGroup",
      data: state._consumerOrder.consumerOrderShippingGroupList,
      metaInfo: state._consumerOrder.consumerOrderShippingGroupListMetaInfo,
      count: state._consumerOrder.consumerOrderShippingGroupCount,
      currentPage: state._consumerOrder.consumerOrderShippingGroupCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderShippingGroupSearchFormParameters,
      loading: state._consumerOrder.loading,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, referenceName: 'bizOrder', listName: 'consumerOrderShippingGroupList', ref:state._consumerOrder, listDisplayName: '消费订单送货分组列表'}, // this is for model namespace and
    }))(ConsumerOrderShippingGroupCreateForm)
  }
  
  getConsumerOrderShippingGroupUpdateForm = () => {
  	const {ConsumerOrderShippingGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._consumerOrder.selectedRows,
      role: "consumerOrderShippingGroup",
      currentUpdateIndex: state._consumerOrder.currentUpdateIndex,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, listName: 'consumerOrderShippingGroupList', ref:state._consumerOrder, listDisplayName: '消费订单送货分组列表' }, // this is for model namespace and
    }))(ConsumerOrderShippingGroupUpdateForm)
  }

  getConsumerOrderPaymentGroupSearch = () => {
    const {ConsumerOrderPaymentGroupSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "消费者订单付款组",
      role: "consumerOrderPaymentGroup",
      data: state._consumerOrder.consumerOrderPaymentGroupList,
      metaInfo: state._consumerOrder.consumerOrderPaymentGroupListMetaInfo,
      count: state._consumerOrder.consumerOrderPaymentGroupCount,
      currentPage: state._consumerOrder.consumerOrderPaymentGroupCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderPaymentGroupSearchFormParameters,
      searchParameters: {...state._consumerOrder.searchParameters},
      expandForm: state._consumerOrder.expandForm,
      loading: state._consumerOrder.loading,
      partialList: state._consumerOrder.partialList,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'consumerOrderPaymentGroupList', ref:state._consumerOrder, 
      listDisplayName: '消费者订单付款组列表' }, // this is for model namespace and
    }))(ConsumerOrderPaymentGroupSearch)
  }
  getConsumerOrderPaymentGroupCreateForm = () => {
   	const {ConsumerOrderPaymentGroupCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "consumerOrderPaymentGroup",
      data: state._consumerOrder.consumerOrderPaymentGroupList,
      metaInfo: state._consumerOrder.consumerOrderPaymentGroupListMetaInfo,
      count: state._consumerOrder.consumerOrderPaymentGroupCount,
      currentPage: state._consumerOrder.consumerOrderPaymentGroupCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderPaymentGroupSearchFormParameters,
      loading: state._consumerOrder.loading,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, referenceName: 'bizOrder', listName: 'consumerOrderPaymentGroupList', ref:state._consumerOrder, listDisplayName: '消费者订单付款组列表'}, // this is for model namespace and
    }))(ConsumerOrderPaymentGroupCreateForm)
  }
  
  getConsumerOrderPaymentGroupUpdateForm = () => {
  	const {ConsumerOrderPaymentGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._consumerOrder.selectedRows,
      role: "consumerOrderPaymentGroup",
      currentUpdateIndex: state._consumerOrder.currentUpdateIndex,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, listName: 'consumerOrderPaymentGroupList', ref:state._consumerOrder, listDisplayName: '消费者订单付款组列表' }, // this is for model namespace and
    }))(ConsumerOrderPaymentGroupUpdateForm)
  }

  getConsumerOrderPriceAdjustmentSearch = () => {
    const {ConsumerOrderPriceAdjustmentSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "消费品价格调整",
      role: "consumerOrderPriceAdjustment",
      data: state._consumerOrder.consumerOrderPriceAdjustmentList,
      metaInfo: state._consumerOrder.consumerOrderPriceAdjustmentListMetaInfo,
      count: state._consumerOrder.consumerOrderPriceAdjustmentCount,
      currentPage: state._consumerOrder.consumerOrderPriceAdjustmentCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderPriceAdjustmentSearchFormParameters,
      searchParameters: {...state._consumerOrder.searchParameters},
      expandForm: state._consumerOrder.expandForm,
      loading: state._consumerOrder.loading,
      partialList: state._consumerOrder.partialList,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'consumerOrderPriceAdjustmentList', ref:state._consumerOrder, 
      listDisplayName: '消费品价格调整列表' }, // this is for model namespace and
    }))(ConsumerOrderPriceAdjustmentSearch)
  }
  getConsumerOrderPriceAdjustmentCreateForm = () => {
   	const {ConsumerOrderPriceAdjustmentCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "consumerOrderPriceAdjustment",
      data: state._consumerOrder.consumerOrderPriceAdjustmentList,
      metaInfo: state._consumerOrder.consumerOrderPriceAdjustmentListMetaInfo,
      count: state._consumerOrder.consumerOrderPriceAdjustmentCount,
      currentPage: state._consumerOrder.consumerOrderPriceAdjustmentCurrentPageNumber,
      searchFormParameters: state._consumerOrder.consumerOrderPriceAdjustmentSearchFormParameters,
      loading: state._consumerOrder.loading,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, referenceName: 'bizOrder', listName: 'consumerOrderPriceAdjustmentList', ref:state._consumerOrder, listDisplayName: '消费品价格调整列表'}, // this is for model namespace and
    }))(ConsumerOrderPriceAdjustmentCreateForm)
  }
  
  getConsumerOrderPriceAdjustmentUpdateForm = () => {
  	const {ConsumerOrderPriceAdjustmentUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._consumerOrder.selectedRows,
      role: "consumerOrderPriceAdjustment",
      currentUpdateIndex: state._consumerOrder.currentUpdateIndex,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, listName: 'consumerOrderPriceAdjustmentList', ref:state._consumerOrder, listDisplayName: '消费品价格调整列表' }, // this is for model namespace and
    }))(ConsumerOrderPriceAdjustmentUpdateForm)
  }

  getRetailStoreMemberGiftCardConsumeRecordSearch = () => {
    const {RetailStoreMemberGiftCardConsumeRecordSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "零售商店会员卡消费记录",
      role: "retailStoreMemberGiftCardConsumeRecord",
      data: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordList,
      metaInfo: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordListMetaInfo,
      count: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordCount,
      currentPage: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordCurrentPageNumber,
      searchFormParameters: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordSearchFormParameters,
      searchParameters: {...state._consumerOrder.searchParameters},
      expandForm: state._consumerOrder.expandForm,
      loading: state._consumerOrder.loading,
      partialList: state._consumerOrder.partialList,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, 
      referenceName: 'bizOrder', 
      listName: 'retailStoreMemberGiftCardConsumeRecordList', ref:state._consumerOrder, 
      listDisplayName: '零售商店会员卡消费记录列表' }, // this is for model namespace and
    }))(RetailStoreMemberGiftCardConsumeRecordSearch)
  }
  getRetailStoreMemberGiftCardConsumeRecordCreateForm = () => {
   	const {RetailStoreMemberGiftCardConsumeRecordCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreMemberGiftCardConsumeRecord",
      data: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordList,
      metaInfo: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordListMetaInfo,
      count: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordCount,
      currentPage: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordCurrentPageNumber,
      searchFormParameters: state._consumerOrder.retailStoreMemberGiftCardConsumeRecordSearchFormParameters,
      loading: state._consumerOrder.loading,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, referenceName: 'bizOrder', listName: 'retailStoreMemberGiftCardConsumeRecordList', ref:state._consumerOrder, listDisplayName: '零售商店会员卡消费记录列表'}, // this is for model namespace and
    }))(RetailStoreMemberGiftCardConsumeRecordCreateForm)
  }
  
  getRetailStoreMemberGiftCardConsumeRecordUpdateForm = () => {
  	const {RetailStoreMemberGiftCardConsumeRecordUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._consumerOrder.selectedRows,
      role: "retailStoreMemberGiftCardConsumeRecord",
      currentUpdateIndex: state._consumerOrder.currentUpdateIndex,
      owner: { type: '_consumerOrder', id: state._consumerOrder.id, listName: 'retailStoreMemberGiftCardConsumeRecordList', ref:state._consumerOrder, listDisplayName: '零售商店会员卡消费记录列表' }, // this is for model namespace and
    }))(RetailStoreMemberGiftCardConsumeRecordUpdateForm)
  }


  
  buildRouters = () =>{
  	const {ConsumerOrderDashboard} = GlobalComponents
  	const {ConsumerOrderPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/consumerOrder/:id/dashboard", component: ConsumerOrderDashboard},
  	{path:"/consumerOrder/:id/preference", component: ConsumerOrderPreference},
  	
  	
  	
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

     //const {ConsumerOrderEditDetail} = GlobalComponents
     //const {ConsumerOrderViewDetail} = GlobalComponents
     
     
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

		 {this.getNavMenuItems(this.props.consumerOrder)}
		 
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
  consumerOrder: state._consumerOrder,
  ...state,
}))(ConsumerOrderBizApp)



