

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
import styles from './TransportTruck.dashboard.less'
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


const imageList =(transportTruck)=>{return [
	 ]}

const internalImageListOf = (transportTruck) =>defaultImageListOf(transportTruck,imageList)

const optionList =(transportTruck)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (transportTruck) =>defaultSettingListOf(transportTruck, optionList)
const internalLargeTextOf = (transportTruck) =>{

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
      <Link to={`/transportTruck/${targetComponent.props.transportTruck.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/transportTruck/${targetComponent.props.transportTruck.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (transportTruck,targetComponent) =>{
	
	
	const {TransportTruckService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号" style={{wordBreak: 'break-all'}}>{transportTruck.id}</Description> 
<Description term="名称" style={{wordBreak: 'break-all'}}>{transportTruck.name}</Description> 
<Description term="车牌号码" style={{wordBreak: 'break-all'}}>{transportTruck.plateNumber}</Description> 
<Description term="联系电话" style={{wordBreak: 'break-all'}}>{transportTruck.contactNumber}</Description> 
<Description term="汽车牌照号码" style={{wordBreak: 'break-all'}}>{transportTruck.vehicleLicenseNumber}</Description> 
<Description term="发动机号" style={{wordBreak: 'break-all'}}>{transportTruck.engineNumber}</Description> 
<Description term="制造日期">{ moment(transportTruck.makeDate).format('YYYY-MM-DD')}</Description> 
<<<<<<< HEAD
<Description term="里程">{transportTruck.mileage}</Description> 
<Description term="车身颜色">{transportTruck.bodyColor}</Description> 
=======
<Description term="里程" style={{wordBreak: 'break-all'}}>{transportTruck.mileage}</Description> 
<Description term="车身颜色" style={{wordBreak: 'break-all'}}>{transportTruck.bodyColor}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
<Description term="业主">{transportTruck.owner==null?appLocaleName(userContext,"NotAssigned"):`${transportTruck.owner.displayName}(${transportTruck.owner.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"业主","transportFleet",TransportTruckService.requestCandidateOwner,
	      TransportTruckService.transferToAnotherOwner,"anotherOwnerId",transportTruck.owner?transportTruck.owner.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(transportTruck,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class TransportTruckDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'transportTruck'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, transportTaskListMetaInfo, transportTaskCount } = this.props.transportTruck
    if(!this.props.transportTruck.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"运输车",cardsFor: "transportTruck",
    	cardsSource: this.props.transportTruck,returnURL,displayName,
  		subItems: [
<<<<<<< HEAD
{name: 'transportTaskList', displayName:'运输任务',type:'transportTask',count:transportTaskCount,addFunction: true, role: 'transportTask', metaInfo: transportTaskListMetaInfo, renderItem: GlobalComponents.TransportTaskBase.renderItemOfList},
=======
{name: 'transportTaskList', displayName:'运输任务',viewGroup:'__no_group', type:'transportTask',count:transportTaskCount,addFunction: true, role: 'transportTask', metaInfo: transportTaskListMetaInfo, renderItem: GlobalComponents.TransportTaskBase.renderItemOfList},
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
  transportTruck: state._transportTruck,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(TransportTruckDashboard))

