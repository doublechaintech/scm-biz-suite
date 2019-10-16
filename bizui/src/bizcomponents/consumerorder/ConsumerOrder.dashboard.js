

import React, { Component } from 'react'
<<<<<<< HEAD
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
=======
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD

=======
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
<<<<<<< HEAD
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
=======
  defaultSubListsOf,defaultRenderAnalytics,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,
  defaultQuickFunctions, defaultRenderSubjectList,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
=======
const internalRenderSubjectList = defaultRenderSubjectList
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
const internalSettingListOf = (consumerOrder) =>defaultSettingListOf(consumerOrder, optionList)
const internalLargeTextOf = (consumerOrder) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


<<<<<<< HEAD
const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)
=======
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
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

}


const internalSummaryOf = (consumerOrder,targetComponent) =>{
	
	
	const {ConsumerOrderService} = GlobalComponents
<<<<<<< HEAD
	
=======
	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{consumerOrder.id}</Description> 
<Description term="头衔">{consumerOrder.title}</Description> 
<<<<<<< HEAD
<Description term="消费者">{consumerOrder.consumer==null?"未分配":consumerOrder.consumer.displayName}
=======
<Description term="消费者">{consumerOrder.consumer==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.consumer.displayName}(${consumerOrder.consumer.id})`}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"消费者","retailStoreMember",ConsumerOrderService.requestCandidateConsumer,
	      ConsumerOrderService.transferToAnotherConsumer,"anotherConsumerId",consumerOrder.consumer?consumerOrder.consumer.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<<<<<<< HEAD
<Description term="商场">{consumerOrder.store==null?"未分配":consumerOrder.store.displayName}
=======
<Description term="商场">{consumerOrder.store==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.store.displayName}(${consumerOrder.store.id})`}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"商场","retailStore",ConsumerOrderService.requestCandidateStore,
	      ConsumerOrderService.transferToAnotherStore,"anotherStoreId",consumerOrder.store?consumerOrder.store.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<<<<<<< HEAD
<Description term="最后更新时间">{ moment(consumerOrder.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
=======
<Description term="最后更新时间">{ moment(consumerOrder.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
<Description term="当前状态">{consumerOrder.currentStatus}</Description> 
	
        {buildTransferModal(consumerOrder,targetComponent)}
      </DescriptionList>
	)

}

<<<<<<< HEAD
=======
const internalQuickFunctions = defaultQuickFunctions
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

class ConsumerOrderDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
<<<<<<< HEAD
    targetLocalName:"城市",
=======
    targetLocalName:"",
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
{name: 'consumerOrderLineItemList', displayName:'消费者订单行项目',type:'consumerOrderLineItem',count:consumerOrderLineItemCount,addFunction: true, role: 'consumerOrderLineItem', metaInfo: consumerOrderLineItemListMetaInfo},
{name: 'consumerOrderShippingGroupList', displayName:'消费订单送货分组',type:'consumerOrderShippingGroup',count:consumerOrderShippingGroupCount,addFunction: true, role: 'consumerOrderShippingGroup', metaInfo: consumerOrderShippingGroupListMetaInfo},
{name: 'consumerOrderPaymentGroupList', displayName:'消费者订单付款组',type:'consumerOrderPaymentGroup',count:consumerOrderPaymentGroupCount,addFunction: true, role: 'consumerOrderPaymentGroup', metaInfo: consumerOrderPaymentGroupListMetaInfo},
{name: 'consumerOrderPriceAdjustmentList', displayName:'消费品价格调整',type:'consumerOrderPriceAdjustment',count:consumerOrderPriceAdjustmentCount,addFunction: true, role: 'consumerOrderPriceAdjustment', metaInfo: consumerOrderPriceAdjustmentListMetaInfo},
{name: 'retailStoreMemberGiftCardConsumeRecordList', displayName:'零售商店会员卡消费记录',type:'retailStoreMemberGiftCardConsumeRecord',count:retailStoreMemberGiftCardConsumeRecordCount,addFunction: true, role: 'retailStoreMemberGiftCardConsumeRecord', metaInfo: retailStoreMemberGiftCardConsumeRecordListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
=======
{name: 'consumerOrderLineItemList', displayName:'消费者订单行项目',type:'consumerOrderLineItem',count:consumerOrderLineItemCount,addFunction: true, role: 'consumerOrderLineItem', metaInfo: consumerOrderLineItemListMetaInfo, renderItem: GlobalComponents.ConsumerOrderLineItemBase.renderItemOfList},
{name: 'consumerOrderShippingGroupList', displayName:'消费订单送货分组',type:'consumerOrderShippingGroup',count:consumerOrderShippingGroupCount,addFunction: true, role: 'consumerOrderShippingGroup', metaInfo: consumerOrderShippingGroupListMetaInfo, renderItem: GlobalComponents.ConsumerOrderShippingGroupBase.renderItemOfList},
{name: 'consumerOrderPaymentGroupList', displayName:'消费者订单付款组',type:'consumerOrderPaymentGroup',count:consumerOrderPaymentGroupCount,addFunction: true, role: 'consumerOrderPaymentGroup', metaInfo: consumerOrderPaymentGroupListMetaInfo, renderItem: GlobalComponents.ConsumerOrderPaymentGroupBase.renderItemOfList},
{name: 'consumerOrderPriceAdjustmentList', displayName:'消费品价格调整',type:'consumerOrderPriceAdjustment',count:consumerOrderPriceAdjustmentCount,addFunction: true, role: 'consumerOrderPriceAdjustment', metaInfo: consumerOrderPriceAdjustmentListMetaInfo, renderItem: GlobalComponents.ConsumerOrderPriceAdjustmentBase.renderItemOfList},
{name: 'retailStoreMemberGiftCardConsumeRecordList', displayName:'零售商店会员卡消费记录',type:'retailStoreMemberGiftCardConsumeRecord',count:retailStoreMemberGiftCardConsumeRecordCount,addFunction: true, role: 'retailStoreMemberGiftCardConsumeRecord', metaInfo: retailStoreMemberGiftCardConsumeRecordListMetaInfo, renderItem: GlobalComponents.RetailStoreMemberGiftCardConsumeRecordBase.renderItemOfList},
    
      	],
   		subSettingItems: [
    
      	],     	
      	
  	};
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
<<<<<<< HEAD
=======
    const renderAnalytics = this.props.renderAnalytics || defaultRenderAnalytics
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
<<<<<<< HEAD
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
=======
       
        {renderExtraHeader(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}  
        {quickFunctions(cardsData)} 
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    )
  }
}

export default connect(state => ({
  consumerOrder: state._consumerOrder,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(ConsumerOrderDashboard))

