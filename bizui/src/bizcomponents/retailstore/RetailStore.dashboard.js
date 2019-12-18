

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
import styles from './RetailStore.dashboard.less'
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


const imageList =(retailStore)=>{return [
	 ]}

const internalImageListOf = (retailStore) =>defaultImageListOf(retailStore,imageList)

const optionList =(retailStore)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (retailStore) =>defaultSettingListOf(retailStore, optionList)
const internalLargeTextOf = (retailStore) =>{

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
      <Link to={`/retailStore/${targetComponent.props.retailStore.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/retailStore/${targetComponent.props.retailStore.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (retailStore,targetComponent) =>{
	
	
	const {RetailStoreService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号" style={{wordBreak: 'break-all'}}>{retailStore.id}</Description> 
<Description term="名称" style={{wordBreak: 'break-all'}}>{retailStore.name}</Description> 
<Description term="电话" style={{wordBreak: 'break-all'}}>{retailStore.telephone}</Description> 
<Description term="业主" style={{wordBreak: 'break-all'}}>{retailStore.owner}</Description> 
<Description term="城市服务中心">{retailStore.cityServiceCenter==null?appLocaleName(userContext,"NotAssigned"):`${retailStore.cityServiceCenter.displayName}(${retailStore.cityServiceCenter.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"城市服务中心","retailStoreCityServiceCenter",RetailStoreService.requestCandidateCityServiceCenter,
	      RetailStoreService.transferToAnotherCityServiceCenter,"anotherCityServiceCenterId",retailStore.cityServiceCenter?retailStore.cityServiceCenter.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="成立">{ moment(retailStore.founded).format('YYYY-MM-DD')}</Description> 
<Description term="纬度" style={{wordBreak: 'break-all'}}>{retailStore.latitude}</Description> 
<Description term="经度" style={{wordBreak: 'break-all'}}>{retailStore.longitude}</Description> 
<Description term="描述" style={{wordBreak: 'break-all'}}>{retailStore.description}</Description> 
<Description term="最后更新时间">{ moment(retailStore.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
	
        {buildTransferModal(retailStore,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class RetailStoreDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'retailStore'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, consumerOrderListMetaInfo, retailStoreOrderListMetaInfo, goodsListMetaInfo, transportTaskListMetaInfo, accountSetListMetaInfo, consumerOrderCount, retailStoreOrderCount, goodsCount, transportTaskCount, accountSetCount } = this.props.retailStore
    if(!this.props.retailStore.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"双链小超",cardsFor: "retailStore",
    	cardsSource: this.props.retailStore,returnURL,displayName,
  		subItems: [
{name: 'consumerOrderList', displayName:'消费者订单',viewGroup:'__no_group', type:'consumerOrder',count:consumerOrderCount,addFunction: true, role: 'consumerOrder', metaInfo: consumerOrderListMetaInfo, renderItem: GlobalComponents.ConsumerOrderBase.renderItemOfList},
{name: 'retailStoreOrderList', displayName:'生超的订单',viewGroup:'__no_group', type:'retailStoreOrder',count:retailStoreOrderCount,addFunction: true, role: 'retailStoreOrder', metaInfo: retailStoreOrderListMetaInfo, renderItem: GlobalComponents.RetailStoreOrderBase.renderItemOfList},
{name: 'goodsList', displayName:'货物',viewGroup:'__no_group', type:'goods',count:goodsCount,addFunction: true, role: 'goods', metaInfo: goodsListMetaInfo, renderItem: GlobalComponents.GoodsBase.renderItemOfList},
{name: 'transportTaskList', displayName:'运输任务',viewGroup:'__no_group', type:'transportTask',count:transportTaskCount,addFunction: true, role: 'transportTask', metaInfo: transportTaskListMetaInfo, renderItem: GlobalComponents.TransportTaskBase.renderItemOfList},
{name: 'accountSetList', displayName:'账套',viewGroup:'__no_group', type:'accountSet',count:accountSetCount,addFunction: true, role: 'accountSet', metaInfo: accountSetListMetaInfo, renderItem: GlobalComponents.AccountSetBase.renderItemOfList},
    
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
  retailStore: state._retailStore,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(RetailStoreDashboard))

