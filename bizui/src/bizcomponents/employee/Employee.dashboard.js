

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Employee.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,defaultRenderAnalytics,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,
  defaultQuickFunctions, defaultRenderSubjectList,
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(employee)=>{return [
	 ]}

const internalImageListOf = (employee) =>defaultImageListOf(employee,imageList)

const optionList =(employee)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (employee) =>defaultSettingListOf(employee, optionList)
const internalLargeTextOf = (employee) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (employee,targetComponent) =>{
	
	
	const {EmployeeService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{employee.id}</Description> 
<Description term="Title">{employee.title}</Description> 
<Description term="Department">{employee.department==null?appLocaleName(userContext,"NotAssigned"):`${employee.department.displayName}(${employee.department.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Department","levelThreeDepartment",EmployeeService.requestCandidateDepartment,
	      EmployeeService.transferToAnotherDepartment,"anotherDepartmentId",employee.department?employee.department.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Family Name">{employee.familyName}</Description> 
<Description term="Given Name">{employee.givenName}</Description> 
<Description term="Email">{employee.email}</Description> 
<Description term="City">{employee.city}</Description> 
<Description term="Address">{employee.address}</Description> 
<Description term="Cell Phone">{employee.cellPhone}</Description> 
<Description term="Occupation">{employee.occupation==null?appLocaleName(userContext,"NotAssigned"):`${employee.occupation.displayName}(${employee.occupation.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Occupation","occupationType",EmployeeService.requestCandidateOccupation,
	      EmployeeService.transferToAnotherOccupation,"anotherOccupationId",employee.occupation?employee.occupation.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Responsible For">{employee.responsibleFor==null?appLocaleName(userContext,"NotAssigned"):`${employee.responsibleFor.displayName}(${employee.responsibleFor.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Responsible For","responsibilityType",EmployeeService.requestCandidateResponsibleFor,
	      EmployeeService.transferToAnotherResponsibleFor,"anotherResponsibleForId",employee.responsibleFor?employee.responsibleFor.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Current Salary Grade">{employee.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${employee.currentSalaryGrade.displayName}(${employee.currentSalaryGrade.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Current Salary Grade","salaryGrade",EmployeeService.requestCandidateCurrentSalaryGrade,
	      EmployeeService.transferToAnotherCurrentSalaryGrade,"anotherCurrentSalaryGradeId",employee.currentSalaryGrade?employee.currentSalaryGrade.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Salary Account">{employee.salaryAccount}</Description> 
<Description term="Termination">{employee.termination==null?appLocaleName(userContext,"NotAssigned"):`${employee.termination.displayName}(${employee.termination.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Termination","termination",EmployeeService.requestCandidateTermination,
	      EmployeeService.transferToAnotherTermination,"anotherTerminationId",employee.termination?employee.termination.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Last Update Time">{ moment(employee.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{employee.currentStatus}</Description> 
	
        {buildTransferModal(employee,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class EmployeeDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'employee'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, employeeCompanyTrainingListMetaInfo, employeeSkillListMetaInfo, employeePerformanceListMetaInfo, employeeWorkExperienceListMetaInfo, employeeLeaveListMetaInfo, employeeInterviewListMetaInfo, employeeAttendanceListMetaInfo, employeeQualifierListMetaInfo, employeeEducationListMetaInfo, employeeAwardListMetaInfo, employeeSalarySheetListMetaInfo, payingOffListMetaInfo, employeeCompanyTrainingCount, employeeSkillCount, employeePerformanceCount, employeeWorkExperienceCount, employeeLeaveCount, employeeInterviewCount, employeeAttendanceCount, employeeQualifierCount, employeeEducationCount, employeeAwardCount, employeeSalarySheetCount, payingOffCount } = this.props.employee
    if(!this.props.employee.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Employee",cardsFor: "employee",
    	cardsSource: this.props.employee,returnURL,displayName,
  		subItems: [
{name: 'employeeCompanyTrainingList', displayName:'Employee Company Training',type:'employeeCompanyTraining',count:employeeCompanyTrainingCount,addFunction: true, role: 'employeeCompanyTraining', metaInfo: employeeCompanyTrainingListMetaInfo, renderItem: GlobalComponents.EmployeeCompanyTrainingBase.renderItemOfList},
{name: 'employeeSkillList', displayName:'Employee Skill',type:'employeeSkill',count:employeeSkillCount,addFunction: true, role: 'employeeSkill', metaInfo: employeeSkillListMetaInfo, renderItem: GlobalComponents.EmployeeSkillBase.renderItemOfList},
{name: 'employeePerformanceList', displayName:'Employee Performance',type:'employeePerformance',count:employeePerformanceCount,addFunction: true, role: 'employeePerformance', metaInfo: employeePerformanceListMetaInfo, renderItem: GlobalComponents.EmployeePerformanceBase.renderItemOfList},
{name: 'employeeWorkExperienceList', displayName:'Employee Work Experience',type:'employeeWorkExperience',count:employeeWorkExperienceCount,addFunction: true, role: 'employeeWorkExperience', metaInfo: employeeWorkExperienceListMetaInfo, renderItem: GlobalComponents.EmployeeWorkExperienceBase.renderItemOfList},
{name: 'employeeLeaveList', displayName:'Employee Leave',type:'employeeLeave',count:employeeLeaveCount,addFunction: true, role: 'employeeLeave', metaInfo: employeeLeaveListMetaInfo, renderItem: GlobalComponents.EmployeeLeaveBase.renderItemOfList},
{name: 'employeeInterviewList', displayName:'Employee Interview',type:'employeeInterview',count:employeeInterviewCount,addFunction: true, role: 'employeeInterview', metaInfo: employeeInterviewListMetaInfo, renderItem: GlobalComponents.EmployeeInterviewBase.renderItemOfList},
{name: 'employeeAttendanceList', displayName:'Employee Attendance',type:'employeeAttendance',count:employeeAttendanceCount,addFunction: true, role: 'employeeAttendance', metaInfo: employeeAttendanceListMetaInfo, renderItem: GlobalComponents.EmployeeAttendanceBase.renderItemOfList},
{name: 'employeeQualifierList', displayName:'Employee Qualifier',type:'employeeQualifier',count:employeeQualifierCount,addFunction: true, role: 'employeeQualifier', metaInfo: employeeQualifierListMetaInfo, renderItem: GlobalComponents.EmployeeQualifierBase.renderItemOfList},
{name: 'employeeEducationList', displayName:'Employee Education',type:'employeeEducation',count:employeeEducationCount,addFunction: true, role: 'employeeEducation', metaInfo: employeeEducationListMetaInfo, renderItem: GlobalComponents.EmployeeEducationBase.renderItemOfList},
{name: 'employeeAwardList', displayName:'Employee Award',type:'employeeAward',count:employeeAwardCount,addFunction: true, role: 'employeeAward', metaInfo: employeeAwardListMetaInfo, renderItem: GlobalComponents.EmployeeAwardBase.renderItemOfList},
{name: 'employeeSalarySheetList', displayName:'Employee Salary Sheet',type:'employeeSalarySheet',count:employeeSalarySheetCount,addFunction: true, role: 'employeeSalarySheet', metaInfo: employeeSalarySheetListMetaInfo, renderItem: GlobalComponents.EmployeeSalarySheetBase.renderItemOfList},
{name: 'payingOffList', displayName:'Paying Off',type:'payingOff',count:payingOffCount,addFunction: true, role: 'payingOff', metaInfo: payingOffListMetaInfo, renderItem: GlobalComponents.PayingOffBase.renderItemOfList},
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    const renderAnalytics = this.props.renderAnalytics || defaultRenderAnalytics
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList
    
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
       
        {renderExtraHeader(cardsData.cardsSource)}
        {quickFunctions(cardsData)} 
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}  
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
    )
  }
}

export default connect(state => ({
  employee: state._employee,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(EmployeeDashboard))

