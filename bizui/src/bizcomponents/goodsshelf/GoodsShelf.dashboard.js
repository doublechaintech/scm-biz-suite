

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
import styles from './GoodsShelf.dashboard.less'
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


const imageList =(goodsShelf)=>{return [
	 ]}

const internalImageListOf = (goodsShelf) =>defaultImageListOf(goodsShelf,imageList)

const optionList =(goodsShelf)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (goodsShelf) =>defaultSettingListOf(goodsShelf, optionList)
const internalLargeTextOf = (goodsShelf) =>{

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
      <Link to={`/goodsShelf/${targetComponent.props.goodsShelf.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/goodsShelf/${targetComponent.props.goodsShelf.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (goodsShelf,targetComponent) =>{
	
	
	const {GoodsShelfService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号" style={{wordBreak: 'break-all'}}>{goodsShelf.id}</Description> 
<Description term="位置" style={{wordBreak: 'break-all'}}>{goodsShelf.location}</Description> 
<Description term="存货区">{goodsShelf.storageSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.storageSpace.displayName}(${goodsShelf.storageSpace.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"存货区","storageSpace",GoodsShelfService.requestCandidateStorageSpace,
	      GoodsShelfService.transferToAnotherStorageSpace,"anotherStorageSpaceId",goodsShelf.storageSpace?goodsShelf.storageSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="供应商的空间">{goodsShelf.supplierSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.supplierSpace.displayName}(${goodsShelf.supplierSpace.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"供应商的空间","supplierSpace",GoodsShelfService.requestCandidateSupplierSpace,
	      GoodsShelfService.transferToAnotherSupplierSpace,"anotherSupplierSpaceId",goodsShelf.supplierSpace?goodsShelf.supplierSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="残次货物存放区">{goodsShelf.damageSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.damageSpace.displayName}(${goodsShelf.damageSpace.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"残次货物存放区","damageSpace",GoodsShelfService.requestCandidateDamageSpace,
	      GoodsShelfService.transferToAnotherDamageSpace,"anotherDamageSpaceId",goodsShelf.damageSpace?goodsShelf.damageSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="最后更新时间">{ moment(goodsShelf.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
	
        {buildTransferModal(goodsShelf,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class GoodsShelfDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'goodsShelf'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, goodsShelfStockCountListMetaInfo, goodsAllocationListMetaInfo, goodsShelfStockCountCount, goodsAllocationCount } = this.props.goodsShelf
    if(!this.props.goodsShelf.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"货架",cardsFor: "goodsShelf",
    	cardsSource: this.props.goodsShelf,returnURL,displayName,
  		subItems: [
{name: 'goodsShelfStockCountList', displayName:'货架库存盘点',viewGroup:'__no_group', type:'goodsShelfStockCount',count:goodsShelfStockCountCount,addFunction: true, role: 'goodsShelfStockCount', metaInfo: goodsShelfStockCountListMetaInfo, renderItem: GlobalComponents.GoodsShelfStockCountBase.renderItemOfList},
{name: 'goodsAllocationList', displayName:'货位',viewGroup:'__no_group', type:'goodsAllocation',count:goodsAllocationCount,addFunction: true, role: 'goodsAllocation', metaInfo: goodsAllocationListMetaInfo, renderItem: GlobalComponents.GoodsAllocationBase.renderItemOfList},
    
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
  goodsShelf: state._goodsShelf,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(GoodsShelfDashboard))

