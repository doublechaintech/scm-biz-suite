

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
import styles from './PotentialCustomerContactPerson.dashboard.less'
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


const imageList =(potentialCustomerContactPerson)=>{return [
	 ]}

const internalImageListOf = (potentialCustomerContactPerson) =>defaultImageListOf(potentialCustomerContactPerson,imageList)

const optionList =(potentialCustomerContactPerson)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (potentialCustomerContactPerson) =>defaultSettingListOf(potentialCustomerContactPerson, optionList)
const internalLargeTextOf = (potentialCustomerContactPerson) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (potentialCustomerContactPerson,targetComponent) =>{
	
	
	const {PotentialCustomerContactPersonService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{potentialCustomerContactPerson.id}</Description> 
<Description term="Name">{potentialCustomerContactPerson.name}</Description> 
<Description term="Mobile">{potentialCustomerContactPerson.mobile}</Description> 
<Description term="Potential Customer">{potentialCustomerContactPerson.potentialCustomer==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContactPerson.potentialCustomer.displayName}(${potentialCustomerContactPerson.potentialCustomer.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Potential Customer","potentialCustomer",PotentialCustomerContactPersonService.requestCandidatePotentialCustomer,
	      PotentialCustomerContactPersonService.transferToAnotherPotentialCustomer,"anotherPotentialCustomerId",potentialCustomerContactPerson.potentialCustomer?potentialCustomerContactPerson.potentialCustomer.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Description">{potentialCustomerContactPerson.description}</Description> 
	
        {buildTransferModal(potentialCustomerContactPerson,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class PotentialCustomerContactPersonDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'potentialCustomerContactPerson'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, potentialCustomerContactListMetaInfo, potentialCustomerContactCount } = this.props.potentialCustomerContactPerson
    if(!this.props.potentialCustomerContactPerson.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Potential Customer Contact Person",cardsFor: "potentialCustomerContactPerson",
    	cardsSource: this.props.potentialCustomerContactPerson,returnURL,displayName,
  		subItems: [
{name: 'potentialCustomerContactList', displayName:'Potential Customer Contact',type:'potentialCustomerContact',count:potentialCustomerContactCount,addFunction: true, role: 'potentialCustomerContact', metaInfo: potentialCustomerContactListMetaInfo, renderItem: GlobalComponents.PotentialCustomerContactBase.renderItemOfList},
    
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
  potentialCustomerContactPerson: state._potentialCustomerContactPerson,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(PotentialCustomerContactPersonDashboard))

