

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
      <Link to={`/employeeSalarySheet/${targetComponent.props.employeeSalarySheet.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/employeeSalarySheet/${targetComponent.props.employeeSalarySheet.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (employeeSalarySheet,targetComponent) =>{
	
	
	const {EmployeeSalarySheetService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<<<<<<< HEAD
<Description term="序号">{employeeSalarySheet.id}</Description> 
=======
<Description term="序号" style={{wordBreak: 'break-all'}}>{employeeSalarySheet.id}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
<Description term="员工">{employeeSalarySheet.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.employee.displayName}(${employeeSalarySheet.employee.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"员工","employee",EmployeeSalarySheetService.requestCandidateEmployee,
	      EmployeeSalarySheetService.transferToAnotherEmployee,"anotherEmployeeId",employeeSalarySheet.employee?employeeSalarySheet.employee.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="目前工资等级">{employeeSalarySheet.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.currentSalaryGrade.displayName}(${employeeSalarySheet.currentSalaryGrade.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"目前工资等级","salaryGrade",EmployeeSalarySheetService.requestCandidateCurrentSalaryGrade,
	      EmployeeSalarySheetService.transferToAnotherCurrentSalaryGrade,"anotherCurrentSalaryGradeId",employeeSalarySheet.currentSalaryGrade?employeeSalarySheet.currentSalaryGrade.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<<<<<<< HEAD
<Description term="基本工资">{employeeSalarySheet.baseSalary}</Description> 
<Description term="奖金">{employeeSalarySheet.bonus}</Description> 
<Description term="奖励">{employeeSalarySheet.reward}</Description> 
<Description term="个人所得税">{employeeSalarySheet.personalTax}</Description> 
<Description term="社会保险">{employeeSalarySheet.socialSecurity}</Description> 
<Description term="住房公积金">{employeeSalarySheet.housingFound}</Description> 
<Description term="失业保险">{employeeSalarySheet.jobInsurance}</Description> 
=======
<Description term="基本工资" style={{wordBreak: 'break-all'}}>{employeeSalarySheet.baseSalary}</Description> 
<Description term="奖金" style={{wordBreak: 'break-all'}}>{employeeSalarySheet.bonus}</Description> 
<Description term="奖励" style={{wordBreak: 'break-all'}}>{employeeSalarySheet.reward}</Description> 
<Description term="个人所得税" style={{wordBreak: 'break-all'}}>{employeeSalarySheet.personalTax}</Description> 
<Description term="社会保险" style={{wordBreak: 'break-all'}}>{employeeSalarySheet.socialSecurity}</Description> 
<Description term="住房公积金" style={{wordBreak: 'break-all'}}>{employeeSalarySheet.housingFound}</Description> 
<Description term="失业保险" style={{wordBreak: 'break-all'}}>{employeeSalarySheet.jobInsurance}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
<Description term="工资支付">{employeeSalarySheet.payingOff==null?appLocaleName(userContext,"NotAssigned"):`${employeeSalarySheet.payingOff.displayName}(${employeeSalarySheet.payingOff.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"工资支付","payingOff",EmployeeSalarySheetService.requestCandidatePayingOff,
	      EmployeeSalarySheetService.transferToAnotherPayingOff,"anotherPayingOffId",employeeSalarySheet.payingOff?employeeSalarySheet.payingOff.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
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
    
    const cardsData = {cardsName:"工资单",cardsFor: "employeeSalarySheet",
    	cardsSource: this.props.employeeSalarySheet,returnURL,displayName,
  		subItems: [
    
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
        {imageListOf(cardsData.cardsSource)}  
        {quickFunctions(cardsData)} 
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
  employeeSalarySheet: state._employeeSalarySheet,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(EmployeeSalarySheetDashboard))

