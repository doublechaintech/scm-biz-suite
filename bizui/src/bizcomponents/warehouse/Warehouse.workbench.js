

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import BaseTool from '../../common/Base.tool'
import { Tag, Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {TagCloud} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Warehouse.workbench.less'
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

const {defaultFormatNumber} = BaseTool

const formatNumber = defaultFormatNumber

const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(warehouse)=>{return [
	   {"title":'合同',"imageLocation":warehouse.contract},
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

}


const internalSummaryOf = (cardsData,targetComponent) =>{

	 const quickFunctions = targetComponent.props.quickFunctions || internalQuickFunctions
	const warehouse = cardsData.cardsSource
	const {WarehouseService} = GlobalComponents
	const userContext = null
	return (
	<div>
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID" style={{wordBreak: 'break-all'}}>{warehouse.id}</Description> 
<Description term="位置" style={{wordBreak: 'break-all'}}>{warehouse.location}</Description> 
<Description term="联系电话" style={{wordBreak: 'break-all'}}>{warehouse.contactNumber}</Description> 
<Description term="总面积" style={{wordBreak: 'break-all'}}>{warehouse.totalArea}</Description> 
<Description term="纬度" style={{wordBreak: 'break-all'}}>{warehouse.latitude}</Description> 
<Description term="经度" style={{wordBreak: 'break-all'}}>{warehouse.longitude}</Description> 
<Description term="更新于">{ moment(warehouse.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 

      
      </DescriptionList>

      </div>
	)

}


const renderTagCloud=(cardsData)=>{


  if(cardsData.subItems.length<10){
    return null
  }

  const tagValue = cardsData.subItems.map(item=>({name:item.displayName, value: item.count}))

  return <div >
      <div style={{verticalAlign:"middle",textAlign:"center",backgroundColor:"rgba(0, 0, 0, 0.65)",color:"white",fontWeight:"bold",height:"40px"}}>
       <span style={{display:"inline-block",marginTop:"10px"}}>{`${cardsData.displayName}画像`}</span>
      </div>
      <TagCloud data={tagValue} height={200} style={{backgroundColor:"white"}}/>
    </div>


}


const internalQuickFunctions = defaultQuickFunctions

class WarehouseWorkbench extends Component {

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

    const cardsData = {cardsName:window.trans('warehouse'),cardsFor: "warehouse",
    	cardsSource: this.props.warehouse,returnURL,displayName,
  		subItems: [
{name: 'storageSpaceList', displayName: window.mtrans('storage_space','warehouse.storage_space_list',false) ,viewGroup:'__no_group', type:'storageSpace',count:storageSpaceCount,addFunction: true, role: 'storageSpace', metaInfo: storageSpaceListMetaInfo, renderItem: GlobalComponents.StorageSpaceBase.renderItemOfList},
{name: 'smartPalletList', displayName: window.mtrans('smart_pallet','warehouse.smart_pallet_list',false) ,viewGroup:'__no_group', type:'smartPallet',count:smartPalletCount,addFunction: true, role: 'smartPallet', metaInfo: smartPalletListMetaInfo, renderItem: GlobalComponents.SmartPalletBase.renderItemOfList},
{name: 'supplierSpaceList', displayName: window.mtrans('supplier_space','warehouse.supplier_space_list',false) ,viewGroup:'__no_group', type:'supplierSpace',count:supplierSpaceCount,addFunction: true, role: 'supplierSpace', metaInfo: supplierSpaceListMetaInfo, renderItem: GlobalComponents.SupplierSpaceBase.renderItemOfList},
{name: 'receivingSpaceList', displayName: window.mtrans('receiving_space','warehouse.receiving_space_list',false) ,viewGroup:'__no_group', type:'receivingSpace',count:receivingSpaceCount,addFunction: true, role: 'receivingSpace', metaInfo: receivingSpaceListMetaInfo, renderItem: GlobalComponents.ReceivingSpaceBase.renderItemOfList},
{name: 'shippingSpaceList', displayName: window.mtrans('shipping_space','warehouse.shipping_space_list',false) ,viewGroup:'__no_group', type:'shippingSpace',count:shippingSpaceCount,addFunction: true, role: 'shippingSpace', metaInfo: shippingSpaceListMetaInfo, renderItem: GlobalComponents.ShippingSpaceBase.renderItemOfList},
{name: 'damageSpaceList', displayName: window.mtrans('damage_space','warehouse.damage_space_list',false) ,viewGroup:'__no_group', type:'damageSpace',count:damageSpaceCount,addFunction: true, role: 'damageSpace', metaInfo: damageSpaceListMetaInfo, renderItem: GlobalComponents.DamageSpaceBase.renderItemOfList},
{name: 'warehouseAssetList', displayName: window.mtrans('warehouse_asset','warehouse.warehouse_asset_list',false) ,viewGroup:'__no_group', type:'warehouseAsset',count:warehouseAssetCount,addFunction: true, role: 'warehouseAsset', metaInfo: warehouseAssetListMetaInfo, renderItem: GlobalComponents.WarehouseAssetBase.renderItemOfList},

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
    // {quickFunctions(cardsData)}
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData,this)}
        wrapperClassName={styles.advancedForm}
      >

      
       
     <Col span={18} style={{marginRight:"20px", backgroundColor: "white"}}>
      {quickFunctions(cardsData)}

      {largeTextOf(cardsData.cardsSource)}
      {renderSubjectList(cardsData)} 
      {renderExtraFooter(cardsData.cardsSource)}
	   </Col>
      <Col span={5}>

			{imageListOf(cardsData.cardsSource)}
			{settingListOf(cardsData.cardsSource)}
		</Col>
		 
      </PageHeaderLayout>

    )
  }
}

export default connect(state => ({
  warehouse: state._warehouse,
  returnURL: state.breadcrumb.returnURL,

}))(Form.create()(WarehouseWorkbench))

