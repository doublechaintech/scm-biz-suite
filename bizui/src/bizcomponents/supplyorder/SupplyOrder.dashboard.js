

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


const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
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

const internalSummaryOf = (supplyOrder,targetComponent) =>{
	
	
	const {SupplyOrderService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{supplyOrder.id}</Description> 
<Description term="卖方">{supplyOrder.seller==null?"未分配":supplyOrder.seller.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"卖方","goodsSupplier",SupplyOrderService.requestCandidateSeller,
	      SupplyOrderService.transferToAnotherSeller,"anotherSellerId",supplyOrder.seller?supplyOrder.seller.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="头衔">{supplyOrder.title}</Description> 
<Description term="总金额">{supplyOrder.totalAmount}</Description> 
<Description term="当前状态">{supplyOrder.currentStatus}</Description> 
	
        {buildTransferModal(supplyOrder,targetComponent)}
      </DescriptionList>
	)

}


class SupplyOrderDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
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
    const cardsData = {cardsName:"供应订单",cardsFor: "supplyOrder",cardsSource: this.props.supplyOrder,
  		subItems: [
{name: 'supplyOrderLineItemList', displayName:'供应订单行项目',type:'supplyOrderLineItem',count:supplyOrderLineItemCount,addFunction: true, role: 'supplyOrderLineItem', metaInfo: supplyOrderLineItemListMetaInfo},
{name: 'supplyOrderShippingGroupList', displayName:'供应订单送货分组',type:'supplyOrderShippingGroup',count:supplyOrderShippingGroupCount,addFunction: true, role: 'supplyOrderShippingGroup', metaInfo: supplyOrderShippingGroupListMetaInfo},
{name: 'supplyOrderPaymentGroupList', displayName:'供应订单付款组',type:'supplyOrderPaymentGroup',count:supplyOrderPaymentGroupCount,addFunction: true, role: 'supplyOrderPaymentGroup', metaInfo: supplyOrderPaymentGroupListMetaInfo},
{name: 'goodsList', displayName:'货物',type:'goods',count:goodsCount,addFunction: true, role: 'goods', metaInfo: goodsListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  supplyOrder: state._supplyOrder,
}))(Form.create()(SupplyOrderDashboard))

