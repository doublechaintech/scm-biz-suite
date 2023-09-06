

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
import styles from './Goods.dashboard.less'
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


const imageList =(goods)=>{return [
	 ]}

const internalImageListOf = (goods) =>defaultImageListOf(goods,imageList)

const optionList =(goods)=>{return [
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (goods) =>defaultSettingListOf(goods, optionList)
const internalLargeTextOf = (goods) =>{

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
      <Link to={`/goods/${targetComponent.props.goods.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/goods/${targetComponent.props.goods.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
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
	const goods = cardsData.cardsSource
	const {GoodsService} = GlobalComponents
	const userContext = null
	return (
	<div>
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID" style={{wordBreak: 'break-all'}}>{goods.id}</Description> 
<Description term="名称" style={{wordBreak: 'break-all'}}>{goods.name}</Description> 
<Description term="RFID" style={{wordBreak: 'break-all'}}>{goods.rfid}</Description> 
<Description term="计量单位" style={{wordBreak: 'break-all'}}>{goods.uom}</Description> 
<Description term="最大包装" style={{wordBreak: 'break-all'}}>{goods.maxPackage}</Description> 
<Description term="到期时间">{ moment(goods.expireTime).format('YYYY-MM-DD')}</Description> 
<Description term="SKU">{goods.sku==null?appLocaleName(userContext,"NotAssigned"):`${goods.sku.displayName}(${goods.sku.id})`}
</Description>
<Description term="收货区">{goods.receivingSpace==null?appLocaleName(userContext,"NotAssigned"):`${goods.receivingSpace.displayName}(${goods.receivingSpace.id})`}
</Description>
<Description term="货位">{goods.goodsAllocation==null?appLocaleName(userContext,"NotAssigned"):`${goods.goodsAllocation.displayName}(${goods.goodsAllocation.id})`}
</Description>
<Description term="智能托盘">{goods.smartPallet==null?appLocaleName(userContext,"NotAssigned"):`${goods.smartPallet.displayName}(${goods.smartPallet.id})`}
</Description>
<Description term="发货区">{goods.shippingSpace==null?appLocaleName(userContext,"NotAssigned"):`${goods.shippingSpace.displayName}(${goods.shippingSpace.id})`}
</Description>
<Description term="运输任务">{goods.transportTask==null?appLocaleName(userContext,"NotAssigned"):`${goods.transportTask.displayName}(${goods.transportTask.id})`}
</Description>
<Description term="双链小超">{goods.retailStore==null?appLocaleName(userContext,"NotAssigned"):`${goods.retailStore.displayName}(${goods.retailStore.id})`}
</Description>
<Description term="订单">{goods.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${goods.bizOrder.displayName}(${goods.bizOrder.id})`}
</Description>
<Description term="生超的订单">{goods.retailStoreOrder==null?appLocaleName(userContext,"NotAssigned"):`${goods.retailStoreOrder.displayName}(${goods.retailStoreOrder.id})`}
</Description>

       
      </DescriptionList>
      <div>{quickFunctions(cardsData)}</div>
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

class GoodsDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",
    defaultType: 'goods'


  }
  componentDidMount() {

  }


  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, goodsMovementListMetaInfo, goodsMovementCount } = this.props.goods
    if(!this.props.goods.class){
      return null
    }
    const returnURL = this.props.returnURL

    const cardsData = {cardsName:window.trans('goods'),cardsFor: "goods",
    	cardsSource: this.props.goods,returnURL,displayName,
  		subItems: [
{name: 'goodsMovementList', displayName: window.mtrans('goods_movement','goods.goods_movement_list',false) ,viewGroup:'__no_group', type:'goodsMovement',count:goodsMovementCount,addFunction: true, role: 'goodsMovement', metaInfo: goodsMovementListMetaInfo, renderItem: GlobalComponents.GoodsMovementBase.renderItemOfList},

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
        wrapperClassName={styles.advancedForm}
      >


       
     <Col span={24} style={{marginRight:"20px", backgroundColor: "white"}}>
      {renderTagCloud(cardsData)}

      {imageListOf(cardsData.cardsSource)}
      {renderAnalytics(cardsData.cardsSource)}
      {settingListOf(cardsData.cardsSource)}

	   </Col>

		 
      </PageHeaderLayout>

    )
  }
}

export default connect(state => ({
  goods: state._goods,
  returnURL: state.breadcrumb.returnURL,

}))(Form.create()(GoodsDashboard))

