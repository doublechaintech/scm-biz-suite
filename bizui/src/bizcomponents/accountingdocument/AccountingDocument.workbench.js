

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
import styles from './AccountingDocument.workbench.less'
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


const imageList =(accountingDocument)=>{return [
	 ]}

const internalImageListOf = (accountingDocument) =>defaultImageListOf(accountingDocument,imageList)

const optionList =(accountingDocument)=>{return [
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (accountingDocument) =>defaultSettingListOf(accountingDocument, optionList)
const internalLargeTextOf = (accountingDocument) =>{

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
      <Link to={`/accountingDocument/${targetComponent.props.accountingDocument.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/accountingDocument/${targetComponent.props.accountingDocument.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
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
	const accountingDocument = cardsData.cardsSource
	const {AccountingDocumentService} = GlobalComponents
	const userContext = null
	return (
	<div>
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID" style={{wordBreak: 'break-all'}}>{accountingDocument.id}</Description> 
<Description term="名称" style={{wordBreak: 'break-all'}}>{accountingDocument.name}</Description> 
<Description term="会计凭证日期">{ moment(accountingDocument.accountingDocumentDate).format('YYYY-MM-DD')}</Description> 
<Description term="会计期间">{accountingDocument.accountingPeriod==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocument.accountingPeriod.displayName}(${accountingDocument.accountingPeriod.id})`}
</Description>
<Description term="文档类型">{accountingDocument.documentType==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocument.documentType.displayName}(${accountingDocument.documentType.id})`}
</Description>

      
      </DescriptionList>

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

class AccountingDocumentWorkbench extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
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
    const returnURL = this.props.returnURL

    const cardsData = {cardsName:window.trans('accounting_document'),cardsFor: "accountingDocument",
    	cardsSource: this.props.accountingDocument,returnURL,displayName,
  		subItems: [
{name: 'originalVoucherList', displayName: window.mtrans('original_voucher','accounting_document.original_voucher_list',false) ,viewGroup:'__no_group', type:'originalVoucher',count:originalVoucherCount,addFunction: true, role: 'originalVoucher', metaInfo: originalVoucherListMetaInfo, renderItem: GlobalComponents.OriginalVoucherBase.renderItemOfList},
{name: 'accountingDocumentLineList', displayName: window.mtrans('accounting_document_line','accounting_document.accounting_document_line_list',false) ,viewGroup:'__no_group', type:'accountingDocumentLine',count:accountingDocumentLineCount,addFunction: true, role: 'accountingDocumentLine', metaInfo: accountingDocumentLineListMetaInfo, renderItem: GlobalComponents.AccountingDocumentLineBase.renderItemOfList},

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
        content={summaryOf(cardsData,this)}
        wrapperClassName={styles.advancedForm}
      >

      
       
     <Col span={18} style={{marginRight:"20px", backgroundColor: "white"}}>
      {quickFunctions(cardsData)}

      {largeTextOf(cardsData.cardsSource)}
      {renderSubjectList(cardsData)} 
      {renderExtraFooter(cardsData.cardsSource)}
	   </Col>
      <Col span={5}>

			{imageListOf(cardsData.cardsSource)}
			{settingListOf(cardsData.cardsSource)}
		</Col>
		 
      </PageHeaderLayout>

    )
  }
}

export default connect(state => ({
  accountingDocument: state._accountingDocument,
  returnURL: state.breadcrumb.returnURL,

}))(Form.create()(AccountingDocumentWorkbench))

