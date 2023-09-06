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
import styles from './RetailStoreProvinceCenter.app.less'
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





class RetailStoreProvinceCenterBizApp extends React.PureComponent {
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
      return ['/retailStoreProvinceCenter/']
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
        <Link to={`/retailStoreProvinceCenter/${this.props.retailStoreProvinceCenter.id}/workbench`}><Icon type="solution" style={{marginRight:"20px"}}/><span>工作台</span></Link>
      </Menu.Item>

        
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu id={`submenu-vg${index}`}  key={`vg${index}`} title={<span><Icon type={viewGroupIconNameOf('retail_store_province_center',`${groupedMenuItem.viewGroup}`)} style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
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



  getProvinceCenterDepartmentSearch = () => {
    const {ProvinceCenterDepartmentSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('province_center_department','retail_store_province_center.province_center_department_list',false),
      role: "provinceCenterDepartment",
      data: state._retailStoreProvinceCenter.provinceCenterDepartmentList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterDepartmentListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterDepartmentCount,
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/workbench`,
      currentPage: state._retailStoreProvinceCenter.provinceCenterDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterDepartmentSearchFormParameters,
      searchParameters: {...state._retailStoreProvinceCenter.searchParameters},
      expandForm: state._retailStoreProvinceCenter.expandForm,
      loading: state._retailStoreProvinceCenter.loading,
      partialList: state._retailStoreProvinceCenter.partialList,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id,
      referenceName: 'provinceCenter',
      listName: 'provinceCenterDepartmentList', ref:state._retailStoreProvinceCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProvinceCenterDepartmentSearch)
  }

  getProvinceCenterDepartmentCreateForm = () => {
   	const {ProvinceCenterDepartmentCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "provinceCenterDepartment",
      data: state._retailStoreProvinceCenter.provinceCenterDepartmentList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterDepartmentListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterDepartmentCount,
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/list`,
      currentPage: state._retailStoreProvinceCenter.provinceCenterDepartmentCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterDepartmentSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id || this.getOwnerId(), referenceName: 'provinceCenter', listName: 'provinceCenterDepartmentList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ProvinceCenterDepartmentCreateForm)
  }

  getProvinceCenterDepartmentUpdateForm = () => {
    const userContext = null
  	const {ProvinceCenterDepartmentUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreProvinceCenter.selectedRows,
      role: "provinceCenterDepartment",
      currentUpdateIndex: state._retailStoreProvinceCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id || this.getOwnerId(), listName: 'provinceCenterDepartmentList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProvinceCenterDepartmentUpdateForm)
  }

  getProvinceCenterEmployeeSearch = () => {
    const {ProvinceCenterEmployeeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('province_center_employee','retail_store_province_center.province_center_employee_list',false),
      role: "provinceCenterEmployee",
      data: state._retailStoreProvinceCenter.provinceCenterEmployeeList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterEmployeeListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterEmployeeCount,
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/workbench`,
      currentPage: state._retailStoreProvinceCenter.provinceCenterEmployeeCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterEmployeeSearchFormParameters,
      searchParameters: {...state._retailStoreProvinceCenter.searchParameters},
      expandForm: state._retailStoreProvinceCenter.expandForm,
      loading: state._retailStoreProvinceCenter.loading,
      partialList: state._retailStoreProvinceCenter.partialList,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id,
      referenceName: 'provinceCenter',
      listName: 'provinceCenterEmployeeList', ref:state._retailStoreProvinceCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProvinceCenterEmployeeSearch)
  }

  getProvinceCenterEmployeeCreateForm = () => {
   	const {ProvinceCenterEmployeeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "provinceCenterEmployee",
      data: state._retailStoreProvinceCenter.provinceCenterEmployeeList,
      metaInfo: state._retailStoreProvinceCenter.provinceCenterEmployeeListMetaInfo,
      count: state._retailStoreProvinceCenter.provinceCenterEmployeeCount,
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/list`,
      currentPage: state._retailStoreProvinceCenter.provinceCenterEmployeeCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.provinceCenterEmployeeSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id || this.getOwnerId(), referenceName: 'provinceCenter', listName: 'provinceCenterEmployeeList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ProvinceCenterEmployeeCreateForm)
  }

  getProvinceCenterEmployeeUpdateForm = () => {
    const userContext = null
  	const {ProvinceCenterEmployeeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreProvinceCenter.selectedRows,
      role: "provinceCenterEmployee",
      currentUpdateIndex: state._retailStoreProvinceCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id || this.getOwnerId(), listName: 'provinceCenterEmployeeList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProvinceCenterEmployeeUpdateForm)
  }

  getRetailStoreCityServiceCenterSearch = () => {
    const {RetailStoreCityServiceCenterSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('retail_store_city_service_center','retail_store_province_center.retail_store_city_service_center_list',false),
      role: "retailStoreCityServiceCenter",
      data: state._retailStoreProvinceCenter.retailStoreCityServiceCenterList,
      metaInfo: state._retailStoreProvinceCenter.retailStoreCityServiceCenterListMetaInfo,
      count: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCount,
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/workbench`,
      currentPage: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.retailStoreCityServiceCenterSearchFormParameters,
      searchParameters: {...state._retailStoreProvinceCenter.searchParameters},
      expandForm: state._retailStoreProvinceCenter.expandForm,
      loading: state._retailStoreProvinceCenter.loading,
      partialList: state._retailStoreProvinceCenter.partialList,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id,
      referenceName: 'belongsTo',
      listName: 'retailStoreCityServiceCenterList', ref:state._retailStoreProvinceCenter,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreCityServiceCenterSearch)
  }

  getRetailStoreCityServiceCenterCreateForm = () => {
   	const {RetailStoreCityServiceCenterCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "retailStoreCityServiceCenter",
      data: state._retailStoreProvinceCenter.retailStoreCityServiceCenterList,
      metaInfo: state._retailStoreProvinceCenter.retailStoreCityServiceCenterListMetaInfo,
      count: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCount,
      returnURL: `/retailStoreProvinceCenter/${state._retailStoreProvinceCenter.id}/list`,
      currentPage: state._retailStoreProvinceCenter.retailStoreCityServiceCenterCurrentPageNumber,
      searchFormParameters: state._retailStoreProvinceCenter.retailStoreCityServiceCenterSearchFormParameters,
      loading: state._retailStoreProvinceCenter.loading,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id || this.getOwnerId(), referenceName: 'belongsTo', listName: 'retailStoreCityServiceCenterList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RetailStoreCityServiceCenterCreateForm)
  }

  getRetailStoreCityServiceCenterUpdateForm = () => {
    const userContext = null
  	const {RetailStoreCityServiceCenterUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._retailStoreProvinceCenter.selectedRows,
      role: "retailStoreCityServiceCenter",
      currentUpdateIndex: state._retailStoreProvinceCenter.currentUpdateIndex || 0,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id || this.getOwnerId(), listName: 'retailStoreCityServiceCenterList', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RetailStoreCityServiceCenterUpdateForm)
  }


  getRequestTypeStepForm = () => {
    const userContext = null
  	 const {ChangeRequestStepForm} = GlobalComponents
    return connect(state => ({
      selectedRows: state._retailStoreProvinceCenter.selectedRows,
      role: "cq",
      currentUpdateIndex: state._retailStoreProvinceCenter.currentUpdateIndex,
      owner: { type: '_retailStoreProvinceCenter', id: state._retailStoreProvinceCenter.id, listName: 'nolist', ref:state._retailStoreProvinceCenter, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestStepForm)
  }



  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '双链小超全流程供应链系统'
    return title
  }

  buildRouters = () =>{
    const {RetailStoreProvinceCenterWorkbench} = GlobalComponents

    const {RetailStoreProvinceCenterDashboard} = GlobalComponents
  	const {RetailStoreProvinceCenterPermission} = GlobalComponents
  	const {RetailStoreProvinceCenterProfile} = GlobalComponents


    const routers=[
    {path:"/retailStoreProvinceCenter/:id/workbench", component: RetailStoreProvinceCenterWorkbench},
    {path:"/retailStoreProvinceCenter/:id/dashboard", component: RetailStoreProvinceCenterDashboard},
  	{path:"/retailStoreProvinceCenter/:id/profile", component: RetailStoreProvinceCenterProfile},
  	{path:"/retailStoreProvinceCenter/:id/permission", component: RetailStoreProvinceCenterPermission},



  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterDepartmentList", component: this.getProvinceCenterDepartmentSearch()},
  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterDepartmentCreateForm", component: this.getProvinceCenterDepartmentCreateForm()},
  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterDepartmentUpdateForm", component: this.getProvinceCenterDepartmentUpdateForm()},
 
  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterEmployeeList", component: this.getProvinceCenterEmployeeSearch()},
  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterEmployeeCreateForm", component: this.getProvinceCenterEmployeeCreateForm()},
  	{path:"/retailStoreProvinceCenter/:id/list/provinceCenterEmployeeUpdateForm", component: this.getProvinceCenterEmployeeUpdateForm()},
 
  	{path:"/retailStoreProvinceCenter/:id/list/retailStoreCityServiceCenterList", component: this.getRetailStoreCityServiceCenterSearch()},
  	{path:"/retailStoreProvinceCenter/:id/list/retailStoreCityServiceCenterCreateForm", component: this.getRetailStoreCityServiceCenterCreateForm()},
  	{path:"/retailStoreProvinceCenter/:id/list/retailStoreCityServiceCenterUpdateForm", component: this.getRetailStoreCityServiceCenterUpdateForm()},
 

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

    const {searchLocalData}=GlobalComponents.RetailStoreProvinceCenterBase

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

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.retailStoreProvinceCenter,this.state.searchKeyword)}</div>

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

         {this.getNavMenuItems(this.props.retailStoreProvinceCenter,"inline","dark")}

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
  retailStoreProvinceCenter: state._retailStoreProvinceCenter,
  ...state,
}))(RetailStoreProvinceCenterBizApp)



