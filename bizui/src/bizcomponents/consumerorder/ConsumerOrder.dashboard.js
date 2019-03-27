

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
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,defaultQuickFunctions
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
<Description term="序号">{consumerOrder.id}</Description> 
<Description term="头衔">{consumerOrder.title}</Description> 
<Description term="消费者">{consumerOrder.consumer==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.consumer.displayName}(${consumerOrder.consumer.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"消费者","retailStoreMember",ConsumerOrderService.requestCandidateConsumer,
	      ConsumerOrderService.transferToAnotherConsumer,"anotherConsumerId",consumerOrder.consumer?consumerOrder.consumer.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="商场">{consumerOrder.store==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.store.displayName}(${consumerOrder.store.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"商场","retailStore",ConsumerOrderService.requestCandidateStore,
	      ConsumerOrderService.transferToAnotherStore,"anotherStoreId",consumerOrder.store?consumerOrder.store.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="最后更新时间">{ moment(consumerOrder.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="当前状态">{consumerOrder.currentStatus}</Description> 
	
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
    
    const cardsData = {cardsName:"消费者订单",cardsFor: "consumerOrder",
    	cardsSource: this.props.consumerOrder,returnURL,displayName,
  		subItems: [
{name: 'consumerOrderLineItemList', displayName:'消费者订单行项目',type:'consumerOrderLineItem',count:consumerOrderLineItemCount,addFunction: true, role: 'consumerOrderLineItem', metaInfo: consumerOrderLineItemListMetaInfo},
{name: 'consumerOrderShippingGroupList', displayName:'消费订单送货分组',type:'consumerOrderShippingGroup',count:consumerOrderShippingGroupCount,addFunction: true, role: 'consumerOrderShippingGroup', metaInfo: consumerOrderShippingGroupListMetaInfo},
{name: 'consumerOrderPaymentGroupList', displayName:'消费者订单付款组',type:'consumerOrderPaymentGroup',count:consumerOrderPaymentGroupCount,addFunction: true, role: 'consumerOrderPaymentGroup', metaInfo: consumerOrderPaymentGroupListMetaInfo},
{name: 'consumerOrderPriceAdjustmentList', displayName:'消费品价格调整',type:'consumerOrderPriceAdjustment',count:consumerOrderPriceAdjustmentCount,addFunction: true, role: 'consumerOrderPriceAdjustment', metaInfo: consumerOrderPriceAdjustmentListMetaInfo},
{name: 'retailStoreMemberGiftCardConsumeRecordList', displayName:'零售商店会员卡消费记录',type:'retailStoreMemberGiftCardConsumeRecord',count:retailStoreMemberGiftCardConsumeRecordCount,addFunction: true, role: 'retailStoreMemberGiftCardConsumeRecord', metaInfo: retailStoreMemberGiftCardConsumeRecordListMetaInfo},
    
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
  consumerOrder: state._consumerOrder,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(ConsumerOrderDashboard))

