

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
import styles from './CompanyTraining.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'


const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
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
const internalSettingListOf = (companyTraining) =>defaultSettingListOf(companyTraining, optionList)
const internalLargeTextOf = (companyTraining) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (companyTraining,targetComponent) =>{
	
	
	const {CompanyTrainingService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{companyTraining.id}</Description> 
<Description term="头衔">{companyTraining.title}</Description> 
<Description term="讲师">{companyTraining.instructor==null?"未分配":companyTraining.instructor.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"讲师","instructor",CompanyTrainingService.requestCandidateInstructor,
	      CompanyTrainingService.transferToAnotherInstructor,"anotherInstructorId",companyTraining.instructor?companyTraining.instructor.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="培训课程类型">{companyTraining.trainingCourseType==null?"未分配":companyTraining.trainingCourseType.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"培训课程类型","trainingCourseType",CompanyTrainingService.requestCandidateTrainingCourseType,
	      CompanyTrainingService.transferToAnotherTrainingCourseType,"anotherTrainingCourseTypeId",companyTraining.trainingCourseType?companyTraining.trainingCourseType.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="时间开始">{ moment(companyTraining.timeStart).format('YYYY-MM-DD')}</Description> 
<Description term="持续时间">{companyTraining.durationHours}</Description> 
<Description term="最后更新时间">{ moment(companyTraining.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(companyTraining,targetComponent)}
      </DescriptionList>
	)

}


class CompanyTrainingDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
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
{name: 'employeeCompanyTrainingList', displayName:'员工参与的公司培训',type:'employeeCompanyTraining',count:employeeCompanyTrainingCount,addFunction: true, role: 'employeeCompanyTraining', metaInfo: employeeCompanyTrainingListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  companyTraining: state._companyTraining,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(CompanyTrainingDashboard))

