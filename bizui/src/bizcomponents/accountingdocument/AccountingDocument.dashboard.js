

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
import styles from './AccountingDocument.dashboard.less'
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


const imageList =(accountingDocument)=>{return [
	 ]}

const internalImageListOf = (accountingDocument) =>defaultImageListOf(accountingDocument,imageList)

const optionList =(accountingDocument)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (accountingDocument) =>defaultSettingListOf(accountingDocument, optionList)
const internalLargeTextOf = (accountingDocument) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (accountingDocument,targetComponent) =>{
	
	
	const {AccountingDocumentService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{accountingDocument.id}</Description> 
<Description term="名称">{accountingDocument.name}</Description> 
<Description term="会计凭证日期">{ moment(accountingDocument.accountingDocumentDate).format('YYYY-MM-DD')}</Description> 
<Description term="会计期间">{accountingDocument.accountingPeriod==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocument.accountingPeriod.displayName}(${accountingDocument.accountingPeriod.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"会计期间","accountingPeriod",AccountingDocumentService.requestCandidateAccountingPeriod,
	      AccountingDocumentService.transferToAnotherAccountingPeriod,"anotherAccountingPeriodId",accountingDocument.accountingPeriod?accountingDocument.accountingPeriod.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="文档类型">{accountingDocument.documentType==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocument.documentType.displayName}(${accountingDocument.documentType.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"文档类型","accountingDocumentType",AccountingDocumentService.requestCandidateDocumentType,
	      AccountingDocumentService.transferToAnotherDocumentType,"anotherDocumentTypeId",accountingDocument.documentType?accountingDocument.documentType.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="当前状态">{accountingDocument.currentStatus}</Description> 
	
        {buildTransferModal(accountingDocument,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class AccountingDocumentDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'accountingDocument'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, originalVoucherListMetaInfo, accountingDocumentLineListMetaInfo, originalVoucherCount, accountingDocumentLineCount } = this.props.accountingDocument
    if(!this.props.accountingDocument.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"会计凭证",cardsFor: "accountingDocument",
    	cardsSource: this.props.accountingDocument,returnURL,displayName,
  		subItems: [
{name: 'originalVoucherList', displayName:'原始凭证',type:'originalVoucher',count:originalVoucherCount,addFunction: true, role: 'originalVoucher', metaInfo: originalVoucherListMetaInfo, renderItem: GlobalComponents.OriginalVoucherBase.renderItemOfList},
{name: 'accountingDocumentLineList', displayName:'会计凭证行',type:'accountingDocumentLine',count:accountingDocumentLineCount,addFunction: true, role: 'accountingDocumentLine', metaInfo: accountingDocumentLineListMetaInfo, renderItem: GlobalComponents.AccountingDocumentLineBase.renderItemOfList},
    
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
  accountingDocument: state._accountingDocument,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(AccountingDocumentDashboard))

