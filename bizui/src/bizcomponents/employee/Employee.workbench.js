

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import BaseTool from '../../common/Base.tool'
import { Tag, Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {TagCloud} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Employee.workbench.less'
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

const {defaultFormatNumber} = BaseTool

const formatNumber = defaultFormatNumber

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


const internalSummaryOf = (cardsData,targetComponent) =>{

	 const quickFunctions = targetComponent.props.quickFunctions || internalQuickFunctions
	const employee = cardsData.cardsSource
	const {EmployeeService} = GlobalComponents
	const userContext = null
	return (
	<div>
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID" style={{wordBreak: 'break-all'}}>{employee.id}</Description> 
<Description term="头衔" style={{wordBreak: 'break-all'}}>{employee.title}</Description> 
<Description term="部门">{employee.department==null?appLocaleName(userContext,"NotAssigned"):`${employee.department.displayName}(${employee.department.id})`}
</Description>
<Description term="姓" style={{wordBreak: 'break-all'}}>{employee.familyName}</Description> 
<Description term="名" style={{wordBreak: 'break-all'}}>{employee.givenName}</Description> 
<Description term="电子邮件" style={{wordBreak: 'break-all'}}>{employee.email}</Description> 
<Description term="城市" style={{wordBreak: 'break-all'}}>{employee.city}</Description> 
<Description term="地址" style={{wordBreak: 'break-all'}}>{employee.address}</Description> 
<Description term="手机" style={{wordBreak: 'break-all'}}>{employee.cellPhone}</Description> 
<Description term="职业">{employee.occupation==null?appLocaleName(userContext,"NotAssigned"):`${employee.occupation.displayName}(${employee.occupation.id})`}
</Description>
<Description term="负责">{employee.responsibleFor==null?appLocaleName(userContext,"NotAssigned"):`${employee.responsibleFor.displayName}(${employee.responsibleFor.id})`}
</Description>
<Description term="目前工资等级">{employee.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${employee.currentSalaryGrade.displayName}(${employee.currentSalaryGrade.id})`}
</Description>
<Description term="工资账户" style={{wordBreak: 'break-all'}}>{employee.salaryAccount}</Description> 
<Description term="更新于">{ moment(employee.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 

      
      </DescriptionList>

      </div>
	)

}


const renderTagCloud=(cardsData)=>{


  if(cardsData.subItems.length<10){
    return null
  }

  const tagValue = cardsData.subItems.map(item=>({name:item.displayName, value: item.count}))

  return <div >
      <div style={{verticalAlign:"middle",textAlign:"center",backgroundColor:"rgba(0, 0, 0, 0.65)",color:"white",fontWeight:"bold",height:"40px"}}>
       <span style={{display:"inline-block",marginTop:"10px"}}>{`${cardsData.displayName}画像`}</span>
      </div>
      <TagCloud data={tagValue} height={200} style={{backgroundColor:"white"}}/>
    </div>


}


const internalQuickFunctions = defaultQuickFunctions

class EmployeeWorkbench extends Component {

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

    const cardsData = {cardsName:window.trans('employee'),cardsFor: "employee",
    	cardsSource: this.props.employee,returnURL,displayName,
  		subItems: [
{name: 'employeeCompanyTrainingList', displayName: window.mtrans('employee_company_training','employee.employee_company_training_list',false) ,viewGroup:'__no_group', type:'employeeCompanyTraining',count:employeeCompanyTrainingCount,addFunction: true, role: 'employeeCompanyTraining', metaInfo: employeeCompanyTrainingListMetaInfo, renderItem: GlobalComponents.EmployeeCompanyTrainingBase.renderItemOfList},
{name: 'employeeSkillList', displayName: window.mtrans('employee_skill','employee.employee_skill_list',false) ,viewGroup:'__no_group', type:'employeeSkill',count:employeeSkillCount,addFunction: true, role: 'employeeSkill', metaInfo: employeeSkillListMetaInfo, renderItem: GlobalComponents.EmployeeSkillBase.renderItemOfList},
{name: 'employeePerformanceList', displayName: window.mtrans('employee_performance','employee.employee_performance_list',false) ,viewGroup:'__no_group', type:'employeePerformance',count:employeePerformanceCount,addFunction: true, role: 'employeePerformance', metaInfo: employeePerformanceListMetaInfo, renderItem: GlobalComponents.EmployeePerformanceBase.renderItemOfList},
{name: 'employeeWorkExperienceList', displayName: window.mtrans('employee_work_experience','employee.employee_work_experience_list',false) ,viewGroup:'__no_group', type:'employeeWorkExperience',count:employeeWorkExperienceCount,addFunction: true, role: 'employeeWorkExperience', metaInfo: employeeWorkExperienceListMetaInfo, renderItem: GlobalComponents.EmployeeWorkExperienceBase.renderItemOfList},
{name: 'employeeLeaveList', displayName: window.mtrans('employee_leave','employee.employee_leave_list',false) ,viewGroup:'__no_group', type:'employeeLeave',count:employeeLeaveCount,addFunction: true, role: 'employeeLeave', metaInfo: employeeLeaveListMetaInfo, renderItem: GlobalComponents.EmployeeLeaveBase.renderItemOfList},
{name: 'employeeInterviewList', displayName: window.mtrans('employee_interview','employee.employee_interview_list',false) ,viewGroup:'__no_group', type:'employeeInterview',count:employeeInterviewCount,addFunction: true, role: 'employeeInterview', metaInfo: employeeInterviewListMetaInfo, renderItem: GlobalComponents.EmployeeInterviewBase.renderItemOfList},
{name: 'employeeAttendanceList', displayName: window.mtrans('employee_attendance','employee.employee_attendance_list',false) ,viewGroup:'__no_group', type:'employeeAttendance',count:employeeAttendanceCount,addFunction: true, role: 'employeeAttendance', metaInfo: employeeAttendanceListMetaInfo, renderItem: GlobalComponents.EmployeeAttendanceBase.renderItemOfList},
{name: 'employeeQualifierList', displayName: window.mtrans('employee_qualifier','employee.employee_qualifier_list',false) ,viewGroup:'__no_group', type:'employeeQualifier',count:employeeQualifierCount,addFunction: true, role: 'employeeQualifier', metaInfo: employeeQualifierListMetaInfo, renderItem: GlobalComponents.EmployeeQualifierBase.renderItemOfList},
{name: 'employeeEducationList', displayName: window.mtrans('employee_education','employee.employee_education_list',false) ,viewGroup:'__no_group', type:'employeeEducation',count:employeeEducationCount,addFunction: true, role: 'employeeEducation', metaInfo: employeeEducationListMetaInfo, renderItem: GlobalComponents.EmployeeEducationBase.renderItemOfList},
{name: 'employeeAwardList', displayName: window.mtrans('employee_award','employee.employee_award_list',false) ,viewGroup:'__no_group', type:'employeeAward',count:employeeAwardCount,addFunction: true, role: 'employeeAward', metaInfo: employeeAwardListMetaInfo, renderItem: GlobalComponents.EmployeeAwardBase.renderItemOfList},
{name: 'employeeSalarySheetList', displayName: window.mtrans('employee_salary_sheet','employee.employee_salary_sheet_list',false) ,viewGroup:'__no_group', type:'employeeSalarySheet',count:employeeSalarySheetCount,addFunction: true, role: 'employeeSalarySheet', metaInfo: employeeSalarySheetListMetaInfo, renderItem: GlobalComponents.EmployeeSalarySheetBase.renderItemOfList},
{name: 'payingOffList', displayName: window.mtrans('paying_off','employee.paying_off_list',false) ,viewGroup:'__no_group', type:'payingOff',count:payingOffCount,addFunction: true, role: 'payingOff', metaInfo: payingOffListMetaInfo, renderItem: GlobalComponents.PayingOffBase.renderItemOfList},

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
    // {quickFunctions(cardsData)}
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData,this)}
        wrapperClassName={styles.advancedForm}
      >

      
       
     <Col span={18} style={{marginRight:"20px", backgroundColor: "white"}}>
      {quickFunctions(cardsData)}

      {largeTextOf(cardsData.cardsSource)}
      {renderSubjectList(cardsData)} 
      {renderExtraFooter(cardsData.cardsSource)}
	   </Col>
      <Col span={5}>

			{imageListOf(cardsData.cardsSource)}
			{settingListOf(cardsData.cardsSource)}
		</Col>
		 
      </PageHeaderLayout>

    )
  }
}

export default connect(state => ({
  employee: state._employee,
  returnURL: state.breadcrumb.returnURL,

}))(Form.create()(EmployeeWorkbench))

