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
import styles from './Employee.app.less'
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





class EmployeeBizApp extends React.PureComponent {
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
        <Link to={`/employee/${this.props.employee.id}/workbench`}><Icon type="solution" style={{marginRight:"20px"}}/><span>工作台</span></Link>
      </Menu.Item>

        
             <Menu.Item key="dashboard">
               <Link to={`/employee/${this.props.employee.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
        
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu id={`submenu-vg${index}`}  key={`vg${index}`} title={<span><Icon type={viewGroupIconNameOf('employee',`${groupedMenuItem.viewGroup}`)} style={{marginRight:"20px"}} /><span>{viewGroupDisplayNameOf('employee',`${groupedMenuItem.viewGroup}`)}</span></span>} >
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



  getEmployeeCompanyTrainingSearch = () => {
    const {EmployeeCompanyTrainingSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee_company_training','employee.employee_company_training_list',false),
      role: "employeeCompanyTraining",
      data: state._employee.employeeCompanyTrainingList,
      metaInfo: state._employee.employeeCompanyTrainingListMetaInfo,
      count: state._employee.employeeCompanyTrainingCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.employeeCompanyTrainingCurrentPageNumber,
      searchFormParameters: state._employee.employeeCompanyTrainingSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'employee',
      listName: 'employeeCompanyTrainingList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeCompanyTrainingSearch)
  }

  getEmployeeCompanyTrainingCreateForm = () => {
   	const {EmployeeCompanyTrainingCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employeeCompanyTraining",
      data: state._employee.employeeCompanyTrainingList,
      metaInfo: state._employee.employeeCompanyTrainingListMetaInfo,
      count: state._employee.employeeCompanyTrainingCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeCompanyTrainingCurrentPageNumber,
      searchFormParameters: state._employee.employeeCompanyTrainingSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'employee', listName: 'employeeCompanyTrainingList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeCompanyTrainingCreateForm)
  }

  getEmployeeCompanyTrainingUpdateForm = () => {
    const userContext = null
  	const {EmployeeCompanyTrainingUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeCompanyTraining",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'employeeCompanyTrainingList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeCompanyTrainingUpdateForm)
  }

  getEmployeeSkillSearch = () => {
    const {EmployeeSkillSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee_skill','employee.employee_skill_list',false),
      role: "employeeSkill",
      data: state._employee.employeeSkillList,
      metaInfo: state._employee.employeeSkillListMetaInfo,
      count: state._employee.employeeSkillCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.employeeSkillCurrentPageNumber,
      searchFormParameters: state._employee.employeeSkillSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'employee',
      listName: 'employeeSkillList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeSkillSearch)
  }

  getEmployeeSkillCreateForm = () => {
   	const {EmployeeSkillCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employeeSkill",
      data: state._employee.employeeSkillList,
      metaInfo: state._employee.employeeSkillListMetaInfo,
      count: state._employee.employeeSkillCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeSkillCurrentPageNumber,
      searchFormParameters: state._employee.employeeSkillSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'employee', listName: 'employeeSkillList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeSkillCreateForm)
  }

  getEmployeeSkillUpdateForm = () => {
    const userContext = null
  	const {EmployeeSkillUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeSkill",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'employeeSkillList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeSkillUpdateForm)
  }

  getEmployeePerformanceSearch = () => {
    const {EmployeePerformanceSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee_performance','employee.employee_performance_list',false),
      role: "employeePerformance",
      data: state._employee.employeePerformanceList,
      metaInfo: state._employee.employeePerformanceListMetaInfo,
      count: state._employee.employeePerformanceCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.employeePerformanceCurrentPageNumber,
      searchFormParameters: state._employee.employeePerformanceSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'employee',
      listName: 'employeePerformanceList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeePerformanceSearch)
  }

  getEmployeePerformanceCreateForm = () => {
   	const {EmployeePerformanceCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employeePerformance",
      data: state._employee.employeePerformanceList,
      metaInfo: state._employee.employeePerformanceListMetaInfo,
      count: state._employee.employeePerformanceCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeePerformanceCurrentPageNumber,
      searchFormParameters: state._employee.employeePerformanceSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'employee', listName: 'employeePerformanceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeePerformanceCreateForm)
  }

  getEmployeePerformanceUpdateForm = () => {
    const userContext = null
  	const {EmployeePerformanceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeePerformance",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'employeePerformanceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeePerformanceUpdateForm)
  }

  getEmployeeWorkExperienceSearch = () => {
    const {EmployeeWorkExperienceSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee_work_experience','employee.employee_work_experience_list',false),
      role: "employeeWorkExperience",
      data: state._employee.employeeWorkExperienceList,
      metaInfo: state._employee.employeeWorkExperienceListMetaInfo,
      count: state._employee.employeeWorkExperienceCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.employeeWorkExperienceCurrentPageNumber,
      searchFormParameters: state._employee.employeeWorkExperienceSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'employee',
      listName: 'employeeWorkExperienceList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeWorkExperienceSearch)
  }

  getEmployeeWorkExperienceCreateForm = () => {
   	const {EmployeeWorkExperienceCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employeeWorkExperience",
      data: state._employee.employeeWorkExperienceList,
      metaInfo: state._employee.employeeWorkExperienceListMetaInfo,
      count: state._employee.employeeWorkExperienceCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeWorkExperienceCurrentPageNumber,
      searchFormParameters: state._employee.employeeWorkExperienceSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'employee', listName: 'employeeWorkExperienceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeWorkExperienceCreateForm)
  }

  getEmployeeWorkExperienceUpdateForm = () => {
    const userContext = null
  	const {EmployeeWorkExperienceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeWorkExperience",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'employeeWorkExperienceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeWorkExperienceUpdateForm)
  }

  getEmployeeLeaveSearch = () => {
    const {EmployeeLeaveSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee_leave','employee.employee_leave_list',false),
      role: "employeeLeave",
      data: state._employee.employeeLeaveList,
      metaInfo: state._employee.employeeLeaveListMetaInfo,
      count: state._employee.employeeLeaveCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.employeeLeaveCurrentPageNumber,
      searchFormParameters: state._employee.employeeLeaveSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'who',
      listName: 'employeeLeaveList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeLeaveSearch)
  }

  getEmployeeLeaveCreateForm = () => {
   	const {EmployeeLeaveCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employeeLeave",
      data: state._employee.employeeLeaveList,
      metaInfo: state._employee.employeeLeaveListMetaInfo,
      count: state._employee.employeeLeaveCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeLeaveCurrentPageNumber,
      searchFormParameters: state._employee.employeeLeaveSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'who', listName: 'employeeLeaveList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeLeaveCreateForm)
  }

  getEmployeeLeaveUpdateForm = () => {
    const userContext = null
  	const {EmployeeLeaveUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeLeave",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'employeeLeaveList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeLeaveUpdateForm)
  }

  getEmployeeInterviewSearch = () => {
    const {EmployeeInterviewSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee_interview','employee.employee_interview_list',false),
      role: "employeeInterview",
      data: state._employee.employeeInterviewList,
      metaInfo: state._employee.employeeInterviewListMetaInfo,
      count: state._employee.employeeInterviewCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.employeeInterviewCurrentPageNumber,
      searchFormParameters: state._employee.employeeInterviewSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'employee',
      listName: 'employeeInterviewList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeInterviewSearch)
  }

  getEmployeeInterviewCreateForm = () => {
   	const {EmployeeInterviewCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employeeInterview",
      data: state._employee.employeeInterviewList,
      metaInfo: state._employee.employeeInterviewListMetaInfo,
      count: state._employee.employeeInterviewCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeInterviewCurrentPageNumber,
      searchFormParameters: state._employee.employeeInterviewSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'employee', listName: 'employeeInterviewList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeInterviewCreateForm)
  }

  getEmployeeInterviewUpdateForm = () => {
    const userContext = null
  	const {EmployeeInterviewUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeInterview",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'employeeInterviewList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeInterviewUpdateForm)
  }

  getEmployeeAttendanceSearch = () => {
    const {EmployeeAttendanceSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee_attendance','employee.employee_attendance_list',false),
      role: "employeeAttendance",
      data: state._employee.employeeAttendanceList,
      metaInfo: state._employee.employeeAttendanceListMetaInfo,
      count: state._employee.employeeAttendanceCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.employeeAttendanceCurrentPageNumber,
      searchFormParameters: state._employee.employeeAttendanceSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'employee',
      listName: 'employeeAttendanceList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeAttendanceSearch)
  }

  getEmployeeAttendanceCreateForm = () => {
   	const {EmployeeAttendanceCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employeeAttendance",
      data: state._employee.employeeAttendanceList,
      metaInfo: state._employee.employeeAttendanceListMetaInfo,
      count: state._employee.employeeAttendanceCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeAttendanceCurrentPageNumber,
      searchFormParameters: state._employee.employeeAttendanceSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'employee', listName: 'employeeAttendanceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeAttendanceCreateForm)
  }

  getEmployeeAttendanceUpdateForm = () => {
    const userContext = null
  	const {EmployeeAttendanceUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeAttendance",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'employeeAttendanceList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeAttendanceUpdateForm)
  }

  getEmployeeQualifierSearch = () => {
    const {EmployeeQualifierSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee_qualifier','employee.employee_qualifier_list',false),
      role: "employeeQualifier",
      data: state._employee.employeeQualifierList,
      metaInfo: state._employee.employeeQualifierListMetaInfo,
      count: state._employee.employeeQualifierCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.employeeQualifierCurrentPageNumber,
      searchFormParameters: state._employee.employeeQualifierSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'employee',
      listName: 'employeeQualifierList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeQualifierSearch)
  }

  getEmployeeQualifierCreateForm = () => {
   	const {EmployeeQualifierCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employeeQualifier",
      data: state._employee.employeeQualifierList,
      metaInfo: state._employee.employeeQualifierListMetaInfo,
      count: state._employee.employeeQualifierCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeQualifierCurrentPageNumber,
      searchFormParameters: state._employee.employeeQualifierSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'employee', listName: 'employeeQualifierList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeQualifierCreateForm)
  }

  getEmployeeQualifierUpdateForm = () => {
    const userContext = null
  	const {EmployeeQualifierUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeQualifier",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'employeeQualifierList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeQualifierUpdateForm)
  }

  getEmployeeEducationSearch = () => {
    const {EmployeeEducationSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee_education','employee.employee_education_list',false),
      role: "employeeEducation",
      data: state._employee.employeeEducationList,
      metaInfo: state._employee.employeeEducationListMetaInfo,
      count: state._employee.employeeEducationCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.employeeEducationCurrentPageNumber,
      searchFormParameters: state._employee.employeeEducationSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'employee',
      listName: 'employeeEducationList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeEducationSearch)
  }

  getEmployeeEducationCreateForm = () => {
   	const {EmployeeEducationCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employeeEducation",
      data: state._employee.employeeEducationList,
      metaInfo: state._employee.employeeEducationListMetaInfo,
      count: state._employee.employeeEducationCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeEducationCurrentPageNumber,
      searchFormParameters: state._employee.employeeEducationSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'employee', listName: 'employeeEducationList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeEducationCreateForm)
  }

  getEmployeeEducationUpdateForm = () => {
    const userContext = null
  	const {EmployeeEducationUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeEducation",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'employeeEducationList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeEducationUpdateForm)
  }

  getEmployeeAwardSearch = () => {
    const {EmployeeAwardSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee_award','employee.employee_award_list',false),
      role: "employeeAward",
      data: state._employee.employeeAwardList,
      metaInfo: state._employee.employeeAwardListMetaInfo,
      count: state._employee.employeeAwardCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.employeeAwardCurrentPageNumber,
      searchFormParameters: state._employee.employeeAwardSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'employee',
      listName: 'employeeAwardList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeAwardSearch)
  }

  getEmployeeAwardCreateForm = () => {
   	const {EmployeeAwardCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employeeAward",
      data: state._employee.employeeAwardList,
      metaInfo: state._employee.employeeAwardListMetaInfo,
      count: state._employee.employeeAwardCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeAwardCurrentPageNumber,
      searchFormParameters: state._employee.employeeAwardSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'employee', listName: 'employeeAwardList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeAwardCreateForm)
  }

  getEmployeeAwardUpdateForm = () => {
    const userContext = null
  	const {EmployeeAwardUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeAward",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'employeeAwardList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeAwardUpdateForm)
  }

  getEmployeeSalarySheetSearch = () => {
    const {EmployeeSalarySheetSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('employee_salary_sheet','employee.employee_salary_sheet_list',false),
      role: "employeeSalarySheet",
      data: state._employee.employeeSalarySheetList,
      metaInfo: state._employee.employeeSalarySheetListMetaInfo,
      count: state._employee.employeeSalarySheetCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.employeeSalarySheetCurrentPageNumber,
      searchFormParameters: state._employee.employeeSalarySheetSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'employee',
      listName: 'employeeSalarySheetList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeSalarySheetSearch)
  }

  getEmployeeSalarySheetCreateForm = () => {
   	const {EmployeeSalarySheetCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "employeeSalarySheet",
      data: state._employee.employeeSalarySheetList,
      metaInfo: state._employee.employeeSalarySheetListMetaInfo,
      count: state._employee.employeeSalarySheetCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.employeeSalarySheetCurrentPageNumber,
      searchFormParameters: state._employee.employeeSalarySheetSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'employee', listName: 'employeeSalarySheetList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EmployeeSalarySheetCreateForm)
  }

  getEmployeeSalarySheetUpdateForm = () => {
    const userContext = null
  	const {EmployeeSalarySheetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "employeeSalarySheet",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'employeeSalarySheetList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EmployeeSalarySheetUpdateForm)
  }

  getPayingOffSearch = () => {
    const {PayingOffSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('paying_off','employee.paying_off_list',false),
      role: "payingOff",
      data: state._employee.payingOffList,
      metaInfo: state._employee.payingOffListMetaInfo,
      count: state._employee.payingOffCount,
      returnURL: `/employee/${state._employee.id}/workbench`,
      currentPage: state._employee.payingOffCurrentPageNumber,
      searchFormParameters: state._employee.payingOffSearchFormParameters,
      searchParameters: {...state._employee.searchParameters},
      expandForm: state._employee.expandForm,
      loading: state._employee.loading,
      partialList: state._employee.partialList,
      owner: { type: '_employee', id: state._employee.id,
      referenceName: 'paidFor',
      listName: 'payingOffList', ref:state._employee,
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PayingOffSearch)
  }

  getPayingOffCreateForm = () => {
   	const {PayingOffCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      initValue: this.getSelectedRows(),
      role: "payingOff",
      data: state._employee.payingOffList,
      metaInfo: state._employee.payingOffListMetaInfo,
      count: state._employee.payingOffCount,
      returnURL: `/employee/${state._employee.id}/list`,
      currentPage: state._employee.payingOffCurrentPageNumber,
      searchFormParameters: state._employee.payingOffSearchFormParameters,
      loading: state._employee.loading,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), referenceName: 'paidFor', listName: 'payingOffList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(PayingOffCreateForm)
  }

  getPayingOffUpdateForm = () => {
    const userContext = null
  	const {PayingOffUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "payingOff",
      currentUpdateIndex: state._employee.currentUpdateIndex || 0,
      owner: { type: '_employee', id: state._employee.id || this.getOwnerId(), listName: 'payingOffList', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(PayingOffUpdateForm)
  }


  getRequestTypeStepForm = () => {
    const userContext = null
  	 const {ChangeRequestStepForm} = GlobalComponents
    return connect(state => ({
      selectedRows: state._employee.selectedRows,
      role: "cq",
      currentUpdateIndex: state._employee.currentUpdateIndex,
      owner: { type: '_employee', id: state._employee.id, listName: 'nolist', ref:state._employee, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChangeRequestStepForm)
  }



  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = '双链小超全流程供应链系统'
    return title
  }

  buildRouters = () =>{
    const {EmployeeWorkbench} = GlobalComponents

    const {EmployeeDashboard} = GlobalComponents
  	const {EmployeePermission} = GlobalComponents
  	const {EmployeeProfile} = GlobalComponents


    const routers=[
    {path:"/employee/:id/workbench", component: EmployeeWorkbench},
    {path:"/employee/:id/dashboard", component: EmployeeDashboard},
  	{path:"/employee/:id/profile", component: EmployeeProfile},
  	{path:"/employee/:id/permission", component: EmployeePermission},



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

    const {searchLocalData}=GlobalComponents.EmployeeBase

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

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.employee,this.state.searchKeyword)}</div>

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

         {this.getNavMenuItems(this.props.employee,"inline","dark")}

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
  employee: state._employee,
  ...state,
}))(EmployeeBizApp)



