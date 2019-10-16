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
import styles from './GenericForm.app.less'
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




class GenericFormBizApp extends React.PureComponent {
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
      return ['/genericForm/']
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
               <Link to={`/genericForm/${this.props.genericForm.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getFormMessageSearch = () => {
    const {FormMessageSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "表单信息",
      role: "formMessage",
      data: state._genericForm.formMessageList,
      metaInfo: state._genericForm.formMessageListMetaInfo,
      count: state._genericForm.formMessageCount,
      returnURL: `/genericForm/${state._genericForm.id}/dashboard`,
      currentPage: state._genericForm.formMessageCurrentPageNumber,
      searchFormParameters: state._genericForm.formMessageSearchFormParameters,
      searchParameters: {...state._genericForm.searchParameters},
      expandForm: state._genericForm.expandForm,
      loading: state._genericForm.loading,
      partialList: state._genericForm.partialList,
      owner: { type: '_genericForm', id: state._genericForm.id, 
      referenceName: 'form', 
      listName: 'formMessageList', ref:state._genericForm, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(FormMessageSearch)
  }
  getFormMessageCreateForm = () => {
   	const {FormMessageCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "formMessage",
      data: state._genericForm.formMessageList,
      metaInfo: state._genericForm.formMessageListMetaInfo,
      count: state._genericForm.formMessageCount,
      returnURL: `/genericForm/${state._genericForm.id}/list`,
      currentPage: state._genericForm.formMessageCurrentPageNumber,
      searchFormParameters: state._genericForm.formMessageSearchFormParameters,
      loading: state._genericForm.loading,
      owner: { type: '_genericForm', id: state._genericForm.id, referenceName: 'form', listName: 'formMessageList', ref:state._genericForm, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(FormMessageCreateForm)
  }
  
  getFormMessageUpdateForm = () => {
    const userContext = null
  	const {FormMessageUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._genericForm.selectedRows,
      role: "formMessage",
      currentUpdateIndex: state._genericForm.currentUpdateIndex,
      owner: { type: '_genericForm', id: state._genericForm.id, listName: 'formMessageList', ref:state._genericForm, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(FormMessageUpdateForm)
  }

  getFormFieldMessageSearch = () => {
    const {FormFieldMessageSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "表单字段的信息",
      role: "formFieldMessage",
      data: state._genericForm.formFieldMessageList,
      metaInfo: state._genericForm.formFieldMessageListMetaInfo,
      count: state._genericForm.formFieldMessageCount,
      returnURL: `/genericForm/${state._genericForm.id}/dashboard`,
      currentPage: state._genericForm.formFieldMessageCurrentPageNumber,
      searchFormParameters: state._genericForm.formFieldMessageSearchFormParameters,
      searchParameters: {...state._genericForm.searchParameters},
      expandForm: state._genericForm.expandForm,
      loading: state._genericForm.loading,
      partialList: state._genericForm.partialList,
      owner: { type: '_genericForm', id: state._genericForm.id, 
      referenceName: 'form', 
      listName: 'formFieldMessageList', ref:state._genericForm, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(FormFieldMessageSearch)
  }
  getFormFieldMessageCreateForm = () => {
   	const {FormFieldMessageCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "formFieldMessage",
      data: state._genericForm.formFieldMessageList,
      metaInfo: state._genericForm.formFieldMessageListMetaInfo,
      count: state._genericForm.formFieldMessageCount,
      returnURL: `/genericForm/${state._genericForm.id}/list`,
      currentPage: state._genericForm.formFieldMessageCurrentPageNumber,
      searchFormParameters: state._genericForm.formFieldMessageSearchFormParameters,
      loading: state._genericForm.loading,
      owner: { type: '_genericForm', id: state._genericForm.id, referenceName: 'form', listName: 'formFieldMessageList', ref:state._genericForm, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(FormFieldMessageCreateForm)
  }
  
  getFormFieldMessageUpdateForm = () => {
    const userContext = null
  	const {FormFieldMessageUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._genericForm.selectedRows,
      role: "formFieldMessage",
      currentUpdateIndex: state._genericForm.currentUpdateIndex,
      owner: { type: '_genericForm', id: state._genericForm.id, listName: 'formFieldMessageList', ref:state._genericForm, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(FormFieldMessageUpdateForm)
  }

  getFormFieldSearch = () => {
    const {FormFieldSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "表单字段",
      role: "formField",
      data: state._genericForm.formFieldList,
      metaInfo: state._genericForm.formFieldListMetaInfo,
      count: state._genericForm.formFieldCount,
      returnURL: `/genericForm/${state._genericForm.id}/dashboard`,
      currentPage: state._genericForm.formFieldCurrentPageNumber,
      searchFormParameters: state._genericForm.formFieldSearchFormParameters,
      searchParameters: {...state._genericForm.searchParameters},
      expandForm: state._genericForm.expandForm,
      loading: state._genericForm.loading,
      partialList: state._genericForm.partialList,
      owner: { type: '_genericForm', id: state._genericForm.id, 
      referenceName: 'form', 
      listName: 'formFieldList', ref:state._genericForm, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(FormFieldSearch)
  }
  getFormFieldCreateForm = () => {
   	const {FormFieldCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "formField",
      data: state._genericForm.formFieldList,
      metaInfo: state._genericForm.formFieldListMetaInfo,
      count: state._genericForm.formFieldCount,
      returnURL: `/genericForm/${state._genericForm.id}/list`,
      currentPage: state._genericForm.formFieldCurrentPageNumber,
      searchFormParameters: state._genericForm.formFieldSearchFormParameters,
      loading: state._genericForm.loading,
      owner: { type: '_genericForm', id: state._genericForm.id, referenceName: 'form', listName: 'formFieldList', ref:state._genericForm, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(FormFieldCreateForm)
  }
  
  getFormFieldUpdateForm = () => {
    const userContext = null
  	const {FormFieldUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._genericForm.selectedRows,
      role: "formField",
      currentUpdateIndex: state._genericForm.currentUpdateIndex,
      owner: { type: '_genericForm', id: state._genericForm.id, listName: 'formFieldList', ref:state._genericForm, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(FormFieldUpdateForm)
  }

  getFormActionSearch = () => {
    const {FormActionSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "表单动作",
      role: "formAction",
      data: state._genericForm.formActionList,
      metaInfo: state._genericForm.formActionListMetaInfo,
      count: state._genericForm.formActionCount,
      returnURL: `/genericForm/${state._genericForm.id}/dashboard`,
      currentPage: state._genericForm.formActionCurrentPageNumber,
      searchFormParameters: state._genericForm.formActionSearchFormParameters,
      searchParameters: {...state._genericForm.searchParameters},
      expandForm: state._genericForm.expandForm,
      loading: state._genericForm.loading,
      partialList: state._genericForm.partialList,
      owner: { type: '_genericForm', id: state._genericForm.id, 
      referenceName: 'form', 
      listName: 'formActionList', ref:state._genericForm, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(FormActionSearch)
  }
  getFormActionCreateForm = () => {
   	const {FormActionCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "formAction",
      data: state._genericForm.formActionList,
      metaInfo: state._genericForm.formActionListMetaInfo,
      count: state._genericForm.formActionCount,
      returnURL: `/genericForm/${state._genericForm.id}/list`,
      currentPage: state._genericForm.formActionCurrentPageNumber,
      searchFormParameters: state._genericForm.formActionSearchFormParameters,
      loading: state._genericForm.loading,
      owner: { type: '_genericForm', id: state._genericForm.id, referenceName: 'form', listName: 'formActionList', ref:state._genericForm, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(FormActionCreateForm)
  }
  
  getFormActionUpdateForm = () => {
    const userContext = null
  	const {FormActionUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._genericForm.selectedRows,
      role: "formAction",
      currentUpdateIndex: state._genericForm.currentUpdateIndex,
      owner: { type: '_genericForm', id: state._genericForm.id, listName: 'formActionList', ref:state._genericForm, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(FormActionUpdateForm)
  }


  
  buildRouters = () =>{
  	const {GenericFormDashboard} = GlobalComponents
  	const {GenericFormPermission} = GlobalComponents
  	const {GenericFormProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/genericForm/:id/dashboard", component: GenericFormDashboard},
  	{path:"/genericForm/:id/profile", component: GenericFormProfile},
  	{path:"/genericForm/:id/permission", component: GenericFormPermission},
  	
  	
  	
  	{path:"/genericForm/:id/list/formMessageList", component: this.getFormMessageSearch()},
  	{path:"/genericForm/:id/list/formMessageCreateForm", component: this.getFormMessageCreateForm()},
  	{path:"/genericForm/:id/list/formMessageUpdateForm", component: this.getFormMessageUpdateForm()},
   	
  	{path:"/genericForm/:id/list/formFieldMessageList", component: this.getFormFieldMessageSearch()},
  	{path:"/genericForm/:id/list/formFieldMessageCreateForm", component: this.getFormFieldMessageCreateForm()},
  	{path:"/genericForm/:id/list/formFieldMessageUpdateForm", component: this.getFormFieldMessageUpdateForm()},
   	
  	{path:"/genericForm/:id/list/formFieldList", component: this.getFormFieldSearch()},
  	{path:"/genericForm/:id/list/formFieldCreateForm", component: this.getFormFieldCreateForm()},
  	{path:"/genericForm/:id/list/formFieldUpdateForm", component: this.getFormFieldUpdateForm()},
   	
  	{path:"/genericForm/:id/list/formActionList", component: this.getFormActionSearch()},
  	{path:"/genericForm/:id/list/formActionCreateForm", component: this.getFormActionCreateForm()},
  	{path:"/genericForm/:id/list/formActionUpdateForm", component: this.getFormActionUpdateForm()},
     	
  	
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
            <Dropdown overlay= {this.getNavMenuItems(this.props.genericForm)}>
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
  genericForm: state._genericForm,
  ...state,
}))(GenericFormBizApp)



