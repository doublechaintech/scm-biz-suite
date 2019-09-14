

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
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
import styles from './ConsumerOrderPriceAdjustment.dashboard.less'
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


const imageList =(consumerOrderPriceAdjustment)=>{return [
	 ]}

const internalImageListOf = (consumerOrderPriceAdjustment) =>defaultImageListOf(consumerOrderPriceAdjustment,imageList)

const optionList =(consumerOrderPriceAdjustment)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (consumerOrderPriceAdjustment) =>defaultSettingListOf(consumerOrderPriceAdjustment, optionList)
const internalLargeTextOf = (consumerOrderPriceAdjustment) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const renderSettingDropDown = (cardsData,targetComponent)=>{

  return (<Dropdown overlay={renderSettingMenu(cardsData,targetComponent)} placement="bottomRight">
        <Icon
          type="setting"
        />
      </Dropdown>)


}

const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/consumerOrderPriceAdjustment/${targetComponent.props.consumerOrderPriceAdjustment.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Item key="permission">
  			<Link to={`/consumerOrderPriceAdjustment/${targetComponent.props.consumerOrderPriceAdjustment.id}/profile`}><Icon type="cluster"  twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Profile")}</span></Link>
			</Menu.Item>
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (consumerOrderPriceAdjustment,targetComponent) =>{
	
	
	const {ConsumerOrderPriceAdjustmentService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{consumerOrderPriceAdjustment.id}</Description> 
<Description term="名称">{consumerOrderPriceAdjustment.name}</Description> 
<Description term="订单">{consumerOrderPriceAdjustment.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrderPriceAdjustment.bizOrder.displayName}(${consumerOrderPriceAdjustment.bizOrder.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"订单","consumerOrder",ConsumerOrderPriceAdjustmentService.requestCandidateBizOrder,
	      ConsumerOrderPriceAdjustmentService.transferToAnotherBizOrder,"anotherBizOrderId",consumerOrderPriceAdjustment.bizOrder?consumerOrderPriceAdjustment.bizOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="金额">{consumerOrderPriceAdjustment.amount}</Description> 
<Description term="供应商">{consumerOrderPriceAdjustment.provider}</Description> 
	
        {buildTransferModal(consumerOrderPriceAdjustment,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class ConsumerOrderPriceAdjustmentDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'consumerOrderPriceAdjustment'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.consumerOrderPriceAdjustment
    if(!this.props.consumerOrderPriceAdjustment.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"消费品价格调整",cardsFor: "consumerOrderPriceAdjustment",
    	cardsSource: this.props.consumerOrderPriceAdjustment,returnURL,displayName,
  		subItems: [
    
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
  consumerOrderPriceAdjustment: state._consumerOrderPriceAdjustment,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(ConsumerOrderPriceAdjustmentDashboard))

