

import React, { Component } from 'react'
<<<<<<< HEAD
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
=======
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD

=======
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
<<<<<<< HEAD
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
=======
  defaultSubListsOf,defaultRenderAnalytics,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,
  defaultQuickFunctions, defaultRenderSubjectList,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
=======
const internalRenderSubjectList = defaultRenderSubjectList
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
const internalSettingListOf = (employee) =>defaultSettingListOf(employee, optionList)
const internalLargeTextOf = (employee) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


<<<<<<< HEAD
const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)
=======
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
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

}


const internalSummaryOf = (employee,targetComponent) =>{
	
	
	const {EmployeeService} = GlobalComponents
<<<<<<< HEAD
	
=======
	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{employee.id}</Description> 
<Description term="头衔">{employee.title}</Description> 
<<<<<<< HEAD
<Description term="部门">{employee.department==null?"未分配":employee.department.displayName}
=======
<Description term="部门">{employee.department==null?appLocaleName(userContext,"NotAssigned"):`${employee.department.displayName}(${employee.department.id})`}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"部门","levelThreeDepartment",EmployeeService.requestCandidateDepartment,
	      EmployeeService.transferToAnotherDepartment,"anotherDepartmentId",employee.department?employee.department.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="姓">{employee.familyName}</Description> 
<Description term="名">{employee.givenName}</Description> 
<Description term="电子邮件">{employee.email}</Description> 
<Description term="城市">{employee.city}</Description> 
<Description term="地址">{employee.address}</Description> 
<Description term="手机">{employee.cellPhone}</Description> 
<<<<<<< HEAD
<Description term="职业">{employee.occupation==null?"未分配":employee.occupation.displayName}
=======
<Description term="职业">{employee.occupation==null?appLocaleName(userContext,"NotAssigned"):`${employee.occupation.displayName}(${employee.occupation.id})`}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"职业","occupationType",EmployeeService.requestCandidateOccupation,
	      EmployeeService.transferToAnotherOccupation,"anotherOccupationId",employee.occupation?employee.occupation.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<<<<<<< HEAD
<Description term="负责">{employee.responsibleFor==null?"未分配":employee.responsibleFor.displayName}
=======
<Description term="负责">{employee.responsibleFor==null?appLocaleName(userContext,"NotAssigned"):`${employee.responsibleFor.displayName}(${employee.responsibleFor.id})`}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"负责","responsibilityType",EmployeeService.requestCandidateResponsibleFor,
	      EmployeeService.transferToAnotherResponsibleFor,"anotherResponsibleForId",employee.responsibleFor?employee.responsibleFor.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<<<<<<< HEAD
<Description term="目前工资等级">{employee.currentSalaryGrade==null?"未分配":employee.currentSalaryGrade.displayName}
=======
<Description term="目前工资等级">{employee.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${employee.currentSalaryGrade.displayName}(${employee.currentSalaryGrade.id})`}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"目前工资等级","salaryGrade",EmployeeService.requestCandidateCurrentSalaryGrade,
	      EmployeeService.transferToAnotherCurrentSalaryGrade,"anotherCurrentSalaryGradeId",employee.currentSalaryGrade?employee.currentSalaryGrade.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="工资账户">{employee.salaryAccount}</Description> 
<<<<<<< HEAD
<Description term="雇佣终止">{employee.termination==null?"未分配":employee.termination.displayName}
=======
<Description term="雇佣终止">{employee.termination==null?appLocaleName(userContext,"NotAssigned"):`${employee.termination.displayName}(${employee.termination.id})`}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"雇佣终止","termination",EmployeeService.requestCandidateTermination,
	      EmployeeService.transferToAnotherTermination,"anotherTerminationId",employee.termination?employee.termination.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<<<<<<< HEAD
<Description term="最后更新时间">{ moment(employee.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
=======
<Description term="最后更新时间">{ moment(employee.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
<Description term="当前状态">{employee.currentStatus}</Description> 
	
        {buildTransferModal(employee,targetComponent)}
      </DescriptionList>
	)

}

<<<<<<< HEAD
=======
const internalQuickFunctions = defaultQuickFunctions
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

class EmployeeDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
<<<<<<< HEAD
    targetLocalName:"城市",
=======
    targetLocalName:"",
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
{name: 'employeeCompanyTrainingList', displayName:'员工参与的公司培训',type:'employeeCompanyTraining',count:employeeCompanyTrainingCount,addFunction: true, role: 'employeeCompanyTraining', metaInfo: employeeCompanyTrainingListMetaInfo},
{name: 'employeeSkillList', displayName:'员工技能',type:'employeeSkill',count:employeeSkillCount,addFunction: true, role: 'employeeSkill', metaInfo: employeeSkillListMetaInfo},
{name: 'employeePerformanceList', displayName:'员工绩效',type:'employeePerformance',count:employeePerformanceCount,addFunction: true, role: 'employeePerformance', metaInfo: employeePerformanceListMetaInfo},
{name: 'employeeWorkExperienceList', displayName:'员工工作经验',type:'employeeWorkExperience',count:employeeWorkExperienceCount,addFunction: true, role: 'employeeWorkExperience', metaInfo: employeeWorkExperienceListMetaInfo},
{name: 'employeeLeaveList', displayName:'请假记录',type:'employeeLeave',count:employeeLeaveCount,addFunction: true, role: 'employeeLeave', metaInfo: employeeLeaveListMetaInfo},
{name: 'employeeInterviewList', displayName:'员工面试',type:'employeeInterview',count:employeeInterviewCount,addFunction: true, role: 'employeeInterview', metaInfo: employeeInterviewListMetaInfo},
{name: 'employeeAttendanceList', displayName:'员工考勤',type:'employeeAttendance',count:employeeAttendanceCount,addFunction: true, role: 'employeeAttendance', metaInfo: employeeAttendanceListMetaInfo},
{name: 'employeeQualifierList', displayName:'员工资质',type:'employeeQualifier',count:employeeQualifierCount,addFunction: true, role: 'employeeQualifier', metaInfo: employeeQualifierListMetaInfo},
{name: 'employeeEducationList', displayName:'员工教育',type:'employeeEducation',count:employeeEducationCount,addFunction: true, role: 'employeeEducation', metaInfo: employeeEducationListMetaInfo},
{name: 'employeeAwardList', displayName:'员工嘉奖',type:'employeeAward',count:employeeAwardCount,addFunction: true, role: 'employeeAward', metaInfo: employeeAwardListMetaInfo},
{name: 'employeeSalarySheetList', displayName:'工资单',type:'employeeSalarySheet',count:employeeSalarySheetCount,addFunction: true, role: 'employeeSalarySheet', metaInfo: employeeSalarySheetListMetaInfo},
{name: 'payingOffList', displayName:'工资支付',type:'payingOff',count:payingOffCount,addFunction: true, role: 'payingOff', metaInfo: payingOffListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
=======
{name: 'employeeCompanyTrainingList', displayName:'员工参与的公司培训',type:'employeeCompanyTraining',count:employeeCompanyTrainingCount,addFunction: true, role: 'employeeCompanyTraining', metaInfo: employeeCompanyTrainingListMetaInfo, renderItem: GlobalComponents.EmployeeCompanyTrainingBase.renderItemOfList},
{name: 'employeeSkillList', displayName:'员工技能',type:'employeeSkill',count:employeeSkillCount,addFunction: true, role: 'employeeSkill', metaInfo: employeeSkillListMetaInfo, renderItem: GlobalComponents.EmployeeSkillBase.renderItemOfList},
{name: 'employeePerformanceList', displayName:'员工绩效',type:'employeePerformance',count:employeePerformanceCount,addFunction: true, role: 'employeePerformance', metaInfo: employeePerformanceListMetaInfo, renderItem: GlobalComponents.EmployeePerformanceBase.renderItemOfList},
{name: 'employeeWorkExperienceList', displayName:'员工工作经验',type:'employeeWorkExperience',count:employeeWorkExperienceCount,addFunction: true, role: 'employeeWorkExperience', metaInfo: employeeWorkExperienceListMetaInfo, renderItem: GlobalComponents.EmployeeWorkExperienceBase.renderItemOfList},
{name: 'employeeLeaveList', displayName:'请假记录',type:'employeeLeave',count:employeeLeaveCount,addFunction: true, role: 'employeeLeave', metaInfo: employeeLeaveListMetaInfo, renderItem: GlobalComponents.EmployeeLeaveBase.renderItemOfList},
{name: 'employeeInterviewList', displayName:'员工面试',type:'employeeInterview',count:employeeInterviewCount,addFunction: true, role: 'employeeInterview', metaInfo: employeeInterviewListMetaInfo, renderItem: GlobalComponents.EmployeeInterviewBase.renderItemOfList},
{name: 'employeeAttendanceList', displayName:'员工考勤',type:'employeeAttendance',count:employeeAttendanceCount,addFunction: true, role: 'employeeAttendance', metaInfo: employeeAttendanceListMetaInfo, renderItem: GlobalComponents.EmployeeAttendanceBase.renderItemOfList},
{name: 'employeeQualifierList', displayName:'员工资质',type:'employeeQualifier',count:employeeQualifierCount,addFunction: true, role: 'employeeQualifier', metaInfo: employeeQualifierListMetaInfo, renderItem: GlobalComponents.EmployeeQualifierBase.renderItemOfList},
{name: 'employeeEducationList', displayName:'员工教育',type:'employeeEducation',count:employeeEducationCount,addFunction: true, role: 'employeeEducation', metaInfo: employeeEducationListMetaInfo, renderItem: GlobalComponents.EmployeeEducationBase.renderItemOfList},
{name: 'employeeAwardList', displayName:'员工嘉奖',type:'employeeAward',count:employeeAwardCount,addFunction: true, role: 'employeeAward', metaInfo: employeeAwardListMetaInfo, renderItem: GlobalComponents.EmployeeAwardBase.renderItemOfList},
{name: 'employeeSalarySheetList', displayName:'工资单',type:'employeeSalarySheet',count:employeeSalarySheetCount,addFunction: true, role: 'employeeSalarySheet', metaInfo: employeeSalarySheetListMetaInfo, renderItem: GlobalComponents.EmployeeSalarySheetBase.renderItemOfList},
{name: 'payingOffList', displayName:'工资支付',type:'payingOff',count:payingOffCount,addFunction: true, role: 'payingOff', metaInfo: payingOffListMetaInfo, renderItem: GlobalComponents.PayingOffBase.renderItemOfList},
    
      	],
   		subSettingItems: [
    
      	],     	
      	
  	};
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
<<<<<<< HEAD
=======
    const renderAnalytics = this.props.renderAnalytics || defaultRenderAnalytics
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
<<<<<<< HEAD
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
=======
       
        {renderExtraHeader(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}  
        {quickFunctions(cardsData)} 
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    )
  }
}

export default connect(state => ({
  employee: state._employee,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(EmployeeDashboard))

