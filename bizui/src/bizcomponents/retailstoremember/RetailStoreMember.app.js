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
import styles from './RetailStoreMember.app.less'
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




class RetailStoreMemberBizApp extends React.PureComponent {
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
      return ['/retailStoreMember/']
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
               <Link to={`/retailStoreMember/${this.props.retailStoreMember.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
               		<Link to={`/retailStoreMember/${this.props.retailStoreMember.id}/permission`}><Icon type="safety-certificate" /><span>{appLocaleName(userContext,"Permission")}</span></Link>
             	</Menu.Item>
             	<Menu.Item key="permission">
               		<Link to={`/retailStoreMember/${this.props.retailStoreMember.id}/profile`}><Icon type="cluster" /><span>{appLocaleName(userContext,"Profile")}</span></Link>
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
      name: "消费者订单",
      role: "consumerOrder",
      data: state._retailStoreMember.consumerOrderList,
      metaInfo: state._retailStoreMember.consumerOrderListMetaInfo,
      count: state._retailStoreMember.consumerOrderCount,
      currentPage: state._retailStoreMember.consumerOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.consumerOrderSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'consumer', 
      listName: 'consumerOrderList', ref:state._retailStoreMember, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderSearch)
  }
  getConsumerOrderCreateForm = () => {
   	const {ConsumerOrderCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "consumerOrder",
      data: state._retailStoreMember.consumerOrderList,
      metaInfo: state._retailStoreMember.consumerOrderListMetaInfo,
      count: state._retailStoreMember.consumerOrderCount,
      currentPage: state._retailStoreMember.consumerOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.consumerOrderSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'consumer', listName: 'consumerOrderList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ConsumerOrderCreateForm)
  }
  
  getConsumerOrderUpdateForm = () => {
    const userContext = null
  	const {ConsumerOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "consumerOrder",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'consumerOrderList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderUpdateForm)
  }

  getRetailStoreMemberCouponSearch = () => {
    const {RetailStoreMemberCouponSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "生超会员优惠券",
      role: "retailStoreMemberCoupon",
      data: state._retailStoreMember.retailStoreMemberCouponList,
      metaInfo: state._retailStoreMember.retailStoreMemberCouponListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberCouponCount,
      currentPage: state._retailStoreMember.retailStoreMemberCouponCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberCouponSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'retailStoreMemberCouponList', ref:state._retailStoreMember, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberCouponSearch)
  }
  getRetailStoreMemberCouponCreateForm = () => {
   	const {RetailStoreMemberCouponCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreMemberCoupon",
      data: state._retailStoreMember.retailStoreMemberCouponList,
      metaInfo: state._retailStoreMember.retailStoreMemberCouponListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberCouponCount,
      currentPage: state._retailStoreMember.retailStoreMemberCouponCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberCouponSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'retailStoreMemberCouponList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreMemberCouponCreateForm)
  }
  
  getRetailStoreMemberCouponUpdateForm = () => {
    const userContext = null
  	const {RetailStoreMemberCouponUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "retailStoreMemberCoupon",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'retailStoreMemberCouponList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberCouponUpdateForm)
  }

  getMemberWishlistSearch = () => {
    const {MemberWishlistSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "会员收藏",
      role: "memberWishlist",
      data: state._retailStoreMember.memberWishlistList,
      metaInfo: state._retailStoreMember.memberWishlistListMetaInfo,
      count: state._retailStoreMember.memberWishlistCount,
      currentPage: state._retailStoreMember.memberWishlistCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberWishlistSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'memberWishlistList', ref:state._retailStoreMember, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(MemberWishlistSearch)
  }
  getMemberWishlistCreateForm = () => {
   	const {MemberWishlistCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "memberWishlist",
      data: state._retailStoreMember.memberWishlistList,
      metaInfo: state._retailStoreMember.memberWishlistListMetaInfo,
      count: state._retailStoreMember.memberWishlistCount,
      currentPage: state._retailStoreMember.memberWishlistCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberWishlistSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'memberWishlistList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(MemberWishlistCreateForm)
  }
  
  getMemberWishlistUpdateForm = () => {
    const userContext = null
  	const {MemberWishlistUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "memberWishlist",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'memberWishlistList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(MemberWishlistUpdateForm)
  }

  getMemberRewardPointSearch = () => {
    const {MemberRewardPointSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "会员奖励点",
      role: "memberRewardPoint",
      data: state._retailStoreMember.memberRewardPointList,
      metaInfo: state._retailStoreMember.memberRewardPointListMetaInfo,
      count: state._retailStoreMember.memberRewardPointCount,
      currentPage: state._retailStoreMember.memberRewardPointCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'memberRewardPointList', ref:state._retailStoreMember, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(MemberRewardPointSearch)
  }
  getMemberRewardPointCreateForm = () => {
   	const {MemberRewardPointCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "memberRewardPoint",
      data: state._retailStoreMember.memberRewardPointList,
      metaInfo: state._retailStoreMember.memberRewardPointListMetaInfo,
      count: state._retailStoreMember.memberRewardPointCount,
      currentPage: state._retailStoreMember.memberRewardPointCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'memberRewardPointList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(MemberRewardPointCreateForm)
  }
  
  getMemberRewardPointUpdateForm = () => {
    const userContext = null
  	const {MemberRewardPointUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "memberRewardPoint",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'memberRewardPointList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(MemberRewardPointUpdateForm)
  }

  getMemberRewardPointRedemptionSearch = () => {
    const {MemberRewardPointRedemptionSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "会员奖励点赎回",
      role: "memberRewardPointRedemption",
      data: state._retailStoreMember.memberRewardPointRedemptionList,
      metaInfo: state._retailStoreMember.memberRewardPointRedemptionListMetaInfo,
      count: state._retailStoreMember.memberRewardPointRedemptionCount,
      currentPage: state._retailStoreMember.memberRewardPointRedemptionCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointRedemptionSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'memberRewardPointRedemptionList', ref:state._retailStoreMember, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(MemberRewardPointRedemptionSearch)
  }
  getMemberRewardPointRedemptionCreateForm = () => {
   	const {MemberRewardPointRedemptionCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "memberRewardPointRedemption",
      data: state._retailStoreMember.memberRewardPointRedemptionList,
      metaInfo: state._retailStoreMember.memberRewardPointRedemptionListMetaInfo,
      count: state._retailStoreMember.memberRewardPointRedemptionCount,
      currentPage: state._retailStoreMember.memberRewardPointRedemptionCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointRedemptionSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'memberRewardPointRedemptionList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(MemberRewardPointRedemptionCreateForm)
  }
  
  getMemberRewardPointRedemptionUpdateForm = () => {
    const userContext = null
  	const {MemberRewardPointRedemptionUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "memberRewardPointRedemption",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'memberRewardPointRedemptionList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(MemberRewardPointRedemptionUpdateForm)
  }

  getRetailStoreMemberAddressSearch = () => {
    const {RetailStoreMemberAddressSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "零售店会员地址",
      role: "retailStoreMemberAddress",
      data: state._retailStoreMember.retailStoreMemberAddressList,
      metaInfo: state._retailStoreMember.retailStoreMemberAddressListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberAddressCount,
      currentPage: state._retailStoreMember.retailStoreMemberAddressCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberAddressSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'retailStoreMemberAddressList', ref:state._retailStoreMember, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberAddressSearch)
  }
  getRetailStoreMemberAddressCreateForm = () => {
   	const {RetailStoreMemberAddressCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreMemberAddress",
      data: state._retailStoreMember.retailStoreMemberAddressList,
      metaInfo: state._retailStoreMember.retailStoreMemberAddressListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberAddressCount,
      currentPage: state._retailStoreMember.retailStoreMemberAddressCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberAddressSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'retailStoreMemberAddressList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreMemberAddressCreateForm)
  }
  
  getRetailStoreMemberAddressUpdateForm = () => {
    const userContext = null
  	const {RetailStoreMemberAddressUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "retailStoreMemberAddress",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'retailStoreMemberAddressList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberAddressUpdateForm)
  }

  getRetailStoreMemberGiftCardSearch = () => {
    const {RetailStoreMemberGiftCardSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "零售店会员礼品卡",
      role: "retailStoreMemberGiftCard",
      data: state._retailStoreMember.retailStoreMemberGiftCardList,
      metaInfo: state._retailStoreMember.retailStoreMemberGiftCardListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberGiftCardCount,
      currentPage: state._retailStoreMember.retailStoreMemberGiftCardCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberGiftCardSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'retailStoreMemberGiftCardList', ref:state._retailStoreMember, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberGiftCardSearch)
  }
  getRetailStoreMemberGiftCardCreateForm = () => {
   	const {RetailStoreMemberGiftCardCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreMemberGiftCard",
      data: state._retailStoreMember.retailStoreMemberGiftCardList,
      metaInfo: state._retailStoreMember.retailStoreMemberGiftCardListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberGiftCardCount,
      currentPage: state._retailStoreMember.retailStoreMemberGiftCardCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberGiftCardSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'retailStoreMemberGiftCardList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreMemberGiftCardCreateForm)
  }
  
  getRetailStoreMemberGiftCardUpdateForm = () => {
    const userContext = null
  	const {RetailStoreMemberGiftCardUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "retailStoreMemberGiftCard",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'retailStoreMemberGiftCardList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberGiftCardUpdateForm)
  }


  
  buildRouters = () =>{
  	const {RetailStoreMemberDashboard} = GlobalComponents
  	const {RetailStoreMemberPermission} = GlobalComponents
  	const {RetailStoreMemberProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/retailStoreMember/:id/dashboard", component: RetailStoreMemberDashboard},
  	{path:"/retailStoreMember/:id/profile", component: RetailStoreMemberProfile},
  	{path:"/retailStoreMember/:id/permission", component: RetailStoreMemberPermission},
  	
  	
  	
  	{path:"/retailStoreMember/:id/list/consumerOrderList", component: this.getConsumerOrderSearch()},
  	{path:"/retailStoreMember/:id/list/consumerOrderCreateForm", component: this.getConsumerOrderCreateForm()},
  	{path:"/retailStoreMember/:id/list/consumerOrderUpdateForm", component: this.getConsumerOrderUpdateForm()},
   	
  	{path:"/retailStoreMember/:id/list/retailStoreMemberCouponList", component: this.getRetailStoreMemberCouponSearch()},
  	{path:"/retailStoreMember/:id/list/retailStoreMemberCouponCreateForm", component: this.getRetailStoreMemberCouponCreateForm()},
  	{path:"/retailStoreMember/:id/list/retailStoreMemberCouponUpdateForm", component: this.getRetailStoreMemberCouponUpdateForm()},
   	
  	{path:"/retailStoreMember/:id/list/memberWishlistList", component: this.getMemberWishlistSearch()},
  	{path:"/retailStoreMember/:id/list/memberWishlistCreateForm", component: this.getMemberWishlistCreateForm()},
  	{path:"/retailStoreMember/:id/list/memberWishlistUpdateForm", component: this.getMemberWishlistUpdateForm()},
   	
  	{path:"/retailStoreMember/:id/list/memberRewardPointList", component: this.getMemberRewardPointSearch()},
  	{path:"/retailStoreMember/:id/list/memberRewardPointCreateForm", component: this.getMemberRewardPointCreateForm()},
  	{path:"/retailStoreMember/:id/list/memberRewardPointUpdateForm", component: this.getMemberRewardPointUpdateForm()},
   	
  	{path:"/retailStoreMember/:id/list/memberRewardPointRedemptionList", component: this.getMemberRewardPointRedemptionSearch()},
  	{path:"/retailStoreMember/:id/list/memberRewardPointRedemptionCreateForm", component: this.getMemberRewardPointRedemptionCreateForm()},
  	{path:"/retailStoreMember/:id/list/memberRewardPointRedemptionUpdateForm", component: this.getMemberRewardPointRedemptionUpdateForm()},
   	
  	{path:"/retailStoreMember/:id/list/retailStoreMemberAddressList", component: this.getRetailStoreMemberAddressSearch()},
  	{path:"/retailStoreMember/:id/list/retailStoreMemberAddressCreateForm", component: this.getRetailStoreMemberAddressCreateForm()},
  	{path:"/retailStoreMember/:id/list/retailStoreMemberAddressUpdateForm", component: this.getRetailStoreMemberAddressUpdateForm()},
   	
  	{path:"/retailStoreMember/:id/list/retailStoreMemberGiftCardList", component: this.getRetailStoreMemberGiftCardSearch()},
  	{path:"/retailStoreMember/:id/list/retailStoreMemberGiftCardCreateForm", component: this.getRetailStoreMemberGiftCardCreateForm()},
  	{path:"/retailStoreMember/:id/list/retailStoreMemberGiftCardUpdateForm", component: this.getRetailStoreMemberGiftCardUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.retailStoreMember)}
		 
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
  retailStoreMember: state._retailStoreMember,
  ...state,
}))(RetailStoreMemberBizApp)



