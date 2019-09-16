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
import styles from './TransportTask.app.less'
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




class TransportTaskBizApp extends React.PureComponent {
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
      return ['/transportTask/']
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
               <Link to={`/transportTask/${this.props.transportTask.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		
        
           </Menu>
    )
  }
  



  getGoodsSearch = () => {
    const {GoodsSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "货物",
      role: "goods",
      data: state._transportTask.goodsList,
      metaInfo: state._transportTask.goodsListMetaInfo,
      count: state._transportTask.goodsCount,
      returnURL: `/transportTask/${state._transportTask.id}/dashboard`,
      currentPage: state._transportTask.goodsCurrentPageNumber,
      searchFormParameters: state._transportTask.goodsSearchFormParameters,
      searchParameters: {...state._transportTask.searchParameters},
      expandForm: state._transportTask.expandForm,
      loading: state._transportTask.loading,
      partialList: state._transportTask.partialList,
      owner: { type: '_transportTask', id: state._transportTask.id, 
      referenceName: 'transportTask', 
      listName: 'goodsList', ref:state._transportTask, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsSearch)
  }
  getGoodsCreateForm = () => {
   	const {GoodsCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "goods",
      data: state._transportTask.goodsList,
      metaInfo: state._transportTask.goodsListMetaInfo,
      count: state._transportTask.goodsCount,
      currentPage: state._transportTask.goodsCurrentPageNumber,
      searchFormParameters: state._transportTask.goodsSearchFormParameters,
      loading: state._transportTask.loading,
      owner: { type: '_transportTask', id: state._transportTask.id, referenceName: 'transportTask', listName: 'goodsList', ref:state._transportTask, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(GoodsCreateForm)
  }
  
  getGoodsUpdateForm = () => {
    const userContext = null
  	const {GoodsUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._transportTask.selectedRows,
      role: "goods",
      currentUpdateIndex: state._transportTask.currentUpdateIndex,
      owner: { type: '_transportTask', id: state._transportTask.id, listName: 'goodsList', ref:state._transportTask, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(GoodsUpdateForm)
  }

  getTransportTaskTrackSearch = () => {
    const {TransportTaskTrackSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "运输任务跟踪",
      role: "transportTaskTrack",
      data: state._transportTask.transportTaskTrackList,
      metaInfo: state._transportTask.transportTaskTrackListMetaInfo,
      count: state._transportTask.transportTaskTrackCount,
      returnURL: `/transportTask/${state._transportTask.id}/dashboard`,
      currentPage: state._transportTask.transportTaskTrackCurrentPageNumber,
      searchFormParameters: state._transportTask.transportTaskTrackSearchFormParameters,
      searchParameters: {...state._transportTask.searchParameters},
      expandForm: state._transportTask.expandForm,
      loading: state._transportTask.loading,
      partialList: state._transportTask.partialList,
      owner: { type: '_transportTask', id: state._transportTask.id, 
      referenceName: 'movement', 
      listName: 'transportTaskTrackList', ref:state._transportTask, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransportTaskTrackSearch)
  }
  getTransportTaskTrackCreateForm = () => {
   	const {TransportTaskTrackCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "transportTaskTrack",
      data: state._transportTask.transportTaskTrackList,
      metaInfo: state._transportTask.transportTaskTrackListMetaInfo,
      count: state._transportTask.transportTaskTrackCount,
      currentPage: state._transportTask.transportTaskTrackCurrentPageNumber,
      searchFormParameters: state._transportTask.transportTaskTrackSearchFormParameters,
      loading: state._transportTask.loading,
      owner: { type: '_transportTask', id: state._transportTask.id, referenceName: 'movement', listName: 'transportTaskTrackList', ref:state._transportTask, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TransportTaskTrackCreateForm)
  }
  
  getTransportTaskTrackUpdateForm = () => {
    const userContext = null
  	const {TransportTaskTrackUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._transportTask.selectedRows,
      role: "transportTaskTrack",
      currentUpdateIndex: state._transportTask.currentUpdateIndex,
      owner: { type: '_transportTask', id: state._transportTask.id, listName: 'transportTaskTrackList', ref:state._transportTask, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransportTaskTrackUpdateForm)
  }


  
  buildRouters = () =>{
  	const {TransportTaskDashboard} = GlobalComponents
  	const {TransportTaskPermission} = GlobalComponents
  	const {TransportTaskProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/transportTask/:id/dashboard", component: TransportTaskDashboard},
  	{path:"/transportTask/:id/profile", component: TransportTaskProfile},
  	{path:"/transportTask/:id/permission", component: TransportTaskPermission},
  	
  	
  	
  	{path:"/transportTask/:id/list/goodsList", component: this.getGoodsSearch()},
  	{path:"/transportTask/:id/list/goodsCreateForm", component: this.getGoodsCreateForm()},
  	{path:"/transportTask/:id/list/goodsUpdateForm", component: this.getGoodsUpdateForm()},
   	
  	{path:"/transportTask/:id/list/transportTaskTrackList", component: this.getTransportTaskTrackSearch()},
  	{path:"/transportTask/:id/list/transportTaskTrackCreateForm", component: this.getTransportTaskTrackCreateForm()},
  	{path:"/transportTask/:id/list/transportTaskTrackUpdateForm", component: this.getTransportTaskTrackUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.transportTask)}
		 
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
  transportTask: state._transportTask,
  ...state,
}))(TransportTaskBizApp)



