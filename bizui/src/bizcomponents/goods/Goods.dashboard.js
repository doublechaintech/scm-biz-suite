

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


const imageList =(goods)=>{return [
	 ]}

const internalImageListOf = (goods) =>defaultImageListOf(goods,imageList)

const optionList =(goods)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (goods) =>defaultSettingListOf(goods, optionList)
const internalLargeTextOf = (goods) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (goods,targetComponent) =>{
	
	
	const {GoodsService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{goods.id}</Description> 
<Description term="Name">{goods.name}</Description> 
<Description term="Rfid">{goods.rfid}</Description> 
<Description term="Uom">{goods.uom}</Description> 
<Description term="Max Package">{goods.maxPackage}</Description> 
<Description term="Expire Time">{ moment(goods.expireTime).format('YYYY-MM-DD')}</Description> 
<Description term="Sku">{goods.sku==null?appLocaleName(userContext,"NotAssigned"):`${goods.sku.displayName}(${goods.sku.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Sku","sku",GoodsService.requestCandidateSku,
	      GoodsService.transferToAnotherSku,"anotherSkuId",goods.sku?goods.sku.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Receiving Space">{goods.receivingSpace==null?appLocaleName(userContext,"NotAssigned"):`${goods.receivingSpace.displayName}(${goods.receivingSpace.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Receiving Space","receivingSpace",GoodsService.requestCandidateReceivingSpace,
	      GoodsService.transferToAnotherReceivingSpace,"anotherReceivingSpaceId",goods.receivingSpace?goods.receivingSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Goods Allocation">{goods.goodsAllocation==null?appLocaleName(userContext,"NotAssigned"):`${goods.goodsAllocation.displayName}(${goods.goodsAllocation.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Goods Allocation","goodsAllocation",GoodsService.requestCandidateGoodsAllocation,
	      GoodsService.transferToAnotherGoodsAllocation,"anotherGoodsAllocationId",goods.goodsAllocation?goods.goodsAllocation.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Smart Pallet">{goods.smartPallet==null?appLocaleName(userContext,"NotAssigned"):`${goods.smartPallet.displayName}(${goods.smartPallet.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Smart Pallet","smartPallet",GoodsService.requestCandidateSmartPallet,
	      GoodsService.transferToAnotherSmartPallet,"anotherSmartPalletId",goods.smartPallet?goods.smartPallet.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Shipping Space">{goods.shippingSpace==null?appLocaleName(userContext,"NotAssigned"):`${goods.shippingSpace.displayName}(${goods.shippingSpace.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Shipping Space","shippingSpace",GoodsService.requestCandidateShippingSpace,
	      GoodsService.transferToAnotherShippingSpace,"anotherShippingSpaceId",goods.shippingSpace?goods.shippingSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Transport Task">{goods.transportTask==null?appLocaleName(userContext,"NotAssigned"):`${goods.transportTask.displayName}(${goods.transportTask.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Transport Task","transportTask",GoodsService.requestCandidateTransportTask,
	      GoodsService.transferToAnotherTransportTask,"anotherTransportTaskId",goods.transportTask?goods.transportTask.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Retail Store">{goods.retailStore==null?appLocaleName(userContext,"NotAssigned"):`${goods.retailStore.displayName}(${goods.retailStore.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Retail Store","retailStore",GoodsService.requestCandidateRetailStore,
	      GoodsService.transferToAnotherRetailStore,"anotherRetailStoreId",goods.retailStore?goods.retailStore.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Biz Order">{goods.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${goods.bizOrder.displayName}(${goods.bizOrder.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Biz Order","supplyOrder",GoodsService.requestCandidateBizOrder,
	      GoodsService.transferToAnotherBizOrder,"anotherBizOrderId",goods.bizOrder?goods.bizOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Retail Store Order">{goods.retailStoreOrder==null?appLocaleName(userContext,"NotAssigned"):`${goods.retailStoreOrder.displayName}(${goods.retailStoreOrder.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Retail Store Order","retailStoreOrder",GoodsService.requestCandidateRetailStoreOrder,
	      GoodsService.transferToAnotherRetailStoreOrder,"anotherRetailStoreOrderId",goods.retailStoreOrder?goods.retailStoreOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Current Status">{goods.currentStatus}</Description> 
	
        {buildTransferModal(goods,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class GoodsDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
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
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Goods",cardsFor: "goods",
    	cardsSource: this.props.goods,returnURL,displayName,
  		subItems: [
{name: 'goodsMovementList', displayName:'Goods Movement',type:'goodsMovement',count:goodsMovementCount,addFunction: true, role: 'goodsMovement', metaInfo: goodsMovementListMetaInfo, renderItem: GlobalComponents.GoodsMovementBase.renderItemOfList},
    
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
  goods: state._goods,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(GoodsDashboard))

