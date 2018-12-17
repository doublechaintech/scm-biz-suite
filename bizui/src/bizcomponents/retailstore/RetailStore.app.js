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
import styles from './RetailStore.app.less'
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




class RetailStoreBizApp extends React.PureComponent {
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
  
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/retailStore/${this.props.retailStore.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
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
               <Link to={`/retailStore/${this.props.retailStore.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getConsumerOrderSearch = () => {
    const {ConsumerOrderSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "消费者订单",
      role: "consumerOrder",
      data: state._retailStore.consumerOrderList,
      metaInfo: state._retailStore.consumerOrderListMetaInfo,
      count: state._retailStore.consumerOrderCount,
      currentPage: state._retailStore.consumerOrderCurrentPageNumber,
      searchFormParameters: state._retailStore.consumerOrderSearchFormParameters,
      searchParameters: {...state._retailStore.searchParameters},
      expandForm: state._retailStore.expandForm,
      loading: state._retailStore.loading,
      partialList: state._retailStore.partialList,
      owner: { type: '_retailStore', id: state._retailStore.id, 
      referenceName: 'store', 
      listName: 'consumerOrderList', ref:state._retailStore, 
      listDisplayName: '消费者订单列表' }, // this is for model namespace and
    }))(ConsumerOrderSearch)
  }
  getConsumerOrderCreateForm = () => {
   	const {ConsumerOrderCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "consumerOrder",
      data: state._retailStore.consumerOrderList,
      metaInfo: state._retailStore.consumerOrderListMetaInfo,
      count: state._retailStore.consumerOrderCount,
      currentPage: state._retailStore.consumerOrderCurrentPageNumber,
      searchFormParameters: state._retailStore.consumerOrderSearchFormParameters,
      loading: state._retailStore.loading,
      owner: { type: '_retailStore', id: state._retailStore.id, referenceName: 'store', listName: 'consumerOrderList', ref:state._retailStore, listDisplayName: '消费者订单列表'}, // this is for model namespace and
    }))(ConsumerOrderCreateForm)
  }
  
  getConsumerOrderUpdateForm = () => {
  	const {ConsumerOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStore.selectedRows,
      role: "consumerOrder",
      currentUpdateIndex: state._retailStore.currentUpdateIndex,
      owner: { type: '_retailStore', id: state._retailStore.id, listName: 'consumerOrderList', ref:state._retailStore, listDisplayName: '消费者订单列表' }, // this is for model namespace and
    }))(ConsumerOrderUpdateForm)
  }

  getRetailStoreOrderSearch = () => {
    const {RetailStoreOrderSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "生超的订单",
      role: "retailStoreOrder",
      data: state._retailStore.retailStoreOrderList,
      metaInfo: state._retailStore.retailStoreOrderListMetaInfo,
      count: state._retailStore.retailStoreOrderCount,
      currentPage: state._retailStore.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStore.retailStoreOrderSearchFormParameters,
      searchParameters: {...state._retailStore.searchParameters},
      expandForm: state._retailStore.expandForm,
      loading: state._retailStore.loading,
      partialList: state._retailStore.partialList,
      owner: { type: '_retailStore', id: state._retailStore.id, 
      referenceName: 'buyer', 
      listName: 'retailStoreOrderList', ref:state._retailStore, 
      listDisplayName: '生超的订单列表' }, // this is for model namespace and
    }))(RetailStoreOrderSearch)
  }
  getRetailStoreOrderCreateForm = () => {
   	const {RetailStoreOrderCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreOrder",
      data: state._retailStore.retailStoreOrderList,
      metaInfo: state._retailStore.retailStoreOrderListMetaInfo,
      count: state._retailStore.retailStoreOrderCount,
      currentPage: state._retailStore.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStore.retailStoreOrderSearchFormParameters,
      loading: state._retailStore.loading,
      owner: { type: '_retailStore', id: state._retailStore.id, referenceName: 'buyer', listName: 'retailStoreOrderList', ref:state._retailStore, listDisplayName: '生超的订单列表'}, // this is for model namespace and
    }))(RetailStoreOrderCreateForm)
  }
  
  getRetailStoreOrderUpdateForm = () => {
  	const {RetailStoreOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStore.selectedRows,
      role: "retailStoreOrder",
      currentUpdateIndex: state._retailStore.currentUpdateIndex,
      owner: { type: '_retailStore', id: state._retailStore.id, listName: 'retailStoreOrderList', ref:state._retailStore, listDisplayName: '生超的订单列表' }, // this is for model namespace and
    }))(RetailStoreOrderUpdateForm)
  }

  getGoodsSearch = () => {
    const {GoodsSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "货物",
      role: "goods",
      data: state._retailStore.goodsList,
      metaInfo: state._retailStore.goodsListMetaInfo,
      count: state._retailStore.goodsCount,
      currentPage: state._retailStore.goodsCurrentPageNumber,
      searchFormParameters: state._retailStore.goodsSearchFormParameters,
      searchParameters: {...state._retailStore.searchParameters},
      expandForm: state._retailStore.expandForm,
      loading: state._retailStore.loading,
      partialList: state._retailStore.partialList,
      owner: { type: '_retailStore', id: state._retailStore.id, 
      referenceName: 'retailStore', 
      listName: 'goodsList', ref:state._retailStore, 
      listDisplayName: '货物列表' }, // this is for model namespace and
    }))(GoodsSearch)
  }
  getGoodsCreateForm = () => {
   	const {GoodsCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "goods",
      data: state._retailStore.goodsList,
      metaInfo: state._retailStore.goodsListMetaInfo,
      count: state._retailStore.goodsCount,
      currentPage: state._retailStore.goodsCurrentPageNumber,
      searchFormParameters: state._retailStore.goodsSearchFormParameters,
      loading: state._retailStore.loading,
      owner: { type: '_retailStore', id: state._retailStore.id, referenceName: 'retailStore', listName: 'goodsList', ref:state._retailStore, listDisplayName: '货物列表'}, // this is for model namespace and
    }))(GoodsCreateForm)
  }
  
  getGoodsUpdateForm = () => {
  	const {GoodsUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStore.selectedRows,
      role: "goods",
      currentUpdateIndex: state._retailStore.currentUpdateIndex,
      owner: { type: '_retailStore', id: state._retailStore.id, listName: 'goodsList', ref:state._retailStore, listDisplayName: '货物列表' }, // this is for model namespace and
    }))(GoodsUpdateForm)
  }

  getTransportTaskSearch = () => {
    const {TransportTaskSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "运输任务",
      role: "transportTask",
      data: state._retailStore.transportTaskList,
      metaInfo: state._retailStore.transportTaskListMetaInfo,
      count: state._retailStore.transportTaskCount,
      currentPage: state._retailStore.transportTaskCurrentPageNumber,
      searchFormParameters: state._retailStore.transportTaskSearchFormParameters,
      searchParameters: {...state._retailStore.searchParameters},
      expandForm: state._retailStore.expandForm,
      loading: state._retailStore.loading,
      partialList: state._retailStore.partialList,
      owner: { type: '_retailStore', id: state._retailStore.id, 
      referenceName: 'end', 
      listName: 'transportTaskList', ref:state._retailStore, 
      listDisplayName: '运输任务列表' }, // this is for model namespace and
    }))(TransportTaskSearch)
  }
  getTransportTaskCreateForm = () => {
   	const {TransportTaskCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "transportTask",
      data: state._retailStore.transportTaskList,
      metaInfo: state._retailStore.transportTaskListMetaInfo,
      count: state._retailStore.transportTaskCount,
      currentPage: state._retailStore.transportTaskCurrentPageNumber,
      searchFormParameters: state._retailStore.transportTaskSearchFormParameters,
      loading: state._retailStore.loading,
      owner: { type: '_retailStore', id: state._retailStore.id, referenceName: 'end', listName: 'transportTaskList', ref:state._retailStore, listDisplayName: '运输任务列表'}, // this is for model namespace and
    }))(TransportTaskCreateForm)
  }
  
  getTransportTaskUpdateForm = () => {
  	const {TransportTaskUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStore.selectedRows,
      role: "transportTask",
      currentUpdateIndex: state._retailStore.currentUpdateIndex,
      owner: { type: '_retailStore', id: state._retailStore.id, listName: 'transportTaskList', ref:state._retailStore, listDisplayName: '运输任务列表' }, // this is for model namespace and
    }))(TransportTaskUpdateForm)
  }

  getAccountSetSearch = () => {
    const {AccountSetSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "账套",
      role: "accountSet",
      data: state._retailStore.accountSetList,
      metaInfo: state._retailStore.accountSetListMetaInfo,
      count: state._retailStore.accountSetCount,
      currentPage: state._retailStore.accountSetCurrentPageNumber,
      searchFormParameters: state._retailStore.accountSetSearchFormParameters,
      searchParameters: {...state._retailStore.searchParameters},
      expandForm: state._retailStore.expandForm,
      loading: state._retailStore.loading,
      partialList: state._retailStore.partialList,
      owner: { type: '_retailStore', id: state._retailStore.id, 
      referenceName: 'retailStore', 
      listName: 'accountSetList', ref:state._retailStore, 
      listDisplayName: '账套列表' }, // this is for model namespace and
    }))(AccountSetSearch)
  }
  getAccountSetCreateForm = () => {
   	const {AccountSetCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "accountSet",
      data: state._retailStore.accountSetList,
      metaInfo: state._retailStore.accountSetListMetaInfo,
      count: state._retailStore.accountSetCount,
      currentPage: state._retailStore.accountSetCurrentPageNumber,
      searchFormParameters: state._retailStore.accountSetSearchFormParameters,
      loading: state._retailStore.loading,
      owner: { type: '_retailStore', id: state._retailStore.id, referenceName: 'retailStore', listName: 'accountSetList', ref:state._retailStore, listDisplayName: '账套列表'}, // this is for model namespace and
    }))(AccountSetCreateForm)
  }
  
  getAccountSetUpdateForm = () => {
  	const {AccountSetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStore.selectedRows,
      role: "accountSet",
      currentUpdateIndex: state._retailStore.currentUpdateIndex,
      owner: { type: '_retailStore', id: state._retailStore.id, listName: 'accountSetList', ref:state._retailStore, listDisplayName: '账套列表' }, // this is for model namespace and
    }))(AccountSetUpdateForm)
  }


  
  buildRouters = () =>{
  	const {RetailStoreDashboard} = GlobalComponents
  	const {RetailStorePreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/retailStore/:id/dashboard", component: RetailStoreDashboard},
  	{path:"/retailStore/:id/preference", component: RetailStorePreference},
  	
  	
  	
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
     const { breadcrumb }  = this.props

     //const {RetailStoreEditDetail} = GlobalComponents
     //const {RetailStoreViewDetail} = GlobalComponents
     
     
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

		 {this.getNavMenuItems(this.props.retailStore)}
		 
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
  retailStore: state._retailStore,
  ...state,
}))(RetailStoreBizApp)



