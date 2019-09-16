

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
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
import styles from './CompanyTraining.dashboard.less'
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


const imageList =(companyTraining)=>{return [
	 ]}

const internalImageListOf = (companyTraining) =>defaultImageListOf(companyTraining,imageList)

const optionList =(companyTraining)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (companyTraining) =>defaultSettingListOf(companyTraining, optionList)
const internalLargeTextOf = (companyTraining) =>{

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
      <Link to={`/companyTraining/${targetComponent.props.companyTraining.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/companyTraining/${targetComponent.props.companyTraining.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (companyTraining,targetComponent) =>{
	
	
	const {CompanyTrainingService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{companyTraining.id}</Description> 
<Description term="头衔">{companyTraining.title}</Description> 
<Description term="讲师">{companyTraining.instructor==null?appLocaleName(userContext,"NotAssigned"):`${companyTraining.instructor.displayName}(${companyTraining.instructor.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"讲师","instructor",CompanyTrainingService.requestCandidateInstructor,
	      CompanyTrainingService.transferToAnotherInstructor,"anotherInstructorId",companyTraining.instructor?companyTraining.instructor.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="培训课程类型">{companyTraining.trainingCourseType==null?appLocaleName(userContext,"NotAssigned"):`${companyTraining.trainingCourseType.displayName}(${companyTraining.trainingCourseType.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"培训课程类型","trainingCourseType",CompanyTrainingService.requestCandidateTrainingCourseType,
	      CompanyTrainingService.transferToAnotherTrainingCourseType,"anotherTrainingCourseTypeId",companyTraining.trainingCourseType?companyTraining.trainingCourseType.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="时间开始">{ moment(companyTraining.timeStart).format('YYYY-MM-DD')}</Description> 
<Description term="持续时间">{companyTraining.durationHours}</Description> 
<Description term="最后更新时间">{ moment(companyTraining.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
	
        {buildTransferModal(companyTraining,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class CompanyTrainingDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'companyTraining'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, employeeCompanyTrainingListMetaInfo, employeeCompanyTrainingCount } = this.props.companyTraining
    if(!this.props.companyTraining.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"公司培训",cardsFor: "companyTraining",
    	cardsSource: this.props.companyTraining,returnURL,displayName,
  		subItems: [
{name: 'employeeCompanyTrainingList', displayName:'员工参与的公司培训',type:'employeeCompanyTraining',count:employeeCompanyTrainingCount,addFunction: true, role: 'employeeCompanyTraining', metaInfo: employeeCompanyTrainingListMetaInfo, renderItem: GlobalComponents.EmployeeCompanyTrainingBase.renderItemOfList},
    
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
  companyTraining: state._companyTraining,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(CompanyTrainingDashboard))

