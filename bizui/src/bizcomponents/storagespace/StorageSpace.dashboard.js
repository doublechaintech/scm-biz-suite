

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
import styles from './StorageSpace.dashboard.less'
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


const imageList =(storageSpace)=>{return [
	 ]}

const internalImageListOf = (storageSpace) =>defaultImageListOf(storageSpace,imageList)

const optionList =(storageSpace)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (storageSpace) =>defaultSettingListOf(storageSpace, optionList)
const internalLargeTextOf = (storageSpace) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (storageSpace,targetComponent) =>{
	
	
	const {StorageSpaceService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{storageSpace.id}</Description> 
<Description term="Location">{storageSpace.location}</Description> 
<Description term="Contact Number">{storageSpace.contactNumber}</Description> 
<Description term="Total Area">{storageSpace.totalArea}</Description> 
<Description term="Warehouse">{storageSpace.warehouse==null?appLocaleName(userContext,"NotAssigned"):`${storageSpace.warehouse.displayName}(${storageSpace.warehouse.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Warehouse","warehouse",StorageSpaceService.requestCandidateWarehouse,
	      StorageSpaceService.transferToAnotherWarehouse,"anotherWarehouseId",storageSpace.warehouse?storageSpace.warehouse.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Latitude">{storageSpace.latitude}</Description> 
<Description term="Longitude">{storageSpace.longitude}</Description> 
<Description term="Last Update Time">{ moment(storageSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(storageSpace,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class StorageSpaceDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'storageSpace'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, goodsShelfListMetaInfo, goodsShelfCount } = this.props.storageSpace
    if(!this.props.storageSpace.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Storage Space",cardsFor: "storageSpace",
    	cardsSource: this.props.storageSpace,returnURL,displayName,
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
  storageSpace: state._storageSpace,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(StorageSpaceDashboard))

