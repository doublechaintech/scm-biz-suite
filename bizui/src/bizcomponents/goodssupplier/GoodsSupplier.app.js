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
import styles from './GoodsSupplier.app.less'
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




class GoodsSupplierBizApp extends React.PureComponent {
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
      return ['/goodsSupplier/']
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
               <Link to={`/goodsSupplier/${this.props.goodsSupplier.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
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
               <Link to={`/goodsSupplier/${this.props.goodsSupplier.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
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
               <Link to={`/goodsSupplier/${this.props.goodsSupplier.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getSupplierProductSearch = () => {
    const {SupplierProductSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "供应商的产品",
      role: "supplierProduct",
      data: state._goodsSupplier.supplierProductList,
      metaInfo: state._goodsSupplier.supplierProductListMetaInfo,
      count: state._goodsSupplier.supplierProductCount,
<<<<<<< HEAD
=======
      returnURL: `/goodsSupplier/${state._goodsSupplier.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._goodsSupplier.supplierProductCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.supplierProductSearchFormParameters,
      searchParameters: {...state._goodsSupplier.searchParameters},
      expandForm: state._goodsSupplier.expandForm,
      loading: state._goodsSupplier.loading,
      partialList: state._goodsSupplier.partialList,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, 
      referenceName: 'supplier', 
      listName: 'supplierProductList', ref:state._goodsSupplier, 
<<<<<<< HEAD
      listDisplayName: '供应商的产品列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SupplierProductSearch)
  }
  getSupplierProductCreateForm = () => {
   	const {SupplierProductCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "supplierProduct",
      data: state._goodsSupplier.supplierProductList,
      metaInfo: state._goodsSupplier.supplierProductListMetaInfo,
      count: state._goodsSupplier.supplierProductCount,
<<<<<<< HEAD
      currentPage: state._goodsSupplier.supplierProductCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.supplierProductSearchFormParameters,
      loading: state._goodsSupplier.loading,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, referenceName: 'supplier', listName: 'supplierProductList', ref:state._goodsSupplier, listDisplayName: '供应商的产品列表'}, // this is for model namespace and
=======
      returnURL: `/goodsSupplier/${state._goodsSupplier.id}/list`,
      currentPage: state._goodsSupplier.supplierProductCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.supplierProductSearchFormParameters,
      loading: state._goodsSupplier.loading,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, referenceName: 'supplier', listName: 'supplierProductList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SupplierProductCreateForm)
  }
  
  getSupplierProductUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {SupplierProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._goodsSupplier.selectedRows,
      role: "supplierProduct",
      currentUpdateIndex: state._goodsSupplier.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, listName: 'supplierProductList', ref:state._goodsSupplier, listDisplayName: '供应商的产品列表' }, // this is for model namespace and
=======
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, listName: 'supplierProductList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SupplierProductUpdateForm)
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
      data: state._goodsSupplier.supplyOrderList,
      metaInfo: state._goodsSupplier.supplyOrderListMetaInfo,
      count: state._goodsSupplier.supplyOrderCount,
<<<<<<< HEAD
=======
      returnURL: `/goodsSupplier/${state._goodsSupplier.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._goodsSupplier.supplyOrderCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.supplyOrderSearchFormParameters,
      searchParameters: {...state._goodsSupplier.searchParameters},
      expandForm: state._goodsSupplier.expandForm,
      loading: state._goodsSupplier.loading,
      partialList: state._goodsSupplier.partialList,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, 
      referenceName: 'seller', 
      listName: 'supplyOrderList', ref:state._goodsSupplier, 
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
      data: state._goodsSupplier.supplyOrderList,
      metaInfo: state._goodsSupplier.supplyOrderListMetaInfo,
      count: state._goodsSupplier.supplyOrderCount,
<<<<<<< HEAD
      currentPage: state._goodsSupplier.supplyOrderCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.supplyOrderSearchFormParameters,
      loading: state._goodsSupplier.loading,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, referenceName: 'seller', listName: 'supplyOrderList', ref:state._goodsSupplier, listDisplayName: '供应订单列表'}, // this is for model namespace and
=======
      returnURL: `/goodsSupplier/${state._goodsSupplier.id}/list`,
      currentPage: state._goodsSupplier.supplyOrderCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.supplyOrderSearchFormParameters,
      loading: state._goodsSupplier.loading,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, referenceName: 'seller', listName: 'supplyOrderList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
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
      selectedRows: state._goodsSupplier.selectedRows,
      role: "supplyOrder",
      currentUpdateIndex: state._goodsSupplier.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, listName: 'supplyOrderList', ref:state._goodsSupplier, listDisplayName: '供应订单列表' }, // this is for model namespace and
=======
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, listName: 'supplyOrderList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(SupplyOrderUpdateForm)
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
      data: state._goodsSupplier.accountSetList,
      metaInfo: state._goodsSupplier.accountSetListMetaInfo,
      count: state._goodsSupplier.accountSetCount,
<<<<<<< HEAD
=======
      returnURL: `/goodsSupplier/${state._goodsSupplier.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._goodsSupplier.accountSetCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.accountSetSearchFormParameters,
      searchParameters: {...state._goodsSupplier.searchParameters},
      expandForm: state._goodsSupplier.expandForm,
      loading: state._goodsSupplier.loading,
      partialList: state._goodsSupplier.partialList,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, 
      referenceName: 'goodsSupplier', 
      listName: 'accountSetList', ref:state._goodsSupplier, 
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
      data: state._goodsSupplier.accountSetList,
      metaInfo: state._goodsSupplier.accountSetListMetaInfo,
      count: state._goodsSupplier.accountSetCount,
<<<<<<< HEAD
      currentPage: state._goodsSupplier.accountSetCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.accountSetSearchFormParameters,
      loading: state._goodsSupplier.loading,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, referenceName: 'goodsSupplier', listName: 'accountSetList', ref:state._goodsSupplier, listDisplayName: '账套列表'}, // this is for model namespace and
=======
      returnURL: `/goodsSupplier/${state._goodsSupplier.id}/list`,
      currentPage: state._goodsSupplier.accountSetCurrentPageNumber,
      searchFormParameters: state._goodsSupplier.accountSetSearchFormParameters,
      loading: state._goodsSupplier.loading,
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, referenceName: 'goodsSupplier', listName: 'accountSetList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
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
      selectedRows: state._goodsSupplier.selectedRows,
      role: "accountSet",
      currentUpdateIndex: state._goodsSupplier.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, listName: 'accountSetList', ref:state._goodsSupplier, listDisplayName: '账套列表' }, // this is for model namespace and
=======
      owner: { type: '_goodsSupplier', id: state._goodsSupplier.id, listName: 'accountSetList', ref:state._goodsSupplier, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(AccountSetUpdateForm)
  }


  
  buildRouters = () =>{
  	const {GoodsSupplierDashboard} = GlobalComponents
<<<<<<< HEAD
  	const {GoodsSupplierPreference} = GlobalComponents
=======
  	const {GoodsSupplierPermission} = GlobalComponents
  	const {GoodsSupplierProfile} = GlobalComponents
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	const routers=[
  	{path:"/goodsSupplier/:id/dashboard", component: GoodsSupplierDashboard},
<<<<<<< HEAD
  	{path:"/goodsSupplier/:id/preference", component: GoodsSupplierPreference},
=======
  	{path:"/goodsSupplier/:id/profile", component: GoodsSupplierProfile},
  	{path:"/goodsSupplier/:id/permission", component: GoodsSupplierPermission},
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	
  	{path:"/goodsSupplier/:id/list/supplierProductList", component: this.getSupplierProductSearch()},
  	{path:"/goodsSupplier/:id/list/supplierProductCreateForm", component: this.getSupplierProductCreateForm()},
  	{path:"/goodsSupplier/:id/list/supplierProductUpdateForm", component: this.getSupplierProductUpdateForm()},
   	
  	{path:"/goodsSupplier/:id/list/supplyOrderList", component: this.getSupplyOrderSearch()},
  	{path:"/goodsSupplier/:id/list/supplyOrderCreateForm", component: this.getSupplyOrderCreateForm()},
  	{path:"/goodsSupplier/:id/list/supplyOrderUpdateForm", component: this.getSupplyOrderUpdateForm()},
   	
  	{path:"/goodsSupplier/:id/list/accountSetList", component: this.getAccountSetSearch()},
  	{path:"/goodsSupplier/:id/list/accountSetCreateForm", component: this.getAccountSetCreateForm()},
  	{path:"/goodsSupplier/:id/list/accountSetUpdateForm", component: this.getAccountSetUpdateForm()},
     	
  	
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

     //const {GoodsSupplierEditDetail} = GlobalComponents
     //const {GoodsSupplierViewDetail} = GlobalComponents
     
     
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

		 {this.getNavMenuItems(this.props.goodsSupplier)}
		 
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
            <Dropdown overlay= {this.getNavMenuItems(this.props.goodsSupplier)}>
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
  goodsSupplier: state._goodsSupplier,
  ...state,
}))(GoodsSupplierBizApp)



