

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
import styles from './ConsumerOrder.dashboard.less'
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


const imageList =(consumerOrder)=>{return [
	 ]}

const internalImageListOf = (consumerOrder) =>defaultImageListOf(consumerOrder,imageList)

const optionList =(consumerOrder)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (consumerOrder) =>defaultSettingListOf(consumerOrder, optionList)
const internalLargeTextOf = (consumerOrder) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (consumerOrder,targetComponent) =>{
	
	
	const {ConsumerOrderService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{consumerOrder.id}</Description> 
<Description term="Title">{consumerOrder.title}</Description> 
<Description term="Consumer">{consumerOrder.consumer==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.consumer.displayName}(${consumerOrder.consumer.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Consumer","retailStoreMember",ConsumerOrderService.requestCandidateConsumer,
	      ConsumerOrderService.transferToAnotherConsumer,"anotherConsumerId",consumerOrder.consumer?consumerOrder.consumer.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Store">{consumerOrder.store==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.store.displayName}(${consumerOrder.store.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Store","retailStore",ConsumerOrderService.requestCandidateStore,
	      ConsumerOrderService.transferToAnotherStore,"anotherStoreId",consumerOrder.store?consumerOrder.store.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Last Update Time">{ moment(consumerOrder.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{consumerOrder.currentStatus}</Description> 
	
        {buildTransferModal(consumerOrder,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class ConsumerOrderDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'consumerOrder'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, consumerOrderLineItemListMetaInfo, consumerOrderShippingGroupListMetaInfo, consumerOrderPaymentGroupListMetaInfo, consumerOrderPriceAdjustmentListMetaInfo, retailStoreMemberGiftCardConsumeRecordListMetaInfo, consumerOrderLineItemCount, consumerOrderShippingGroupCount, consumerOrderPaymentGroupCount, consumerOrderPriceAdjustmentCount, retailStoreMemberGiftCardConsumeRecordCount } = this.props.consumerOrder
    if(!this.props.consumerOrder.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Consumer Order",cardsFor: "consumerOrder",
    	cardsSource: this.props.consumerOrder,returnURL,displayName,
  		subItems: [
{name: 'consumerOrderLineItemList', displayName:'Consumer Order Line Item',type:'consumerOrderLineItem',count:consumerOrderLineItemCount,addFunction: true, role: 'consumerOrderLineItem', metaInfo: consumerOrderLineItemListMetaInfo, renderItem: GlobalComponents.ConsumerOrderLineItemBase.renderItemOfList},
{name: 'consumerOrderShippingGroupList', displayName:'Consumer Order Shipping Group',type:'consumerOrderShippingGroup',count:consumerOrderShippingGroupCount,addFunction: true, role: 'consumerOrderShippingGroup', metaInfo: consumerOrderShippingGroupListMetaInfo, renderItem: GlobalComponents.ConsumerOrderShippingGroupBase.renderItemOfList},
{name: 'consumerOrderPaymentGroupList', displayName:'Consumer Order Payment Group',type:'consumerOrderPaymentGroup',count:consumerOrderPaymentGroupCount,addFunction: true, role: 'consumerOrderPaymentGroup', metaInfo: consumerOrderPaymentGroupListMetaInfo, renderItem: GlobalComponents.ConsumerOrderPaymentGroupBase.renderItemOfList},
{name: 'consumerOrderPriceAdjustmentList', displayName:'Consumer Order Price Adjustment',type:'consumerOrderPriceAdjustment',count:consumerOrderPriceAdjustmentCount,addFunction: true, role: 'consumerOrderPriceAdjustment', metaInfo: consumerOrderPriceAdjustmentListMetaInfo, renderItem: GlobalComponents.ConsumerOrderPriceAdjustmentBase.renderItemOfList},
{name: 'retailStoreMemberGiftCardConsumeRecordList', displayName:'Retail Store Member Gift Card Consume Record',type:'retailStoreMemberGiftCardConsumeRecord',count:retailStoreMemberGiftCardConsumeRecordCount,addFunction: true, role: 'retailStoreMemberGiftCardConsumeRecord', metaInfo: retailStoreMemberGiftCardConsumeRecordListMetaInfo, renderItem: GlobalComponents.RetailStoreMemberGiftCardConsumeRecordBase.renderItemOfList},
    
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
  consumerOrder: state._consumerOrder,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(ConsumerOrderDashboard))

