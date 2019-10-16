

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
import styles from './RetailStoreOrder.dashboard.less'
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


const imageList =(retailStoreOrder)=>{return [
	 ]}

const internalImageListOf = (retailStoreOrder) =>defaultImageListOf(retailStoreOrder,imageList)

const optionList =(retailStoreOrder)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
<<<<<<< HEAD
=======
const internalRenderSubjectList = defaultRenderSubjectList
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
const internalSettingListOf = (retailStoreOrder) =>defaultSettingListOf(retailStoreOrder, optionList)
const internalLargeTextOf = (retailStoreOrder) =>{

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
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

}


const internalSummaryOf = (retailStoreOrder,targetComponent) =>{
	
	
	const {RetailStoreOrderService} = GlobalComponents
<<<<<<< HEAD
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrder.id}</Description> 
<Description term="买方">{retailStoreOrder.buyer==null?"未分配":retailStoreOrder.buyer.displayName}
=======
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrder.id}</Description> 
<Description term="买方">{retailStoreOrder.buyer==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreOrder.buyer.displayName}(${retailStoreOrder.buyer.id})`}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"买方","retailStore",RetailStoreOrderService.requestCandidateBuyer,
	      RetailStoreOrderService.transferToAnotherBuyer,"anotherBuyerId",retailStoreOrder.buyer?retailStoreOrder.buyer.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="头衔">{retailStoreOrder.title}</Description> 
<Description term="总金额">{retailStoreOrder.totalAmount}</Description> 
<<<<<<< HEAD
<Description term="最后更新时间">{ moment(retailStoreOrder.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
=======
<Description term="最后更新时间">{ moment(retailStoreOrder.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
<Description term="当前状态">{retailStoreOrder.currentStatus}</Description> 
	
        {buildTransferModal(retailStoreOrder,targetComponent)}
      </DescriptionList>
	)

}

<<<<<<< HEAD
=======
const internalQuickFunctions = defaultQuickFunctions
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

class RetailStoreOrderDashboard extends Component {

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
{name: 'retailStoreOrderLineItemList', displayName:'双链小超订单行项目',type:'retailStoreOrderLineItem',count:retailStoreOrderLineItemCount,addFunction: true, role: 'retailStoreOrderLineItem', metaInfo: retailStoreOrderLineItemListMetaInfo},
{name: 'retailStoreOrderShippingGroupList', displayName:'生超订单送货分组',type:'retailStoreOrderShippingGroup',count:retailStoreOrderShippingGroupCount,addFunction: true, role: 'retailStoreOrderShippingGroup', metaInfo: retailStoreOrderShippingGroupListMetaInfo},
{name: 'retailStoreOrderPaymentGroupList', displayName:'生超订单付款组',type:'retailStoreOrderPaymentGroup',count:retailStoreOrderPaymentGroupCount,addFunction: true, role: 'retailStoreOrderPaymentGroup', metaInfo: retailStoreOrderPaymentGroupListMetaInfo},
{name: 'goodsList', displayName:'货物',type:'goods',count:goodsCount,addFunction: true, role: 'goods', metaInfo: goodsListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
=======
{name: 'retailStoreOrderLineItemList', displayName:'双链小超订单行项目',type:'retailStoreOrderLineItem',count:retailStoreOrderLineItemCount,addFunction: true, role: 'retailStoreOrderLineItem', metaInfo: retailStoreOrderLineItemListMetaInfo, renderItem: GlobalComponents.RetailStoreOrderLineItemBase.renderItemOfList},
{name: 'retailStoreOrderShippingGroupList', displayName:'生超订单送货分组',type:'retailStoreOrderShippingGroup',count:retailStoreOrderShippingGroupCount,addFunction: true, role: 'retailStoreOrderShippingGroup', metaInfo: retailStoreOrderShippingGroupListMetaInfo, renderItem: GlobalComponents.RetailStoreOrderShippingGroupBase.renderItemOfList},
{name: 'retailStoreOrderPaymentGroupList', displayName:'生超订单付款组',type:'retailStoreOrderPaymentGroup',count:retailStoreOrderPaymentGroupCount,addFunction: true, role: 'retailStoreOrderPaymentGroup', metaInfo: retailStoreOrderPaymentGroupListMetaInfo, renderItem: GlobalComponents.RetailStoreOrderPaymentGroupBase.renderItemOfList},
{name: 'goodsList', displayName:'货物',type:'goods',count:goodsCount,addFunction: true, role: 'goods', metaInfo: goodsListMetaInfo, renderItem: GlobalComponents.GoodsBase.renderItemOfList},
    
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
  retailStoreOrder: state._retailStoreOrder,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(RetailStoreOrderDashboard))

