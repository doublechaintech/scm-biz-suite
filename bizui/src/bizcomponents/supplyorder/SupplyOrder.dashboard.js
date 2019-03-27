

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
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,defaultQuickFunctions
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
<Description term="序号">{supplyOrder.id}</Description> 
<Description term="卖方">{supplyOrder.seller==null?appLocaleName(userContext,"NotAssigned"):`${supplyOrder.seller.displayName}(${supplyOrder.seller.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"卖方","goodsSupplier",SupplyOrderService.requestCandidateSeller,
	      SupplyOrderService.transferToAnotherSeller,"anotherSellerId",supplyOrder.seller?supplyOrder.seller.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="头衔">{supplyOrder.title}</Description> 
<Description term="总金额">{supplyOrder.totalAmount}</Description> 
<Description term="最后更新时间">{ moment(supplyOrder.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="当前状态">{supplyOrder.currentStatus}</Description> 
	
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
    
    const cardsData = {cardsName:"供应订单",cardsFor: "supplyOrder",
    	cardsSource: this.props.supplyOrder,returnURL,displayName,
  		subItems: [
{name: 'supplyOrderLineItemList', displayName:'供应订单行项目',type:'supplyOrderLineItem',count:supplyOrderLineItemCount,addFunction: true, role: 'supplyOrderLineItem', metaInfo: supplyOrderLineItemListMetaInfo},
{name: 'supplyOrderShippingGroupList', displayName:'供应订单送货分组',type:'supplyOrderShippingGroup',count:supplyOrderShippingGroupCount,addFunction: true, role: 'supplyOrderShippingGroup', metaInfo: supplyOrderShippingGroupListMetaInfo},
{name: 'supplyOrderPaymentGroupList', displayName:'供应订单付款组',type:'supplyOrderPaymentGroup',count:supplyOrderPaymentGroupCount,addFunction: true, role: 'supplyOrderPaymentGroup', metaInfo: supplyOrderPaymentGroupListMetaInfo},
{name: 'goodsList', displayName:'货物',type:'goods',count:goodsCount,addFunction: true, role: 'goods', metaInfo: goodsListMetaInfo},
    
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
  supplyOrder: state._supplyOrder,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(SupplyOrderDashboard))

