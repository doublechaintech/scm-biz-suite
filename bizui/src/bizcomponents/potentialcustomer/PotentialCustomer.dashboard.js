

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
import styles from './PotentialCustomer.dashboard.less'
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


const imageList =(potentialCustomer)=>{return [
	 ]}

const internalImageListOf = (potentialCustomer) =>defaultImageListOf(potentialCustomer,imageList)

const optionList =(potentialCustomer)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (potentialCustomer) =>defaultSettingListOf(potentialCustomer, optionList)
const internalLargeTextOf = (potentialCustomer) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (potentialCustomer,targetComponent) =>{
	
	
	const {PotentialCustomerService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{potentialCustomer.id}</Description> 
<Description term="Name">{potentialCustomer.name}</Description> 
<Description term="Mobile">{potentialCustomer.mobile}</Description> 
<Description term="City Service Center">{potentialCustomer.cityServiceCenter==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomer.cityServiceCenter.displayName}(${potentialCustomer.cityServiceCenter.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"City Service Center","retailStoreCityServiceCenter",PotentialCustomerService.requestCandidateCityServiceCenter,
	      PotentialCustomerService.transferToAnotherCityServiceCenter,"anotherCityServiceCenterId",potentialCustomer.cityServiceCenter?potentialCustomer.cityServiceCenter.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="City Partner">{potentialCustomer.cityPartner==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomer.cityPartner.displayName}(${potentialCustomer.cityPartner.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"City Partner","cityPartner",PotentialCustomerService.requestCandidateCityPartner,
	      PotentialCustomerService.transferToAnotherCityPartner,"anotherCityPartnerId",potentialCustomer.cityPartner?potentialCustomer.cityPartner.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Description">{potentialCustomer.description}</Description> 
<Description term="Last Update Time">{ moment(potentialCustomer.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(potentialCustomer,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class PotentialCustomerDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'potentialCustomer'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, potentialCustomerContactPersonListMetaInfo, potentialCustomerContactListMetaInfo, eventAttendanceListMetaInfo, potentialCustomerContactPersonCount, potentialCustomerContactCount, eventAttendanceCount } = this.props.potentialCustomer
    if(!this.props.potentialCustomer.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Potential Customer",cardsFor: "potentialCustomer",
    	cardsSource: this.props.potentialCustomer,returnURL,displayName,
  		subItems: [
{name: 'potentialCustomerContactPersonList', displayName:'Potential Customer Contact Person',type:'potentialCustomerContactPerson',count:potentialCustomerContactPersonCount,addFunction: true, role: 'potentialCustomerContactPerson', metaInfo: potentialCustomerContactPersonListMetaInfo, renderItem: GlobalComponents.PotentialCustomerContactPersonBase.renderItemOfList},
{name: 'potentialCustomerContactList', displayName:'Potential Customer Contact',type:'potentialCustomerContact',count:potentialCustomerContactCount,addFunction: true, role: 'potentialCustomerContact', metaInfo: potentialCustomerContactListMetaInfo, renderItem: GlobalComponents.PotentialCustomerContactBase.renderItemOfList},
{name: 'eventAttendanceList', displayName:'Event Attendance',type:'eventAttendance',count:eventAttendanceCount,addFunction: true, role: 'eventAttendance', metaInfo: eventAttendanceListMetaInfo, renderItem: GlobalComponents.EventAttendanceBase.renderItemOfList},
    
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
  potentialCustomer: state._potentialCustomer,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(PotentialCustomerDashboard))

