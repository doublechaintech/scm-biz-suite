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
import styles from './RetailStoreMember.app.less'
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





class RetailStoreMemberBizApp extends React.PureComponent {
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

 getNavMenuItems = (targetObject, style, customTheme) => {


    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
    const mode =style || "inline"
    const theme = customTheme || "light"
	const {objectId}=targetApp;
  	const userContext = null
  	const viewGroupIconNameOf=window.viewGroupIconNameOf
    return (
	  <Menu
        theme="dark"
        mode="inline"

        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}

       >

       <Menu.Item key="workbench">
        <Link to={`/retailStoreMember/${this.props.retailStoreMember.id}/workbench`}><Icon type="solution" style={{marginRight:"20px"}}/><span>工作台</span></Link>
      </Menu.Item>

        
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu id={`submenu-vg${index}`}  key={`vg${index}`} title={<span><Icon type={viewGroupIconNameOf('retail_store_member',`${groupedMenuItem.viewGroup}`)} style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
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



  getConsumerOrderSearch = () => {
    const {ConsumerOrderSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('consumer_order','retail_store_member.consumer_order_list',false),
      role: "consumerOrder",
      data: state._retailStoreMember.consumerOrderList,
      metaInfo: state._retailStoreMember.consumerOrderListMetaInfo,
      count: state._retailStoreMember.consumerOrderCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/workbench`,
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
      initValue: this.getSelectedRows(),
      role: "consumerOrder",
      data: state._retailStoreMember.consumerOrderList,
      metaInfo: state._retailStoreMember.consumerOrderListMetaInfo,
      count: state._retailStoreMember.consumerOrderCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.consumerOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.consumerOrderSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), referenceName: 'consumer', listName: 'consumerOrderList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ConsumerOrderCreateForm)
  }

  getConsumerOrderUpdateForm = () => {
    const userContext = null
  	const {ConsumerOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "consumerOrder",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex || 0,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), listName: 'consumerOrderList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderUpdateForm)
  }

  getRetailStoreMemberCouponSearch = () => {
    const {RetailStoreMemberCouponSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store_member_coupon','retail_store_member.retail_store_member_coupon_list',false),
      role: "retailStoreMemberCoupon",
      data: state._retailStoreMember.retailStoreMemberCouponList,
      metaInfo: state._retailStoreMember.retailStoreMemberCouponListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberCouponCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/workbench`,
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
      initValue: this.getSelectedRows(),
      role: "retailStoreMemberCoupon",
      data: state._retailStoreMember.retailStoreMemberCouponList,
      metaInfo: state._retailStoreMember.retailStoreMemberCouponListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberCouponCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.retailStoreMemberCouponCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberCouponSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), referenceName: 'owner', listName: 'retailStoreMemberCouponList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreMemberCouponCreateForm)
  }

  getRetailStoreMemberCouponUpdateForm = () => {
    const userContext = null
  	const {RetailStoreMemberCouponUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "retailStoreMemberCoupon",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex || 0,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), listName: 'retailStoreMemberCouponList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberCouponUpdateForm)
  }

  getMemberWishlistSearch = () => {
    const {MemberWishlistSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('member_wishlist','retail_store_member.member_wishlist_list',false),
      role: "memberWishlist",
      data: state._retailStoreMember.memberWishlistList,
      metaInfo: state._retailStoreMember.memberWishlistListMetaInfo,
      count: state._retailStoreMember.memberWishlistCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/workbench`,
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
      initValue: this.getSelectedRows(),
      role: "memberWishlist",
      data: state._retailStoreMember.memberWishlistList,
      metaInfo: state._retailStoreMember.memberWishlistListMetaInfo,
      count: state._retailStoreMember.memberWishlistCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.memberWishlistCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberWishlistSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), referenceName: 'owner', listName: 'memberWishlistList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(MemberWishlistCreateForm)
  }

  getMemberWishlistUpdateForm = () => {
    const userContext = null
  	const {MemberWishlistUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "memberWishlist",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex || 0,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), listName: 'memberWishlistList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(MemberWishlistUpdateForm)
  }

  getMemberRewardPointSearch = () => {
    const {MemberRewardPointSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('member_reward_point','retail_store_member.member_reward_point_list',false),
      role: "memberRewardPoint",
      data: state._retailStoreMember.memberRewardPointList,
      metaInfo: state._retailStoreMember.memberRewardPointListMetaInfo,
      count: state._retailStoreMember.memberRewardPointCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/workbench`,
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
      initValue: this.getSelectedRows(),
      role: "memberRewardPoint",
      data: state._retailStoreMember.memberRewardPointList,
      metaInfo: state._retailStoreMember.memberRewardPointListMetaInfo,
      count: state._retailStoreMember.memberRewardPointCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.memberRewardPointCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), referenceName: 'owner', listName: 'memberRewardPointList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(MemberRewardPointCreateForm)
  }

  getMemberRewardPointUpdateForm = () => {
    const userContext = null
  	const {MemberRewardPointUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "memberRewardPoint",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex || 0,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), listName: 'memberRewardPointList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(MemberRewardPointUpdateForm)
  }

  getMemberRewardPointRedemptionSearch = () => {
    const {MemberRewardPointRedemptionSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('member_reward_point_redemption','retail_store_member.member_reward_point_redemption_list',false),
      role: "memberRewardPointRedemption",
      data: state._retailStoreMember.memberRewardPointRedemptionList,
      metaInfo: state._retailStoreMember.memberRewardPointRedemptionListMetaInfo,
      count: state._retailStoreMember.memberRewardPointRedemptionCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/workbench`,
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
      initValue: this.getSelectedRows(),
      role: "memberRewardPointRedemption",
      data: state._retailStoreMember.memberRewardPointRedemptionList,
      metaInfo: state._retailStoreMember.memberRewardPointRedemptionListMetaInfo,
      count: state._retailStoreMember.memberRewardPointRedemptionCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.memberRewardPointRedemptionCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.memberRewardPointRedemptionSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), referenceName: 'owner', listName: 'memberRewardPointRedemptionList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(MemberRewardPointRedemptionCreateForm)
  }

  getMemberRewardPointRedemptionUpdateForm = () => {
    const userContext = null
  	const {MemberRewardPointRedemptionUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "memberRewardPointRedemption",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex || 0,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), listName: 'memberRewardPointRedemptionList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(MemberRewardPointRedemptionUpdateForm)
  }

  getRetailStoreMemberAddressSearch = () => {
    const {RetailStoreMemberAddressSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store_member_address','retail_store_member.retail_store_member_address_list',false),
      role: "retailStoreMemberAddress",
      data: state._retailStoreMember.retailStoreMemberAddressList,
      metaInfo: state._retailStoreMember.retailStoreMemberAddressListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberAddressCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/workbench`,
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
      initValue: this.getSelectedRows(),
      role: "retailStoreMemberAddress",
      data: state._retailStoreMember.retailStoreMemberAddressList,
      metaInfo: state._retailStoreMember.retailStoreMemberAddressListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberAddressCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.retailStoreMemberAddressCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberAddressSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), referenceName: 'owner', listName: 'retailStoreMemberAddressList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreMemberAddressCreateForm)
  }

  getRetailStoreMemberAddressUpdateForm = () => {
    const userContext = null
  	const {RetailStoreMemberAddressUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "retailStoreMemberAddress",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex || 0,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), listName: 'retailStoreMemberAddressList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberAddressUpdateForm)
  }

  getRetailStoreMemberGiftCardSearch = () => {
    const {RetailStoreMemberGiftCardSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store_member_gift_card','retail_store_member.retail_store_member_gift_card_list',false),
      role: "retailStoreMemberGiftCard",
      data: state._retailStoreMember.retailStoreMemberGiftCardList,
      metaInfo: state._retailStoreMember.retailStoreMemberGiftCardListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberGiftCardCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/workbench`,
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
      initValue: this.getSelectedRows(),
      role: "retailStoreMemberGiftCard",
      data: state._retailStoreMember.retailStoreMemberGiftCardList,
      metaInfo: state._retailStoreMember.retailStoreMemberGiftCardListMetaInfo,
      count: state._retailStoreMember.retailStoreMemberGiftCardCount,
      returnURL: `/retailStoreMember/${state._retailStoreMember.id}/list`,
      currentPage: state._retailStoreMember.retailStoreMemberGiftCardCurrentPageNumber,
      searchFormParameters: state._retailStoreMember.retailStoreMemberGiftCardSearchFormParameters,
      loading: state._retailStoreMember.loading,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), referenceName: 'owner', listName: 'retailStoreMemberGiftCardList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreMemberGiftCardCreateForm)
  }

  getRetailStoreMemberGiftCardUpdateForm = () => {
    const userContext = null
  	const {RetailStoreMemberGiftCardUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "retailStoreMemberGiftCard",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex || 0,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id || this.getOwnerId(), listName: 'retailStoreMemberGiftCardList', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberGiftCardUpdateForm)
  }


  getRequestTypeStepForm = () => {
    const userContext = null
  	 const {ChangeRequestStepForm} = GlobalComponents
    return connect(state => ({
      selectedRows: state._retailStoreMember.selectedRows,
      role: "cq",
      currentUpdateIndex: state._retailStoreMember.currentUpdateIndex,
      owner: { type: '_retailStoreMember', id: state._retailStoreMember.id, listName: 'nolist', ref:state._retailStoreMember, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestStepForm)
  }



  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '双链小超全流程供应链系统'
    return title
  }

  buildRouters = () =>{
    const {RetailStoreMemberWorkbench} = GlobalComponents

    const {RetailStoreMemberDashboard} = GlobalComponents
  	const {RetailStoreMemberPermission} = GlobalComponents
  	const {RetailStoreMemberProfile} = GlobalComponents


    const routers=[
    {path:"/retailStoreMember/:id/workbench", component: RetailStoreMemberWorkbench},
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

    const {searchLocalData}=GlobalComponents.RetailStoreMemberBase

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

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.retailStoreMember,this.state.searchKeyword)}</div>

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

         {this.getNavMenuItems(this.props.retailStoreMember,"inline","dark")}

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
  retailStoreMember: state._retailStoreMember,
  ...state,
}))(RetailStoreMemberBizApp)



