

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
import styles from './RetailStoreOrder.dashboard.less'
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


const imageList =(retailStoreOrder)=>{return [
	 ]}

const internalImageListOf = (retailStoreOrder) =>defaultImageListOf(retailStoreOrder,imageList)

const optionList =(retailStoreOrder)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (retailStoreOrder) =>defaultSettingListOf(retailStoreOrder, optionList)
const internalLargeTextOf = (retailStoreOrder) =>{

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
      <Link to={`/retailStoreOrder/${targetComponent.props.retailStoreOrder.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/retailStoreOrder/${targetComponent.props.retailStoreOrder.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (retailStoreOrder,targetComponent) =>{
	
	
	const {RetailStoreOrderService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<<<<<<< HEAD
<Description term="序号">{retailStoreOrder.id}</Description> 
=======
<Description term="序号" style={{wordBreak: 'break-all'}}>{retailStoreOrder.id}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
<Description term="买方">{retailStoreOrder.buyer==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreOrder.buyer.displayName}(${retailStoreOrder.buyer.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"买方","retailStore",RetailStoreOrderService.requestCandidateBuyer,
	      RetailStoreOrderService.transferToAnotherBuyer,"anotherBuyerId",retailStoreOrder.buyer?retailStoreOrder.buyer.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<<<<<<< HEAD
<Description term="头衔">{retailStoreOrder.title}</Description> 
<Description term="总金额">{retailStoreOrder.totalAmount}</Description> 
<Description term="最后更新时间">{ moment(retailStoreOrder.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
<Description term="当前状态">{retailStoreOrder.currentStatus}</Description> 
=======
<Description term="头衔" style={{wordBreak: 'break-all'}}>{retailStoreOrder.title}</Description> 
<Description term="总金额" style={{wordBreak: 'break-all'}}>{retailStoreOrder.totalAmount}</Description> 
<Description term="最后更新时间">{ moment(retailStoreOrder.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
	
        {buildTransferModal(retailStoreOrder,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class RetailStoreOrderDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
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
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"生超的订单",cardsFor: "retailStoreOrder",
    	cardsSource: this.props.retailStoreOrder,returnURL,displayName,
  		subItems: [
<<<<<<< HEAD
{name: 'retailStoreOrderLineItemList', displayName:'双链小超订单行项目',type:'retailStoreOrderLineItem',count:retailStoreOrderLineItemCount,addFunction: true, role: 'retailStoreOrderLineItem', metaInfo: retailStoreOrderLineItemListMetaInfo, renderItem: GlobalComponents.RetailStoreOrderLineItemBase.renderItemOfList},
{name: 'retailStoreOrderShippingGroupList', displayName:'生超订单送货分组',type:'retailStoreOrderShippingGroup',count:retailStoreOrderShippingGroupCount,addFunction: true, role: 'retailStoreOrderShippingGroup', metaInfo: retailStoreOrderShippingGroupListMetaInfo, renderItem: GlobalComponents.RetailStoreOrderShippingGroupBase.renderItemOfList},
{name: 'retailStoreOrderPaymentGroupList', displayName:'生超订单付款组',type:'retailStoreOrderPaymentGroup',count:retailStoreOrderPaymentGroupCount,addFunction: true, role: 'retailStoreOrderPaymentGroup', metaInfo: retailStoreOrderPaymentGroupListMetaInfo, renderItem: GlobalComponents.RetailStoreOrderPaymentGroupBase.renderItemOfList},
{name: 'goodsList', displayName:'货物',type:'goods',count:goodsCount,addFunction: true, role: 'goods', metaInfo: goodsListMetaInfo, renderItem: GlobalComponents.GoodsBase.renderItemOfList},
=======
{name: 'retailStoreOrderLineItemList', displayName:'双链小超订单行项目',viewGroup:'__no_group', type:'retailStoreOrderLineItem',count:retailStoreOrderLineItemCount,addFunction: true, role: 'retailStoreOrderLineItem', metaInfo: retailStoreOrderLineItemListMetaInfo, renderItem: GlobalComponents.RetailStoreOrderLineItemBase.renderItemOfList},
{name: 'retailStoreOrderShippingGroupList', displayName:'生超订单送货分组',viewGroup:'__no_group', type:'retailStoreOrderShippingGroup',count:retailStoreOrderShippingGroupCount,addFunction: true, role: 'retailStoreOrderShippingGroup', metaInfo: retailStoreOrderShippingGroupListMetaInfo, renderItem: GlobalComponents.RetailStoreOrderShippingGroupBase.renderItemOfList},
{name: 'retailStoreOrderPaymentGroupList', displayName:'生超订单付款组',viewGroup:'__no_group', type:'retailStoreOrderPaymentGroup',count:retailStoreOrderPaymentGroupCount,addFunction: true, role: 'retailStoreOrderPaymentGroup', metaInfo: retailStoreOrderPaymentGroupListMetaInfo, renderItem: GlobalComponents.RetailStoreOrderPaymentGroupBase.renderItemOfList},
{name: 'goodsList', displayName:'货物',viewGroup:'__no_group', type:'goods',count:goodsCount,addFunction: true, role: 'goods', metaInfo: goodsListMetaInfo, renderItem: GlobalComponents.GoodsBase.renderItemOfList},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
    
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
  retailStoreOrder: state._retailStoreOrder,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(RetailStoreOrderDashboard))

