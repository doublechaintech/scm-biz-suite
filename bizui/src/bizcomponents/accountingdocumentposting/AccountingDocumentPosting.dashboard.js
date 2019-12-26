

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
import styles from './AccountingDocumentPosting.dashboard.less'
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


const imageList =(accountingDocumentPosting)=>{return [
	 ]}

const internalImageListOf = (accountingDocumentPosting) =>defaultImageListOf(accountingDocumentPosting,imageList)

const optionList =(accountingDocumentPosting)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (accountingDocumentPosting) =>defaultSettingListOf(accountingDocumentPosting, optionList)
const internalLargeTextOf = (accountingDocumentPosting) =>{

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
      <Link to={`/accountingDocumentPosting/${targetComponent.props.accountingDocumentPosting.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/accountingDocumentPosting/${targetComponent.props.accountingDocumentPosting.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (accountingDocumentPosting,targetComponent) =>{
	
	
	const {AccountingDocumentPostingService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号" style={{wordBreak: 'break-all'}}>{accountingDocumentPosting.id}</Description> 
<Description term="谁" style={{wordBreak: 'break-all'}}>{accountingDocumentPosting.who}</Description> 
<Description term="评论" style={{wordBreak: 'break-all'}}>{accountingDocumentPosting.comments}</Description> 
<Description term="制造日期">{ moment(accountingDocumentPosting.makeDate).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(accountingDocumentPosting,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class AccountingDocumentPostingDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'accountingDocumentPosting'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, accountingDocumentListMetaInfo, accountingDocumentCount } = this.props.accountingDocumentPosting
    if(!this.props.accountingDocumentPosting.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"会计凭证过帐",cardsFor: "accountingDocumentPosting",
    	cardsSource: this.props.accountingDocumentPosting,returnURL,displayName,
  		subItems: [
<<<<<<< HEAD
{name: 'accountingDocumentList', displayName:'会计凭证',type:'accountingDocument',count:accountingDocumentCount,addFunction: true, role: 'accountingDocument', metaInfo: accountingDocumentListMetaInfo, renderItem: GlobalComponents.AccountingDocumentBase.renderItemOfList},
=======
{name: 'accountingDocumentList', displayName:'会计凭证',viewGroup:'__no_group', type:'accountingDocument',count:accountingDocumentCount,addFunction: true, role: 'accountingDocument', metaInfo: accountingDocumentListMetaInfo, renderItem: GlobalComponents.AccountingDocumentBase.renderItemOfList},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
    
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
  accountingDocumentPosting: state._accountingDocumentPosting,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(AccountingDocumentPostingDashboard))

