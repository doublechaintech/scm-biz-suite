

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
import styles from './RetailStoreOrder.dashboard.less'
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


const imageList =(retailStoreOrder)=>{return [
	 ]}

const internalImageListOf = (retailStoreOrder) =>defaultImageListOf(retailStoreOrder,imageList)

const optionList =(retailStoreOrder)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (retailStoreOrder) =>defaultSettingListOf(retailStoreOrder, optionList)
const internalLargeTextOf = (retailStoreOrder) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (retailStoreOrder,targetComponent) =>{
	
	
	const {RetailStoreOrderService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrder.id}</Description> 
<Description term="买方">{retailStoreOrder.buyer==null?"未分配":retailStoreOrder.buyer.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"买方","retailStore",RetailStoreOrderService.requestCandidateBuyer,
	      RetailStoreOrderService.transferToAnotherBuyer,"anotherBuyerId",retailStoreOrder.buyer?retailStoreOrder.buyer.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="头衔">{retailStoreOrder.title}</Description> 
<Description term="总金额">{retailStoreOrder.totalAmount}</Description> 
<Description term="当前状态">{retailStoreOrder.currentStatus}</Description> 
	
        {buildTransferModal(retailStoreOrder,targetComponent)}
      </DescriptionList>
	)

}


class RetailStoreOrderDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'retailStoreOrder'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, retailStoreOrderLineItemListMetaInfo, retailStoreOrderShippingGroupListMetaInfo, retailStoreOrderPaymentGroupListMetaInfo, goodsListMetaInfo, retailStoreOrderLineItemCount, retailStoreOrderShippingGroupCount, retailStoreOrderPaymentGroupCount, goodsCount } = this.props.retailStoreOrder
    if(!this.props.retailStoreOrder.class){
      return null
    }
    const cardsData = {cardsName:"生超的订单",cardsFor: "retailStoreOrder",cardsSource: this.props.retailStoreOrder,
  		subItems: [
{name: 'retailStoreOrderLineItemList', displayName:'双链小超订单行项目',type:'retailStoreOrderLineItem',count:retailStoreOrderLineItemCount,addFunction: true, role: 'retailStoreOrderLineItem', metaInfo: retailStoreOrderLineItemListMetaInfo},
{name: 'retailStoreOrderShippingGroupList', displayName:'生超订单送货分组',type:'retailStoreOrderShippingGroup',count:retailStoreOrderShippingGroupCount,addFunction: true, role: 'retailStoreOrderShippingGroup', metaInfo: retailStoreOrderShippingGroupListMetaInfo},
{name: 'retailStoreOrderPaymentGroupList', displayName:'生超订单付款组',type:'retailStoreOrderPaymentGroup',count:retailStoreOrderPaymentGroupCount,addFunction: true, role: 'retailStoreOrderPaymentGroup', metaInfo: retailStoreOrderPaymentGroupListMetaInfo},
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
  retailStoreOrder: state._retailStoreOrder,
}))(Form.create()(RetailStoreOrderDashboard))

