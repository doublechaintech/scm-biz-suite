

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
import styles from './TransportTask.dashboard.less'
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


const imageList =(transportTask)=>{return [
	 ]}

const internalImageListOf = (transportTask) =>defaultImageListOf(transportTask,imageList)

const optionList =(transportTask)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (transportTask) =>defaultSettingListOf(transportTask, optionList)
const internalLargeTextOf = (transportTask) =>{

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
      <Link to={`/transportTask/${targetComponent.props.transportTask.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/transportTask/${targetComponent.props.transportTask.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (transportTask,targetComponent) =>{
	
	
	const {TransportTaskService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号" style={{wordBreak: 'break-all'}}>{transportTask.id}</Description> 
<Description term="名称" style={{wordBreak: 'break-all'}}>{transportTask.name}</Description> 
<Description term="开始" style={{wordBreak: 'break-all'}}>{transportTask.start}</Description> 
<Description term="开始时间">{ moment(transportTask.beginTime).format('YYYY-MM-DD')}</Description> 
<Description term="结束">{transportTask.end==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.end.displayName}(${transportTask.end.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"结束","retailStore",TransportTaskService.requestCandidateEnd,
	      TransportTaskService.transferToAnotherEnd,"anotherEndId",transportTask.end?transportTask.end.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="司机">{transportTask.driver==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.driver.displayName}(${transportTask.driver.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"司机","truckDriver",TransportTaskService.requestCandidateDriver,
	      TransportTaskService.transferToAnotherDriver,"anotherDriverId",transportTask.driver?transportTask.driver.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="卡车">{transportTask.truck==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.truck.displayName}(${transportTask.truck.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"卡车","transportTruck",TransportTaskService.requestCandidateTruck,
	      TransportTaskService.transferToAnotherTruck,"anotherTruckId",transportTask.truck?transportTask.truck.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="属于">{transportTask.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.belongsTo.displayName}(${transportTask.belongsTo.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"属于","transportFleet",TransportTaskService.requestCandidateBelongsTo,
	      TransportTaskService.transferToAnotherBelongsTo,"anotherBelongsToId",transportTask.belongsTo?transportTask.belongsTo.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="纬度" style={{wordBreak: 'break-all'}}>{transportTask.latitude}</Description> 
<Description term="经度" style={{wordBreak: 'break-all'}}>{transportTask.longitude}</Description> 
	
        {buildTransferModal(transportTask,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class TransportTaskDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'transportTask'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, goodsListMetaInfo, transportTaskTrackListMetaInfo, goodsCount, transportTaskTrackCount } = this.props.transportTask
    if(!this.props.transportTask.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"运输任务",cardsFor: "transportTask",
    	cardsSource: this.props.transportTask,returnURL,displayName,
  		subItems: [
<<<<<<< HEAD
{name: 'goodsList', displayName:'货物',type:'goods',count:goodsCount,addFunction: true, role: 'goods', metaInfo: goodsListMetaInfo, renderItem: GlobalComponents.GoodsBase.renderItemOfList},
{name: 'transportTaskTrackList', displayName:'运输任务跟踪',type:'transportTaskTrack',count:transportTaskTrackCount,addFunction: true, role: 'transportTaskTrack', metaInfo: transportTaskTrackListMetaInfo, renderItem: GlobalComponents.TransportTaskTrackBase.renderItemOfList},
=======
{name: 'goodsList', displayName:'货物',viewGroup:'__no_group', type:'goods',count:goodsCount,addFunction: true, role: 'goods', metaInfo: goodsListMetaInfo, renderItem: GlobalComponents.GoodsBase.renderItemOfList},
{name: 'transportTaskTrackList', displayName:'运输任务跟踪',viewGroup:'__no_group', type:'transportTaskTrack',count:transportTaskTrackCount,addFunction: true, role: 'transportTaskTrack', metaInfo: transportTaskTrackListMetaInfo, renderItem: GlobalComponents.TransportTaskTrackBase.renderItemOfList},
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
  transportTask: state._transportTask,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(TransportTaskDashboard))

