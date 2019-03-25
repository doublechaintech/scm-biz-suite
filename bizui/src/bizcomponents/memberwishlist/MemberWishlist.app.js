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
import styles from './MemberWishlist.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'

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




class MemberWishlistBizApp extends React.PureComponent {
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
      return ['/memberWishlist/']
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
               <Link to={`/memberWishlist/${this.props.memberWishlist.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/memberWishlist/${this.props.memberWishlist.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getMemberWishlistProductSearch = () => {
    const {MemberWishlistProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "会员收藏产品",
      role: "memberWishlistProduct",
      data: state._memberWishlist.memberWishlistProductList,
      metaInfo: state._memberWishlist.memberWishlistProductListMetaInfo,
      count: state._memberWishlist.memberWishlistProductCount,
      currentPage: state._memberWishlist.memberWishlistProductCurrentPageNumber,
      searchFormParameters: state._memberWishlist.memberWishlistProductSearchFormParameters,
      searchParameters: {...state._memberWishlist.searchParameters},
      expandForm: state._memberWishlist.expandForm,
      loading: state._memberWishlist.loading,
      partialList: state._memberWishlist.partialList,
      owner: { type: '_memberWishlist', id: state._memberWishlist.id, 
      referenceName: 'owner', 
      listName: 'memberWishlistProductList', ref:state._memberWishlist, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(MemberWishlistProductSearch)
  }
  getMemberWishlistProductCreateForm = () => {
   	const {MemberWishlistProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "memberWishlistProduct",
      data: state._memberWishlist.memberWishlistProductList,
      metaInfo: state._memberWishlist.memberWishlistProductListMetaInfo,
      count: state._memberWishlist.memberWishlistProductCount,
      currentPage: state._memberWishlist.memberWishlistProductCurrentPageNumber,
      searchFormParameters: state._memberWishlist.memberWishlistProductSearchFormParameters,
      loading: state._memberWishlist.loading,
      owner: { type: '_memberWishlist', id: state._memberWishlist.id, referenceName: 'owner', listName: 'memberWishlistProductList', ref:state._memberWishlist, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(MemberWishlistProductCreateForm)
  }
  
  getMemberWishlistProductUpdateForm = () => {
    const userContext = null
  	const {MemberWishlistProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._memberWishlist.selectedRows,
      role: "memberWishlistProduct",
      currentUpdateIndex: state._memberWishlist.currentUpdateIndex,
      owner: { type: '_memberWishlist', id: state._memberWishlist.id, listName: 'memberWishlistProductList', ref:state._memberWishlist, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(MemberWishlistProductUpdateForm)
  }


  
  buildRouters = () =>{
  	const {MemberWishlistDashboard} = GlobalComponents
  	const {MemberWishlistPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/memberWishlist/:id/dashboard", component: MemberWishlistDashboard},
  	{path:"/memberWishlist/:id/preference", component: MemberWishlistPreference},
  	
  	
  	
  	{path:"/memberWishlist/:id/list/memberWishlistProductList", component: this.getMemberWishlistProductSearch()},
  	{path:"/memberWishlist/:id/list/memberWishlistProductCreateForm", component: this.getMemberWishlistProductCreateForm()},
  	{path:"/memberWishlist/:id/list/memberWishlistProductUpdateForm", component: this.getMemberWishlistProductUpdateForm()},
     	
  	
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
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
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

		 {this.getNavMenuItems(this.props.memberWishlist)}
		 
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
  memberWishlist: state._memberWishlist,
  ...state,
}))(MemberWishlistBizApp)



