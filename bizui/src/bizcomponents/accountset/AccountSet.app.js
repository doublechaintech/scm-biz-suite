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
import styles from './AccountSet.app.less'
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




class AccountSetBizApp extends React.PureComponent {
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
      return ['/accountSet/']
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
               <Link to={`/accountSet/${this.props.accountSet.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getAccountingSubjectSearch = () => {
    const {AccountingSubjectSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "会计科目",
      role: "accountingSubject",
      data: state._accountSet.accountingSubjectList,
      metaInfo: state._accountSet.accountingSubjectListMetaInfo,
      count: state._accountSet.accountingSubjectCount,
      currentPage: state._accountSet.accountingSubjectCurrentPageNumber,
      searchFormParameters: state._accountSet.accountingSubjectSearchFormParameters,
      searchParameters: {...state._accountSet.searchParameters},
      expandForm: state._accountSet.expandForm,
      loading: state._accountSet.loading,
      partialList: state._accountSet.partialList,
      owner: { type: '_accountSet', id: state._accountSet.id, 
      referenceName: 'accountSet', 
      listName: 'accountingSubjectList', ref:state._accountSet, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountingSubjectSearch)
  }
  getAccountingSubjectCreateForm = () => {
   	const {AccountingSubjectCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "accountingSubject",
      data: state._accountSet.accountingSubjectList,
      metaInfo: state._accountSet.accountingSubjectListMetaInfo,
      count: state._accountSet.accountingSubjectCount,
      currentPage: state._accountSet.accountingSubjectCurrentPageNumber,
      searchFormParameters: state._accountSet.accountingSubjectSearchFormParameters,
      loading: state._accountSet.loading,
      owner: { type: '_accountSet', id: state._accountSet.id, referenceName: 'accountSet', listName: 'accountingSubjectList', ref:state._accountSet, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AccountingSubjectCreateForm)
  }
  
  getAccountingSubjectUpdateForm = () => {
    const userContext = null
  	const {AccountingSubjectUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._accountSet.selectedRows,
      role: "accountingSubject",
      currentUpdateIndex: state._accountSet.currentUpdateIndex,
      owner: { type: '_accountSet', id: state._accountSet.id, listName: 'accountingSubjectList', ref:state._accountSet, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountingSubjectUpdateForm)
  }

  getAccountingPeriodSearch = () => {
    const {AccountingPeriodSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "会计期间",
      role: "accountingPeriod",
      data: state._accountSet.accountingPeriodList,
      metaInfo: state._accountSet.accountingPeriodListMetaInfo,
      count: state._accountSet.accountingPeriodCount,
      currentPage: state._accountSet.accountingPeriodCurrentPageNumber,
      searchFormParameters: state._accountSet.accountingPeriodSearchFormParameters,
      searchParameters: {...state._accountSet.searchParameters},
      expandForm: state._accountSet.expandForm,
      loading: state._accountSet.loading,
      partialList: state._accountSet.partialList,
      owner: { type: '_accountSet', id: state._accountSet.id, 
      referenceName: 'accountSet', 
      listName: 'accountingPeriodList', ref:state._accountSet, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountingPeriodSearch)
  }
  getAccountingPeriodCreateForm = () => {
   	const {AccountingPeriodCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "accountingPeriod",
      data: state._accountSet.accountingPeriodList,
      metaInfo: state._accountSet.accountingPeriodListMetaInfo,
      count: state._accountSet.accountingPeriodCount,
      currentPage: state._accountSet.accountingPeriodCurrentPageNumber,
      searchFormParameters: state._accountSet.accountingPeriodSearchFormParameters,
      loading: state._accountSet.loading,
      owner: { type: '_accountSet', id: state._accountSet.id, referenceName: 'accountSet', listName: 'accountingPeriodList', ref:state._accountSet, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AccountingPeriodCreateForm)
  }
  
  getAccountingPeriodUpdateForm = () => {
    const userContext = null
  	const {AccountingPeriodUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._accountSet.selectedRows,
      role: "accountingPeriod",
      currentUpdateIndex: state._accountSet.currentUpdateIndex,
      owner: { type: '_accountSet', id: state._accountSet.id, listName: 'accountingPeriodList', ref:state._accountSet, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountingPeriodUpdateForm)
  }

  getAccountingDocumentTypeSearch = () => {
    const {AccountingDocumentTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "会计凭证类型",
      role: "accountingDocumentType",
      data: state._accountSet.accountingDocumentTypeList,
      metaInfo: state._accountSet.accountingDocumentTypeListMetaInfo,
      count: state._accountSet.accountingDocumentTypeCount,
      currentPage: state._accountSet.accountingDocumentTypeCurrentPageNumber,
      searchFormParameters: state._accountSet.accountingDocumentTypeSearchFormParameters,
      searchParameters: {...state._accountSet.searchParameters},
      expandForm: state._accountSet.expandForm,
      loading: state._accountSet.loading,
      partialList: state._accountSet.partialList,
      owner: { type: '_accountSet', id: state._accountSet.id, 
      referenceName: 'accountingPeriod', 
      listName: 'accountingDocumentTypeList', ref:state._accountSet, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountingDocumentTypeSearch)
  }
  getAccountingDocumentTypeCreateForm = () => {
   	const {AccountingDocumentTypeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "accountingDocumentType",
      data: state._accountSet.accountingDocumentTypeList,
      metaInfo: state._accountSet.accountingDocumentTypeListMetaInfo,
      count: state._accountSet.accountingDocumentTypeCount,
      currentPage: state._accountSet.accountingDocumentTypeCurrentPageNumber,
      searchFormParameters: state._accountSet.accountingDocumentTypeSearchFormParameters,
      loading: state._accountSet.loading,
      owner: { type: '_accountSet', id: state._accountSet.id, referenceName: 'accountingPeriod', listName: 'accountingDocumentTypeList', ref:state._accountSet, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AccountingDocumentTypeCreateForm)
  }
  
  getAccountingDocumentTypeUpdateForm = () => {
    const userContext = null
  	const {AccountingDocumentTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._accountSet.selectedRows,
      role: "accountingDocumentType",
      currentUpdateIndex: state._accountSet.currentUpdateIndex,
      owner: { type: '_accountSet', id: state._accountSet.id, listName: 'accountingDocumentTypeList', ref:state._accountSet, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountingDocumentTypeUpdateForm)
  }


  
  buildRouters = () =>{
  	const {AccountSetDashboard} = GlobalComponents
  	const {AccountSetPermission} = GlobalComponents
  	const {AccountSetProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/accountSet/:id/dashboard", component: AccountSetDashboard},
  	{path:"/accountSet/:id/profile", component: AccountSetProfile},
  	{path:"/accountSet/:id/permission", component: AccountSetPermission},
  	
  	
  	
  	{path:"/accountSet/:id/list/accountingSubjectList", component: this.getAccountingSubjectSearch()},
  	{path:"/accountSet/:id/list/accountingSubjectCreateForm", component: this.getAccountingSubjectCreateForm()},
  	{path:"/accountSet/:id/list/accountingSubjectUpdateForm", component: this.getAccountingSubjectUpdateForm()},
   	
  	{path:"/accountSet/:id/list/accountingPeriodList", component: this.getAccountingPeriodSearch()},
  	{path:"/accountSet/:id/list/accountingPeriodCreateForm", component: this.getAccountingPeriodCreateForm()},
  	{path:"/accountSet/:id/list/accountingPeriodUpdateForm", component: this.getAccountingPeriodUpdateForm()},
   	
  	{path:"/accountSet/:id/list/accountingDocumentTypeList", component: this.getAccountingDocumentTypeSearch()},
  	{path:"/accountSet/:id/list/accountingDocumentTypeCreateForm", component: this.getAccountingDocumentTypeCreateForm()},
  	{path:"/accountSet/:id/list/accountingDocumentTypeUpdateForm", component: this.getAccountingDocumentTypeUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.accountSet)}
		 
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
  accountSet: state._accountSet,
  ...state,
}))(AccountSetBizApp)



