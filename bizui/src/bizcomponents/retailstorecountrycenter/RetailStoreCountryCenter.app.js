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
import styles from './RetailStoreCountryCenter.app.less'
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




class RetailStoreCountryCenterBizApp extends React.PureComponent {
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
               <Link to={`/retailStoreCountryCenter/${this.props.retailStoreCountryCenter.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
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
               <Link to={`/retailStoreCountryCenter/${this.props.retailStoreCountryCenter.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
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
               <Link to={`/retailStoreCountryCenter/${this.props.retailStoreCountryCenter.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getCatalogSearch = () => {
    const {CatalogSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "目录",
      role: "catalog",
      data: state._retailStoreCountryCenter.catalogList,
      metaInfo: state._retailStoreCountryCenter.catalogListMetaInfo,
      count: state._retailStoreCountryCenter.catalogCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.catalogCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.catalogSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'owner', 
      listName: 'catalogList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '目录列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(CatalogSearch)
  }
  getCatalogCreateForm = () => {
   	const {CatalogCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "catalog",
      data: state._retailStoreCountryCenter.catalogList,
      metaInfo: state._retailStoreCountryCenter.catalogListMetaInfo,
      count: state._retailStoreCountryCenter.catalogCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.catalogCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.catalogSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'catalogList', ref:state._retailStoreCountryCenter, listDisplayName: '目录列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.catalogCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.catalogSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'catalogList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(CatalogCreateForm)
  }
  
  getCatalogUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {CatalogUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "catalog",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'catalogList', ref:state._retailStoreCountryCenter, listDisplayName: '目录列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'catalogList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(CatalogUpdateForm)
  }

  getRetailStoreProvinceCenterSearch = () => {
    const {RetailStoreProvinceCenterSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "双链小超省中心",
      role: "retailStoreProvinceCenter",
      data: state._retailStoreCountryCenter.retailStoreProvinceCenterList,
      metaInfo: state._retailStoreCountryCenter.retailStoreProvinceCenterListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreProvinceCenterCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.retailStoreProvinceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreProvinceCenterSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'country', 
      listName: 'retailStoreProvinceCenterList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '双链小超省中心列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreProvinceCenterSearch)
  }
  getRetailStoreProvinceCenterCreateForm = () => {
   	const {RetailStoreProvinceCenterCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreProvinceCenter",
      data: state._retailStoreCountryCenter.retailStoreProvinceCenterList,
      metaInfo: state._retailStoreCountryCenter.retailStoreProvinceCenterListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreProvinceCenterCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.retailStoreProvinceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreProvinceCenterSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'country', listName: 'retailStoreProvinceCenterList', ref:state._retailStoreCountryCenter, listDisplayName: '双链小超省中心列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.retailStoreProvinceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreProvinceCenterSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'country', listName: 'retailStoreProvinceCenterList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreProvinceCenterCreateForm)
  }
  
  getRetailStoreProvinceCenterUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {RetailStoreProvinceCenterUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStoreProvinceCenter",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreProvinceCenterList', ref:state._retailStoreCountryCenter, listDisplayName: '双链小超省中心列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreProvinceCenterList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreProvinceCenterUpdateForm)
  }

  getRetailStoreSearch = () => {
    const {RetailStoreSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "双链小超",
      role: "retailStore",
      data: state._retailStoreCountryCenter.retailStoreList,
      metaInfo: state._retailStoreCountryCenter.retailStoreListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.retailStoreCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'retailStoreCountryCenter', 
      listName: 'retailStoreList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '双链小超列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreSearch)
  }
  getRetailStoreCreateForm = () => {
   	const {RetailStoreCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "retailStore",
      data: state._retailStoreCountryCenter.retailStoreList,
      metaInfo: state._retailStoreCountryCenter.retailStoreListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.retailStoreCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'retailStoreCountryCenter', listName: 'retailStoreList', ref:state._retailStoreCountryCenter, listDisplayName: '双链小超列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.retailStoreCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'retailStoreCountryCenter', listName: 'retailStoreList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreCreateForm)
  }
  
  getRetailStoreUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {RetailStoreUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStore",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreList', ref:state._retailStoreCountryCenter, listDisplayName: '双链小超列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreUpdateForm)
  }

  getRetailStoreMemberSearch = () => {
    const {RetailStoreMemberSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "生超会员",
      role: "retailStoreMember",
      data: state._retailStoreCountryCenter.retailStoreMemberList,
      metaInfo: state._retailStoreCountryCenter.retailStoreMemberListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreMemberCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.retailStoreMemberCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreMemberSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'owner', 
      listName: 'retailStoreMemberList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '生超会员列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberSearch)
  }
  getRetailStoreMemberCreateForm = () => {
   	const {RetailStoreMemberCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreMember",
      data: state._retailStoreCountryCenter.retailStoreMemberList,
      metaInfo: state._retailStoreCountryCenter.retailStoreMemberListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreMemberCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.retailStoreMemberCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreMemberSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'retailStoreMemberList', ref:state._retailStoreCountryCenter, listDisplayName: '生超会员列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.retailStoreMemberCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreMemberSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'retailStoreMemberList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberCreateForm)
  }
  
  getRetailStoreMemberUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {RetailStoreMemberUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStoreMember",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreMemberList', ref:state._retailStoreCountryCenter, listDisplayName: '生超会员列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreMemberList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreMemberUpdateForm)
  }

  getGoodsSupplierSearch = () => {
    const {GoodsSupplierSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "产品供应商",
      role: "goodsSupplier",
      data: state._retailStoreCountryCenter.goodsSupplierList,
      metaInfo: state._retailStoreCountryCenter.goodsSupplierListMetaInfo,
      count: state._retailStoreCountryCenter.goodsSupplierCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.goodsSupplierCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.goodsSupplierSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'belongTo', 
      listName: 'goodsSupplierList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '产品供应商列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(GoodsSupplierSearch)
  }
  getGoodsSupplierCreateForm = () => {
   	const {GoodsSupplierCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "goodsSupplier",
      data: state._retailStoreCountryCenter.goodsSupplierList,
      metaInfo: state._retailStoreCountryCenter.goodsSupplierListMetaInfo,
      count: state._retailStoreCountryCenter.goodsSupplierCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.goodsSupplierCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.goodsSupplierSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'belongTo', listName: 'goodsSupplierList', ref:state._retailStoreCountryCenter, listDisplayName: '产品供应商列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.goodsSupplierCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.goodsSupplierSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'belongTo', listName: 'goodsSupplierList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(GoodsSupplierCreateForm)
  }
  
  getGoodsSupplierUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {GoodsSupplierUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "goodsSupplier",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'goodsSupplierList', ref:state._retailStoreCountryCenter, listDisplayName: '产品供应商列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'goodsSupplierList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(GoodsSupplierUpdateForm)
  }

  getSupplyOrderSearch = () => {
    const {SupplyOrderSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "供应订单",
      role: "supplyOrder",
      data: state._retailStoreCountryCenter.supplyOrderList,
      metaInfo: state._retailStoreCountryCenter.supplyOrderListMetaInfo,
      count: state._retailStoreCountryCenter.supplyOrderCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.supplyOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.supplyOrderSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'buyer', 
      listName: 'supplyOrderList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '供应订单列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SupplyOrderSearch)
  }
  getSupplyOrderCreateForm = () => {
   	const {SupplyOrderCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "supplyOrder",
      data: state._retailStoreCountryCenter.supplyOrderList,
      metaInfo: state._retailStoreCountryCenter.supplyOrderListMetaInfo,
      count: state._retailStoreCountryCenter.supplyOrderCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.supplyOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.supplyOrderSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'buyer', listName: 'supplyOrderList', ref:state._retailStoreCountryCenter, listDisplayName: '供应订单列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.supplyOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.supplyOrderSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'buyer', listName: 'supplyOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SupplyOrderCreateForm)
  }
  
  getSupplyOrderUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {SupplyOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "supplyOrder",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'supplyOrderList', ref:state._retailStoreCountryCenter, listDisplayName: '供应订单列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'supplyOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SupplyOrderUpdateForm)
  }

  getRetailStoreOrderSearch = () => {
    const {RetailStoreOrderSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "生超的订单",
      role: "retailStoreOrder",
      data: state._retailStoreCountryCenter.retailStoreOrderList,
      metaInfo: state._retailStoreCountryCenter.retailStoreOrderListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreOrderCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreOrderSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'seller', 
      listName: 'retailStoreOrderList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '生超的订单列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderSearch)
  }
  getRetailStoreOrderCreateForm = () => {
   	const {RetailStoreOrderCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreOrder",
      data: state._retailStoreCountryCenter.retailStoreOrderList,
      metaInfo: state._retailStoreCountryCenter.retailStoreOrderListMetaInfo,
      count: state._retailStoreCountryCenter.retailStoreOrderCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreOrderSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'seller', listName: 'retailStoreOrderList', ref:state._retailStoreCountryCenter, listDisplayName: '生超的订单列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.retailStoreOrderSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'seller', listName: 'retailStoreOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderCreateForm)
  }
  
  getRetailStoreOrderUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {RetailStoreOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "retailStoreOrder",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreOrderList', ref:state._retailStoreCountryCenter, listDisplayName: '生超的订单列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'retailStoreOrderList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(RetailStoreOrderUpdateForm)
  }

  getWarehouseSearch = () => {
    const {WarehouseSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "仓库",
      role: "warehouse",
      data: state._retailStoreCountryCenter.warehouseList,
      metaInfo: state._retailStoreCountryCenter.warehouseListMetaInfo,
      count: state._retailStoreCountryCenter.warehouseCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.warehouseCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.warehouseSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'owner', 
      listName: 'warehouseList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '仓库列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(WarehouseSearch)
  }
  getWarehouseCreateForm = () => {
   	const {WarehouseCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "warehouse",
      data: state._retailStoreCountryCenter.warehouseList,
      metaInfo: state._retailStoreCountryCenter.warehouseListMetaInfo,
      count: state._retailStoreCountryCenter.warehouseCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.warehouseCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.warehouseSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'warehouseList', ref:state._retailStoreCountryCenter, listDisplayName: '仓库列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.warehouseCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.warehouseSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'warehouseList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(WarehouseCreateForm)
  }
  
  getWarehouseUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {WarehouseUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "warehouse",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'warehouseList', ref:state._retailStoreCountryCenter, listDisplayName: '仓库列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'warehouseList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(WarehouseUpdateForm)
  }

  getTransportFleetSearch = () => {
    const {TransportFleetSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "运输车队",
      role: "transportFleet",
      data: state._retailStoreCountryCenter.transportFleetList,
      metaInfo: state._retailStoreCountryCenter.transportFleetListMetaInfo,
      count: state._retailStoreCountryCenter.transportFleetCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.transportFleetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.transportFleetSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'owner', 
      listName: 'transportFleetList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '运输车队列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TransportFleetSearch)
  }
  getTransportFleetCreateForm = () => {
   	const {TransportFleetCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "transportFleet",
      data: state._retailStoreCountryCenter.transportFleetList,
      metaInfo: state._retailStoreCountryCenter.transportFleetListMetaInfo,
      count: state._retailStoreCountryCenter.transportFleetCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.transportFleetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.transportFleetSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'transportFleetList', ref:state._retailStoreCountryCenter, listDisplayName: '运输车队列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.transportFleetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.transportFleetSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'owner', listName: 'transportFleetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TransportFleetCreateForm)
  }
  
  getTransportFleetUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {TransportFleetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "transportFleet",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'transportFleetList', ref:state._retailStoreCountryCenter, listDisplayName: '运输车队列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'transportFleetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TransportFleetUpdateForm)
  }

  getAccountSetSearch = () => {
    const {AccountSetSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "账套",
      role: "accountSet",
      data: state._retailStoreCountryCenter.accountSetList,
      metaInfo: state._retailStoreCountryCenter.accountSetListMetaInfo,
      count: state._retailStoreCountryCenter.accountSetCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.accountSetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.accountSetSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'countryCenter', 
      listName: 'accountSetList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '账套列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(AccountSetSearch)
  }
  getAccountSetCreateForm = () => {
   	const {AccountSetCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "accountSet",
      data: state._retailStoreCountryCenter.accountSetList,
      metaInfo: state._retailStoreCountryCenter.accountSetListMetaInfo,
      count: state._retailStoreCountryCenter.accountSetCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.accountSetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.accountSetSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'countryCenter', listName: 'accountSetList', ref:state._retailStoreCountryCenter, listDisplayName: '账套列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.accountSetCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.accountSetSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'countryCenter', listName: 'accountSetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(AccountSetCreateForm)
  }
  
  getAccountSetUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {AccountSetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "accountSet",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'accountSetList', ref:state._retailStoreCountryCenter, listDisplayName: '账套列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'accountSetList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(AccountSetUpdateForm)
  }

  getLevelOneDepartmentSearch = () => {
    const {LevelOneDepartmentSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "一级部门",
      role: "levelOneDepartment",
      data: state._retailStoreCountryCenter.levelOneDepartmentList,
      metaInfo: state._retailStoreCountryCenter.levelOneDepartmentListMetaInfo,
      count: state._retailStoreCountryCenter.levelOneDepartmentCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.levelOneDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.levelOneDepartmentSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'belongsTo', 
      listName: 'levelOneDepartmentList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '一级部门列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(LevelOneDepartmentSearch)
  }
  getLevelOneDepartmentCreateForm = () => {
   	const {LevelOneDepartmentCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "levelOneDepartment",
      data: state._retailStoreCountryCenter.levelOneDepartmentList,
      metaInfo: state._retailStoreCountryCenter.levelOneDepartmentListMetaInfo,
      count: state._retailStoreCountryCenter.levelOneDepartmentCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.levelOneDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.levelOneDepartmentSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'belongsTo', listName: 'levelOneDepartmentList', ref:state._retailStoreCountryCenter, listDisplayName: '一级部门列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.levelOneDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.levelOneDepartmentSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'belongsTo', listName: 'levelOneDepartmentList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(LevelOneDepartmentCreateForm)
  }
  
  getLevelOneDepartmentUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {LevelOneDepartmentUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "levelOneDepartment",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'levelOneDepartmentList', ref:state._retailStoreCountryCenter, listDisplayName: '一级部门列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'levelOneDepartmentList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(LevelOneDepartmentUpdateForm)
  }

  getSkillTypeSearch = () => {
    const {SkillTypeSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "技能类型",
      role: "skillType",
      data: state._retailStoreCountryCenter.skillTypeList,
      metaInfo: state._retailStoreCountryCenter.skillTypeListMetaInfo,
      count: state._retailStoreCountryCenter.skillTypeCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.skillTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.skillTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'skillTypeList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '技能类型列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SkillTypeSearch)
  }
  getSkillTypeCreateForm = () => {
   	const {SkillTypeCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "skillType",
      data: state._retailStoreCountryCenter.skillTypeList,
      metaInfo: state._retailStoreCountryCenter.skillTypeListMetaInfo,
      count: state._retailStoreCountryCenter.skillTypeCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.skillTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.skillTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'skillTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '技能类型列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.skillTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.skillTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'skillTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SkillTypeCreateForm)
  }
  
  getSkillTypeUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {SkillTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "skillType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'skillTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '技能类型列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'skillTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SkillTypeUpdateForm)
  }

  getResponsibilityTypeSearch = () => {
    const {ResponsibilityTypeSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "责任类型",
      role: "responsibilityType",
      data: state._retailStoreCountryCenter.responsibilityTypeList,
      metaInfo: state._retailStoreCountryCenter.responsibilityTypeListMetaInfo,
      count: state._retailStoreCountryCenter.responsibilityTypeCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.responsibilityTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.responsibilityTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'responsibilityTypeList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '责任类型列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ResponsibilityTypeSearch)
  }
  getResponsibilityTypeCreateForm = () => {
   	const {ResponsibilityTypeCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "responsibilityType",
      data: state._retailStoreCountryCenter.responsibilityTypeList,
      metaInfo: state._retailStoreCountryCenter.responsibilityTypeListMetaInfo,
      count: state._retailStoreCountryCenter.responsibilityTypeCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.responsibilityTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.responsibilityTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'responsibilityTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '责任类型列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.responsibilityTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.responsibilityTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'responsibilityTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ResponsibilityTypeCreateForm)
  }
  
  getResponsibilityTypeUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {ResponsibilityTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "responsibilityType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'responsibilityTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '责任类型列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'responsibilityTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(ResponsibilityTypeUpdateForm)
  }

  getTerminationReasonSearch = () => {
    const {TerminationReasonSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "雇佣终止的原因",
      role: "terminationReason",
      data: state._retailStoreCountryCenter.terminationReasonList,
      metaInfo: state._retailStoreCountryCenter.terminationReasonListMetaInfo,
      count: state._retailStoreCountryCenter.terminationReasonCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.terminationReasonCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationReasonSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'terminationReasonList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '雇佣终止的原因列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TerminationReasonSearch)
  }
  getTerminationReasonCreateForm = () => {
   	const {TerminationReasonCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "terminationReason",
      data: state._retailStoreCountryCenter.terminationReasonList,
      metaInfo: state._retailStoreCountryCenter.terminationReasonListMetaInfo,
      count: state._retailStoreCountryCenter.terminationReasonCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.terminationReasonCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationReasonSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'terminationReasonList', ref:state._retailStoreCountryCenter, listDisplayName: '雇佣终止的原因列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.terminationReasonCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationReasonSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'terminationReasonList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TerminationReasonCreateForm)
  }
  
  getTerminationReasonUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {TerminationReasonUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "terminationReason",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'terminationReasonList', ref:state._retailStoreCountryCenter, listDisplayName: '雇佣终止的原因列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'terminationReasonList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TerminationReasonUpdateForm)
  }

  getTerminationTypeSearch = () => {
    const {TerminationTypeSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "雇佣终止类型",
      role: "terminationType",
      data: state._retailStoreCountryCenter.terminationTypeList,
      metaInfo: state._retailStoreCountryCenter.terminationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.terminationTypeCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.terminationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'terminationTypeList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '雇佣终止类型列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TerminationTypeSearch)
  }
  getTerminationTypeCreateForm = () => {
   	const {TerminationTypeCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "terminationType",
      data: state._retailStoreCountryCenter.terminationTypeList,
      metaInfo: state._retailStoreCountryCenter.terminationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.terminationTypeCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.terminationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'terminationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '雇佣终止类型列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.terminationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.terminationTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'terminationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TerminationTypeCreateForm)
  }
  
  getTerminationTypeUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {TerminationTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "terminationType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'terminationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '雇佣终止类型列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'terminationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TerminationTypeUpdateForm)
  }

  getOccupationTypeSearch = () => {
    const {OccupationTypeSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "职位类型",
      role: "occupationType",
      data: state._retailStoreCountryCenter.occupationTypeList,
      metaInfo: state._retailStoreCountryCenter.occupationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.occupationTypeCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.occupationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.occupationTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'occupationTypeList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '职位类型列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(OccupationTypeSearch)
  }
  getOccupationTypeCreateForm = () => {
   	const {OccupationTypeCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "occupationType",
      data: state._retailStoreCountryCenter.occupationTypeList,
      metaInfo: state._retailStoreCountryCenter.occupationTypeListMetaInfo,
      count: state._retailStoreCountryCenter.occupationTypeCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.occupationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.occupationTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'occupationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '职位类型列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.occupationTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.occupationTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'occupationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(OccupationTypeCreateForm)
  }
  
  getOccupationTypeUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {OccupationTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "occupationType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'occupationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '职位类型列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'occupationTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(OccupationTypeUpdateForm)
  }

  getLeaveTypeSearch = () => {
    const {LeaveTypeSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "请假类型",
      role: "leaveType",
      data: state._retailStoreCountryCenter.leaveTypeList,
      metaInfo: state._retailStoreCountryCenter.leaveTypeListMetaInfo,
      count: state._retailStoreCountryCenter.leaveTypeCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.leaveTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.leaveTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'leaveTypeList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '请假类型列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(LeaveTypeSearch)
  }
  getLeaveTypeCreateForm = () => {
   	const {LeaveTypeCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "leaveType",
      data: state._retailStoreCountryCenter.leaveTypeList,
      metaInfo: state._retailStoreCountryCenter.leaveTypeListMetaInfo,
      count: state._retailStoreCountryCenter.leaveTypeCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.leaveTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.leaveTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'leaveTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '请假类型列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.leaveTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.leaveTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'leaveTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(LeaveTypeCreateForm)
  }
  
  getLeaveTypeUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {LeaveTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "leaveType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'leaveTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '请假类型列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'leaveTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(LeaveTypeUpdateForm)
  }

  getSalaryGradeSearch = () => {
    const {SalaryGradeSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "工资等级",
      role: "salaryGrade",
      data: state._retailStoreCountryCenter.salaryGradeList,
      metaInfo: state._retailStoreCountryCenter.salaryGradeListMetaInfo,
      count: state._retailStoreCountryCenter.salaryGradeCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.salaryGradeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.salaryGradeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'salaryGradeList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '工资等级列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SalaryGradeSearch)
  }
  getSalaryGradeCreateForm = () => {
   	const {SalaryGradeCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "salaryGrade",
      data: state._retailStoreCountryCenter.salaryGradeList,
      metaInfo: state._retailStoreCountryCenter.salaryGradeListMetaInfo,
      count: state._retailStoreCountryCenter.salaryGradeCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.salaryGradeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.salaryGradeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'salaryGradeList', ref:state._retailStoreCountryCenter, listDisplayName: '工资等级列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.salaryGradeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.salaryGradeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'salaryGradeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SalaryGradeCreateForm)
  }
  
  getSalaryGradeUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {SalaryGradeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "salaryGrade",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'salaryGradeList', ref:state._retailStoreCountryCenter, listDisplayName: '工资等级列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'salaryGradeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SalaryGradeUpdateForm)
  }

  getInterviewTypeSearch = () => {
    const {InterviewTypeSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "面试类型",
      role: "interviewType",
      data: state._retailStoreCountryCenter.interviewTypeList,
      metaInfo: state._retailStoreCountryCenter.interviewTypeListMetaInfo,
      count: state._retailStoreCountryCenter.interviewTypeCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.interviewTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.interviewTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'interviewTypeList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '面试类型列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(InterviewTypeSearch)
  }
  getInterviewTypeCreateForm = () => {
   	const {InterviewTypeCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "interviewType",
      data: state._retailStoreCountryCenter.interviewTypeList,
      metaInfo: state._retailStoreCountryCenter.interviewTypeListMetaInfo,
      count: state._retailStoreCountryCenter.interviewTypeCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.interviewTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.interviewTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'interviewTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '面试类型列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.interviewTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.interviewTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'interviewTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(InterviewTypeCreateForm)
  }
  
  getInterviewTypeUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {InterviewTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "interviewType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'interviewTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '面试类型列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'interviewTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(InterviewTypeUpdateForm)
  }

  getTrainingCourseTypeSearch = () => {
    const {TrainingCourseTypeSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "培训课程类型",
      role: "trainingCourseType",
      data: state._retailStoreCountryCenter.trainingCourseTypeList,
      metaInfo: state._retailStoreCountryCenter.trainingCourseTypeListMetaInfo,
      count: state._retailStoreCountryCenter.trainingCourseTypeCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.trainingCourseTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.trainingCourseTypeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'trainingCourseTypeList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '培训课程类型列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TrainingCourseTypeSearch)
  }
  getTrainingCourseTypeCreateForm = () => {
   	const {TrainingCourseTypeCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "trainingCourseType",
      data: state._retailStoreCountryCenter.trainingCourseTypeList,
      metaInfo: state._retailStoreCountryCenter.trainingCourseTypeListMetaInfo,
      count: state._retailStoreCountryCenter.trainingCourseTypeCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.trainingCourseTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.trainingCourseTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'trainingCourseTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '培训课程类型列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.trainingCourseTypeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.trainingCourseTypeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'trainingCourseTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TrainingCourseTypeCreateForm)
  }
  
  getTrainingCourseTypeUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {TrainingCourseTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "trainingCourseType",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'trainingCourseTypeList', ref:state._retailStoreCountryCenter, listDisplayName: '培训课程类型列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'trainingCourseTypeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(TrainingCourseTypeUpdateForm)
  }

  getPublicHolidaySearch = () => {
    const {PublicHolidaySearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "公共假日",
      role: "publicHoliday",
      data: state._retailStoreCountryCenter.publicHolidayList,
      metaInfo: state._retailStoreCountryCenter.publicHolidayListMetaInfo,
      count: state._retailStoreCountryCenter.publicHolidayCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.publicHolidayCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.publicHolidaySearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'publicHolidayList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '公共假日列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(PublicHolidaySearch)
  }
  getPublicHolidayCreateForm = () => {
   	const {PublicHolidayCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "publicHoliday",
      data: state._retailStoreCountryCenter.publicHolidayList,
      metaInfo: state._retailStoreCountryCenter.publicHolidayListMetaInfo,
      count: state._retailStoreCountryCenter.publicHolidayCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.publicHolidayCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.publicHolidaySearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'publicHolidayList', ref:state._retailStoreCountryCenter, listDisplayName: '公共假日列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.publicHolidayCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.publicHolidaySearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'publicHolidayList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(PublicHolidayCreateForm)
  }
  
  getPublicHolidayUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {PublicHolidayUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "publicHoliday",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'publicHolidayList', ref:state._retailStoreCountryCenter, listDisplayName: '公共假日列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'publicHolidayList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(PublicHolidayUpdateForm)
  }

  getEmployeeSearch = () => {
    const {EmployeeSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "员工",
      role: "employee",
      data: state._retailStoreCountryCenter.employeeList,
      metaInfo: state._retailStoreCountryCenter.employeeListMetaInfo,
      count: state._retailStoreCountryCenter.employeeCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.employeeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.employeeSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'employeeList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '员工列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeSearch)
  }
  getEmployeeCreateForm = () => {
   	const {EmployeeCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employee",
      data: state._retailStoreCountryCenter.employeeList,
      metaInfo: state._retailStoreCountryCenter.employeeListMetaInfo,
      count: state._retailStoreCountryCenter.employeeCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.employeeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.employeeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'employeeList', ref:state._retailStoreCountryCenter, listDisplayName: '员工列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.employeeCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.employeeSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'employeeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeCreateForm)
  }
  
  getEmployeeUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "employee",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'employeeList', ref:state._retailStoreCountryCenter, listDisplayName: '员工列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'employeeList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeUpdateForm)
  }

  getInstructorSearch = () => {
    const {InstructorSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "讲师",
      role: "instructor",
      data: state._retailStoreCountryCenter.instructorList,
      metaInfo: state._retailStoreCountryCenter.instructorListMetaInfo,
      count: state._retailStoreCountryCenter.instructorCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.instructorCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.instructorSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'instructorList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '讲师列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(InstructorSearch)
  }
  getInstructorCreateForm = () => {
   	const {InstructorCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "instructor",
      data: state._retailStoreCountryCenter.instructorList,
      metaInfo: state._retailStoreCountryCenter.instructorListMetaInfo,
      count: state._retailStoreCountryCenter.instructorCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.instructorCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.instructorSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'instructorList', ref:state._retailStoreCountryCenter, listDisplayName: '讲师列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.instructorCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.instructorSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'instructorList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(InstructorCreateForm)
  }
  
  getInstructorUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {InstructorUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "instructor",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'instructorList', ref:state._retailStoreCountryCenter, listDisplayName: '讲师列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'instructorList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(InstructorUpdateForm)
  }

  getCompanyTrainingSearch = () => {
    const {CompanyTrainingSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "公司培训",
      role: "companyTraining",
      data: state._retailStoreCountryCenter.companyTrainingList,
      metaInfo: state._retailStoreCountryCenter.companyTrainingListMetaInfo,
      count: state._retailStoreCountryCenter.companyTrainingCount,
<<<<<<< HEAD
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._retailStoreCountryCenter.companyTrainingCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.companyTrainingSearchFormParameters,
      searchParameters: {...state._retailStoreCountryCenter.searchParameters},
      expandForm: state._retailStoreCountryCenter.expandForm,
      loading: state._retailStoreCountryCenter.loading,
      partialList: state._retailStoreCountryCenter.partialList,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, 
      referenceName: 'company', 
      listName: 'companyTrainingList', ref:state._retailStoreCountryCenter, 
<<<<<<< HEAD
      listDisplayName: '公司培训列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(CompanyTrainingSearch)
  }
  getCompanyTrainingCreateForm = () => {
   	const {CompanyTrainingCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "companyTraining",
      data: state._retailStoreCountryCenter.companyTrainingList,
      metaInfo: state._retailStoreCountryCenter.companyTrainingListMetaInfo,
      count: state._retailStoreCountryCenter.companyTrainingCount,
<<<<<<< HEAD
      currentPage: state._retailStoreCountryCenter.companyTrainingCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.companyTrainingSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'companyTrainingList', ref:state._retailStoreCountryCenter, listDisplayName: '公司培训列表'}, // this is for model namespace and
=======
      returnURL: `/retailStoreCountryCenter/${state._retailStoreCountryCenter.id}/list`,
      currentPage: state._retailStoreCountryCenter.companyTrainingCurrentPageNumber,
      searchFormParameters: state._retailStoreCountryCenter.companyTrainingSearchFormParameters,
      loading: state._retailStoreCountryCenter.loading,
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, referenceName: 'company', listName: 'companyTrainingList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(CompanyTrainingCreateForm)
  }
  
  getCompanyTrainingUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {CompanyTrainingUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreCountryCenter.selectedRows,
      role: "companyTraining",
      currentUpdateIndex: state._retailStoreCountryCenter.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'companyTrainingList', ref:state._retailStoreCountryCenter, listDisplayName: '公司培训列表' }, // this is for model namespace and
=======
      owner: { type: '_retailStoreCountryCenter', id: state._retailStoreCountryCenter.id, listName: 'companyTrainingList', ref:state._retailStoreCountryCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(CompanyTrainingUpdateForm)
  }


  
  buildRouters = () =>{
  	const {RetailStoreCountryCenterDashboard} = GlobalComponents
<<<<<<< HEAD
  	const {RetailStoreCountryCenterPreference} = GlobalComponents
=======
  	const {RetailStoreCountryCenterPermission} = GlobalComponents
  	const {RetailStoreCountryCenterProfile} = GlobalComponents
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	const routers=[
  	{path:"/retailStoreCountryCenter/:id/dashboard", component: RetailStoreCountryCenterDashboard},
<<<<<<< HEAD
  	{path:"/retailStoreCountryCenter/:id/preference", component: RetailStoreCountryCenterPreference},
=======
  	{path:"/retailStoreCountryCenter/:id/profile", component: RetailStoreCountryCenterProfile},
  	{path:"/retailStoreCountryCenter/:id/permission", component: RetailStoreCountryCenterPermission},
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	
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
<<<<<<< HEAD
     const { breadcrumb }  = this.props

     //const {RetailStoreCountryCenterEditDetail} = GlobalComponents
     //const {RetailStoreCountryCenterViewDetail} = GlobalComponents
     
     
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

		 {this.getNavMenuItems(this.props.retailStoreCountryCenter)}
		 
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
            <Dropdown overlay= {this.getNavMenuItems(this.props.retailStoreCountryCenter)}>
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
  retailStoreCountryCenter: state._retailStoreCountryCenter,
  ...state,
}))(RetailStoreCountryCenterBizApp)



