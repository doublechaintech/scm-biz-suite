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
import styles from './AccountingDocument.app.less'
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




class AccountingDocumentBizApp extends React.PureComponent {
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
      return ['/accountingDocument/']
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
               <Link to={`/accountingDocument/${this.props.accountingDocument.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
  



  getOriginalVoucherSearch = () => {
    const {OriginalVoucherSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "原始凭证",
      role: "originalVoucher",
      data: state._accountingDocument.originalVoucherList,
      metaInfo: state._accountingDocument.originalVoucherListMetaInfo,
      count: state._accountingDocument.originalVoucherCount,
      returnURL: `/accountingDocument/${state._accountingDocument.id}/dashboard`,
      currentPage: state._accountingDocument.originalVoucherCurrentPageNumber,
      searchFormParameters: state._accountingDocument.originalVoucherSearchFormParameters,
      searchParameters: {...state._accountingDocument.searchParameters},
      expandForm: state._accountingDocument.expandForm,
      loading: state._accountingDocument.loading,
      partialList: state._accountingDocument.partialList,
      owner: { type: '_accountingDocument', id: state._accountingDocument.id, 
      referenceName: 'belongsTo', 
      listName: 'originalVoucherList', ref:state._accountingDocument, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(OriginalVoucherSearch)
  }
  getOriginalVoucherCreateForm = () => {
   	const {OriginalVoucherCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "originalVoucher",
      data: state._accountingDocument.originalVoucherList,
      metaInfo: state._accountingDocument.originalVoucherListMetaInfo,
      count: state._accountingDocument.originalVoucherCount,
      returnURL: `/accountingDocument/${state._accountingDocument.id}/list`,
      currentPage: state._accountingDocument.originalVoucherCurrentPageNumber,
      searchFormParameters: state._accountingDocument.originalVoucherSearchFormParameters,
      loading: state._accountingDocument.loading,
      owner: { type: '_accountingDocument', id: state._accountingDocument.id, referenceName: 'belongsTo', listName: 'originalVoucherList', ref:state._accountingDocument, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(OriginalVoucherCreateForm)
  }
  
  getOriginalVoucherUpdateForm = () => {
    const userContext = null
  	const {OriginalVoucherUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._accountingDocument.selectedRows,
      role: "originalVoucher",
      currentUpdateIndex: state._accountingDocument.currentUpdateIndex,
      owner: { type: '_accountingDocument', id: state._accountingDocument.id, listName: 'originalVoucherList', ref:state._accountingDocument, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(OriginalVoucherUpdateForm)
  }

  getAccountingDocumentLineSearch = () => {
    const {AccountingDocumentLineSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "会计凭证行",
      role: "accountingDocumentLine",
      data: state._accountingDocument.accountingDocumentLineList,
      metaInfo: state._accountingDocument.accountingDocumentLineListMetaInfo,
      count: state._accountingDocument.accountingDocumentLineCount,
      returnURL: `/accountingDocument/${state._accountingDocument.id}/dashboard`,
      currentPage: state._accountingDocument.accountingDocumentLineCurrentPageNumber,
      searchFormParameters: state._accountingDocument.accountingDocumentLineSearchFormParameters,
      searchParameters: {...state._accountingDocument.searchParameters},
      expandForm: state._accountingDocument.expandForm,
      loading: state._accountingDocument.loading,
      partialList: state._accountingDocument.partialList,
      owner: { type: '_accountingDocument', id: state._accountingDocument.id, 
      referenceName: 'belongsTo', 
      listName: 'accountingDocumentLineList', ref:state._accountingDocument, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountingDocumentLineSearch)
  }
  getAccountingDocumentLineCreateForm = () => {
   	const {AccountingDocumentLineCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "accountingDocumentLine",
      data: state._accountingDocument.accountingDocumentLineList,
      metaInfo: state._accountingDocument.accountingDocumentLineListMetaInfo,
      count: state._accountingDocument.accountingDocumentLineCount,
      returnURL: `/accountingDocument/${state._accountingDocument.id}/list`,
      currentPage: state._accountingDocument.accountingDocumentLineCurrentPageNumber,
      searchFormParameters: state._accountingDocument.accountingDocumentLineSearchFormParameters,
      loading: state._accountingDocument.loading,
      owner: { type: '_accountingDocument', id: state._accountingDocument.id, referenceName: 'belongsTo', listName: 'accountingDocumentLineList', ref:state._accountingDocument, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AccountingDocumentLineCreateForm)
  }
  
  getAccountingDocumentLineUpdateForm = () => {
    const userContext = null
  	const {AccountingDocumentLineUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._accountingDocument.selectedRows,
      role: "accountingDocumentLine",
      currentUpdateIndex: state._accountingDocument.currentUpdateIndex,
      owner: { type: '_accountingDocument', id: state._accountingDocument.id, listName: 'accountingDocumentLineList', ref:state._accountingDocument, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountingDocumentLineUpdateForm)
  }


  
  buildRouters = () =>{
  	const {AccountingDocumentDashboard} = GlobalComponents
  	const {AccountingDocumentPermission} = GlobalComponents
  	const {AccountingDocumentProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/accountingDocument/:id/dashboard", component: AccountingDocumentDashboard},
  	{path:"/accountingDocument/:id/profile", component: AccountingDocumentProfile},
  	{path:"/accountingDocument/:id/permission", component: AccountingDocumentPermission},
  	
  	
  	
  	{path:"/accountingDocument/:id/list/originalVoucherList", component: this.getOriginalVoucherSearch()},
  	{path:"/accountingDocument/:id/list/originalVoucherCreateForm", component: this.getOriginalVoucherCreateForm()},
  	{path:"/accountingDocument/:id/list/originalVoucherUpdateForm", component: this.getOriginalVoucherUpdateForm()},
   	
  	{path:"/accountingDocument/:id/list/accountingDocumentLineList", component: this.getAccountingDocumentLineSearch()},
  	{path:"/accountingDocument/:id/list/accountingDocumentLineCreateForm", component: this.getAccountingDocumentLineCreateForm()},
  	{path:"/accountingDocument/:id/list/accountingDocumentLineUpdateForm", component: this.getAccountingDocumentLineUpdateForm()},
     	
  	
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
            <Dropdown overlay= {this.getNavMenuItems(this.props.accountingDocument)}>
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
  accountingDocument: state._accountingDocument,
  ...state,
}))(AccountingDocumentBizApp)



