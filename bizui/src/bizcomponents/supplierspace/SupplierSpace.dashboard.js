

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
import styles from './SupplierSpace.dashboard.less'
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


const imageList =(supplierSpace)=>{return [
	 ]}

const internalImageListOf = (supplierSpace) =>defaultImageListOf(supplierSpace,imageList)

const optionList =(supplierSpace)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (supplierSpace) =>defaultSettingListOf(supplierSpace, optionList)
const internalLargeTextOf = (supplierSpace) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (supplierSpace,targetComponent) =>{
	
	
	const {SupplierSpaceService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{supplierSpace.id}</Description> 
<Description term="位置">{supplierSpace.location}</Description> 
<Description term="联系电话">{supplierSpace.contactNumber}</Description> 
<Description term="总面积">{supplierSpace.totalArea}</Description> 
<Description term="仓库">{supplierSpace.warehouse==null?"未分配":supplierSpace.warehouse.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"仓库","warehouse",SupplierSpaceService.requestCandidateWarehouse,
	      SupplierSpaceService.transferToAnotherWarehouse,"anotherWarehouseId",supplierSpace.warehouse?supplierSpace.warehouse.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="纬度">{supplierSpace.latitude}</Description> 
<Description term="经度">{supplierSpace.longitude}</Description> 
	
        {buildTransferModal(supplierSpace,targetComponent)}
      </DescriptionList>
	)

}


class SupplierSpaceDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'supplierSpace'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, goodsShelfListMetaInfo, goodsShelfCount } = this.props.supplierSpace
    if(!this.props.supplierSpace.class){
      return null
    }
    const cardsData = {cardsName:"供应商的空间",cardsFor: "supplierSpace",cardsSource: this.props.supplierSpace,
  		subItems: [
{name: 'goodsShelfList', displayName:'货架',type:'goodsShelf',count:goodsShelfCount,addFunction: true, role: 'goodsShelf', metaInfo: goodsShelfListMetaInfo},
    
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
  supplierSpace: state._supplierSpace,
}))(Form.create()(SupplierSpaceDashboard))

