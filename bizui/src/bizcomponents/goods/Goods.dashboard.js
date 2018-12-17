

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
import styles from './Goods.dashboard.less'
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


const imageList =(goods)=>{return [
	 ]}

const internalImageListOf = (goods) =>defaultImageListOf(goods,imageList)

const optionList =(goods)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (goods) =>defaultSettingListOf(goods, optionList)
const internalLargeTextOf = (goods) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (goods,targetComponent) =>{
	
	
	const {GoodsService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{goods.id}</Description> 
<Description term="名称">{goods.name}</Description> 
<Description term="RFID">{goods.rfid}</Description> 
<Description term="计量单位">{goods.uom}</Description> 
<Description term="最大包装">{goods.maxPackage}</Description> 
<Description term="到期时间">{ moment(goods.expireTime).format('YYYY-MM-DD')}</Description> 
<Description term="SKU">{goods.sku==null?"未分配":goods.sku.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"SKU","sku",GoodsService.requestCandidateSku,
	      GoodsService.transferToAnotherSku,"anotherSkuId",goods.sku?goods.sku.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="收货区">{goods.receivingSpace==null?"未分配":goods.receivingSpace.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"收货区","receivingSpace",GoodsService.requestCandidateReceivingSpace,
	      GoodsService.transferToAnotherReceivingSpace,"anotherReceivingSpaceId",goods.receivingSpace?goods.receivingSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="货位">{goods.goodsAllocation==null?"未分配":goods.goodsAllocation.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"货位","goodsAllocation",GoodsService.requestCandidateGoodsAllocation,
	      GoodsService.transferToAnotherGoodsAllocation,"anotherGoodsAllocationId",goods.goodsAllocation?goods.goodsAllocation.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="智能托盘">{goods.smartPallet==null?"未分配":goods.smartPallet.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"智能托盘","smartPallet",GoodsService.requestCandidateSmartPallet,
	      GoodsService.transferToAnotherSmartPallet,"anotherSmartPalletId",goods.smartPallet?goods.smartPallet.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="发货区">{goods.shippingSpace==null?"未分配":goods.shippingSpace.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"发货区","shippingSpace",GoodsService.requestCandidateShippingSpace,
	      GoodsService.transferToAnotherShippingSpace,"anotherShippingSpaceId",goods.shippingSpace?goods.shippingSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="运输任务">{goods.transportTask==null?"未分配":goods.transportTask.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"运输任务","transportTask",GoodsService.requestCandidateTransportTask,
	      GoodsService.transferToAnotherTransportTask,"anotherTransportTaskId",goods.transportTask?goods.transportTask.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="双链小超">{goods.retailStore==null?"未分配":goods.retailStore.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"双链小超","retailStore",GoodsService.requestCandidateRetailStore,
	      GoodsService.transferToAnotherRetailStore,"anotherRetailStoreId",goods.retailStore?goods.retailStore.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="订单">{goods.bizOrder==null?"未分配":goods.bizOrder.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"订单","supplyOrder",GoodsService.requestCandidateBizOrder,
	      GoodsService.transferToAnotherBizOrder,"anotherBizOrderId",goods.bizOrder?goods.bizOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="生超的订单">{goods.retailStoreOrder==null?"未分配":goods.retailStoreOrder.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"生超的订单","retailStoreOrder",GoodsService.requestCandidateRetailStoreOrder,
	      GoodsService.transferToAnotherRetailStoreOrder,"anotherRetailStoreOrderId",goods.retailStoreOrder?goods.retailStoreOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="当前状态">{goods.currentStatus}</Description> 
	
        {buildTransferModal(goods,targetComponent)}
      </DescriptionList>
	)

}


class GoodsDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'goods'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, goodsMovementListMetaInfo, goodsMovementCount } = this.props.goods
    if(!this.props.goods.class){
      return null
    }
    const cardsData = {cardsName:"货物",cardsFor: "goods",cardsSource: this.props.goods,
  		subItems: [
{name: 'goodsMovementList', displayName:'货物移动',type:'goodsMovement',count:goodsMovementCount,addFunction: true, role: 'goodsMovement', metaInfo: goodsMovementListMetaInfo},
    
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
  goods: state._goods,
}))(Form.create()(GoodsDashboard))

