

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
import styles from './PotentialCustomerContact.dashboard.less'
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


const imageList =(potentialCustomerContact)=>{return [
	 ]}

const internalImageListOf = (potentialCustomerContact) =>defaultImageListOf(potentialCustomerContact,imageList)

const optionList =(potentialCustomerContact)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (potentialCustomerContact) =>defaultSettingListOf(potentialCustomerContact, optionList)
const internalLargeTextOf = (potentialCustomerContact) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (potentialCustomerContact,targetComponent) =>{
	
	
	const {PotentialCustomerContactService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{potentialCustomerContact.id}</Description> 
<Description term="Name">{potentialCustomerContact.name}</Description> 
<Description term="Contact Date">{ moment(potentialCustomerContact.contactDate).format('YYYY-MM-DD')}</Description> 
<Description term="Contact Method">{potentialCustomerContact.contactMethod}</Description> 
<Description term="Potential Customer">{potentialCustomerContact.potentialCustomer==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.potentialCustomer.displayName}(${potentialCustomerContact.potentialCustomer.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Potential Customer","potentialCustomer",PotentialCustomerContactService.requestCandidatePotentialCustomer,
	      PotentialCustomerContactService.transferToAnotherPotentialCustomer,"anotherPotentialCustomerId",potentialCustomerContact.potentialCustomer?potentialCustomerContact.potentialCustomer.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="City Partner">{potentialCustomerContact.cityPartner==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.cityPartner.displayName}(${potentialCustomerContact.cityPartner.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"City Partner","cityPartner",PotentialCustomerContactService.requestCandidateCityPartner,
	      PotentialCustomerContactService.transferToAnotherCityPartner,"anotherCityPartnerId",potentialCustomerContact.cityPartner?potentialCustomerContact.cityPartner.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Contact To">{potentialCustomerContact.contactTo==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.contactTo.displayName}(${potentialCustomerContact.contactTo.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Contact To","potentialCustomerContactPerson",PotentialCustomerContactService.requestCandidateContactTo,
	      PotentialCustomerContactService.transferToAnotherContactTo,"anotherContactToId",potentialCustomerContact.contactTo?potentialCustomerContact.contactTo.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Description">{potentialCustomerContact.description}</Description> 
<Description term="Last Update Time">{ moment(potentialCustomerContact.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(potentialCustomerContact,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class PotentialCustomerContactDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'potentialCustomerContact'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.potentialCustomerContact
    if(!this.props.potentialCustomerContact.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Potential Customer Contact",cardsFor: "potentialCustomerContact",
    	cardsSource: this.props.potentialCustomerContact,returnURL,displayName,
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
  potentialCustomerContact: state._potentialCustomerContact,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(PotentialCustomerContactDashboard))

