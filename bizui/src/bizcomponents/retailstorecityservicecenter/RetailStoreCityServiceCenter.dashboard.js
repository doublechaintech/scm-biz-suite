

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
import styles from './RetailStoreCityServiceCenter.dashboard.less'
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


const imageList =(retailStoreCityServiceCenter)=>{return [
	 ]}

const internalImageListOf = (retailStoreCityServiceCenter) =>defaultImageListOf(retailStoreCityServiceCenter,imageList)

const optionList =(retailStoreCityServiceCenter)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (retailStoreCityServiceCenter) =>defaultSettingListOf(retailStoreCityServiceCenter, optionList)
const internalLargeTextOf = (retailStoreCityServiceCenter) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (retailStoreCityServiceCenter,targetComponent) =>{
	
	
	const {RetailStoreCityServiceCenterService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreCityServiceCenter.id}</Description> 
<Description term="名称">{retailStoreCityServiceCenter.name}</Description> 
<Description term="成立">{ moment(retailStoreCityServiceCenter.founded).format('YYYY-MM-DD')}</Description> 
<Description term="属于">{retailStoreCityServiceCenter.belongsTo==null?"未分配":retailStoreCityServiceCenter.belongsTo.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"属于","retailStoreProvinceCenter",RetailStoreCityServiceCenterService.requestCandidateBelongsTo,
	      RetailStoreCityServiceCenterService.transferToAnotherBelongsTo,"anotherBelongsToId",retailStoreCityServiceCenter.belongsTo?retailStoreCityServiceCenter.belongsTo.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="最后更新时间">{ moment(retailStoreCityServiceCenter.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(retailStoreCityServiceCenter,targetComponent)}
      </DescriptionList>
	)

}


class RetailStoreCityServiceCenterDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'retailStoreCityServiceCenter'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, cityPartnerListMetaInfo, potentialCustomerListMetaInfo, cityEventListMetaInfo, retailStoreListMetaInfo, cityPartnerCount, potentialCustomerCount, cityEventCount, retailStoreCount } = this.props.retailStoreCityServiceCenter
    if(!this.props.retailStoreCityServiceCenter.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"双链小超城市服务中心",cardsFor: "retailStoreCityServiceCenter",
    	cardsSource: this.props.retailStoreCityServiceCenter,returnURL,displayName,
  		subItems: [
{name: 'cityPartnerList', displayName:'城市合伙人',type:'cityPartner',count:cityPartnerCount,addFunction: true, role: 'cityPartner', metaInfo: cityPartnerListMetaInfo},
{name: 'potentialCustomerList', displayName:'潜在的客户',type:'potentialCustomer',count:potentialCustomerCount,addFunction: true, role: 'potentialCustomer', metaInfo: potentialCustomerListMetaInfo},
{name: 'cityEventList', displayName:'城市活动',type:'cityEvent',count:cityEventCount,addFunction: true, role: 'cityEvent', metaInfo: cityEventListMetaInfo},
{name: 'retailStoreList', displayName:'双链小超',type:'retailStore',count:retailStoreCount,addFunction: true, role: 'retailStore', metaInfo: retailStoreListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
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
  retailStoreCityServiceCenter: state._retailStoreCityServiceCenter,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(RetailStoreCityServiceCenterDashboard))

