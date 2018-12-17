

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
import styles from './AccountSet.dashboard.less'
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


const imageList =(accountSet)=>{return [
	 ]}

const internalImageListOf = (accountSet) =>defaultImageListOf(accountSet,imageList)

const optionList =(accountSet)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (accountSet) =>defaultSettingListOf(accountSet, optionList)
const internalLargeTextOf = (accountSet) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (accountSet,targetComponent) =>{
	
	
	const {AccountSetService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{accountSet.id}</Description> 
<Description term="名称">{accountSet.name}</Description> 
<Description term="年组">{accountSet.yearSet}</Description> 
<Description term="生效日期">{ moment(accountSet.effectiveDate).format('YYYY-MM-DD')}</Description> 
<Description term="会计制度">{accountSet.accountingSystem}</Description> 
<Description term="本币代码">{accountSet.domesticCurrencyCode}</Description> 
<Description term="本币名称">{accountSet.domesticCurrencyName}</Description> 
<Description term="开户银行">{accountSet.openingBank}</Description> 
<Description term="帐户号码">{accountSet.accountNumber}</Description> 
<Description term="双链小超">{accountSet.retailStore==null?"未分配":accountSet.retailStore.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"双链小超","retailStore",AccountSetService.requestCandidateRetailStore,
	      AccountSetService.transferToAnotherRetailStore,"anotherRetailStoreId",accountSet.retailStore?accountSet.retailStore.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="产品供应商">{accountSet.goodsSupplier==null?"未分配":accountSet.goodsSupplier.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"产品供应商","goodsSupplier",AccountSetService.requestCandidateGoodsSupplier,
	      AccountSetService.transferToAnotherGoodsSupplier,"anotherGoodsSupplierId",accountSet.goodsSupplier?accountSet.goodsSupplier.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(accountSet,targetComponent)}
      </DescriptionList>
	)

}


class AccountSetDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'accountSet'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, accountingSubjectListMetaInfo, accountingPeriodListMetaInfo, accountingDocumentTypeListMetaInfo, accountingSubjectCount, accountingPeriodCount, accountingDocumentTypeCount } = this.props.accountSet
    if(!this.props.accountSet.class){
      return null
    }
    const cardsData = {cardsName:"账套",cardsFor: "accountSet",cardsSource: this.props.accountSet,
  		subItems: [
{name: 'accountingSubjectList', displayName:'会计科目',type:'accountingSubject',count:accountingSubjectCount,addFunction: true, role: 'accountingSubject', metaInfo: accountingSubjectListMetaInfo},
{name: 'accountingPeriodList', displayName:'会计期间',type:'accountingPeriod',count:accountingPeriodCount,addFunction: true, role: 'accountingPeriod', metaInfo: accountingPeriodListMetaInfo},
{name: 'accountingDocumentTypeList', displayName:'会计凭证类型',type:'accountingDocumentType',count:accountingDocumentTypeCount,addFunction: true, role: 'accountingDocumentType', metaInfo: accountingDocumentTypeListMetaInfo},
    
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
  accountSet: state._accountSet,
}))(Form.create()(AccountSetDashboard))

