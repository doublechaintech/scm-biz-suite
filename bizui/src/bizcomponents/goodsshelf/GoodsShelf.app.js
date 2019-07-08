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
import styles from './GoodsShelf.app.less'
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




class GoodsShelfBizApp extends React.PureComponent {
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
      return ['/goodsShelf/']
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
               <Link to={`/goodsShelf/${this.props.goodsShelf.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
               		<Link to={`/goodsShelf/${this.props.goodsShelf.id}/permission`}><Icon type="safety-certificate" /><span>{appLocaleName(userContext,"Permission")}</span></Link>
             	</Menu.Item>
             	<Menu.Item key="permission">
               		<Link to={`/goodsShelf/${this.props.goodsShelf.id}/profile`}><Icon type="cluster" /><span>{appLocaleName(userContext,"Profile")}</span></Link>
             	</Menu.Item> 
      
        	</SubMenu>
        
           </Menu>
    )
  }
  



  getGoodsShelfStockCountSearch = () => {
    const {GoodsShelfStockCountSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Goods Shelf Stock Count",
      role: "goodsShelfStockCount",
      data: state._goodsShelf.goodsShelfStockCountList,
      metaInfo: state._goodsShelf.goodsShelfStockCountListMetaInfo,
      count: state._goodsShelf.goodsShelfStockCountCount,
      currentPage: state._goodsShelf.goodsShelfStockCountCurrentPageNumber,
      searchFormParameters: state._goodsShelf.goodsShelfStockCountSearchFormParameters,
      searchParameters: {...state._goodsShelf.searchParameters},
      expandForm: state._goodsShelf.expandForm,
      loading: state._goodsShelf.loading,
      partialList: state._goodsShelf.partialList,
      owner: { type: '_goodsShelf', id: state._goodsShelf.id, 
      referenceName: 'shelf', 
      listName: 'goodsShelfStockCountList', ref:state._goodsShelf, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsShelfStockCountSearch)
  }
  getGoodsShelfStockCountCreateForm = () => {
   	const {GoodsShelfStockCountCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "goodsShelfStockCount",
      data: state._goodsShelf.goodsShelfStockCountList,
      metaInfo: state._goodsShelf.goodsShelfStockCountListMetaInfo,
      count: state._goodsShelf.goodsShelfStockCountCount,
      currentPage: state._goodsShelf.goodsShelfStockCountCurrentPageNumber,
      searchFormParameters: state._goodsShelf.goodsShelfStockCountSearchFormParameters,
      loading: state._goodsShelf.loading,
      owner: { type: '_goodsShelf', id: state._goodsShelf.id, referenceName: 'shelf', listName: 'goodsShelfStockCountList', ref:state._goodsShelf, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(GoodsShelfStockCountCreateForm)
  }
  
  getGoodsShelfStockCountUpdateForm = () => {
    const userContext = null
  	const {GoodsShelfStockCountUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._goodsShelf.selectedRows,
      role: "goodsShelfStockCount",
      currentUpdateIndex: state._goodsShelf.currentUpdateIndex,
      owner: { type: '_goodsShelf', id: state._goodsShelf.id, listName: 'goodsShelfStockCountList', ref:state._goodsShelf, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsShelfStockCountUpdateForm)
  }

  getGoodsAllocationSearch = () => {
    const {GoodsAllocationSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Goods Allocation",
      role: "goodsAllocation",
      data: state._goodsShelf.goodsAllocationList,
      metaInfo: state._goodsShelf.goodsAllocationListMetaInfo,
      count: state._goodsShelf.goodsAllocationCount,
      currentPage: state._goodsShelf.goodsAllocationCurrentPageNumber,
      searchFormParameters: state._goodsShelf.goodsAllocationSearchFormParameters,
      searchParameters: {...state._goodsShelf.searchParameters},
      expandForm: state._goodsShelf.expandForm,
      loading: state._goodsShelf.loading,
      partialList: state._goodsShelf.partialList,
      owner: { type: '_goodsShelf', id: state._goodsShelf.id, 
      referenceName: 'goodsShelf', 
      listName: 'goodsAllocationList', ref:state._goodsShelf, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsAllocationSearch)
  }
  getGoodsAllocationCreateForm = () => {
   	const {GoodsAllocationCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "goodsAllocation",
      data: state._goodsShelf.goodsAllocationList,
      metaInfo: state._goodsShelf.goodsAllocationListMetaInfo,
      count: state._goodsShelf.goodsAllocationCount,
      currentPage: state._goodsShelf.goodsAllocationCurrentPageNumber,
      searchFormParameters: state._goodsShelf.goodsAllocationSearchFormParameters,
      loading: state._goodsShelf.loading,
      owner: { type: '_goodsShelf', id: state._goodsShelf.id, referenceName: 'goodsShelf', listName: 'goodsAllocationList', ref:state._goodsShelf, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(GoodsAllocationCreateForm)
  }
  
  getGoodsAllocationUpdateForm = () => {
    const userContext = null
  	const {GoodsAllocationUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._goodsShelf.selectedRows,
      role: "goodsAllocation",
      currentUpdateIndex: state._goodsShelf.currentUpdateIndex,
      owner: { type: '_goodsShelf', id: state._goodsShelf.id, listName: 'goodsAllocationList', ref:state._goodsShelf, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsAllocationUpdateForm)
  }


  
  buildRouters = () =>{
  	const {GoodsShelfDashboard} = GlobalComponents
  	const {GoodsShelfPermission} = GlobalComponents
  	const {GoodsShelfProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/goodsShelf/:id/dashboard", component: GoodsShelfDashboard},
  	{path:"/goodsShelf/:id/profile", component: GoodsShelfProfile},
  	{path:"/goodsShelf/:id/permission", component: GoodsShelfPermission},
  	
  	
  	
  	{path:"/goodsShelf/:id/list/goodsShelfStockCountList", component: this.getGoodsShelfStockCountSearch()},
  	{path:"/goodsShelf/:id/list/goodsShelfStockCountCreateForm", component: this.getGoodsShelfStockCountCreateForm()},
  	{path:"/goodsShelf/:id/list/goodsShelfStockCountUpdateForm", component: this.getGoodsShelfStockCountUpdateForm()},
   	
  	{path:"/goodsShelf/:id/list/goodsAllocationList", component: this.getGoodsAllocationSearch()},
  	{path:"/goodsShelf/:id/list/goodsAllocationCreateForm", component: this.getGoodsAllocationCreateForm()},
  	{path:"/goodsShelf/:id/list/goodsAllocationUpdateForm", component: this.getGoodsAllocationUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.goodsShelf)}
		 
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
  goodsShelf: state._goodsShelf,
  ...state,
}))(GoodsShelfBizApp)



