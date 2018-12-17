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
import styles from './StorageSpace.app.less'
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




class StorageSpaceBizApp extends React.PureComponent {
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
      return ['/storageSpace/']
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
               <Link to={`/storageSpace/${this.props.storageSpace.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
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
               <Link to={`/storageSpace/${this.props.storageSpace.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getGoodsShelfSearch = () => {
    const {GoodsShelfSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "货架",
      role: "goodsShelf",
      data: state._storageSpace.goodsShelfList,
      metaInfo: state._storageSpace.goodsShelfListMetaInfo,
      count: state._storageSpace.goodsShelfCount,
      currentPage: state._storageSpace.goodsShelfCurrentPageNumber,
      searchFormParameters: state._storageSpace.goodsShelfSearchFormParameters,
      searchParameters: {...state._storageSpace.searchParameters},
      expandForm: state._storageSpace.expandForm,
      loading: state._storageSpace.loading,
      partialList: state._storageSpace.partialList,
      owner: { type: '_storageSpace', id: state._storageSpace.id, 
      referenceName: 'storageSpace', 
      listName: 'goodsShelfList', ref:state._storageSpace, 
      listDisplayName: '货架列表' }, // this is for model namespace and
    }))(GoodsShelfSearch)
  }
  getGoodsShelfCreateForm = () => {
   	const {GoodsShelfCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "goodsShelf",
      data: state._storageSpace.goodsShelfList,
      metaInfo: state._storageSpace.goodsShelfListMetaInfo,
      count: state._storageSpace.goodsShelfCount,
      currentPage: state._storageSpace.goodsShelfCurrentPageNumber,
      searchFormParameters: state._storageSpace.goodsShelfSearchFormParameters,
      loading: state._storageSpace.loading,
      owner: { type: '_storageSpace', id: state._storageSpace.id, referenceName: 'storageSpace', listName: 'goodsShelfList', ref:state._storageSpace, listDisplayName: '货架列表'}, // this is for model namespace and
    }))(GoodsShelfCreateForm)
  }
  
  getGoodsShelfUpdateForm = () => {
  	const {GoodsShelfUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._storageSpace.selectedRows,
      role: "goodsShelf",
      currentUpdateIndex: state._storageSpace.currentUpdateIndex,
      owner: { type: '_storageSpace', id: state._storageSpace.id, listName: 'goodsShelfList', ref:state._storageSpace, listDisplayName: '货架列表' }, // this is for model namespace and
    }))(GoodsShelfUpdateForm)
  }


  
  buildRouters = () =>{
  	const {StorageSpaceDashboard} = GlobalComponents
  	const {StorageSpacePreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/storageSpace/:id/dashboard", component: StorageSpaceDashboard},
  	{path:"/storageSpace/:id/preference", component: StorageSpacePreference},
  	
  	
  	
  	{path:"/storageSpace/:id/list/goodsShelfList", component: this.getGoodsShelfSearch()},
  	{path:"/storageSpace/:id/list/goodsShelfCreateForm", component: this.getGoodsShelfCreateForm()},
  	{path:"/storageSpace/:id/list/goodsShelfUpdateForm", component: this.getGoodsShelfUpdateForm()},
     	
  	
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

     //const {StorageSpaceEditDetail} = GlobalComponents
     //const {StorageSpaceViewDetail} = GlobalComponents
     
     
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

		 {this.getNavMenuItems(this.props.storageSpace)}
		 
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
  storageSpace: state._storageSpace,
  ...state,
}))(StorageSpaceBizApp)



