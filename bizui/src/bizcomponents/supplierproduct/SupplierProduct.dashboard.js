

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
import styles from './SupplierProduct.dashboard.less'
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


const imageList =(supplierProduct)=>{return [
	 ]}

const internalImageListOf = (supplierProduct) =>defaultImageListOf(supplierProduct,imageList)

const optionList =(supplierProduct)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (supplierProduct) =>defaultSettingListOf(supplierProduct, optionList)
const internalLargeTextOf = (supplierProduct) =>{

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
      <Link to={`/supplierProduct/${targetComponent.props.supplierProduct.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/supplierProduct/${targetComponent.props.supplierProduct.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (supplierProduct,targetComponent) =>{
	
	
	const {SupplierProductService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<<<<<<< HEAD
<Description term="序号">{supplierProduct.id}</Description> 
<Description term="品名">{supplierProduct.productName}</Description> 
<Description term="产品描述">{supplierProduct.productDescription}</Description> 
<Description term="产品单元">{supplierProduct.productUnit}</Description> 
=======
<Description term="序号" style={{wordBreak: 'break-all'}}>{supplierProduct.id}</Description> 
<Description term="品名" style={{wordBreak: 'break-all'}}>{supplierProduct.productName}</Description> 
<Description term="产品描述" style={{wordBreak: 'break-all'}}>{supplierProduct.productDescription}</Description> 
<Description term="产品单元" style={{wordBreak: 'break-all'}}>{supplierProduct.productUnit}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
<Description term="供应商">{supplierProduct.supplier==null?appLocaleName(userContext,"NotAssigned"):`${supplierProduct.supplier.displayName}(${supplierProduct.supplier.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"供应商","goodsSupplier",SupplierProductService.requestCandidateSupplier,
	      SupplierProductService.transferToAnotherSupplier,"anotherSupplierId",supplierProduct.supplier?supplierProduct.supplier.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(supplierProduct,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class SupplierProductDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'supplierProduct'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, productSupplyDurationListMetaInfo, productSupplyDurationCount } = this.props.supplierProduct
    if(!this.props.supplierProduct.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"供应商的产品",cardsFor: "supplierProduct",
    	cardsSource: this.props.supplierProduct,returnURL,displayName,
  		subItems: [
<<<<<<< HEAD
{name: 'productSupplyDurationList', displayName:'产品供应时间',type:'productSupplyDuration',count:productSupplyDurationCount,addFunction: true, role: 'productSupplyDuration', metaInfo: productSupplyDurationListMetaInfo, renderItem: GlobalComponents.ProductSupplyDurationBase.renderItemOfList},
=======
{name: 'productSupplyDurationList', displayName:'产品供应时间',viewGroup:'__no_group', type:'productSupplyDuration',count:productSupplyDurationCount,addFunction: true, role: 'productSupplyDuration', metaInfo: productSupplyDurationListMetaInfo, renderItem: GlobalComponents.ProductSupplyDurationBase.renderItemOfList},
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
  supplierProduct: state._supplierProduct,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(SupplierProductDashboard))

