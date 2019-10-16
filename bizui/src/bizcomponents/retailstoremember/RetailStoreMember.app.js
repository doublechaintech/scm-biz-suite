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
import styles from './RetailStoreMember.app.less'
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




class RetailStoreMemberBizApp extends React.PureComponent {
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
               <Link to={`/retailStoreMember/${this.props.retailStoreMember.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
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
               <Link to={`/retailStoreMember/${this.props.retailStoreMember.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
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
               <Link to={`/retailStoreMember/${this.props.retailStoreMember.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getConsumerOrderSearch = () => {
    const {ConsumerOrderSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "消费者订单",
      role: "consumerOrder",
      data: state._retailStoreMember.consumerOrderList,
      metaInfo: state._retailStoreMember.consumerOrderListMetaInfo,
      count: state._retailStoreMember.consumerOrderCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreMember.consumerOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.consumerOrderSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'consumer', 
      listName: 'consumerOrderList', ref:state._retailStoreMember, 
<<<<<<< HEAD
      listDisplayName: '消费者订单列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ConsumerOrderSearch)
  }
  getConsumerOrderCreateForm = () => {
   	const {ConsumerOrderCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "consumerOrder",
      data: state._retailStoreMember.consumerOrderList,
      metaInfo: state._retailStoreMember.consumerOrderListMetaInfo,
      count: state._retailStoreMember.consumerOrderCount,
<<<<<<< HEAD
      currentPage: state._retailStoreMember.consumerOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.consumerOrderSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'consumer', listName: 'consumerOrderList', ref:state._retailStoreMember, listDisplayName: '消费者订单列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.consumerOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.consumerOrderSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'consumer', listName: 'consumerOrderList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ConsumerOrderCreateForm)
  }
  
  getConsumerOrderUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {ConsumerOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "consumerOrder",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'consumerOrderList', ref:state._retailStoreMember, listDisplayName: '消费者订单列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'consumerOrderList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ConsumerOrderUpdateForm)
  }

  getRetailStoreMemberCouponSearch = () => {
    const {RetailStoreMemberCouponSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "生超会员优惠券",
      role: "retailStoreMemberCoupon",
      data: state._retailStoreMember.retailStoreMemberCouponList,
      metaInfo: state._retailStoreMember.retailStoreMemberCouponListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberCouponCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreMember.retailStoreMemberCouponCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberCouponSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'retailStoreMemberCouponList', ref:state._retailStoreMember, 
<<<<<<< HEAD
      listDisplayName: '生超会员优惠券列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberCouponSearch)
  }
  getRetailStoreMemberCouponCreateForm = () => {
   	const {RetailStoreMemberCouponCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreMemberCoupon",
      data: state._retailStoreMember.retailStoreMemberCouponList,
      metaInfo: state._retailStoreMember.retailStoreMemberCouponListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberCouponCount,
<<<<<<< HEAD
      currentPage: state._retailStoreMember.retailStoreMemberCouponCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberCouponSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'retailStoreMemberCouponList', ref:state._retailStoreMember, listDisplayName: '生超会员优惠券列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.retailStoreMemberCouponCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberCouponSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'retailStoreMemberCouponList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberCouponCreateForm)
  }
  
  getRetailStoreMemberCouponUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {RetailStoreMemberCouponUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "retailStoreMemberCoupon",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'retailStoreMemberCouponList', ref:state._retailStoreMember, listDisplayName: '生超会员优惠券列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'retailStoreMemberCouponList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberCouponUpdateForm)
  }

  getMemberWishlistSearch = () => {
    const {MemberWishlistSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "会员收藏",
      role: "memberWishlist",
      data: state._retailStoreMember.memberWishlistList,
      metaInfo: state._retailStoreMember.memberWishlistListMetaInfo,
      count: state._retailStoreMember.memberWishlistCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreMember.memberWishlistCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberWishlistSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'memberWishlistList', ref:state._retailStoreMember, 
<<<<<<< HEAD
      listDisplayName: '会员收藏列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(MemberWishlistSearch)
  }
  getMemberWishlistCreateForm = () => {
   	const {MemberWishlistCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "memberWishlist",
      data: state._retailStoreMember.memberWishlistList,
      metaInfo: state._retailStoreMember.memberWishlistListMetaInfo,
      count: state._retailStoreMember.memberWishlistCount,
<<<<<<< HEAD
      currentPage: state._retailStoreMember.memberWishlistCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberWishlistSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'memberWishlistList', ref:state._retailStoreMember, listDisplayName: '会员收藏列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.memberWishlistCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberWishlistSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'memberWishlistList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(MemberWishlistCreateForm)
  }
  
  getMemberWishlistUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {MemberWishlistUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "memberWishlist",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'memberWishlistList', ref:state._retailStoreMember, listDisplayName: '会员收藏列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'memberWishlistList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(MemberWishlistUpdateForm)
  }

  getMemberRewardPointSearch = () => {
    const {MemberRewardPointSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "会员奖励点",
      role: "memberRewardPoint",
      data: state._retailStoreMember.memberRewardPointList,
      metaInfo: state._retailStoreMember.memberRewardPointListMetaInfo,
      count: state._retailStoreMember.memberRewardPointCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreMember.memberRewardPointCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'memberRewardPointList', ref:state._retailStoreMember, 
<<<<<<< HEAD
      listDisplayName: '会员奖励点列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(MemberRewardPointSearch)
  }
  getMemberRewardPointCreateForm = () => {
   	const {MemberRewardPointCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "memberRewardPoint",
      data: state._retailStoreMember.memberRewardPointList,
      metaInfo: state._retailStoreMember.memberRewardPointListMetaInfo,
      count: state._retailStoreMember.memberRewardPointCount,
<<<<<<< HEAD
      currentPage: state._retailStoreMember.memberRewardPointCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'memberRewardPointList', ref:state._retailStoreMember, listDisplayName: '会员奖励点列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.memberRewardPointCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'memberRewardPointList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(MemberRewardPointCreateForm)
  }
  
  getMemberRewardPointUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {MemberRewardPointUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "memberRewardPoint",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'memberRewardPointList', ref:state._retailStoreMember, listDisplayName: '会员奖励点列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'memberRewardPointList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(MemberRewardPointUpdateForm)
  }

  getMemberRewardPointRedemptionSearch = () => {
    const {MemberRewardPointRedemptionSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "会员奖励点赎回",
      role: "memberRewardPointRedemption",
      data: state._retailStoreMember.memberRewardPointRedemptionList,
      metaInfo: state._retailStoreMember.memberRewardPointRedemptionListMetaInfo,
      count: state._retailStoreMember.memberRewardPointRedemptionCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreMember.memberRewardPointRedemptionCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointRedemptionSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'memberRewardPointRedemptionList', ref:state._retailStoreMember, 
<<<<<<< HEAD
      listDisplayName: '会员奖励点赎回列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(MemberRewardPointRedemptionSearch)
  }
  getMemberRewardPointRedemptionCreateForm = () => {
   	const {MemberRewardPointRedemptionCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "memberRewardPointRedemption",
      data: state._retailStoreMember.memberRewardPointRedemptionList,
      metaInfo: state._retailStoreMember.memberRewardPointRedemptionListMetaInfo,
      count: state._retailStoreMember.memberRewardPointRedemptionCount,
<<<<<<< HEAD
      currentPage: state._retailStoreMember.memberRewardPointRedemptionCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointRedemptionSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'memberRewardPointRedemptionList', ref:state._retailStoreMember, listDisplayName: '会员奖励点赎回列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.memberRewardPointRedemptionCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointRedemptionSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'memberRewardPointRedemptionList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(MemberRewardPointRedemptionCreateForm)
  }
  
  getMemberRewardPointRedemptionUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {MemberRewardPointRedemptionUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "memberRewardPointRedemption",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'memberRewardPointRedemptionList', ref:state._retailStoreMember, listDisplayName: '会员奖励点赎回列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'memberRewardPointRedemptionList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(MemberRewardPointRedemptionUpdateForm)
  }

  getRetailStoreMemberAddressSearch = () => {
    const {RetailStoreMemberAddressSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "零售店会员地址",
      role: "retailStoreMemberAddress",
      data: state._retailStoreMember.retailStoreMemberAddressList,
      metaInfo: state._retailStoreMember.retailStoreMemberAddressListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberAddressCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreMember.retailStoreMemberAddressCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberAddressSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'retailStoreMemberAddressList', ref:state._retailStoreMember, 
<<<<<<< HEAD
      listDisplayName: '零售店会员地址列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberAddressSearch)
  }
  getRetailStoreMemberAddressCreateForm = () => {
   	const {RetailStoreMemberAddressCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreMemberAddress",
      data: state._retailStoreMember.retailStoreMemberAddressList,
      metaInfo: state._retailStoreMember.retailStoreMemberAddressListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberAddressCount,
<<<<<<< HEAD
      currentPage: state._retailStoreMember.retailStoreMemberAddressCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberAddressSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'retailStoreMemberAddressList', ref:state._retailStoreMember, listDisplayName: '零售店会员地址列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.retailStoreMemberAddressCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberAddressSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'retailStoreMemberAddressList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberAddressCreateForm)
  }
  
  getRetailStoreMemberAddressUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {RetailStoreMemberAddressUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "retailStoreMemberAddress",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'retailStoreMemberAddressList', ref:state._retailStoreMember, listDisplayName: '零售店会员地址列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'retailStoreMemberAddressList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberAddressUpdateForm)
  }

  getRetailStoreMemberGiftCardSearch = () => {
    const {RetailStoreMemberGiftCardSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "零售店会员礼品卡",
      role: "retailStoreMemberGiftCard",
      data: state._retailStoreMember.retailStoreMemberGiftCardList,
      metaInfo: state._retailStoreMember.retailStoreMemberGiftCardListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberGiftCardCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreMember.retailStoreMemberGiftCardCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberGiftCardSearchFormParameters,
      searchParameters: {...state._retailStoreMember.searchParameters},
      expandForm: state._retailStoreMember.expandForm,
      loading: state._retailStoreMember.loading,
      partialList: state._retailStoreMember.partialList,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, 
      referenceName: 'owner', 
      listName: 'retailStoreMemberGiftCardList', ref:state._retailStoreMember, 
<<<<<<< HEAD
      listDisplayName: '零售店会员礼品卡列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberGiftCardSearch)
  }
  getRetailStoreMemberGiftCardCreateForm = () => {
   	const {RetailStoreMemberGiftCardCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreMemberGiftCard",
      data: state._retailStoreMember.retailStoreMemberGiftCardList,
      metaInfo: state._retailStoreMember.retailStoreMemberGiftCardListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberGiftCardCount,
<<<<<<< HEAD
      currentPage: state._retailStoreMember.retailStoreMemberGiftCardCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberGiftCardSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'retailStoreMemberGiftCardList', ref:state._retailStoreMember, listDisplayName: '零售店会员礼品卡列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.retailStoreMemberGiftCardCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberGiftCardSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, referenceName: 'owner', listName: 'retailStoreMemberGiftCardList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberGiftCardCreateForm)
  }
  
  getRetailStoreMemberGiftCardUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {RetailStoreMemberGiftCardUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "retailStoreMemberGiftCard",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'retailStoreMemberGiftCardList', ref:state._retailStoreMember, listDisplayName: '零售店会员礼品卡列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'retailStoreMemberGiftCardList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberGiftCardUpdateForm)
  }


  
  buildRouters = () =>{
  	const {RetailStoreMemberDashboard} = GlobalComponents
<<<<<<< HEAD
  	const {RetailStoreMemberPreference} = GlobalComponents
=======
  	const {RetailStoreMemberPermission} = GlobalComponents
  	const {RetailStoreMemberProfile} = GlobalComponents
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	const routers=[
  	{path:"/retailStoreMember/:id/dashboard", component: RetailStoreMemberDashboard},
<<<<<<< HEAD
  	{path:"/retailStoreMember/:id/preference", component: RetailStoreMemberPreference},
=======
  	{path:"/retailStoreMember/:id/profile", component: RetailStoreMemberProfile},
  	{path:"/retailStoreMember/:id/permission", component: RetailStoreMemberPermission},
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	
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
<<<<<<< HEAD
     const { breadcrumb }  = this.props

     //const {RetailStoreMemberEditDetail} = GlobalComponents
     //const {RetailStoreMemberViewDetail} = GlobalComponents
     
     
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

		 {this.getNavMenuItems(this.props.retailStoreMember)}
		 
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
            <Dropdown overlay= {this.getNavMenuItems(this.props.retailStoreMember)}>
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
  retailStoreMember: state._retailStoreMember,
  ...state,
}))(RetailStoreMemberBizApp)



