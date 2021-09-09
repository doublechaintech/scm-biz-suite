

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import BaseTool from '../../common/Base.tool'
import { Tag, Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {TagCloud} from '../../components/Charts'
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

const {defaultFormatNumber} = BaseTool

const formatNumber = defaultFormatNumber

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
      <Link to={`/consumerOrder/${targetComponent.props.consumerOrder.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/consumerOrder/${targetComponent.props.consumerOrder.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{


  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (cardsData,targetComponent) =>{

	 const quickFunctions = targetComponent.props.quickFunctions || internalQuickFunctions
	const consumerOrder = cardsData.cardsSource
	const {ConsumerOrderService} = GlobalComponents
	const userContext = null
	return (
	<div>
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID" style={{wordBreak: 'break-all'}}>{consumerOrder.id}</Description> 
<Description term="头衔" style={{wordBreak: 'break-all'}}>{consumerOrder.title}</Description> 
<Description term="消费者">{consumerOrder.consumer==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.consumer.displayName}(${consumerOrder.consumer.id})`}
</Description>
<Description term="商场">{consumerOrder.store==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.store.displayName}(${consumerOrder.store.id})`}
</Description>
<Description term="更新于">{ moment(consumerOrder.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 

       
      </DescriptionList>
      <div>{quickFunctions(cardsData)}</div>
      </div>
	)

}


const renderTagCloud=(cardsData)=>{


  if(cardsData.subItems.length<10){
    return null
  }

  const tagValue = cardsData.subItems.map(item=>({name:item.displayName, value: item.count}))

  return <div >
      <div style={{verticalAlign:"middle",textAlign:"center",backgroundColor:"rgba(0, 0, 0, 0.65)",color:"white",fontWeight:"bold",height:"40px"}}>
       <span style={{display:"inline-block",marginTop:"10px"}}>{`${cardsData.displayName}画像`}</span>
      </div>
      <TagCloud data={tagValue} height={200} style={{backgroundColor:"white"}}/>
    </div>


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

    const cardsData = {cardsName:window.trans('consumer_order'),cardsFor: "consumerOrder",
    	cardsSource: this.props.consumerOrder,returnURL,displayName,
  		subItems: [
{name: 'consumerOrderLineItemList', displayName: window.mtrans('consumer_order_line_item','consumer_order.consumer_order_line_item_list',false) ,viewGroup:'__no_group', type:'consumerOrderLineItem',count:consumerOrderLineItemCount,addFunction: true, role: 'consumerOrderLineItem', metaInfo: consumerOrderLineItemListMetaInfo, renderItem: GlobalComponents.ConsumerOrderLineItemBase.renderItemOfList},
{name: 'consumerOrderShippingGroupList', displayName: window.mtrans('consumer_order_shipping_group','consumer_order.consumer_order_shipping_group_list',false) ,viewGroup:'__no_group', type:'consumerOrderShippingGroup',count:consumerOrderShippingGroupCount,addFunction: true, role: 'consumerOrderShippingGroup', metaInfo: consumerOrderShippingGroupListMetaInfo, renderItem: GlobalComponents.ConsumerOrderShippingGroupBase.renderItemOfList},
{name: 'consumerOrderPaymentGroupList', displayName: window.mtrans('consumer_order_payment_group','consumer_order.consumer_order_payment_group_list',false) ,viewGroup:'__no_group', type:'consumerOrderPaymentGroup',count:consumerOrderPaymentGroupCount,addFunction: true, role: 'consumerOrderPaymentGroup', metaInfo: consumerOrderPaymentGroupListMetaInfo, renderItem: GlobalComponents.ConsumerOrderPaymentGroupBase.renderItemOfList},
{name: 'consumerOrderPriceAdjustmentList', displayName: window.mtrans('consumer_order_price_adjustment','consumer_order.consumer_order_price_adjustment_list',false) ,viewGroup:'__no_group', type:'consumerOrderPriceAdjustment',count:consumerOrderPriceAdjustmentCount,addFunction: true, role: 'consumerOrderPriceAdjustment', metaInfo: consumerOrderPriceAdjustmentListMetaInfo, renderItem: GlobalComponents.ConsumerOrderPriceAdjustmentBase.renderItemOfList},
{name: 'retailStoreMemberGiftCardConsumeRecordList', displayName: window.mtrans('retail_store_member_gift_card_consume_record','consumer_order.retail_store_member_gift_card_consume_record_list',false) ,viewGroup:'__no_group', type:'retailStoreMemberGiftCardConsumeRecord',count:retailStoreMemberGiftCardConsumeRecordCount,addFunction: true, role: 'retailStoreMemberGiftCardConsumeRecord', metaInfo: retailStoreMemberGiftCardConsumeRecordListMetaInfo, renderItem: GlobalComponents.RetailStoreMemberGiftCardConsumeRecordBase.renderItemOfList},

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
    // {quickFunctions(cardsData)}
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        wrapperClassName={styles.advancedForm}
      >


       
     <Col span={24} style={{marginRight:"20px", backgroundColor: "white"}}>
      {renderTagCloud(cardsData)}

      {imageListOf(cardsData.cardsSource)}
      {renderAnalytics(cardsData.cardsSource)}
      {settingListOf(cardsData.cardsSource)}

	   </Col>

		 
      </PageHeaderLayout>

    )
  }
}

export default connect(state => ({
  consumerOrder: state._consumerOrder,
  returnURL: state.breadcrumb.returnURL,

}))(Form.create()(ConsumerOrderDashboard))

