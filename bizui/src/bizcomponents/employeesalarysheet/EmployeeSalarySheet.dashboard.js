

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
import styles from './EmployeeSalarySheet.dashboard.less'
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


const imageList =(employeeSalarySheet)=>{return [
	 ]}

const internalImageListOf = (employeeSalarySheet) =>defaultImageListOf(employeeSalarySheet,imageList)

const optionList =(employeeSalarySheet)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (employeeSalarySheet) =>defaultSettingListOf(employeeSalarySheet, optionList)
const internalLargeTextOf = (employeeSalarySheet) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (employeeSalarySheet,targetComponent) =>{
	
	
	const {EmployeeSalarySheetService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{employeeSalarySheet.id}</Description> 
<Description term="Employee">{employeeSalarySheet.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.employee.displayName}(${employeeSalarySheet.employee.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Employee","employee",EmployeeSalarySheetService.requestCandidateEmployee,
	      EmployeeSalarySheetService.transferToAnotherEmployee,"anotherEmployeeId",employeeSalarySheet.employee?employeeSalarySheet.employee.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Current Salary Grade">{employeeSalarySheet.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.currentSalaryGrade.displayName}(${employeeSalarySheet.currentSalaryGrade.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Current Salary Grade","salaryGrade",EmployeeSalarySheetService.requestCandidateCurrentSalaryGrade,
	      EmployeeSalarySheetService.transferToAnotherCurrentSalaryGrade,"anotherCurrentSalaryGradeId",employeeSalarySheet.currentSalaryGrade?employeeSalarySheet.currentSalaryGrade.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Base Salary">{employeeSalarySheet.baseSalary}</Description> 
<Description term="Bonus">{employeeSalarySheet.bonus}</Description> 
<Description term="Reward">{employeeSalarySheet.reward}</Description> 
<Description term="Personal Tax">{employeeSalarySheet.personalTax}</Description> 
<Description term="Social Security">{employeeSalarySheet.socialSecurity}</Description> 
<Description term="Housing Found">{employeeSalarySheet.housingFound}</Description> 
<Description term="Job Insurance">{employeeSalarySheet.jobInsurance}</Description> 
<Description term="Paying Off">{employeeSalarySheet.payingOff==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.payingOff.displayName}(${employeeSalarySheet.payingOff.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Paying Off","payingOff",EmployeeSalarySheetService.requestCandidatePayingOff,
	      EmployeeSalarySheetService.transferToAnotherPayingOff,"anotherPayingOffId",employeeSalarySheet.payingOff?employeeSalarySheet.payingOff.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Current Status">{employeeSalarySheet.currentStatus}</Description> 
	
        {buildTransferModal(employeeSalarySheet,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class EmployeeSalarySheetDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'employeeSalarySheet'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.employeeSalarySheet
    if(!this.props.employeeSalarySheet.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Employee Salary Sheet",cardsFor: "employeeSalarySheet",
    	cardsSource: this.props.employeeSalarySheet,returnURL,displayName,
  		subItems: [
    
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
  employeeSalarySheet: state._employeeSalarySheet,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(EmployeeSalarySheetDashboard))

