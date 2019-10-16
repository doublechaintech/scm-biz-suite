

import React, { Component } from 'react'
<<<<<<< HEAD
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
=======
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD

=======
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
<<<<<<< HEAD
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
=======
  defaultSubListsOf,defaultRenderAnalytics,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,
  defaultQuickFunctions, defaultRenderSubjectList,
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
=======
const internalRenderSubjectList = defaultRenderSubjectList
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
const internalSettingListOf = (warehouse) =>defaultSettingListOf(warehouse, optionList)
const internalLargeTextOf = (warehouse) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


<<<<<<< HEAD
const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)
=======
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
      <Link to={`/warehouse/${targetComponent.props.warehouse.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/warehouse/${targetComponent.props.warehouse.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

}


const internalSummaryOf = (warehouse,targetComponent) =>{
	
	
	const {WarehouseService} = GlobalComponents
<<<<<<< HEAD
	
=======
	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{warehouse.id}</Description> 
<Description term="位置">{warehouse.location}</Description> 
<Description term="联系电话">{warehouse.contactNumber}</Description> 
<Description term="总面积">{warehouse.totalArea}</Description> 
<Description term="纬度">{warehouse.latitude}</Description> 
<Description term="经度">{warehouse.longitude}</Description> 
<<<<<<< HEAD
<Description term="最后更新时间">{ moment(warehouse.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
=======
<Description term="最后更新时间">{ moment(warehouse.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	
        {buildTransferModal(warehouse,targetComponent)}
      </DescriptionList>
	)

}

<<<<<<< HEAD
=======
const internalQuickFunctions = defaultQuickFunctions
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

class WarehouseDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
<<<<<<< HEAD
    targetLocalName:"城市",
=======
    targetLocalName:"",
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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
<<<<<<< HEAD
{name: 'storageSpaceList', displayName:'存货区',type:'storageSpace',count:storageSpaceCount,addFunction: true, role: 'storageSpace', metaInfo: storageSpaceListMetaInfo},
{name: 'smartPalletList', displayName:'智能托盘',type:'smartPallet',count:smartPalletCount,addFunction: true, role: 'smartPallet', metaInfo: smartPalletListMetaInfo},
{name: 'supplierSpaceList', displayName:'供应商的空间',type:'supplierSpace',count:supplierSpaceCount,addFunction: true, role: 'supplierSpace', metaInfo: supplierSpaceListMetaInfo},
{name: 'receivingSpaceList', displayName:'收货区',type:'receivingSpace',count:receivingSpaceCount,addFunction: true, role: 'receivingSpace', metaInfo: receivingSpaceListMetaInfo},
{name: 'shippingSpaceList', displayName:'发货区',type:'shippingSpace',count:shippingSpaceCount,addFunction: true, role: 'shippingSpace', metaInfo: shippingSpaceListMetaInfo},
{name: 'damageSpaceList', displayName:'残次货物存放区',type:'damageSpace',count:damageSpaceCount,addFunction: true, role: 'damageSpace', metaInfo: damageSpaceListMetaInfo},
{name: 'warehouseAssetList', displayName:'仓库资产',type:'warehouseAsset',count:warehouseAssetCount,addFunction: true, role: 'warehouseAsset', metaInfo: warehouseAssetListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
=======
{name: 'storageSpaceList', displayName:'存货区',type:'storageSpace',count:storageSpaceCount,addFunction: true, role: 'storageSpace', metaInfo: storageSpaceListMetaInfo, renderItem: GlobalComponents.StorageSpaceBase.renderItemOfList},
{name: 'smartPalletList', displayName:'智能托盘',type:'smartPallet',count:smartPalletCount,addFunction: true, role: 'smartPallet', metaInfo: smartPalletListMetaInfo, renderItem: GlobalComponents.SmartPalletBase.renderItemOfList},
{name: 'supplierSpaceList', displayName:'供应商的空间',type:'supplierSpace',count:supplierSpaceCount,addFunction: true, role: 'supplierSpace', metaInfo: supplierSpaceListMetaInfo, renderItem: GlobalComponents.SupplierSpaceBase.renderItemOfList},
{name: 'receivingSpaceList', displayName:'收货区',type:'receivingSpace',count:receivingSpaceCount,addFunction: true, role: 'receivingSpace', metaInfo: receivingSpaceListMetaInfo, renderItem: GlobalComponents.ReceivingSpaceBase.renderItemOfList},
{name: 'shippingSpaceList', displayName:'发货区',type:'shippingSpace',count:shippingSpaceCount,addFunction: true, role: 'shippingSpace', metaInfo: shippingSpaceListMetaInfo, renderItem: GlobalComponents.ShippingSpaceBase.renderItemOfList},
{name: 'damageSpaceList', displayName:'残次货物存放区',type:'damageSpace',count:damageSpaceCount,addFunction: true, role: 'damageSpace', metaInfo: damageSpaceListMetaInfo, renderItem: GlobalComponents.DamageSpaceBase.renderItemOfList},
{name: 'warehouseAssetList', displayName:'仓库资产',type:'warehouseAsset',count:warehouseAssetCount,addFunction: true, role: 'warehouseAsset', metaInfo: warehouseAssetListMetaInfo, renderItem: GlobalComponents.WarehouseAssetBase.renderItemOfList},
    
      	],
   		subSettingItems: [
    
      	],     	
      	
  	};
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
<<<<<<< HEAD
=======
    const renderAnalytics = this.props.renderAnalytics || defaultRenderAnalytics
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
<<<<<<< HEAD
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
=======
       
        {renderExtraHeader(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}  
        {quickFunctions(cardsData)} 
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    )
  }
}

export default connect(state => ({
  warehouse: state._warehouse,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(WarehouseDashboard))

