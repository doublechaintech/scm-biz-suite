

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
import styles from './CityEvent.dashboard.less'
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


const imageList =(cityEvent)=>{return [
	 ]}

const internalImageListOf = (cityEvent) =>defaultImageListOf(cityEvent,imageList)

const optionList =(cityEvent)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (cityEvent) =>defaultSettingListOf(cityEvent, optionList)
const internalLargeTextOf = (cityEvent) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (cityEvent,targetComponent) =>{
	
	
	const {CityEventService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{cityEvent.id}</Description> 
<Description term="名称">{cityEvent.name}</Description> 
<Description term="手机">{cityEvent.mobile}</Description> 
<Description term="城市服务中心">{cityEvent.cityServiceCenter==null?"未分配":cityEvent.cityServiceCenter.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"城市服务中心","retailStoreCityServiceCenter",CityEventService.requestCandidateCityServiceCenter,
	      CityEventService.transferToAnotherCityServiceCenter,"anotherCityServiceCenterId",cityEvent.cityServiceCenter?cityEvent.cityServiceCenter.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="描述">{cityEvent.description}</Description> 
	
        {buildTransferModal(cityEvent,targetComponent)}
      </DescriptionList>
	)

}


class CityEventDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'cityEvent'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, eventAttendanceListMetaInfo, eventAttendanceCount } = this.props.cityEvent
    if(!this.props.cityEvent.class){
      return null
    }
    const cardsData = {cardsName:"城市活动",cardsFor: "cityEvent",cardsSource: this.props.cityEvent,
  		subItems: [
{name: 'eventAttendanceList', displayName:'活动的参与情况',type:'eventAttendance',count:eventAttendanceCount,addFunction: true, role: 'eventAttendance', metaInfo: eventAttendanceListMetaInfo},
    
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
  cityEvent: state._cityEvent,
}))(Form.create()(CityEventDashboard))

