

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
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


const renderSettingDropDown = (cardsData,targetComponent)=>{

  return (<div style={{float: 'right'}} >
        <Dropdown overlay={renderSettingMenu(cardsData,targetComponent)} placement="bottomRight" >
       
        <Button>
        <Icon type="setting" theme="filled" twoToneColor="#00b" style={{color:'#3333b0'}}/> 设置  <Icon type="down"/>
      </Button>
      </Dropdown></div>)

}

const renderSettingMenuItem = (item,cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu.Item key={item.name}>
      <Link to={`/employee/${targetComponent.props.employee.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/employee/${targetComponent.props.employee.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (employee,targetComponent) =>{
	
	
	const {EmployeeService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号" style={{wordBreak: 'break-all'}}>{employee.id}</Description> 
<Description term="头衔" style={{wordBreak: 'break-all'}}>{employee.title}</Description> 
<Description term="部门">{employee.department==null?appLocaleName(userContext,"NotAssigned"):`${employee.department.displayName}(${employee.department.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"部门","levelThreeDepartment",EmployeeService.requestCandidateDepartment,
	      EmployeeService.transferToAnotherDepartment,"anotherDepartmentId",employee.department?employee.department.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="姓" style={{wordBreak: 'break-all'}}>{employee.familyName}</Description> 
<Description term="名" style={{wordBreak: 'break-all'}}>{employee.givenName}</Description> 
<Description term="电子邮件" style={{wordBreak: 'break-all'}}>{employee.email}</Description> 
<Description term="城市" style={{wordBreak: 'break-all'}}>{employee.city}</Description> 
<Description term="地址" style={{wordBreak: 'break-all'}}>{employee.address}</Description> 
<Description term="手机" style={{wordBreak: 'break-all'}}>{employee.cellPhone}</Description> 
<Description term="职业">{employee.occupation==null?appLocaleName(userContext,"NotAssigned"):`${employee.occupation.displayName}(${employee.occupation.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"职业","occupationType",EmployeeService.requestCandidateOccupation,
	      EmployeeService.transferToAnotherOccupation,"anotherOccupationId",employee.occupation?employee.occupation.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="负责">{employee.responsibleFor==null?appLocaleName(userContext,"NotAssigned"):`${employee.responsibleFor.displayName}(${employee.responsibleFor.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"负责","responsibilityType",EmployeeService.requestCandidateResponsibleFor,
	      EmployeeService.transferToAnotherResponsibleFor,"anotherResponsibleForId",employee.responsibleFor?employee.responsibleFor.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="目前工资等级">{employee.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${employee.currentSalaryGrade.displayName}(${employee.currentSalaryGrade.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"目前工资等级","salaryGrade",EmployeeService.requestCandidateCurrentSalaryGrade,
	      EmployeeService.transferToAnotherCurrentSalaryGrade,"anotherCurrentSalaryGradeId",employee.currentSalaryGrade?employee.currentSalaryGrade.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="工资账户" style={{wordBreak: 'break-all'}}>{employee.salaryAccount}</Description> 
<Description term="最后更新时间">{ moment(employee.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
	
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
    
    const cardsData = {cardsName:"员工",cardsFor: "employee",
    	cardsSource: this.props.employee,returnURL,displayName,
  		subItems: [
{name: 'employeeCompanyTrainingList', displayName:'员工参与的公司培训',viewGroup:'__no_group', type:'employeeCompanyTraining',count:employeeCompanyTrainingCount,addFunction: true, role: 'employeeCompanyTraining', metaInfo: employeeCompanyTrainingListMetaInfo, renderItem: GlobalComponents.EmployeeCompanyTrainingBase.renderItemOfList},
{name: 'employeeSkillList', displayName:'员工技能',viewGroup:'__no_group', type:'employeeSkill',count:employeeSkillCount,addFunction: true, role: 'employeeSkill', metaInfo: employeeSkillListMetaInfo, renderItem: GlobalComponents.EmployeeSkillBase.renderItemOfList},
{name: 'employeePerformanceList', displayName:'员工绩效',viewGroup:'__no_group', type:'employeePerformance',count:employeePerformanceCount,addFunction: true, role: 'employeePerformance', metaInfo: employeePerformanceListMetaInfo, renderItem: GlobalComponents.EmployeePerformanceBase.renderItemOfList},
{name: 'employeeWorkExperienceList', displayName:'员工工作经验',viewGroup:'__no_group', type:'employeeWorkExperience',count:employeeWorkExperienceCount,addFunction: true, role: 'employeeWorkExperience', metaInfo: employeeWorkExperienceListMetaInfo, renderItem: GlobalComponents.EmployeeWorkExperienceBase.renderItemOfList},
{name: 'employeeLeaveList', displayName:'请假记录',viewGroup:'__no_group', type:'employeeLeave',count:employeeLeaveCount,addFunction: true, role: 'employeeLeave', metaInfo: employeeLeaveListMetaInfo, renderItem: GlobalComponents.EmployeeLeaveBase.renderItemOfList},
{name: 'employeeInterviewList', displayName:'员工面试',viewGroup:'__no_group', type:'employeeInterview',count:employeeInterviewCount,addFunction: true, role: 'employeeInterview', metaInfo: employeeInterviewListMetaInfo, renderItem: GlobalComponents.EmployeeInterviewBase.renderItemOfList},
{name: 'employeeAttendanceList', displayName:'员工考勤',viewGroup:'__no_group', type:'employeeAttendance',count:employeeAttendanceCount,addFunction: true, role: 'employeeAttendance', metaInfo: employeeAttendanceListMetaInfo, renderItem: GlobalComponents.EmployeeAttendanceBase.renderItemOfList},
{name: 'employeeQualifierList', displayName:'员工资质',viewGroup:'__no_group', type:'employeeQualifier',count:employeeQualifierCount,addFunction: true, role: 'employeeQualifier', metaInfo: employeeQualifierListMetaInfo, renderItem: GlobalComponents.EmployeeQualifierBase.renderItemOfList},
{name: 'employeeEducationList', displayName:'员工教育',viewGroup:'__no_group', type:'employeeEducation',count:employeeEducationCount,addFunction: true, role: 'employeeEducation', metaInfo: employeeEducationListMetaInfo, renderItem: GlobalComponents.EmployeeEducationBase.renderItemOfList},
{name: 'employeeAwardList', displayName:'员工嘉奖',viewGroup:'__no_group', type:'employeeAward',count:employeeAwardCount,addFunction: true, role: 'employeeAward', metaInfo: employeeAwardListMetaInfo, renderItem: GlobalComponents.EmployeeAwardBase.renderItemOfList},
{name: 'employeeSalarySheetList', displayName:'工资单',viewGroup:'__no_group', type:'employeeSalarySheet',count:employeeSalarySheetCount,addFunction: true, role: 'employeeSalarySheet', metaInfo: employeeSalarySheetListMetaInfo, renderItem: GlobalComponents.EmployeeSalarySheetBase.renderItemOfList},
{name: 'payingOffList', displayName:'工资支付',viewGroup:'__no_group', type:'payingOff',count:payingOffCount,addFunction: true, role: 'payingOff', metaInfo: payingOffListMetaInfo, renderItem: GlobalComponents.PayingOffBase.renderItemOfList},
    
      	],
   		subSettingItems: [
    
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
        {imageListOf(cardsData.cardsSource)}  
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
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

