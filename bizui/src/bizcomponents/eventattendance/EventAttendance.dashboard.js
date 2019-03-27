

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
import styles from './EventAttendance.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,defaultQuickFunctions
}= DashboardTool





const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(eventAttendance)=>{return [
	 ]}

const internalImageListOf = (eventAttendance) =>defaultImageListOf(eventAttendance,imageList)

const optionList =(eventAttendance)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (eventAttendance) =>defaultSettingListOf(eventAttendance, optionList)
const internalLargeTextOf = (eventAttendance) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (eventAttendance,targetComponent) =>{
	
	
	const {EventAttendanceService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{eventAttendance.id}</Description> 
<Description term="名称">{eventAttendance.name}</Description> 
<Description term="潜在的客户">{eventAttendance.potentialCustomer==null?appLocaleName(userContext,"NotAssigned"):`${eventAttendance.potentialCustomer.displayName}(${eventAttendance.potentialCustomer.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"潜在的客户","potentialCustomer",EventAttendanceService.requestCandidatePotentialCustomer,
	      EventAttendanceService.transferToAnotherPotentialCustomer,"anotherPotentialCustomerId",eventAttendance.potentialCustomer?eventAttendance.potentialCustomer.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="城市活动">{eventAttendance.cityEvent==null?appLocaleName(userContext,"NotAssigned"):`${eventAttendance.cityEvent.displayName}(${eventAttendance.cityEvent.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"城市活动","cityEvent",EventAttendanceService.requestCandidateCityEvent,
	      EventAttendanceService.transferToAnotherCityEvent,"anotherCityEventId",eventAttendance.cityEvent?eventAttendance.cityEvent.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="描述">{eventAttendance.description}</Description> 
	
        {buildTransferModal(eventAttendance,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class EventAttendanceDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'eventAttendance'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.eventAttendance
    if(!this.props.eventAttendance.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"活动的参与情况",cardsFor: "eventAttendance",
    	cardsSource: this.props.eventAttendance,returnURL,displayName,
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
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
        {quickFunctions(cardsData)} 
        {renderExtraHeader(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}        
        {largeTextOf(cardsData.cardsSource)}
  
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  eventAttendance: state._eventAttendance,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(EventAttendanceDashboard))

