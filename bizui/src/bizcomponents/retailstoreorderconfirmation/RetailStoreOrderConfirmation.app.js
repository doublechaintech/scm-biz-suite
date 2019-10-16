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
import styles from './RetailStoreOrderConfirmation.app.less'
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




class RetailStoreOrderConfirmationBizApp extends React.PureComponent {
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
      return ['/retailStoreOrderConfirmation/']
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
               <Link to={`/retailStoreOrderConfirmation/${this.props.retailStoreOrderConfirmation.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getRetailStoreOrderSearch = () => {
    const {RetailStoreOrderSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "生超的订单",
      role: "retailStoreOrder",
      data: state._retailStoreOrderConfirmation.retailStoreOrderList,
      metaInfo: state._retailStoreOrderConfirmation.retailStoreOrderListMetaInfo,
      count: state._retailStoreOrderConfirmation.retailStoreOrderCount,
      returnURL: `/retailStoreOrderConfirmation/${state._retailStoreOrderConfirmation.id}/dashboard`,
      currentPage: state._retailStoreOrderConfirmation.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreOrderConfirmation.retailStoreOrderSearchFormParameters,
      searchParameters: {...state._retailStoreOrderConfirmation.searchParameters},
      expandForm: state._retailStoreOrderConfirmation.expandForm,
      loading: state._retailStoreOrderConfirmation.loading,
      partialList: state._retailStoreOrderConfirmation.partialList,
      owner: { type: '_retailStoreOrderConfirmation', id: state._retailStoreOrderConfirmation.id, 
      referenceName: 'confirmation', 
      listName: 'retailStoreOrderList', ref:state._retailStoreOrderConfirmation, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderSearch)
  }
  getRetailStoreOrderCreateForm = () => {
   	const {RetailStoreOrderCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "retailStoreOrder",
      data: state._retailStoreOrderConfirmation.retailStoreOrderList,
      metaInfo: state._retailStoreOrderConfirmation.retailStoreOrderListMetaInfo,
      count: state._retailStoreOrderConfirmation.retailStoreOrderCount,
      returnURL: `/retailStoreOrderConfirmation/${state._retailStoreOrderConfirmation.id}/list`,
      currentPage: state._retailStoreOrderConfirmation.retailStoreOrderCurrentPageNumber,
      searchFormParameters: state._retailStoreOrderConfirmation.retailStoreOrderSearchFormParameters,
      loading: state._retailStoreOrderConfirmation.loading,
      owner: { type: '_retailStoreOrderConfirmation', id: state._retailStoreOrderConfirmation.id, referenceName: 'confirmation', listName: 'retailStoreOrderList', ref:state._retailStoreOrderConfirmation, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreOrderCreateForm)
  }
  
  getRetailStoreOrderUpdateForm = () => {
    const userContext = null
  	const {RetailStoreOrderUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreOrderConfirmation.selectedRows,
      role: "retailStoreOrder",
      currentUpdateIndex: state._retailStoreOrderConfirmation.currentUpdateIndex,
      owner: { type: '_retailStoreOrderConfirmation', id: state._retailStoreOrderConfirmation.id, listName: 'retailStoreOrderList', ref:state._retailStoreOrderConfirmation, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreOrderUpdateForm)
  }


  
  buildRouters = () =>{
  	const {RetailStoreOrderConfirmationDashboard} = GlobalComponents
  	const {RetailStoreOrderConfirmationPermission} = GlobalComponents
  	const {RetailStoreOrderConfirmationProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/retailStoreOrderConfirmation/:id/dashboard", component: RetailStoreOrderConfirmationDashboard},
  	{path:"/retailStoreOrderConfirmation/:id/profile", component: RetailStoreOrderConfirmationProfile},
  	{path:"/retailStoreOrderConfirmation/:id/permission", component: RetailStoreOrderConfirmationPermission},
  	
  	
  	
  	{path:"/retailStoreOrderConfirmation/:id/list/retailStoreOrderList", component: this.getRetailStoreOrderSearch()},
  	{path:"/retailStoreOrderConfirmation/:id/list/retailStoreOrderCreateForm", component: this.getRetailStoreOrderCreateForm()},
  	{path:"/retailStoreOrderConfirmation/:id/list/retailStoreOrderUpdateForm", component: this.getRetailStoreOrderUpdateForm()},
     	
  	
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
            <Dropdown overlay= {this.getNavMenuItems(this.props.retailStoreOrderConfirmation)}>
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
  retailStoreOrderConfirmation: state._retailStoreOrderConfirmation,
  ...state,
}))(RetailStoreOrderConfirmationBizApp)



