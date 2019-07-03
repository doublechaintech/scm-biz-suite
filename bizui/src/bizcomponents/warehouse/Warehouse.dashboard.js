

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
import styles from './Warehouse.dashboard.less'
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


const imageList =(warehouse)=>{return [
	 ]}

const internalImageListOf = (warehouse) =>defaultImageListOf(warehouse,imageList)

const optionList =(warehouse)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (warehouse) =>defaultSettingListOf(warehouse, optionList)
const internalLargeTextOf = (warehouse) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (warehouse,targetComponent) =>{
	
	
	const {WarehouseService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{warehouse.id}</Description> 
<Description term="位置">{warehouse.location}</Description> 
<Description term="联系电话">{warehouse.contactNumber}</Description> 
<Description term="总面积">{warehouse.totalArea}</Description> 
<Description term="纬度">{warehouse.latitude}</Description> 
<Description term="经度">{warehouse.longitude}</Description> 
<Description term="最后更新时间">{ moment(warehouse.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(warehouse,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class WarehouseDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'warehouse'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, storageSpaceListMetaInfo, smartPalletListMetaInfo, supplierSpaceListMetaInfo, receivingSpaceListMetaInfo, shippingSpaceListMetaInfo, damageSpaceListMetaInfo, warehouseAssetListMetaInfo, storageSpaceCount, smartPalletCount, supplierSpaceCount, receivingSpaceCount, shippingSpaceCount, damageSpaceCount, warehouseAssetCount } = this.props.warehouse
    if(!this.props.warehouse.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"仓库",cardsFor: "warehouse",
    	cardsSource: this.props.warehouse,returnURL,displayName,
  		subItems: [
{name: 'storageSpaceList', displayName:'存货区',type:'storageSpace',count:storageSpaceCount,addFunction: true, role: 'storageSpace', metaInfo: storageSpaceListMetaInfo, renderItem: GlobalComponents.StorageSpaceBase.renderItemOfList},
{name: 'smartPalletList', displayName:'智能托盘',type:'smartPallet',count:smartPalletCount,addFunction: true, role: 'smartPallet', metaInfo: smartPalletListMetaInfo, renderItem: GlobalComponents.SmartPalletBase.renderItemOfList},
{name: 'supplierSpaceList', displayName:'供应商的空间',type:'supplierSpace',count:supplierSpaceCount,addFunction: true, role: 'supplierSpace', metaInfo: supplierSpaceListMetaInfo, renderItem: GlobalComponents.SupplierSpaceBase.renderItemOfList},
{name: 'receivingSpaceList', displayName:'收货区',type:'receivingSpace',count:receivingSpaceCount,addFunction: true, role: 'receivingSpace', metaInfo: receivingSpaceListMetaInfo, renderItem: GlobalComponents.ReceivingSpaceBase.renderItemOfList},
{name: 'shippingSpaceList', displayName:'发货区',type:'shippingSpace',count:shippingSpaceCount,addFunction: true, role: 'shippingSpace', metaInfo: shippingSpaceListMetaInfo, renderItem: GlobalComponents.ShippingSpaceBase.renderItemOfList},
{name: 'damageSpaceList', displayName:'残次货物存放区',type:'damageSpace',count:damageSpaceCount,addFunction: true, role: 'damageSpace', metaInfo: damageSpaceListMetaInfo, renderItem: GlobalComponents.DamageSpaceBase.renderItemOfList},
{name: 'warehouseAssetList', displayName:'仓库资产',type:'warehouseAsset',count:warehouseAssetCount,addFunction: true, role: 'warehouseAsset', metaInfo: warehouseAssetListMetaInfo, renderItem: GlobalComponents.WarehouseAssetBase.renderItemOfList},
    
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
  warehouse: state._warehouse,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(WarehouseDashboard))

