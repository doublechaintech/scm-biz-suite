

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
import styles from './SupplyOrderLineItem.dashboard.less'
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


const imageList =(supplyOrderLineItem)=>{return [
	 ]}

const internalImageListOf = (supplyOrderLineItem) =>defaultImageListOf(supplyOrderLineItem,imageList)

const optionList =(supplyOrderLineItem)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (supplyOrderLineItem) =>defaultSettingListOf(supplyOrderLineItem, optionList)
const internalLargeTextOf = (supplyOrderLineItem) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (supplyOrderLineItem,targetComponent) =>{
	
	
	const {SupplyOrderLineItemService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{supplyOrderLineItem.id}</Description> 
<Description term="订单">{supplyOrderLineItem.bizOrder==null?"未分配":supplyOrderLineItem.bizOrder.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"订单","supplyOrder",SupplyOrderLineItemService.requestCandidateBizOrder,
	      SupplyOrderLineItemService.transferToAnotherBizOrder,"anotherBizOrderId",supplyOrderLineItem.bizOrder?supplyOrderLineItem.bizOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="产品ID">{supplyOrderLineItem.skuId}</Description> 
<Description term="产品名称">{supplyOrderLineItem.skuName}</Description> 
<Description term="金额">{supplyOrderLineItem.amount}</Description> 
<Description term="数量">{supplyOrderLineItem.quantity}</Description> 
<Description term="测量单位">{supplyOrderLineItem.unitOfMeasurement}</Description> 
	
        {buildTransferModal(supplyOrderLineItem,targetComponent)}
      </DescriptionList>
	)

}


class SupplyOrderLineItemDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'supplyOrderLineItem'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.supplyOrderLineItem
    if(!this.props.supplyOrderLineItem.class){
      return null
    }
    const cardsData = {cardsName:"供应订单行项目",cardsFor: "supplyOrderLineItem",cardsSource: this.props.supplyOrderLineItem,
  		subItems: [
    
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
  supplyOrderLineItem: state._supplyOrderLineItem,
}))(Form.create()(SupplyOrderLineItemDashboard))

