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
import styles from './TransportFleet.app.less'
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




class TransportFleetBizApp extends React.PureComponent {
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
      return ['/transportFleet/']
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
        style={{ width: '456px' }}
       >
           

             <Menu.Item key="dashboard">
               <Link to={`/transportFleet/${this.props.transportFleet.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getTransportTruckSearch = () => {
    const {TransportTruckSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "运输车",
      role: "transportTruck",
      data: state._transportFleet.transportTruckList,
      metaInfo: state._transportFleet.transportTruckListMetaInfo,
      count: state._transportFleet.transportTruckCount,
      returnURL: `/transportFleet/${state._transportFleet.id}/dashboard`,
      currentPage: state._transportFleet.transportTruckCurrentPageNumber,
      searchFormParameters: state._transportFleet.transportTruckSearchFormParameters,
      searchParameters: {...state._transportFleet.searchParameters},
      expandForm: state._transportFleet.expandForm,
      loading: state._transportFleet.loading,
      partialList: state._transportFleet.partialList,
      owner: { type: '_transportFleet', id: state._transportFleet.id, 
      referenceName: 'owner', 
      listName: 'transportTruckList', ref:state._transportFleet, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransportTruckSearch)
  }
  getTransportTruckCreateForm = () => {
   	const {TransportTruckCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "transportTruck",
      data: state._transportFleet.transportTruckList,
      metaInfo: state._transportFleet.transportTruckListMetaInfo,
      count: state._transportFleet.transportTruckCount,
      returnURL: `/transportFleet/${state._transportFleet.id}/list`,
      currentPage: state._transportFleet.transportTruckCurrentPageNumber,
      searchFormParameters: state._transportFleet.transportTruckSearchFormParameters,
      loading: state._transportFleet.loading,
      owner: { type: '_transportFleet', id: state._transportFleet.id, referenceName: 'owner', listName: 'transportTruckList', ref:state._transportFleet, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TransportTruckCreateForm)
  }
  
  getTransportTruckUpdateForm = () => {
    const userContext = null
  	const {TransportTruckUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._transportFleet.selectedRows,
      role: "transportTruck",
      currentUpdateIndex: state._transportFleet.currentUpdateIndex,
      owner: { type: '_transportFleet', id: state._transportFleet.id, listName: 'transportTruckList', ref:state._transportFleet, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransportTruckUpdateForm)
  }

  getTruckDriverSearch = () => {
    const {TruckDriverSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "卡车司机",
      role: "truckDriver",
      data: state._transportFleet.truckDriverList,
      metaInfo: state._transportFleet.truckDriverListMetaInfo,
      count: state._transportFleet.truckDriverCount,
      returnURL: `/transportFleet/${state._transportFleet.id}/dashboard`,
      currentPage: state._transportFleet.truckDriverCurrentPageNumber,
      searchFormParameters: state._transportFleet.truckDriverSearchFormParameters,
      searchParameters: {...state._transportFleet.searchParameters},
      expandForm: state._transportFleet.expandForm,
      loading: state._transportFleet.loading,
      partialList: state._transportFleet.partialList,
      owner: { type: '_transportFleet', id: state._transportFleet.id, 
      referenceName: 'belongsTo', 
      listName: 'truckDriverList', ref:state._transportFleet, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TruckDriverSearch)
  }
  getTruckDriverCreateForm = () => {
   	const {TruckDriverCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "truckDriver",
      data: state._transportFleet.truckDriverList,
      metaInfo: state._transportFleet.truckDriverListMetaInfo,
      count: state._transportFleet.truckDriverCount,
      returnURL: `/transportFleet/${state._transportFleet.id}/list`,
      currentPage: state._transportFleet.truckDriverCurrentPageNumber,
      searchFormParameters: state._transportFleet.truckDriverSearchFormParameters,
      loading: state._transportFleet.loading,
      owner: { type: '_transportFleet', id: state._transportFleet.id, referenceName: 'belongsTo', listName: 'truckDriverList', ref:state._transportFleet, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TruckDriverCreateForm)
  }
  
  getTruckDriverUpdateForm = () => {
    const userContext = null
  	const {TruckDriverUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._transportFleet.selectedRows,
      role: "truckDriver",
      currentUpdateIndex: state._transportFleet.currentUpdateIndex,
      owner: { type: '_transportFleet', id: state._transportFleet.id, listName: 'truckDriverList', ref:state._transportFleet, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TruckDriverUpdateForm)
  }

  getTransportTaskSearch = () => {
    const {TransportTaskSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "运输任务",
      role: "transportTask",
      data: state._transportFleet.transportTaskList,
      metaInfo: state._transportFleet.transportTaskListMetaInfo,
      count: state._transportFleet.transportTaskCount,
      returnURL: `/transportFleet/${state._transportFleet.id}/dashboard`,
      currentPage: state._transportFleet.transportTaskCurrentPageNumber,
      searchFormParameters: state._transportFleet.transportTaskSearchFormParameters,
      searchParameters: {...state._transportFleet.searchParameters},
      expandForm: state._transportFleet.expandForm,
      loading: state._transportFleet.loading,
      partialList: state._transportFleet.partialList,
      owner: { type: '_transportFleet', id: state._transportFleet.id, 
      referenceName: 'belongsTo', 
      listName: 'transportTaskList', ref:state._transportFleet, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransportTaskSearch)
  }
  getTransportTaskCreateForm = () => {
   	const {TransportTaskCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "transportTask",
      data: state._transportFleet.transportTaskList,
      metaInfo: state._transportFleet.transportTaskListMetaInfo,
      count: state._transportFleet.transportTaskCount,
      returnURL: `/transportFleet/${state._transportFleet.id}/list`,
      currentPage: state._transportFleet.transportTaskCurrentPageNumber,
      searchFormParameters: state._transportFleet.transportTaskSearchFormParameters,
      loading: state._transportFleet.loading,
      owner: { type: '_transportFleet', id: state._transportFleet.id, referenceName: 'belongsTo', listName: 'transportTaskList', ref:state._transportFleet, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TransportTaskCreateForm)
  }
  
  getTransportTaskUpdateForm = () => {
    const userContext = null
  	const {TransportTaskUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._transportFleet.selectedRows,
      role: "transportTask",
      currentUpdateIndex: state._transportFleet.currentUpdateIndex,
      owner: { type: '_transportFleet', id: state._transportFleet.id, listName: 'transportTaskList', ref:state._transportFleet, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TransportTaskUpdateForm)
  }


  

 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '双链小超全流程供应链系统'
    return title
  }
 
  buildRouters = () =>{
  	const {TransportFleetDashboard} = GlobalComponents
  	const {TransportFleetPermission} = GlobalComponents
  	const {TransportFleetProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/transportFleet/:id/dashboard", component: TransportFleetDashboard},
  	{path:"/transportFleet/:id/profile", component: TransportFleetProfile},
  	{path:"/transportFleet/:id/permission", component: TransportFleetPermission},
  	
  	
  	
  	{path:"/transportFleet/:id/list/transportTruckList", component: this.getTransportTruckSearch()},
  	{path:"/transportFleet/:id/list/transportTruckCreateForm", component: this.getTransportTruckCreateForm()},
  	{path:"/transportFleet/:id/list/transportTruckUpdateForm", component: this.getTransportTruckUpdateForm()},
   	
  	{path:"/transportFleet/:id/list/truckDriverList", component: this.getTruckDriverSearch()},
  	{path:"/transportFleet/:id/list/truckDriverCreateForm", component: this.getTruckDriverCreateForm()},
  	{path:"/transportFleet/:id/list/truckDriverUpdateForm", component: this.getTruckDriverUpdateForm()},
   	
  	{path:"/transportFleet/:id/list/transportTaskList", component: this.getTransportTaskSearch()},
  	{path:"/transportFleet/:id/list/transportTaskCreateForm", component: this.getTransportTaskCreateForm()},
  	{path:"/transportFleet/:id/list/transportTaskUpdateForm", component: this.getTransportTaskUpdateForm()},
     	
 	 
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
     const showSearchResult=()=>{

        this.setState({showSearch:true})

     }
     const searchChange=(evt)=>{

      this.setState({searchKeyword :evt.target.value})

    }
    const hideSearchResult=()=>{

      this.setState({showSearch:false})

    }

    const {searchLocalData}=GlobalComponents.TransportFleetBase
	
    
     
     
     const layout = (
     <Layout>
 <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          
        <Row type="flex" justify="start" align="bottom">
        
        <Col {...naviBarResponsiveStyle} >
            <Dropdown overlay= {this.getNavMenuItems(this.props.transportFleet)}>
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
          
          <Search size="default" placeholder="请输入搜索条件, 查找功能，数据和词汇解释，关闭请点击搜索结果空白处" 
            enterButton onFocus={()=>showSearchResult()} onChange={(evt)=>searchChange(evt)}
           	
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
       
      {this.state.showSearch&&(

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.transportFleet,this.state.searchKeyword)}</div>

      )}
       
        
         
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
  transportFleet: state._transportFleet,
  ...state,
}))(TransportFleetBizApp)



