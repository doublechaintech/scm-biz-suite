

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
import styles from './AccountingDocumentLine.dashboard.less'
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


const imageList =(accountingDocumentLine)=>{return [
	 ]}

const internalImageListOf = (accountingDocumentLine) =>defaultImageListOf(accountingDocumentLine,imageList)

const optionList =(accountingDocumentLine)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (accountingDocumentLine) =>defaultSettingListOf(accountingDocumentLine, optionList)
const internalLargeTextOf = (accountingDocumentLine) =>{

	return null
	

}







const internalRenderExtraHeader = defaultRenderExtraHeader




const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf

const internalSummaryOf = (accountingDocumentLine,targetComponent) =>{
	
	
	const {AccountingDocumentLineService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{accountingDocumentLine.id}</Description> 
<Description term="名称">{accountingDocumentLine.name}</Description> 
<Description term="代码">{accountingDocumentLine.code}</Description> 
<Description term="直接">{accountingDocumentLine.direct}</Description> 
<Description term="金额">{accountingDocumentLine.amount}</Description> 
<Description term="属于">{accountingDocumentLine.belongsTo==null?"未分配":accountingDocumentLine.belongsTo.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"属于","accountingDocument",AccountingDocumentLineService.requestCandidateBelongsTo,
	      AccountingDocumentLineService.transferToAnotherBelongsTo,"anotherBelongsToId",accountingDocumentLine.belongsTo?accountingDocumentLine.belongsTo.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="会计科目">{accountingDocumentLine.accountingSubject==null?"未分配":accountingDocumentLine.accountingSubject.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"会计科目","accountingSubject",AccountingDocumentLineService.requestCandidateAccountingSubject,
	      AccountingDocumentLineService.transferToAnotherAccountingSubject,"anotherAccountingSubjectId",accountingDocumentLine.accountingSubject?accountingDocumentLine.accountingSubject.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(accountingDocumentLine,targetComponent)}
      </DescriptionList>
	)

}


class AccountingDocumentLineDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'accountingDocumentLine'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.accountingDocumentLine
    if(!this.props.accountingDocumentLine.class){
      return null
    }
    const cardsData = {cardsName:"会计凭证行",cardsFor: "accountingDocumentLine",cardsSource: this.props.accountingDocumentLine,
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
  accountingDocumentLine: state._accountingDocumentLine,
}))(Form.create()(AccountingDocumentLineDashboard))

