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
  Input,Button,Tooltip,
} from 'antd'

import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './UserDomain.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';
import TopMenu from '../../launcher/TopMenu'
import SwitchAppMenu from '../../launcher/SwitchAppMenu'

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


const naviBarResponsiveStyle = {
  xs: 10,
  sm: 10,
  md: 10,
  lg: 8,
  xl: 8,

};



const searchBarResponsiveStyle = {
  xs: 4,
  sm: 4,
  md: 4,
  lg: 8,
  xl: 8,

};

const userBarResponsiveStyle = {
  xs: 10,
  sm: 10,
  md: 10,
  lg: 8,
  xl: 8,

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

/*
const currentAppName=()=>{

  const targetApp = sessionObject('targetApp')
  return targetApp.title

}
*/

const currentAppName=()=>{

  const sysConfig=window.sysConfig
  const targetApp = sessionObject('targetApp')
  const {logo}=sysConfig()
  return <span><img width="25px" src={logo} style={{marginRight:"10px"}}/>{targetApp.title}</span>

}





class UserDomainBizApp extends React.PureComponent {
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
      return ['/userDomain/']
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

 getNavMenuItems = (targetObject, style, customTheme) => {


    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
    const mode =style || "inline"
    const theme = customTheme || "light"
	const {objectId}=targetApp;
  	const userContext = null
  	const viewGroupIconNameOf=window.viewGroupIconNameOf
    return (
	  <Menu
        theme="dark"
        mode="inline"

        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}

       >

       <Menu.Item key="workbench">
        <Link to={`/userDomain/${this.props.userDomain.id}/workbench`}><Icon type="solution" style={{marginRight:"20px"}}/><span>工作台</span></Link>
      </Menu.Item>

        
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu id={`submenu-vg${index}`}  key={`vg${index}`} title={<span><Icon type={viewGroupIconNameOf('user_domain',`${groupedMenuItem.viewGroup}`)} style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}



           </Menu>
    )
  }

  getSelectedRows=()=>{
    const {state} = this.props.location

    if(!state){
      return null
    }
    if(!state.selectedRows){
      return null
    }
    if(state.selectedRows.length === 0){
      return null
    }
    return state.selectedRows[0]

  }

  getOwnerId=()=>{
    const {state} = this.props.location

    if(!state){
      return null
    }
    if(!state.ownerId){
      return null
    }

    return state.ownerId

  }



  getUserAllowListSearch = () => {
    const {UserAllowListSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('user_allow_list','user_domain.user_allow_list_list',false),
      role: "userAllowList",
      data: state._userDomain.userAllowListList,
      metaInfo: state._userDomain.userAllowListListMetaInfo,
      count: state._userDomain.userAllowListCount,
      returnURL: `/userDomain/${state._userDomain.id}/workbench`,
      currentPage: state._userDomain.userAllowListCurrentPageNumber,
      searchFormParameters: state._userDomain.userAllowListSearchFormParameters,
      searchParameters: {...state._userDomain.searchParameters},
      expandForm: state._userDomain.expandForm,
      loading: state._userDomain.loading,
      partialList: state._userDomain.partialList,
      owner: { type: '_userDomain', id: state._userDomain.id,
      referenceName: 'domain',
      listName: 'userAllowListList', ref:state._userDomain,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserAllowListSearch)
  }

  getUserAllowListCreateForm = () => {
   	const {UserAllowListCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "userAllowList",
      data: state._userDomain.userAllowListList,
      metaInfo: state._userDomain.userAllowListListMetaInfo,
      count: state._userDomain.userAllowListCount,
      returnURL: `/userDomain/${state._userDomain.id}/list`,
      currentPage: state._userDomain.userAllowListCurrentPageNumber,
      searchFormParameters: state._userDomain.userAllowListSearchFormParameters,
      loading: state._userDomain.loading,
      owner: { type: '_userDomain', id: state._userDomain.id || this.getOwnerId(), referenceName: 'domain', listName: 'userAllowListList', ref:state._userDomain, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(UserAllowListCreateForm)
  }

  getUserAllowListUpdateForm = () => {
    const userContext = null
  	const {UserAllowListUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userDomain.selectedRows,
      role: "userAllowList",
      currentUpdateIndex: state._userDomain.currentUpdateIndex || 0,
      owner: { type: '_userDomain', id: state._userDomain.id || this.getOwnerId(), listName: 'userAllowListList', ref:state._userDomain, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserAllowListUpdateForm)
  }

  getSecUserSearch = () => {
    const {SecUserSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('sec_user','user_domain.sec_user_list',false),
      role: "secUser",
      data: state._userDomain.secUserList,
      metaInfo: state._userDomain.secUserListMetaInfo,
      count: state._userDomain.secUserCount,
      returnURL: `/userDomain/${state._userDomain.id}/workbench`,
      currentPage: state._userDomain.secUserCurrentPageNumber,
      searchFormParameters: state._userDomain.secUserSearchFormParameters,
      searchParameters: {...state._userDomain.searchParameters},
      expandForm: state._userDomain.expandForm,
      loading: state._userDomain.loading,
      partialList: state._userDomain.partialList,
      owner: { type: '_userDomain', id: state._userDomain.id,
      referenceName: 'domain',
      listName: 'secUserList', ref:state._userDomain,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SecUserSearch)
  }

  getSecUserCreateForm = () => {
   	const {SecUserCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "secUser",
      data: state._userDomain.secUserList,
      metaInfo: state._userDomain.secUserListMetaInfo,
      count: state._userDomain.secUserCount,
      returnURL: `/userDomain/${state._userDomain.id}/list`,
      currentPage: state._userDomain.secUserCurrentPageNumber,
      searchFormParameters: state._userDomain.secUserSearchFormParameters,
      loading: state._userDomain.loading,
      owner: { type: '_userDomain', id: state._userDomain.id || this.getOwnerId(), referenceName: 'domain', listName: 'secUserList', ref:state._userDomain, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SecUserCreateForm)
  }

  getSecUserUpdateForm = () => {
    const userContext = null
  	const {SecUserUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userDomain.selectedRows,
      role: "secUser",
      currentUpdateIndex: state._userDomain.currentUpdateIndex || 0,
      owner: { type: '_userDomain', id: state._userDomain.id || this.getOwnerId(), listName: 'secUserList', ref:state._userDomain, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SecUserUpdateForm)
  }

  getPublicKeyTypeSearch = () => {
    const {PublicKeyTypeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('public_key_type','user_domain.public_key_type_list',false),
      role: "publicKeyType",
      data: state._userDomain.publicKeyTypeList,
      metaInfo: state._userDomain.publicKeyTypeListMetaInfo,
      count: state._userDomain.publicKeyTypeCount,
      returnURL: `/userDomain/${state._userDomain.id}/workbench`,
      currentPage: state._userDomain.publicKeyTypeCurrentPageNumber,
      searchFormParameters: state._userDomain.publicKeyTypeSearchFormParameters,
      searchParameters: {...state._userDomain.searchParameters},
      expandForm: state._userDomain.expandForm,
      loading: state._userDomain.loading,
      partialList: state._userDomain.partialList,
      owner: { type: '_userDomain', id: state._userDomain.id,
      referenceName: 'domain',
      listName: 'publicKeyTypeList', ref:state._userDomain,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PublicKeyTypeSearch)
  }

  getPublicKeyTypeCreateForm = () => {
   	const {PublicKeyTypeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "publicKeyType",
      data: state._userDomain.publicKeyTypeList,
      metaInfo: state._userDomain.publicKeyTypeListMetaInfo,
      count: state._userDomain.publicKeyTypeCount,
      returnURL: `/userDomain/${state._userDomain.id}/list`,
      currentPage: state._userDomain.publicKeyTypeCurrentPageNumber,
      searchFormParameters: state._userDomain.publicKeyTypeSearchFormParameters,
      loading: state._userDomain.loading,
      owner: { type: '_userDomain', id: state._userDomain.id || this.getOwnerId(), referenceName: 'domain', listName: 'publicKeyTypeList', ref:state._userDomain, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(PublicKeyTypeCreateForm)
  }

  getPublicKeyTypeUpdateForm = () => {
    const userContext = null
  	const {PublicKeyTypeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._userDomain.selectedRows,
      role: "publicKeyType",
      currentUpdateIndex: state._userDomain.currentUpdateIndex || 0,
      owner: { type: '_userDomain', id: state._userDomain.id || this.getOwnerId(), listName: 'publicKeyTypeList', ref:state._userDomain, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PublicKeyTypeUpdateForm)
  }


  getRequestTypeStepForm = () => {
    const userContext = null
  	 const {ChangeRequestStepForm} = GlobalComponents
    return connect(state => ({
      selectedRows: state._userDomain.selectedRows,
      role: "cq",
      currentUpdateIndex: state._userDomain.currentUpdateIndex,
      owner: { type: '_userDomain', id: state._userDomain.id, listName: 'nolist', ref:state._userDomain, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestStepForm)
  }



  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '双链小超全流程供应链系统'
    return title
  }

  buildRouters = () =>{
    const {UserDomainWorkbench} = GlobalComponents

    const {UserDomainDashboard} = GlobalComponents
  	const {UserDomainPermission} = GlobalComponents
  	const {UserDomainProfile} = GlobalComponents


    const routers=[
    {path:"/userDomain/:id/workbench", component: UserDomainWorkbench},
    {path:"/userDomain/:id/dashboard", component: UserDomainDashboard},
  	{path:"/userDomain/:id/profile", component: UserDomainProfile},
  	{path:"/userDomain/:id/permission", component: UserDomainPermission},



  	{path:"/userDomain/:id/list/userAllowListList", component: this.getUserAllowListSearch()},
  	{path:"/userDomain/:id/list/userAllowListCreateForm", component: this.getUserAllowListCreateForm()},
  	{path:"/userDomain/:id/list/userAllowListUpdateForm", component: this.getUserAllowListUpdateForm()},
 
  	{path:"/userDomain/:id/list/secUserList", component: this.getSecUserSearch()},
  	{path:"/userDomain/:id/list/secUserCreateForm", component: this.getSecUserCreateForm()},
  	{path:"/userDomain/:id/list/secUserUpdateForm", component: this.getSecUserUpdateForm()},
 
  	{path:"/userDomain/:id/list/publicKeyTypeList", component: this.getPublicKeyTypeSearch()},
  	{path:"/userDomain/:id/list/publicKeyTypeCreateForm", component: this.getPublicKeyTypeCreateForm()},
  	{path:"/userDomain/:id/list/publicKeyTypeUpdateForm", component: this.getPublicKeyTypeUpdateForm()},
 

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

   toggleSwitchText=()=>{
    const { collapsed } = this.props
    if(collapsed){
      return "打开菜单"
    }
    return "关闭菜单"

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
     const breadcrumbBar=()=>{
      const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
      return ( <div mode="vertical">
      {currentBreadcrumb.map(item => renderBreadcrumbBarItem(item))}
      </div>)


     }


	const jumpToBreadcrumbLink=(breadcrumbMenuItem)=>{
      const { dispatch} = this.props
      const {name,link} = breadcrumbMenuItem
      dispatch({ type: 'breadcrumb/jumpToLink', payload: {name, link }} )

     }

	 const removeBreadcrumbLink=(breadcrumbMenuItem)=>{
      const { dispatch} = this.props
      const {link} = breadcrumbMenuItem
      dispatch({ type: 'breadcrumb/removeLink', payload: { link }} )

     }

     const renderBreadcrumbBarItem=(breadcrumbMenuItem)=>{

      return (
     <Tag
      	key={breadcrumbMenuItem.link} color={breadcrumbMenuItem.selected?"#108ee9":"grey"}
      	style={{marginRight:"1px",marginBottom:"1px"}} closable onClose={()=>removeBreadcrumbLink(breadcrumbMenuItem)} >
        <span onClick={()=>jumpToBreadcrumbLink(breadcrumbMenuItem)}>
        	{renderBreadcrumbText(breadcrumbMenuItem.name)}
        </span>
      </Tag>)

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

    const {searchLocalData}=GlobalComponents.UserDomainBase

    const renderMenuSwitch=()=>{
      const  text = collapsed?"开启左侧菜单":"关闭左侧菜单"
      const icon = collapsed?"pic-left":"pic-center"

      return (

        <Tooltip placement="bottom" title={text}>


      <a  className={styles.menuLink} onClick={()=>this.toggle()} style={{marginLeft:"20px",minHeight:"20px"}}>
        <Icon type={icon} style={{marginRight:"10px"}}/>
      </a>  </Tooltip>)

     }


       const layout = (
     <Layout>
 		<Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>

        <Row type="flex" justify="start" align="bottom">

        <Col {...naviBarResponsiveStyle} >
          <a className={styles.menuLink}  style={{fontSize:"20px"}}>{currentAppName()}</a>

        </Col>
        <Col  className={styles.searchBox} {...searchBarResponsiveStyle}  >
         <Search size="default" placeholder="请输入搜索条件, 查找功能，数据和词汇解释，关闭请点击搜索结果空白处"
            enterButton onFocus={()=>showSearchResult()} onChange={(evt)=>searchChange(evt)}
            style={{ marginLeft:"10px",marginTop:"7px",width:"100%"}} />
          </Col>
          <Col  {...userBarResponsiveStyle}  >
          <Row>
          <Col  span={10}  > </Col>
          <Col  span={2}  >  {renderMenuSwitch()}</Col>
          <Col  span={6}  >
	          <Dropdown overlay={<SwitchAppMenu {...this.props} />} style={{marginRight:"100px"}} className={styles.right}>
                <a  className={styles.menuLink} >
                <Icon type="appstore" style={{marginRight:"5px"}}/>切换应用
                </a>
              </Dropdown>
          </Col>

          <Col  span={6}  >
            <Dropdown overlay= { <TopMenu {...this.props} />} className={styles.right}>
                <a  className={styles.menuLink}>
                <Icon type="user" style={{marginRight:"5px"}}/>账户
                </a>
            </Dropdown>
            </Col>

          </Row>
            </Col>
         </Row>
        </Header>
       <Layout style={{  marginTop: 44 }}>


       <Layout>

      {this.state.showSearch&&(

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.userDomain,this.state.searchKeyword)}</div>

      )}
       </Layout>


         <Layout>
       <Sider
          trigger={null}
          collapsible
          collapsed={collapsed}
          breakpoint="md"
          onCollapse={() => this.onCollapse(collapsed)}
          collapsedWidth={50}
          className={styles.sider}
        >

         {this.getNavMenuItems(this.props.userDomain,"inline","dark")}

        </Sider>

         <Layout>
         <Layout><Row type="flex" justify="start" align="bottom">{breadcrumbBar()} </Row></Layout>

           <Content style={{ margin: '24px 24px 0', height: '100%' }}>

           {this.buildRouters()}
           </Content>
          </Layout>
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
  userDomain: state._userDomain,
  ...state,
}))(UserDomainBizApp)



