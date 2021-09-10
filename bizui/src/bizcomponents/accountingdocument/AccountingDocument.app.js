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
import styles from './AccountingDocument.app.less'
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





class AccountingDocumentBizApp extends React.PureComponent {
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

 getNavMenuItems = (targetObject, style, customTheme) => {


    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
    const mode =style || "inline"
    const theme = customTheme || "light"
	const {objectId}=targetApp;
  	const userContext = null
  	const viewGroupIconNameOf=window.viewGroupIconNameOf
    const viewGroupDisplayNameOf=window.viewGroupDisplayNameOf

    return (
	  <Menu
        theme="dark"
        mode="inline"

        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}

       >

       <Menu.Item key="workbench">
        <Link to={`/accountingDocument/${this.props.accountingDocument.id}/workbench`}><Icon type="solution" style={{marginRight:"20px"}}/><span>工作台</span></Link>
      </Menu.Item>

        
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu id={`submenu-vg${index}`}  key={`vg${index}`} title={<span><Icon type={viewGroupIconNameOf('accounting_document',`${groupedMenuItem.viewGroup}`)} style={{marginRight:"20px"}} /><span>{viewGroupDisplayNameOf('accounting_document',`${groupedMenuItem.viewGroup}`)}</span></span>} >
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



  getOriginalVoucherSearch = () => {
    const {OriginalVoucherSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('original_voucher','accounting_document.original_voucher_list',false),
      role: "originalVoucher",
      data: state._accountingDocument.originalVoucherList,
      metaInfo: state._accountingDocument.originalVoucherListMetaInfo,
      count: state._accountingDocument.originalVoucherCount,
      returnURL: `/accountingDocument/${state._accountingDocument.id}/workbench`,
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
      initValue: this.getSelectedRows(),
      role: "originalVoucher",
      data: state._accountingDocument.originalVoucherList,
      metaInfo: state._accountingDocument.originalVoucherListMetaInfo,
      count: state._accountingDocument.originalVoucherCount,
      returnURL: `/accountingDocument/${state._accountingDocument.id}/list`,
      currentPage: state._accountingDocument.originalVoucherCurrentPageNumber,
      searchFormParameters: state._accountingDocument.originalVoucherSearchFormParameters,
      loading: state._accountingDocument.loading,
      owner: { type: '_accountingDocument', id: state._accountingDocument.id || this.getOwnerId(), referenceName: 'belongsTo', listName: 'originalVoucherList', ref:state._accountingDocument, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(OriginalVoucherCreateForm)
  }

  getOriginalVoucherUpdateForm = () => {
    const userContext = null
  	const {OriginalVoucherUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._accountingDocument.selectedRows,
      role: "originalVoucher",
      currentUpdateIndex: state._accountingDocument.currentUpdateIndex || 0,
      owner: { type: '_accountingDocument', id: state._accountingDocument.id || this.getOwnerId(), listName: 'originalVoucherList', ref:state._accountingDocument, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(OriginalVoucherUpdateForm)
  }

  getAccountingDocumentLineSearch = () => {
    const {AccountingDocumentLineSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('accounting_document_line','accounting_document.accounting_document_line_list',false),
      role: "accountingDocumentLine",
      data: state._accountingDocument.accountingDocumentLineList,
      metaInfo: state._accountingDocument.accountingDocumentLineListMetaInfo,
      count: state._accountingDocument.accountingDocumentLineCount,
      returnURL: `/accountingDocument/${state._accountingDocument.id}/workbench`,
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
      initValue: this.getSelectedRows(),
      role: "accountingDocumentLine",
      data: state._accountingDocument.accountingDocumentLineList,
      metaInfo: state._accountingDocument.accountingDocumentLineListMetaInfo,
      count: state._accountingDocument.accountingDocumentLineCount,
      returnURL: `/accountingDocument/${state._accountingDocument.id}/list`,
      currentPage: state._accountingDocument.accountingDocumentLineCurrentPageNumber,
      searchFormParameters: state._accountingDocument.accountingDocumentLineSearchFormParameters,
      loading: state._accountingDocument.loading,
      owner: { type: '_accountingDocument', id: state._accountingDocument.id || this.getOwnerId(), referenceName: 'belongsTo', listName: 'accountingDocumentLineList', ref:state._accountingDocument, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AccountingDocumentLineCreateForm)
  }

  getAccountingDocumentLineUpdateForm = () => {
    const userContext = null
  	const {AccountingDocumentLineUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._accountingDocument.selectedRows,
      role: "accountingDocumentLine",
      currentUpdateIndex: state._accountingDocument.currentUpdateIndex || 0,
      owner: { type: '_accountingDocument', id: state._accountingDocument.id || this.getOwnerId(), listName: 'accountingDocumentLineList', ref:state._accountingDocument, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AccountingDocumentLineUpdateForm)
  }


  getRequestTypeStepForm = () => {
    const userContext = null
  	 const {ChangeRequestStepForm} = GlobalComponents
    return connect(state => ({
      selectedRows: state._accountingDocument.selectedRows,
      role: "cq",
      currentUpdateIndex: state._accountingDocument.currentUpdateIndex,
      owner: { type: '_accountingDocument', id: state._accountingDocument.id, listName: 'nolist', ref:state._accountingDocument, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestStepForm)
  }



  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '双链小超全流程供应链系统'
    return title
  }

  buildRouters = () =>{
    const {AccountingDocumentWorkbench} = GlobalComponents

    const {AccountingDocumentDashboard} = GlobalComponents
  	const {AccountingDocumentPermission} = GlobalComponents
  	const {AccountingDocumentProfile} = GlobalComponents


    const routers=[
    {path:"/accountingDocument/:id/workbench", component: AccountingDocumentWorkbench},
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

    const {searchLocalData}=GlobalComponents.AccountingDocumentBase

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

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.accountingDocument,this.state.searchKeyword)}</div>

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

         {this.getNavMenuItems(this.props.accountingDocument,"inline","dark")}

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
  accountingDocument: state._accountingDocument,
  ...state,
}))(AccountingDocumentBizApp)



