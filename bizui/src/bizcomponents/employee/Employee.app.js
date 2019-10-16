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
<<<<<<< HEAD
  AutoComplete,
  Input,Button
} from 'antd'
=======
  AutoComplete,Row, Col,
  Input,Button
} from 'antd'
import TopMenu from '../../launcher/TopMenu'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './Employee.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
<<<<<<< HEAD

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
=======
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

>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

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




class EmployeeBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
<<<<<<< HEAD
    // 把一级 Layout 的 children 作为菜单项
    // this.menus = getNavData().reduce((arr, current) => arr.concat(current.children), [])
    this.state = {
=======
     this.state = {
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
      return ['/employee/']
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
<<<<<<< HEAD
  
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/employee/${this.props.employee.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
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
               <Link to={`/employee/${this.props.employee.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
             </Menu.Item>
      
=======
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
               <Link to={`/employee/${this.props.employee.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		
        
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
           </Menu>
    )
  }
  



  getEmployeeCompanyTrainingSearch = () => {
    const {EmployeeCompanyTrainingSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "员工参与的公司培训",
      role: "employeeCompanyTraining",
      data: state._employee.employeeCompanyTrainingList,
      metaInfo: state._employee.employeeCompanyTrainingListMetaInfo,
      count: state._employee.employeeCompanyTrainingCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.employeeCompanyTrainingCurrentPageNumber,
      searchFormParameters: state._employee.employeeCompanyTrainingSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'employee', 
      listName: 'employeeCompanyTrainingList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '员工参与的公司培训列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeCompanyTrainingSearch)
  }
  getEmployeeCompanyTrainingCreateForm = () => {
   	const {EmployeeCompanyTrainingCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employeeCompanyTraining",
      data: state._employee.employeeCompanyTrainingList,
      metaInfo: state._employee.employeeCompanyTrainingListMetaInfo,
      count: state._employee.employeeCompanyTrainingCount,
<<<<<<< HEAD
      currentPage: state._employee.employeeCompanyTrainingCurrentPageNumber,
      searchFormParameters: state._employee.employeeCompanyTrainingSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeCompanyTrainingList', ref:state._employee, listDisplayName: '员工参与的公司培训列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeCompanyTrainingCurrentPageNumber,
      searchFormParameters: state._employee.employeeCompanyTrainingSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeCompanyTrainingList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeCompanyTrainingCreateForm)
  }
  
  getEmployeeCompanyTrainingUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeeCompanyTrainingUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeCompanyTraining",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeCompanyTrainingList', ref:state._employee, listDisplayName: '员工参与的公司培训列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeCompanyTrainingList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeCompanyTrainingUpdateForm)
  }

  getEmployeeSkillSearch = () => {
    const {EmployeeSkillSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "员工技能",
      role: "employeeSkill",
      data: state._employee.employeeSkillList,
      metaInfo: state._employee.employeeSkillListMetaInfo,
      count: state._employee.employeeSkillCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.employeeSkillCurrentPageNumber,
      searchFormParameters: state._employee.employeeSkillSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'employee', 
      listName: 'employeeSkillList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '员工技能列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeSkillSearch)
  }
  getEmployeeSkillCreateForm = () => {
   	const {EmployeeSkillCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employeeSkill",
      data: state._employee.employeeSkillList,
      metaInfo: state._employee.employeeSkillListMetaInfo,
      count: state._employee.employeeSkillCount,
<<<<<<< HEAD
      currentPage: state._employee.employeeSkillCurrentPageNumber,
      searchFormParameters: state._employee.employeeSkillSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeSkillList', ref:state._employee, listDisplayName: '员工技能列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeSkillCurrentPageNumber,
      searchFormParameters: state._employee.employeeSkillSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeSkillList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeSkillCreateForm)
  }
  
  getEmployeeSkillUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeeSkillUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeSkill",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeSkillList', ref:state._employee, listDisplayName: '员工技能列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeSkillList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeSkillUpdateForm)
  }

  getEmployeePerformanceSearch = () => {
    const {EmployeePerformanceSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "员工绩效",
      role: "employeePerformance",
      data: state._employee.employeePerformanceList,
      metaInfo: state._employee.employeePerformanceListMetaInfo,
      count: state._employee.employeePerformanceCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.employeePerformanceCurrentPageNumber,
      searchFormParameters: state._employee.employeePerformanceSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'employee', 
      listName: 'employeePerformanceList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '员工绩效列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeePerformanceSearch)
  }
  getEmployeePerformanceCreateForm = () => {
   	const {EmployeePerformanceCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employeePerformance",
      data: state._employee.employeePerformanceList,
      metaInfo: state._employee.employeePerformanceListMetaInfo,
      count: state._employee.employeePerformanceCount,
<<<<<<< HEAD
      currentPage: state._employee.employeePerformanceCurrentPageNumber,
      searchFormParameters: state._employee.employeePerformanceSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeePerformanceList', ref:state._employee, listDisplayName: '员工绩效列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeePerformanceCurrentPageNumber,
      searchFormParameters: state._employee.employeePerformanceSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeePerformanceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeePerformanceCreateForm)
  }
  
  getEmployeePerformanceUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeePerformanceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeePerformance",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'employeePerformanceList', ref:state._employee, listDisplayName: '员工绩效列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'employeePerformanceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeePerformanceUpdateForm)
  }

  getEmployeeWorkExperienceSearch = () => {
    const {EmployeeWorkExperienceSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "员工工作经验",
      role: "employeeWorkExperience",
      data: state._employee.employeeWorkExperienceList,
      metaInfo: state._employee.employeeWorkExperienceListMetaInfo,
      count: state._employee.employeeWorkExperienceCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.employeeWorkExperienceCurrentPageNumber,
      searchFormParameters: state._employee.employeeWorkExperienceSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'employee', 
      listName: 'employeeWorkExperienceList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '员工工作经验列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeWorkExperienceSearch)
  }
  getEmployeeWorkExperienceCreateForm = () => {
   	const {EmployeeWorkExperienceCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employeeWorkExperience",
      data: state._employee.employeeWorkExperienceList,
      metaInfo: state._employee.employeeWorkExperienceListMetaInfo,
      count: state._employee.employeeWorkExperienceCount,
<<<<<<< HEAD
      currentPage: state._employee.employeeWorkExperienceCurrentPageNumber,
      searchFormParameters: state._employee.employeeWorkExperienceSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeWorkExperienceList', ref:state._employee, listDisplayName: '员工工作经验列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeWorkExperienceCurrentPageNumber,
      searchFormParameters: state._employee.employeeWorkExperienceSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeWorkExperienceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeWorkExperienceCreateForm)
  }
  
  getEmployeeWorkExperienceUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeeWorkExperienceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeWorkExperience",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeWorkExperienceList', ref:state._employee, listDisplayName: '员工工作经验列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeWorkExperienceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeWorkExperienceUpdateForm)
  }

  getEmployeeLeaveSearch = () => {
    const {EmployeeLeaveSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "请假记录",
      role: "employeeLeave",
      data: state._employee.employeeLeaveList,
      metaInfo: state._employee.employeeLeaveListMetaInfo,
      count: state._employee.employeeLeaveCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.employeeLeaveCurrentPageNumber,
      searchFormParameters: state._employee.employeeLeaveSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'who', 
      listName: 'employeeLeaveList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '请假记录列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeLeaveSearch)
  }
  getEmployeeLeaveCreateForm = () => {
   	const {EmployeeLeaveCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employeeLeave",
      data: state._employee.employeeLeaveList,
      metaInfo: state._employee.employeeLeaveListMetaInfo,
      count: state._employee.employeeLeaveCount,
<<<<<<< HEAD
      currentPage: state._employee.employeeLeaveCurrentPageNumber,
      searchFormParameters: state._employee.employeeLeaveSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'who', listName: 'employeeLeaveList', ref:state._employee, listDisplayName: '请假记录列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeLeaveCurrentPageNumber,
      searchFormParameters: state._employee.employeeLeaveSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'who', listName: 'employeeLeaveList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeLeaveCreateForm)
  }
  
  getEmployeeLeaveUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeeLeaveUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeLeave",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeLeaveList', ref:state._employee, listDisplayName: '请假记录列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeLeaveList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeLeaveUpdateForm)
  }

  getEmployeeInterviewSearch = () => {
    const {EmployeeInterviewSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "员工面试",
      role: "employeeInterview",
      data: state._employee.employeeInterviewList,
      metaInfo: state._employee.employeeInterviewListMetaInfo,
      count: state._employee.employeeInterviewCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.employeeInterviewCurrentPageNumber,
      searchFormParameters: state._employee.employeeInterviewSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'employee', 
      listName: 'employeeInterviewList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '员工面试列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeInterviewSearch)
  }
  getEmployeeInterviewCreateForm = () => {
   	const {EmployeeInterviewCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employeeInterview",
      data: state._employee.employeeInterviewList,
      metaInfo: state._employee.employeeInterviewListMetaInfo,
      count: state._employee.employeeInterviewCount,
<<<<<<< HEAD
      currentPage: state._employee.employeeInterviewCurrentPageNumber,
      searchFormParameters: state._employee.employeeInterviewSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeInterviewList', ref:state._employee, listDisplayName: '员工面试列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeInterviewCurrentPageNumber,
      searchFormParameters: state._employee.employeeInterviewSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeInterviewList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeInterviewCreateForm)
  }
  
  getEmployeeInterviewUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeeInterviewUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeInterview",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeInterviewList', ref:state._employee, listDisplayName: '员工面试列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeInterviewList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeInterviewUpdateForm)
  }

  getEmployeeAttendanceSearch = () => {
    const {EmployeeAttendanceSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "员工考勤",
      role: "employeeAttendance",
      data: state._employee.employeeAttendanceList,
      metaInfo: state._employee.employeeAttendanceListMetaInfo,
      count: state._employee.employeeAttendanceCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.employeeAttendanceCurrentPageNumber,
      searchFormParameters: state._employee.employeeAttendanceSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'employee', 
      listName: 'employeeAttendanceList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '员工考勤列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeAttendanceSearch)
  }
  getEmployeeAttendanceCreateForm = () => {
   	const {EmployeeAttendanceCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employeeAttendance",
      data: state._employee.employeeAttendanceList,
      metaInfo: state._employee.employeeAttendanceListMetaInfo,
      count: state._employee.employeeAttendanceCount,
<<<<<<< HEAD
      currentPage: state._employee.employeeAttendanceCurrentPageNumber,
      searchFormParameters: state._employee.employeeAttendanceSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeAttendanceList', ref:state._employee, listDisplayName: '员工考勤列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeAttendanceCurrentPageNumber,
      searchFormParameters: state._employee.employeeAttendanceSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeAttendanceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeAttendanceCreateForm)
  }
  
  getEmployeeAttendanceUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeeAttendanceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeAttendance",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeAttendanceList', ref:state._employee, listDisplayName: '员工考勤列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeAttendanceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeAttendanceUpdateForm)
  }

  getEmployeeQualifierSearch = () => {
    const {EmployeeQualifierSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "员工资质",
      role: "employeeQualifier",
      data: state._employee.employeeQualifierList,
      metaInfo: state._employee.employeeQualifierListMetaInfo,
      count: state._employee.employeeQualifierCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.employeeQualifierCurrentPageNumber,
      searchFormParameters: state._employee.employeeQualifierSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'employee', 
      listName: 'employeeQualifierList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '员工资质列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeQualifierSearch)
  }
  getEmployeeQualifierCreateForm = () => {
   	const {EmployeeQualifierCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employeeQualifier",
      data: state._employee.employeeQualifierList,
      metaInfo: state._employee.employeeQualifierListMetaInfo,
      count: state._employee.employeeQualifierCount,
<<<<<<< HEAD
      currentPage: state._employee.employeeQualifierCurrentPageNumber,
      searchFormParameters: state._employee.employeeQualifierSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeQualifierList', ref:state._employee, listDisplayName: '员工资质列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeQualifierCurrentPageNumber,
      searchFormParameters: state._employee.employeeQualifierSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeQualifierList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeQualifierCreateForm)
  }
  
  getEmployeeQualifierUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeeQualifierUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeQualifier",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeQualifierList', ref:state._employee, listDisplayName: '员工资质列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeQualifierList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeQualifierUpdateForm)
  }

  getEmployeeEducationSearch = () => {
    const {EmployeeEducationSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "员工教育",
      role: "employeeEducation",
      data: state._employee.employeeEducationList,
      metaInfo: state._employee.employeeEducationListMetaInfo,
      count: state._employee.employeeEducationCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.employeeEducationCurrentPageNumber,
      searchFormParameters: state._employee.employeeEducationSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'employee', 
      listName: 'employeeEducationList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '员工教育列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeEducationSearch)
  }
  getEmployeeEducationCreateForm = () => {
   	const {EmployeeEducationCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employeeEducation",
      data: state._employee.employeeEducationList,
      metaInfo: state._employee.employeeEducationListMetaInfo,
      count: state._employee.employeeEducationCount,
<<<<<<< HEAD
      currentPage: state._employee.employeeEducationCurrentPageNumber,
      searchFormParameters: state._employee.employeeEducationSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeEducationList', ref:state._employee, listDisplayName: '员工教育列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeEducationCurrentPageNumber,
      searchFormParameters: state._employee.employeeEducationSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeEducationList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeEducationCreateForm)
  }
  
  getEmployeeEducationUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeeEducationUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeEducation",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeEducationList', ref:state._employee, listDisplayName: '员工教育列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeEducationList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeEducationUpdateForm)
  }

  getEmployeeAwardSearch = () => {
    const {EmployeeAwardSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "员工嘉奖",
      role: "employeeAward",
      data: state._employee.employeeAwardList,
      metaInfo: state._employee.employeeAwardListMetaInfo,
      count: state._employee.employeeAwardCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.employeeAwardCurrentPageNumber,
      searchFormParameters: state._employee.employeeAwardSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'employee', 
      listName: 'employeeAwardList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '员工嘉奖列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeAwardSearch)
  }
  getEmployeeAwardCreateForm = () => {
   	const {EmployeeAwardCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employeeAward",
      data: state._employee.employeeAwardList,
      metaInfo: state._employee.employeeAwardListMetaInfo,
      count: state._employee.employeeAwardCount,
<<<<<<< HEAD
      currentPage: state._employee.employeeAwardCurrentPageNumber,
      searchFormParameters: state._employee.employeeAwardSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeAwardList', ref:state._employee, listDisplayName: '员工嘉奖列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeAwardCurrentPageNumber,
      searchFormParameters: state._employee.employeeAwardSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeAwardList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeAwardCreateForm)
  }
  
  getEmployeeAwardUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeeAwardUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeAward",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeAwardList', ref:state._employee, listDisplayName: '员工嘉奖列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeAwardList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeAwardUpdateForm)
  }

  getEmployeeSalarySheetSearch = () => {
    const {EmployeeSalarySheetSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "工资单",
      role: "employeeSalarySheet",
      data: state._employee.employeeSalarySheetList,
      metaInfo: state._employee.employeeSalarySheetListMetaInfo,
      count: state._employee.employeeSalarySheetCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.employeeSalarySheetCurrentPageNumber,
      searchFormParameters: state._employee.employeeSalarySheetSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'employee', 
      listName: 'employeeSalarySheetList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '工资单列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeSalarySheetSearch)
  }
  getEmployeeSalarySheetCreateForm = () => {
   	const {EmployeeSalarySheetCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "employeeSalarySheet",
      data: state._employee.employeeSalarySheetList,
      metaInfo: state._employee.employeeSalarySheetListMetaInfo,
      count: state._employee.employeeSalarySheetCount,
<<<<<<< HEAD
      currentPage: state._employee.employeeSalarySheetCurrentPageNumber,
      searchFormParameters: state._employee.employeeSalarySheetSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeSalarySheetList', ref:state._employee, listDisplayName: '工资单列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeSalarySheetCurrentPageNumber,
      searchFormParameters: state._employee.employeeSalarySheetSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'employee', listName: 'employeeSalarySheetList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeSalarySheetCreateForm)
  }
  
  getEmployeeSalarySheetUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {EmployeeSalarySheetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeSalarySheet",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeSalarySheetList', ref:state._employee, listDisplayName: '工资单列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'employeeSalarySheetList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(EmployeeSalarySheetUpdateForm)
  }

  getPayingOffSearch = () => {
    const {PayingOffSearch} = GlobalComponents;
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      name: "工资支付",
      role: "payingOff",
      data: state._employee.payingOffList,
      metaInfo: state._employee.payingOffListMetaInfo,
      count: state._employee.payingOffCount,
<<<<<<< HEAD
=======
      returnURL: `/employee/${state._employee.id}/dashboard`,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      currentPage: state._employee.payingOffCurrentPageNumber,
      searchFormParameters: state._employee.payingOffSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id, 
      referenceName: 'paidFor', 
      listName: 'payingOffList', ref:state._employee, 
<<<<<<< HEAD
      listDisplayName: '工资支付列表' }, // this is for model namespace and
=======
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(PayingOffSearch)
  }
  getPayingOffCreateForm = () => {
   	const {PayingOffCreateForm} = GlobalComponents;
<<<<<<< HEAD
=======
   	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return connect(state => ({
      rule: state.rule,
      role: "payingOff",
      data: state._employee.payingOffList,
      metaInfo: state._employee.payingOffListMetaInfo,
      count: state._employee.payingOffCount,
<<<<<<< HEAD
      currentPage: state._employee.payingOffCurrentPageNumber,
      searchFormParameters: state._employee.payingOffSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'paidFor', listName: 'payingOffList', ref:state._employee, listDisplayName: '工资支付列表'}, // this is for model namespace and
=======
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.payingOffCurrentPageNumber,
      searchFormParameters: state._employee.payingOffSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id, referenceName: 'paidFor', listName: 'payingOffList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(PayingOffCreateForm)
  }
  
  getPayingOffUpdateForm = () => {
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	const {PayingOffUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "payingOff",
      currentUpdateIndex: state._employee.currentUpdateIndex,
<<<<<<< HEAD
      owner: { type: '_employee', id: state._employee.id, listName: 'payingOffList', ref:state._employee, listDisplayName: '工资支付列表' }, // this is for model namespace and
=======
      owner: { type: '_employee', id: state._employee.id, listName: 'payingOffList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }))(PayingOffUpdateForm)
  }


  
  buildRouters = () =>{
  	const {EmployeeDashboard} = GlobalComponents
<<<<<<< HEAD
  	const {EmployeePreference} = GlobalComponents
=======
  	const {EmployeePermission} = GlobalComponents
  	const {EmployeeProfile} = GlobalComponents
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	const routers=[
  	{path:"/employee/:id/dashboard", component: EmployeeDashboard},
<<<<<<< HEAD
  	{path:"/employee/:id/preference", component: EmployeePreference},
=======
  	{path:"/employee/:id/profile", component: EmployeeProfile},
  	{path:"/employee/:id/permission", component: EmployeePermission},
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  	
  	
  	
  	{path:"/employee/:id/list/employeeCompanyTrainingList", component: this.getEmployeeCompanyTrainingSearch()},
  	{path:"/employee/:id/list/employeeCompanyTrainingCreateForm", component: this.getEmployeeCompanyTrainingCreateForm()},
  	{path:"/employee/:id/list/employeeCompanyTrainingUpdateForm", component: this.getEmployeeCompanyTrainingUpdateForm()},
   	
  	{path:"/employee/:id/list/employeeSkillList", component: this.getEmployeeSkillSearch()},
  	{path:"/employee/:id/list/employeeSkillCreateForm", component: this.getEmployeeSkillCreateForm()},
  	{path:"/employee/:id/list/employeeSkillUpdateForm", component: this.getEmployeeSkillUpdateForm()},
   	
  	{path:"/employee/:id/list/employeePerformanceList", component: this.getEmployeePerformanceSearch()},
  	{path:"/employee/:id/list/employeePerformanceCreateForm", component: this.getEmployeePerformanceCreateForm()},
  	{path:"/employee/:id/list/employeePerformanceUpdateForm", component: this.getEmployeePerformanceUpdateForm()},
   	
  	{path:"/employee/:id/list/employeeWorkExperienceList", component: this.getEmployeeWorkExperienceSearch()},
  	{path:"/employee/:id/list/employeeWorkExperienceCreateForm", component: this.getEmployeeWorkExperienceCreateForm()},
  	{path:"/employee/:id/list/employeeWorkExperienceUpdateForm", component: this.getEmployeeWorkExperienceUpdateForm()},
   	
  	{path:"/employee/:id/list/employeeLeaveList", component: this.getEmployeeLeaveSearch()},
  	{path:"/employee/:id/list/employeeLeaveCreateForm", component: this.getEmployeeLeaveCreateForm()},
  	{path:"/employee/:id/list/employeeLeaveUpdateForm", component: this.getEmployeeLeaveUpdateForm()},
   	
  	{path:"/employee/:id/list/employeeInterviewList", component: this.getEmployeeInterviewSearch()},
  	{path:"/employee/:id/list/employeeInterviewCreateForm", component: this.getEmployeeInterviewCreateForm()},
  	{path:"/employee/:id/list/employeeInterviewUpdateForm", component: this.getEmployeeInterviewUpdateForm()},
   	
  	{path:"/employee/:id/list/employeeAttendanceList", component: this.getEmployeeAttendanceSearch()},
  	{path:"/employee/:id/list/employeeAttendanceCreateForm", component: this.getEmployeeAttendanceCreateForm()},
  	{path:"/employee/:id/list/employeeAttendanceUpdateForm", component: this.getEmployeeAttendanceUpdateForm()},
   	
  	{path:"/employee/:id/list/employeeQualifierList", component: this.getEmployeeQualifierSearch()},
  	{path:"/employee/:id/list/employeeQualifierCreateForm", component: this.getEmployeeQualifierCreateForm()},
  	{path:"/employee/:id/list/employeeQualifierUpdateForm", component: this.getEmployeeQualifierUpdateForm()},
   	
  	{path:"/employee/:id/list/employeeEducationList", component: this.getEmployeeEducationSearch()},
  	{path:"/employee/:id/list/employeeEducationCreateForm", component: this.getEmployeeEducationCreateForm()},
  	{path:"/employee/:id/list/employeeEducationUpdateForm", component: this.getEmployeeEducationUpdateForm()},
   	
  	{path:"/employee/:id/list/employeeAwardList", component: this.getEmployeeAwardSearch()},
  	{path:"/employee/:id/list/employeeAwardCreateForm", component: this.getEmployeeAwardCreateForm()},
  	{path:"/employee/:id/list/employeeAwardUpdateForm", component: this.getEmployeeAwardUpdateForm()},
   	
  	{path:"/employee/:id/list/employeeSalarySheetList", component: this.getEmployeeSalarySheetSearch()},
  	{path:"/employee/:id/list/employeeSalarySheetCreateForm", component: this.getEmployeeSalarySheetCreateForm()},
  	{path:"/employee/:id/list/employeeSalarySheetUpdateForm", component: this.getEmployeeSalarySheetUpdateForm()},
   	
  	{path:"/employee/:id/list/payingOffList", component: this.getPayingOffSearch()},
  	{path:"/employee/:id/list/payingOffCreateForm", component: this.getPayingOffCreateForm()},
  	{path:"/employee/:id/list/payingOffUpdateForm", component: this.getPayingOffUpdateForm()},
     	
  	
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
<<<<<<< HEAD
     const { breadcrumb }  = this.props

     //const {EmployeeEditDetail} = GlobalComponents
     //const {EmployeeViewDetail} = GlobalComponents
     
     
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

		 {this.getNavMenuItems(this.props.employee)}
		 
         </Sider>
         <Layout>
=======
     
  
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
 <Header>
          
        <Row type="flex" justify="start" align="bottom">
        
        <Col {...naviBarResponsiveStyle} >
            <Dropdown overlay= {this.getNavMenuItems(this.props.employee)}>
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
       <Layout>
       
         
         <Layout>
         
            
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
  employee: state._employee,
  ...state,
}))(EmployeeBizApp)



