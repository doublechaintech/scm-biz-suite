

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
import styles from './PotentialCustomer.dashboard.less'
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


const imageList =(potentialCustomer)=>{return [
	 ]}

const internalImageListOf = (potentialCustomer) =>defaultImageListOf(potentialCustomer,imageList)

const optionList =(potentialCustomer)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (potentialCustomer) =>defaultSettingListOf(potentialCustomer, optionList)
const internalLargeTextOf = (potentialCustomer) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (potentialCustomer,targetComponent) =>{
	
	
	const {PotentialCustomerService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{potentialCustomer.id}</Description> 
<Description term="名称">{potentialCustomer.name}</Description> 
<Description term="手机">{potentialCustomer.mobile}</Description> 
<Description term="城市服务中心">{potentialCustomer.cityServiceCenter==null?"未分配":potentialCustomer.cityServiceCenter.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"城市服务中心","retailStoreCityServiceCenter",PotentialCustomerService.requestCandidateCityServiceCenter,
	      PotentialCustomerService.transferToAnotherCityServiceCenter,"anotherCityServiceCenterId",potentialCustomer.cityServiceCenter?potentialCustomer.cityServiceCenter.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="城市合伙人">{potentialCustomer.cityPartner==null?"未分配":potentialCustomer.cityPartner.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"城市合伙人","cityPartner",PotentialCustomerService.requestCandidateCityPartner,
	      PotentialCustomerService.transferToAnotherCityPartner,"anotherCityPartnerId",potentialCustomer.cityPartner?potentialCustomer.cityPartner.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="描述">{potentialCustomer.description}</Description> 
	
        {buildTransferModal(potentialCustomer,targetComponent)}
      </DescriptionList>
	)

}


class PotentialCustomerDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'potentialCustomer'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, potentialCustomerContactPersonListMetaInfo, potentialCustomerContactListMetaInfo, eventAttendanceListMetaInfo, potentialCustomerContactPersonCount, potentialCustomerContactCount, eventAttendanceCount } = this.props.potentialCustomer
    if(!this.props.potentialCustomer.class){
      return null
    }
    const cardsData = {cardsName:"潜在的客户",cardsFor: "potentialCustomer",cardsSource: this.props.potentialCustomer,
  		subItems: [
{name: 'potentialCustomerContactPersonList', displayName:'潜在客户联络人',type:'potentialCustomerContactPerson',count:potentialCustomerContactPersonCount,addFunction: true, role: 'potentialCustomerContactPerson', metaInfo: potentialCustomerContactPersonListMetaInfo},
{name: 'potentialCustomerContactList', displayName:'潜在客户联系',type:'potentialCustomerContact',count:potentialCustomerContactCount,addFunction: true, role: 'potentialCustomerContact', metaInfo: potentialCustomerContactListMetaInfo},
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
  potentialCustomer: state._potentialCustomer,
}))(Form.create()(PotentialCustomerDashboard))

