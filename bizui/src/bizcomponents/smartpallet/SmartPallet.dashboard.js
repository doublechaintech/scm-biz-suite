

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
import styles from './SmartPallet.dashboard.less'
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


const imageList =(smartPallet)=>{return [
	 ]}

const internalImageListOf = (smartPallet) =>defaultImageListOf(smartPallet,imageList)

const optionList =(smartPallet)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (smartPallet) =>defaultSettingListOf(smartPallet, optionList)
const internalLargeTextOf = (smartPallet) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (smartPallet,targetComponent) =>{
	
	
	const {SmartPalletService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{smartPallet.id}</Description> 
<Description term="位置">{smartPallet.location}</Description> 
<Description term="联系电话">{smartPallet.contactNumber}</Description> 
<Description term="总面积">{smartPallet.totalArea}</Description> 
<Description term="纬度">{smartPallet.latitude}</Description> 
<Description term="经度">{smartPallet.longitude}</Description> 
<Description term="仓库">{smartPallet.warehouse==null?"未分配":smartPallet.warehouse.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"仓库","warehouse",SmartPalletService.requestCandidateWarehouse,
	      SmartPalletService.transferToAnotherWarehouse,"anotherWarehouseId",smartPallet.warehouse?smartPallet.warehouse.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="最后更新时间">{ moment(smartPallet.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(smartPallet,targetComponent)}
      </DescriptionList>
	)

}


class SmartPalletDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'smartPallet'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, goodsListMetaInfo, goodsCount } = this.props.smartPallet
    if(!this.props.smartPallet.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"智能托盘",cardsFor: "smartPallet",
    	cardsSource: this.props.smartPallet,returnURL,displayName,
  		subItems: [
{name: 'goodsList', displayName:'货物',type:'goods',count:goodsCount,addFunction: true, role: 'goods', metaInfo: goodsListMetaInfo},
    
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
  smartPallet: state._smartPallet,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(SmartPalletDashboard))

