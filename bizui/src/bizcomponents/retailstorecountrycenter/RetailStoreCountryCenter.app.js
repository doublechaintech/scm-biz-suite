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
import styles from './RetailStoreCountryCenter.app.less'
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




class RetailStoreCountryCenterBizApp extends React.PureComponent {
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
               <Link to={`/retailStoreCountryCenter/${this.props.retailStoreCountryCenter.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
               		<Link to={`/retailStoreCountryCenter/${this.props.retailStoreCountryCenter.id}/permission`}><Icon type="safety-certificate" /><span>{appLocaleName(userContext,"Permission")}</span></Link>
             	</Menu.Item>
             	<Menu.Item key="permission">
               		<Link to={`/retailStoreCountryCenter/${this.props.retailStoreCountryCenter.id}/profile`}><Icon type="cluster" /><span>{appLocaleName(userContext,"Profile")}</span></Link>
             	</Menu.Item> 
      
        	</SubMenu>
        
           </Menu>
    )
  }
  



  getCatalogSearch = () => {
    const {CatalogSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Catalog",
      role: "catalog",
      data: state._retailStoreCountryCenter.catalogList,
      metaInfo: state._retailStoreCountryCenter.catalogListMetaInfo,
      count: state._retailStoreCountryCenter.catalogCount,
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
      role: "catalog",
      data: state._retailStoreCountryCenter.catalogList,
      metaInfo: state._retailStoreCountryCenter.catalogListMetaInfo,
      count: state._retailStoreCountryCenter.catalogCount,
      currentPage: state._retailStoreCountryCenter.catalogCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.catalogSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'catalogList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(CatalogCreateForm)
  }
  
  getCatalogUpdateForm = () => {
    const userContext = null
  	const {CatalogUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "catalog",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'catalogList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CatalogUpdateForm)
  }

  getRetailStoreProvinceCenterSearch = () => {
    const {RetailStoreProvinceCenterSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Retail Store Province Center",
      role: "retailStoreProvinceCenter",
      data: state._retailStoreCountryCenter.retailStoreProvinceCenterList,
      metaInfo: state._retailStoreCountryCenter.retailStoreProvinceCenterListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreProvinceCenterCount,
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
      role: "retailStoreProvinceCenter",
      data: state._retailStoreCountryCenter.retailStoreProvinceCenterList,
      metaInfo: state._retailStoreCountryCenter.retailStoreProvinceCenterListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreProvinceCenterCount,
      currentPage: state._retailStoreCountryCenter.retailStoreProvinceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreProvinceCenterSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'country', listName: 'retailStoreProvinceCenterList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreProvinceCenterCreateForm)
  }
  
  getRetailStoreProvinceCenterUpdateForm = () => {
    const userContext = null
  	const {RetailStoreProvinceCenterUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStoreProvinceCenter",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreProvinceCenterList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreProvinceCenterUpdateForm)
  }

  getRetailStoreSearch = () => {
    const {RetailStoreSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Retail Store",
      role: "retailStore",
      data: state._retailStoreCountryCenter.retailStoreList,
      metaInfo: state._retailStoreCountryCenter.retailStoreListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreCount,
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
      role: "retailStore",
      data: state._retailStoreCountryCenter.retailStoreList,
      metaInfo: state._retailStoreCountryCenter.retailStoreListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreCount,
      currentPage: state._retailStoreCountryCenter.retailStoreCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'retailStoreCountryCenter', listName: 'retailStoreList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreCreateForm)
  }
  
  getRetailStoreUpdateForm = () => {
    const userContext = null
  	const {RetailStoreUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStore",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreUpdateForm)
  }

  getRetailStoreMemberSearch = () => {
    const {RetailStoreMemberSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Retail Store Member",
      role: "retailStoreMember",
      data: state._retailStoreCountryCenter.retailStoreMemberList,
      metaInfo: state._retailStoreCountryCenter.retailStoreMemberListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreMemberCount,
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
      role: "retailStoreMember",
      data: state._retailStoreCountryCenter.retailStoreMemberList,
      metaInfo: state._retailStoreCountryCenter.retailStoreMemberListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreMemberCount,
      currentPage: state._retailStoreCountryCenter.retailStoreMemberCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreMemberSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'retailStoreMemberList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreMemberCreateForm)
  }
  
  getRetailStoreMemberUpdateForm = () => {
    const userContext = null
  	const {RetailStoreMemberUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStoreMember",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreMemberList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreMemberUpdateForm)
  }

  getGoodsSupplierSearch = () => {
    const {GoodsSupplierSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Goods Supplier",
      role: "goodsSupplier",
      data: state._retailStoreCountryCenter.goodsSupplierList,
      metaInfo: state._retailStoreCountryCenter.goodsSupplierListMetaInfo,
      count: state._retailStoreCountryCenter.goodsSupplierCount,
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
      role: "goodsSupplier",
      data: state._retailStoreCountryCenter.goodsSupplierList,
      metaInfo: state._retailStoreCountryCenter.goodsSupplierListMetaInfo,
      count: state._retailStoreCountryCenter.goodsSupplierCount,
      currentPage: state._retailStoreCountryCenter.goodsSupplierCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.goodsSupplierSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'belongTo', listName: 'goodsSupplierList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(GoodsSupplierCreateForm)
  }
  
  getGoodsSupplierUpdateForm = () => {
    const userContext = null
  	const {GoodsSupplierUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "goodsSupplier",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'goodsSupplierList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsSupplierUpdateForm)
  }

  getSupplyOrderSearch = () => {
    const {SupplyOrderSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Supply Order",
      role: "supplyOrder",
      data: state._retailStoreCountryCenter.supplyOrderList,
      metaInfo: state._retailStoreCountryCenter.supplyOrderListMetaInfo,
      count: state._retailStoreCountryCenter.supplyOrderCount,
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
      role: "supplyOrder",
      data: state._retailStoreCountryCenter.supplyOrderList,
      metaInfo: state._retailStoreCountryCenter.supplyOrderListMetaInfo,
      count: state._retailStoreCountryCenter.supplyOrderCount,
      currentPage: state._retailStoreCountryCenter.supplyOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.supplyOrderSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'buyer', listName: 'supplyOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SupplyOrderCreateForm)
  }
  
  getSupplyOrderUpdateForm = () => {
    const userContext = null
  	const {SupplyOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "supplyOrder",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'supplyOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SupplyOrderUpdateForm)
  }

  getRetailStoreOrderSearch = () => {
    const {RetailStoreOrderSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Retail Store Order",
      role: "retailStoreOrder",
      data: state._retailStoreCountryCenter.retailStoreOrderList,
      metaInfo: state._retailStoreCountryCenter.retailStoreOrderListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreOrderCount,
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
      role: "retailStoreOrder",
      data: state._retailStoreCountryCenter.retailStoreOrderList,
      metaInfo: state._retailStoreCountryCenter.retailStoreOrderListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreOrderCount,
      currentPage: state._retailStoreCountryCenter.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreOrderSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'seller', listName: 'retailStoreOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreOrderCreateForm)
  }
  
  getRetailStoreOrderUpdateForm = () => {
    const userContext = null
  	const {RetailStoreOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStoreOrder",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderUpdateForm)
  }

  getWarehouseSearch = () => {
    const {WarehouseSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Warehouse",
      role: "warehouse",
      data: state._retailStoreCountryCenter.warehouseList,
      metaInfo: state._retailStoreCountryCenter.warehouseListMetaInfo,
      count: state._retailStoreCountryCenter.warehouseCount,
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
      role: "warehouse",
      data: state._retailStoreCountryCenter.warehouseList,
      metaInfo: state._retailStoreCountryCenter.warehouseListMetaInfo,
      count: state._retailStoreCountryCenter.warehouseCount,
      currentPage: state._retailStoreCountryCenter.warehouseCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.warehouseSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'warehouseList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(WarehouseCreateForm)
  }
  
  getWarehouseUpdateForm = () => {
    const userContext = null
  	const {WarehouseUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "warehouse",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'warehouseList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(WarehouseUpdateForm)
  }

  getTransportFleetSearch = () => {
    const {TransportFleetSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Transport Fleet",
      role: "transportFleet",
      data: state._retailStoreCountryCenter.transportFleetList,
      metaInfo: state._retailStoreCountryCenter.transportFleetListMetaInfo,
      count: state._retailStoreCountryCenter.transportFleetCount,
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
      role: "transportFleet",
      data: state._retailStoreCountryCenter.transportFleetList,
      metaInfo: state._retailStoreCountryCenter.transportFleetListMetaInfo,
      count: state._retailStoreCountryCenter.transportFleetCount,
      currentPage: state._retailStoreCountryCenter.transportFleetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.transportFleetSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'transportFleetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TransportFleetCreateForm)
  }
  
  getTransportFleetUpdateForm = () => {
    const userContext = null
  	const {TransportFleetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "transportFleet",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'transportFleetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransportFleetUpdateForm)
  }

  getAccountSetSearch = () => {
    const {AccountSetSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Account Set",
      role: "accountSet",
      data: state._retailStoreCountryCenter.accountSetList,
      metaInfo: state._retailStoreCountryCenter.accountSetListMetaInfo,
      count: state._retailStoreCountryCenter.accountSetCount,
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
      role: "accountSet",
      data: state._retailStoreCountryCenter.accountSetList,
      metaInfo: state._retailStoreCountryCenter.accountSetListMetaInfo,
      count: state._retailStoreCountryCenter.accountSetCount,
      currentPage: state._retailStoreCountryCenter.accountSetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.accountSetSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'countryCenter', listName: 'accountSetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AccountSetCreateForm)
  }
  
  getAccountSetUpdateForm = () => {
    const userContext = null
  	const {AccountSetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "accountSet",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'accountSetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountSetUpdateForm)
  }

  getLevelOneDepartmentSearch = () => {
    const {LevelOneDepartmentSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Level One Department",
      role: "levelOneDepartment",
      data: state._retailStoreCountryCenter.levelOneDepartmentList,
      metaInfo: state._retailStoreCountryCenter.levelOneDepartmentListMetaInfo,
      count: state._retailStoreCountryCenter.levelOneDepartmentCount,
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
      role: "levelOneDepartment",
      data: state._retailStoreCountryCenter.levelOneDepartmentList,
      metaInfo: state._retailStoreCountryCenter.levelOneDepartmentListMetaInfo,
      count: state._retailStoreCountryCenter.levelOneDepartmentCount,
      currentPage: state._retailStoreCountryCenter.levelOneDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.levelOneDepartmentSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'belongsTo', listName: 'levelOneDepartmentList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(LevelOneDepartmentCreateForm)
  }
  
  getLevelOneDepartmentUpdateForm = () => {
    const userContext = null
  	const {LevelOneDepartmentUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "levelOneDepartment",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'levelOneDepartmentList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LevelOneDepartmentUpdateForm)
  }

  getSkillTypeSearch = () => {
    const {SkillTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Skill Type",
      role: "skillType",
      data: state._retailStoreCountryCenter.skillTypeList,
      metaInfo: state._retailStoreCountryCenter.skillTypeListMetaInfo,
      count: state._retailStoreCountryCenter.skillTypeCount,
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
      role: "skillType",
      data: state._retailStoreCountryCenter.skillTypeList,
      metaInfo: state._retailStoreCountryCenter.skillTypeListMetaInfo,
      count: state._retailStoreCountryCenter.skillTypeCount,
      currentPage: state._retailStoreCountryCenter.skillTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.skillTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'skillTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SkillTypeCreateForm)
  }
  
  getSkillTypeUpdateForm = () => {
    const userContext = null
  	const {SkillTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "skillType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'skillTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SkillTypeUpdateForm)
  }

  getResponsibilityTypeSearch = () => {
    const {ResponsibilityTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Responsibility Type",
      role: "responsibilityType",
      data: state._retailStoreCountryCenter.responsibilityTypeList,
      metaInfo: state._retailStoreCountryCenter.responsibilityTypeListMetaInfo,
      count: state._retailStoreCountryCenter.responsibilityTypeCount,
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
      role: "responsibilityType",
      data: state._retailStoreCountryCenter.responsibilityTypeList,
      metaInfo: state._retailStoreCountryCenter.responsibilityTypeListMetaInfo,
      count: state._retailStoreCountryCenter.responsibilityTypeCount,
      currentPage: state._retailStoreCountryCenter.responsibilityTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.responsibilityTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'responsibilityTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ResponsibilityTypeCreateForm)
  }
  
  getResponsibilityTypeUpdateForm = () => {
    const userContext = null
  	const {ResponsibilityTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "responsibilityType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'responsibilityTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ResponsibilityTypeUpdateForm)
  }

  getTerminationReasonSearch = () => {
    const {TerminationReasonSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Termination Reason",
      role: "terminationReason",
      data: state._retailStoreCountryCenter.terminationReasonList,
      metaInfo: state._retailStoreCountryCenter.terminationReasonListMetaInfo,
      count: state._retailStoreCountryCenter.terminationReasonCount,
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
      role: "terminationReason",
      data: state._retailStoreCountryCenter.terminationReasonList,
      metaInfo: state._retailStoreCountryCenter.terminationReasonListMetaInfo,
      count: state._retailStoreCountryCenter.terminationReasonCount,
      currentPage: state._retailStoreCountryCenter.terminationReasonCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationReasonSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'terminationReasonList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TerminationReasonCreateForm)
  }
  
  getTerminationReasonUpdateForm = () => {
    const userContext = null
  	const {TerminationReasonUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "terminationReason",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'terminationReasonList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TerminationReasonUpdateForm)
  }

  getTerminationTypeSearch = () => {
    const {TerminationTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Termination Type",
      role: "terminationType",
      data: state._retailStoreCountryCenter.terminationTypeList,
      metaInfo: state._retailStoreCountryCenter.terminationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.terminationTypeCount,
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
      role: "terminationType",
      data: state._retailStoreCountryCenter.terminationTypeList,
      metaInfo: state._retailStoreCountryCenter.terminationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.terminationTypeCount,
      currentPage: state._retailStoreCountryCenter.terminationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'terminationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TerminationTypeCreateForm)
  }
  
  getTerminationTypeUpdateForm = () => {
    const userContext = null
  	const {TerminationTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "terminationType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'terminationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TerminationTypeUpdateForm)
  }

  getOccupationTypeSearch = () => {
    const {OccupationTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Occupation Type",
      role: "occupationType",
      data: state._retailStoreCountryCenter.occupationTypeList,
      metaInfo: state._retailStoreCountryCenter.occupationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.occupationTypeCount,
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
      role: "occupationType",
      data: state._retailStoreCountryCenter.occupationTypeList,
      metaInfo: state._retailStoreCountryCenter.occupationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.occupationTypeCount,
      currentPage: state._retailStoreCountryCenter.occupationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.occupationTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'occupationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(OccupationTypeCreateForm)
  }
  
  getOccupationTypeUpdateForm = () => {
    const userContext = null
  	const {OccupationTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "occupationType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'occupationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(OccupationTypeUpdateForm)
  }

  getLeaveTypeSearch = () => {
    const {LeaveTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Leave Type",
      role: "leaveType",
      data: state._retailStoreCountryCenter.leaveTypeList,
      metaInfo: state._retailStoreCountryCenter.leaveTypeListMetaInfo,
      count: state._retailStoreCountryCenter.leaveTypeCount,
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
      role: "leaveType",
      data: state._retailStoreCountryCenter.leaveTypeList,
      metaInfo: state._retailStoreCountryCenter.leaveTypeListMetaInfo,
      count: state._retailStoreCountryCenter.leaveTypeCount,
      currentPage: state._retailStoreCountryCenter.leaveTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.leaveTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'leaveTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(LeaveTypeCreateForm)
  }
  
  getLeaveTypeUpdateForm = () => {
    const userContext = null
  	const {LeaveTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "leaveType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'leaveTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LeaveTypeUpdateForm)
  }

  getSalaryGradeSearch = () => {
    const {SalaryGradeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Salary Grade",
      role: "salaryGrade",
      data: state._retailStoreCountryCenter.salaryGradeList,
      metaInfo: state._retailStoreCountryCenter.salaryGradeListMetaInfo,
      count: state._retailStoreCountryCenter.salaryGradeCount,
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
      role: "salaryGrade",
      data: state._retailStoreCountryCenter.salaryGradeList,
      metaInfo: state._retailStoreCountryCenter.salaryGradeListMetaInfo,
      count: state._retailStoreCountryCenter.salaryGradeCount,
      currentPage: state._retailStoreCountryCenter.salaryGradeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.salaryGradeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'salaryGradeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SalaryGradeCreateForm)
  }
  
  getSalaryGradeUpdateForm = () => {
    const userContext = null
  	const {SalaryGradeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "salaryGrade",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'salaryGradeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SalaryGradeUpdateForm)
  }

  getInterviewTypeSearch = () => {
    const {InterviewTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Interview Type",
      role: "interviewType",
      data: state._retailStoreCountryCenter.interviewTypeList,
      metaInfo: state._retailStoreCountryCenter.interviewTypeListMetaInfo,
      count: state._retailStoreCountryCenter.interviewTypeCount,
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
      role: "interviewType",
      data: state._retailStoreCountryCenter.interviewTypeList,
      metaInfo: state._retailStoreCountryCenter.interviewTypeListMetaInfo,
      count: state._retailStoreCountryCenter.interviewTypeCount,
      currentPage: state._retailStoreCountryCenter.interviewTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.interviewTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'interviewTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(InterviewTypeCreateForm)
  }
  
  getInterviewTypeUpdateForm = () => {
    const userContext = null
  	const {InterviewTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "interviewType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'interviewTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(InterviewTypeUpdateForm)
  }

  getTrainingCourseTypeSearch = () => {
    const {TrainingCourseTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Training Course Type",
      role: "trainingCourseType",
      data: state._retailStoreCountryCenter.trainingCourseTypeList,
      metaInfo: state._retailStoreCountryCenter.trainingCourseTypeListMetaInfo,
      count: state._retailStoreCountryCenter.trainingCourseTypeCount,
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
      role: "trainingCourseType",
      data: state._retailStoreCountryCenter.trainingCourseTypeList,
      metaInfo: state._retailStoreCountryCenter.trainingCourseTypeListMetaInfo,
      count: state._retailStoreCountryCenter.trainingCourseTypeCount,
      currentPage: state._retailStoreCountryCenter.trainingCourseTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.trainingCourseTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'trainingCourseTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TrainingCourseTypeCreateForm)
  }
  
  getTrainingCourseTypeUpdateForm = () => {
    const userContext = null
  	const {TrainingCourseTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "trainingCourseType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'trainingCourseTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TrainingCourseTypeUpdateForm)
  }

  getPublicHolidaySearch = () => {
    const {PublicHolidaySearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Public Holiday",
      role: "publicHoliday",
      data: state._retailStoreCountryCenter.publicHolidayList,
      metaInfo: state._retailStoreCountryCenter.publicHolidayListMetaInfo,
      count: state._retailStoreCountryCenter.publicHolidayCount,
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
      role: "publicHoliday",
      data: state._retailStoreCountryCenter.publicHolidayList,
      metaInfo: state._retailStoreCountryCenter.publicHolidayListMetaInfo,
      count: state._retailStoreCountryCenter.publicHolidayCount,
      currentPage: state._retailStoreCountryCenter.publicHolidayCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.publicHolidaySearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'publicHolidayList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(PublicHolidayCreateForm)
  }
  
  getPublicHolidayUpdateForm = () => {
    const userContext = null
  	const {PublicHolidayUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "publicHoliday",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'publicHolidayList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PublicHolidayUpdateForm)
  }

  getEmployeeSearch = () => {
    const {EmployeeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Employee",
      role: "employee",
      data: state._retailStoreCountryCenter.employeeList,
      metaInfo: state._retailStoreCountryCenter.employeeListMetaInfo,
      count: state._retailStoreCountryCenter.employeeCount,
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
      role: "employee",
      data: state._retailStoreCountryCenter.employeeList,
      metaInfo: state._retailStoreCountryCenter.employeeListMetaInfo,
      count: state._retailStoreCountryCenter.employeeCount,
      currentPage: state._retailStoreCountryCenter.employeeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.employeeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'employeeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeCreateForm)
  }
  
  getEmployeeUpdateForm = () => {
    const userContext = null
  	const {EmployeeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "employee",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'employeeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeUpdateForm)
  }

  getInstructorSearch = () => {
    const {InstructorSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Instructor",
      role: "instructor",
      data: state._retailStoreCountryCenter.instructorList,
      metaInfo: state._retailStoreCountryCenter.instructorListMetaInfo,
      count: state._retailStoreCountryCenter.instructorCount,
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
      role: "instructor",
      data: state._retailStoreCountryCenter.instructorList,
      metaInfo: state._retailStoreCountryCenter.instructorListMetaInfo,
      count: state._retailStoreCountryCenter.instructorCount,
      currentPage: state._retailStoreCountryCenter.instructorCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.instructorSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'instructorList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(InstructorCreateForm)
  }
  
  getInstructorUpdateForm = () => {
    const userContext = null
  	const {InstructorUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "instructor",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'instructorList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(InstructorUpdateForm)
  }

  getCompanyTrainingSearch = () => {
    const {CompanyTrainingSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Company Training",
      role: "companyTraining",
      data: state._retailStoreCountryCenter.companyTrainingList,
      metaInfo: state._retailStoreCountryCenter.companyTrainingListMetaInfo,
      count: state._retailStoreCountryCenter.companyTrainingCount,
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
      role: "companyTraining",
      data: state._retailStoreCountryCenter.companyTrainingList,
      metaInfo: state._retailStoreCountryCenter.companyTrainingListMetaInfo,
      count: state._retailStoreCountryCenter.companyTrainingCount,
      currentPage: state._retailStoreCountryCenter.companyTrainingCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.companyTrainingSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'companyTrainingList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(CompanyTrainingCreateForm)
  }
  
  getCompanyTrainingUpdateForm = () => {
    const userContext = null
  	const {CompanyTrainingUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "companyTraining",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'companyTrainingList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CompanyTrainingUpdateForm)
  }


  
  buildRouters = () =>{
  	const {RetailStoreCountryCenterDashboard} = GlobalComponents
  	const {RetailStoreCountryCenterPermission} = GlobalComponents
  	const {RetailStoreCountryCenterProfile} = GlobalComponents
  	
  	
  	const routers=[
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

		 {this.getNavMenuItems(this.props.retailStoreCountryCenter)}
		 
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
  retailStoreCountryCenter: state._retailStoreCountryCenter,
  ...state,
}))(RetailStoreCountryCenterBizApp)



