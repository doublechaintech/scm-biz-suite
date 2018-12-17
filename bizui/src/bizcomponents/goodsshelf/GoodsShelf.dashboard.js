

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
import styles from './GoodsShelf.dashboard.less'
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


const imageList =(goodsShelf)=>{return [
	 ]}

const internalImageListOf = (goodsShelf) =>defaultImageListOf(goodsShelf,imageList)

const optionList =(goodsShelf)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (goodsShelf) =>defaultSettingListOf(goodsShelf, optionList)
const internalLargeTextOf = (goodsShelf) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (goodsShelf,targetComponent) =>{
	
	
	const {GoodsShelfService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{goodsShelf.id}</Description> 
<Description term="位置">{goodsShelf.location}</Description> 
<Description term="存货区">{goodsShelf.storageSpace==null?"未分配":goodsShelf.storageSpace.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"存货区","storageSpace",GoodsShelfService.requestCandidateStorageSpace,
	      GoodsShelfService.transferToAnotherStorageSpace,"anotherStorageSpaceId",goodsShelf.storageSpace?goodsShelf.storageSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="供应商的空间">{goodsShelf.supplierSpace==null?"未分配":goodsShelf.supplierSpace.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"供应商的空间","supplierSpace",GoodsShelfService.requestCandidateSupplierSpace,
	      GoodsShelfService.transferToAnotherSupplierSpace,"anotherSupplierSpaceId",goodsShelf.supplierSpace?goodsShelf.supplierSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="残次货物存放区">{goodsShelf.damageSpace==null?"未分配":goodsShelf.damageSpace.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"残次货物存放区","damageSpace",GoodsShelfService.requestCandidateDamageSpace,
	      GoodsShelfService.transferToAnotherDamageSpace,"anotherDamageSpaceId",goodsShelf.damageSpace?goodsShelf.damageSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(goodsShelf,targetComponent)}
      </DescriptionList>
	)

}


class GoodsShelfDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
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
    const cardsData = {cardsName:"货架",cardsFor: "goodsShelf",cardsSource: this.props.goodsShelf,
  		subItems: [
{name: 'goodsShelfStockCountList', displayName:'货架库存盘点',type:'goodsShelfStockCount',count:goodsShelfStockCountCount,addFunction: true, role: 'goodsShelfStockCount', metaInfo: goodsShelfStockCountListMetaInfo},
{name: 'goodsAllocationList', displayName:'货位',type:'goodsAllocation',count:goodsAllocationCount,addFunction: true, role: 'goodsAllocation', metaInfo: goodsAllocationListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
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
  goodsShelf: state._goodsShelf,
}))(Form.create()(GoodsShelfDashboard))

