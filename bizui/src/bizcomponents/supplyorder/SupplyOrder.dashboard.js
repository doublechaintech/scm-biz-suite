

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
import styles from './SupplyOrder.dashboard.less'
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


const imageList =(supplyOrder)=>{return [
	 ]}

const internalImageListOf = (supplyOrder) =>defaultImageListOf(supplyOrder,imageList)

const optionList =(supplyOrder)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (supplyOrder) =>defaultSettingListOf(supplyOrder, optionList)
const internalLargeTextOf = (supplyOrder) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (supplyOrder,targetComponent) =>{
	
	
	const {SupplyOrderService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{supplyOrder.id}</Description> 
<Description term="Seller">{supplyOrder.seller==null?appLocaleName(userContext,"NotAssigned"):`${supplyOrder.seller.displayName}(${supplyOrder.seller.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Seller","goodsSupplier",SupplyOrderService.requestCandidateSeller,
	      SupplyOrderService.transferToAnotherSeller,"anotherSellerId",supplyOrder.seller?supplyOrder.seller.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Title">{supplyOrder.title}</Description> 
<Description term="Total Amount">{supplyOrder.totalAmount}</Description> 
<Description term="Last Update Time">{ moment(supplyOrder.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{supplyOrder.currentStatus}</Description> 
	
        {buildTransferModal(supplyOrder,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class SupplyOrderDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'supplyOrder'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, supplyOrderLineItemListMetaInfo, supplyOrderShippingGroupListMetaInfo, supplyOrderPaymentGroupListMetaInfo, goodsListMetaInfo, supplyOrderLineItemCount, supplyOrderShippingGroupCount, supplyOrderPaymentGroupCount, goodsCount } = this.props.supplyOrder
    if(!this.props.supplyOrder.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Supply Order",cardsFor: "supplyOrder",
    	cardsSource: this.props.supplyOrder,returnURL,displayName,
  		subItems: [
{name: 'supplyOrderLineItemList', displayName:'Supply Order Line Item',type:'supplyOrderLineItem',count:supplyOrderLineItemCount,addFunction: true, role: 'supplyOrderLineItem', metaInfo: supplyOrderLineItemListMetaInfo, renderItem: GlobalComponents.SupplyOrderLineItemBase.renderItemOfList},
{name: 'supplyOrderShippingGroupList', displayName:'Supply Order Shipping Group',type:'supplyOrderShippingGroup',count:supplyOrderShippingGroupCount,addFunction: true, role: 'supplyOrderShippingGroup', metaInfo: supplyOrderShippingGroupListMetaInfo, renderItem: GlobalComponents.SupplyOrderShippingGroupBase.renderItemOfList},
{name: 'supplyOrderPaymentGroupList', displayName:'Supply Order Payment Group',type:'supplyOrderPaymentGroup',count:supplyOrderPaymentGroupCount,addFunction: true, role: 'supplyOrderPaymentGroup', metaInfo: supplyOrderPaymentGroupListMetaInfo, renderItem: GlobalComponents.SupplyOrderPaymentGroupBase.renderItemOfList},
{name: 'goodsList', displayName:'Goods',type:'goods',count:goodsCount,addFunction: true, role: 'goods', metaInfo: goodsListMetaInfo, renderItem: GlobalComponents.GoodsBase.renderItemOfList},
    
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
  supplyOrder: state._supplyOrder,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(SupplyOrderDashboard))

