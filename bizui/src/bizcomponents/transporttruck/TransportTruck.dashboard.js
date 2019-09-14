

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
  			<Link to={`/transportTruck/${targetComponent.props.transportTruck.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Item key="permission">
  			<Link to={`/transportTruck/${targetComponent.props.transportTruck.id}/profile`}><Icon type="cluster"  twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Profile")}</span></Link>
			</Menu.Item>
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (transportTruck,targetComponent) =>{
	
	
	const {TransportTruckService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{transportTruck.id}</Description> 
<Description term="名称">{transportTruck.name}</Description> 
<Description term="车牌号码">{transportTruck.plateNumber}</Description> 
<Description term="联系电话">{transportTruck.contactNumber}</Description> 
<Description term="汽车牌照号码">{transportTruck.vehicleLicenseNumber}</Description> 
<Description term="发动机号">{transportTruck.engineNumber}</Description> 
<Description term="制造日期">{ moment(transportTruck.makeDate).format('YYYY-MM-DD')}</Description> 
<Description term="里程">{transportTruck.mileage}</Description> 
<Description term="车身颜色">{transportTruck.bodyColor}</Description> 
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
{name: 'transportTaskList', displayName:'运输任务',type:'transportTask',count:transportTaskCount,addFunction: true, role: 'transportTask', metaInfo: transportTaskListMetaInfo, renderItem: GlobalComponents.TransportTaskBase.renderItemOfList},
    
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

