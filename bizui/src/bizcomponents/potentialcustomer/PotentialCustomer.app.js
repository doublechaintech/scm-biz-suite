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
import styles from './PotentialCustomer.app.less'
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




class PotentialCustomerBizApp extends React.PureComponent {
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
      return ['/potentialCustomer/']
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
               <Link to={`/potentialCustomer/${this.props.potentialCustomer.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
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
               <Link to={`/potentialCustomer/${this.props.potentialCustomer.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getPotentialCustomerContactPersonSearch = () => {
    const {PotentialCustomerContactPersonSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "潜在客户联络人",
      role: "potentialCustomerContactPerson",
      data: state._potentialCustomer.potentialCustomerContactPersonList,
      metaInfo: state._potentialCustomer.potentialCustomerContactPersonListMetaInfo,
      count: state._potentialCustomer.potentialCustomerContactPersonCount,
      currentPage: state._potentialCustomer.potentialCustomerContactPersonCurrentPageNumber,
      searchFormParameters: state._potentialCustomer.potentialCustomerContactPersonSearchFormParameters,
      searchParameters: {...state._potentialCustomer.searchParameters},
      expandForm: state._potentialCustomer.expandForm,
      loading: state._potentialCustomer.loading,
      partialList: state._potentialCustomer.partialList,
      owner: { type: '_potentialCustomer', id: state._potentialCustomer.id, 
      referenceName: 'potentialCustomer', 
      listName: 'potentialCustomerContactPersonList', ref:state._potentialCustomer, 
      listDisplayName: '潜在客户联络人列表' }, // this is for model namespace and
    }))(PotentialCustomerContactPersonSearch)
  }
  getPotentialCustomerContactPersonCreateForm = () => {
   	const {PotentialCustomerContactPersonCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "potentialCustomerContactPerson",
      data: state._potentialCustomer.potentialCustomerContactPersonList,
      metaInfo: state._potentialCustomer.potentialCustomerContactPersonListMetaInfo,
      count: state._potentialCustomer.potentialCustomerContactPersonCount,
      currentPage: state._potentialCustomer.potentialCustomerContactPersonCurrentPageNumber,
      searchFormParameters: state._potentialCustomer.potentialCustomerContactPersonSearchFormParameters,
      loading: state._potentialCustomer.loading,
      owner: { type: '_potentialCustomer', id: state._potentialCustomer.id, referenceName: 'potentialCustomer', listName: 'potentialCustomerContactPersonList', ref:state._potentialCustomer, listDisplayName: '潜在客户联络人列表'}, // this is for model namespace and
    }))(PotentialCustomerContactPersonCreateForm)
  }
  
  getPotentialCustomerContactPersonUpdateForm = () => {
  	const {PotentialCustomerContactPersonUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._potentialCustomer.selectedRows,
      role: "potentialCustomerContactPerson",
      currentUpdateIndex: state._potentialCustomer.currentUpdateIndex,
      owner: { type: '_potentialCustomer', id: state._potentialCustomer.id, listName: 'potentialCustomerContactPersonList', ref:state._potentialCustomer, listDisplayName: '潜在客户联络人列表' }, // this is for model namespace and
    }))(PotentialCustomerContactPersonUpdateForm)
  }

  getPotentialCustomerContactSearch = () => {
    const {PotentialCustomerContactSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "潜在客户联系",
      role: "potentialCustomerContact",
      data: state._potentialCustomer.potentialCustomerContactList,
      metaInfo: state._potentialCustomer.potentialCustomerContactListMetaInfo,
      count: state._potentialCustomer.potentialCustomerContactCount,
      currentPage: state._potentialCustomer.potentialCustomerContactCurrentPageNumber,
      searchFormParameters: state._potentialCustomer.potentialCustomerContactSearchFormParameters,
      searchParameters: {...state._potentialCustomer.searchParameters},
      expandForm: state._potentialCustomer.expandForm,
      loading: state._potentialCustomer.loading,
      partialList: state._potentialCustomer.partialList,
      owner: { type: '_potentialCustomer', id: state._potentialCustomer.id, 
      referenceName: 'potentialCustomer', 
      listName: 'potentialCustomerContactList', ref:state._potentialCustomer, 
      listDisplayName: '潜在客户联系列表' }, // this is for model namespace and
    }))(PotentialCustomerContactSearch)
  }
  getPotentialCustomerContactCreateForm = () => {
   	const {PotentialCustomerContactCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "potentialCustomerContact",
      data: state._potentialCustomer.potentialCustomerContactList,
      metaInfo: state._potentialCustomer.potentialCustomerContactListMetaInfo,
      count: state._potentialCustomer.potentialCustomerContactCount,
      currentPage: state._potentialCustomer.potentialCustomerContactCurrentPageNumber,
      searchFormParameters: state._potentialCustomer.potentialCustomerContactSearchFormParameters,
      loading: state._potentialCustomer.loading,
      owner: { type: '_potentialCustomer', id: state._potentialCustomer.id, referenceName: 'potentialCustomer', listName: 'potentialCustomerContactList', ref:state._potentialCustomer, listDisplayName: '潜在客户联系列表'}, // this is for model namespace and
    }))(PotentialCustomerContactCreateForm)
  }
  
  getPotentialCustomerContactUpdateForm = () => {
  	const {PotentialCustomerContactUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._potentialCustomer.selectedRows,
      role: "potentialCustomerContact",
      currentUpdateIndex: state._potentialCustomer.currentUpdateIndex,
      owner: { type: '_potentialCustomer', id: state._potentialCustomer.id, listName: 'potentialCustomerContactList', ref:state._potentialCustomer, listDisplayName: '潜在客户联系列表' }, // this is for model namespace and
    }))(PotentialCustomerContactUpdateForm)
  }

  getEventAttendanceSearch = () => {
    const {EventAttendanceSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "活动的参与情况",
      role: "eventAttendance",
      data: state._potentialCustomer.eventAttendanceList,
      metaInfo: state._potentialCustomer.eventAttendanceListMetaInfo,
      count: state._potentialCustomer.eventAttendanceCount,
      currentPage: state._potentialCustomer.eventAttendanceCurrentPageNumber,
      searchFormParameters: state._potentialCustomer.eventAttendanceSearchFormParameters,
      searchParameters: {...state._potentialCustomer.searchParameters},
      expandForm: state._potentialCustomer.expandForm,
      loading: state._potentialCustomer.loading,
      partialList: state._potentialCustomer.partialList,
      owner: { type: '_potentialCustomer', id: state._potentialCustomer.id, 
      referenceName: 'potentialCustomer', 
      listName: 'eventAttendanceList', ref:state._potentialCustomer, 
      listDisplayName: '活动的参与情况列表' }, // this is for model namespace and
    }))(EventAttendanceSearch)
  }
  getEventAttendanceCreateForm = () => {
   	const {EventAttendanceCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "eventAttendance",
      data: state._potentialCustomer.eventAttendanceList,
      metaInfo: state._potentialCustomer.eventAttendanceListMetaInfo,
      count: state._potentialCustomer.eventAttendanceCount,
      currentPage: state._potentialCustomer.eventAttendanceCurrentPageNumber,
      searchFormParameters: state._potentialCustomer.eventAttendanceSearchFormParameters,
      loading: state._potentialCustomer.loading,
      owner: { type: '_potentialCustomer', id: state._potentialCustomer.id, referenceName: 'potentialCustomer', listName: 'eventAttendanceList', ref:state._potentialCustomer, listDisplayName: '活动的参与情况列表'}, // this is for model namespace and
    }))(EventAttendanceCreateForm)
  }
  
  getEventAttendanceUpdateForm = () => {
  	const {EventAttendanceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._potentialCustomer.selectedRows,
      role: "eventAttendance",
      currentUpdateIndex: state._potentialCustomer.currentUpdateIndex,
      owner: { type: '_potentialCustomer', id: state._potentialCustomer.id, listName: 'eventAttendanceList', ref:state._potentialCustomer, listDisplayName: '活动的参与情况列表' }, // this is for model namespace and
    }))(EventAttendanceUpdateForm)
  }


  
  buildRouters = () =>{
  	const {PotentialCustomerDashboard} = GlobalComponents
  	const {PotentialCustomerPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/potentialCustomer/:id/dashboard", component: PotentialCustomerDashboard},
  	{path:"/potentialCustomer/:id/preference", component: PotentialCustomerPreference},
  	
  	
  	
  	{path:"/potentialCustomer/:id/list/potentialCustomerContactPersonList", component: this.getPotentialCustomerContactPersonSearch()},
  	{path:"/potentialCustomer/:id/list/potentialCustomerContactPersonCreateForm", component: this.getPotentialCustomerContactPersonCreateForm()},
  	{path:"/potentialCustomer/:id/list/potentialCustomerContactPersonUpdateForm", component: this.getPotentialCustomerContactPersonUpdateForm()},
   	
  	{path:"/potentialCustomer/:id/list/potentialCustomerContactList", component: this.getPotentialCustomerContactSearch()},
  	{path:"/potentialCustomer/:id/list/potentialCustomerContactCreateForm", component: this.getPotentialCustomerContactCreateForm()},
  	{path:"/potentialCustomer/:id/list/potentialCustomerContactUpdateForm", component: this.getPotentialCustomerContactUpdateForm()},
   	
  	{path:"/potentialCustomer/:id/list/eventAttendanceList", component: this.getEventAttendanceSearch()},
  	{path:"/potentialCustomer/:id/list/eventAttendanceCreateForm", component: this.getEventAttendanceCreateForm()},
  	{path:"/potentialCustomer/:id/list/eventAttendanceUpdateForm", component: this.getEventAttendanceUpdateForm()},
     	
  	
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

     //const {PotentialCustomerEditDetail} = GlobalComponents
     //const {PotentialCustomerViewDetail} = GlobalComponents
     
     
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

		 {this.getNavMenuItems(this.props.potentialCustomer)}
		 
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
  potentialCustomer: state._potentialCustomer,
  ...state,
}))(PotentialCustomerBizApp)



