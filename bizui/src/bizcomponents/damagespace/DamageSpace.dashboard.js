

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
import styles from './DamageSpace.dashboard.less'
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


const imageList =(damageSpace)=>{return [
	 ]}

const internalImageListOf = (damageSpace) =>defaultImageListOf(damageSpace,imageList)

const optionList =(damageSpace)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (damageSpace) =>defaultSettingListOf(damageSpace, optionList)
const internalLargeTextOf = (damageSpace) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (damageSpace,targetComponent) =>{
	
	
	const {DamageSpaceService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{damageSpace.id}</Description> 
<Description term="Location">{damageSpace.location}</Description> 
<Description term="Contact Number">{damageSpace.contactNumber}</Description> 
<Description term="Total Area">{damageSpace.totalArea}</Description> 
<Description term="Latitude">{damageSpace.latitude}</Description> 
<Description term="Longitude">{damageSpace.longitude}</Description> 
<Description term="Warehouse">{damageSpace.warehouse==null?appLocaleName(userContext,"NotAssigned"):`${damageSpace.warehouse.displayName}(${damageSpace.warehouse.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Warehouse","warehouse",DamageSpaceService.requestCandidateWarehouse,
	      DamageSpaceService.transferToAnotherWarehouse,"anotherWarehouseId",damageSpace.warehouse?damageSpace.warehouse.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Last Update Time">{ moment(damageSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(damageSpace,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class DamageSpaceDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'damageSpace'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, goodsShelfListMetaInfo, goodsShelfCount } = this.props.damageSpace
    if(!this.props.damageSpace.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Damage Space",cardsFor: "damageSpace",
    	cardsSource: this.props.damageSpace,returnURL,displayName,
  		subItems: [
{name: 'goodsShelfList', displayName:'Goods Shelf',type:'goodsShelf',count:goodsShelfCount,addFunction: true, role: 'goodsShelf', metaInfo: goodsShelfListMetaInfo, renderItem: GlobalComponents.GoodsShelfBase.renderItemOfList},
    
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
        {quickFunctions(cardsData)} 
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}  
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
    )
  }
}

export default connect(state => ({
  damageSpace: state._damageSpace,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(DamageSpaceDashboard))

