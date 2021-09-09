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
import styles from './RetailStoreOrder.app.less'
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





class RetailStoreOrderBizApp extends React.PureComponent {
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
        <Link to={`/retailStoreOrder/${this.props.retailStoreOrder.id}/workbench`}><Icon type="solution" style={{marginRight:"20px"}}/><span>工作台</span></Link>
      </Menu.Item>

        
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu id={`submenu-vg${index}`}  key={`vg${index}`} title={<span><Icon type={viewGroupIconNameOf('retail_store_order',`${groupedMenuItem.viewGroup}`)} style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
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



  getRetailStoreOrderLineItemSearch = () => {
    const {RetailStoreOrderLineItemSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store_order_line_item','retail_store_order.retail_store_order_line_item_list',false),
      role: "retailStoreOrderLineItem",
      data: state._retailStoreOrder.retailStoreOrderLineItemList,
      metaInfo: state._retailStoreOrder.retailStoreOrderLineItemListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderLineItemCount,
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/workbench`,
      currentPage: state._retailStoreOrder.retailStoreOrderLineItemCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderLineItemSearchFormParameters,
      searchParameters: {...state._retailStoreOrder.searchParameters},
      expandForm: state._retailStoreOrder.expandForm,
      loading: state._retailStoreOrder.loading,
      partialList: state._retailStoreOrder.partialList,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id,
      referenceName: 'bizOrder',
      listName: 'retailStoreOrderLineItemList', ref:state._retailStoreOrder,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderLineItemSearch)
  }

  getRetailStoreOrderLineItemCreateForm = () => {
   	const {RetailStoreOrderLineItemCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "retailStoreOrderLineItem",
      data: state._retailStoreOrder.retailStoreOrderLineItemList,
      metaInfo: state._retailStoreOrder.retailStoreOrderLineItemListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderLineItemCount,
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/list`,
      currentPage: state._retailStoreOrder.retailStoreOrderLineItemCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderLineItemSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id || this.getOwnerId(), referenceName: 'bizOrder', listName: 'retailStoreOrderLineItemList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreOrderLineItemCreateForm)
  }

  getRetailStoreOrderLineItemUpdateForm = () => {
    const userContext = null
  	const {RetailStoreOrderLineItemUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreOrder.selectedRows,
      role: "retailStoreOrderLineItem",
      currentUpdateIndex: state._retailStoreOrder.currentUpdateIndex || 0,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id || this.getOwnerId(), listName: 'retailStoreOrderLineItemList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderLineItemUpdateForm)
  }

  getRetailStoreOrderShippingGroupSearch = () => {
    const {RetailStoreOrderShippingGroupSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store_order_shipping_group','retail_store_order.retail_store_order_shipping_group_list',false),
      role: "retailStoreOrderShippingGroup",
      data: state._retailStoreOrder.retailStoreOrderShippingGroupList,
      metaInfo: state._retailStoreOrder.retailStoreOrderShippingGroupListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderShippingGroupCount,
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/workbench`,
      currentPage: state._retailStoreOrder.retailStoreOrderShippingGroupCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderShippingGroupSearchFormParameters,
      searchParameters: {...state._retailStoreOrder.searchParameters},
      expandForm: state._retailStoreOrder.expandForm,
      loading: state._retailStoreOrder.loading,
      partialList: state._retailStoreOrder.partialList,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id,
      referenceName: 'bizOrder',
      listName: 'retailStoreOrderShippingGroupList', ref:state._retailStoreOrder,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderShippingGroupSearch)
  }

  getRetailStoreOrderShippingGroupCreateForm = () => {
   	const {RetailStoreOrderShippingGroupCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "retailStoreOrderShippingGroup",
      data: state._retailStoreOrder.retailStoreOrderShippingGroupList,
      metaInfo: state._retailStoreOrder.retailStoreOrderShippingGroupListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderShippingGroupCount,
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/list`,
      currentPage: state._retailStoreOrder.retailStoreOrderShippingGroupCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderShippingGroupSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id || this.getOwnerId(), referenceName: 'bizOrder', listName: 'retailStoreOrderShippingGroupList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreOrderShippingGroupCreateForm)
  }

  getRetailStoreOrderShippingGroupUpdateForm = () => {
    const userContext = null
  	const {RetailStoreOrderShippingGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreOrder.selectedRows,
      role: "retailStoreOrderShippingGroup",
      currentUpdateIndex: state._retailStoreOrder.currentUpdateIndex || 0,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id || this.getOwnerId(), listName: 'retailStoreOrderShippingGroupList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderShippingGroupUpdateForm)
  }

  getRetailStoreOrderPaymentGroupSearch = () => {
    const {RetailStoreOrderPaymentGroupSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store_order_payment_group','retail_store_order.retail_store_order_payment_group_list',false),
      role: "retailStoreOrderPaymentGroup",
      data: state._retailStoreOrder.retailStoreOrderPaymentGroupList,
      metaInfo: state._retailStoreOrder.retailStoreOrderPaymentGroupListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderPaymentGroupCount,
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/workbench`,
      currentPage: state._retailStoreOrder.retailStoreOrderPaymentGroupCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderPaymentGroupSearchFormParameters,
      searchParameters: {...state._retailStoreOrder.searchParameters},
      expandForm: state._retailStoreOrder.expandForm,
      loading: state._retailStoreOrder.loading,
      partialList: state._retailStoreOrder.partialList,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id,
      referenceName: 'bizOrder',
      listName: 'retailStoreOrderPaymentGroupList', ref:state._retailStoreOrder,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderPaymentGroupSearch)
  }

  getRetailStoreOrderPaymentGroupCreateForm = () => {
   	const {RetailStoreOrderPaymentGroupCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "retailStoreOrderPaymentGroup",
      data: state._retailStoreOrder.retailStoreOrderPaymentGroupList,
      metaInfo: state._retailStoreOrder.retailStoreOrderPaymentGroupListMetaInfo,
      count: state._retailStoreOrder.retailStoreOrderPaymentGroupCount,
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/list`,
      currentPage: state._retailStoreOrder.retailStoreOrderPaymentGroupCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.retailStoreOrderPaymentGroupSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id || this.getOwnerId(), referenceName: 'bizOrder', listName: 'retailStoreOrderPaymentGroupList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreOrderPaymentGroupCreateForm)
  }

  getRetailStoreOrderPaymentGroupUpdateForm = () => {
    const userContext = null
  	const {RetailStoreOrderPaymentGroupUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreOrder.selectedRows,
      role: "retailStoreOrderPaymentGroup",
      currentUpdateIndex: state._retailStoreOrder.currentUpdateIndex || 0,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id || this.getOwnerId(), listName: 'retailStoreOrderPaymentGroupList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderPaymentGroupUpdateForm)
  }

  getGoodsSearch = () => {
    const {GoodsSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('goods','retail_store_order.goods_list',false),
      role: "goods",
      data: state._retailStoreOrder.goodsList,
      metaInfo: state._retailStoreOrder.goodsListMetaInfo,
      count: state._retailStoreOrder.goodsCount,
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/workbench`,
      currentPage: state._retailStoreOrder.goodsCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.goodsSearchFormParameters,
      searchParameters: {...state._retailStoreOrder.searchParameters},
      expandForm: state._retailStoreOrder.expandForm,
      loading: state._retailStoreOrder.loading,
      partialList: state._retailStoreOrder.partialList,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id,
      referenceName: 'retailStoreOrder',
      listName: 'goodsList', ref:state._retailStoreOrder,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsSearch)
  }

  getGoodsCreateForm = () => {
   	const {GoodsCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "goods",
      data: state._retailStoreOrder.goodsList,
      metaInfo: state._retailStoreOrder.goodsListMetaInfo,
      count: state._retailStoreOrder.goodsCount,
      returnURL: `/retailStoreOrder/${state._retailStoreOrder.id}/list`,
      currentPage: state._retailStoreOrder.goodsCurrentPageNumber,
      searchFormParameters: state._retailStoreOrder.goodsSearchFormParameters,
      loading: state._retailStoreOrder.loading,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id || this.getOwnerId(), referenceName: 'retailStoreOrder', listName: 'goodsList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(GoodsCreateForm)
  }

  getGoodsUpdateForm = () => {
    const userContext = null
  	const {GoodsUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreOrder.selectedRows,
      role: "goods",
      currentUpdateIndex: state._retailStoreOrder.currentUpdateIndex || 0,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id || this.getOwnerId(), listName: 'goodsList', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsUpdateForm)
  }


  getRequestTypeStepForm = () => {
    const userContext = null
  	 const {ChangeRequestStepForm} = GlobalComponents
    return connect(state => ({
      selectedRows: state._retailStoreOrder.selectedRows,
      role: "cq",
      currentUpdateIndex: state._retailStoreOrder.currentUpdateIndex,
      owner: { type: '_retailStoreOrder', id: state._retailStoreOrder.id, listName: 'nolist', ref:state._retailStoreOrder, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestStepForm)
  }



  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '双链小超全流程供应链系统'
    return title
  }

  buildRouters = () =>{
    const {RetailStoreOrderWorkbench} = GlobalComponents

    const {RetailStoreOrderDashboard} = GlobalComponents
  	const {RetailStoreOrderPermission} = GlobalComponents
  	const {RetailStoreOrderProfile} = GlobalComponents


    const routers=[
    {path:"/retailStoreOrder/:id/workbench", component: RetailStoreOrderWorkbench},
    {path:"/retailStoreOrder/:id/dashboard", component: RetailStoreOrderDashboard},
  	{path:"/retailStoreOrder/:id/profile", component: RetailStoreOrderProfile},
  	{path:"/retailStoreOrder/:id/permission", component: RetailStoreOrderPermission},



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

    const {searchLocalData}=GlobalComponents.RetailStoreOrderBase

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

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.retailStoreOrder,this.state.searchKeyword)}</div>

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

         {this.getNavMenuItems(this.props.retailStoreOrder,"inline","dark")}

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
  retailStoreOrder: state._retailStoreOrder,
  ...state,
}))(RetailStoreOrderBizApp)



