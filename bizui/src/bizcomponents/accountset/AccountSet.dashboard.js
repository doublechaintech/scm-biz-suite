

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
import styles from './AccountSet.dashboard.less'
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


const imageList =(accountSet)=>{return [
	 ]}

const internalImageListOf = (accountSet) =>defaultImageListOf(accountSet,imageList)

const optionList =(accountSet)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (accountSet) =>defaultSettingListOf(accountSet, optionList)
const internalLargeTextOf = (accountSet) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (accountSet,targetComponent) =>{
	
	
	const {AccountSetService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{accountSet.id}</Description> 
<Description term="Name">{accountSet.name}</Description> 
<Description term="Year Set">{accountSet.yearSet}</Description> 
<Description term="Effective Date">{ moment(accountSet.effectiveDate).format('YYYY-MM-DD')}</Description> 
<Description term="Accounting System">{accountSet.accountingSystem}</Description> 
<Description term="Domestic Currency Code">{accountSet.domesticCurrencyCode}</Description> 
<Description term="Domestic Currency Name">{accountSet.domesticCurrencyName}</Description> 
<Description term="Opening Bank">{accountSet.openingBank}</Description> 
<Description term="Account Number">{accountSet.accountNumber}</Description> 
<Description term="Retail Store">{accountSet.retailStore==null?appLocaleName(userContext,"NotAssigned"):`${accountSet.retailStore.displayName}(${accountSet.retailStore.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Retail Store","retailStore",AccountSetService.requestCandidateRetailStore,
	      AccountSetService.transferToAnotherRetailStore,"anotherRetailStoreId",accountSet.retailStore?accountSet.retailStore.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Goods Supplier">{accountSet.goodsSupplier==null?appLocaleName(userContext,"NotAssigned"):`${accountSet.goodsSupplier.displayName}(${accountSet.goodsSupplier.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Goods Supplier","goodsSupplier",AccountSetService.requestCandidateGoodsSupplier,
	      AccountSetService.transferToAnotherGoodsSupplier,"anotherGoodsSupplierId",accountSet.goodsSupplier?accountSet.goodsSupplier.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Last Update Time">{ moment(accountSet.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(accountSet,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class AccountSetDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'accountSet'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, accountingSubjectListMetaInfo, accountingPeriodListMetaInfo, accountingDocumentTypeListMetaInfo, accountingSubjectCount, accountingPeriodCount, accountingDocumentTypeCount } = this.props.accountSet
    if(!this.props.accountSet.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Account Set",cardsFor: "accountSet",
    	cardsSource: this.props.accountSet,returnURL,displayName,
  		subItems: [
{name: 'accountingSubjectList', displayName:'Accounting Subject',type:'accountingSubject',count:accountingSubjectCount,addFunction: true, role: 'accountingSubject', metaInfo: accountingSubjectListMetaInfo, renderItem: GlobalComponents.AccountingSubjectBase.renderItemOfList},
{name: 'accountingPeriodList', displayName:'Accounting Period',type:'accountingPeriod',count:accountingPeriodCount,addFunction: true, role: 'accountingPeriod', metaInfo: accountingPeriodListMetaInfo, renderItem: GlobalComponents.AccountingPeriodBase.renderItemOfList},
{name: 'accountingDocumentTypeList', displayName:'Accounting Document Type',type:'accountingDocumentType',count:accountingDocumentTypeCount,addFunction: true, role: 'accountingDocumentType', metaInfo: accountingDocumentTypeListMetaInfo, renderItem: GlobalComponents.AccountingDocumentTypeBase.renderItemOfList},
    
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
  accountSet: state._accountSet,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(AccountSetDashboard))

