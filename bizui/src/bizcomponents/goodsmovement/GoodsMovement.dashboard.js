

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
import styles from './GoodsMovement.dashboard.less'
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


const imageList =(goodsMovement)=>{return [
	 ]}

const internalImageListOf = (goodsMovement) =>defaultImageListOf(goodsMovement,imageList)

const optionList =(goodsMovement)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (goodsMovement) =>defaultSettingListOf(goodsMovement, optionList)
const internalLargeTextOf = (goodsMovement) =>{

	return(<div> 
   <Card title={`用户代理`} ><pre>{goodsMovement.userAgent}</pre></Card>
</div>)

	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (goodsMovement,targetComponent) =>{
	
	
	const {GoodsMovementService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{goodsMovement.id}</Description> 
<Description term="移动时间">{ moment(goodsMovement.moveTime).format('YYYY-MM-DD')}</Description> 
<Description term="设施">{goodsMovement.facility}</Description> 
<Description term="设备ID">{goodsMovement.facilityId}</Description> 
<Description term="从IP">{goodsMovement.fromIp}</Description> 
<Description term="会话ID">{goodsMovement.sessionId}</Description> 
<Description term="纬度">{goodsMovement.latitude}</Description> 
<Description term="经度">{goodsMovement.longitude}</Description> 
<Description term="货物">{goodsMovement.goods==null?"未分配":goodsMovement.goods.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"货物","goods",GoodsMovementService.requestCandidateGoods,
	      GoodsMovementService.transferToAnotherGoods,"anotherGoodsId",goodsMovement.goods?goodsMovement.goods.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(goodsMovement,targetComponent)}
      </DescriptionList>
	)

}


class GoodsMovementDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'goodsMovement'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.goodsMovement
    if(!this.props.goodsMovement.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"货物移动",cardsFor: "goodsMovement",
    	cardsSource: this.props.goodsMovement,returnURL,displayName,
  		subItems: [
    
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
  goodsMovement: state._goodsMovement,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(GoodsMovementDashboard))

