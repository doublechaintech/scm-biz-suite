

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
import styles from './AccountingDocumentLine.dashboard.less'
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


const imageList =(accountingDocumentLine)=>{return [
	 ]}

const internalImageListOf = (accountingDocumentLine) =>defaultImageListOf(accountingDocumentLine,imageList)

const optionList =(accountingDocumentLine)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (accountingDocumentLine) =>defaultSettingListOf(accountingDocumentLine, optionList)
const internalLargeTextOf = (accountingDocumentLine) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (accountingDocumentLine,targetComponent) =>{
	
	
	const {AccountingDocumentLineService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{accountingDocumentLine.id}</Description> 
<Description term="Name">{accountingDocumentLine.name}</Description> 
<Description term="Code">{accountingDocumentLine.code}</Description> 
<Description term="Direct">{accountingDocumentLine.direct}</Description> 
<Description term="Amount">{accountingDocumentLine.amount}</Description> 
<Description term="Belongs To">{accountingDocumentLine.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocumentLine.belongsTo.displayName}(${accountingDocumentLine.belongsTo.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Belongs To","accountingDocument",AccountingDocumentLineService.requestCandidateBelongsTo,
	      AccountingDocumentLineService.transferToAnotherBelongsTo,"anotherBelongsToId",accountingDocumentLine.belongsTo?accountingDocumentLine.belongsTo.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Accounting Subject">{accountingDocumentLine.accountingSubject==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocumentLine.accountingSubject.displayName}(${accountingDocumentLine.accountingSubject.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Accounting Subject","accountingSubject",AccountingDocumentLineService.requestCandidateAccountingSubject,
	      AccountingDocumentLineService.transferToAnotherAccountingSubject,"anotherAccountingSubjectId",accountingDocumentLine.accountingSubject?accountingDocumentLine.accountingSubject.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(accountingDocumentLine,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class AccountingDocumentLineDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'accountingDocumentLine'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.accountingDocumentLine
    if(!this.props.accountingDocumentLine.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Accounting Document Line",cardsFor: "accountingDocumentLine",
    	cardsSource: this.props.accountingDocumentLine,returnURL,displayName,
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
  accountingDocumentLine: state._accountingDocumentLine,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(AccountingDocumentLineDashboard))

