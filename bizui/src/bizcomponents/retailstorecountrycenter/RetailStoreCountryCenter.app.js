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
import styles from './RetailStoreCountryCenter.app.less'
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





class RetailStoreCountryCenterBizApp extends React.PureComponent {
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
      return ['/retailStoreCountryCenter/']
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
        <Link to={`/retailStoreCountryCenter/${this.props.retailStoreCountryCenter.id}/workbench`}><Icon type="solution" style={{marginRight:"20px"}}/><span>工作台</span></Link>
      </Menu.Item>

        
             <Menu.Item key="dashboard">
               <Link to={`/retailStoreCountryCenter/${this.props.retailStoreCountryCenter.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
        
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu id={`submenu-vg${index}`}  key={`vg${index}`} title={<span><Icon type={viewGroupIconNameOf('retail_store_country_center',`${groupedMenuItem.viewGroup}`)} style={{marginRight:"20px"}} /><span>{viewGroupDisplayNameOf('retail_store_country_center',`${groupedMenuItem.viewGroup}`)}</span></span>} >
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



  getCatalogSearch = () => {
    const {CatalogSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('catalog','retail_store_country_center.catalog_list',false),
      role: "catalog",
      data: state._retailStoreCountryCenter.catalogList,
      metaInfo: state._retailStoreCountryCenter.catalogListMetaInfo,
      count: state._retailStoreCountryCenter.catalogCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.catalogCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.catalogSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'owner',
      listName: 'catalogList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CatalogSearch)
  }

  getCatalogCreateForm = () => {
   	const {CatalogCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "catalog",
      data: state._retailStoreCountryCenter.catalogList,
      metaInfo: state._retailStoreCountryCenter.catalogListMetaInfo,
      count: state._retailStoreCountryCenter.catalogCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.catalogCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.catalogSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'owner', listName: 'catalogList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(CatalogCreateForm)
  }

  getCatalogUpdateForm = () => {
    const userContext = null
  	const {CatalogUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "catalog",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'catalogList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CatalogUpdateForm)
  }

  getRetailStoreProvinceCenterSearch = () => {
    const {RetailStoreProvinceCenterSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store_province_center','retail_store_country_center.retail_store_province_center_list',false),
      role: "retailStoreProvinceCenter",
      data: state._retailStoreCountryCenter.retailStoreProvinceCenterList,
      metaInfo: state._retailStoreCountryCenter.retailStoreProvinceCenterListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreProvinceCenterCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.retailStoreProvinceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreProvinceCenterSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'country',
      listName: 'retailStoreProvinceCenterList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreProvinceCenterSearch)
  }

  getRetailStoreProvinceCenterCreateForm = () => {
   	const {RetailStoreProvinceCenterCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "retailStoreProvinceCenter",
      data: state._retailStoreCountryCenter.retailStoreProvinceCenterList,
      metaInfo: state._retailStoreCountryCenter.retailStoreProvinceCenterListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreProvinceCenterCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.retailStoreProvinceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreProvinceCenterSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'country', listName: 'retailStoreProvinceCenterList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreProvinceCenterCreateForm)
  }

  getRetailStoreProvinceCenterUpdateForm = () => {
    const userContext = null
  	const {RetailStoreProvinceCenterUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStoreProvinceCenter",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'retailStoreProvinceCenterList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreProvinceCenterUpdateForm)
  }

  getRetailStoreSearch = () => {
    const {RetailStoreSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store','retail_store_country_center.retail_store_list',false),
      role: "retailStore",
      data: state._retailStoreCountryCenter.retailStoreList,
      metaInfo: state._retailStoreCountryCenter.retailStoreListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.retailStoreCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'retailStoreCountryCenter',
      listName: 'retailStoreList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreSearch)
  }

  getRetailStoreCreateForm = () => {
   	const {RetailStoreCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "retailStore",
      data: state._retailStoreCountryCenter.retailStoreList,
      metaInfo: state._retailStoreCountryCenter.retailStoreListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.retailStoreCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'retailStoreCountryCenter', listName: 'retailStoreList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreCreateForm)
  }

  getRetailStoreUpdateForm = () => {
    const userContext = null
  	const {RetailStoreUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStore",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'retailStoreList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreUpdateForm)
  }

  getRetailStoreMemberSearch = () => {
    const {RetailStoreMemberSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store_member','retail_store_country_center.retail_store_member_list',false),
      role: "retailStoreMember",
      data: state._retailStoreCountryCenter.retailStoreMemberList,
      metaInfo: state._retailStoreCountryCenter.retailStoreMemberListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreMemberCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.retailStoreMemberCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreMemberSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'owner',
      listName: 'retailStoreMemberList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberSearch)
  }

  getRetailStoreMemberCreateForm = () => {
   	const {RetailStoreMemberCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "retailStoreMember",
      data: state._retailStoreCountryCenter.retailStoreMemberList,
      metaInfo: state._retailStoreCountryCenter.retailStoreMemberListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreMemberCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.retailStoreMemberCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreMemberSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'owner', listName: 'retailStoreMemberList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreMemberCreateForm)
  }

  getRetailStoreMemberUpdateForm = () => {
    const userContext = null
  	const {RetailStoreMemberUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStoreMember",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'retailStoreMemberList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberUpdateForm)
  }

  getGoodsSupplierSearch = () => {
    const {GoodsSupplierSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('goods_supplier','retail_store_country_center.goods_supplier_list',false),
      role: "goodsSupplier",
      data: state._retailStoreCountryCenter.goodsSupplierList,
      metaInfo: state._retailStoreCountryCenter.goodsSupplierListMetaInfo,
      count: state._retailStoreCountryCenter.goodsSupplierCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.goodsSupplierCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.goodsSupplierSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'belongTo',
      listName: 'goodsSupplierList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsSupplierSearch)
  }

  getGoodsSupplierCreateForm = () => {
   	const {GoodsSupplierCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "goodsSupplier",
      data: state._retailStoreCountryCenter.goodsSupplierList,
      metaInfo: state._retailStoreCountryCenter.goodsSupplierListMetaInfo,
      count: state._retailStoreCountryCenter.goodsSupplierCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.goodsSupplierCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.goodsSupplierSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'belongTo', listName: 'goodsSupplierList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(GoodsSupplierCreateForm)
  }

  getGoodsSupplierUpdateForm = () => {
    const userContext = null
  	const {GoodsSupplierUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "goodsSupplier",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'goodsSupplierList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsSupplierUpdateForm)
  }

  getSupplyOrderSearch = () => {
    const {SupplyOrderSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('supply_order','retail_store_country_center.supply_order_list',false),
      role: "supplyOrder",
      data: state._retailStoreCountryCenter.supplyOrderList,
      metaInfo: state._retailStoreCountryCenter.supplyOrderListMetaInfo,
      count: state._retailStoreCountryCenter.supplyOrderCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.supplyOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.supplyOrderSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'buyer',
      listName: 'supplyOrderList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderSearch)
  }

  getSupplyOrderCreateForm = () => {
   	const {SupplyOrderCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "supplyOrder",
      data: state._retailStoreCountryCenter.supplyOrderList,
      metaInfo: state._retailStoreCountryCenter.supplyOrderListMetaInfo,
      count: state._retailStoreCountryCenter.supplyOrderCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.supplyOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.supplyOrderSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'buyer', listName: 'supplyOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SupplyOrderCreateForm)
  }

  getSupplyOrderUpdateForm = () => {
    const userContext = null
  	const {SupplyOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "supplyOrder",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'supplyOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderUpdateForm)
  }

  getRetailStoreOrderSearch = () => {
    const {RetailStoreOrderSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store_order','retail_store_country_center.retail_store_order_list',false),
      role: "retailStoreOrder",
      data: state._retailStoreCountryCenter.retailStoreOrderList,
      metaInfo: state._retailStoreCountryCenter.retailStoreOrderListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreOrderCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreOrderSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'seller',
      listName: 'retailStoreOrderList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderSearch)
  }

  getRetailStoreOrderCreateForm = () => {
   	const {RetailStoreOrderCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "retailStoreOrder",
      data: state._retailStoreCountryCenter.retailStoreOrderList,
      metaInfo: state._retailStoreCountryCenter.retailStoreOrderListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreOrderCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreOrderSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'seller', listName: 'retailStoreOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreOrderCreateForm)
  }

  getRetailStoreOrderUpdateForm = () => {
    const userContext = null
  	const {RetailStoreOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStoreOrder",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'retailStoreOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderUpdateForm)
  }

  getWarehouseSearch = () => {
    const {WarehouseSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('warehouse','retail_store_country_center.warehouse_list',false),
      role: "warehouse",
      data: state._retailStoreCountryCenter.warehouseList,
      metaInfo: state._retailStoreCountryCenter.warehouseListMetaInfo,
      count: state._retailStoreCountryCenter.warehouseCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.warehouseCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.warehouseSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'owner',
      listName: 'warehouseList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(WarehouseSearch)
  }

  getWarehouseCreateForm = () => {
   	const {WarehouseCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "warehouse",
      data: state._retailStoreCountryCenter.warehouseList,
      metaInfo: state._retailStoreCountryCenter.warehouseListMetaInfo,
      count: state._retailStoreCountryCenter.warehouseCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.warehouseCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.warehouseSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'owner', listName: 'warehouseList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(WarehouseCreateForm)
  }

  getWarehouseUpdateForm = () => {
    const userContext = null
  	const {WarehouseUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "warehouse",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'warehouseList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(WarehouseUpdateForm)
  }

  getTransportFleetSearch = () => {
    const {TransportFleetSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('transport_fleet','retail_store_country_center.transport_fleet_list',false),
      role: "transportFleet",
      data: state._retailStoreCountryCenter.transportFleetList,
      metaInfo: state._retailStoreCountryCenter.transportFleetListMetaInfo,
      count: state._retailStoreCountryCenter.transportFleetCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.transportFleetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.transportFleetSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'owner',
      listName: 'transportFleetList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransportFleetSearch)
  }

  getTransportFleetCreateForm = () => {
   	const {TransportFleetCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "transportFleet",
      data: state._retailStoreCountryCenter.transportFleetList,
      metaInfo: state._retailStoreCountryCenter.transportFleetListMetaInfo,
      count: state._retailStoreCountryCenter.transportFleetCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.transportFleetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.transportFleetSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'owner', listName: 'transportFleetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TransportFleetCreateForm)
  }

  getTransportFleetUpdateForm = () => {
    const userContext = null
  	const {TransportFleetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "transportFleet",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'transportFleetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransportFleetUpdateForm)
  }

  getAccountSetSearch = () => {
    const {AccountSetSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('account_set','retail_store_country_center.account_set_list',false),
      role: "accountSet",
      data: state._retailStoreCountryCenter.accountSetList,
      metaInfo: state._retailStoreCountryCenter.accountSetListMetaInfo,
      count: state._retailStoreCountryCenter.accountSetCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.accountSetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.accountSetSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'countryCenter',
      listName: 'accountSetList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountSetSearch)
  }

  getAccountSetCreateForm = () => {
   	const {AccountSetCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "accountSet",
      data: state._retailStoreCountryCenter.accountSetList,
      metaInfo: state._retailStoreCountryCenter.accountSetListMetaInfo,
      count: state._retailStoreCountryCenter.accountSetCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.accountSetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.accountSetSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'countryCenter', listName: 'accountSetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AccountSetCreateForm)
  }

  getAccountSetUpdateForm = () => {
    const userContext = null
  	const {AccountSetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "accountSet",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'accountSetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountSetUpdateForm)
  }

  getLevelOneDepartmentSearch = () => {
    const {LevelOneDepartmentSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('level_one_department','retail_store_country_center.level_one_department_list',false),
      role: "levelOneDepartment",
      data: state._retailStoreCountryCenter.levelOneDepartmentList,
      metaInfo: state._retailStoreCountryCenter.levelOneDepartmentListMetaInfo,
      count: state._retailStoreCountryCenter.levelOneDepartmentCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.levelOneDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.levelOneDepartmentSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'belongsTo',
      listName: 'levelOneDepartmentList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LevelOneDepartmentSearch)
  }

  getLevelOneDepartmentCreateForm = () => {
   	const {LevelOneDepartmentCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "levelOneDepartment",
      data: state._retailStoreCountryCenter.levelOneDepartmentList,
      metaInfo: state._retailStoreCountryCenter.levelOneDepartmentListMetaInfo,
      count: state._retailStoreCountryCenter.levelOneDepartmentCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.levelOneDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.levelOneDepartmentSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'belongsTo', listName: 'levelOneDepartmentList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(LevelOneDepartmentCreateForm)
  }

  getLevelOneDepartmentUpdateForm = () => {
    const userContext = null
  	const {LevelOneDepartmentUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "levelOneDepartment",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'levelOneDepartmentList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LevelOneDepartmentUpdateForm)
  }

  getSkillTypeSearch = () => {
    const {SkillTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('skill_type','retail_store_country_center.skill_type_list',false),
      role: "skillType",
      data: state._retailStoreCountryCenter.skillTypeList,
      metaInfo: state._retailStoreCountryCenter.skillTypeListMetaInfo,
      count: state._retailStoreCountryCenter.skillTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.skillTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.skillTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'skillTypeList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SkillTypeSearch)
  }

  getSkillTypeCreateForm = () => {
   	const {SkillTypeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "skillType",
      data: state._retailStoreCountryCenter.skillTypeList,
      metaInfo: state._retailStoreCountryCenter.skillTypeListMetaInfo,
      count: state._retailStoreCountryCenter.skillTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.skillTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.skillTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'skillTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SkillTypeCreateForm)
  }

  getSkillTypeUpdateForm = () => {
    const userContext = null
  	const {SkillTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "skillType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'skillTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SkillTypeUpdateForm)
  }

  getResponsibilityTypeSearch = () => {
    const {ResponsibilityTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('responsibility_type','retail_store_country_center.responsibility_type_list',false),
      role: "responsibilityType",
      data: state._retailStoreCountryCenter.responsibilityTypeList,
      metaInfo: state._retailStoreCountryCenter.responsibilityTypeListMetaInfo,
      count: state._retailStoreCountryCenter.responsibilityTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.responsibilityTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.responsibilityTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'responsibilityTypeList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ResponsibilityTypeSearch)
  }

  getResponsibilityTypeCreateForm = () => {
   	const {ResponsibilityTypeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "responsibilityType",
      data: state._retailStoreCountryCenter.responsibilityTypeList,
      metaInfo: state._retailStoreCountryCenter.responsibilityTypeListMetaInfo,
      count: state._retailStoreCountryCenter.responsibilityTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.responsibilityTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.responsibilityTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'responsibilityTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ResponsibilityTypeCreateForm)
  }

  getResponsibilityTypeUpdateForm = () => {
    const userContext = null
  	const {ResponsibilityTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "responsibilityType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'responsibilityTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ResponsibilityTypeUpdateForm)
  }

  getTerminationReasonSearch = () => {
    const {TerminationReasonSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('termination_reason','retail_store_country_center.termination_reason_list',false),
      role: "terminationReason",
      data: state._retailStoreCountryCenter.terminationReasonList,
      metaInfo: state._retailStoreCountryCenter.terminationReasonListMetaInfo,
      count: state._retailStoreCountryCenter.terminationReasonCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.terminationReasonCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationReasonSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'terminationReasonList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TerminationReasonSearch)
  }

  getTerminationReasonCreateForm = () => {
   	const {TerminationReasonCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "terminationReason",
      data: state._retailStoreCountryCenter.terminationReasonList,
      metaInfo: state._retailStoreCountryCenter.terminationReasonListMetaInfo,
      count: state._retailStoreCountryCenter.terminationReasonCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.terminationReasonCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationReasonSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'terminationReasonList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TerminationReasonCreateForm)
  }

  getTerminationReasonUpdateForm = () => {
    const userContext = null
  	const {TerminationReasonUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "terminationReason",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'terminationReasonList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TerminationReasonUpdateForm)
  }

  getTerminationTypeSearch = () => {
    const {TerminationTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('termination_type','retail_store_country_center.termination_type_list',false),
      role: "terminationType",
      data: state._retailStoreCountryCenter.terminationTypeList,
      metaInfo: state._retailStoreCountryCenter.terminationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.terminationTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.terminationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'terminationTypeList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TerminationTypeSearch)
  }

  getTerminationTypeCreateForm = () => {
   	const {TerminationTypeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "terminationType",
      data: state._retailStoreCountryCenter.terminationTypeList,
      metaInfo: state._retailStoreCountryCenter.terminationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.terminationTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.terminationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'terminationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TerminationTypeCreateForm)
  }

  getTerminationTypeUpdateForm = () => {
    const userContext = null
  	const {TerminationTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "terminationType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'terminationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TerminationTypeUpdateForm)
  }

  getOccupationTypeSearch = () => {
    const {OccupationTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('occupation_type','retail_store_country_center.occupation_type_list',false),
      role: "occupationType",
      data: state._retailStoreCountryCenter.occupationTypeList,
      metaInfo: state._retailStoreCountryCenter.occupationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.occupationTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.occupationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.occupationTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'occupationTypeList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(OccupationTypeSearch)
  }

  getOccupationTypeCreateForm = () => {
   	const {OccupationTypeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "occupationType",
      data: state._retailStoreCountryCenter.occupationTypeList,
      metaInfo: state._retailStoreCountryCenter.occupationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.occupationTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.occupationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.occupationTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'occupationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(OccupationTypeCreateForm)
  }

  getOccupationTypeUpdateForm = () => {
    const userContext = null
  	const {OccupationTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "occupationType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'occupationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(OccupationTypeUpdateForm)
  }

  getLeaveTypeSearch = () => {
    const {LeaveTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('leave_type','retail_store_country_center.leave_type_list',false),
      role: "leaveType",
      data: state._retailStoreCountryCenter.leaveTypeList,
      metaInfo: state._retailStoreCountryCenter.leaveTypeListMetaInfo,
      count: state._retailStoreCountryCenter.leaveTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.leaveTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.leaveTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'leaveTypeList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LeaveTypeSearch)
  }

  getLeaveTypeCreateForm = () => {
   	const {LeaveTypeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "leaveType",
      data: state._retailStoreCountryCenter.leaveTypeList,
      metaInfo: state._retailStoreCountryCenter.leaveTypeListMetaInfo,
      count: state._retailStoreCountryCenter.leaveTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.leaveTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.leaveTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'leaveTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(LeaveTypeCreateForm)
  }

  getLeaveTypeUpdateForm = () => {
    const userContext = null
  	const {LeaveTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "leaveType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'leaveTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LeaveTypeUpdateForm)
  }

  getSalaryGradeSearch = () => {
    const {SalaryGradeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('salary_grade','retail_store_country_center.salary_grade_list',false),
      role: "salaryGrade",
      data: state._retailStoreCountryCenter.salaryGradeList,
      metaInfo: state._retailStoreCountryCenter.salaryGradeListMetaInfo,
      count: state._retailStoreCountryCenter.salaryGradeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.salaryGradeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.salaryGradeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'salaryGradeList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SalaryGradeSearch)
  }

  getSalaryGradeCreateForm = () => {
   	const {SalaryGradeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "salaryGrade",
      data: state._retailStoreCountryCenter.salaryGradeList,
      metaInfo: state._retailStoreCountryCenter.salaryGradeListMetaInfo,
      count: state._retailStoreCountryCenter.salaryGradeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.salaryGradeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.salaryGradeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'salaryGradeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SalaryGradeCreateForm)
  }

  getSalaryGradeUpdateForm = () => {
    const userContext = null
  	const {SalaryGradeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "salaryGrade",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'salaryGradeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SalaryGradeUpdateForm)
  }

  getInterviewTypeSearch = () => {
    const {InterviewTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('interview_type','retail_store_country_center.interview_type_list',false),
      role: "interviewType",
      data: state._retailStoreCountryCenter.interviewTypeList,
      metaInfo: state._retailStoreCountryCenter.interviewTypeListMetaInfo,
      count: state._retailStoreCountryCenter.interviewTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.interviewTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.interviewTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'interviewTypeList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(InterviewTypeSearch)
  }

  getInterviewTypeCreateForm = () => {
   	const {InterviewTypeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "interviewType",
      data: state._retailStoreCountryCenter.interviewTypeList,
      metaInfo: state._retailStoreCountryCenter.interviewTypeListMetaInfo,
      count: state._retailStoreCountryCenter.interviewTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.interviewTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.interviewTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'interviewTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(InterviewTypeCreateForm)
  }

  getInterviewTypeUpdateForm = () => {
    const userContext = null
  	const {InterviewTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "interviewType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'interviewTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(InterviewTypeUpdateForm)
  }

  getTrainingCourseTypeSearch = () => {
    const {TrainingCourseTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('training_course_type','retail_store_country_center.training_course_type_list',false),
      role: "trainingCourseType",
      data: state._retailStoreCountryCenter.trainingCourseTypeList,
      metaInfo: state._retailStoreCountryCenter.trainingCourseTypeListMetaInfo,
      count: state._retailStoreCountryCenter.trainingCourseTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.trainingCourseTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.trainingCourseTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'trainingCourseTypeList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TrainingCourseTypeSearch)
  }

  getTrainingCourseTypeCreateForm = () => {
   	const {TrainingCourseTypeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "trainingCourseType",
      data: state._retailStoreCountryCenter.trainingCourseTypeList,
      metaInfo: state._retailStoreCountryCenter.trainingCourseTypeListMetaInfo,
      count: state._retailStoreCountryCenter.trainingCourseTypeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.trainingCourseTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.trainingCourseTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'trainingCourseTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TrainingCourseTypeCreateForm)
  }

  getTrainingCourseTypeUpdateForm = () => {
    const userContext = null
  	const {TrainingCourseTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "trainingCourseType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'trainingCourseTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TrainingCourseTypeUpdateForm)
  }

  getPublicHolidaySearch = () => {
    const {PublicHolidaySearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('public_holiday','retail_store_country_center.public_holiday_list',false),
      role: "publicHoliday",
      data: state._retailStoreCountryCenter.publicHolidayList,
      metaInfo: state._retailStoreCountryCenter.publicHolidayListMetaInfo,
      count: state._retailStoreCountryCenter.publicHolidayCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.publicHolidayCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.publicHolidaySearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'publicHolidayList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PublicHolidaySearch)
  }

  getPublicHolidayCreateForm = () => {
   	const {PublicHolidayCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "publicHoliday",
      data: state._retailStoreCountryCenter.publicHolidayList,
      metaInfo: state._retailStoreCountryCenter.publicHolidayListMetaInfo,
      count: state._retailStoreCountryCenter.publicHolidayCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.publicHolidayCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.publicHolidaySearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'publicHolidayList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(PublicHolidayCreateForm)
  }

  getPublicHolidayUpdateForm = () => {
    const userContext = null
  	const {PublicHolidayUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "publicHoliday",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'publicHolidayList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PublicHolidayUpdateForm)
  }

  getEmployeeSearch = () => {
    const {EmployeeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee','retail_store_country_center.employee_list',false),
      role: "employee",
      data: state._retailStoreCountryCenter.employeeList,
      metaInfo: state._retailStoreCountryCenter.employeeListMetaInfo,
      count: state._retailStoreCountryCenter.employeeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.employeeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.employeeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'employeeList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeSearch)
  }

  getEmployeeCreateForm = () => {
   	const {EmployeeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employee",
      data: state._retailStoreCountryCenter.employeeList,
      metaInfo: state._retailStoreCountryCenter.employeeListMetaInfo,
      count: state._retailStoreCountryCenter.employeeCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.employeeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.employeeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'employeeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeCreateForm)
  }

  getEmployeeUpdateForm = () => {
    const userContext = null
  	const {EmployeeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "employee",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'employeeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeUpdateForm)
  }

  getInstructorSearch = () => {
    const {InstructorSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('instructor','retail_store_country_center.instructor_list',false),
      role: "instructor",
      data: state._retailStoreCountryCenter.instructorList,
      metaInfo: state._retailStoreCountryCenter.instructorListMetaInfo,
      count: state._retailStoreCountryCenter.instructorCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.instructorCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.instructorSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'instructorList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(InstructorSearch)
  }

  getInstructorCreateForm = () => {
   	const {InstructorCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "instructor",
      data: state._retailStoreCountryCenter.instructorList,
      metaInfo: state._retailStoreCountryCenter.instructorListMetaInfo,
      count: state._retailStoreCountryCenter.instructorCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.instructorCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.instructorSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'instructorList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(InstructorCreateForm)
  }

  getInstructorUpdateForm = () => {
    const userContext = null
  	const {InstructorUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "instructor",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'instructorList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(InstructorUpdateForm)
  }

  getCompanyTrainingSearch = () => {
    const {CompanyTrainingSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('company_training','retail_store_country_center.company_training_list',false),
      role: "companyTraining",
      data: state._retailStoreCountryCenter.companyTrainingList,
      metaInfo: state._retailStoreCountryCenter.companyTrainingListMetaInfo,
      count: state._retailStoreCountryCenter.companyTrainingCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/workbench`,
      currentPage: state._retailStoreCountryCenter.companyTrainingCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.companyTrainingSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id,
      referenceName: 'company',
      listName: 'companyTrainingList', ref:state._retailStoreCountryCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CompanyTrainingSearch)
  }

  getCompanyTrainingCreateForm = () => {
   	const {CompanyTrainingCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "companyTraining",
      data: state._retailStoreCountryCenter.companyTrainingList,
      metaInfo: state._retailStoreCountryCenter.companyTrainingListMetaInfo,
      count: state._retailStoreCountryCenter.companyTrainingCount,
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.companyTrainingCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.companyTrainingSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), referenceName: 'company', listName: 'companyTrainingList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(CompanyTrainingCreateForm)
  }

  getCompanyTrainingUpdateForm = () => {
    const userContext = null
  	const {CompanyTrainingUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "companyTraining",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id || this.getOwnerId(), listName: 'companyTrainingList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CompanyTrainingUpdateForm)
  }


  getRequestTypeStepForm = () => {
    const userContext = null
  	 const {ChangeRequestStepForm} = GlobalComponents
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "cq",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'nolist', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestStepForm)
  }



  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '双链小超全流程供应链系统'
    return title
  }

  buildRouters = () =>{
    const {RetailStoreCountryCenterWorkbench} = GlobalComponents

    const {RetailStoreCountryCenterDashboard} = GlobalComponents
  	const {RetailStoreCountryCenterPermission} = GlobalComponents
  	const {RetailStoreCountryCenterProfile} = GlobalComponents


    const routers=[
    {path:"/retailStoreCountryCenter/:id/workbench", component: RetailStoreCountryCenterWorkbench},
    {path:"/retailStoreCountryCenter/:id/dashboard", component: RetailStoreCountryCenterDashboard},
  	{path:"/retailStoreCountryCenter/:id/profile", component: RetailStoreCountryCenterProfile},
  	{path:"/retailStoreCountryCenter/:id/permission", component: RetailStoreCountryCenterPermission},



  	{path:"/retailStoreCountryCenter/:id/list/catalogList", component: this.getCatalogSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/catalogCreateForm", component: this.getCatalogCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/catalogUpdateForm", component: this.getCatalogUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreProvinceCenterList", component: this.getRetailStoreProvinceCenterSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreProvinceCenterCreateForm", component: this.getRetailStoreProvinceCenterCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreProvinceCenterUpdateForm", component: this.getRetailStoreProvinceCenterUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreList", component: this.getRetailStoreSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreCreateForm", component: this.getRetailStoreCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreUpdateForm", component: this.getRetailStoreUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreMemberList", component: this.getRetailStoreMemberSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreMemberCreateForm", component: this.getRetailStoreMemberCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreMemberUpdateForm", component: this.getRetailStoreMemberUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/goodsSupplierList", component: this.getGoodsSupplierSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/goodsSupplierCreateForm", component: this.getGoodsSupplierCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/goodsSupplierUpdateForm", component: this.getGoodsSupplierUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/supplyOrderList", component: this.getSupplyOrderSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/supplyOrderCreateForm", component: this.getSupplyOrderCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/supplyOrderUpdateForm", component: this.getSupplyOrderUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreOrderList", component: this.getRetailStoreOrderSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreOrderCreateForm", component: this.getRetailStoreOrderCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/retailStoreOrderUpdateForm", component: this.getRetailStoreOrderUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/warehouseList", component: this.getWarehouseSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/warehouseCreateForm", component: this.getWarehouseCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/warehouseUpdateForm", component: this.getWarehouseUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/transportFleetList", component: this.getTransportFleetSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/transportFleetCreateForm", component: this.getTransportFleetCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/transportFleetUpdateForm", component: this.getTransportFleetUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/accountSetList", component: this.getAccountSetSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/accountSetCreateForm", component: this.getAccountSetCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/accountSetUpdateForm", component: this.getAccountSetUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/levelOneDepartmentList", component: this.getLevelOneDepartmentSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/levelOneDepartmentCreateForm", component: this.getLevelOneDepartmentCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/levelOneDepartmentUpdateForm", component: this.getLevelOneDepartmentUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/skillTypeList", component: this.getSkillTypeSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/skillTypeCreateForm", component: this.getSkillTypeCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/skillTypeUpdateForm", component: this.getSkillTypeUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/responsibilityTypeList", component: this.getResponsibilityTypeSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/responsibilityTypeCreateForm", component: this.getResponsibilityTypeCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/responsibilityTypeUpdateForm", component: this.getResponsibilityTypeUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/terminationReasonList", component: this.getTerminationReasonSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/terminationReasonCreateForm", component: this.getTerminationReasonCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/terminationReasonUpdateForm", component: this.getTerminationReasonUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/terminationTypeList", component: this.getTerminationTypeSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/terminationTypeCreateForm", component: this.getTerminationTypeCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/terminationTypeUpdateForm", component: this.getTerminationTypeUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/occupationTypeList", component: this.getOccupationTypeSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/occupationTypeCreateForm", component: this.getOccupationTypeCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/occupationTypeUpdateForm", component: this.getOccupationTypeUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/leaveTypeList", component: this.getLeaveTypeSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/leaveTypeCreateForm", component: this.getLeaveTypeCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/leaveTypeUpdateForm", component: this.getLeaveTypeUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/salaryGradeList", component: this.getSalaryGradeSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/salaryGradeCreateForm", component: this.getSalaryGradeCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/salaryGradeUpdateForm", component: this.getSalaryGradeUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/interviewTypeList", component: this.getInterviewTypeSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/interviewTypeCreateForm", component: this.getInterviewTypeCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/interviewTypeUpdateForm", component: this.getInterviewTypeUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/trainingCourseTypeList", component: this.getTrainingCourseTypeSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/trainingCourseTypeCreateForm", component: this.getTrainingCourseTypeCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/trainingCourseTypeUpdateForm", component: this.getTrainingCourseTypeUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/publicHolidayList", component: this.getPublicHolidaySearch()},
  	{path:"/retailStoreCountryCenter/:id/list/publicHolidayCreateForm", component: this.getPublicHolidayCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/publicHolidayUpdateForm", component: this.getPublicHolidayUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/employeeList", component: this.getEmployeeSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/employeeCreateForm", component: this.getEmployeeCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/employeeUpdateForm", component: this.getEmployeeUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/instructorList", component: this.getInstructorSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/instructorCreateForm", component: this.getInstructorCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/instructorUpdateForm", component: this.getInstructorUpdateForm()},
 
  	{path:"/retailStoreCountryCenter/:id/list/companyTrainingList", component: this.getCompanyTrainingSearch()},
  	{path:"/retailStoreCountryCenter/:id/list/companyTrainingCreateForm", component: this.getCompanyTrainingCreateForm()},
  	{path:"/retailStoreCountryCenter/:id/list/companyTrainingUpdateForm", component: this.getCompanyTrainingUpdateForm()},
 

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

    const {searchLocalData}=GlobalComponents.RetailStoreCountryCenterBase

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

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.retailStoreCountryCenter,this.state.searchKeyword)}</div>

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

         {this.getNavMenuItems(this.props.retailStoreCountryCenter,"inline","dark")}

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
  retailStoreCountryCenter: state._retailStoreCountryCenter,
  ...state,
}))(RetailStoreCountryCenterBizApp)



