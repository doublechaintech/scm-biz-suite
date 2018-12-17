

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
import styles from './AccountingDocument.dashboard.less'
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


const imageList =(accountingDocument)=>{return [
	 ]}

const internalImageListOf = (accountingDocument) =>defaultImageListOf(accountingDocument,imageList)

const optionList =(accountingDocument)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (accountingDocument) =>defaultSettingListOf(accountingDocument, optionList)
const internalLargeTextOf = (accountingDocument) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (accountingDocument,targetComponent) =>{
	
	
	const {AccountingDocumentService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{accountingDocument.id}</Description> 
<Description term="名称">{accountingDocument.name}</Description> 
<Description term="会计凭证日期">{ moment(accountingDocument.accountingDocumentDate).format('YYYY-MM-DD')}</Description> 
<Description term="会计期间">{accountingDocument.accountingPeriod==null?"未分配":accountingDocument.accountingPeriod.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"会计期间","accountingPeriod",AccountingDocumentService.requestCandidateAccountingPeriod,
	      AccountingDocumentService.transferToAnotherAccountingPeriod,"anotherAccountingPeriodId",accountingDocument.accountingPeriod?accountingDocument.accountingPeriod.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="文档类型">{accountingDocument.documentType==null?"未分配":accountingDocument.documentType.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"文档类型","accountingDocumentType",AccountingDocumentService.requestCandidateDocumentType,
	      AccountingDocumentService.transferToAnotherDocumentType,"anotherDocumentTypeId",accountingDocument.documentType?accountingDocument.documentType.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="当前状态">{accountingDocument.currentStatus}</Description> 
	
        {buildTransferModal(accountingDocument,targetComponent)}
      </DescriptionList>
	)

}


class AccountingDocumentDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'accountingDocument'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, originalVoucherListMetaInfo, accountingDocumentLineListMetaInfo, originalVoucherCount, accountingDocumentLineCount } = this.props.accountingDocument
    if(!this.props.accountingDocument.class){
      return null
    }
    const cardsData = {cardsName:"会计凭证",cardsFor: "accountingDocument",cardsSource: this.props.accountingDocument,
  		subItems: [
{name: 'originalVoucherList', displayName:'原始凭证',type:'originalVoucher',count:originalVoucherCount,addFunction: true, role: 'originalVoucher', metaInfo: originalVoucherListMetaInfo},
{name: 'accountingDocumentLineList', displayName:'会计凭证行',type:'accountingDocumentLine',count:accountingDocumentLineCount,addFunction: true, role: 'accountingDocumentLine', metaInfo: accountingDocumentLineListMetaInfo},
    
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
  accountingDocument: state._accountingDocument,
}))(Form.create()(AccountingDocumentDashboard))

