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
  Input,Button
} from 'antd'
import TopMenu from '../../launcher/TopMenu'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './RetailStore.app.less'
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




class RetailStoreBizApp extends React.PureComponent {
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
      return ['/retailStore/']
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
        style={{ width: '256px' }}
       >
           

             <Menu.Item key="dashboard">
               <Link to={`/retailStore/${this.props.retailStore.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		
        
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
      data: state._retailStore.consumerOrderList,
      metaInfo: state._retailStore.consumerOrderListMetaInfo,
      count: state._retailStore.consumerOrderCount,
      returnURL: `/retailStore/${state._retailStore.id}/dashboard`,
      currentPage: state._retailStore.consumerOrderCurrentPageNumber,
      searchFormParameters: state._retailStore.consumerOrderSearchFormParameters,
      searchParameters: {...state._retailStore.searchParameters},
      expandForm: state._retailStore.expandForm,
      loading: state._retailStore.loading,
      partialList: state._retailStore.partialList,
      owner: { type: '_retailStore', id: state._retailStore.id, 
      referenceName: 'store', 
      listName: 'consumerOrderList', ref:state._retailStore, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderSearch)
  }
  getConsumerOrderCreateForm = () => {
   	const {ConsumerOrderCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "consumerOrder",
      data: state._retailStore.consumerOrderList,
      metaInfo: state._retailStore.consumerOrderListMetaInfo,
      count: state._retailStore.consumerOrderCount,
      returnURL: `/retailStore/${state._retailStore.id}/list`,
      currentPage: state._retailStore.consumerOrderCurrentPageNumber,
      searchFormParameters: state._retailStore.consumerOrderSearchFormParameters,
      loading: state._retailStore.loading,
      owner: { type: '_retailStore', id: state._retailStore.id, referenceName: 'store', listName: 'consumerOrderList', ref:state._retailStore, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ConsumerOrderCreateForm)
  }
  
  getConsumerOrderUpdateForm = () => {
    const userContext = null
  	const {ConsumerOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStore.selectedRows,
      role: "consumerOrder",
      currentUpdateIndex: state._retailStore.currentUpdateIndex,
      owner: { type: '_retailStore', id: state._retailStore.id, listName: 'consumerOrderList', ref:state._retailStore, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ConsumerOrderUpdateForm)
  }

  getRetailStoreOrderSearch = () => {
    const {RetailStoreOrderSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "生超的订单",
      role: "retailStoreOrder",
      data: state._retailStore.retailStoreOrderList,
      metaInfo: state._retailStore.retailStoreOrderListMetaInfo,
      count: state._retailStore.retailStoreOrderCount,
      returnURL: `/retailStore/${state._retailStore.id}/dashboard`,
      currentPage: state._retailStore.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStore.retailStoreOrderSearchFormParameters,
      searchParameters: {...state._retailStore.searchParameters},
      expandForm: state._retailStore.expandForm,
      loading: state._retailStore.loading,
      partialList: state._retailStore.partialList,
      owner: { type: '_retailStore', id: state._retailStore.id, 
      referenceName: 'buyer', 
      listName: 'retailStoreOrderList', ref:state._retailStore, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderSearch)
  }
  getRetailStoreOrderCreateForm = () => {
   	const {RetailStoreOrderCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreOrder",
      data: state._retailStore.retailStoreOrderList,
      metaInfo: state._retailStore.retailStoreOrderListMetaInfo,
      count: state._retailStore.retailStoreOrderCount,
      returnURL: `/retailStore/${state._retailStore.id}/list`,
      currentPage: state._retailStore.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStore.retailStoreOrderSearchFormParameters,
      loading: state._retailStore.loading,
      owner: { type: '_retailStore', id: state._retailStore.id, referenceName: 'buyer', listName: 'retailStoreOrderList', ref:state._retailStore, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreOrderCreateForm)
  }
  
  getRetailStoreOrderUpdateForm = () => {
    const userContext = null
  	const {RetailStoreOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStore.selectedRows,
      role: "retailStoreOrder",
      currentUpdateIndex: state._retailStore.currentUpdateIndex,
      owner: { type: '_retailStore', id: state._retailStore.id, listName: 'retailStoreOrderList', ref:state._retailStore, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderUpdateForm)
  }

  getGoodsSearch = () => {
    const {GoodsSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "货物",
      role: "goods",
      data: state._retailStore.goodsList,
      metaInfo: state._retailStore.goodsListMetaInfo,
      count: state._retailStore.goodsCount,
      returnURL: `/retailStore/${state._retailStore.id}/dashboard`,
      currentPage: state._retailStore.goodsCurrentPageNumber,
      searchFormParameters: state._retailStore.goodsSearchFormParameters,
      searchParameters: {...state._retailStore.searchParameters},
      expandForm: state._retailStore.expandForm,
      loading: state._retailStore.loading,
      partialList: state._retailStore.partialList,
      owner: { type: '_retailStore', id: state._retailStore.id, 
      referenceName: 'retailStore', 
      listName: 'goodsList', ref:state._retailStore, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsSearch)
  }
  getGoodsCreateForm = () => {
   	const {GoodsCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "goods",
      data: state._retailStore.goodsList,
      metaInfo: state._retailStore.goodsListMetaInfo,
      count: state._retailStore.goodsCount,
      returnURL: `/retailStore/${state._retailStore.id}/list`,
      currentPage: state._retailStore.goodsCurrentPageNumber,
      searchFormParameters: state._retailStore.goodsSearchFormParameters,
      loading: state._retailStore.loading,
      owner: { type: '_retailStore', id: state._retailStore.id, referenceName: 'retailStore', listName: 'goodsList', ref:state._retailStore, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(GoodsCreateForm)
  }
  
  getGoodsUpdateForm = () => {
    const userContext = null
  	const {GoodsUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStore.selectedRows,
      role: "goods",
      currentUpdateIndex: state._retailStore.currentUpdateIndex,
      owner: { type: '_retailStore', id: state._retailStore.id, listName: 'goodsList', ref:state._retailStore, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsUpdateForm)
  }

  getTransportTaskSearch = () => {
    const {TransportTaskSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "运输任务",
      role: "transportTask",
      data: state._retailStore.transportTaskList,
      metaInfo: state._retailStore.transportTaskListMetaInfo,
      count: state._retailStore.transportTaskCount,
      returnURL: `/retailStore/${state._retailStore.id}/dashboard`,
      currentPage: state._retailStore.transportTaskCurrentPageNumber,
      searchFormParameters: state._retailStore.transportTaskSearchFormParameters,
      searchParameters: {...state._retailStore.searchParameters},
      expandForm: state._retailStore.expandForm,
      loading: state._retailStore.loading,
      partialList: state._retailStore.partialList,
      owner: { type: '_retailStore', id: state._retailStore.id, 
      referenceName: 'end', 
      listName: 'transportTaskList', ref:state._retailStore, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransportTaskSearch)
  }
  getTransportTaskCreateForm = () => {
   	const {TransportTaskCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "transportTask",
      data: state._retailStore.transportTaskList,
      metaInfo: state._retailStore.transportTaskListMetaInfo,
      count: state._retailStore.transportTaskCount,
      returnURL: `/retailStore/${state._retailStore.id}/list`,
      currentPage: state._retailStore.transportTaskCurrentPageNumber,
      searchFormParameters: state._retailStore.transportTaskSearchFormParameters,
      loading: state._retailStore.loading,
      owner: { type: '_retailStore', id: state._retailStore.id, referenceName: 'end', listName: 'transportTaskList', ref:state._retailStore, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TransportTaskCreateForm)
  }
  
  getTransportTaskUpdateForm = () => {
    const userContext = null
  	const {TransportTaskUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStore.selectedRows,
      role: "transportTask",
      currentUpdateIndex: state._retailStore.currentUpdateIndex,
      owner: { type: '_retailStore', id: state._retailStore.id, listName: 'transportTaskList', ref:state._retailStore, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransportTaskUpdateForm)
  }

  getAccountSetSearch = () => {
    const {AccountSetSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "账套",
      role: "accountSet",
      data: state._retailStore.accountSetList,
      metaInfo: state._retailStore.accountSetListMetaInfo,
      count: state._retailStore.accountSetCount,
      returnURL: `/retailStore/${state._retailStore.id}/dashboard`,
      currentPage: state._retailStore.accountSetCurrentPageNumber,
      searchFormParameters: state._retailStore.accountSetSearchFormParameters,
      searchParameters: {...state._retailStore.searchParameters},
      expandForm: state._retailStore.expandForm,
      loading: state._retailStore.loading,
      partialList: state._retailStore.partialList,
      owner: { type: '_retailStore', id: state._retailStore.id, 
      referenceName: 'retailStore', 
      listName: 'accountSetList', ref:state._retailStore, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountSetSearch)
  }
  getAccountSetCreateForm = () => {
   	const {AccountSetCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "accountSet",
      data: state._retailStore.accountSetList,
      metaInfo: state._retailStore.accountSetListMetaInfo,
      count: state._retailStore.accountSetCount,
      returnURL: `/retailStore/${state._retailStore.id}/list`,
      currentPage: state._retailStore.accountSetCurrentPageNumber,
      searchFormParameters: state._retailStore.accountSetSearchFormParameters,
      loading: state._retailStore.loading,
      owner: { type: '_retailStore', id: state._retailStore.id, referenceName: 'retailStore', listName: 'accountSetList', ref:state._retailStore, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AccountSetCreateForm)
  }
  
  getAccountSetUpdateForm = () => {
    const userContext = null
  	const {AccountSetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStore.selectedRows,
      role: "accountSet",
      currentUpdateIndex: state._retailStore.currentUpdateIndex,
      owner: { type: '_retailStore', id: state._retailStore.id, listName: 'accountSetList', ref:state._retailStore, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountSetUpdateForm)
  }


  
  buildRouters = () =>{
  	const {RetailStoreDashboard} = GlobalComponents
  	const {RetailStorePermission} = GlobalComponents
  	const {RetailStoreProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/retailStore/:id/dashboard", component: RetailStoreDashboard},
  	{path:"/retailStore/:id/profile", component: RetailStoreProfile},
  	{path:"/retailStore/:id/permission", component: RetailStorePermission},
  	
  	
  	
  	{path:"/retailStore/:id/list/consumerOrderList", component: this.getConsumerOrderSearch()},
  	{path:"/retailStore/:id/list/consumerOrderCreateForm", component: this.getConsumerOrderCreateForm()},
  	{path:"/retailStore/:id/list/consumerOrderUpdateForm", component: this.getConsumerOrderUpdateForm()},
   	
  	{path:"/retailStore/:id/list/retailStoreOrderList", component: this.getRetailStoreOrderSearch()},
  	{path:"/retailStore/:id/list/retailStoreOrderCreateForm", component: this.getRetailStoreOrderCreateForm()},
  	{path:"/retailStore/:id/list/retailStoreOrderUpdateForm", component: this.getRetailStoreOrderUpdateForm()},
   	
  	{path:"/retailStore/:id/list/goodsList", component: this.getGoodsSearch()},
  	{path:"/retailStore/:id/list/goodsCreateForm", component: this.getGoodsCreateForm()},
  	{path:"/retailStore/:id/list/goodsUpdateForm", component: this.getGoodsUpdateForm()},
   	
  	{path:"/retailStore/:id/list/transportTaskList", component: this.getTransportTaskSearch()},
  	{path:"/retailStore/:id/list/transportTaskCreateForm", component: this.getTransportTaskCreateForm()},
  	{path:"/retailStore/:id/list/transportTaskUpdateForm", component: this.getTransportTaskUpdateForm()},
   	
  	{path:"/retailStore/:id/list/accountSetList", component: this.getAccountSetSearch()},
  	{path:"/retailStore/:id/list/accountSetCreateForm", component: this.getAccountSetCreateForm()},
  	{path:"/retailStore/:id/list/accountSetUpdateForm", component: this.getAccountSetUpdateForm()},
     	
  	
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
 <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          
        <Row type="flex" justify="start" align="bottom">
        
        <Col {...naviBarResponsiveStyle} >
            <Dropdown overlay= {this.getNavMenuItems(this.props.retailStore)}>
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
       <Layout style={{  marginTop: 44 }}>
       
         
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
  retailStore: state._retailStore,
  ...state,
}))(RetailStoreBizApp)



