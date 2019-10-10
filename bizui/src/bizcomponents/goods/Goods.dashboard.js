

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
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


const renderSettingDropDown = (cardsData,targetComponent)=>{

  return (<div style={{float: 'right'}} >
        <Dropdown overlay={renderSettingMenu(cardsData,targetComponent)} placement="bottomRight" >
       
        <Button>
        <Icon type="setting" theme="filled" twoToneColor="#00b" style={{color:'#3333b0'}}/> 设置  <Icon type="down"/>
      </Button>
      </Dropdown></div>)

}

const renderSettingMenuItem = (item,cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu.Item key={item.name}>
      <Link to={`/goods/${targetComponent.props.goods.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/goods/${targetComponent.props.goods.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (goods,targetComponent) =>{
	
	
	const {GoodsService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{goods.id}</Description> 
<Description term="名称">{goods.name}</Description> 
<Description term="RFID">{goods.rfid}</Description> 
<Description term="计量单位">{goods.uom}</Description> 
<Description term="最大包装">{goods.maxPackage}</Description> 
<Description term="到期时间">{ moment(goods.expireTime).format('YYYY-MM-DD')}</Description> 
<Description term="SKU">{goods.sku==null?appLocaleName(userContext,"NotAssigned"):`${goods.sku.displayName}(${goods.sku.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"SKU","sku",GoodsService.requestCandidateSku,
	      GoodsService.transferToAnotherSku,"anotherSkuId",goods.sku?goods.sku.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="收货区">{goods.receivingSpace==null?appLocaleName(userContext,"NotAssigned"):`${goods.receivingSpace.displayName}(${goods.receivingSpace.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"收货区","receivingSpace",GoodsService.requestCandidateReceivingSpace,
	      GoodsService.transferToAnotherReceivingSpace,"anotherReceivingSpaceId",goods.receivingSpace?goods.receivingSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="货位">{goods.goodsAllocation==null?appLocaleName(userContext,"NotAssigned"):`${goods.goodsAllocation.displayName}(${goods.goodsAllocation.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"货位","goodsAllocation",GoodsService.requestCandidateGoodsAllocation,
	      GoodsService.transferToAnotherGoodsAllocation,"anotherGoodsAllocationId",goods.goodsAllocation?goods.goodsAllocation.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="智能托盘">{goods.smartPallet==null?appLocaleName(userContext,"NotAssigned"):`${goods.smartPallet.displayName}(${goods.smartPallet.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"智能托盘","smartPallet",GoodsService.requestCandidateSmartPallet,
	      GoodsService.transferToAnotherSmartPallet,"anotherSmartPalletId",goods.smartPallet?goods.smartPallet.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="发货区">{goods.shippingSpace==null?appLocaleName(userContext,"NotAssigned"):`${goods.shippingSpace.displayName}(${goods.shippingSpace.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"发货区","shippingSpace",GoodsService.requestCandidateShippingSpace,
	      GoodsService.transferToAnotherShippingSpace,"anotherShippingSpaceId",goods.shippingSpace?goods.shippingSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="运输任务">{goods.transportTask==null?appLocaleName(userContext,"NotAssigned"):`${goods.transportTask.displayName}(${goods.transportTask.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"运输任务","transportTask",GoodsService.requestCandidateTransportTask,
	      GoodsService.transferToAnotherTransportTask,"anotherTransportTaskId",goods.transportTask?goods.transportTask.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="双链小超">{goods.retailStore==null?appLocaleName(userContext,"NotAssigned"):`${goods.retailStore.displayName}(${goods.retailStore.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"双链小超","retailStore",GoodsService.requestCandidateRetailStore,
	      GoodsService.transferToAnotherRetailStore,"anotherRetailStoreId",goods.retailStore?goods.retailStore.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="订单">{goods.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${goods.bizOrder.displayName}(${goods.bizOrder.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"订单","supplyOrder",GoodsService.requestCandidateBizOrder,
	      GoodsService.transferToAnotherBizOrder,"anotherBizOrderId",goods.bizOrder?goods.bizOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="生超的订单">{goods.retailStoreOrder==null?appLocaleName(userContext,"NotAssigned"):`${goods.retailStoreOrder.displayName}(${goods.retailStoreOrder.id})`}
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
    
    const cardsData = {cardsName:"货物",cardsFor: "goods",
    	cardsSource: this.props.goods,returnURL,displayName,
  		subItems: [
{name: 'goodsMovementList', displayName:'货物移动',type:'goodsMovement',count:goodsMovementCount,addFunction: true, role: 'goodsMovement', metaInfo: goodsMovementListMetaInfo, renderItem: GlobalComponents.GoodsMovementBase.renderItemOfList},
    
      	],
   		subSettingItems: [
    
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
        {imageListOf(cardsData.cardsSource)}  
        {quickFunctions(cardsData)} 
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
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

