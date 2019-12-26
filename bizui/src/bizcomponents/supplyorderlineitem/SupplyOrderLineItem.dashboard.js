

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
import styles from './SupplyOrderLineItem.dashboard.less'
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


const imageList =(supplyOrderLineItem)=>{return [
	 ]}

const internalImageListOf = (supplyOrderLineItem) =>defaultImageListOf(supplyOrderLineItem,imageList)

const optionList =(supplyOrderLineItem)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (supplyOrderLineItem) =>defaultSettingListOf(supplyOrderLineItem, optionList)
const internalLargeTextOf = (supplyOrderLineItem) =>{

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
      <Link to={`/supplyOrderLineItem/${targetComponent.props.supplyOrderLineItem.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/supplyOrderLineItem/${targetComponent.props.supplyOrderLineItem.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (supplyOrderLineItem,targetComponent) =>{
	
	
	const {SupplyOrderLineItemService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<<<<<<< HEAD
<Description term="序号">{supplyOrderLineItem.id}</Description> 
=======
<Description term="序号" style={{wordBreak: 'break-all'}}>{supplyOrderLineItem.id}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
<Description term="订单">{supplyOrderLineItem.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${supplyOrderLineItem.bizOrder.displayName}(${supplyOrderLineItem.bizOrder.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"订单","supplyOrder",SupplyOrderLineItemService.requestCandidateBizOrder,
	      SupplyOrderLineItemService.transferToAnotherBizOrder,"anotherBizOrderId",supplyOrderLineItem.bizOrder?supplyOrderLineItem.bizOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="产品ID" style={{wordBreak: 'break-all'}}>{supplyOrderLineItem.skuId}</Description> 
<Description term="产品名称" style={{wordBreak: 'break-all'}}>{supplyOrderLineItem.skuName}</Description> 
<Description term="金额" style={{wordBreak: 'break-all'}}>{supplyOrderLineItem.amount}</Description> 
<Description term="数量" style={{wordBreak: 'break-all'}}>{supplyOrderLineItem.quantity}</Description> 
<Description term="测量单位" style={{wordBreak: 'break-all'}}>{supplyOrderLineItem.unitOfMeasurement}</Description> 
	
        {buildTransferModal(supplyOrderLineItem,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class SupplyOrderLineItemDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
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
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"供应订单行项目",cardsFor: "supplyOrderLineItem",
    	cardsSource: this.props.supplyOrderLineItem,returnURL,displayName,
  		subItems: [
    
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
  supplyOrderLineItem: state._supplyOrderLineItem,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(SupplyOrderLineItemDashboard))

